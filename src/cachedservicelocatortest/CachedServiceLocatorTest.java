package cachedservicelocatortest;

import exceptions.LocatorError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator.CachedServiceLocator;
import servicelocator.factories.FactoryA1;
import servicelocator.factories.FactoryB1;
import servicelocator.factories.FactoryC1;
import servicelocator.factories.FactoryD1;

import static org.junit.jupiter.api.Assertions.*;

class CachedServiceLocatorTest {

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
        csl.setService("A", factoryA1);
        csl.setService("B", factoryB1);
        csl.setService("C", factoryC1);
        csl.setService("D", factoryD1);
        csl.setConstant("I", 1);
        csl.setConstant("S", "test");
        csl2 = new CachedServiceLocator();
        csl2.setService("A", factoryA1);
        csl2.setService("B", factoryB1);
        csl2.setService("C", factoryC1);
        csl2.setService("D", factoryD1);
        csl2.setConstant("I", 10);
        csl2.setConstant("S", "test2");
    }

    @Test
    void setService() throws LocatorError {
        assertEquals(csl.getObject("B"), factoryB1.create(csl));
        assertEquals(csl.getObject("D"), factoryD1.create(csl));
        assertThrows(LocatorError.class, () -> csl.setService("A", factoryA1));
    }

    @Test
    void setConstant() throws LocatorError {
        assertEquals(csl.getObject("I"), 1);
        assertThrows(LocatorError.class, ()-> csl.setConstant("I", 1));
    }

    @Test
    void getObject() throws LocatorError {
        assertThrows(LocatorError.class, ()-> csl.getObject("X"));
        assertEquals(csl.getObject("A"), factoryA1.create(csl));
        assertEquals(csl.getObject("B"), factoryB1.create(csl));
        assertEquals(csl.getObject("C"), factoryC1.create(csl));
        assertEquals(csl.getObject("D"), factoryD1.create(csl));
        assertNotEquals(csl.getObject("A"),csl.getObject("B"));
        assertNotEquals(csl.getObject("A"),csl.getObject("C"));
        assertNotEquals(csl.getObject("A"),csl.getObject("D"));
        assertNotEquals(csl.getObject("B"),csl.getObject("C"));
        assertNotEquals(csl.getObject("B"),csl.getObject("D"));
        assertNotEquals(csl.getObject("C"),csl.getObject("D"));
        assertSame(csl.getObject("A"), csl.getObject("A"));
        assertSame(csl.getObject("B"), csl.getObject("B"));
        assertSame(csl.getObject("C"), csl.getObject("C"));
        assertSame(csl.getObject("D"), csl.getObject("D"));
    }

    @Test
    void getObjectDifferent() throws LocatorError {
        assertNotEquals(csl.getObject("A"), csl2.getObject("B"));
        assertNotEquals(csl.getObject("A"), csl2.getObject("C"));
        assertNotEquals(csl.getObject("A"), csl2.getObject("D"));
        assertNotEquals(csl.getObject("B"), csl2.getObject("C"));
        assertNotEquals(csl.getObject("B"), csl2.getObject("D"));
        assertNotEquals(csl.getObject("C"), csl2.getObject("D"));
        assertNotSame(csl.getObject("A"), csl2.getObject("A"));
        assertNotSame(csl.getObject("B"), csl2.getObject("B"));
        assertNotSame(csl.getObject("C"), csl2.getObject("C"));
        assertNotSame(csl.getObject("D"), csl2.getObject("D"));
    }
}
