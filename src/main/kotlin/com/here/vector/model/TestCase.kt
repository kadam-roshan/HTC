package com.here.vector.model

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL
import java.util.concurrent.TimeUnit

class TestCase(var url: String, var testSteps: List<TestStep>) {
    constructor() : this("", listOf())

    fun getTestSteps() {
        val driver = RemoteWebDriver(URL("http://localhost:9515"), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url)

        for (testStep: TestStep in testSteps) {
            print("test steps")
            testStep.execute(driver)
        }
    }
}