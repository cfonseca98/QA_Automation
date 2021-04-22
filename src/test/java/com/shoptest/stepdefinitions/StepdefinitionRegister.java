package com.shoptest.stepdefinitions;


import com.shoptest.tasks.ShopperTest;
import com.shoptest.util.Driver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import org.openqa.selenium.Alert;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@SuppressWarnings("unused")
public class StepdefinitionRegister {
	
	
	Actor Robot;
//	@Before
//	public void setUp() {
//		OnStage.setTheStage(Cast.ofStandardActors());
//	}
//
//	;

	@Given("^that (.*) is on the login page$")
	public void thatTheUserIsOnTheLoginPage(String name) {

		Robot = Actor.named(name);
        
		Robot.whoCan(BrowseTheWeb
				.with(Driver.web("FALSE", "TRUE", "CHROME").enLaPagina("https://co-tc-shopper-web-stage.serempre.dev")));

	}

	@When("^Enter a city$")
	public void enterACity() {
		Robot.attemptsTo(ShopperTest.withUser());
	}

//	@Then("^successful registration$")
//	public void canSeeYourName() {
//		Alert alert = Driver.getDriverSelenium().switchTo().alert();
//		alert.accept();
		//		theActorInTheSpotlight().attemptsTo(Switch.toAlert());

//	}


}
