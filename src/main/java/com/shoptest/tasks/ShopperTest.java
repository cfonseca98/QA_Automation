package com.shoptest.tasks;

import com.shoptest.interactions.WaitToLoad;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class ShopperTest implements Task {
	private String data;
	int random_int = (int)Math.floor(Math.random()*(100)+1);
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on("//*[@id='cityLocation']/div"),
				JavaScriptClick.on("//div[@id='react-select-2-option-4']"),
				Click.on("//*[@id='root']/div[1]/div[2]/div[3]/button"),
				Click.on("//button[@class='sc-jSFkmK hRxJjc w-full StyledButton StyledButtonprimary transition duration-300 ease-in-out']"),
				Enter.keyValues("3219457"+random_int).into("//input[@id='abi-phone']"),
				Click.on("//button[@class='sc-jSFkmK hRxJjc w-full StyledButton StyledButtonprimary transition duration-300 ease-in-out']"),
				WaitToLoad.theMiliSeconds(3),Click.on("//input[@id='abi-checkbox-terms']"),
				Click.on("//input[@id='abi-checkbox-policies']"),
				Click.on("//button[@class='sc-jSFkmK hRxJjc w-full StyledButton StyledButtonprimary transition duration-300 ease-in-out']"),
				Enter.keyValues("Camilo").into("//input[@id='register-name']"),
				Enter.keyValues("Fonseca").into("//input[@id='register-lastName']"),
				Enter.keyValues("camilo.fonsecap"+random_int+"@gmail.com").into("//input[@id='register-email']"),
				WaitToLoad.theMiliSeconds(5),Click.on("//button[@class='sc-jSFkmK hRxJjc styledButtonNext StyledButton StyledButtonprimary transition duration-300 ease-in-out']"),
				WaitToLoad.theMiliSeconds(5),Click.on("//button[@class='sc-jSFkmK hRxJjc w-full bg-transparent shadow-none border-gray-500 normal-case text-gray-principal py-3 justify-start relative StyledButton StyledButtonprimary transition duration-300 ease-in-out']"),
				WaitToLoad.theMiliSeconds(2),Enter.keyValues("Cra. 13 #96-67").into("//input[@id='address']"),
				Click.on("//div[@class='sc-ciSmjq eGqnrC']"),
				WaitToLoad.theMiliSeconds(2),Click.on("//button[@class='sc-jSFkmK hRxJjc sc-fnVYJo aqTZb StyledButton StyledButtonprimary transition duration-300 ease-in-out']"),WaitToLoad.theMiliSeconds(3)) ;


	}

	public static ShopperTest withUser() {
		return new ShopperTest();
		//        		Tasks.instrumented(ShopperTest.class);
	}
}
