package servicelocator.interfaces;

import exceptions.LocatorError;

public interface Factory {
    Object create(ServiceLocator sl) throws LocatorError;
}
