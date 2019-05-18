package servicelocator2.factories;

import implementations.ImplementationC1;
import interfaces.InterfaceC;
import exceptions.LocatorError;
import servicelocator2.interfaces.Factory;
import servicelocator2.interfaces.ServiceLocator;

public class FactoryC1 implements Factory<InterfaceC> {
    @Override
    public InterfaceC create(ServiceLocator sl) throws LocatorError {
        try {
            String s = sl.getObject(String.class);
            return new ImplementationC1(s);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
