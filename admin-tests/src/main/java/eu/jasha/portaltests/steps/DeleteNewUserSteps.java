/*
 * Copyright 2012 Jasha Joachimsthal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.jasha.portaltests.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import eu.jasha.portaltests.pages.Portal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Steps for the new user stories
 */
public class DeleteNewUserSteps {

    @Autowired
    Portal portal;

    @When("I go to \"$url\"")
    public void goTo(String url) {
        portal.go(url);
    }

    @Then("I see the login page")
    public void isLoginPage() {
        final WebElement title = portal.findElement(By.tagName("title"));
        assertThat(title.getText().trim(), equalTo("Login - Rave"));
    }

    @When("I log in as an administrator with username \"$username\" and password \"$password\"")
    public void loginAsAdmin(String username, String password) {
        portal.loginAsAdmin(username,password);
    }

    @Then("I see the admin interface link")
    public void getAdminInterfaceLink() {
        // throws exception if id is not present
        portal.getAdminInterfaceLink();
    }

	 @When("I log out")
	 public void iLogOut() {
		  portal.logout();
	 }

	 @Then("I see the Rave login page")
	 public void backToLoginPage() {
        final WebElement title = portal.findElement(By.tagName("title"));
        assertThat(title.getText().trim(), equalTo("Login - Rave"));
	 }

}
