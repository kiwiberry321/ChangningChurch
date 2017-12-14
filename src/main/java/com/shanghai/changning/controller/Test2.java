package com.shanghai.changning.controller;

import com.shanghai.changning.vo.User;

public class Test2 {
    public static void main(String[] args) {

        char a = (char)70000;
        System.out.println(a);
        int[] key = new int[5];
        System.out.println(key.length);
        System.out.println(key[4]);
        key = new int[]{3, 4, 5, 6, 7,8};
        System.out.println(key[5]);
        User[] test = new User[4];
        for (int i = 0; i < test.length; i++) {
            test[i] = new User();
            System.out.println(test[i].getPasswd());
        }

        int key1[];

//        final Test test = new Test();
//        for(int i=0;i<10;i++){
//            new Thread(){
//                public void run() {
//                    for(int j=0;j<1000;j++)
//                        test.increase();
//                };
//            }.start();
//        }
//
//        while(Thread.activeCount()>1)  //保证前面的线程都执行完
//            Thread.yield();
//        System.out.println(test.inc);
    }
}
