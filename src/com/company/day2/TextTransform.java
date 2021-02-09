package com.company.day2;

import org.json.simple.JSONObject;

public class TextTransform {
    private String strToTransform;
    private int maxLength;
    private String[] forbiddenWords;

    public TextTransform (String str, int maxLength, String[] forbiddenWords) {
        strToTransform = str;
        this.maxLength = maxLength;
        this.forbiddenWords = forbiddenWords;
    }
    public int countChars() { //возвращаем длину строки
        return strToTransform.length();
    }

    public int countCharsWithoutSpaces() { //возвращаем длину строки без пробелов
        int spaces=0;
        for (int i = 0; i < strToTransform.length(); i++) {
            if(strToTransform.charAt(i) == ' ') { spaces++;}
        }
        return strToTransform.length() - spaces;
    }

    public void isEven() { //печатаем, четное или нечетное число символов
        if (strToTransform.length() % 2 == 0) {
            System.out.println("Количество символов в строке четное.");
        } else {
            System.out.println("Количество символов в строке НЕчетное.");
        }
    }

    public void isLongerThanChars(int num) { // Определяем, длиннее ли строка чем num символов?
        if(strToTransform.length() > num) {
            System.out.println("Длина строки больше чем, " + num + " символов.");
        }
    }

    public String getPureText() { //заменяем запрещенные слова на три *
        String[] str = new String[forbiddenWords.length+1];
        str[0] = new String(strToTransform);
        for (int i = 1; i < forbiddenWords.length+1; i++) {
            str[i] = new String((str[i-1].replaceAll(forbiddenWords[i-1],"***")));
        }
        return str[str.length-1];
    }
    public String getShortPureText(int size) { //ОБрезаем текст без запрещенных слов до size и добавляем ...
        if(getPureText().length()>size){
            StringBuilder st =  new StringBuilder(getPureText().substring(0,size)+"...");
            return st.toString();
        } else {
            return getPureText();
        }
    }

    public JSONObject getJSON() { //Создаем JSON объект
        JSONObject myJson = new JSONObject();
        myJson.put("length", strToTransform.length());
        myJson.put("pure_length", countCharsWithoutSpaces());
        myJson.put("origin_text", strToTransform);
        myJson.put("pure_text", getPureText());
        myJson.put("pure_short_text", getShortPureText(maxLength));
        return myJson;
    }

}
