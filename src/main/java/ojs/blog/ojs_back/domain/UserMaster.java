package ojs.blog.ojs_back.domain;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Comment;

import jakarta.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@ToString @EqualsAndHashCode(callSuper = false, of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user_master")
//@org.hibernate.annotations.Table(comment = "사용자정보테이블", appliesTo = "user_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UserMaster extends AbstractAuditingEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
    * UUID형태 ID
    */
    @Comment("UUID형태ID")
    @NotNull
    @Id
    @Column(name="id", nullable = false)
    private String id;

    /**
     *사용자이름
     */
    @Comment("사용자이름")
    @Size(max=36)
    @Column(name="user_name")
    private String userName;

    /**
     *사용자 패스워드
     */
    @Comment("사용자패스워드")
    @Size(max=255)
    @Column(name="user_password")
    private String userPassword;

    /**
     *사용자 나이
     */
    @Comment("사용자나이")
    @Column(name="user_age")
    private Integer userAge;

    /**
     *사용자 이메일
     */
    @Comment("사용자이메일")
    @Size(max=255)
    @Column(name="user_email")
    private String userEmail;

    /**
     *사용자 직책
     */
    @Comment("사용자직책")
    @Size(max=255)
    @Column(name="company_position")
    private String companyPosition;

    /**
     *사용자 연락처
     */
    @Comment("사용자연락처")
    @Size(max=255)
    @Column(name="user_phone_number")
    private String userPhoneNumber;

    /**
     *사용자 주소
     */
    @Comment("사용자주소")
    @Size(max=255)
    @Column(name="user_address")
    private String userAddress;

    /**
     *사용중인 장비1
     */
    @Comment("사용중인장비1")
    @Size(max=255)
    @Column(name="item_one_name")
    private String itemOneName;

    /**
     *사용중인 장비1 시리얼번호
     */
    @Comment("사용중인장비1시리얼번호")
    @Size(max=255)
    @Column(name="item_one_serial_info")
    private String itemOneSerialInfo;

    /**
     *사용중인 장비2
     */
    @Comment("사용중인장비2")
    @Size(max=255)
    @Column(name="item_two_name")
    private String itemTwoName;

    /**
     *사용중인 장비2 시리얼번호
     */
    @Comment("사용중인장비2시리얼번호")
    @Size(max=255)
    @Column(name="item_two_serial_info")
    private String itemTwoSerialInfo;

    /**
     *사용중인 장비3
     */
    @Comment("사용중인장비3")
    @Size(max=255)
    @Column(name="item_three_name")
    private String itemThreeName;

    /**
     *사용중인 장비3 시리얼번호
     */
    @Comment("사용중인장비3시리얼번호")
    @Size(max=255)
    @Column(name="item_three_serial_info")
    private String itemThreeSerialInfo;

}
