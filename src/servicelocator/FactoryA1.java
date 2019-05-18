package servicelocator;

import Interfaces.InterfaceB;
import Interfaces.InterfaceC;

public class FactoryA1 implements Factory {
    @Override
    public ImplementationA1 create(ServiceLocator sl) throws LocatorError {
        try {
            InterfaceB b = (InterfaceB) sl.getObject("B");
            InterfaceC c = (InterfaceC) sl.getObject("C");
            return new ImplementationA1(b, c);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
