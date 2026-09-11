package com.example.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDependencyTest {

    @Test
    public void seleniumLocatorApiIsAvailable() {
        By usernameField = By.id("username");

        Assert.assertEquals(usernameField.toString(), "By.id: username");
    }
}
