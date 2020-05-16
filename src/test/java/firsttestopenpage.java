
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class firsttestopenpage {

    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
// убедитесь, что файл chromedriver.exe расположен именно в каталоге C:\tmp
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

   // @Test
   // void shouldTestSomething() {
     //   driver.get("http://localhost:9999");
       // List<WebElement> elements = driver.findElements(By.className("input__control"));
        //elements.get(0).sendKeys("Василий");
        //elements.get(1).sendKeys("+79270000000");
        //driver.findElement(By.className("checkbox__box")).click();
        //driver.findElement(By.className("button")).click();
        //String text = driver.findElement(By.className("alert-success")).getText();
        //assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    //}

    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=name] input").setValue("Гурина Елена");
        form.$("[data-test-id=phone] input").setValue("+79159638319");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $("[data-test-id=order-success]").shouldHave(exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}



