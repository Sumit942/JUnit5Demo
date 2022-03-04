package com.example.demo;

public class StringHelper {

    public String removeAFromFirstPosition(String str) {

        if (str.length() <= 2)
            return str.replaceAll("A","");

        String first2Chars = str.substring(0,2);
        String strMinusFirst2Chars = str.substring(2);

        return first2Chars.replaceAll("A","").concat(strMinusFirst2Chars);
    }
}
