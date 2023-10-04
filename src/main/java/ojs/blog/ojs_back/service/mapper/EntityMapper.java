package ojs.blog.ojs_back.service.mapper;


import ojs.blog.ojs_back.service.dto.AbstractAuditingDTO;
import ojs.blog.ojs_back.util.TsidUtil;
import org.mapstruct.*;
import org.springframework.util.StringUtils;

import java.util.List;

public interface EntityMapper<D, E> {
    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

///////
}
