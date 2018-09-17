package test.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

public class FunctionalTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	@Test
    public void testHomepage() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/");
		assertEquals(driver.getTitle(), "Partagez vos passions | Meetup");
        //test de la description
		assertEquals(driver.findElement(By.name("description")).getAttribute("content"), "Partagez vos passions et faites bouger votre ville ! Meetup vous aide à rencontrer des personnes près de chez vous, autour de vos centres d'intérêt.");
		//test du titre punchline
        assertEquals(driver.findElement(By.cssSelector("h1.text--display1")).getText(), "Vous avez une passion ?");
        //test de la sous punchline
        assertEquals(driver.findElement(By.cssSelector("p.text--big.text--heavy")).getText(), "Lancez-vous avec Meetup");
        //test du bouton
        assertEquals(driver.findElement(By.cssSelector("a.button.button--primary.text--big.j-modal--register")).getCssValue("background"), "rgb(237, 28, 64) none repeat scroll 0% 0% / auto padding-box border-box");
        assertEquals(driver.findElement(By.cssSelector("a.button.button--primary.text--big.j-modal--register")).getText(), "Inscription");
        assertEquals(driver.findElement(By.cssSelector("a.button.button--primary.text--big.j-modal--register")).getAttribute("href"), "https://secure.meetup.com/fr-FR/register/");

    }


    @Test
    public void testsearch() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/find/outdoors-adventure/");

        String title = driver.getTitle();
        String h1 = driver.findElement(By.cssSelector("h1.text--display1")).getText();

        assertEquals(title.contains(h1), true);
        assertNotEquals(driver.findElement(By.id("searchForm")), null);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}