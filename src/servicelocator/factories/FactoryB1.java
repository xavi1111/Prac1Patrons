package servicelocator.factories;

import interfaces.InterfaceD;
import implementations.ImplementationB1;
import servicelocator.interfaces.Factory;
import exceptions.LocatorError;
import servicelocator.interfaces.ServiceLocator;

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
