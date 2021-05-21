package com.werth.translatorapp.model;
import com.werth.translatorapp.service.Translator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;

@Entity
public class TextTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String originalText;
    private String translatedText;
    private String originalLanguage;
    private String translatedLanguage;

    public TextTranslation() {}

    public TextTranslation(long id, String originalText, String originalLanguage, String translatedLanguage) throws IOException {
        this.id = id;
        this.originalText = originalText;
        this.originalLanguage = originalLanguage;
        this.translatedLanguage = translatedLanguage;
        this.translatedText = Translator.translate(originalLanguage, translatedLanguage, originalText);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTranslatedLanguage() {
        return translatedLanguage;
    }

    public void setTranslatedLanguage(String translatedLanguage) {
        this.translatedLanguage = translatedLanguage;
    }

    @Override
    public String toString() {
        return "TextTranslation{" +
                "id=" + id +
                ", originalText='" + originalText + '\'' +
                ", translatedText='" + translatedText + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", translatedLanguage='" + translatedLanguage + '\'' +
                '}';
    }
}
