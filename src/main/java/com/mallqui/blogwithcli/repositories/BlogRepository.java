package com.mallqui.blogwithcli.repositories;

import com.mallqui.blogwithcli.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
