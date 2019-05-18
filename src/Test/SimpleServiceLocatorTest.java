package Test;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.LocatorError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator.*;
import servicelocator.factories.FactoryA1;
import servicelocator.factories.FactoryB1;
import servicelocator.factories.FactoryC1;
import servicelocator.factories.FactoryD1;


class SimpleServiceLocatorTest {

    static SimpleServiceLocator prova;
    static FactoryA1 A1;
    static FactoryB1 B1;
    static FactoryC1 C1;
    static FactoryD1 D1;

    @BeforeEach
    void init() throws LocatorError {
        A1 = new FactoryA1();
        B1 = new FactoryB1();
        C1 = new FactoryC1();
        D1 = new FactoryD1();
        prova = new SimpleServiceLocator();
        prova.setService("A", A1);
        prova.setService("B", B1);
        prova.setService("C", C1);
        prova.setService("D", D1);
        prova.setConstant("I", 1);
        prova.setConstant("S", "test");
    }

    @Test
    void setService() throws LocatorError {
        assertEquals(prova.getObject("B"), B1.create(prova));
        assertEquals(prova.getObject("D"), D1.create(prova));
        assertThrows(LocatorError.class, () -> prova.setService("A", A1));
    }

    @Test
    void setConstant() throws LocatorError {
        assertEquals(prova.getObject("I"), 1);
        assertThrows(LocatorError.class, ()-> prova.setConstant("I", 1));
    }

    @Test
    void getObject() throws LocatorError {
        assertThrows(LocatorError.class, ()-> prova.getObject("X"));
        assertEquals(prova.getObject("A"), A1.create(prova));
        assertEquals(prova.getObject("B"), B1.create(prova));
        assertEquals(prova.getObject("C"), C1.create(prova));
        assertEquals(prova.getObject("D"), D1.create(prova));
        assertNotEquals(prova.getObject("A"),prova.getObject("B"));
        assertNotEquals(prova.getObject("A"),prova.getObject("C"));
        assertNotEquals(prova.getObject("A"),prova.getObject("D"));
        assertNotEquals(prova.getObject("B"),prova.getObject("C"));
        assertNotEquals(prova.getObject("B"),prova.getObject("D"));
        assertNotEquals(prova.getObject("C"),prova.getObject("D"));
        assertNotSame(prova.getObject("A"), prova.getObject("A"));
        assertNotSame(prova.getObject("B"), prova.getObject("B"));
        assertNotSame(prova.getObject("C"), prova.getObject("C"));
        assertNotSame(prova.getObject("D"), prova.getObject("D"));
    }
}