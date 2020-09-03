package common;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Selenide.screenshot;
import pages.HomePage;
import pages.CartPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class BaseTest {
    protected static HomePage home;
    protected static CartPage cart;

    @BeforeMethod
    public void start() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://shopcart-challenge.4all.com";
        Configuration.timeout = 30000;

        home = new HomePage();
        cart = new CartPage();
    }

    @AfterTest
    public void finish() {
        String sc = screenshot("sc");
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(sc));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte [] binaryShot = baos.toByteArray();
            io.qameta.allure.Allure.addAttachment("finish_sc", new ByteArrayInputStream(binaryShot));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
