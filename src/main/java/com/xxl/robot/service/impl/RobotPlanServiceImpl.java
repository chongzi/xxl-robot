package com.xxl.robot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.common.tools.BeanTools;
import com.xxl.robot.dao.RobotPlanMapper;
import com.xxl.robot.dto.RobotPlanDto;
import com.xxl.robot.entity.RobotPlan;
import com.xxl.robot.service.RobotPlanService;
import com.xxl.robot.service.RobotQqService;
import com.xxl.robot.time.DynamicSchedule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
 * 
 * todo 配置表服务类
 */
@Service
public class RobotPlanServiceImpl implements RobotPlanService {
	private static final Logger logger = LoggerFactory.getLogger(RobotPlanServiceImpl.class);

	@Autowired
	private RobotPlanMapper robotPlanMapper;
	@Autowired
	private DynamicSchedule dynamicSchedule;
	@Autowired
	@Lazy
	private RobotQqService robotQqService;


	@Override
	public RobotPlanDto get(Long id) {
		RobotPlan entity = new RobotPlan();
		entity.setId(id);
		return BeanTools.sourceToTarget(robotPlanMapper.selectOne(entity),RobotPlanDto.class);
	}

	@Override
	public int save(RobotPlanDto dto) {
		handleTask("save",dto);
		RobotPlan entity = BeanTools.sourceToTarget(dto, RobotPlan.class);
		return robotPlanMapper.insert(entity);
	}


	@Override
	public int update(RobotPlanDto dto) {
		handleTask("update",dto);
		RobotPlan entity = BeanTools.sourceToTarget(dto, RobotPlan.class);
		return robotPlanMapper.updateByPrimaryKeySelective(entity);
	}


	@Override
	public int delete(String ids) {
		String[] id = ids.split(",");
		for(int i=0;i<id.length;i++){
			RobotPlanDto dto = BeanTools.sourceToTarget(robotPlanMapper.selectByPrimaryKey(id[i]),RobotPlanDto.class);
			handleTask("delete",dto);
		}


		return robotPlanMapper.deleteByIds(ids);
	}

	@Override
	public List<RobotPlanDto> list(RobotPlanDto dto) {
		List<RobotPlan> dtos = robotPlanMapper.selectByCondition(getCondition(dto));
		return BeanTools.sourceToTarget(dtos, RobotPlanDto.class);
	}


	@Override
	public PageInfo<RobotPlanDto> page(RobotPlanDto dto, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<RobotPlanDto> beans = BeanTools.sourceToTarget(robotPlanMapper.selectByCondition(getCondition(dto)),RobotPlanDto.class);
		PageInfo<RobotPlanDto> pageInfo = new PageInfo<>(beans);
		return pageInfo;
	}

	private Condition getCondition(RobotPlanDto dto){
		Condition condition = new Condition(RobotPlan.class);
		Condition.Criteria criteria = condition.createCriteria();
		if(StringUtils.isNotBlank(dto.getRobotCode())){
			criteria.andEqualTo("robotCode",dto.getRobotCode());
		}
		if(null!=dto.getOperateType()){
			criteria.andEqualTo("operateType",dto.getOperateType());
		}
		if(null!=dto.getEnabled()){
			criteria.andEqualTo("enabled",dto.getEnabled());
		}
		return condition;
	}



	@Override
	public int doEnabled(Long id) {
		RobotPlan entity = robotPlanMapper.selectByPrimaryKey(id);
		if(null!=entity){
			if(entity.getEnabled()==0){
				entity.setEnabled((byte) 1);
			}else{
				entity.setEnabled((byte) 0);
			}
		}
		RobotPlanDto dto = BeanTools.sourceToTarget(entity,RobotPlanDto.class);
		handleTask("update",dto);
		return robotPlanMapper.updateByPrimaryKey(entity);
	}

	@Override
	public RobotPlanDto selectByHostOperate(RobotPlan entity) {
		return BeanTools.sourceToTarget(robotPlanMapper.selectOne(entity),RobotPlanDto.class);
	}

	@Override
	public void handleTask(String conditon, RobotPlanDto dto) {
		if(conditon.equals("save")){
			//任务id由机器人编号+时间+操作方式
			String taskId = dto.getRobotCode()+dto.getCron()+dto.getOperateType();
			if(dto.getEnabled()== Byte.valueOf("0")) {
				dynamicSchedule.addTriggerTask(taskId, new TriggerTask(() -> handleTaskOperate(dto), new CronTrigger(dto.getCron())));
			}
		}else if(conditon.equals("update")){
			RobotPlan entity =  robotPlanMapper.selectByPrimaryKey(dto.getId());
			String taskId = entity.getRobotCode()+entity.getCron()+entity.getOperateType();
			if(dynamicSchedule.hasTask(taskId)){
				dynamicSchedule.cancelTriggerTask(taskId);
			}
			if(dto.getEnabled()== Byte.valueOf("0")) {
				String taskIdElse = dto.getRobotCode() + dto.getCron() + dto.getOperateType();
				dynamicSchedule.addTriggerTask(taskIdElse, new TriggerTask(() -> handleTaskOperate(dto), new CronTrigger(dto.getCron())));
			}

		}else if(conditon.equals("delete")){
			String taskId = dto.getRobotCode() + dto.getCron() + dto.getOperateType();
			if(dynamicSchedule.hasTask(taskId)){
				dynamicSchedule.cancelTriggerTask(taskId);
			}
		}


	}

	@Override
	public void handleTaskOperate(RobotPlanDto dto) {
		logger.info("*************定时器启动************"+dto.getCron() );
		switch(dto.getOperateType()){
			case 0 ://0-QQ数据采集
				robotQqService.collectQQ();
				break;
			case 1 ://1-QQ自动发送
				robotQqService.sendQQ();
				break;
			case 2 ://2-QQ群、好友添加
				robotQqService.addQQ();
				break;
			case 3 ://3-微信采集

				break;
			case 4 ://4-微信自动发送

				break;
			case 5 ://5-微信添加
				//语句
				break; //可选
			case 6 :
				//语句
				break; //可选
			case 7 :
				//语句
				break; //可选
			case 8 :
				//语句
				break; //可选
			case 9 :
				//语句
				break; //可选

			default : //可选
				//语句
		}
	}


}
