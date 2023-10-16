package ojs.blog.ojs_back.service.mapper;

import ojs.blog.ojs_back.domain.UserMaster;
import ojs.blog.ojs_back.service.dto.UserMasterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


/**
 * Mapper for the entity {@link UserMaster} and its DTO {@link UserMasterDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMasterMapper extends EntityMapper<UserMasterDTO, UserMaster>{//

    @Override
    UserMasterDTO toDto(UserMaster entity);
}
