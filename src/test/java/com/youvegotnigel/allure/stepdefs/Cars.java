package com.youvegotnigel.allure.stepdefs;

import io.cucumber.java.en.And;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Cars {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cars.class.getName());
    String tesla = System.getProperty("user.dir") + "//src//main//resources//files//tesla.jpg";
    String speed = System.getProperty("user.dir") + "//src//main//resources//files//speed.jpg";
    String hit = System.getProperty("user.dir") + "//src//main//resources//files//hit.jpg";
    String coin = System.getProperty("user.dir") + "//src//main//resources//files//coin.png";
    String log = System.getProperty("user.dir") + "//src//main//resources//files//any.log";
    String video = System.getProperty("user.dir") + "//src//main//resources//files//view.mp4";


    @And("^I like fast teslas")
    public void step_01() throws IOException {
        LOGGER.info("This is step 01");

        try {
            File teslaF = new File(tesla);
            ByteArrayInputStream imageAsByteArrayIS = new ByteArrayInputStream(FileUtils.readFileToByteArray(teslaF));
            Allure.addAttachment("Some Screenshot", imageAsByteArrayIS);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("File Not Found");
        }

    }

    @And("^Can drive as 100 kmph$")
    public void step_02() throws IOException {
        LOGGER.info("This is step 02");
        try {
            File logF = new File(log);
            File speedF = new File(speed);
            ByteArrayInputStream fileAsByteArrayIS = new ByteArrayInputStream(FileUtils.readFileToByteArray(logF));
            ByteArrayInputStream fileAsByteArrayIS_1 = new ByteArrayInputStream(FileUtils.readFileToByteArray(speedF));
            Allure.addAttachment("Any file log", fileAsByteArrayIS);
            Allure.addAttachment("Some Screenshot", fileAsByteArrayIS_1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^I hit a brick wall$")
    public void step_03() throws IOException{
        LOGGER.info("This is step 03");
        try {
            File videoF = new File(video);
            File hitF = new File(hit);
            ByteArrayInputStream imageAsByteArrayIS = new ByteArrayInputStream(FileUtils.readFileToByteArray(videoF));
            ByteArrayInputStream imageAsByteArrayIS_1 = new ByteArrayInputStream(FileUtils.readFileToByteArray(hitF));
            Allure.addAttachment("Some Video", imageAsByteArrayIS);
            Allure.addAttachment("Some Screenshot", imageAsByteArrayIS_1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^My doge coin wallet will fall$")
    public void step_04() {
        LOGGER.info("This is step 04");
        try {
            File coinF = new File(coin);
            ByteArrayInputStream imageAsByteArrayIS = new ByteArrayInputStream(FileUtils.readFileToByteArray(coinF));
            Allure.addAttachment("Some Screenshot", imageAsByteArrayIS);
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.fail("FAILURE ON PURPOSE");
    }

}
