package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {

        pro = new Properties();

        try {

            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")
                    + "/src/test/resources/config.properties");

            pro.load(fis);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public String getApplicationURL() {
        return pro.getProperty("baseURL");
    }

    public String getBrowser() {
        return pro.getProperty("browser");
    }

    public String getUsername() {
        return pro.getProperty("username");
    }

    public String getPassword() {
        return pro.getProperty("password");
    }

    public String getExcelPath() {
        return pro.getProperty("excelPath");
    }

    public int getImplicitWait() {
        return Integer.parseInt(pro.getProperty("implicitWait"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(pro.getProperty("explicitWait"));
    }

}