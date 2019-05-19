package simpleservicelocatortest;

import exceptions.LocatorError;
import interfaces.InterfaceA;
import interfaces.InterfaceB;
import interfaces.InterfaceC;
import interfaces.InterfaceD;
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
        ssl.setService(InterfaceA.class,  factoryA1);
        ssl.setService(InterfaceB.class, factoryB1);
        ssl.setService(InterfaceC.class, factoryC1);
        ssl.setService(InterfaceD.class, factoryD1);
        ssl.setConstant(Integer.class, 1);
        ssl.setConstant(String.class, "test");
        ssl2 = new SimpleServiceLocator();
        ssl2.setService(InterfaceA.class, factoryA1);
        ssl2.setService(InterfaceB.class, factoryB1);
        ssl2.setService(InterfaceC.class, factoryC1);
        ssl2.setService(InterfaceD.class, factoryD1);
        ssl2.setConstant(Integer.class, 10);
        ssl2.setConstant(String.class, "test2");
    }

    @Test
    void setService() throws LocatorError {
        assertEquals(ssl.getObject(InterfaceB.class), factoryB1.create(ssl));
        assertEquals(ssl.getObject(InterfaceD.class), factoryD1.create(ssl));
        assertThrows(LocatorError.class, () -> ssl.setService(InterfaceA.class, factoryA1));
    }

    @Test
    void setConstant() throws LocatorError {
        assertEquals(ssl.getObject(Integer.class), 1);
        assertThrows(LocatorError.class, () -> ssl.setConstant(Integer.class, 1));
    }

    @Test
    void getObject() throws LocatorError {
        assertThrows(LocatorError.class, () -> ssl.getObject(Long.class));
        assertEquals(ssl.getObject(InterfaceA.class), factoryA1.create(ssl));
        assertEquals(ssl.getObject(InterfaceB.class), factoryB1.create(ssl));
        assertEquals(ssl.getObject(InterfaceC.class), factoryC1.create(ssl));
        assertEquals(ssl.getObject(InterfaceD.class), factoryD1.create(ssl));
        assertNotEquals(ssl.getObject(InterfaceA.class), ssl.getObject(InterfaceB.class));
        assertNotEquals(ssl.getObject(InterfaceA.class), ssl.getObject(InterfaceC.class));
        assertNotEquals(ssl.getObject(InterfaceA.class), ssl.getObject(InterfaceD.class));
        assertNotEquals(ssl.getObject(InterfaceB.class), ssl.getObject(InterfaceC.class));
        assertNotEquals(ssl.getObject(InterfaceB.class), ssl.getObject(InterfaceD.class));
        assertNotEquals(ssl.getObject(InterfaceC.class), ssl.getObject(InterfaceD.class));
        assertNotSame(ssl.getObject(InterfaceA.class), ssl.getObject(InterfaceA.class));
        assertNotSame(ssl.getObject(InterfaceB.class), ssl.getObject(InterfaceB.class));
        assertNotSame(ssl.getObject(InterfaceC.class), ssl.getObject(InterfaceC.class));
        assertNotSame(ssl.getObject(InterfaceD.class), ssl.getObject(InterfaceD.class));
    }


    @Test
    void getObjectDifferent() throws LocatorError {
        assertNotEquals(ssl.getObject(InterfaceA.class), ssl2.getObject(InterfaceB.class));
        assertNotEquals(ssl.getObject(InterfaceA.class), ssl2.getObject(InterfaceC.class));
        assertNotEquals(ssl.getObject(InterfaceA.class), ssl2.getObject(InterfaceD.class));
        assertNotEquals(ssl.getObject(InterfaceB.class), ssl2.getObject(InterfaceC.class));
        assertNotEquals(ssl.getObject(InterfaceB.class), ssl2.getObject(InterfaceD.class));
        assertNotEquals(ssl.getObject(InterfaceC.class), ssl2.getObject(InterfaceD.class));
        assertNotSame(ssl.getObject(InterfaceA.class), ssl2.getObject(InterfaceA.class));
        assertNotSame(ssl.getObject(InterfaceB.class), ssl2.getObject(InterfaceB.class));
        assertNotSame(ssl.getObject(InterfaceC.class), ssl2.getObject(InterfaceC.class));
        assertNotSame(ssl.getObject(InterfaceD.class), ssl2.getObject(InterfaceD.class));
    }
}