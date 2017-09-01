/*
 * MessageUtils.java Created on May 12, 2006
 * Copyright 2006@broadtext. 
 * All right reserved. 
 */
package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * 操作资源文件的�1�7�用籄1�7
 * @time: 16:03:14
 * @author liuxiaofang
 */
public class MessageUtils {
	
	/**
	 * 属�1�7�对豄1�7
	 */
    private static Properties props = null;    
	/**
	 * 资源配置文件
	 */
    private static File configFile = null; 
	/**
	 * 文件上次修改时间
	 */
    private static long fileLastModified = 0L; 

	/**
	 * 默认资源文件
	 */
    private static String defaultResourceFileName = "messages_zh_CN.properties";

    /**
     * 初始匄1�7
     *
     */
    private static void init() { 
        URL url = MessageUtils.class.getClassLoader().getResource(defaultResourceFileName); 
        configFile = new File(url.getFile()); 
        fileLastModified = configFile.lastModified();      
        props = new Properties(); 
        load(); 
    } 
    
    /**
     * 加载资源文件
     *
     */
    private static void load() { 
        try { 
            props.load(new FileInputStream(configFile)); 
            fileLastModified = configFile.lastModified(); 
        } catch (IOException e) {            
            throw new RuntimeException(e); 
        } 
    } 
    
    /**
     * 根据丄1�7个key取得对应的资源消恄1�7
     * @param key 消息key
     * @return 消息
     */
    public static String getMessage(String key){
        if ((configFile == null) || (props == null)) init(); 
        if (configFile.lastModified() > fileLastModified) load(); 
        String message = props.getProperty(key); 
        if(StringUtils.isEmpty(message)){
            return key;
        }else{
            return message;
        }
    }
    
    /**
     * 取得带有参数的资源文件，并将参数替换为对应的实际倄1�7
     * @param key 消息key
     * @param values 参数数组，形式为new String[]{"戄1�7"}
     * @return 消息
     */ 
    public static String getMessage(String key,String[] values){
        if ((configFile == null) || (props == null)) init(); 
        if (configFile.lastModified() > fileLastModified) load(); 
        String message = props.getProperty(key);
        if(StringUtils.isEmpty(message)) return key;
        
        if(values!=null && values!=null){
            for(int i=0;i<values.length;i++){
                message = StringUtils.replace(message,"{"+i+"}",values[i]);
            }
        }
        
        return message;
    }
    
    public static void main(String []args){
//        AppBaseException a = new AppBaseException("errors.required",new String[]{"戄1�7","佄1�7"});
    	Locale locale = Locale.getDefault();
    	System.out.println("_"+locale.getLanguage()+"_"+locale.getCountry());
//        System.out.println(a.getMessage());
    }
}

