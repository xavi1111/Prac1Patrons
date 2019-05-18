package implementations;

import interfaces.InterfaceB;
import interfaces.InterfaceD;

public class ImplementationB1 implements InterfaceB {
    private InterfaceD d ;
    public ImplementationB1(InterfaceD d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof ImplementationB1 && ((ImplementationB1)o).d.equals(d);
    }
}
