package ojs.blog.ojs_back.web.rest;

import jakarta.validation.Valid;

import ojs.blog.ojs_back.repository.UserMasterRepository;
import ojs.blog.ojs_back.service.UserMasterService;
import ojs.blog.ojs_back.service.dto.UserMasterDTO;
import ojs.blog.ojs_back.service.dto.cmn.FieldSelector;
import ojs.blog.ojs_back.service.dto.cmn.Partial;
import ojs.blog.ojs_back.service.dto.cmn.View;
import ojs.blog.ojs_back.util.HeaderUtil;
import ojs.blog.ojs_back.util.PaginationUtil;
import ojs.blog.ojs_back.util.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<Partial<List<UserMasterDTO>>> getAllUserMasters(
            @RequestParam(name = "selectors",       required = false) List<String> selectors,
            Pageable pageable
    ) {
        if(ObjectUtils.isEmpty(pageable)) {
            pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("createDate")));
        } else {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.desc("createDate")));
        }
//        System.out.println("REST request to get a page of UserMasters");
//        log.debug("REST request to get a page of UserMasters");
        Page<UserMasterDTO> page = userMasterService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(
                Partial.with(
                        page.getContent(),
                        FieldSelector.withDefaultView(selectors, View.List.class)
                )
        );
    }

//   단건조회
    /**
     * {@code GET  /user-master/{id} : get the "id" userMasters.
     *
     * @param id the id of the UserMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the UserMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-master/{id}")
    public ResponseEntity<Partial<UserMasterDTO>> getUserMasters(
            @PathVariable String id ,
     @RequestParam(name = "selectors",   required = false) List<String> selectors){
        log.debug("REST request to get UserMasters Detail : {}", id);
        Optional<UserMasterDTO> userMasterDTO = userMasterService.findOne(id);
//       HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(HttpHeaders.EMPTY).body(
                Partial.with(
                        userMasterDTO.get(),
                        FieldSelector.withDefaultView(selectors, View.Detail.class)
                )
        );
    }

    //신규생성
    @PostMapping(value="/user-master/create", produces="application/json",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<UserMasterDTO> createUserMaster(@Valid @RequestBody UserMasterDTO userMasterDTO) throws URISyntaxException{
        log.debug("REST request to get UserMasters Detail : {}", userMasterDTO);
        if (userMasterDTO.getId() != null && userMasterRepository.existsById(userMasterDTO.getId())) {
            throw new URISyntaxException("A new userMenu cannot already have an ID", ENTITY_NAME);
        }
        userMasterDTO.setCreateBy(userMasterDTO.getUserName());
        UserMasterDTO result = userMasterService.save(userMasterDTO);
        return ResponseEntity
                .created(new URI("/api/user-master/create/"+ result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("Backend",true,ENTITY_NAME,result.getId()))
                .body(result);
    }

}
