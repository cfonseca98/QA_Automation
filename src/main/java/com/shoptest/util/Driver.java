package com.shoptest.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

	private static WebDriver driverSelenium = null;
	private static Logger logger = Logger.getLogger(Driver.class.getName());
	private static final String ESTATUSOFF = "FALSE";
	private static final String ESTATUSON = "TRUE";

	public static Driver web(String geolocalizacion, String openmode, String navegador) {
		Driver a = new Driver();
		switch (navegador) {
		case "CHROME":

			logger.info("DEBUG: ABRE NAVEGADOR CHROME ");
			a = navegadorChrome(geolocalizacion, openmode);
			break;
		case "FIREFOX":
			logger.info("DEBUG: ABRE NAVEGADOR FIREFOX ");
			a = navegadorFirefox(geolocalizacion, openmode);
			break;

		case "EDGE":
			logger.info("DEBUG: ABRE NAVEGADOR EGDE ");
			a = navegadorEdge();
			break;

		default:
			logger.info("DEBUG: NO EXITE ESE NAVEGADOR");
			break;
		}
		return a;

	}

	public static Driver navegadorChrome(String geolocalizacion, String openmode) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver1.exe");
		HashMap<String, Object> preferences = new HashMap<>();
		preferences.put("download.default_directory","ruta");   
		preferences.put("download.prompt_for_download", "false");
		preferences.put("profile.managed_default_content_settings.javascript", 1);
		preferences.put("profile.default_content_settings.popups", 1);
		preferences.put("profile.content_settings.exceptions.plugins.*,*.setting", 1);
		//preferences.put("profile.managed_default_content_settings.geolocation", 1);
//		if (geolocalizacion.equals(ESTATUSON)) {
//			preferences.put("profile.managed_default_content_settings.geolocation", 1);
//		} else if (geolocalizacion.equals(ESTATUSOFF)) {
//			preferences.put("profile.managed_default_content_settings.geolocation", 2);
//		}
		preferences.put("download.prompt_for_download", "false");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		options.addArguments("test-type");
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		options.addArguments("--no-sandbox");
		options.addArguments("start-maximized");
		if (openmode.equals(ESTATUSOFF)) {
			options.addArguments("--incognito");
		} else if (openmode.equals(ESTATUSON)) {
			logger.info("DEBUG: ABRE EL NAVEGADOR MODO  INCOGNITO");
		} else {
			logger.info("ERROR: OPCION NO VALIDA");
		}
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("prefs", preferences);
		setDriverSelenium(new ChromeDriver(options));
		getDriverSelenium().manage().deleteAllCookies();

		return new Driver();

	}

	public static Driver navegadorFirefox(String geolocalizacion, String openmode) {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/FIREFOX/geckodriver.exe");

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("geo.prompt.testing", true);
		profile.setPreference("geo.prompt.testing.allow", true);
		FirefoxOptions options = new FirefoxOptions();


		profile.setPreference("javascript.enabled", true);
		if (geolocalizacion.equals(ESTATUSON)) {
			profile.setPreference("geo.enabled", true);

		} else if (geolocalizacion.equals(ESTATUSOFF)) {
			profile.setPreference("geo.enabled", false);

		}
		if (openmode.equals(ESTATUSON)) {
			options.addArguments("--private");
		} else {
			logger.info("NO ABRE EN MODO  IGCONITO");
		}
		setDriverSelenium(new FirefoxDriver(options));
		getDriverSelenium().manage().window().maximize();

		return new Driver();

	}

	public static Driver navegadorEdge() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/EDGE/msedgedriver.exe");
		setDriverSelenium(new EdgeDriver());
		return new Driver();

	}

	public WebDriver enLaPagina(String url) {
		getDriverSelenium().get(url);
		return getDriverSelenium();
	}

	public static void scrollBy(int valor) {
		JavascriptExecutor jse = (JavascriptExecutor) getDriverSelenium();
		jse.executeScript("window.scrollBy(0," + valor + ")");

	}

	public static void scrollByMenos() {
		JavascriptExecutor jse = (JavascriptExecutor) getDriverSelenium();
		jse.executeScript("window.scrollBy(0,-90000)");

	}

	public static WebDriver getDriverSelenium() {
		return driverSelenium;
	}

	public static void setDriverSelenium(WebDriver driverSelenium) {
		Driver.driverSelenium = driverSelenium;
	}

}
