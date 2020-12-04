package com.cameo.rest01.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Inherited;
import java.util.Date;

@MappedSuperclass
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable,Cloneable{
    /** ID */
    @Id
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id ;
    /** 乐观锁 */
    private Integer revision ;
    /** 创建人 */
    @Column(length = 50)
    private String createdBy ;
    /** 创建时间 */
    @CreatedDate
    private Date createdTime ;
    /** 更新人 */
    @Column(length = 50)
    private String updatedBy ;
    /** 更新时间 */
    @LastModifiedDate
    private Date updatedTime ;

}
