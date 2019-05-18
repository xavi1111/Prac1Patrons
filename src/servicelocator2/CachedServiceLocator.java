package servicelocator2;

import exceptions.LocatorError;
import servicelocator2.interfaces.Factory;
import servicelocator2.interfaces.ServiceLocator;

public class CachedServiceLocator implements ServiceLocator {
    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {

    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {

    }

    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {
        return null;
    }
}
