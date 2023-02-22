package com.digitalExperience.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class Driver {
    private Driver() {
    }

    private static final InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    private static final String BS_USERNAME = ConfigurationReader.getProperty("BS_USERNAME");
    private static final String BS_PASSWORD = ConfigurationReader.getProperty("BS_ACCESS_KEY");
    private static final String REMOTE_URL = "https://" + BS_USERNAME + ":" + BS_PASSWORD + "@hub-cloud.browserstack.com/wd/hub";
    static ChromeOptions chromeOptions;
    static SafariOptions bsSafariOptions;

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            synchronized (Driver.class) {
                String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigurationReader.getProperty("browser");
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-notifications");
//                        chromeOptions.setBrowserVersion("103.0");
                        chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                        chromeOptions.setAcceptInsecureCerts(true);
                        driverPool.set(new ChromeDriver(chromeOptions));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        break;
                    case "chrome-remote":
                        chromeOptions = new ChromeOptions();
                        try {
                            String ipAddress = "172.26.3.230";
                            URL urlPage = new URL("http://" + ipAddress + ":4444/");
                            chromeOptions.addArguments("--disable-notifications");
                            chromeOptions.setBrowserVersion("103.0");
                            chromeOptions.addArguments("--disable-site-isolation-trials");
                            chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                            chromeOptions.setAcceptInsecureCerts(true);
                            driverPool.set(new RemoteWebDriver(urlPage, chromeOptions));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome-remote-headless":
                        chromeOptions = new ChromeOptions();
                        try {
                            String ipAddress = "172.26.3.230";
                            URL urlPage = new URL("http://" + ipAddress + ":4444/");
                            chromeOptions.addArguments("--disable-notifications");
                            chromeOptions.setBrowserVersion("103.0");
                            chromeOptions.addArguments("--disable-site-isolation-trials");
                            chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                            chromeOptions.setAcceptInsecureCerts(true);
                            driverPool.set(new RemoteWebDriver(urlPage, chromeOptions.setHeadless(true)));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        chromeOptions = new ChromeOptions();
                        try {
                            chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                            chromeOptions.addArguments("--disable-notifications");
                            chromeOptions.setAcceptInsecureCerts(true);
                            driverPool.set(new ChromeDriver(chromeOptions.setHeadless(true)));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "safari":
                        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                            throw new WebDriverException("Your OS does not support Safari");
                        }
                        WebDriver driver = WebDriverManager.safaridriver().browserInDocker().create();
                        driverPool.set(driver);
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        break;
                    case "safari-remote":
                        try {
                            String ipAddress = "172.26.3.230";
                            URL urlPage2 = new URL("http://" + ipAddress + ":4444/");
                            bsSafariOptions = new SafariOptions();
                            bsSafariOptions.setCapability("browserName", "safari");
                            bsSafariOptions.setAcceptInsecureCerts(true);
                            driverPool.set(new RemoteWebDriver(urlPage2, bsSafariOptions));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome-bstack":
                        try {
                            DesiredCapabilities bsChromeCaps = new DesiredCapabilities();
                            bsChromeCaps.setCapability("browserName", "Chrome");
                            bsChromeCaps.setCapability("browserVersion", "latest");
                            bsChromeCaps.setAcceptInsecureCerts(true);
                            bsChromeCaps.acceptInsecureCerts();
                            HashMap<String, Object> chromeOptionsMap = new HashMap<>();
                            chromeOptionsMap.put("os", "Windows");
                            chromeOptionsMap.put("osVersion", "10");
                            chromeOptionsMap.put("local", ConfigurationReader.getProperty("BS_LOCAL"));
                            chromeOptionsMap.put("seleniumVersion", ConfigurationReader.getProperty("BS_SELENIUM_VERSION"));
                            chromeOptionsMap.put("video", "false");
                            bsChromeCaps.setCapability("bstack:options", chromeOptionsMap);
                            bsChromeCaps.setCapability("BS_SESSION_NAME", ConfigurationReader.getProperty("BS_SESSION_NAME"));
                            bsChromeCaps.setCapability("buildName", ConfigurationReader.getProperty("CHROME_BS_BUILD_NAME"));
//                            bsChromeCaps.setCapability("acceptSslCert", "true");
                            driverPool.set(new RemoteWebDriver(new URL(REMOTE_URL), bsChromeCaps));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "safari-bstack":
                        try {
                            DesiredCapabilities bsSafariCaps = new DesiredCapabilities();
                            bsSafariCaps.setCapability("browserName", "Safari");
                            bsSafariCaps.setCapability("browserVersion", "15.3");
                            bsSafariCaps.setAcceptInsecureCerts(true);
                            bsSafariCaps.acceptInsecureCerts();
                            HashMap<String, Object> safariOptionsMap = new HashMap<>();
                            safariOptionsMap.put("os", "OS X");
                            safariOptionsMap.put("osVersion", "Monterey");
                            safariOptionsMap.put("local", ConfigurationReader.getProperty("BS_LOCAL"));
                            safariOptionsMap.put("seleniumVersion", ConfigurationReader.getProperty("BS_SELENIUM_VERSION"));
                            safariOptionsMap.put("video", "true");
                            bsSafariCaps.setCapability("bstack:options", safariOptionsMap);
                            bsSafariCaps.setCapability("BS_SESSION_NAME", ConfigurationReader.getProperty("BS_SESSION_NAME"));
                            bsSafariCaps.setCapability("buildName", ConfigurationReader.getProperty("SAFARI_BS_BUILD_NAME"));
//                            bsSafariCaps.setCapability("acceptSslCert", "true");
//                            safariBstackOptions.setCapability("browserstack.safari.enablePopups", false);
                            driverPool.set(new RemoteWebDriver(new URL(REMOTE_URL), bsSafariCaps));
                            bsSafariOptions.setImplicitWaitTimeout(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--disable-notifications");
                        firefoxOptions.setAcceptInsecureCerts(true);
                        driverPool.set(new FirefoxDriver(firefoxOptions));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        break;
                }
            }
        }
        return driverPool.get();

    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
