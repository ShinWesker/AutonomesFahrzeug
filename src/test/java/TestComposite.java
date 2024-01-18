import dhbw.mosbach.parts.battery.ACell;
import dhbw.mosbach.parts.battery.Cell;
import dhbw.mosbach.parts.battery.MainCell;
import dhbw.mosbach.parts.battery.SubCell;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestComposite {

    @Test
    public void testHierarchyNoEnergy(){
        ACell main = new MainCell();
        ACell sub = new SubCell();
        ACell cell = new Cell();
        sub.addUnit(cell);
        main.addUnit(sub);
        main.charge();

        assertEquals(0, main.discharge(1));
    }

    @Test
    public void testHierarchyDischargeOne(){
        ACell main = new MainCell();
        ACell sub = new SubCell();
        ACell cell = new Cell();
        sub.addUnit(cell);
        main.addUnit(sub);

        assertEquals(1, main.discharge(1));
    }

    @Test
    public void testHierarchyMethodCalls(){
        ACell main = new MainCell();
        ACell sub1 = new SubCell();
        ACell sub2 = new SubCell();
        ACell[] cell1 = new Cell[]{mock(Cell.class),mock(Cell.class),mock(Cell.class),mock(Cell.class)};
        ACell[] cell2 = new Cell[]{mock(Cell.class),mock(Cell.class),mock(Cell.class),mock(Cell.class)};

        for (ACell cell : cell1) {
            sub1.addUnit(cell);
            doCallRealMethod().when(cell).discharge(Mockito.anyInt());

        }

        for (ACell cell : cell2) {
            sub2.addUnit(cell);
            doCallRealMethod().when(cell).discharge(Mockito.anyInt());
        }


        main.addUnit(sub1);
        main.addUnit(sub2);

        main.discharge(1);

        for (ACell cell : cell1) {
            verify(cell).discharge(1);
        }
    }

    @Test
    public void testHierarchyMethodCallsSub(){
        ACell main = new MainCell();
        ACell[] sub = new SubCell[]{mock(SubCell.class),mock(SubCell.class),mock(SubCell.class)};

        for (ACell cell : sub) {
            main.addUnit(cell);
            doCallRealMethod().when(cell).discharge(Mockito.anyInt());
        }

        main.discharge(1);

        for (ACell cell : sub) {
            verify(cell).discharge(1);
        }
    }



}
