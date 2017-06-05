package com.selenium.test.junit.tests.users;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        RegistrationTest.class,
        LoginTest.class,
        ManagementTest.class
})


public class UsersSuite {
}
