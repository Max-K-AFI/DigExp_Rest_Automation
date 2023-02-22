package com.digitalExperience.step_definitions.digitalExp_steps;



import com.browserstack.local.Local;
import com.digitalExperience.utilities.BStackUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.HashMap;

public class Hooks {

    private static String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigurationReader.getProperty("browser");
    private static final String BS_PASSWORD = ConfigurationReader.getProperty("BS_ACCESS_KEY");
    private static final Local LOCAL = new Local();
    private static final HashMap<String, String> BS_LOCAL_ARGS = new HashMap<>();

    @BeforeAll
    public static void setUpConnection() throws Exception {
        BS_LOCAL_ARGS.put("key", BS_PASSWORD);
        if (browser.contains("bstack")) {
            LOCAL.start(BS_LOCAL_ARGS);
        }
    }

    @Before
    public static void setUpBrowser() {
        String platform = System.getProperty("platform") != null ? platform = System.getProperty("platform") : ConfigurationReader.getProperty("platform");
        Dimension dimension;
        switch (platform) {
            case "desktop":
                if (ConfigurationReader.getProperty("browser").contains("headless")) {
                    dimension = new Dimension(1280, 950);
                    Driver.getDriver().manage().window().setSize(dimension);
                } else {
                    Driver.getDriver().manage().window().maximize();
                    System.out.println("============Desktop Test Started!=============");
                }
                break;
            case "tablet":
                dimension = new Dimension(768, 950);
                Driver.getDriver().manage().window().setSize(dimension);
                System.out.println("============Tablet Test Started!=============");
                break;
            case "mobile":
                dimension = new Dimension(598, 900);
                Driver.getDriver().manage().window().setSize(dimension);
                System.out.println("============Mobile Test Started!=============");
                break;
            default:
                Driver.getDriver().manage().window().maximize();
        }
    }

    @After
    public static void afterScenarioStep(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            if (scenario.isFailed() && browser.contains("bstack")) {
                BStackUtils.bstackTestResult("failed",  String.format("%s failed.", scenario.getName()));
            }
            if (!scenario.isFailed() && browser.contains("bstack")) {
                BStackUtils.bstackTestResult("passed", String.format("%s passed.", scenario.getName()));
            }
            System.out.println("==============End of Test Scenario!==============");
        } finally {
            Driver.closeDriver();
        }
    }

    @AfterAll
    public static void tearDown() throws Exception {
        System.out.println("========= End of Tests! =========");
        if (browser.contains("bstack")) {
            LOCAL.stop();
        }
    }
}
