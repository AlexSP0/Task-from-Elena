package com.company.day1;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class TimeGreetingsFromInet {
    private Calendar currentDate1;
    private Date currentDate;

    public TimeGreetingsFromInet () throws IOException, ParseException {
        updateTime();
    }
    public void printGreetingFromInet () {

    }
    private void updateTime () throws IOException, ParseException {
        String url = "http://worldtimeapi.org/api/Etc/GMT+4";

        HttpURLConnection myConnection = (HttpURLConnection) new URL(url).openConnection();
        myConnection.setRequestMethod("GET");
        myConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
        String inputLine;
        StringBuilder strBuffer = new StringBuilder();
        while((inputLine = bufReader.readLine()) != null) {
            strBuffer.append(inputLine);
        }
        System.out.println(strBuffer);
        System.out.println("************************конец ответа сервера **********************");
        JSONObject myJsonObj = (JSONObject) new JSONParser().parse(String.valueOf(strBuffer));
        System.out.println("Unixtime:" + myJsonObj.get("unixtime"));
        long ut = (long) myJsonObj.get("unixtime") * 1000;
        currentDate = new Date(ut);
        System.out.println("текущее время: " + currentDate.toString());

    }
}
