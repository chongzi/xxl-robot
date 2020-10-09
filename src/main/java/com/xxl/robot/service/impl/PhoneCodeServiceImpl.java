package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.PhoneCodeMapper;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.entity.PhoneCode;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.service.RobotInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class PhoneCodeServiceImpl implements PhoneCodeService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(PhoneCodeServiceImpl.class);

	@Autowired
	private PhoneCodeMapper phoneCodeMapper;
	private RobotInfoService robotInfoService;

	@Override
	public PhoneCodeDto get(Long id) {
		PhoneCode entity = new PhoneCode();
		entity.setId(id);
		return BeanTools.sourceToTarget(phoneCodeMapper.selectOne(entity),PhoneCodeDto.class);
	}

	@Override
	public PhoneCodeDto getUnique(String robotCode,String appCode, String appEvent) {
		PhoneCode entity = new PhoneCode();
		entity.setRobotCode(robotCode);
		entity.setAppCode(appCode);
		entity.setAppEvent(appEvent);
		return BeanTools.sourceToTarget(phoneCodeMapper.selectOne(entity),PhoneCodeDto.class);
	}

	@Override
	public List<PhoneCodeDto> getList(String robotCode, String appCode) {
		PhoneCodeDto dto = new PhoneCodeDto();
		if(robotCode.length()>8) {
			dto.setRobotCode(robotCode.substring(0, robotCode.length() - 1));
		}else{
			dto.setRobotCode(robotCode);
		}
		dto.setAppCode(appCode);
		List<PhoneCode> dtos = phoneCodeMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, PhoneCodeDto.class);
	}


	@Override
	public int save(PhoneCodeDto dto) {
		PhoneCode entity = BeanTools.sourceToTarget(dto,PhoneCode.class);
		return phoneCodeMapper.insert(entity);
	}


	@Override
	public int update(PhoneCodeDto dto) {
		PhoneCode entity = BeanTools.sourceToTarget(dto,PhoneCode.class);
		return phoneCodeMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return phoneCodeMapper.deleteByIds(ids);
	}

	@Override
	public List<PhoneCodeDto> list(PhoneCodeDto dto) {
		List<PhoneCode> dtos = phoneCodeMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, PhoneCodeDto.class);
	}


	@Override
	public PageInfo<PhoneCodeDto> page(PhoneCodeDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<PhoneCodeDto> beans = BeanTools.sourceToTarget(phoneCodeMapper.selectByCondition(getCondition(dto)),PhoneCodeDto.class);
		PageInfo<PhoneCodeDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(PhoneCodeDto dto){
		Condition condition = new Condition(PhoneCode.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(null!=dto.getRobotCode()){
			criteria.andEqualTo("robotCode",dto.getRobotCode());
		}
		if(null!=dto.getAppCode()){
			criteria.andEqualTo("appCode",dto.getAppCode());
		}


		return condition;
	}

}
