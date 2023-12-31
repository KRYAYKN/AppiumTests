package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
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


        AndroidDriver<MobileElement>driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("App yuklendi");
        Thread.sleep(3000);
    driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
    MobileElement okButton =driver.findElementByXPath("//android.widget.Button[@text='OK']");
    okButton.click();

        System.out.println("izinler onaylandi");
    MobileElement homeScreenTitle =driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("ana sayfa acildi");
    }
}
