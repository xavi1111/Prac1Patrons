package servicelocator;

import java.util.HashMap;
import java.util.Map;

public class CachedServiceLocator implements ServiceLocator {
    private Map<String, Factory> serviceMap = new HashMap<>();
    private Map<String, Object> constantMap = new HashMap<>();

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if(!serviceMap.containsKey(name)){
            serviceMap.put(name, factory);
        }
        else
            throw new LocatorError();
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if(!constantMap.containsKey(name))
            constantMap.put(name, value);
        else
            throw new  LocatorError();
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        if(serviceMap.containsKey(name)) {
            constantMap.put(name,serviceMap.get(name).create(this));
            serviceMap.remove(name);
            return constantMap.get(name);
        }
        else  if(constantMap.containsKey(name))
            return constantMap.get(name);
        else
            throw new LocatorError();
    }
}
