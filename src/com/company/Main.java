package com.company;

import com.company.day2.TextTransform;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        String[] forbiddenWords = {"волшебники", "Гарри Поттер"};
        TextTransform txt = new TextTransform("Не забывайте о том, что все великие волшебники в истории в свое время были такими же, как мы, – школьниками. Если у них получилось, то получится и у нас», – Гарри Поттер.", 10, forbiddenWords);
        //Day 2 task 1
        System.out.println(txt.countChars());
        System.out.println(txt.countCharsWithoutSpaces());
        txt.isEven();
        txt.isLongerThanChars(12);
        //Day 2 task 2
        System.out.println(txt.getPureText());
        System.out.println(txt.getShortPureText(19));
        JSONObject obj = txt.getJSON();
    }
}
