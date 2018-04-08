package com.troylc.service;

import com.troylc.dto.CartDTO;
import com.troylc.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品业务处理服务层
 * Created by troylc on 2018/3/27.
 */
public interface IProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有上架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 减少库存.
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 增加库存.
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 商品下架.
     */
    ProductInfo offSafe(ProductInfo productInfo);

    /**
     * 商品上架.
     */
    ProductInfo onSafe(ProductInfo productInfo);

}
