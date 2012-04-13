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

package eu.jasha.portaltests.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Web interface to the portal
 */
@Component
public class Portal extends WebDriverPage {

    @Autowired
    public Portal(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void go(String url) {
        get(url);
    }

    public void pressNewAccountButton() {
        final WebElement newAccountButton = findElement(By.id("createNewAccountButton"));
        newAccountButton.click();
    }

    public WebElement getNewAccountForm() {
        return findElement(By.id("newAccountForm"));
    }

    public WebElement getLoginForm() {
        return findElement(By.id("loginForm"));
    }

    public WebElement getEmptyPageBox() {
        return findElement(By.id("emptyPageMessageWrapper"));
    }
}
