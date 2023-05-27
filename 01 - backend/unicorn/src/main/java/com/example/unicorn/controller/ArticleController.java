package com.example.unicorn.controller;

import com.example.unicorn.entity.ArticleEntity;
import com.example.unicorn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public void saveArticle(@RequestBody ArticleEntity articleEntity) {
        articleService.saveArticle(articleEntity);
    }

    @GetMapping
    public Iterable<ArticleEntity> getArticles() {
        return articleService.getArticles();
    }

    @GetMapping("/{id}")
    public ArticleEntity getArticle(@PathVariable(value = "id") Long id) {
        return articleService.getArticleById(id);
    }

    @PostMapping("/update")
    public void updateArticle(@RequestBody ArticleEntity articleEntity) {
        articleService.updateArticle(articleEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticle(@PathVariable(value = "id") Long id) {
        articleService.deleteArticleById(id);
    }
}
