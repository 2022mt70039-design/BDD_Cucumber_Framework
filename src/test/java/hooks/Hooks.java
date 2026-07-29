package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import stepDefination.Steps;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {

            File src = ((TakesScreenshot) Steps.driver).getScreenshotAs(OutputType.FILE);

            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            File dest = new File("Screenshots/" + scenario.getName() + "_" + time + ".png");

            dest.getParentFile().mkdirs();

            Files.copy(src.toPath(), dest.toPath());

            scenario.attach(
                    Files.readAllBytes(dest.toPath()),
                    "image/png",
                    scenario.getName());

            System.out.println("Screenshot saved : " + dest.getAbsolutePath());
        }
    }
}