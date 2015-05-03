package tests.com.pluralsight;

import main.com.pluralsight.Container;
import main.com.pluralsight.IoCException;

import org.junit.Test;

public class ContainerInitializationTests {
    @Test(expected = IoCException.class)
    public void shouldThrowAnExceptionWhenTheConfigurationIsInvalid() throws IoCException {
        Container container = new Container("invalidConfiguration.json");
    }


}
