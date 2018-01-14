package org.paumard.katas.minesweeper;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = {"classpath:features/"},
        glue = {"org.paumard.katas.minesweeper"}
)
public class MineSweeperTest {
}
