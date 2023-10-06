package ojs.blog.ojs_back.service.mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ojs.blog.ojs_back.domain.UserMaster;
import ojs.blog.ojs_back.service.dto.UserMasterDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-07T00:26:00+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserMasterMapperImpl implements UserMasterMapper {

    @Override
    public UserMaster toEntity(UserMasterDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserMaster userMaster = new UserMaster();

        userMaster.setCreateBy( dto.getCreateBy() );
        if ( dto.getCreateDate() != null ) {
            userMaster.setCreateDate( Instant.parse( dto.getCreateDate() ) );
        }
        userMaster.setUpdateBy( dto.getUpdateBy() );
        if ( dto.getUpdateDate() != null ) {
            userMaster.setUpdateDate( Instant.parse( dto.getUpdateDate() ) );
        }
        userMaster.setId( dto.getId() );
        userMaster.setUserName( dto.getUserName() );
        userMaster.setUserPassword( dto.getUserPassword() );
        userMaster.setUserAge( dto.getUserAge() );
        userMaster.setUserEmail( dto.getUserEmail() );
        userMaster.setCompanyPosition( dto.getCompanyPosition() );
        userMaster.setUserPhoneNumber( dto.getUserPhoneNumber() );
        userMaster.setUserAddress( dto.getUserAddress() );
        userMaster.setItemOneName( dto.getItemOneName() );
        userMaster.setItemOneSerialInfo( dto.getItemOneSerialInfo() );
        userMaster.setItemTwoName( dto.getItemTwoName() );
        userMaster.setItemTwoSerialInfo( dto.getItemTwoSerialInfo() );
        userMaster.setItemThreeName( dto.getItemThreeName() );
        userMaster.setItemThreeSerialInfo( dto.getItemThreeSerialInfo() );

        return userMaster;
    }

    @Override
    public UserMasterDTO toDto(UserMaster entity) {
        if ( entity == null ) {
            return null;
        }

        UserMasterDTO.UserMasterDTOBuilder userMasterDTO = UserMasterDTO.builder();

        userMasterDTO.id( entity.getId() );
        userMasterDTO.userName( entity.getUserName() );
        userMasterDTO.userPassword( entity.getUserPassword() );
        userMasterDTO.userAge( entity.getUserAge() );
        userMasterDTO.userEmail( entity.getUserEmail() );
        userMasterDTO.companyPosition( entity.getCompanyPosition() );
        userMasterDTO.userPhoneNumber( entity.getUserPhoneNumber() );
        userMasterDTO.userAddress( entity.getUserAddress() );
        userMasterDTO.itemOneName( entity.getItemOneName() );
        userMasterDTO.itemOneSerialInfo( entity.getItemOneSerialInfo() );
        userMasterDTO.itemTwoName( entity.getItemTwoName() );
        userMasterDTO.itemTwoSerialInfo( entity.getItemTwoSerialInfo() );
        userMasterDTO.itemThreeName( entity.getItemThreeName() );
        userMasterDTO.itemThreeSerialInfo( entity.getItemThreeSerialInfo() );
        if ( entity.getCreateDate() != null ) {
            userMasterDTO.createDate( entity.getCreateDate().toString() );
        }
        userMasterDTO.createBy( entity.getCreateBy() );
        if ( entity.getUpdateDate() != null ) {
            userMasterDTO.updateDate( entity.getUpdateDate().toString() );
        }
        userMasterDTO.updateBy( entity.getUpdateBy() );

        return userMasterDTO.build();
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
