import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class dicedotcom {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/mervegurleyen/Desktop/BrowserDrivers/chromedriver-3");
        WebDriver driver = new ChromeDriver();

        // Given I am at dice.com
        driver.get("http://www.dice.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //When I enter the search term SDET and location as Washington DC
        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        driver.findElement(By.id("google-location-search")).sendKeys("Washington DC");
        driver.findElement(By.id("submitSearch-button")).click();

        //Then search result page should contain 20 search results

        List<WebElement> elements=driver.findElements(By.xpath("//a[@data-cy='card-title-link']"));
        Assert.assertEquals(20,elements.size());


//        And search result should contain "SDET"

        for (WebElement element:elements){
            Assert.assertTrue(element.getText().contains("SDET"));
        }


        Thread.sleep(3000);

        //And click on the last search result and verify the title contains "SDET"

        elements.get(elements.size()-1).click();

        Assert.assertTrue(driver.getTitle().contains("SDET"));

        driver.quit();

    }
}



