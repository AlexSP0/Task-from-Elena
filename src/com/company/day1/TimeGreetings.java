package com.company.day1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

 public class TimeGreetings {
    private Calendar currentDate;
    private String userName;
    private boolean isGetTimeFromInet;

    public TimeGreetings (String userName, boolean flag) throws IOException, ParseException {
        this.userName = userName;
        this.isGetTimeFromInet = flag;
        updateTime();
    }

    //Получает текущее время, если flag = false, то время системное
    //если flag = true, то время из инета по адресу http://worldtimeapi.org/api/Etc/GMT+4
    public void updateTime() throws IOException, ParseException {
        currentDate = Calendar.getInstance();
        if(!isGetTimeFromInet) {
            currentDate = Calendar.getInstance(); // получаем текущую дату из системы
        } else { //получаем текущую дату из инета
            String url = "http://worldtimeapi.org/api/Etc/GMT+4"; //откуда берем дату и время
            HttpURLConnection myConnection = (HttpURLConnection) new URL(url).openConnection();
            myConnection.setRequestMethod("GET");
            myConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
            String inputLine;
            StringBuilder strBuffer = new StringBuilder();
            while((inputLine = bufReader.readLine()) != null) {
                strBuffer.append(inputLine);
            }
            JSONObject myJsonObj = (JSONObject) new JSONParser().parse(String.valueOf(strBuffer));
            long ut = (long) myJsonObj.get("unixtime") * 1000;
            currentDate.setTimeInMillis(ut*1000);
        }
    }
    public void printGreetings() throws IOException, ParseException {
        updateTime();
        int hours = currentDate.get(Calendar.HOUR_OF_DAY);
        if(hours >= 0 && hours <=4) {
            System.out.println("Доброй ночи, " + userName);
        } else if(hours >=5 && hours<=9) {
            System.out.println("Доброе утро, " + userName);
        } else if (hours >=10 && hours <=16) {
            System.out.println("Добрый день, " + userName);
        } else {
            System.out.println("Добрый вечер, " + userName);
        }
    }

}
