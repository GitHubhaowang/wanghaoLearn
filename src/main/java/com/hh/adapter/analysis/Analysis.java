package com.hh.adapter.analysis;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析接口
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/2/25
 */
public abstract class Analysis {
    private Map<String, Integer> funcMap = new TreeMap<>();

    public abstract boolean analysis(File file);

    public abstract void analysis(String line);

    public boolean analysis(String filePath, String pattern) {
        File file = new File(filePath);
        readFile(file, pattern);
        return true;
    }

    /**
     * 循环读取文件并解析
     * @param fileParent
     */
    private void readFile(File fileParent, String pattern) {
        if (fileParent.isDirectory()) {
            File[] files = fileParent.listFiles();
            for (File file : files) {
                readFile(file, pattern);
            }
        } else if (fileParent.isFile()) {
            fileAnalysis(fileParent, pattern);
        }
    }

    /**
     * 文件解析
     * @param file
     * @param patternStr
     */
    private void fileAnalysis(File file, String patternStr) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader bufferedReader = null;
        Pattern pattern = Pattern.compile(patternStr);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gb2312"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    analysis(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void addFunc(String func) {
        if (funcMap.containsKey(func)) {
            funcMap.put(func, funcMap.get(func) + 1);
        } else {
            funcMap.put(func, new Integer(1));
        }
    }

    public final Map<String, Integer> getFuncMap() {
        return this.funcMap;
    }
}
