package com.company;

import com.company.day2.TextTransform;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args)  {
        //День третий, задача №1
        String[] str = {"apple banana", "orange", "banana", "kiwi strawberry blueberry"};
        getWords(str, " ");
        //День третий, задача №2
        String str2 = "Ну что ж я, я найти решения правильного не смогу ж? Смогу ж конечно, я ж старательный все ж таки.";
        getStopWordsInJson(str2,3);

    }
    public static JSONObject getStopWordsInJson(String str, int frequency) {
        HashMap<String, Integer> allWords = getWordFrequency(str); //получаем частоту слов в хешмапе
        HashMap<String, Integer> stopWords = getStopWords(allWords, frequency);
        JSONObject myJson = new JSONObject();
        for (Map.Entry<String, Integer> word: stopWords.entrySet()) {
            myJson.put(word.getKey(), word.getValue());
        }
        return myJson;
    }
    public static HashMap<String, Integer> getWordFrequency(String str) { //Получаем в hashmap частоту слов, где ключ - слово, значение - количество вхождений типа Integer
        HashMap<String, Integer> map = new HashMap<>();
        String[] buff = getWords(str.split(" "), "[!?;,. ]");
        for (int i = 0; i < buff.length; i++) {
            buff[i].toLowerCase();
            if(map.containsKey(buff[i])){ //такой ключ
                map.put(buff[i], map.get(buff[i])+1);
            } else {
                map.put(buff[i], 1);
            }
        }
        return map;
    }
    public static HashMap<String, Integer> getStopWords(HashMap<String, Integer> map, int frequency) { //возвращает hashmap слов c заданной частотой
        HashMap<String, Integer> stopWordsMap = new HashMap<>();
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            if(e.getValue()>=frequency) {
                stopWordsMap.put(e.getKey(),e.getValue());
            }
        }
        return stopWordsMap;
    }
    public static String[] getWords(String[] str, String sp) { //возвращаем массив слов из массива строк!
        //День третий задача 1
        ArrayList<String> list = new ArrayList<>();
        String[] buff;
        for (int i = 0; i < str.length; i++) {
            buff = str[i].split(sp);
            if(buff.length!=0) {
                for (int j = 0; j < buff.length; j++) {
                    list.add(buff[j]);
                }
            }
        }
        return list.toArray(list.toArray(new String[0]));
    }
}
