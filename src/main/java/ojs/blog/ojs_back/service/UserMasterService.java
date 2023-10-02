package ojs.blog.ojs_back.service;

import ojs.blog.ojs_back.domain.UserMaster;
import ojs.blog.ojs_back.service.dto.UserMasterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link UserMaster}.
 */
public interface UserMasterService {
    Page<UserMasterDTO> findAll(Pageable pageable);

    Optional<UserMasterDTO> findOne(String id);
}
