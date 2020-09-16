package com.xxl.robot.service.impl;

import com.xxl.robot.app.media.*;
import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.dto.PhoneCodeDto;
import com.xxl.robot.service.PhoneCodeService;
import com.xxl.robot.service.PhoneSourceService;
import com.xxl.robot.tools.WindowTools;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * 
 * todo 数据字典编码值定义表服务类
 */
@Service
public class PhoneSourceServiceImpl implements PhoneSourceService {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(PhoneSourceServiceImpl.class);
	@Autowired
	private PhoneCodeService phoneCodeService;


}