package com.troylc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 返回给前端的商品详情（包含类目）
 * Created by troylc on 2018/3/28.
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -4471285242600830239L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    protected List<ProductInfoVO> productInfos;

}