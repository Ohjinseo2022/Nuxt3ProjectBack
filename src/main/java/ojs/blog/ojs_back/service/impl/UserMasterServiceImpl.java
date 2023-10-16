package ojs.blog.ojs_back.service.impl;

import ojs.blog.ojs_back.domain.UserMaster;
import ojs.blog.ojs_back.repository.UserMasterRepository;
import ojs.blog.ojs_back.service.UserMasterService;
import ojs.blog.ojs_back.service.dto.UserMasterDTO;
import ojs.blog.ojs_back.service.mapper.UserMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserMaster}.
 */
@Service
@Transactional
public class UserMasterServiceImpl implements UserMasterService {
    private final Logger log = LoggerFactory.getLogger(UserMasterServiceImpl.class);


    private final UserMasterRepository userMasterRepository;
    private final UserMasterMapper userMasterMapper;

    public UserMasterServiceImpl(UserMasterRepository userMasterRepository, UserMasterMapper userMasterMapper){
        this.userMasterRepository = userMasterRepository;
        this.userMasterMapper = userMasterMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserMasters");
        //Page<UserMaster> userList = userMasterRepository.findAll(pageable);
        //Page<UserMasterDTO> userDtoList = userMasterMapper.toDto(userList);

        //return userDtoList;
        return userMasterRepository.findAll(pageable).map(userMasterMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserMasterDTO> findOne(String id)
    {
        log.debug("Request to get CompanyMaster : {}", id);
        Optional<UserMasterDTO> userMasterDTO = userMasterRepository.findById(id).map(userMasterMapper::toDto);
        return userMasterDTO;
    }

    @Override
    public UserMasterDTO save(UserMasterDTO userMasterDTO){
        UserMaster userMaster = userMasterMapper.toEntity(userMasterDTO);
        userMaster = userMasterRepository.save(userMaster);
        return userMasterMapper.toDto(userMaster);
    }

}
