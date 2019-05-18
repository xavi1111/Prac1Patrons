package servicelocator2;

public class SimpleServiceLocator implements ServiceLocator {
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
