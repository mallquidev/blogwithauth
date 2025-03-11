package com.mallqui.blogwithcli.services;

import com.mallqui.blogwithcli.dto.BlogDto;
import com.mallqui.blogwithcli.entities.Blog;
import com.mallqui.blogwithcli.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired //inyectamos la dependencias
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    //registrar blog
    public BlogDto registerBlog(BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());

        Blog blogSaved = blogRepository.save(blog);
        return new BlogDto(blogSaved.getTitle(), blogSaved.getContent());
    }

    //buscar blog por id
    public Optional<BlogDto> getBlogById(Long id){
        return blogRepository.findById(id)
                .map(blog -> new BlogDto(blog.getTitle(), blog.getContent()));
    }

    //listar todo los blogs
    public List<BlogDto> getAllBlogs() {
        return blogRepository.findAll().stream()
                .map(blog -> new BlogDto(blog.getTitle(), blog.getContent()))
                .collect(Collectors.toList());
    }

    //eliminar blog por id
    public void deleteBlogById(Long id){
        if(!blogRepository.existsById(id)){
            throw new IllegalStateException("El usuario con id + "+ id + " no existe en la base de datos");
        }
        blogRepository.deleteById(id);
    }

    //actualizar blog por id
    public BlogDto updateBlog(Long id, BlogDto blogDto) {
        //verificamos si existe un blog con ese id
        Blog blog = blogRepository.findById(id)
                .orElseThrow(()->new IllegalStateException("El usuario con id " + id + " no existe en la base datos"));

        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        Blog blogUpdated = blogRepository.save(blog);

        return new BlogDto(blogUpdated.getTitle(), blogUpdated.getContent());
    }

}
