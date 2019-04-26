package com.stylefeng.guns.rest.util;

import java.io.*;

/**
 * Created by hu xinyue
 * Date 2019/4/25 Time 11:23
 */
public class ReadUtil {
    public static String readFile(String path) {
        StringBuffer laststr = new StringBuffer();
        File file = new File(path);// 打开文件
        BufferedReader reader = null;
        try {
            FileInputStream in = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));// 读取文件
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException el) {
                }
            }
        }
        return laststr.toString();
    }

}
