package servicelocator;

import Interfaces.InterfaceB;
import Interfaces.InterfaceD;

public class ImplementationB1 implements InterfaceB {
    private InterfaceD d ;
    public ImplementationB1(InterfaceD d) {
        this.d = d;
    }
}
