package com.xxl.robot.service;

import com.xxl.common.service.IBaseService;
import com.xxl.robot.dto.RobotConfigDto;
import com.xxl.robot.entity.RobotConfig;

import java.util.List;
import java.util.Map;

/**
 * 
 * 配置表服务接口类接口
 */
public interface RobotConfigService extends IBaseService<RobotConfigDto> {

	/**
	 * 根据类型获取字典信息
	 * @param codeType
	 * @return
	 */
	List<RobotConfig> queryDictionary(String codeType);

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


}
