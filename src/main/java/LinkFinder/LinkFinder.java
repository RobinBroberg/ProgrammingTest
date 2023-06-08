package LinkFinder;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class LinkFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new").addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("Please enter a website address (e.g., www.google.com)");
        String input = scan.nextLine();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.get("https://" + input);


            List<WebElement> weblinks = driver.findElements(By.tagName("a"));


            for (WebElement weblink : weblinks) {
                String links = weblink.getAttribute("href");
                if (links != null) {
                    System.out.println(links);
                }
            }
        } catch (WebDriverException e){
            System.err.println("WebdriverException occured: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
