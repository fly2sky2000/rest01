package com.cameo.rest01.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="TRADING_RECORD")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class)
public class TradingRecord implements Serializable,Cloneable{
    /** ID */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    @ApiModelProperty("ID")
    private String id ;
    /** 币种 */
    @ApiModelProperty("币种")
    @Column(length = 50)
    private String coinCode ;
    /** 数量 */
    private Double quantity ;
    /** 交易类型;1买入,2卖出 */
    @Column(length = 50)
    private String tradingType ;
    /** 交易总价 */
    private Double money ;
    /** 交易单位;CNY,BTC,USD等 */
    @Column(length = 50)
    private String unit ;
    /** 价格类型;1总价,2单价 */
    @Column(length = 50)
    private String priceType ;
    /** 交易日期 */
    private Date bookedDate ;
    /** 备注 */
    @Column(length = 50)
    private String remark ;
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
