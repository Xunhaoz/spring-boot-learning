package com.walnutek.healthcareapi.controller;

import com.walnutek.healthcareapi.model.vo.PostVo;
import com.walnutek.healthcareapi.model.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.Map;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Operation(summary = "測試")
    @GetMapping("/test")
    public String testing() {
        return "Hello World";
    }

    @Operation(summary = "取得貼文")
    @GetMapping("/{id}")
    public PostVo getPost(@Parameter(description = "貼文ID") @PathVariable("id") Integer id) {
        return postService.getDetail(id);
    }

    @Operation(summary = "新增貼文")
    @PostMapping
    public void post(@RequestBody PostVo postVo) {
        postService.post(postVo);
    }

    @Operation(summary = "修改貼文")
    @PutMapping("/{id}")
    public void put(@Parameter(description = "貼文ID") @PathVariable("id") Integer id, @RequestBody PostVo postVo) {
        postService.put(id, postVo);
    }

    @Operation(summary = "刪除貼文")
    @DeleteMapping("/{id}")
    public void delete(@Parameter(description = "貼文ID") @PathVariable("id") Integer id) {
        postService.delete(id);
    }
}
