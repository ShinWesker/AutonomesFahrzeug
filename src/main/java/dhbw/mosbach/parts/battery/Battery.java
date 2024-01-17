package dhbw.mosbach.parts.battery;

public class Battery {
    private ACell[] cells;
    public Battery(){
        cells = new MainCell[500];

        for (int i = 0; i < cells.length; i++) {
            cells[i] = new MainCell();

            for (int j = 0; j < 100 ; j++) {
                ACell subCell = new SubCell();

                for (int k = 0; k < 5; k++) {
                    ACell cell = new Cell();
                    subCell.addUnit(cell);
                }
                cells[i].addUnit(subCell);
            }
        }
    }

    public boolean takeEnergy(int amount){
        if (amount < 0)  return true;
        for (ACell subordinate : cells) {
            if (amount == 0) return true;
            amount = subordinate.discharge(amount);
        }
        return amount == 0;
    }

    public void charge(){
        for (ACell subordinate : cells) {
            subordinate.charge();
        }
    }


}
