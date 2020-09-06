# HTC
Development setup

* Run Remote web driver [chromedriver.exe].
* Run task gradle bootRun from terminal to start server.
* Open Postman.
* Select method type POST.
* Post belowed request data:
```json
  {
  "url": "http://demo.guru99.com/test/newtours/login.php",
  "testSteps": [
    {
      "fields": [
        {
          "type": "button",
          "locator": "xpath",
          "element": "//a[text()='REGISTER']",
          "action": "click"
        }
      ]
    },
    {
      "fields": [
        {
          "name":"username",
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='firstName']",
          "action": "enter",
          "data": "Test"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='lastName']",
          "action": "enter",
          "data": "Test"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='phone']",
          "action": "enter",
          "data": "1111111111"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='userName']",
          "action": "enter",
          "data": "Test@gmail.com"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='address1']",
          "action": "enter",
          "data": "Test"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='city']",
          "action": "enter",
          "data": "Test"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='state']",
          "action": "enter",
          "data": "Test"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='postalCode']",
          "action": "enter",
          "data": "Test"
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='country']",
          "data": "Test"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='email']",
          "action": "enter",
          "data": "Test"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='password']",
          "action": "enter",
          "data": "Test@12345"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='confirmPassword']",
          "action": "enter",
          "data": "Test@12345"
        },
        {
          "type": "button",
          "locator": "xpath",
          "element": "//input[@name='submit']",
          "action": "click"
        }
      ]
    },
    {
      "fields": [
        {
          "type": "button",
          "locator": "xpath",
          "element": "//a[@href='login.php']",
          "action": "click"
        }
      ]
    },
    {
      "fields": [
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='userName']",
          "action": "enter",
          "data": "Test"
        },
        {
          "type": "text",
          "locator": "xpath",
          "element": "//input[@name='password']",
          "action": "enter",
          "data": "Test@12345"
        },
        {
          "type": "button",
          "locator": "xpath",
          "element": "//input[@name='submit']",
          "action": "click"
        }
      ]
    },
    {
      "fields": [
        {
          "type": "button",
          "locator": "xpath",
          "element": "//a[@href='reservation.php']",
          "action": "click",
          "wait": "explicit",
          "waittype": "visible",
          "timeout": 30
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='passCount']",
          "data": "4"
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='fromPort']",
          "data": "Paris"
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='fromMonth']",
          "data": "April"
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='fromDay']",
          "data": "10"
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='toPort']",
          "data": "London"
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='toMonth']",
          "data": "April"
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='toDay']",
          "data": "25"
        },
        {
          "type": "select",
          "locator": "xpath",
          "element": "//select[@name='airline']",
          "data": "Unified Airlines"
        },
        {
          "type": "button",
          "locator": "xpath",
          "element": "//input[@name='findFlights']",
          "action": "click"
        }
      ]
    }
  ]
}
```
