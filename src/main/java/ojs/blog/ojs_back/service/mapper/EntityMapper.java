package ojs.blog.ojs_back.service.mapper;


import ojs.blog.ojs_back.service.dto.AbstractAuditingDTO;
import ojs.blog.ojs_back.util.TsidUtil;
import org.mapstruct.*;
import org.springframework.util.StringUtils;

import java.util.List;

public interface EntityMapper<DTO, ENT> {
    ENT toEntity(DTO dto);

    DTO toDto(ENT entity);

    List<ENT> toEntity(List<DTO> dtoList);

    List<DTO> toDto(List<ENT> entityList);


}
