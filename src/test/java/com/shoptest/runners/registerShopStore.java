package com.shoptest.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/register.feature", glue = "com.shoptest.stepdefinitions", snippets = SnippetType.CAMELCASE, tags = "@register", monochrome = true)

public class registerShopStore {
	

}

