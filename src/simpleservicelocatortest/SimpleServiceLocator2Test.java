package simpleservicelocatortest;

import exceptions.LocatorError;
import implementations.ImplementationA1;
import implementations.ImplementationB1;
import implementations.ImplementationD1;
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
import servicelocator2.interfaces.Factory;

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
    void setConstant() {
    }

    @Test
    void getObject() {
    }
}