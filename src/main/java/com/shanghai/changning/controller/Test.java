package com.shanghai.changning.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        String a = "1.23";
        double b =  Double.parseDouble(a);
        System.out.println(b);
        String dueDate = "2017/12/05 11:00:55";
        String time = dueDate.split(" ")[1].substring(0, dueDate.split(" ")[1].lastIndexOf(":"));
        System.out.println(time);

        Map<Long, String> map = new HashMap<Long, String>();
        map.put(1L,"a");
        map.put(2L,"b");
        map.put(3L,"c");
        for (Long key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        DecimalFormat df=new DecimalFormat("0.000");
        double aa = 55;
        String bb = df.format(aa);
        System.out.println(bb);


    }

}
