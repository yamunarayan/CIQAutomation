package org.ciq.utils;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.Arrays;

public class RunTestNGXML {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        ArrayList<String> suites = new ArrayList<>();
        suites.add("testng.xml");
        testNG.setTestSuites(suites);
        testNG.setGroups(System.getProperty("groups"));
        testNG.run();
    }
}
