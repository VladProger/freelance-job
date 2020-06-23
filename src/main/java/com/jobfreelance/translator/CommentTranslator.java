package com.jobfreelance.translator;

import com.jobfreelance.dto.CommentDto;
import com.jobfreelance.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentTranslator {

    public CommentEntity translateDtoToEntity(CommentDto dto) {
        return new CommentEntity(dto.getText(), dto.getCustomerUuid(), dto.getIsAnonym(),
                dto.getExecutorId(), dto.getCreatedOn());
    }

    public CommentDto translateEntityToDto(CommentEntity entity) {
        return new CommentDto(entity.getText(), entity.getCustomerUuid(), entity.getIsAnonym(),
                entity.getExecutorId(), entity.getCreatedOn());
    }
}
