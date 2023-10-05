package ojs.blog.ojs_back.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ojs.blog.ojs_back.domain.UserMaster;
import ojs.blog.ojs_back.service.dto.UserMasterDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-06T00:28:30+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserMasterMapperImpl implements UserMasterMapper {

    @Override
    public UserMaster toEntity(UserMasterDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserMaster userMaster = new UserMaster();

        return userMaster;
    }

    @Override
    public UserMasterDTO toDto(UserMaster entity) {
        if ( entity == null ) {
            return null;
        }

        UserMasterDTO userMasterDTO = new UserMasterDTO();

        userMasterDTO.setId( entity.getId() );

        return userMasterDTO;
    }

    @Override
    public List<UserMaster> toEntity(List<UserMasterDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<UserMaster> list = new ArrayList<UserMaster>( dtoList.size() );
        for ( UserMasterDTO userMasterDTO : dtoList ) {
            list.add( toEntity( userMasterDTO ) );
        }

        return list;
    }

    @Override
    public List<UserMasterDTO> toDto(List<UserMaster> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserMasterDTO> list = new ArrayList<UserMasterDTO>( entityList.size() );
        for ( UserMaster userMaster : entityList ) {
            list.add( toDto( userMaster ) );
        }

        return list;
    }
}
