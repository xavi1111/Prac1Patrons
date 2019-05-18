package implementations;

import interfaces.InterfaceD;

public class ImplementationD1 implements InterfaceD {
    private int i;
    public ImplementationD1(int i){
        this.i = i;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof ImplementationD1 && ((ImplementationD1)o).i == i;
    }
}
