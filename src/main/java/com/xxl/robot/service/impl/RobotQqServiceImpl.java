package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.robotQqMapper;
import com.xxl.robot.dto.RobotQqDto;
import com.xxl.robot.entity.RobotQq;
import com.xxl.robot.service.RobotQqService;
import com.xxl.robot.tools.RegTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * todo qq服务类
 */
@Service
public class RobotQqServiceImpl implements RobotQqService {

	@Autowired
	private robotQqMapper robotQqMapper;


	@Override
	public RobotQqDto get(Long id) {
		RobotQq entity = new RobotQq();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotQqMapper.selectOne(entity),RobotQqDto.class);
	}

	@Override
	public int save(RobotQqDto dto) {
		RobotQq entity = BeanTools.sourceToTarget(dto, RobotQq.class);
		return robotQqMapper.insert(entity);
	}


	@Override
	public int update(RobotQqDto dto) {
		RobotQq entity = BeanTools.sourceToTarget(dto, RobotQq.class);
		return robotQqMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		return robotQqMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotQqDto> list(RobotQqDto dto) {
		List<RobotQq> dtos = robotQqMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotQqDto.class);
	}


	@Override
	public PageInfo<RobotQqDto> page(RobotQqDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotQqDto> beans = BeanTools.sourceToTarget(robotQqMapper.selectByCondition(getCondition(dto)),RobotQqDto.class);
		PageInfo<RobotQqDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotQqDto dto){
		Condition condition = new Condition(RobotQq.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(null!=dto.getEnabled()){
			criteria.andEqualTo("enabled",dto.getEnabled());
		}
		return condition;
	}

//***********************************************业务逻辑************************************************************
    @Async("taskExecutor")
	@Override
	public void handleQQ(List<String> datas){
		List<RobotQq> RobotQqs = new ArrayList<>();
 		if(!CollectionUtils.isEmpty(datas)) {
			for (String data : datas) {
				String[] result = data.split(RegTools.TIME);
				for(int i=0;i<result.length;i++){
					RobotQq dto = new RobotQq();
					dto.setContent(result[i]);
					dto.setEnabled((byte) 0);
					RobotQqs.add(dto);
				}
			}
		}
		RobotQqs.stream().distinct().collect(Collectors.toList());

        robotQqMapper.insertList(RobotQqs);

	}








}
