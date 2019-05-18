package implementations;

import interfaces.InterfaceD;

public class ImplementationD1 implements InterfaceD {
    private int i;
    public ImplementationD1(int i){
        this.i = i;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof ImplementationD1){
            return ((ImplementationD1)o).i == this.i;
        }
        return false;

    }
}
