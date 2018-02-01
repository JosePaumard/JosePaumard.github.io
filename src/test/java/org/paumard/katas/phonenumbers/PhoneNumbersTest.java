package org.paumard.katas.phonenumbers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = {"classpath:features/"},
        glue = {"org.paumard.katas.phonenumbers"}
)
public class PhoneNumbersTest {
}
