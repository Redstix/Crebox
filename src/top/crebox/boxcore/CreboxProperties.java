package top.crebox.boxcore;

import top.crebox.logger.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreboxProperties {
    private static CreboxProperties instance;
    private String PropertiesFile="./resources/boxcore/sandbox.properties";
    private Properties Props;
    private CreboxProperties() {} // 私有构造方法

    public static CreboxProperties getInstance() {
        if (instance == null)
            instance = new CreboxProperties();
        return instance;
    }
    public void loadProperties() {
        Props=new Properties();
        try (InputStream is = new FileInputStream(PropertiesFile)){
            Props.load(is);
        } catch (IOException e) {
            Logger.getInstance().logError(e.getMessage());
            throw new RuntimeException(e);
        }

    }
    public int getEnergyNum() {
        return (int) Props.get("PhotosynthesisEnergy");
    }
}
