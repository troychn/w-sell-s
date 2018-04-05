package com.troylc.dao;

import com.troylc.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单主表dao
 * Created by troylc on 2018/3/28.
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

        /**
         * 根据买家openid获取买家订单
         * @param openid
         * @param pageable
         * @return
         */
        Page<OrderMaster> findByBuyerOpenid (String openid, Pageable pageable);

}
