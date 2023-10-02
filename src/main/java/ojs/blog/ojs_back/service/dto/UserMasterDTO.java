package ojs.blog.ojs_back.service.dto;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.*;
import ojs.blog.ojs_back.service.dto.cmn.FieldSelector;
import ojs.blog.ojs_back.service.dto.cmn.View;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

//@Schema(description = "콘텐츠카탈로그원부") 스웨거 ui 목적
@SuppressWarnings("common-java:DuplicatedBlocks")
@Data
@EqualsAndHashCode(callSuper = false, of="id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonFilter(FieldSelector.FILTER_NAME)// 물어볼것
public class UserMasterDTO extends AbstractAuditingDTO<String> implements Serializable {
    /**
     * UUID형태 ID
     */
    @JsonView(View.Min.class)
    @Size(max = 36)
    private String id;

    /**
     * 사용자이름
     */
    @JsonView(View.Detail.class)
    @Size(max = 255)
    private String userName;

    /**
     *사용자 패스워드
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String userPassword;

    /**
     *사용자 나이
     */
    @JsonView(View.Basic.class)
    private Integer userAge;

    /**
     *사용자 이메일
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String userEmail;

    /**
     *사용자 직책
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String companyPosition;

    /**
     *사용자 연락처
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String userPhoneNumber;

    /**
     *사용자 주소
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String userAddress;

    /**
     *사용중인 장비1
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String itemOneName;

    /**
     *사용중인 장비1 시리얼번호
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String itemOneSerialInfo;

    /**
     *사용중인 장비2
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String itemTwoName;

    /**
     *사용중인 장비2 시리얼번호
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String itemTwoSerialInfo;

    /**
     *사용중인 장비3
     */
    @JsonView(View.Detail.class)
    @Size(max=255)
    private String itemThreeName;

    /**
     *사용중인 장비3 시리얼번호
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String itemThreeSerialInfo;

    /**
     *생성시간
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String createDate;

    /**
     *생성자 이름
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String createBy;

    /**
     *마지막 업데이트 시간
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String updateDate;

    /**
     *마지막 업데이트 이름
     */
    @JsonView(View.Basic.class)
    @Size(max=255)
    private String updateBy;
}
