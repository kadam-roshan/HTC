package com.here.vector.model

import com.here.vector.enums.ActionEnum
import com.here.vector.enums.LocatorEnum
import com.here.vector.enums.TypeEnum
import com.here.vector.enums.WaitTypeEnum
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


class Field(
    var type: String, var locator: String, var element: String, var action: String?,
    var data: String?, var wait: String?, var waittype: String?, var timeout: Long?
) {

    private val UPLOADED_FOLDER: String = "C:/Users/rokadam/Desktop/Tour Planning/"

    fun execute(driver: RemoteWebDriver) {
        val webElement: WebElement? = locateElement(driver)
        if (webElement != null) {
            performAction(webElement)
            saveScreenshots(driver)
        }
    }

    /**
     * get by expression to locate we element
     */
    private fun getByExpression(): By? {
        val byExpression: By?
        val locatorEnum = LocatorEnum.valueOf(locator.toUpperCase())

        byExpression = when (locatorEnum) {
            LocatorEnum.ID -> {
                By.id(element)
            }
            LocatorEnum.NAME -> {
                By.name(element)
            }
            LocatorEnum.CLASS -> {
                By.className(element)
            }
            LocatorEnum.CSS -> {
                By.cssSelector(element)
            }
            LocatorEnum.XPATH -> {
                By.xpath(element)
            }
        }

        return byExpression
    }

    /**
     * locate we element by locators
     */
    private fun locateElement(driver: RemoteWebDriver): WebElement? {
        var webElement: WebElement? = null

        val byExpression: By? = getByExpression()

        if (wait == null) {
            webElement = driver.findElement(byExpression)
        } else {
            if (wait != null) {
                val wait = WebDriverWait(driver, timeout ?: 0)
                val waitTypeEnum = waittype?.toUpperCase()?.let { WaitTypeEnum.valueOf(it) }

                webElement = when (waitTypeEnum) {
                    WaitTypeEnum.VISIBLE -> {
                        wait.until(ExpectedConditions.visibilityOfElementLocated(byExpression))
                    }
                    WaitTypeEnum.CLICKABLE -> {
                        wait.until(ExpectedConditions.elementToBeClickable(byExpression))
                    }
                    else -> null
                }
            }
        }

        return webElement
    }

    /**
     * perform actions on located web element
     */
    private fun performAction(webElement: WebElement) {
        val typeEnum: TypeEnum = TypeEnum.valueOf(type.toUpperCase())
        val actionEnum: ActionEnum? = action?.toUpperCase()?.let { ActionEnum.valueOf(it) }

        when (typeEnum) {
            TypeEnum.SELECT -> {
                val select = Select(webElement)
                select.selectByVisibleText(data)
            }
            TypeEnum.TEXT -> {
                if (actionEnum == ActionEnum.ENTER) {
                    webElement.sendKeys(data)
                }
            }
            TypeEnum.BUTTON -> {
                if (actionEnum == ActionEnum.CLICK) {
                    webElement.click()
                }
            }
        }
    }

    /**
     * save screenshots to uploaded folder
     */
    private fun saveScreenshots(driver: RemoteWebDriver) {
        val scrFile: File = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        try {
            val bytes: ByteArray = scrFile.readBytes()
            val path: Path = Paths.get(UPLOADED_FOLDER + scrFile.name)
            Files.write(path, bytes)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}