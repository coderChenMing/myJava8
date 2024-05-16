package com.learn.java8.base.str.replace_more;

import org.apache.commons.lang.StringUtils;

import java.util.Map;


public class StrReplaceTest {
    private String testStringUtils(final String text, final Map<String, String> definitions ) {
        final String[] keys = keys( definitions );
        final String[] values = values( definitions );

        return StringUtils.replaceEach( text, keys, values );
    }

    private String[] keys(Map<String, String> definitions) {
        return definitions.keySet().toArray(new String[0]);
    }

    private String[] values(Map<String, String> definitions) {
        return definitions.keySet().toArray(new String[0]);
    }

    public static void main(String[] args) {

        //StringUtils.test
    }
}
