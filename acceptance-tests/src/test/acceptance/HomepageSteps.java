package test.acceptance;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class HomepageSteps {

	public static WebDriver driver;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^je suis sur la homepage$")
	public void je_suis_sur_la_homepage() throws Throwable {
		driver.get("https://www.meetup.com/fr-FR/");
	}

	@Then("^le titre doit être \"([^\"]*)\"$")
	public void le_titre_doit_être(String arg1) throws Throwable {
	    assertEquals(driver.getTitle(), arg1);
	}

	@Then("^la description doit être \"([^\"]*)\"$")
	public void la_description_doit_être(String arg1) throws Throwable {
		// By CSS Selector
	    assertEquals(driver.findElement(By.cssSelector("meta[name='description']")).getAttribute("content"), arg1);
		// By XPATH, si vous préférez...
	    // assertEquals(driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content"), arg1);
	}

	@Then("^le header doit être \"([^\"]*)\"$")
	public void le_header_doit_être(String arg1) throws Throwable {
    	assertEquals(driver.findElement(By.cssSelector("h1.text--display1")).getText(), arg1);
}

@Then("^la sous punchline doit être \"([^\"]*)\"$")
public void la_sous_punchline_doit_être(String arg1) throws Throwable {
    assertEquals(driver.findElement(By.cssSelector("p.text--big.text--heavy")).getText(), arg1);
}

@Given("^le bloc des meetups près de chez soi est présent$")
public void le_bloc_des_meetups_près_de_chez_soi_est_présent() throws Throwable {
    assertNotEquals(driver.findElement(By.cssSelector("div.bounds.bounds--categories")), null);
}

@When("^je clic sur le bouton \"([^\"]*)\"$")
public void je_clic_sur_le_bouton(String arg1) throws Throwable {
    driver.findElement(By.cssSelector("a.link.text--bold.text--red")).click();
}

@Then("^je suis sur la page \"([^\"]*)\"$")
public void je_suis_sur_la_page(String arg1) throws Throwable {
    assertEquals(driver.getCurrentUrl(), arg1);
}

@Then("^la recherche est initialisé sur un rayon de \"([^\"]*)\" autour de \"([^\"]*)\"$")
public void la_recherche_est_initialisé_sur_un_rayon_de_autour_de(String arg1, String arg2) throws Throwable {
    assertEquals(driver.findElement(By.cssSelector("div.dropdown.callout.center > a")).getText().replaceAll(" ", ""), arg1);
	assertEquals(driver.findElement(By.cssSelector("div.dropdown.callout.center.location-display > a")).getText(), arg2);
}


	@After
	public void afterScenario() {
		driver.quit();
	}

}