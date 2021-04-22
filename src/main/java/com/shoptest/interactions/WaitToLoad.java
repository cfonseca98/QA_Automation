package com.shoptest.interactions;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class WaitToLoad implements Interaction {
	private Logger logger = Logger.getLogger(WaitToLoad.class.getName());
	private int seconds;

	public WaitToLoad(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public <T extends Actor> void performAs(T actor) { 
		try {
			Thread.sleep((long) seconds * 1000);
		} catch (InterruptedException e) {
			logger.log(Level.WARNING, () -> "Interrupted! "+ e.getMessage());
			Thread.currentThread().interrupt();
		}
	}

	public static WaitToLoad theMiliSeconds(int seconds) {
		return Tasks.instrumented(WaitToLoad.class, seconds);
	}
}
