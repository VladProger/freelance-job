package com.jobfreelance.controller;

import com.jobfreelance.dto.CommentDto;
import com.jobfreelance.entity.CommentEntity;
import com.jobfreelance.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("create")
    public CommentEntity createComment(@RequestBody @Valid CommentDto commentDto){
        return commentService.createComment(commentDto);
    }

    @GetMapping("{uuid}")
    public CommentDto getById(@PathVariable UUID uuid){
        return commentService.getComment(uuid.toString());
    }
}
