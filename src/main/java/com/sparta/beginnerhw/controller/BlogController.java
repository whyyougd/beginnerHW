package com.sparta.beginnerhw.controller;

import com.sparta.beginnerhw.domain.Blog;
import com.sparta.beginnerhw.domain.BlogRepository;
import com.sparta.beginnerhw.domain.BlogRequestDto;
import com.sparta.beginnerhw.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;


@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto){
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @GetMapping("/api/blogs")
    public List<Blog> getMemo(){
//        LocalDateTime start = LocalDateTime.now().minusDays(1);
//        LocalDateTime end = LocalDateTime.now();
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id){
        blogRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        blogService.update(id,requestDto);
        return id;
    }
//
//    @GetMapping("/api/blogs/{id}")
//    public List<Blog> getPost(@PathVariable Long id){
//        return blogRepository.findAllById();
//    }
//    @GetMapping("/board/{id}")
//    public ModelAndView boardView(@PathVariable long id){
//        Optional<Board> boardDto = bs.findOne(id);
//        ModelAndView mav= new ModelAndView("view");
//        mav.addObject("boardOne",boardDto.get());
//        mav.addObject("index",id);
//        //optional 에 저장된 값에 접근 할 수 있는 get() 메서드
//        return mav;
//
//    }
    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
}
