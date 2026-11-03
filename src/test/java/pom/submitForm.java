package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class submitForm {
    public static WebDriver driver;
    public submitForm(WebDriver driverParam) {
        driver = driverParam;
    }


    public String getValue(String valueParam) {
        return driver.findElement(By.xpath("//table//tr//td[text()='"+ valueParam + "']/../td[2]")).getText();

    };

    public String getStudentName() {
        return getValue("Student Name");
    }
}
