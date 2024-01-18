package dhbw.mosbach.command;

import dhbw.mosbach.cryptography.IAlgorithm;
import dhbw.mosbach.cryptography.aes.AES;
import dhbw.mosbach.cryptography.aes.Configuration;

public class Key {
    private String key;
    private ICommand command;

    public Key() {
        key = "8qXgWHag1PwTQE3biI6OFQ==";
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }

    @Override
    public String toString() {
        return this.key;
    }
}
