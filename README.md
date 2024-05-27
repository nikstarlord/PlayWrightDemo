# Playwright Framework with Java and TestNG

This project is a Maven-based automation framework using Playwright for Java. It leverages TestNG for test management and follows the Page Object Model (POM) architecture. The framework includes configurations for browser type, auto wait, browser version, host URL, user authentications, and different types of browser options.

## Project Structure

<pre>
playwright-framework
│
├── src
│   ├── main
│   │   └── java
│   │       ├── config
│   │       │   └── FrameworkConfig.java
│   │       ├── pages
│   │       │   ├── BasePage.java
│   │       │   └── ZomatoPage.java
│   │       └── utils
│   │           └── BrowserFactory.java
│   ├── test
│   │   └── java
│   │       └── tests
│   │           └── OrderDishTest.java
│   └── resources
│       └── testng.xml
└── pom.xml
</pre>

## Getting Started

### Prerequisites

- Java 17 or higher

### Installation

1. **Clone the repository**:

    ```sh
    git clone https://github.com/your-repo/playwright-framework.git
    cd playwright-framework
    ```

2. **Install dependencies**:

    ```sh
    mvn clean install
    ```

### Running the Tests

To execute the test suite, use the following Maven command:

```sh
mvn clean test
```
This command will:
- Clean the project(remove the `target` directory).
- Compile the source and test classes.
- Run the tests specified in `testng.xml`.

## Project Components
#### `Framework.java`
Provides configuration for the framework such as :
- Browser Type (default: Chrome)
- Auto Wait
- Host URL
- User Authentication tokens
- Browser launch options

#### `BrowserFactory.java`
Handles browser setup & teardown: 
- Initializes Playwright & browser instances.
- Set up browser context with user authentication tokens.
- Provides a method to get the current page instance.
- Close the browser after tests are completed.

#### `BasePage.java`
A base class for all pages objects:
- Provides basic navigation functionality.
- Holds a reference to the Playwright `Page` Object.

#### `ZomatoPage.java`
A specific page object for interacting with the Zomato website:
- Contains selectors and methods for searching restaurants & opening them.
- Implementations like `searchForRestaurant`, `selectRestaurant` & `getRestaurantName`.

#### `testng.xml`
TestNG configuration file:
- Specifies the test suite and test classes to be executed.

# Example Usage

```java
package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ZomatoPage;
import utils.BrowserFactory;

public class OrderDishTest {
    ZomatoPage zomatoPage;

    @BeforeClass
    public void setUp() {
        BrowserFactory.setup();
        zomatoPage = new ZomatoPage();
    }

    @Test
    public void orderDishFromRestaurant() {
        zomatoPage.navigateTo("https://www.zomato.com");
        zomatoPage.searchForRestaurant("Pizza Hut");
        zomatoPage.selectFirstResult();
        zomatoPage.orderDish();
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.tearDown();
    }
}
```



