package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotCodeMapper;
import com.xxl.robot.dto.RobotCodeDto;
import com.xxl.robot.entity.RobotCode;
import com.xxl.robot.service.RobotCodeService;
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
public class RobotCodeServiceImpl implements RobotCodeService {

	@Autowired
	private RobotCodeMapper robotConfigMapper;


	@Override
	public RobotCodeDto get(Long id) {
		RobotCode entity = new RobotCode();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotConfigMapper.selectOne(entity), RobotCodeDto.class);
	}

	@Override
	public int save(RobotCodeDto dto) {
		RobotCode entity = BeanTools.sourceToTarget(dto, RobotCode.class);
		return robotConfigMapper.insert(entity);
	}


	@Override
	public int update(RobotCodeDto dto) {
		RobotCode entity = BeanTools.sourceToTarget(dto, RobotCode.class);
		return robotConfigMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotConfigMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotCodeDto> list(RobotCodeDto dto) {
		List<RobotCode> dtos = robotConfigMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotCodeDto.class);
	}


	@Override
	public PageInfo<RobotCodeDto> page(RobotCodeDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotCodeDto> beans = BeanTools.sourceToTarget(robotConfigMapper.selectByCondition(getCondition(dto)), RobotCodeDto.class);
		PageInfo<RobotCodeDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotCodeDto dto){
		Condition condition = new Condition(RobotCode.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(StringUtils.isNotBlank(dto.getCodeType())){
			criteria.andLike("codeType",dto.getCodeType());
		}
		if(StringUtils.isNotBlank(dto.getCode())){
			criteria.andEqualTo("robotCode",dto.getRobotCode());
		}
		if(StringUtils.isNotBlank(dto.getCode())){
			criteria.andEqualTo("code",dto.getCode());
		}
		if(StringUtils.isNotBlank(dto.getName())){
			criteria.andEqualTo("name",dto.getName());
		}
		return condition;
	}

	@Override
	public List<RobotCode> queryDictionary(String codeType) {
		RobotCode RobotCode = new RobotCode();
		RobotCode.setCodeType(codeType);
		RobotCode.setEnabled((byte) 0);
		List<com.xxl.robot.entity.RobotCode> beans = robotConfigMapper.select(RobotCode);
		return beans;
	}

	@Override
	public Map<String, Object> getTypeValus(List<String> typeNos) {
		Map<String, Object> map = new HashMap<>();
		if (CollectionUtils.isNotEmpty(typeNos)) {
			for (String codeType : typeNos) {
				RobotCode RobotCode = new RobotCode();
				RobotCode.setCodeType(codeType);
 				List<com.xxl.robot.entity.RobotCode> beans = robotConfigMapper.select(RobotCode);
				map.put(codeType, beans);
			}
		}
		return map;
	}

	@Override
	public int doEnabled(Long id) {
		RobotCode entity = robotConfigMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return robotConfigMapper.updateByPrimaryKey(entity);
	}

	@Override
	public List<RobotCode> queryRobotCode(String robotCode, String codeType) {
		RobotCode RobotCode = new RobotCode();
		RobotCode.setCodeType(codeType);
		RobotCode.setEnabled((byte) 0);
		RobotCode.setRobotCode(robotCode);
		List<com.xxl.robot.entity.RobotCode> beans = robotConfigMapper.select(RobotCode);
		return beans;
	}


}
