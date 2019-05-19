package simpleservicelocatortest;

import exceptions.LocatorError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator2.SimpleServiceLocator;
import servicelocator2.factories.FactoryA1;
import servicelocator2.factories.FactoryB1;
import servicelocator2.factories.FactoryC1;
import servicelocator2.factories.FactoryD1;

import static org.junit.jupiter.api.Assertions.*;

class SimpleServiceLocator2Test {
    private SimpleServiceLocator ssl;
    private SimpleServiceLocator ssl2;
    private FactoryA1 factoryA1;
    private FactoryB1 factoryB1;
    private FactoryC1 factoryC1;
    private FactoryD1 factoryD1;

    @BeforeEach
    void init() throws LocatorError {
        factoryA1 = new FactoryA1();
        factoryB1 = new FactoryB1();
        factoryC1 = new FactoryC1();
        factoryD1 = new FactoryD1();
        ssl = new SimpleServiceLocator();
        ssl.setService(FactoryA1.class, factoryA1);
        ssl.setService(F, factoryB1);
        ssl.setService("C", factoryC1);
        ssl.setService("D", factoryD1);
        ssl.setConstant("I", 1);
        ssl.setConstant("S", "test");
        ssl2 = new SimpleServiceLocator();
        ssl2.setService("A", factoryA1);
        ssl2.setService("B", factoryB1);
        ssl2.setService("C", factoryC1);
        ssl2.setService("D", factoryD1);
        ssl2.setConstant("I", 10);
        ssl2.setConstant("S", "test2");
    }

    @Test
    void setService() throws LocatorError {
        assertEquals(ssl.getObject("B"), factoryB1.create(ssl));
        assertEquals(ssl.getObject("D"), factoryD1.create(ssl));
        assertThrows(LocatorError.class, () -> ssl.setService("A", factoryA1));
    }

    @Test
    void setConstant() {
    }

    @Test
    void getObject() {
    }
}