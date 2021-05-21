package com.werth.translatorapp.service;

import com.werth.translatorapp.model.TextTranslation;
import com.werth.translatorapp.repo.TextTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


@Service
public class Translator {

    @Autowired
    TextTranslationRepository textTranslationRepository;

    //` String url = "script.google.com/macros/s/AKf****xhI/exec?q=" + URLEncoder.encode(text, "UTF-8") + "&target=" + this.to + "&source=" + this.from; String translatedText = restTemplate.getForObject(url, String.class);`

    public static void main(String[] args) throws IOException {
        String text = "Whoever dwells in the shelter of the Most High will rest in the shadow of the Almighty." +
                " 2 I will say of the Lord, “He is my refuge and my fortress, my God, in whom I trust.";

        System.out.println("English Text: \n" + text + "\n" + "\nTranslated Text: \n" + translate("en", "ko", text));
    }

    public static String translate(String langFrom, String langTo, String text) throws IOException {

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

//    public String upload(MultipartFile file, Model model) {
//
//        if (fileIsEmpty(file)) {
//            model.addAttribute("message", "Please select a CSV file to upload.");
//            model.addAttribute("status", false);
//        }
//        else parseCSV(file, model);
//        return "file-upload-status";
//    }
//
//    public boolean fileIsEmpty(MultipartFile file) {
//        return file.isEmpty();
//    }
//
//    public List<TextTranslation> translateText(String text, Model model) {
//        try (
//                String translation
//                TextTranslation textTranslation = new TextTranslation(text)
//
//            // convert `CsvToBean` object to list of users
//
//            // save users list on model
//            model.addAttribute("users", users);
//            model.addAttribute("status", true);
//
//            // save to database
//            saveUsers(users);
//            users.forEach(System.out::println);
//            return users;
//
//        } catch (Exception ex) {
//            model.addAttribute("message", "An error occurred while processing the CSV file.");
//            model.addAttribute("status", false);
//            return null;
//        }
//    }
//
//    public Iterable<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    private void saveUsers(List<User> users) {
//        userRepository.saveAll(users);
//    }

}