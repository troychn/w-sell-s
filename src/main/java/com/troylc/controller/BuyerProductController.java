package com.troylc.controller;

import com.troylc.entity.ProductCategory;
import com.troylc.entity.ProductInfo;
import com.troylc.service.ICategoryService;
import com.troylc.service.IProductService;
import com.troylc.utils.ResultUtils;
import com.troylc.vo.ProductInfoVO;
import com.troylc.vo.ProductVO;
import com.troylc.vo.ResultObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by troylc on 2018/3/27.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;


    @GetMapping("/list")
    public ResultObject list(){
        //获取所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //获取所有的类目(一次性查询）
        List<Integer> categoryTypes = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypes);

        //拼接VO
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfos(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultUtils.success(productVOList);
    }
}
