package servicelocator2.interfaces;

import exceptions.LocatorError;

public interface Factory<T> {
    T create(ServiceLocator sl) throws LocatorError;
}
