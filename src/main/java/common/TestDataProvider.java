package common;

import org.testng.annotations.BeforeTest;

public class TestDataProvider extends ElementProvider{

    @BeforeTest
    public void preSetUp()
    {
       setWebDriver();
    }
}


