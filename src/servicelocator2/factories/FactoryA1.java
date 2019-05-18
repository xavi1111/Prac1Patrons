package servicelocator2.factories;

import interfaces.InterfaceA;
import interfaces.InterfaceB;
import interfaces.InterfaceC;
import implementations.ImplementationA1;
import exceptions.LocatorError;
import servicelocator2.interfaces.Factory;
import servicelocator2.interfaces.ServiceLocator;

public class FactoryA1 implements Factory<InterfaceA> {
    @Override
    public InterfaceA create(ServiceLocator sl) throws LocatorError {
        InterfaceB b = sl.getObject(InterfaceB.class);
        InterfaceC c = sl.getObject(InterfaceC.class);
        return new ImplementationA1(b, c);
    }
}
