package implementations;

import interfaces.InterfaceA;
import interfaces.InterfaceB;
import interfaces.InterfaceC;

public class ImplementationA1 implements InterfaceA {
    private	InterfaceB	b;
    private	InterfaceC	c;
    public ImplementationA1(InterfaceB b, InterfaceC c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof ImplementationA1 && ((ImplementationA1)o).b.equals(b) && ((ImplementationA1)o).c.equals(c);
    }
}
