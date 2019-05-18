package servicelocator2;

import exceptions.LocatorError;
import servicelocator2.interfaces.Factory;
import servicelocator2.interfaces.ServiceLocator;

import java.util.HashMap;
import java.util.Map;

public class SimpleServiceLocator implements ServiceLocator {

    private Map<Object, Factory> serviceMap = new HashMap<>();
    private Map<Object, Object> constantMap = new HashMap<>();


    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if(!serviceMap.containsKey(klass))
            serviceMap.put(klass, factory); // no ens cal fer el cast si assegurem que aixo serà de tipus t.
        else
            throw new LocatorError();
    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if(!constantMap.containsKey(klass))
            constantMap.put(klass, value);
        else
            throw new  LocatorError();
    }

    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {
        if(serviceMap.containsKey(klass))
            return (T)serviceMap.get(klass).create(this);
        else  if(constantMap.containsKey(klass))
            return (T)constantMap.get(klass);
        else
            throw new LocatorError();
    }
}
