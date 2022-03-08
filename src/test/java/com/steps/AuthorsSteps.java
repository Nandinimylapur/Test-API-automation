package com.steps;

import com.bean.Authors;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;

public class AuthorsSteps {

    // "([^"]*)" string pattern
    // (\\d+) integer pattern
    int id;
    int bookId;
    String firstname, lastname;
    Response authorsResponse;

    @Given("^Author id is (\\d+)$")
    public void authorIdIs(int id) {
        System.out.println("Test from First step..");
        System.out.println("Author Id : " + id);
    }

    @Given("^Author book id is \"([^\"]*)\"$")
    public void Author_book_id_is(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had

        System.out.println("Author book Id : " + arg1);
    }

    @Given("^Author firstname is \"([^\"]*)\"$")
    public void Author_firstname_is(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Author firstname : " + arg1);
    }

    @Given("^Author lastname is \"([^\"]*)\"$")
    public void Author_lastname_is(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Author lastname : " + arg1);
    }


    @Given("^Author details are like id: (\\d+) and bookId (\\d+) and firstname \"([^\"]*)\" and lastname \"([^\"]*)\"$")
    public void Author_details_are_like_id_and_bookId_and_firstname_and_lastname(int id, int bookId, String fname, String lname) throws Throwable {
        System.out.println(id);
        System.out.println(bookId);
        System.out.println(fname);
        System.out.println(lname);

        this.id = id;
        this.bookId = bookId;
        firstname = fname;
        lastname = lname;

    }

    @When("^Perform the POST call on Authors api$")
    public void Perform_the_POST_call_on_Authors_api() throws Throwable {

        String url = "https://fakerestapi.azurewebsites.net/api/v1/Authors";

        Authors authors = new Authors();
        authors.setId(id);
        authors.setIdBook(bookId);
        authors.setFirstName(firstname);
        authors.setLastName(lastname);

        authorsResponse = RestAssured.given().baseUri(url)
                .contentType(ContentType.JSON)
                .body(authors)
                .when().log().all()
                .post()
                .then().log().all()// use log().all() method in between the API calls to get the details logs, which checks that what happens at any steps
                .statusCode(HttpStatus.SC_OK).extract().response();
    }

    @Then("^Verify response of Authors api$")
    public void Verify_response_of_Authors_api() throws Throwable {

    	

        Assert.assertEquals(firstname, authorsResponse.path("firstName"));

        Assert.assertEquals(lastname, authorsResponse.path("lastName"));

    }
}
