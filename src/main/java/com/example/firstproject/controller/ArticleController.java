package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired //미리 생성해 놓은 repository객체 주입
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        //System.out.println(form.toString());

        //1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());

        //2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "redirect:/articles/" + saved.getId();//redirect
    }//createArticle end
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("Id = " + id);

        //1. id를 조회해서 데이터를 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);//id 값이 없으면 null 넣음
        //2. model에 데이터 저장
        model.addAttribute("article", articleEntity);
        return "articles/show";
    }//show end
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("Id = " + id);
        //1. id를 조회해서 데이터를 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);//id 값이 없으면 null 넣음
        //2. model에 데이터 저장
        model.addAttribute("article", articleEntity);
        return "articles/show";
    }//show end
    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        // 3. 뷰 페이지 설정하기
        return "articles/index";
    }
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }
    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        log.info(form.toString());
        Article articleEntity = form.toEntity();

}
    
