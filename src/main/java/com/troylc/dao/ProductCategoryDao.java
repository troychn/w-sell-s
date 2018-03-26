package com.troylc.dao;

import com.troylc.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 端口类目dao层
 * Created by troylc on 2018/3/25.
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
    /**
     * 根据类目的list数据，查询类目信息
     * findByCategoryTypeIn方法名是根据jpa的规范编写的，
     * 所以jpa可以直接通过方法名称来自动实现接口的实现
     *
     * @param categoryTypeList
     * @return categoryTypeLists集合
     */
     List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
