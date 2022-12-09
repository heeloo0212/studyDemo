package com.test.demo.web.redisPubAndSub;

import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/8/19 16:01
 */
@Data
public class SendSocketMsg {

    /**
     * websocket业务数据(json)
     */
    private String msg;

    /**
     *业务模块类型
     */
    private String type;
    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 设备id集合
     */
    private List<String> deviceIdList;
}
