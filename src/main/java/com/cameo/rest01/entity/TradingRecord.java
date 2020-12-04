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
import java.util.Date;

@Data
@Table(name="TRADING_RECORD")
@EntityListeners(AuditingEntityListener.class)
@Entity
@Accessors(chain = true)
public class TradingRecord extends BaseEntity{

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
    @Column(length = 500)
    private String remark ;




}
