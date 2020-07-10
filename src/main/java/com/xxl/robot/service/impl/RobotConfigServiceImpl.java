package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotConfigMapper;
import com.xxl.robot.dto.RobotConfigDto;
import com.xxl.robot.entity.RobotConfig;
import com.xxl.robot.service.RobotConfigService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * todo 配置表服务类
 */
@Service
public class RobotConfigServiceImpl implements RobotConfigService {

	@Autowired
	private RobotConfigMapper robotConfigMapper;


	@Override
	public RobotConfigDto get(Long id) {
		RobotConfig entity = new RobotConfig();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotConfigMapper.selectOne(entity),RobotConfigDto.class);
	}

	@Override
	public int save(RobotConfigDto dto) {
		RobotConfig entity = BeanTools.sourceToTarget(dto, RobotConfig.class);
		return robotConfigMapper.insert(entity);
	}


	@Override
	public int update(RobotConfigDto dto) {
		RobotConfig entity = BeanTools.sourceToTarget(dto, RobotConfig.class);
		return robotConfigMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotConfigMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotConfigDto> list(RobotConfigDto dto) {
		List<RobotConfig> dtos = robotConfigMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotConfigDto.class);
	}


	@Override
	public PageInfo<RobotConfigDto> page(RobotConfigDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotConfigDto> beans = BeanTools.sourceToTarget(robotConfigMapper.selectByCondition(getCondition(dto)),RobotConfigDto.class);
		PageInfo<RobotConfigDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotConfigDto dto){
		Condition condition = new Condition(RobotConfig.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(StringUtils.isNotBlank(dto.getCodeType())){
			criteria.andLike("codeType",dto.getCodeType());
		}
		if(StringUtils.isNotBlank(dto.getNo())){
			criteria.andEqualTo("no",dto.getNo());
		}
		return condition;
	}

	@Override
	public List<RobotConfig> queryDictionary(String codeType) {
		RobotConfig RobotCode = new RobotConfig();
		RobotCode.setCodeType(codeType);
		RobotCode.setEnabled((byte) 0);
		List<RobotConfig> beans = robotConfigMapper.select(RobotCode);
		return beans;
	}

	@Override
	public Map<String, Object> getTypeValus(List<String> typeNos) {
		Map<String, Object> map = new HashMap<>();
		if (CollectionUtils.isNotEmpty(typeNos)) {
			for (String codeType : typeNos) {
				RobotConfig RobotCode = new RobotConfig();
				RobotCode.setCodeType(codeType);
 				List<RobotConfig> beans = robotConfigMapper.select(RobotCode);
				map.put(codeType, beans);
			}
		}
		return map;
	}

	@Override
	public int doEnabled(Long id) {
		RobotConfig entity = robotConfigMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return robotConfigMapper.updateByPrimaryKey(entity);
	}


}
