package servicelocator2.factories;

import implementations.ImplementationD1;
import interfaces.InterfaceD;
import exceptions.LocatorError;
import servicelocator2.interfaces.Factory;
import servicelocator2.interfaces.ServiceLocator;

public class FactoryD1 implements Factory<InterfaceD> {
    @Override
    public InterfaceD create(ServiceLocator sl) throws LocatorError {
        try {
            int i = sl.getObject(Integer.class);
            return new ImplementationD1(i);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
