package com.hspedu;


import org.omg.SendingContext.RunTime;

public class CupNum {
    public static void main(String[] args) {
        Runtime runTime = Runtime.getRuntime();
        int cupNums = runTime.availableProcessors();
        System.out.println(cupNums);


    }
}
