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
    date = "2023-10-04T23:10:22+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserMasterMapperImpl implements UserMasterMapper {

    @Override
    public UserMaster toEntity(UserMasterDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserMaster userMaster = new UserMaster();

        userMaster.setCreateBy( arg0.getCreateBy() );
        if ( arg0.getCreateDate() != null ) {
            userMaster.setCreateDate( Instant.parse( arg0.getCreateDate() ) );
        }
        userMaster.setUpdateBy( arg0.getUpdateBy() );
        if ( arg0.getUpdateDate() != null ) {
            userMaster.setUpdateDate( Instant.parse( arg0.getUpdateDate() ) );
        }
        userMaster.setId( arg0.getId() );
        userMaster.setUserName( arg0.getUserName() );
        userMaster.setUserPassword( arg0.getUserPassword() );
        userMaster.setUserAge( arg0.getUserAge() );
        userMaster.setUserEmail( arg0.getUserEmail() );
        userMaster.setCompanyPosition( arg0.getCompanyPosition() );
        userMaster.setUserPhoneNumber( arg0.getUserPhoneNumber() );
        userMaster.setUserAddress( arg0.getUserAddress() );
        userMaster.setItemOneName( arg0.getItemOneName() );
        userMaster.setItemOneSerialInfo( arg0.getItemOneSerialInfo() );
        userMaster.setItemTwoName( arg0.getItemTwoName() );
        userMaster.setItemTwoSerialInfo( arg0.getItemTwoSerialInfo() );
        userMaster.setItemThreeName( arg0.getItemThreeName() );
        userMaster.setItemThreeSerialInfo( arg0.getItemThreeSerialInfo() );

        return userMaster;
    }

    @Override
    public UserMasterDTO toDto(UserMaster arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserMasterDTO.UserMasterDTOBuilder userMasterDTO = UserMasterDTO.builder();

        userMasterDTO.id( arg0.getId() );
        userMasterDTO.userName( arg0.getUserName() );
        userMasterDTO.userPassword( arg0.getUserPassword() );
        userMasterDTO.userAge( arg0.getUserAge() );
        userMasterDTO.userEmail( arg0.getUserEmail() );
        userMasterDTO.companyPosition( arg0.getCompanyPosition() );
        userMasterDTO.userPhoneNumber( arg0.getUserPhoneNumber() );
        userMasterDTO.userAddress( arg0.getUserAddress() );
        userMasterDTO.itemOneName( arg0.getItemOneName() );
        userMasterDTO.itemOneSerialInfo( arg0.getItemOneSerialInfo() );
        userMasterDTO.itemTwoName( arg0.getItemTwoName() );
        userMasterDTO.itemTwoSerialInfo( arg0.getItemTwoSerialInfo() );
        userMasterDTO.itemThreeName( arg0.getItemThreeName() );
        userMasterDTO.itemThreeSerialInfo( arg0.getItemThreeSerialInfo() );
        if ( arg0.getCreateDate() != null ) {
            userMasterDTO.createDate( arg0.getCreateDate().toString() );
        }
        userMasterDTO.createBy( arg0.getCreateBy() );
        if ( arg0.getUpdateDate() != null ) {
            userMasterDTO.updateDate( arg0.getUpdateDate().toString() );
        }
        userMasterDTO.updateBy( arg0.getUpdateBy() );

        return userMasterDTO.build();
    }

    @Override
    public List<UserMaster> toEntity(List<UserMasterDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<UserMaster> list = new ArrayList<UserMaster>( arg0.size() );
        for ( UserMasterDTO userMasterDTO : arg0 ) {
            list.add( toEntity( userMasterDTO ) );
        }

        return list;
    }

    @Override
    public List<UserMasterDTO> toDto(List<UserMaster> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<UserMasterDTO> list = new ArrayList<UserMasterDTO>( arg0.size() );
        for ( UserMaster userMaster : arg0 ) {
            list.add( toDto( userMaster ) );
        }

        return list;
    }
}
