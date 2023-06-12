package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Appium05 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //capabilities.setCapability("platformName","Android");
//    capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_6");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
    capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\w\\IdeaProjects\\appiumTests\\src\\Apps\\Calculator Vault_1.3.4_Apkpure.apk");


       //if you want to start app at main page without permissions use below code
//capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement>driver =new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        System.out.println("App yuklendi");
        Thread.sleep(5000);
MobileElement pass1 =driver.findElementById("android:id/text1");
pass1.sendKeys("990062");
MobileElement pass2 =driver.findElementById("android:id/text2");
pass2.sendKeys("990062");
MobileElement ok =driver.findElementById("android:id/button1");
ok.click();
MobileElement OK =driver.findElementByXPath("//android.widget.Button[@text='OK']");
OK.click();



        MobileElement num1 =driver.findElementByXPath("//android.widget.Button[@text='1']");
        MobileElement num2 =driver.findElementByXPath("//android.widget.Button[@text='2']");
        MobileElement num3 =driver.findElementByXPath("//android.widget.Button[@text='3']");
        MobileElement num4 =driver.findElementByXPath("//android.widget.Button[@text='4']");
        MobileElement num5 =driver.findElementByXPath("//android.widget.Button[@text='5']");
        MobileElement num6 =driver.findElementByXPath("//android.widget.Button[@text='6']");
        MobileElement num7 =driver.findElementByXPath("//android.widget.Button[@text='7']");
        MobileElement num8 =driver.findElementByXPath("//android.widget.Button[@text='8']");
        MobileElement num9 =driver.findElementByXPath("//android.widget.Button[@text='9']");
        MobileElement num0 =driver.findElementByXPath("//android.widget.Button[@text='0']");

        MobileElement plus =driver.findElementByXPath("//android.widget.Button[@content-desc=\"plus\"]");
        MobileElement minus =driver.findElementByXPath("//android.widget.Button[@content-desc=\"minus\"]");
        MobileElement multiply =driver.findElementByXPath("//android.widget.Button[@content-desc=\"times\"]");
        MobileElement divide =driver.findElementByXPath("//android.widget.Button[@content-desc=\"divide\"]");

        MobileElement equal =driver.findElementByXPath("//android.widget.Button[@content-desc=\"equals\"]");

//64+71
        num6.click();
        num4.click();
        plus.click();
        num7.click();
        num1.click();
        equal.click();

        MobileElement result =driver.findElementByXPath("(//*[@class='android.widget.EditText'])[1]");
assertEquals("135",result.getText());



        //session close
        driver.closeApp();
    }
}
