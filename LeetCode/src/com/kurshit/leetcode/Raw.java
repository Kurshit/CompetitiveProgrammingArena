package com.kurshit.leetcode;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

public class Raw {



    public static void main(String[] args) {

        Raw r = new Raw();

        r.printMe(null);


    }

    public void printMe(String s) {
        System.out.println("String " + s);
    }


    public void printMe(Object i) {
        System.out.println("Integer  " + i);
    }



}
