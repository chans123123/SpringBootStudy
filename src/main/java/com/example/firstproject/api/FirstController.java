package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstApiController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }//index end
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }// show end
   @PostMapping("/api/articles")
   public Article create(@RequestBody ArticleForm articleForm) {
       Article article = articleForm.toEntity();
       return articleRepository.save(article);
   }//create end
