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
 * todo 数据字典编码值定义表服务类
 */
@Service
public class RobotCodeServiceImpl implements RobotCodeService {

	@Autowired
	private RobotCodeMapper robotCodeMapper;


	@Override
	public RobotCodeDto get(Long id) {
		RobotCode entity = new RobotCode();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotCodeMapper.selectOne(entity),RobotCodeDto.class);
	}

	@Override
	public int save(RobotCodeDto dto) {
		RobotCode entity = BeanTools.sourceToTarget(dto,RobotCode.class);
		return robotCodeMapper.insert(entity);
	}


	@Override
	public int update(RobotCodeDto dto) {
		RobotCode entity = BeanTools.sourceToTarget(dto,RobotCode.class);
		return robotCodeMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotCodeMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotCodeDto> list(RobotCodeDto dto) {
		List<RobotCode> dtos = robotCodeMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotCodeDto.class);
	}


	@Override
	public PageInfo<RobotCodeDto> page(RobotCodeDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotCodeDto> beans = BeanTools.sourceToTarget(robotCodeMapper.selectByCondition(getCondition(dto)),RobotCodeDto.class);
		PageInfo<RobotCodeDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotCodeDto dto){
		Condition condition = new Condition(RobotCode.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(StringUtils.isNotBlank(dto.getCodeType())){
			criteria.andLike("codeType",dto.getCodeType());
		}
		if(StringUtils.isNotBlank(dto.getName())){
			criteria.andEqualTo("name",dto.getName());
		}
		if(StringUtils.isNotBlank(dto.getNo())){
			criteria.andEqualTo("no",dto.getNo());
		}
		return condition;
	}

	@Override
	public List<RobotCode> queryDictionary(String codeType) {
		RobotCode RobotCode = new RobotCode();
		RobotCode.setCodeType(codeType);
		RobotCode.setEnabled((byte) 0);
		List<RobotCode> beans = robotCodeMapper.select(RobotCode);
		return beans;
	}

	@Override
	public Map<String, Object> getTypeValus(List<String> typeNos) {
		Map<String, Object> map = new HashMap<>();
		if (CollectionUtils.isNotEmpty(typeNos)) {
			for (String codeType : typeNos) {
				RobotCode RobotCode = new RobotCode();
				RobotCode.setCodeType(codeType);
 				List<RobotCode> beans = robotCodeMapper.select(RobotCode);
				map.put(codeType, beans);
			}
		}
		return map;
	}

	@Override
	public int doEnabled(Long id) {
		RobotCode entity = robotCodeMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		return robotCodeMapper.updateByPrimaryKey(entity);
	}


}
