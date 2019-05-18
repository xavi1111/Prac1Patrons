package servicelocator.factories;

import implementations.ImplementationD1;
import servicelocator.interfaces.Factory;
import exceptions.LocatorError;
import servicelocator.interfaces.ServiceLocator;

public class FactoryD1 implements Factory {
    @Override
    public Object create(ServiceLocator sl) throws LocatorError {
        try{
            int i = (int) sl.getObject("I");
            return new ImplementationD1(i);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
