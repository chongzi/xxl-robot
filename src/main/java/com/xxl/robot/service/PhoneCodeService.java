package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.entity.CarSource;

import java.util.List;

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

    /**
     * todo 根据条件查询手机动作指令
     * @param robotCode
     * @param appCode
     * @return
     */
    List<PhoneCodeDto> getList(String robotCode, String appCode);

}
