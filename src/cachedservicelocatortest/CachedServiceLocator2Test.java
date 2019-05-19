package cachedservicelocatortest;

import exceptions.LocatorError;
import interfaces.InterfaceA;
import interfaces.InterfaceB;
import interfaces.InterfaceC;
import interfaces.InterfaceD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator2.CachedServiceLocator;
import servicelocator2.factories.FactoryA1;
import servicelocator2.factories.FactoryB1;
import servicelocator2.factories.FactoryC1;
import servicelocator2.factories.FactoryD1;

import static org.junit.jupiter.api.Assertions.*;

class CachedServiceLocator2Test {

    private CachedServiceLocator csl;
    private CachedServiceLocator csl2;

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
        csl = new CachedServiceLocator();
        csl.setService(InterfaceA.class, factoryA1);
        csl.setService(InterfaceB.class, factoryB1);
        csl.setService(InterfaceC.class, factoryC1);
        csl.setService(InterfaceD.class, factoryD1);
        csl.setConstant(Integer.class, 1);
        csl.setConstant(String.class, "test");
        csl2 = new CachedServiceLocator();
        csl2.setService(InterfaceA.class, factoryA1);
        csl2.setService(InterfaceB.class, factoryB1);
        csl2.setService(InterfaceC.class, factoryC1);
        csl2.setService(InterfaceD.class, factoryD1);
        csl2.setConstant(Integer.class, 10);
        csl2.setConstant(String.class, "test2");
    }

    @Test
    void setService() throws LocatorError {
        assertEquals(csl.getObject(InterfaceB.class), factoryB1.create(csl));
        assertEquals(csl.getObject(InterfaceD.class), factoryD1.create(csl));
        assertThrows(LocatorError.class, () -> csl.setService(InterfaceA.class, factoryA1));
    }

    @Test
    void setConstant() throws LocatorError {
        assertEquals(csl.getObject(Integer.class), 1);
        assertThrows(LocatorError.class, ()-> csl.setConstant(Integer.class, 1));
    }

    @Test
    void getObject() throws LocatorError {
        assertThrows(LocatorError.class, () -> csl.getObject(Long.class));
        assertEquals(csl.getObject(InterfaceA.class), factoryA1.create(csl));
        assertEquals(csl.getObject(InterfaceB.class), factoryB1.create(csl));
        assertEquals(csl.getObject(InterfaceC.class), factoryC1.create(csl));
        assertEquals(csl.getObject(InterfaceD.class), factoryD1.create(csl));
        assertNotEquals(csl.getObject(InterfaceA.class), csl.getObject(InterfaceB.class));
        assertNotEquals(csl.getObject(InterfaceA.class), csl.getObject(InterfaceC.class));
        assertNotEquals(csl.getObject(InterfaceA.class), csl.getObject(InterfaceD.class));
        assertNotEquals(csl.getObject(InterfaceB.class), csl.getObject(InterfaceC.class));
        assertNotEquals(csl.getObject(InterfaceB.class), csl.getObject(InterfaceD.class));
        assertNotEquals(csl.getObject(InterfaceC.class), csl.getObject(InterfaceD.class));
        assertSame(csl.getObject(InterfaceA.class), csl.getObject(InterfaceA.class));
        assertSame(csl.getObject(InterfaceB.class), csl.getObject(InterfaceB.class));
        assertSame(csl.getObject(InterfaceC.class), csl.getObject(InterfaceC.class));
        assertSame(csl.getObject(InterfaceD.class), csl.getObject(InterfaceD.class));
    }

    @Test
    void getObjectDifferent() throws LocatorError {
        assertNotEquals(csl.getObject(InterfaceA.class), csl2.getObject(InterfaceB.class));
        assertNotEquals(csl.getObject(InterfaceA.class), csl2.getObject(InterfaceC.class));
        assertNotEquals(csl.getObject(InterfaceA.class), csl2.getObject(InterfaceD.class));
        assertNotEquals(csl.getObject(InterfaceB.class), csl2.getObject(InterfaceC.class));
        assertNotEquals(csl.getObject(InterfaceB.class), csl2.getObject(InterfaceD.class));
        assertNotEquals(csl.getObject(InterfaceC.class), csl2.getObject(InterfaceD.class));
        assertNotSame(csl.getObject(InterfaceA.class), csl2.getObject(InterfaceA.class));
        assertNotSame(csl.getObject(InterfaceB.class), csl2.getObject(InterfaceB.class));
        assertNotSame(csl.getObject(InterfaceC.class), csl2.getObject(InterfaceC.class));
        assertNotSame(csl.getObject(InterfaceD.class), csl2.getObject(InterfaceD.class));
    }
}