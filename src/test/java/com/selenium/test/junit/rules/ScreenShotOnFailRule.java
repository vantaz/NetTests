package com.selenium.test.junit.rules;

import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ScreenShotOnFailRule implements TestRule {


    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                } catch (Throwable t) {
                    WebDriverFactory.takeScreenShot();
                    throw t;
                }
            }
        };
    }
}
