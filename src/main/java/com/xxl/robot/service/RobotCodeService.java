package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.RobotCodeDto;
import com.xxl.robot.entity.RobotCode;

import java.util.List;
import java.util.Map;

/**
 * 
 * 配置表服务接口类接口
 */
public interface RobotCodeService extends IBaseService<RobotCodeDto> {

	/**
	 * 根据类型获取字典信息
	 * @param codeType
	 * @return
	 */
	List<RobotCode> queryDictionary(String codeType);

	/**
	 *
	 * <p>根据数据字典类型NO，查询字典Value</p>
	 * @date 2017年9月7日 下午1:44:06
	 * @return
	 * @see
	 */
	Map<String, Object> getTypeValus(List<String> typeNos);

	/**
	 * 启用/禁用
	 * @param id
	 * @return
	 */
	int doEnabled(Long id);


	/**
	 * 根据类型获取字典信息
 * 	 * @param robotCode
	 * @param codeType
	 * @return
	 */
	List<RobotCode> queryRobotCode(String robotCode, String codeType);


}
