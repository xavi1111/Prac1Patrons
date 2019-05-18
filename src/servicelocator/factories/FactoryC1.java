package servicelocator.factories;

import implementations.ImplementationC1;
import servicelocator.interfaces.Factory;
import exceptions.LocatorError;
import servicelocator.interfaces.ServiceLocator;

public class FactoryC1 implements Factory {
    @Override
    public ImplementationC1 create(ServiceLocator sl) throws LocatorError {
        try {
            String s = (String) sl.getObject("S");
            return new ImplementationC1(s);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
