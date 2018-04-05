package com.troylc.dao;

import com.troylc.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品dao层
 * Created by troylc on 2018/3/27.
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {

    /**
     * 根据商品状态查询所有商品信息
     * @param productStatus  商品状态
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
