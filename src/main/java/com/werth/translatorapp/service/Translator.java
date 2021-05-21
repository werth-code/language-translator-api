package com.werth.translatorapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {

    //` String url = "script.google.com/macros/s/AKf****xhI/exec?q=" + URLEncoder.encode(text, "UTF-8") + "&target=" + this.to + "&source=" + this.from; String translatedText = restTemplate.getForObject(url, String.class);`

    public static void main(String[] args) throws IOException {
        String text = "\nWhoever dwells in the shelter of the Most High will rest in the shadow of the Almighty." +
                " 2 I will say of the Lord, “He is my refuge and my fortress, my God, in whom I trust.";

        System.out.println("English Text: " + text + "\n" + "\nTranslated Text: \n" + translate("en", "es", text));
    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {

        String urlStr = "https://script.google.com/macros/s/AKfycbwHNtLIpIyJZvSv683eDHzvn_Y5lOAKRgIa6FSM/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}