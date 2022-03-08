package com.steps;


import io.cucumber.java.en.*;

public class Stepdefs {

	@Given("^Passing two number to addition$")
	public void Passing_two_number_to_addition() throws Throwable {
		System.out.println("Passing two numbers");
	}

	@Then("^Numbers added successfully$")
	public void Numbers_added_successfully() throws Throwable {
		System.out.println("Numbers added");
	}

	@Given("^I want to add (\\d+) and (\\d+)$")
	public void I_want_to_add_and(int a, int b) throws Throwable {
		System.out.println("Two param : " + a);
		System.out.println("Two param : " + b);
	}

	@Then("^Addition should be (\\d+)$")
	public void Addition_shoulf_be(int ans) throws Throwable {
		System.out.println("Ans : " + ans);

	}
}
