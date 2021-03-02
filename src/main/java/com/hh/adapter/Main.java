package com.hh.adapter;

import com.hh.adapter.adapter.analysis.AdapterAnalysis;
import com.hh.adapter.analysis.Analysis;
import com.hh.adapter.gateway.analysis.GatewayAnalysis;

import java.util.Iterator;
import java.util.Map;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/2/25
 */
public class Main {
    public static void main(String[] args) {
//        File file = new File("D:\\国泰君安\\生产统计\\统计功能号\\jzqs\\adapter\\2021-02-24-adapter.txt");
//        Analysis analysis = new AdapterAnalysis();

//        File file = new File("D:\\国泰君安\\生产统计\\统计功能号\\jzqs\\gateway\\2021-02-22-gateway.txt");
//        Analysis analysis = new GatewayAnalysis();
//        analysis.analysis(file);
//        printMap(analysis.getFuncMap());

//        String filePath = "D:\\国泰君安\\生产统计\\统计功能号\\sfcg\\sfcg\\adapter\\2021-02-24";
//        String pattern = "发送异步请求成功";
//
//        Analysis analysis = new AdapterAnalysis();
//        analysis.analysis(filePath, pattern);
//        printMap(analysis.getFuncMap());

        String filePath = "D:\\国泰君安\\生产统计\\统计功能号\\sfcg\\sfcg\\gateway\\2021-02-22";
        String pattern = "adapterReq";

        Analysis analysis = new GatewayAnalysis();
        analysis.analysis(filePath, pattern);
        printMap(analysis.getFuncMap());
    }

    public static void printMap(Map<String, Integer> map) {
        System.out.println("===========================================================");
        int total = 0;
        for (Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry<String, Integer> entry = iter.next();
            Integer value = entry.getValue();
            System.out.println(entry.getKey() + "\t" + value);
            total += value;
        }
        System.out.println("总计\t\t\t" + total);
    }
}
