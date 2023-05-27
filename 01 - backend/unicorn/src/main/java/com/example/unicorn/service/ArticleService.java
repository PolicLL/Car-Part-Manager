package com.example.unicorn.service;

import com.example.unicorn.dao.ArticleRepository;
import com.example.unicorn.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public void saveArticle(ArticleEntity articleEntity) {
        articleRepository.save(articleEntity);
    }

    public Iterable<ArticleEntity> getArticles() {
        return articleRepository.findAll();
    }

    public ArticleEntity getArticleById(Long id) {
        Optional<ArticleEntity> tempArticle = articleRepository.findById(id);
        return tempArticle.orElseGet(ArticleEntity::new);
    }

    public void updateArticle(ArticleEntity articleEntity) {
        articleRepository.save(articleEntity);
    }

    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);
    }
}
