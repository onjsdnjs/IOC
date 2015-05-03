package tests.com.pluralsight;


import main.com.pluralsight.Container;
import main.com.pluralsight.IoCException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tests.com.mantiso.Drivable;
import tests.com.mantiso.FileLogger;
import tests.com.mantiso.Logger;
import tests.com.mantiso.SingleCtorWithFixedArgItf;
import tests.com.mantiso.SingleCtorWithSingleFixedArgAndSingleReferenceArgItf;

public class ContainerTests {

    Container container;

    @Before
    public void beforeEach() {
        String configurationPath = "testConfigurations/config.json";
        try {
            container = new Container(configurationPath);
        } catch (IoCException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldLoadRegistrations() {
        String configurationPath = "testConfigurations/simpleconfig.json";
        try {
            container = new Container(configurationPath);
        } catch (IoCException e) {
            e.printStackTrace();
        }
//        assertThat(container.registrations.keySet().size(), equalTo(4));
    }

    @Test
    public void shouldCreateInstanceOfClassWithAConstructorWhichHasNoParameters() throws IoCException {
//        assertThat(container.resolve(Logger.class), is(notNullValue()));
    }

    @Test
    public void shouldCreateInstanceOfClassWithAConstructorWhichHasOneRegisteredParameter() throws IoCException {
//        assertThat(container.resolve(Drivable.class), is(notNullValue()));
    }

    @Test
    public void shouldCreateInstanceOfClassWithAConstructorWhichHasOneIntegerParameter() throws IoCException {
//        assertThat(container.resolve(SingleCtorWithFixedArgItf.class), is(notNullValue()));
    }

    @Test
    public void shouldCreateInstanceOfClassWithAConstructorWhichHasOneIntegerParameterAndOneReferenceParameter() throws IoCException {
        SingleCtorWithSingleFixedArgAndSingleReferenceArgItf itf = container.resolve(SingleCtorWithSingleFixedArgAndSingleReferenceArgItf.class);
//        assertThat(itf, is(notNullValue()));
//        assertThat(itf.getValue(), is("23"));
        Assert.assertEquals(FileLogger.class, itf.getLogger().getClass());
    }
}

