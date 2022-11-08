package com.dojo.stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true, features = "feature", glue = { "stepDefinition" })
public class TestRunner {

}
