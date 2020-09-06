package com.here.vector.model

import org.openqa.selenium.remote.RemoteWebDriver

class TestStep(var fields: List<Field>) {
    constructor() : this(listOf())

    fun execute(driver: RemoteWebDriver) {
        for (field: Field in fields) {
            field.execute(driver)
        }
    }
}