package com.troylc.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目实体，
 * Created by troylc on 2018/3/25.
 */
@Entity
@Data  //运行时生成get,set方法，主要是依赖于pom文件中的lombok
@DynamicUpdate   //动态生成sql语句，即在插入和修改数据的时候,语句中只包括要插入或者修改的字段，其它字段如果没写就不更新，或者沿用数据库对字段的默认操作。
public class ProductCategory {

    /**
     * 分类ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类类型
     */
    private Integer categoryType;

    /**
     * 创建时间 （数据库自动更新）
     */
    private Date createTime;

    /**
     * 更新时间（数据库自动更新，参考建表语句）
     */
    private Date updateTime;


    public ProductCategory() {
    }

    /**
     * 如果自己新增了构造方法，
     * 则必须包含一个默认无参的构造方法，以便于jpa中的hibernate来映射。
     * @param categoryName  分类名称
     * @param categoryType  分类类型
     */
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
