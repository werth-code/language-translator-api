package com.werth.translatorapp.model;


public class TextTranslation {
    private String text;

    public TextTranslation(String text) {
        this.text = text;
    }

    public TextTranslation() {}

    @Override
    public String toString() {
        return "TextTranslation{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
