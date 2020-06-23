package com.jobfreelance.service;

import com.jobfreelance.dto.CommentDto;
import com.jobfreelance.entity.CommentEntity;
import com.jobfreelance.repository.CommentRepository;
import com.jobfreelance.translator.CommentTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentTranslator commentTranslator;

    public CommentEntity createComment(CommentDto commentDto) {
        commentDto.setCreatedOn(Timestamp.from(Instant.now()));
        return commentRepository.save(commentTranslator.translateDtoToEntity(commentDto));
    }

    public CommentDto getComment(String ucdmId){
        CommentEntity entity = commentRepository.findByCustomerUuid(ucdmId);
        CommentDto dto = commentTranslator.translateEntityToDto(entity);
        if(dto.getIsAnonym())
            dto.setCustomerUuid(null);
        return dto;
    }
}
