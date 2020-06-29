package com.BPDTS.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/resources",tags = {"@API"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/",
        "json:target/cucumber-report/cucumber.json",
        "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"
},      glue = "com.BPDTS.test")

public class RunAPISuite extends AbstractTestNGCucumberTests {
    }