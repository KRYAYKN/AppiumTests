package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class Appium04 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //capabilities.setCapability("platformName","Android");
//    capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_6");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
    capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\w\\IdeaProjects\\appiumTests\\src\\Apps\\Gesture Tool_1.3_Apkpure.apk");
      capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
       capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");

       //if you want to start app at main page without permissions use below code
capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement>driver =new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        System.out.println("App yuklendi");

    MobileElement homeScreenTitle =driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("ana sayfa acildi");

MobileElement addGestureButton =driver.findElementById("com.davemac327.gesture.tool:id/addButton");
addGestureButton.click();
MobileElement createTitle =driver.findElementByXPath("//android.widget.TextView[@text='Create a gesture']");
Thread.sleep(3000);
assertTrue(createTitle.isDisplayed());
MobileElement nameBox =driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
nameBox.sendKeys("ayakin");
MobileElement doneButton =driver.findElementById("com.davemac327.gesture.tool:id/done");
doneButton.click();



        //session close
        driver.closeApp();
    }
}
