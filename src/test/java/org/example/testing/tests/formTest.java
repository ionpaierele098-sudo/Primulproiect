package org.example.testing.tests;

import Utils.SeleniumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.DemoqaForm;

public class formTest {
    private static final Logger logger = LogManager.getLogger(formTest.class);

    public static WebDriver driver;
    public static String URI = "https://demoqa.com/automation-practice-form";
    public static String FIRST_NAME = "Paierele";
    public static String LAST_NAME = "Ion";
    public static String EMAIL = "ionpaierele098@gmail.com";
    public static String GENDER = "Male";
    public static String NUMBER = "0600000000";
    public static String BIRTH_DATE = "11 Jul 2007";
    public static String SUBJECTS = "Maths";
    public static String HOBBY = "Sports";
    public static String STATE = "Rajasthan";
    public static String CITY = "Jaipur";

    @BeforeTest
    public void beforeTest() {
        driver = SeleniumDriver.getAutoDriver();
    }

    @Test
    public void formTest() {
        logger.info("Start test");
        driver.get(URI);
        driver.manage().window().maximize();

        DemoqaForm form = new DemoqaForm(driver);

        // Remove ads and footer to prevent ElementClickInterceptedException
        form.closeAdvert();

        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setUserEmail(EMAIL);
        form.setGender(GENDER);
        form.setUserNumber(NUMBER);
        form.setDateOfBirth(BIRTH_DATE);
        form.setSubjects(SUBJECTS);
        form.setHobby(HOBBY);
        form.setState(STATE);
        form.setCity(CITY);
        form.clickSubmit();

        logger.info("Finish test");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}