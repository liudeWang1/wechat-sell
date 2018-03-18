package com.wang.service;

import com.wang.dto.OrderDTO;

/**将BuyerOrderController中的订单详情和取消订单处理逻辑放在这
 * Created by 汪刘德 on 2018/3/14.
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancelOrder(String openid,String orderId);
}
