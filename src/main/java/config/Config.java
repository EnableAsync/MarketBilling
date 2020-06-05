package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 单例模式的枚举写法
 * 需要 jdk 1.8+
 */
public enum Config {
    INSTANCE;
    private Properties instance;

    Config() {
        instance = new Properties();
        try {
            instance.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getInstance() {
        return instance;
    }
}
