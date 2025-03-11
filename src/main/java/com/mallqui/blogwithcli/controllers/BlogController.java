package com.mallqui.blogwithcli.controllers;

import com.mallqui.blogwithcli.dto.BlogDto;
import com.mallqui.blogwithcli.repositories.BlogRepository;
import com.mallqui.blogwithcli.services.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService, BlogRepository blogRepository) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogDto> registerBlog(@Valid @RequestBody BlogDto blogDto) {
        BlogDto newBlog = blogService.registerBlog(blogDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBlog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable Long id) {
        Optional<BlogDto> blogDto = blogService.getBlogById(id);
        return blogDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        List<BlogDto> blogDtos = blogService.getAllBlogs();
        return ResponseEntity.ok(blogDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogById(@PathVariable Long id) {
        blogService.deleteBlogById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDto> updateBlog(@PathVariable Long id, @RequestBody @Valid BlogDto blogDto){
        BlogDto blogUpdated = blogService.updateBlog(id, blogDto);
        return ResponseEntity.ok(blogUpdated);
    }



}
