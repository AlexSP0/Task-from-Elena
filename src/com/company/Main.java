package com.company;

import com.company.day1.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        TimeGreetings tm = new TimeGreetings("Alexey", true);
        tm.printGreetings();
    }
}
