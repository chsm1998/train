package com.two.train.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chsm
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Path对象", description="")
public class Path implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "列车id")
    private Integer trainId;

    @ApiModelProperty(value = "上一站点id")
    private Integer preId;

    @ApiModelProperty(value = "站点id")
    private Integer siteId;

    @ApiModelProperty(value = "下一站站点id")
    private Integer nextId;

    @ApiModelProperty(value = "站点票价")
    private BigDecimal price;

    @ApiModelProperty(value = "站点车票库存")
    private Integer store;

    @ApiModelProperty(value = "发车时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "停留时间")
    private LocalDateTime sleepTime;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;


}
