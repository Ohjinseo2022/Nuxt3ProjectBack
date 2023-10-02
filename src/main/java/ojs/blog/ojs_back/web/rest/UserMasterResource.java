package ojs.blog.ojs_back.web.rest;

import ojs.blog.ojs_back.repository.UserMasterRepository;
import ojs.blog.ojs_back.service.UserMasterService;
import ojs.blog.ojs_back.service.dto.UserMasterDTO;
import ojs.blog.ojs_back.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserMasterResource {

    private final Logger log = LoggerFactory.getLogger(UserMasterResource.class);

    private static final String ENTITY_NAME = "userMaster";

//    @Value("${spring.application.name}")
//    private String applicationName;
    private final UserMasterService userMasterService;

    private final UserMasterRepository userMasterRepository;
    public UserMasterResource(UserMasterService userMasterService, UserMasterRepository userMasterRepository ){
        this.userMasterService = userMasterService;
      this.userMasterRepository = userMasterRepository;
    }
    /**
     * {@code GET  /user-master} : get all the userMasters.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of companyMasters in body.
     */

    @GetMapping("/user-master")
    public ResponseEntity<List<UserMasterDTO>> getAllUserMasters(Pageable pageable) {
        log.debug("REST request to get a page of UserMasters");
        Page<UserMasterDTO> page = userMasterService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
