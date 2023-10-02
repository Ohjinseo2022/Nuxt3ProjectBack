package ojs.blog.ojs_back.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


/**
 * Base abstract class for entities which will hold definitions for created, last modified, created by,
 * last modified by attributes.
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"}, allowGetters = true)//"version",
public abstract class AbstractAuditingEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Version
//    @Column(name = "version")
//    @Comment("optimistic lock 버전 정보")
//    private Long version;

    @CreatedBy
    @Column(name = "create_by", nullable = false, length = 50, updatable = false)
    @Comment("최초생성자")
    private String createdBy;

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    @Comment("최초 생성 일시")
    private Instant createDate = Instant.now();

    @LastModifiedBy
    @Column(name = "update_by", length = 50)
    @Comment("마지막 변경자")
    private String updateBy;

    @LastModifiedDate
    @Column(name = "update_date")
    @Comment("마지막 변경 일시")
    private Instant updateDate = Instant.now();

    public abstract T getId();
}
