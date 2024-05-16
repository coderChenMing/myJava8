package com.learn.java8.curl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<String> command = new ArrayList<>();
        command.add("curl");
        command.add("-X");
        command.add("GET");
        command.add("https://www.baidu.com");

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        int exitCode = process.waitFor();
        System.out.println("Exited with error code: " + exitCode);
    }
}
