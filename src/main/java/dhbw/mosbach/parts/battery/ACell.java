package dhbw.mosbach.parts.battery;

import java.util.ArrayList;
import java.util.List;

public abstract class ACell {
    protected List<ACell> subordinates;

    public ACell() {
        subordinates = new ArrayList<>();
    }
    public void addUnit(ACell administrativeUnit) {
        subordinates.add(administrativeUnit);
    }

    public int discharge(int amount){
        if (subordinates == null) return amount;

        for (ACell subordinate : subordinates) {
            if (amount == 0) return 0;
            amount = subordinate.discharge(amount);
        }
        return amount;
    }

    public void charge(){
        for (ACell subordinate : subordinates) {
            subordinate.charge();
        }
    }
}
