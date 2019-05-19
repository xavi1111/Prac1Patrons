package simpleservicelocatortest;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.LocatorError;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator.*;
import servicelocator.factories.FactoryA1;
import servicelocator.factories.FactoryB1;
import servicelocator.factories.FactoryC1;
import servicelocator.factories.FactoryD1;


class SimpleServiceLocatorTest {

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
        ssl.setService("A", factoryA1);
        ssl.setService("B", factoryB1);
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
    void setConstant() throws LocatorError {
        assertEquals(ssl.getObject("I"), 1);
        assertThrows(LocatorError.class, () -> ssl.setConstant("I", 1));
    }

    @Test
    void getObject() throws LocatorError {
        assertThrows(LocatorError.class, () -> ssl.getObject("X"));
        assertEquals(ssl.getObject("A"), factoryA1.create(ssl));
        assertEquals(ssl.getObject("B"), factoryB1.create(ssl));
        assertEquals(ssl.getObject("C"), factoryC1.create(ssl));
        assertEquals(ssl.getObject("D"), factoryD1.create(ssl));
        assertNotEquals(ssl.getObject("A"), ssl.getObject("B"));
        assertNotEquals(ssl.getObject("A"), ssl.getObject("C"));
        assertNotEquals(ssl.getObject("A"), ssl.getObject("D"));
        assertNotEquals(ssl.getObject("B"), ssl.getObject("C"));
        assertNotEquals(ssl.getObject("B"), ssl.getObject("D"));
        assertNotEquals(ssl.getObject("C"), ssl.getObject("D"));
        assertNotSame(ssl.getObject("A"), ssl.getObject("A"));
        assertNotSame(ssl.getObject("B"), ssl.getObject("B"));
        assertNotSame(ssl.getObject("C"), ssl.getObject("C"));
        assertNotSame(ssl.getObject("D"), ssl.getObject("D"));
    }


    @Test
    void getObjectDifferent() throws LocatorError {
        assertNotEquals(ssl.getObject("A"), ssl2.getObject("B"));
        assertNotEquals(ssl.getObject("A"), ssl2.getObject("C"));
        assertNotEquals(ssl.getObject("A"), ssl2.getObject("D"));
        assertNotEquals(ssl.getObject("B"), ssl2.getObject("C"));
        assertNotEquals(ssl.getObject("B"), ssl2.getObject("D"));
        assertNotEquals(ssl.getObject("C"), ssl2.getObject("D"));
        assertNotSame(ssl.getObject("A"), ssl2.getObject("A"));
        assertNotSame(ssl.getObject("B"), ssl2.getObject("B"));
        assertNotSame(ssl.getObject("C"), ssl2.getObject("C"));
        assertNotSame(ssl.getObject("D"), ssl2.getObject("D"));
    }
}