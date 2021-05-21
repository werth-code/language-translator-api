package com.werth.translatorapp.repo;

import com.werth.translatorapp.model.TextTranslation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextTranslationRepository extends JpaRepository<TextTranslation, Long> {
}
