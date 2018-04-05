package com.troylc.service.impl;

import com.troylc.dao.ProductInfoDao;
import com.troylc.entity.ProductInfo;
import com.troylc.enums.ProductStatusEnum;
import com.troylc.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by troylc on 2018/3/27.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductInfoDao productInfoDao;
   
    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.getOne(productId);
    }

    /**
     * 查询所有上架的商品
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {

        return productInfoDao.save(productInfo);
    }
}
