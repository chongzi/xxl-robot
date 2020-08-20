package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.entity.CarSource;

/**
 * 
 * 手机源数据服务接口类接口
 */
public interface PhoneCodeService extends IBaseService<PhoneCodeDto> {
    /**
     * todo 根据条件查询手机动作指令
      * @param robotCode
     * @param appCode
     * @param appEvent
     * @return
     */
    PhoneCodeDto getUnique(String robotCode,String appCode, String appEvent);

}
