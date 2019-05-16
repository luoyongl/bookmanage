package com.wtu.jht.bookmanage.openapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Desc:properties文件获取工具类
 * Created by hafiz.zhang on 2016/9/15.
 */
public class PropertiesUtil {
    private static Properties props;
    private static String[] proFileArr = new String[]{"dbconfig.properties"};
    static{
        loadProps();
    }

    synchronized static private void loadProps(){
        props = new Properties();
        InputStream in = null;
        for(String proFile:proFileArr){
            try {
                in = PropertiesUtil.class.getClassLoader().getResourceAsStream(proFile);
                //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
                props.load(in);
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } finally {
                try {
                    if(null != in) {
                        in.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
    
}