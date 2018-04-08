package com.troylc.service.impl;

import com.troylc.dao.ProductInfoDao;
import com.troylc.dto.CartDTO;
import com.troylc.entity.ProductInfo;
import com.troylc.enums.ProductStatusEnums;
import com.troylc.enums.ResultEnums;
import com.troylc.exception.WSellSException;
import com.troylc.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return productInfoDao.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {

        return productInfoDao.save(productInfo);
    }

    /**
     * 减少库存.
     *
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            //查找商品
            ProductInfo productInfo = productInfoDao.getOne(cartDTO.getProductId());
            if (null == productInfo) {
                throw new WSellSException(ResultEnums.PRODUCT_NOT_FOUND);
            }

            Integer stock = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (stock < 0) {
                throw new WSellSException(ResultEnums.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(stock);
            productInfoDao.save(productInfo);

        }
    }

    /**
     * 增加库存.
     *
     * @param cartDTOList
     */
    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            //查找商品
            ProductInfo productInfo = productInfoDao.getOne(cartDTO.getProductId());
            if (null == productInfo) {
                throw new WSellSException(ResultEnums.PRODUCT_NOT_FOUND);
            }

            Integer stock = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(stock);
            productInfoDao.save(productInfo);
        }
    }

    /**
     * 商品下架.
     *
     * @param productInfo
     */
    @Override
    public ProductInfo offSafe(ProductInfo productInfo) {
        //1.判断商品状态
        if (ProductStatusEnums.DOWN.getCode() == productInfo.getProductStatus()) {
            throw new WSellSException(ResultEnums.PRODUCT_OFF_SALE_FAIL);
        }
        productInfo.setProductStatus(ProductStatusEnums.DOWN.getCode());
        return productInfoDao.save(productInfo);
    }

    /**
     * 商品上架.
     *
     * @param productInfo
     */
    @Override
    public ProductInfo onSafe(ProductInfo productInfo) {
        //1.判断商品状态
        if (ProductStatusEnums.UP.getCode() == productInfo.getProductStatus()) {
            throw new WSellSException(ResultEnums.PRODUCT_ON_SALE_FAIL);
        }
        productInfo.setProductStatus(ProductStatusEnums.UP.getCode());
        return productInfoDao.save(productInfo);
    }
}
