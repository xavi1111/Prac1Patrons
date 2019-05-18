package servicelocator;

import interfaces.InterfaceD;
import implementations.ImplementationB1;

public class FactoryB1 implements Factory {
    @Override
    public ImplementationB1 create(ServiceLocator sl) throws LocatorError {
        try {
            InterfaceD d = (InterfaceD) sl.getObject("D");
            return new ImplementationB1(d);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
