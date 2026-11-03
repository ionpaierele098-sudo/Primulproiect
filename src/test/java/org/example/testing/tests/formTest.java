package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaForm {
    private WebDriver driver;

    public DemoqaForm(WebDriver driver) {
        this.driver = driver;
    }

    // Metodă pentru a ascunde sau elimina bannerele și reclamele care blochează elementele
    public void closeAdvert() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("const ads = document.querySelectorAll('#fixedban, footer, iframe'); ads.forEach(ad => ad.remove());");
        } catch (Exception e) {
            // Ignoră dacă elementele nu sunt găsite
        }
    }

    public void setFirstName(String firstName) {
        WebElement el = driver.findElement(By.id("firstName"));
        el.clear();
        el.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement el = driver.findElement(By.id("lastName"));
        el.clear();
        el.sendKeys(lastName);
    }

    public void setUserEmail(String email) {
        WebElement el = driver.findElement(By.id("userEmail"));
        el.clear();
        el.sendKeys(email);
    }

    public void setGender(String gender) {
        String xpath = "//label[text()='" + gender + "']";
        WebElement el = driver.findElement(By.xpath(xpath));
        // Folosim JavaScript click și scroll pentru a evita ElementClickInterceptedException
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", el);
        js.executeScript("arguments[0].click();", el);
    }

    public void setUserNumber(String number) {
        WebElement el = driver.findElement(By.id("userNumber"));
        el.clear();
        el.sendKeys(number);
    }

    public void setDateOfBirth(String dob) {
        WebElement dateInput = driver.findElement(By.id("dateOfBirthInput"));
        dateInput.click();
        dateInput.sendKeys(Keys.CONTROL + "a");
        dateInput.sendKeys(dob);
        dateInput.sendKeys(Keys.ENTER);
    }

    public void setSubjects(String subjects) {
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys(subjects);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void setHobby(String hobby) {
        String xpath = "//label[text()='" + hobby + "']";
        WebElement el = driver.findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", el);
        js.executeScript("arguments[0].click();", el);
    }

    public void setState(String state) {
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", stateInput);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
    }

    public void setCity(String city) {
        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", cityInput);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void clickSubmit() {
        WebElement submitBtn = driver.findElement(By.id("submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        js.executeScript("arguments[0].click();", submitBtn);
    }
}