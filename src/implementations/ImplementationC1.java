package implementations;

import interfaces.InterfaceC;

public class ImplementationC1 implements InterfaceC {
    private String s;
    public ImplementationC1(String s){
        this.s= s;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof ImplementationC1 && ((ImplementationC1)o).s == s;
    }
}
