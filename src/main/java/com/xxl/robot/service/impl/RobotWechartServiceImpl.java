package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotWechartMapper;
import com.xxl.robot.dto.RobotWechartDto;
import com.xxl.robot.entity.RobotWechart;
import com.xxl.robot.service.RobotConfigService;
import com.xxl.robot.service.RobotWechartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
 * 
 * todo 微信服务类
 */
@Service
public class RobotWechartServiceImpl implements RobotWechartService {

	@Autowired
	private RobotWechartMapper robotWechartMapper;
	@Autowired
	private RobotConfigService robotConfigService;


	@Override
	public RobotWechartDto get(Long id) {
		RobotWechart entity = new RobotWechart();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotWechartMapper.selectOne(entity), RobotWechartDto.class);
	}

	@Override
	public int save(RobotWechartDto dto) {
		RobotWechart entity = BeanTools.sourceToTarget(dto, RobotWechart.class);
		return robotWechartMapper.insert(entity);
	}


	@Override
	public int update(RobotWechartDto dto) {
		RobotWechart entity = BeanTools.sourceToTarget(dto, RobotWechart.class);
		return robotWechartMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotWechartMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotWechartDto> list(RobotWechartDto dto) {
		List<RobotWechart> dtos = robotWechartMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotWechartDto.class);
	}


	@Override
	public PageInfo<RobotWechartDto> page(RobotWechartDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotWechartDto> beans = BeanTools.sourceToTarget(robotWechartMapper.selectByCondition(getCondition(dto)), RobotWechartDto.class);
		PageInfo<RobotWechartDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotWechartDto dto){
		Condition condition = new Condition(RobotWechart.class);
		Condition.Criteria criteria = condition.createCriteria();


		return condition;
	}


	@Override
	public int doEnabled(Long id) {
		RobotWechart robotWechart = robotWechartMapper.selectByPrimaryKey(id);
		if(robotWechart.getEnabled()==0){
			robotWechart.setEnabled((byte) 1);
		}else{
			robotWechart.setEnabled((byte) 0);
		}
		return 0;
	}
}
