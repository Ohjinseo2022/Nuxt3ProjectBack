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

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);

    @BeforeMapping
    default void generateId(D d) {
        if(d == null) return;

        if(d instanceof AbstractAuditingDTO<?>) {
            AbstractAuditingDTO abstractAuditingDTO = (AbstractAuditingDTO)d;

            if(abstractAuditingDTO.getId() == null || !StringUtils.hasText(abstractAuditingDTO.getId().toString())) {
                abstractAuditingDTO.setId(TsidUtil.TSID_FACTORY.create().toString());
            }
        }
    }
}
