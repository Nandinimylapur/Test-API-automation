package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", // feature files path
        glue = {"com.steps"}, // location where step definitions located // package name
        tags = "@Author",
        plugin = {"pretty", "html:target/cucumber-reports"}) // need to provide path where all feature files are located
public class Runner {

}
