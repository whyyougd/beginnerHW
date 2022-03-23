package com.sparta.beginnerhw.service;

import com.sparta.beginnerhw.domain.Blog;
import com.sparta.beginnerhw.domain.BlogRepository;
import com.sparta.beginnerhw.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디 존재 X")
        );
        blog.update(requestDto);
        return blog.getId();
    }
}
