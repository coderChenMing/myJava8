package com.learn.java8.regex;

import java.net.MalformedURLException;
import java.net.URL;

public class TestUrl3 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.xxxyyyyy.wang");

        String domainName = url.getHost();
        System.out.println(domainName);
        int num=domainName.lastIndexOf(".");
        if(num>0) {
            domainName = domainName.substring(num);
        }
        System.out.println(domainName);
    }
}
