package tests.com.pluralsight;

import java.util.Map;

import main.com.pluralsight.Constructor;
import main.com.pluralsight.IoCException;
import main.com.pluralsight.Loader;
import main.com.pluralsight.Registration;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import tests.com.mantiso.Drivable;

public class LoaderTests {
    Map<Class, Registration> registrations;


    @Before
    public void beforeEach() {
        String configurationPath = "testConfigurations/config.json";
        try {
            Loader loader = new Loader();
            registrations = loader.loadConfiguration(configurationPath);

        } catch (IoCException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void shouldHaveRegistrationForSpecifiedClass() {
//        assertThat(registrations.get(Drivable.class), is(notNullValue()));
    }

    @Test
    public void shouldHaveAConstructorForSpecifiedClass() {
        Registration registration = registrations.get(Drivable.class);
//        assertThat(registration.getConstructorParams().get(0), is(notNullValue()));
    }

    @Test
    public void shouldHaveAConstructorValueForSpecifiedClass() {
        Registration registration = registrations.get(Drivable.class);
        Constructor ctor = registration.getConstructorParams().get(0);
//        assertThat(ctor.getName(), is("age"));
//        assertThat(ctor.getValue(), is(23));
    }

    @Test(expected = ClassNotFoundException.class)
    public void shouldThrowExceptionWhenLoadingClassThatDoesNotExist() throws Throwable {
        String configurationPath = "testConfigurations/invalidclassnameconfig.json";
        try {
            Loader loader = new Loader();
            registrations = loader.loadConfiguration(configurationPath);

        } catch (IoCException e) {
            throw e.getCause();
        }
    }

    @Test(expected = IoCException.class)
    public void shouldThrowAnExceptionWhenTheConfigurationIsInvalid() throws IoCException {
        Loader loader = new Loader();
        registrations = loader.loadConfiguration("invalidConfiguration.json");
    }

}
