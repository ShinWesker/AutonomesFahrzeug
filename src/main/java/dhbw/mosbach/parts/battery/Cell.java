package dhbw.mosbach.parts.battery;

public class Cell extends ACell {
    private boolean energy = false;

    @Override
    public int discharge(int amount) {
        if (amount == 0) return 0;
        if (energy) {
            energy = false;
            return amount - 1;
        }
        return amount;
    }

    @Override
    public void charge(){
        energy = true;
    }
}
