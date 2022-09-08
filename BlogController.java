package com.example.blogsystem.controller;

import com.example.blogsystem.dto.ApiDto;
import com.example.blogsystem.exception.ApiException;
import com.example.blogsystem.model.Blog;
import com.example.blogsystem.repository.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
@CrossOrigin(origins = "*")
public class BlogController {

    private final BlogRepository blogRepository;

    @GetMapping
    public ResponseEntity getBlogs(){
        return ResponseEntity.status(200).body(blogRepository.findAll());
    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody @Valid Blog blog){
        blogRepository.save(blog);
        return ResponseEntity.status(201).body(new ApiDto("New blog added !",201));
    }

    @GetMapping("/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        Blog blog=blogRepository.findById(id).get();
        return ResponseEntity.status(200).body(blog);
    }


}