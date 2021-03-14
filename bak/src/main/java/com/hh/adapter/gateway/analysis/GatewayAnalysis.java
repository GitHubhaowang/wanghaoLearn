package com.hh.adapter.gateway.analysis;

import com.hh.adapter.analysis.Analysis;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/2/25
 */
public class GatewayAnalysis extends Analysis {

    @Override
    public boolean analysis(File file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                analysis(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public void analysis(String line) {
        Pattern contextPattern = Pattern.compile("\"func\":\"(\\w+)\",");
        Matcher method = contextPattern.matcher(line);
        if (method.find()) {
            this.addFunc(method.group(1));
        }
    }
}
