Selenium 4 - new features in alpha releases

1) Relative locator (previously Friendly locator - renamed with Selenium 4)
   --working fine on Selenium v4.0.0-alpha-3, 4, 5. Latest version v4.0.0-alpha-6 is not working.
   --This functionality was added to help you locate elements that are nearby other elements.

2) Switching new window
   --driver.switchTo.newWindow(WindowType.Window)
   --returns another WebDriver instance for the newly opened window
   --new webdriver instance should be used to perform actions on that window
   --After completing operations on new window, need to use parent window handle to switch back to first window.
