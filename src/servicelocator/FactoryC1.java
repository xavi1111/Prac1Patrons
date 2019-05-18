package servicelocator;

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
