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
    /**
     * 币种
     */
    public static enum CoinCode {
        BTC,//比特币
        ETH;//莱特币
    }

    /**
     * 交易类型
     */
    public static enum TradingType {
        BUY, //买入
        SELL; //卖出
    }

    /**
     * 交易单位
     */
    public static enum UnitType {
        CNY, //买入
        BTC, //卖出
        USD; //卖出
    }

    /**
     * 价格类型
     */
    public static enum PriceType {
        TOTAL, //总价
        UNIT; //单价
    }
    /** 币种 */
    @ApiModelProperty("币种")
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private CoinCode coinCode ;
    /** 数量 */
    private Double quantity ;
    /** 交易类型;BUY买入,SELL卖出 */
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private TradingType tradingType ;
    /** 交易总价 */
    private Double money ;
    /** 交易单位;CNY,BTC,USD等 */
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private UnitType unit ;
    /** 价格类型;TOTAL总价,UNIT单价 */
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private PriceType priceType ;
    /** 交易日期 */
    private Date bookedDate ;
    /** 备注 */
    @Column(length = 500)
    private String remark ;




}
