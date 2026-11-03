package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaForm {
    private WebDriver driver;
    private JavascriptExecutor js;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='lastName']")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(xpath = "//*[@id='dateOfBirthInput']")
    WebElement dateOfBirth;

    @FindBy(id = "subjectsInput")
    WebElement subjects;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "submit")
    WebElement submit;

    public DemoqaForm(WebDriver driverParam) {
        this.driver = driverParam;
        this.js = (JavascriptExecutor) driverParam;
        // CRITICAL: Initialize elements annotated with @FindBy
        PageFactory.initElements(driverParam, this);
    }

    public void setFirstName(String firstnameParam) {
        firstName.clear();
        firstName.sendKeys(firstnameParam);
    }

    public void setLastName(String lastnameParam) {
        lastName.clear();
        lastName.sendKeys(lastnameParam);
    }

    public void setUserEmail(String emailParam) {
        userEmail.clear();
        userEmail.sendKeys(emailParam);
    }

    public void setGender(String genderParam) {
        WebElement gender = driver.findElement(By.xpath("//*[@id='genterWrapper']//*[text()='" + genderParam + "']"));
        gender.click();
    }

    public void setUserNumber(String numberParam) {
        userNumber.clear();
        userNumber.sendKeys(numberParam);
    }

    public void setDateOfBirth(String dateParam) {
        dateOfBirth.sendKeys(Keys.CONTROL, "a");
        dateOfBirth.sendKeys(dateParam);
        dateOfBirth.sendKeys(Keys.ENTER);
    }

    public void setSubjects(String subjectParam) {
        subjects.clear();
        subjects.sendKeys(subjectParam);
        subjects.sendKeys(Keys.ENTER);
    }

    public void setHobby(String hobbyParam) {
        WebElement hobby = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']//label[text()='" + hobbyParam + "']/../input"));
        js.executeScript("arguments[0].click();", hobby);
    }

    public void setState(String stateParam) {
        scrollToElement(state);
        state.click();
        driver.findElement(By.xpath("//*[text()='" + stateParam + "']")).click();
    }

    public void setCity(String cityParam) {
        city.click();
        driver.findElement(By.xpath("//*[text()='" + cityParam + "']")).click();
    }

    public void clickSubmit() {
        scrollToElement(submit);
        submit.click();
    }

    public void closeAdvert() {
        try {
            js.executeScript("var elem = document.evaluate(\"//*[@id='Ad.Plus-970x250-2']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "if (elem) elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
        try {
            js.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "if (elem) elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}