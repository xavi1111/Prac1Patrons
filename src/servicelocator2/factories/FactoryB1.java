package servicelocator2.factories;

import implementations.ImplementationB1;
import interfaces.InterfaceB;
import interfaces.InterfaceD;
import exceptions.LocatorError;
import servicelocator2.interfaces.Factory;
import servicelocator2.interfaces.ServiceLocator;

public class FactoryB1 implements Factory<InterfaceB> {
    @Override
    public InterfaceB create(ServiceLocator sl) throws LocatorError {
        try {
            InterfaceD d = sl.getObject(InterfaceD.class);
            return new ImplementationB1(d);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
