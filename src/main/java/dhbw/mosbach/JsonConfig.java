package dhbw.mosbach;

import dhbw.mosbach.parts.lidar.ALidar;
import dhbw.mosbach.parts.lidar.LidarNG;
import dhbw.mosbach.parts.lidar.LidarXT;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public enum JsonConfig {
    INSTANCE;

    private final String path = "configuration\\config.json";

    private String cameraPath = "components\\CameraVX\\build\\libs\\CameraVX.jar";

    public ALidar getLidar() {
        try {
            FileReader fileReader = new FileReader(path);
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            JSONObject jsonObject = new JSONObject(jsonTokener);
            fileReader.close();

            switch (jsonObject.getString("lidar_type")) {
                case "NG" -> {
                    return new LidarNG();
                }
                case "XT" -> {
                    return new LidarXT();
                }

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new LidarNG();
    }

    public Object getCamera(){
        String cameraType = "";
        try {
            FileReader fileReader = new FileReader(path);
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            JSONObject jsonObject = new JSONObject(jsonTokener);
            fileReader.close();

            cameraType = jsonObject.getString("camera_type");
            cameraPath = cameraPath.replaceAll("VX", cameraType);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if(!verifyJar(cameraPath)) throw new NullPointerException();
        return getObject(cameraPath, cameraType);

    }

    private boolean verifyJar(String path) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\Java\\jdk-21\\bin\\jarsigner", "-verify", path);
            Process process = processBuilder.start();
            process.waitFor();

            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            boolean isComponentAccepted = false;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("JAR-Datei verifiziert.")) {
                    isComponentAccepted = true;
                }
            }

            return isComponentAccepted;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Object getObject(String path, String version) {
        try {
            URL[] urls = {new File(path).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Main.class.getClassLoader());
            Class<?> clazz = Class.forName("Camera"+version, true, urlClassLoader);

            Object instance = clazz.getMethod("getInstance").invoke(null);
            return clazz.getDeclaredField("port").get(instance);

        } catch (Exception e) {
            System.out.println("--- exception");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}
