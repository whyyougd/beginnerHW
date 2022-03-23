package com.sparta.beginnerhw.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByModifiedAtDesc();

//    List<Blog> findAllById();
}
