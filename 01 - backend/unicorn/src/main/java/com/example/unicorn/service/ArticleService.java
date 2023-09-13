package com.example.unicorn.service;

import com.example.unicorn.dao.ArticleRepository;
import com.example.unicorn.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ArticleService {

    void saveArticle(ArticleEntity articleEntity);

    Iterable<ArticleEntity> getArticles();

    ArticleEntity getArticleById(Long id);

    void updateArticle(ArticleEntity articleEntity);

    void deleteArticleById(Long id);
}