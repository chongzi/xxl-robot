package com.xxl.robot.tools;//package com.xxl.auth.tools;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 自动生成MyBatis的实体类、实体映射XML文件、Mapper
// *
// * @author WYS
// * @date 2014-11-8
// * @version v1.0
// */
//@SuppressWarnings("hiding")
//public class GenerateTools {
//
//	// **********************************根据条件修改后生成代码START*****************************************
//	/** 数据库名称 **/
//	private final String moduleName = "xxl_auth"; // 对应模块名称（根据自己模块做相应调整!!!务必修改^_^）
//	/** 代码生成地址 **/
//	private static final String path = "D:/xxl/";
//	/** 代码生成目录 **/
//	private final String base_package = "com.xxl.auth";
//	/** 数据库连接地址 **/
//	private final String url = "jdbc:mysql://47.92.37.36:3306/" + moduleName + "?characterEncoding=utf8";
//	/** 数据库用户名 **/
//	private final String user = "root";
//	/** 数据库密码 **/
//	private final String password = "phoenix30";
//
//	// **********************************根据条件修改后生成代码END*******************************************
//
//	/** 作者 **/
//	private final String comment_Author = "";
//
//	private static final String file_path = path + "";
//
//	private final String base_url = "/system/";
//
//	private final String bean_path = "entity";
//
//	private final String mapper_path = "dao";
//
//	private final String xml_path = "xml";
//
//	private final String service_path = "service";
//
//	private final String controller_path = "controller";
//
//	private final String web_path = "web";
//
//	private final String request_path = "request";
//
//	private final String bean_package = base_package + ".entity";
//
//	private final String mapper_package = base_package + ".dao";
//
//	private final String iservice_package = base_package + ".service";
//
//	private final String service_package = base_package + ".service.impl";
//
//	private final String controller_package = base_package + ".controller";
//
//	private final String request_package = base_package + ".request";
//
//	private final String type_char = "char";
//
//	private final String type_date = "date";
//
//	private final String type_timestamp = "timestamp";
//
//	private final String type_double = "double";
//
//	private final String type_int = "int";
//
//	private final String type_bigint = "bigint";
//
//	private final String type_text = "text";
//
//	private final String type_bit = "bit";
//
//	private final String type_decimal = "decimal";
//
//	private final String type_blob = "blob";
//
//	private final String driverName = "com.mysql.jdbc.Driver";
//
//	private String tableName = null;
//
//	private String beanName = null;
//
//	private String mapperName = null;
//
//	private String daoName = null;
//
//	private Connection conn = null;
//
//	private String serviceName = null;
//
//	private String iserviceName = null;
//
//	private String addVoName = null;
//
//	private String upDateVoName = null;
//
//	private String deleteVoName = null;
//
//	private String queryName = null;
//
//	private String XName = null;
//
//	private String controllerName = null;
//
//	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
//
//	private static String date;
//
//	private void init() throws ClassNotFoundException, SQLException {
//		Class.forName(driverName);
//		conn = DriverManager.getConnection(url, user, password);
//		File folder = new File(path);
//		if (!folder.exists()) {
//			folder.mkdir();
//			folder = new File(file_path);
//			if (!folder.exists()) {
//				folder.mkdir();
//			}
//		} else {
//			folder = new File(file_path);
//			if (!folder.exists()) {
//				folder.mkdir();
//			}
//		}
//	}
//
//	/**
//	 * 获取所有的表
//	 *
//	 * @return
//	 * @throws SQLException
//	 */
//	private List<String> getTables() throws SQLException {
//		List<String> tables = new ArrayList<String>();
//		PreparedStatement pstate = conn.prepareStatement("show tables");
//		ResultSet results = pstate.executeQuery();
//		while (results.next()) {
//			String tableName = results.getString(1);
//			// if ( tableName.toLowerCase().startsWith("yy_") ) {
//			tables.add(tableName);
//			// }
//		}
//		return tables;
//	}
//
//	private void processTable(String table) {
//		StringBuffer sb = new StringBuffer(table.length());
//		String tableNew = table.toLowerCase();
//		String[] tables = tableNew.split("_");
//		String temp = null;
//		for (int i = 0; i < tables.length; i++) {
//			temp = tables[i].trim();
//			sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
//		}
//		beanName = sb.toString();
//		mapperName = beanName + "Mapper";
//		daoName = beanName + "Mapper";
//		iserviceName = beanName + "Service";
//		serviceName = beanName + "ServiceImpl";
//		controllerName = beanName + "Controller";
//		XName = beanName + "QueryRequest";
//	}
//
//	private String processType(String type) {
//		if (type.indexOf(type_char) > -1) {
//			return "String";
//		} else if (type.indexOf(type_bigint) > -1) {
//			return "Long";
//		} else if (type.indexOf(type_int) > -1) {
//			return "Integer";
//		} else if (type.indexOf(type_date) > -1) {
//			return "java.util.Date";
//		} else if (type.indexOf(type_text) > -1) {
//			return "String";
//		} else if (type.indexOf(type_timestamp) > -1) {
//			return "Date";
//		} else if (type.indexOf(type_double) > -1) {
//			return "Double";
//		} else if (type.indexOf(type_timestamp) > -1) {
//			return "java.util.Date";
//		} else if (type.indexOf(type_bit) > -1) {
//			return "Boolean";
//		} else if (type.indexOf(type_decimal) > -1) {
//			return "java.math.BigDecimal";
//		} else if (type.indexOf(type_blob) > -1) {
//			return "byte[]";
//		}
//		return null;
//	}
//
//	private String processField(String field) {
//		StringBuffer sb = new StringBuffer(field.length());
//		// field = field.toLowerCase();
//		String[] fields = field.split("_");
//		String temp = null;
//		for (int i = 0; i < fields.length; i++) {
//			temp = fields[i].trim().toLowerCase();// 先全部转成小写
//			if (i > 0) {
//				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
//			} else {
//				sb.append(temp);
//			}
//		}
//		return sb.toString();
//	}
//
//	private String getTab(int num) {
//		String result = "";
//		if (num == 0) {
//			result = "\t";
//		} else {
//			for (int i = 0; i < num; i++) {
//				result = result + "\t";
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * 将实体类名首字母改为小写
//	 *
//	 * @param beanName
//	 * @return
//	 */
//	private String processName(String Name) {
//		return Name.substring(0, 1).toLowerCase() + Name.substring(1);
//	}
//
//	/**
//	 * 将首字母改为大写
//	 *
//	 * @param beanName
//	 * @return
//	 */
//	private String processCapName(String Name) {
//		return Name.substring(0, 1).toUpperCase() + Name.substring(1);
//	}
//
//	/**
//	 * 构建类上面的注释
//	 *
//	 * @param bw
//	 * @param text
//	 * @return
//	 * @throws IOException
//	 */
//	private BufferedWriter buildClassComment(BufferedWriter bw, String text) throws IOException {
//		bw.newLine();
//		write(bw, "/**");
//		write(bw, " * ");
//		write(bw, " * " + text);
//		write(bw, " * <p style=\"display:none\">modifyRecord</p>");
//		write(bw, " * <p style=\"display:none\">version:V1.0,author:" + comment_Author + ",date:" + date + ", </p>");
//		write(bw, " * @author " + comment_Author);
//		write(bw, " * @date " + date);
//		write(bw, " * @since ");
//		write(bw, " * @version ");
//		write(bw, " * ");
//		write(bw, " *	此代码由xxl开发内部使用");
//		write(bw, " *	外部使用该代码将付相应的法律责任");
//		write(bw, " *	更多信息请查询");
//		write(bw, " *	http://www.xlxu.com");
//		write(bw, " */");
//		return bw;
//	}
//
//	/**
//	 * 构建方法上面的注释
//	 *
//	 * @param bw
//	 * @param text
//	 * @return
//	 * @throws IOException
//	 */
//	private BufferedWriter buildMethodComment(BufferedWriter bw, String text) throws IOException {
//		bw.newLine();
//		write(bw, getTab(1) + "/**");
//		write(bw, getTab(1) + " * ");
//		write(bw, getTab(1) + " * <p>" + text + "</p>");
//		write(bw, getTab(1) + " * @author " + comment_Author);
//		write(bw, getTab(1) + " * @date " + date);
//		write(bw, getTab(1) + " * @param ");
//		write(bw, getTab(1) + " * @return ");
//		write(bw, getTab(1) + " * @see ");
//		write(bw, getTab(1) + " */");
//		return bw;
//	}
//
//	/**
//	 * 生成实体类
//	 *
//	 * @param columns
//	 * @param types
//	 * @param comments
//	 * @throws IOException
//	 */
//	private void buildEntityBean(List<String> columns, List<String> types, List<String> comments, String tableComment,
//			String tableName) throws IOException {
//		File folder = new File(file_path + bean_path);
//		if (!folder.exists()) {
//			folder.mkdir();
//		}
//
//		File beanFile = new File(file_path + bean_path, beanName + ".java");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(beanFile)));
//		write(bw, "package " + bean_package + ";");
//		bw.newLine();
//		write(bw, "import javax.persistence.Entity;");
//		write(bw, "import javax.persistence.Table;");
//		write(bw, "import javax.persistence.Id;");
//		write(bw, "import lombok.*;");
//		write(bw, "import com.xxl.common.entity.BaseEntity;");
//		bw = buildClassComment(bw, tableComment + "实体类");
//		write(bw, "@Data");
//		write(bw, "@Entity");
//		write(bw, "@Table(name=\"" + tableName + "\")");
//		write(bw, "public class " + beanName + " extends BaseEntity{");
//		bw.newLine();
//		write(bw, getTab(1) + "private static final long serialVersionUID = 1L;");
//		bw.newLine();
//		int size = columns.size();
//		for (int i = 0; i < size; i++) {
//			if ("version".equals(processField(columns.get(i))) || "createBy".equals(processField(columns.get(i)))
//					|| "createDate".equals(processField(columns.get(i)))
//					|| "updateBy".equals(processField(columns.get(i)))
//					|| "updateDate".equals(processField(columns.get(i)))) {
//				continue;
//			}
//			write(bw, getTab(1) + "/**" + comments.get(i) + "**/");
//			if (i == 0 && processField(columns.get(i)).endsWith("Id")) {
//				write(bw, getTab(1) + "@Id");
//			}
//			write(bw, "\tprivate " + processType(types.get(i)) + " " + processField(columns.get(i)) + ";");
//			bw.newLine();
//		}
//
//		bw.newLine();
//		write(bw, "}");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 生成查询QueryVo
//	 *
//	 * @param columns
//	 * @param types
//	 * @param comments
//	 * @throws IOException
//	 */
//	private void buildQueryVo(List<String> columns, List<String> types, List<String> comments, String tableComment,
//			String tableName) throws IOException {
//		File folder = new File(file_path + request_path);
//		if (!folder.exists()) {
//			folder.mkdir();
//		}
//
//		File beanFile = new File(file_path + request_path, XName + ".java");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(beanFile)));
//		write(bw, "package " + request_package + ";");
//		write(bw, "import lombok.*;");
////		write(bw, "import io.swagger.annotations.ApiModelProperty;");
//		bw = buildClassComment(bw, tableComment + "查询VO");
//		bw.newLine();
//		write(bw, "@Data");
//		write(bw, "public class " + XName + " {");
//		bw.newLine();
//		write(bw, getTab(1) + "/** 当前页码，默认是第一页 **/");
////		write(bw, getTab(1) + "@ApiModelProperty(\"当前页码 \")");
//		write(bw, getTab(1) + "private int pageIndex;");
//		bw.newLine();
//		write(bw, getTab(1) + "/** 每页显示的记录数，默认是10 ，设置为“-1”表示不进行分页（分页无效） **/");
////		write(bw, getTab(1) + "@ApiModelProperty(\"每页记录数 \")");
//		write(bw, getTab(1) + "private int pageSize;");
//		bw.newLine();
//
//		write(bw, getTab(1) + "/** 开始时间 **/");
//		write(bw, getTab(1) + "private String planStartDate;");
//		bw.newLine();
//
//		write(bw, getTab(1) + "/** 结束时间 **/");
//		write(bw, getTab(1) + "private String planEndDate;");
//		bw.newLine();
//
//		write(bw, getTab(1) + "/** 智能文本框名称 **/");
//		write(bw, getTab(1) + "private String noOrName;");
//		bw.newLine();
//
//		int size = columns.size();
//		for (int i = 0; i < size; i++) {
//			if ("version".equals(processField(columns.get(i)))) {
//				continue;
//			}
//			write(bw, getTab(1) + "/**" + comments.get(i) + "**/");
////			write(bw, getTab(1) + "@ApiModelProperty(\"" + comments.get(i) + "\")");
//			write(bw, getTab(1) + "private " + processType(types.get(i)) + " " + processField(columns.get(i)) + ";");
//			bw.newLine();
//		}
//		write(bw, "}");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 构建Mapper文件
//	 *
//	 * @throws IOException
//	 */
//	private void buildMapper(List<String> columns, String tableComment) throws IOException {
//		File folder = new File(file_path + mapper_path);
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//
//		File mapperFile = new File(file_path + mapper_path, daoName + ".java");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
//		write(bw, "package " + mapper_package + ";");
//		bw.newLine();
//		write(bw, "import java.util.List;");
//		write(bw, "import java.util.Map;");
//		write(bw, "import " + bean_package + "." + beanName + ";");
//		write(bw, "import com.xxl.common.dao.IBaseMapper;");
//		write(bw, "import org.apache.ibatis.annotations.Mapper;");
//		bw = buildClassComment(bw, tableComment + "数据库操作接口类");
//		write(bw, "@Mapper");
//		write(bw, "public interface " + daoName + " extends IBaseMapper<" + beanName + "> {");
////        int no = getFiled(columns, "no");
////        bw = buildMethodComment(bw, "根据No查询");
////        write(bw,getTab(1) + "public " + beanName +" selectByNo(@Param(\"" + processField(columns.get(no)) + "\") String " +  processField(columns.get(no)) + ");");
////        bw = buildMethodComment(bw, "根据主键ID批量删除");
////        write(bw,getTab(1) + "public int deleteBatch(@Param(\"" + processName(beanName) + "s\") List<String> " + processName(beanName) +"s);");
////        bw = buildMethodComment(bw, "批量插入");
////        write(bw,getTab(1) + "public int addBatch(List<" + beanName + "> " + processName(beanName) +"s);");
////        bw = buildMethodComment(bw, "XXL全部查询");
////        write(bw,getTab(1) + "public List<Map<String, Object>> queryXXL(@Param(\"" + "QueryVo"+ "\")" +XName +" QueryVo, Page page);");
////
////        bw.newLine();
//		write(bw, "}");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 构建Server接口文件
//	 *
//	 * @throws IOException
//	 */
//	private void buildServerInterface(List<String> columns, String tableComment) throws IOException {
//		File folder = new File(file_path + service_path);
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//
//		File mapperFile = new File(file_path + service_path, iserviceName + ".java");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
//		write(bw, "package " + iservice_package + ";");
//		bw.newLine();
//		write(bw, "import java.util.List;");
//		write(bw, "import java.util.Map;");
//		write(bw, "import " + bean_package + "." + beanName + ";");
//		write(bw, "import com.xxl.common.service.IBaseService;");
//		bw = buildClassComment(bw, tableComment + "服务接口类接口");
//		write(bw, "public interface " + iserviceName + " extends IBaseService<" + beanName + "> {");
//		bw.newLine();
//		write(bw, "}");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 构建Server文件
//	 *
//	 * @throws IOException
//	 */
//	private void buildServer(List<String> columns, String tableComment) throws IOException {
//		File folder = new File(file_path + service_path + "\\impl");
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//
//		File mapperFile = new File(file_path + service_path + "\\impl", serviceName + ".java");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
//		write(bw, "package " + service_package + ";");
//		bw.newLine();
//		write(bw, "import java.util.List;");
//		write(bw, "import java.util.Date;");
//		write(bw, "import java.util.Map;");
//		write(bw, "import com.xxl.common.exception.BusinessException;");
//		write(bw, "import org.springframework.beans.factory.annotation.Autowired;");
//		write(bw, "import com.xxl.common.tools.BeanTools;");
//		write(bw, "import com.github.pagehelper.PageHelper;");
//		write(bw, "import com.github.pagehelper.PageInfo;");
//		write(bw, "import org.springframework.stereotype.Service;");
//		write(bw, "import " + bean_package + "." + beanName + ";");
//		write(bw, "import " + mapper_package + "." + daoName + ";");
//		write(bw, "import " + iservice_package + "." + iserviceName + ";");
//		write(bw, "import com.xxl.auth.tools.ContextTools;");
//		bw = buildClassComment(bw, tableComment + "服务类");
//		write(bw, "@Service");
//		write(bw, "public class " + serviceName + " implements " + iserviceName + " {");
//		bw.newLine();
//		write(bw, getTab(1) + "@Autowired");
//		write(bw, getTab(1) + "private " + daoName + " " + processName(daoName) + ";");
//		bw = buildMethodComment(bw, "新增");
//		write(bw, getTab(1) + "@Override");
//		write(bw, getTab(1) + "public int add(" + beanName + " entity) {");
////        int no = getFiled(columns,"no");
////        write(bw,getTab(2) + beanName + " " + processName(beanName) + " = " + processName(daoName) + ".selectByNo(entity.get" + processCapName(processField(columns.get(no))) + "()); //根据实际修改");
////        write(bw,getTab(2) + "if(" + processName(beanName) + " != null){");
////        write(bw,getTab(3) + "throw new BusinessException(\"-1000000\",\"" + tableComment + "编号已经存在不能保存！\"); //根据实际修改");
////        write(bw,getTab(2) + "}");
////        write(bw,getTab(2) + "entity.set" + processCapName(processField(columns.get(0))) + "(BeanUtil.getUUIDString()); // id");
////        write(bw,getTab(2) + "entity.setVersion(0);// 版本号");
//		write(bw, getTab(2) + "entity.setCreateBy(ContextTools.getUserNo());// 新增人员");
//		write(bw, getTab(2) + "entity.setCreateDate(new Date());// 新增日期");
//		write(bw, getTab(2) + "entity.setUpdateBy(\"\");// 更新人员");
//		write(bw, getTab(2) + "entity.setUpdateDate(new Date());// 更新日期");
//		write(bw, getTab(2) + "return " + processName(daoName) + ".insert(entity);");
//		write(bw, getTab(1) + "}");
//		bw = buildMethodComment(bw, "修改");
//		write(bw, getTab(1) + "@Override");
//		write(bw, getTab(1) + "public int update(" + beanName + " entity) {");
//		write(bw, getTab(2) + beanName + " " + processName(beanName) + " = " + processName(daoName)
//				+ ".selectOne(entity);");
//		write(bw, getTab(2) + "if( " + processName(beanName) + " == null ){");
//		write(bw, getTab(3) + "throw new BusinessException(\"-1000000\",\"" + tableComment + "更新失败,不存在id:\",entity.get"
//				+ processCapName(processField(columns.get(0))) + "()); //根据实际修改");
//		write(bw, getTab(2) + "}");
//		write(bw, getTab(2) + "entity.setUpdateBy(ContextTools.getUserNo());");
//		write(bw, getTab(2) + "entity.setUpdateDate(new Date());");
//		write(bw, getTab(2) + "return " + processName(daoName) + ".updateByPrimaryKeySelective(entity);");
//		write(bw, getTab(1) + "}");
//		bw = buildMethodComment(bw, "删除");
//		write(bw, getTab(1) + "@Override");
//		write(bw, getTab(1) + "public int delete(" + beanName + " entity) {");
//		write(bw, getTab(2) + "return " + processName(daoName) + ".delete(entity);");
//		write(bw, getTab(1) + "}");
//		bw = buildMethodComment(bw, "根据唯一性查询");
//		write(bw, getTab(1) + "@Override");
//		write(bw, getTab(1) + "public " + beanName + " selectOne(" + beanName + " entity) {");
//		write(bw, getTab(2) + "return " + processName(daoName) + ".selectOne(entity);");
//		write(bw, getTab(1) + "}");
//		bw = buildMethodComment(bw, "不带分页查询");
//		write(bw, getTab(1) + "@Override");
//		write(bw, getTab(1) + "public " + "List<" + beanName + "> queryAll(" + beanName + " entity) {");
//		write(bw, getTab(2) + "return " + processName(daoName) + ".select(entity);");
//		write(bw, getTab(1) + "}");
////----------------------------------------------------------------------------
//		bw = buildMethodComment(bw, "pageHelper分页查询");
//		write(bw, getTab(1) + "@Override");
//		write(bw, getTab(1) + "public " + "PageInfo<" + beanName + "> queryPageAll(" + beanName
//				+ " entity, int pageIndex, int pageSize) {");
//		write(bw, getTab(2) + "PageHelper.startPage(pageIndex,pageSize);");
//		write(bw, getTab(2) + "List<" + beanName + "> beans =" + processName(daoName) + ".select(entity);");
//		write(bw, getTab(2) + "PageInfo<" + beanName + "> pageInfo = new PageInfo<>(beans);");
//		write(bw, getTab(2) + "return pageInfo;");
//		write(bw, getTab(1) + "}");
//
////      @Override
////      public PageInfo<Doc> selectDocByPage1(int currentPage, int pageSize) {
////          PageHelper.startPage(currentPage, pageSize);
////          List<Doc> docs = docMapper.selectByPageAndSelections();
////          PageInfo<Doc> pageInfo = new PageInfo<>(docs);
////          return pageInfo;
////      }
//
////----------------------------------------------------------------------------
////        bw = buildMethodComment(bw, "根据No查询");
////        write(bw,getTab(1) + "@Override");
////        write(bw,getTab(1) + "public " + beanName +" selectByNo(String " +  processField(columns.get(no)) + ") {");
////        write(bw,getTab(2) + "return " + processName(daoName) + ".selectByNo(" + processField(columns.get(no)) + ");");
////        write(bw,getTab(1) + "}");
////        bw = buildMethodComment(bw, "根据主键ID批量删除");
////        write(bw,getTab(1) + "@Override");
////        write(bw,getTab(1) + "public int deleteBatch(List<String> " + processName(beanName) +") {");
////        write(bw,getTab(2) + "return " + processName(daoName) + ".deleteBatch(" + processName(beanName) + ");");
////        write(bw,getTab(1) + "}");
////        bw = buildMethodComment(bw, "批量插入");
////        write(bw,getTab(1) + "@Override");
////        write(bw,getTab(1) + "public int addBatch(List<" + beanName + "> " + processName(beanName) +"s) {");
////        write(bw,getTab(2) + "return " + processName(daoName) + ".addBatch(" + processName(beanName) + "s);");
////        write(bw,getTab(1) + "}");
////        bw.newLine();
//		write(bw, "}");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 构建Server接口文件
//	 *
//	 * @throws IOException
//	 */
//	private void buildController(List<String> columns, List<String> types, List<String> comments, String tableComment,
//			String tableName) throws IOException {
//		File folder = new File(file_path + controller_path);
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//
//		File mapperFile = new File(file_path + controller_path, controllerName + ".java");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
//		write(bw, "package " + controller_package + ";");
//		bw.newLine();
//		write(bw, "import java.lang.reflect.InvocationTargetException;");
//		write(bw, "import javax.servlet.http.HttpServletRequest;");
//		write(bw, "import java.util.Date;");
//		write(bw, "import java.util.List;");
//		write(bw, "import java.util.LinkedHashMap;");
//		write(bw, "import java.text.SimpleDateFormat;");
//		write(bw, "import java.io.IOException;");
//		write(bw, "import java.io.OutputStream;");
//		write(bw, "import java.util.Map;");
//		write(bw, "import java.util.ArrayList;");
//		write(bw, "import javax.servlet.http.HttpServletResponse;");
//		write(bw, "import com.alibaba.fastjson.JSONObject;");
////		write(bw, "import org.apache.poi.hssf.usermodel.HSSFWorkbook;");
//		write(bw, "import org.springframework.web.bind.annotation.GetMapping;");
//		write(bw, "import org.springframework.beans.BeanUtils;");
//		write(bw, "import org.springframework.beans.factory.annotation.Autowired;");
//		write(bw, "import org.springframework.web.bind.annotation.PostMapping;");
//		write(bw, "import org.springframework.web.bind.annotation.RequestBody;");
//		write(bw, "import org.springframework.web.bind.annotation.RequestMapping;");
//		write(bw, "import org.springframework.web.bind.annotation.RestController;");
////		write(bw, "import com.xxl.core.components.excel.ExcelUtils;");
//		write(bw, "import com.xxl.common.exception.BusinessException;");
//		write(bw, "import com.xxl.common.response.BaseResponse;");
//		write(bw, "import com.xxl.common.tools.BeanTools;");
////		write(bw, "import com.xxl.core.base.utils.WebUtil;");
////		write(bw, "import com.xxl.auth.system.service.ISysMsgService;");
//		write(bw, "import " + bean_package + "." + beanName + ";");
//		write(bw, "import " + iservice_package + "." + iserviceName + ";");
//		write(bw, "import " + request_package + "." + XName + ";");
////		write(bw, "import " + request_package + "." + addVoName + ";");
////		write(bw, "import " + request_package + "." + upDateVoName + ";");
////		write(bw, "import " + request_package + "." + deleteVoName + ";");
////		write(bw, "import " + request_package + "." + queryName + ";");
////		write(bw, "import " + request_package + "." + XName + ";");
//		bw = buildClassComment(bw, tableComment + "服务");
//		write(bw, "@RestController");
//		write(bw, "@RequestMapping(value = \"" + base_url + processName(beanName) + "\")");
//		write(bw, "public class " + controllerName + " {");
//		bw.newLine();
//		write(bw, getTab(1) + "@Autowired");
//		write(bw, getTab(1) + "private " + iserviceName + " " + processName(iserviceName) + ";");
//		bw.newLine();
//		// 新增方法
//		bw = buildMethodComment(bw, "新增" + tableComment);
////        write(bw,getTab(1) + "@ApiOperation(\"新增" + tableComment + "\")");
//		write(bw, getTab(1) + "@PostMapping(value = \"add\")");
//		write(bw, getTab(1) + "public BaseResponse add(@RequestBody " + beanName
//				+ " obj,HttpServletRequest servletRequest) throws IllegalAccessException, InvocationTargetException {");
////		write(bw, getTab(2) + "BaseResponse baseResponse = new BaseResponse();");
//		write(bw, getTab(2) + beanName + " entity = new " + beanName + "();");
//		write(bw, getTab(2) + "BeanUtils.copyProperties(obj,entity);");
//		write(bw, getTab(2) + processName(iserviceName) + ".add(entity);");
//		write(bw, getTab(2) + "return BaseResponse.newSuccess();");
//		write(bw, getTab(1) + "}");
//
//		// 更新方法
//		bw = buildMethodComment(bw, "更新" + tableComment);
////        write(bw,getTab(1) + "@ApiOperation(\"更新" + tableComment + "\")");
//		write(bw, getTab(1) + "@PostMapping(value = \"update\")");
//		write(bw, getTab(1) + "public BaseResponse update(@RequestBody " + beanName
//				+ " obj,HttpServletRequest servletRequest) throws IllegalAccessException, InvocationTargetException {");
////		write(bw, getTab(2) + "BaseResponse baseResponse = new BaseResponse();");
//		write(bw, getTab(2) + beanName + " entity = new " + beanName + "();");
//		write(bw, getTab(2) + "BeanUtils.copyProperties(obj,entity);");
//		write(bw, getTab(2) + processName(iserviceName) + ".update(entity);");
////		write(bw, getTab(2) + "if (flag > 0) {");
////		write(bw, getTab(3) + "baseResponse.setResults(true);");
//////		write(bw, getTab(2) + "}");
////		write(bw, getTab(2) + "baseResponse.setCount(flag);");
////		write(bw, getTab(2) + "baseResponse.setMessage(sysMsgService.selectMsg(\"1000000\",\"" + tableComment
////				+ "更新成功!\"));");
//		write(bw, getTab(2) + "return BaseResponse.newSuccess();");
//		write(bw, getTab(1) + "}");
//
//		// 删除方法
//		bw = buildMethodComment(bw, "删除" + tableComment);
////        write(bw,getTab(1) + "@ApiOperation(\"删除" + tableComment + "\")");
//		write(bw, getTab(1) + "@PostMapping(value = \"delete\")");
//		write(bw, getTab(1) + "public BaseResponse delete(@RequestBody " + beanName
//				+ " paramVo,HttpServletRequest servletRequest) throws IllegalAccessException, InvocationTargetException {");
////		write(bw, getTab(2) + "BaseResponse baseResponse = new BaseResponse();");
////		write(bw, getTab(2) + "int count=0;");
//		/*
//		 * write(bw,"//" + getTab(2) + "for( String id : paramVo.get" +
//		 * processCapName(processField(columns.get(0))) + "()){"); write(bw,"//" +
//		 * getTab(3) + beanName + " obj = new " + beanName + "();"); write(bw,"//" +
//		 * getTab(3) + "obj.set" + processCapName(processField(columns.get(0))) +
//		 * "(id); //设置主键"); write(bw,"//" + getTab(3) + beanName + " " +
//		 * processName(beanName) + " = " + processName(serviceName) +
//		 * ".selectById(obj);"); write(bw,"//" + getTab(3) + "if( " +
//		 * processName(beanName) + " == null ){"); write(bw,"//" + getTab(4) +
//		 * "throw new BusinessException(\"-1000000\",\"" + tableComment +
//		 * "删除失败,不存在id: \" + obj.get" + processCapName(processField(columns.get(0))) +
//		 * "()); //根据实际修改"); write(bw,"//" + getTab(3) + "}"); write(bw,"//" + getTab(3)
//		 * + "int flag = " + processName(serviceName) + ".delete(obj);"); write(bw,"//"
//		 * + getTab(3) + "count=count+flag;"); write(bw,"//" + getTab(2) + "}");
//		 */
//		write(bw, getTab(2) + processName(iserviceName) + ".delete(paramVo);");
////		write(bw, getTab(2) + "baseResponse.setCount(count);");
////		write(bw, getTab(2) + "baseResponse.setResults(true);");
////		write(bw, getTab(2) + "baseResponse.setMessage(sysMsgService.selectMsg(\"1000000\",\"" + tableComment
////				+ "删除成功!\"));");
//		write(bw, getTab(2) + "return BaseResponse.newSuccess();");
//		write(bw, getTab(1) + "}");
//
//		// 查询方法
//		bw = buildMethodComment(bw, "分页查询" + tableComment);
////        write(bw,getTab(1) + "@ApiOperation(\"分页查询" + tableComment + "\")");
//		write(bw, getTab(1) + "@PostMapping(value = \"queryPageAll\")");
//		write(bw, getTab(1) + "public BaseResponse querylistByPage(@RequestBody " + XName
//				+ " paramVo,HttpServletRequest servletRequest) throws IllegalAccessException, InvocationTargetException {");
// 		write(bw, getTab(2) + "int pageIndex = paramVo.getPageIndex();");
// 		write(bw, getTab(2) + "int pageSize = paramVo.getPageSize();");
//		write(bw, getTab(2) + beanName + " entity = new " + beanName + "();");
//		write(bw, getTab(2) + "BeanUtils.copyProperties(paramVo,entity);");
//		write(bw, getTab(2) + "List<" + beanName + "> list = "+"(List<" + beanName + ">)"+ processName(iserviceName) + ".queryPageAll(entity, pageIndex, pageSize).getList();");
//		write(bw, getTab(2) + "return BaseResponse.newSuccess(list);");
//		write(bw, getTab(1) + "}");
//
////		// XXL查询方法
////		bw = buildMethodComment(bw, "XXL分页查询" + tableComment);
//////        write(bw,getTab(1) + "@ApiOperation(\"XXL分页查询" + tableComment + "\")");
////		write(bw, getTab(1) + "@PostMapping(value = \"queryXXL\")");
////		write(bw, getTab(1) + "public BaseResponse querylistByPage(@RequestBody " + XName
////				+ " QueryVo,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {");
////		write(bw, getTab(2) + "BaseResponse baseResponse = new BaseResponse();");
////		write(bw, getTab(2) + "Page page = new Page(QueryVo.getPageIndex(),QueryVo.getPageSize());");
////		write(bw, getTab(2) + "List<Map<String,Object>> list = " + processName(serviceName)
////				+ ".queryXXL(QueryVo, page);");
////		write(bw, getTab(2) + "baseResponse.setCount(page.gettotalRecord());");
////		write(bw, getTab(2) + "baseResponse.setResults(list);");
////		write(bw, getTab(2) + "baseResponse.setTotalPage(page.getPages());");
////		write(bw, getTab(2) + "baseResponse.setMessage(sysMsgService.selectMsg(\"1000000\",\"" + tableComment
////				+ "分页查询成功！\"));");
////		write(bw, getTab(2) + "return baseResponse;");
////		write(bw, getTab(1) + "}");
////
////		// 不带serach智能文本框
////		bw = buildMethodComment(bw, "不带serach智能文本框查询" + tableComment);
//////        write(bw,getTab(1) + "@ApiOperation(\"不带serach智能文本框查询" + tableComment + "\")");
////		write(bw, getTab(1) + "@PostMapping(value = \"querySuggest\")");
////		write(bw, getTab(1) + "public BaseResponse querySuggest(@RequestBody " + XName
////				+ " QueryVo,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {");
////		write(bw, getTab(2) + "BaseResponse baseResponse = new BaseResponse();");
////		write(bw, getTab(2) + "Page page = new Page(1,-1);");
////		write(bw, getTab(2) + "List<Map<String,Object>> list = " + processName(serviceName)
////				+ ".queryXXL(QueryVo, page);");
////		write(bw, getTab(2) + "baseResponse.setCount(page.gettotalRecord());");
////		write(bw, getTab(2) + "baseResponse.setResults(list);");
////		write(bw, getTab(2) + "baseResponse.setTotalPage(page.getPages());");
////		write(bw, getTab(2) + "baseResponse.setMessage(sysMsgService.selectMsg(\"1000000\",\"" + tableComment
////				+ "分页查询成功！\"));");
////		write(bw, getTab(2) + "return baseResponse;");
////		write(bw, getTab(1) + "}");
////
////		// 带serach智能文本框
////		bw = buildMethodComment(bw, "带serach智能文本框查询" + tableComment);
//////        write(bw,getTab(1) + "@ApiOperation(\"带serach智能文本框查询" + tableComment + "\")");
////		write(bw, getTab(1) + "@PostMapping(value = \"querySerachSuggest\")");
////		write(bw, getTab(1)
////				+ "public Map<String,Object> querySerachSuggest(HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException {");
////		write(bw, getTab(2) + "BaseResponse baseResponse = new BaseResponse();");
////		write(bw, getTab(2) + "Page page = new Page(1,-1);");
////		write(bw, getTab(2) + XName + " QueryVo = new " + XName + "();");
////		write(bw, getTab(2) + "String noOrName = request.getParameter(\"" + "name" + "\")" + ";");
////
////		write(bw, getTab(2) + "List<Map<String,Object>> list = " + processName(serviceName)
////				+ ".queryXXL(QueryVo, page);");
////		write(bw, getTab(2) + "baseResponse.setCount(page.gettotalRecord());");
////		write(bw, getTab(2) + "baseResponse.setResults(list);");
////		write(bw, getTab(2) + "baseResponse.setTotalPage(page.getPages());");
////		write(bw, getTab(2) + "baseResponse.setMessage(sysMsgService.selectMsg(\"1000000\",\"" + tableComment
////				+ "分页查询成功！\"));");
////		write(bw, getTab(2) + "return baseResponse;");
////		write(bw, getTab(1) + "}");
////
////		// 导出excel方法
////		bw = buildMethodComment(bw, "导出" + tableComment);
//////        write(bw,getTab(1) + "@ApiOperation(\"导出" + tableComment + "\")");
////		write(bw, getTab(1) + "@GetMapping(value = \"export\")");
////		write(bw, getTab(1)
////				+ "public void export(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InvocationTargetException {");
////		write(bw, getTab(2) + "Page page = new Page(1,-1);");
////		write(bw, getTab(2) + beanName + " entity = new " + beanName + "();");
////		write(bw, getTab(2) + "List<" + beanName + ">" + " " + processName(beanName) + "s = " + processName(serviceName)
////				+ ".queryAll(entity, page);");
////		write(bw, getTab(2) + "HSSFWorkbook wb = null;");
////		write(bw, getTab(2) + "Map<String, String> map = new LinkedHashMap<String, String>();");
////		int index = 0;
////		for (String column : columns) {
////			if ("version".equals(processField(columns.get(index)))
////					|| "createBy".equals(processField(columns.get(index)))
////					|| "createDate".equals(processField(columns.get(index)))
////					|| "updateBy".equals(processField(columns.get(index)))
////					|| "updateDate".equals(processField(columns.get(index)))) {
////				continue;
////			}
////			write(bw, getTab(2) + "map.put(\"" + column + "\",\"" + comments.get(index) + "\");");
////			index = index + 1;
////		}
////		write(bw, getTab(2) + "List<JSONObject> dataList = new ArrayList<JSONObject>();  ");
////		write(bw, getTab(2) + "for (" + beanName + " " + processName(beanName) + " : " + processName(beanName) + "s){");
////		write(bw, getTab(3) + "JSONObject params = new JSONObject(); ");
////		index = 0;
////		for (String column : columns) {
////			if ("version".equals(processField(columns.get(index)))
////					|| "createBy".equals(processField(columns.get(index)))
////					|| "createDate".equals(processField(columns.get(index)))
////					|| "updateBy".equals(processField(columns.get(index)))
////					|| "updateDate".equals(processField(columns.get(index)))) {
////				continue;
////			}
////			write(bw, getTab(3) + "params.put(\"" + column + "\"," + processName(beanName) + ".get"
////					+ processCapName(processField(columns.get(index))) + "());");
////			index = index + 1;
////		}
////		write(bw, getTab(3) + "dataList.add(params);");
////		write(bw, getTab(2) + "}");
////		write(bw, getTab(2) + "OutputStream ouput = null;");
////		write(bw, getTab(2) + "try {");
////		write(bw, getTab(3) + "wb = ExcelUtils.exportExcel(\"" + tableComment + "\", map, dataList);");
////		write(bw, getTab(3) + "SimpleDateFormat df = new SimpleDateFormat(\"yyyy-MM-dd\");");
////		write(bw, getTab(3) + "String date = df.format(new Date());");
////		write(bw, getTab(3) + "response.setContentType(\"application/vnd.ms-excel\");");
////		write(bw, getTab(3) + "response.setHeader(\"Content-disposition\", \"attachment;filename="
////				+ processName(beanName) + "(\" + date + " + "\").xls\");");
////		write(bw, getTab(3) + "ouput = response.getOutputStream();");
////		write(bw, getTab(3) + "wb.write(ouput);");
////		write(bw, getTab(3) + "ouput.flush();");
////		write(bw, getTab(3) + "wb.close();");
////		write(bw, getTab(3) + "ouput.close();");
////		write(bw, getTab(2) + "} catch (Exception e) {");
////		write(bw, getTab(3) + "e.printStackTrace(); ");
////		write(bw, getTab(2) + "} finally {");
////		write(bw, getTab(3) + "if (ouput != null) {");
////		write(bw, getTab(4) + "try {");
////		write(bw, getTab(5) + "ouput.close();");
////		write(bw, getTab(4) + "} catch (IOException e) {");
////		write(bw, getTab(5) + "e.printStackTrace();");
////		write(bw, getTab(4) + "}");
////		write(bw, getTab(3) + "}");
////		write(bw, getTab(2) + "}");
////		write(bw, getTab(1) + "}");
////
////		// 导出excel模板方法
////		bw = buildMethodComment(bw, "导出" + tableComment + "模板");
//////        write(bw,getTab(1) + "@ApiOperation(\"导出" + tableComment + "模板" + "\")");
////		write(bw, getTab(1) + "@GetMapping(value = \"exportTpl\")");
////		write(bw, getTab(1)
////				+ "public void exportTpl(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InvocationTargetException {");
////		write(bw, getTab(2) + "HSSFWorkbook wb = null;");
////		write(bw, getTab(2) + "Map<String, String> map = new LinkedHashMap<String, String>();");
////		index = 0;
////		for (String column : columns) {
////			if ("version".equals(processField(columns.get(index)))
////					|| "createBy".equals(processField(columns.get(index)))
////					|| "createDate".equals(processField(columns.get(index)))
////					|| "updateBy".equals(processField(columns.get(index)))
////					|| "updateDate".equals(processField(columns.get(index)))) {
////				continue;
////			}
////			write(bw, getTab(2) + "map.put(\"" + column + "\",\"" + comments.get(index) + "\");");
////			index = index + 1;
////		}
////		write(bw, getTab(2) + "List<JSONObject> dataList = new ArrayList<JSONObject>();  ");
////		write(bw, getTab(2) + "for (int i=0; i<1;i++) {");
////		write(bw, getTab(3) + "JSONObject params = new JSONObject(); ");
////		index = 0;
////		for (String column : columns) {
////			if ("version".equals(processField(columns.get(index)))
////					|| "createBy".equals(processField(columns.get(index)))
////					|| "createDate".equals(processField(columns.get(index)))
////					|| "updateBy".equals(processField(columns.get(index)))
////					|| "updateDate".equals(processField(columns.get(index)))) {
////				continue;
////			}
////			write(bw, getTab(3) + "params.put(\"" + column + "\",\"xxx\");");
////			index = index + 1;
////		}
////		write(bw, getTab(3) + "dataList.add(params);");
////		write(bw, getTab(2) + "}");
////		write(bw, getTab(2) + "OutputStream ouput = null;");
////		write(bw, getTab(2) + "try {");
////		write(bw, getTab(3) + "wb = ExcelUtils.exportExcel(\"" + tableComment + "\", map, dataList);");
////		write(bw, getTab(3) + "SimpleDateFormat df = new SimpleDateFormat(\"yyyy-MM-dd\");");
////		write(bw, getTab(3) + "String date = df.format(new Date());");
////		write(bw, getTab(3) + "response.setContentType(\"application/vnd.ms-excel\");");
////		write(bw, getTab(3) + "response.setHeader(\"Content-disposition\", \"attachment;filename="
////				+ processName(beanName) + "Tpl(\" + date + " + "\").xls\");");
////		write(bw, getTab(3) + "ouput = response.getOutputStream();");
////		write(bw, getTab(3) + "wb.write(ouput);");
////		write(bw, getTab(3) + "ouput.flush();");
////		write(bw, getTab(3) + "wb.close();");
////		write(bw, getTab(3) + "ouput.close();");
////		write(bw, getTab(2) + "} catch (Exception e) {");
////		write(bw, getTab(3) + "e.printStackTrace(); ");
////		write(bw, getTab(2) + "} finally {");
////		write(bw, getTab(3) + "if (ouput != null) {");
////		write(bw, getTab(4) + "try {");
////		write(bw, getTab(5) + "ouput.close();");
////		write(bw, getTab(4) + "} catch (IOException e) {");
////		write(bw, getTab(5) + "e.printStackTrace();");
////		write(bw, getTab(4) + "}");
////		write(bw, getTab(3) + "}");
////		write(bw, getTab(2) + "}");
////		write(bw, getTab(1) + "}");
//
//		write(bw, "}");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 获取属性
//	 */
//	private int getFiled(List<String> columns, String name) {
//		int result = -1;
//		boolean flag = true;
//		for (String column : columns) {
//			result = result + 1;
//			if (column.contains(name) || column.indexOf(name) > 0) {
//				flag = false;
//				break;
//			}
//		}
//		if (flag) {
//			result = 0;
//		}
//		return result;
//	}
//
//	private void buildInputFiled(BufferedWriter bw, List<String> columns, List<String> types, List<String> comments,
//			String tableComment, String tableName) throws IOException {
//		int index = 0;
//		for (String column : columns) {
//			if ("version".equals(processField(columns.get(index)))
//					|| "createBy".equals(processField(columns.get(index)))
//					|| "createDate".equals(processField(columns.get(index)))
//					|| "updateBy".equals(processField(columns.get(index)))
//					|| "updateDate".equals(processField(columns.get(index)))) {
//				continue;
//			}
//			if (index == 0) {
//				write(bw, getTab(8) + "<div class=\"form-group\" style=\"margin-bottom: 15px;\">");
//				write(bw, getTab(9) + "<input type=\"text\" id=\"" + processName(processField(column)) + "\" name=\""
//						+ processName(processField(column)) + "\" style=\"display:none;\">");
//			} else {
//				if ((index - 1) % 2 == 0 && index != 1) {
//					write(bw, getTab(8) + "<div class=\"form-group\" style=\"margin-bottom: 15px;\">");
//				}
//				if (index == 1) {
//					write(bw,
//							getTab(9) + "<label for=\"" + column
//									+ "\" class=\"col-xs-2 control-label\"><span class=\"x-red\">*</span>"
//									+ comments.get(index) + "</label>");
//				} else {
//					write(bw, getTab(9) + "<label for=\"" + column + "\" class=\"col-xs-2 control-label\">"
//							+ comments.get(index) + "</label>");
//				}
//				bw.newLine();
//				write(bw, getTab(9) + "<div class=\"col-xs-4\">");
//				write(bw, getTab(10) + "<input type=\"text\" autocomplete=\"off\" class=\"form-control\" id=\""
//						+ processName(processField(column)) + "\" name=\"" + processName(processField(column)) + "\">");
//				write(bw, getTab(9) + "</div>");
//				if (index % 2 == 0) {
//					write(bw, getTab(8) + "</div>");
//				}
//			}
//			index = index + 1;
//		}
//		if (index % 2 == 0) {
//			write(bw, getTab(8) + "</div>");
//		}
//	}
//
//	private void buildInputFiled_Use_Web_Framework(BufferedWriter bw, List<String> columns, List<String> types,
//			List<String> comments, String tableComment, String tableName) throws IOException {
//		int index = 0;
//		for (String column : columns) {
//			if ("version".equals(processField(columns.get(index)))
//					|| "createBy".equals(processField(columns.get(index)))
//					|| "createDate".equals(processField(columns.get(index)))
//					|| "updateBy".equals(processField(columns.get(index)))
//					|| "updateDate".equals(processField(columns.get(index)))) {
//				continue;
//			}
//			if (index == 0) {
//				write(bw, getTab(3) + "formList:[{");
//			} else {
//				if (index != 1) {
//					write(bw, getTab(3) + "},{");
//				}
//				String type = getType(types.get(index));
//				if ("remark".equals(column)) {
//					type = "area";
//				}
//				if ("is_edit".equals(column)) {
//					type = "switch";
//				}
//				write(bw, getTab(4) + "idName:'" + type + processCapName(processField(column)) + "',");
//				write(bw, getTab(4) + "text:'" + comments.get(index) + "',");
//				write(bw, getTab(4) + "field:'" + processField(columns.get(index)) + "',");
//				if ("area".equals(type)) {
//					write(bw, getTab(4) + "n:2,");
//				}
//				if ("switch".equals(type)) {
//					write(bw, getTab(4) + "ontext:'是',");
//					write(bw, getTab(4) + "offtext:'否',");
//				}
//				String validetype = getFiledType(types.get(index));
//				String max = getFiledMaxSize(types.get(index));
//				String min = "0";
//				write(bw, getTab(4) + "valid:['notEmpty',{type:\"" + validetype + "\",min:" + min + ",max:" + max
//						+ "}],");
//				if (index == 1) {
//					write(bw, getTab(4) + "disabled:type=='add'?false:true");
//				} else {
//					write(bw, getTab(4) + "disabled:type=='add'?false:false");
//				}
//			}
//			index = index + 1;
//		}
//		write(bw, getTab(3) + "}],");
//	}
//
//	/**
//	 * 构建html
//	 *
//	 * @throws IOException
//	 */
//	private void buildHtml(List<String> columns, List<String> types, List<String> comments, String tableComment,
//			String tableName) throws IOException {
//		File folder = new File(file_path + web_path + "/" + beanName);
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//
//		File mapperFile = new File(file_path + web_path + "/" + beanName, processName(beanName) + ".html");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
//		write(bw, "<!DOCTYPE html>");
//		write(bw, "<html>");
//		write(bw, getTab(1) + "<head>");
//		write(bw, getTab(2) + "<meta charset=\"UTF-8\">");
//		write(bw, getTab(2) + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
//		write(bw, getTab(2) + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
//		write(bw, getTab(2) + "<title>" + tableComment + "</title>");
//		write(bw, getTab(2) + "<link href=\"../../../dep/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" />");
//		write(bw,
//				getTab(2) + "<link href=\"../../../dep/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2) + "<link href=\"../../../dep/layui/css/x-admin.css\" rel=\"stylesheet\" media=\"all\">");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrap-switch/css/bootstrap3/bootstrap-switch.min.css\" rel=\"stylesheet\">");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrapValidator/css/bootstrapValidator.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrap-datetimepicker_new/css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrap-table/bootstrap-table.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2) + "<link href=\"../../../css/bootstrap-small.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(1) + "</head>");
//		write(bw, getTab(1) + "<body>");
//		write(bw, getTab(2) + "<div class=\"panel-body\" style=\"padding-bottom:0px;\">");
//		write(bw, getTab(3) + "<div class=\"panel panel-default\">");
//		write(bw, getTab(4) + "<div class=\"panel-heading\"><span class=\"dot\"></span>查询");
//		write(bw, getTab(5) + "<span class=\"closeBtn\" onclick=\"closeBtn()\"></span>");
//		write(bw, getTab(5) + "<span class=\"openBtn\" onclick=\"openBtn()\"></span>");
//		write(bw, getTab(4) + "</div>");
//		write(bw, getTab(4) + "<div class=\"panel-body\">");
//		write(bw, getTab(5) + "<form id=\"formSearch\" class=\"form-horizontal\">");
//		write(bw, getTab(6) + "<div class=\"form-group\">");
//		int no = getFiled(columns, "no");
//		write(bw, getTab(7) + "<div class=\"row\">");
//		write(bw, getTab(8) + "<label class=\"control-label\" for=\"search_" + columns.get(no) + "\">"
//				+ comments.get(no) + "</label>");
//		write(bw, getTab(8) + "<div class=\"col-sm-2\">");
//		write(bw, getTab(9) + "<input type=\"text\" class=\"form-control\" id=\"search_" + columns.get(no)
//				+ "\" name=\"search_" + columns.get(no) + "\">");
//		write(bw, getTab(8) + "</div>");
//		int name = getFiled(columns, "name");
//		write(bw, getTab(8) + "<label class=\"control-label\" for=\"search_" + columns.get(name) + "\">"
//				+ comments.get(name) + "</label>");
//		write(bw, getTab(8) + "<div class=\"col-sm-2\">");
//		write(bw, getTab(9) + "<input type=\"text\" class=\"form-control\" id=\"search_" + columns.get(name)
//				+ "\" name=\"search_" + columns.get(name) + " \">");
//		write(bw, getTab(8) + "</div>");
//		write(bw, getTab(8) + "<div>");
//		write(bw, getTab(9)
//				+ "<button type=\"button\" id=\"btn_query\" onclick=\"queryInfo();\" class=\"btn btn-primary\">");
//		write(bw, getTab(10) + "搜索");
//		write(bw, getTab(9) + "</button>");
//		write(bw, getTab(9) + "<button type=\"reset\" id=\"btn_clear\" class=\"btn btn-danger\">");
//		write(bw, getTab(10) + "清除");
//		write(bw, getTab(9) + "</button>");
//		write(bw, getTab(8) + "</div>");
//		write(bw, getTab(7) + "</div>");
//		write(bw, getTab(6) + "</div>");
//		write(bw, getTab(5) + "</form>");
//		write(bw, getTab(4) + "</div>");
//		write(bw, getTab(3) + "</div>");
//		write(bw, getTab(3) + "<div id=\"toolbar\" class=\"btn-group1\">");
//		write(bw, getTab(4)
//				+ "<button id=\"btn_add\" type=\"button\" class=\"btn btn-primary\" onclick=\"openAddWin();\">");
//		write(bw, getTab(5) + "新增");
//		write(bw, getTab(4) + "</button>");
//		write(bw, getTab(4)
//				+ "<button id=\"btn_edit\" type=\"button\" class=\"btn btn-info\" onclick=\"openEditWin();\">");
//		write(bw, getTab(5) + "编辑");
//		write(bw, getTab(4) + "</button>");
//		write(bw, getTab(4)
//				+ "<button id=\"btn_delete\" type=\"button\" class=\"btn btn-danger\" onclick=\"deleteInfo();\">");
//		write(bw, getTab(5) + "删除");
//		write(bw, getTab(4) + "</button>");
//		write(bw, getTab(3) + "</div>");
//		bw.newLine();
//		write(bw, getTab(3) + "<table id=\"tb_" + processName(beanName) + "\" data-pagination=\"true\"></table>");
//		bw.newLine();
//		write(bw, getTab(3) + "<!--新增窗口-->");
//		write(bw, getTab(3) + "<div class=\"modal fade\" role=\"dialog\" id=\"addModal\">");
//		write(bw, getTab(4) + "<div class=\"modal-dialog\" style=\"top:70px;width:800px;hight:600px\">");
//		write(bw, getTab(5) + "<div class=\"modal-content\">");
//		write(bw, getTab(6) + "<div class=\"modal-header\" style=\"border-bottom: 1px solid #F4F4F4;\">");
//		write(bw, getTab(7) + "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">");
//		write(bw, getTab(8) + "&times;");
//		write(bw, getTab(7) + "</button>");
//		write(bw, getTab(7) + "<h4 class=\"modal-title\" id=\"titleId\">新增</h4>");
//		write(bw, getTab(6) + "</div>");
//		int add_height = 75 + (columns.size() - 5) / 2 * 30;
//		write(bw, getTab(6) + "<div class=\"modal-body\" style=\"height:" + add_height + "px\">");
//		write(bw, getTab(7) + "<form class=\"form-horizontal\" id=\"formEdit\">");
//		buildInputFiled(bw, columns, types, comments, tableComment, tableName);
//		write(bw, getTab(7) + "</form>");
//		write(bw, getTab(6) + "</div>");
//		write(bw, getTab(6) + "<div class=\"modal-footer\">");
//		write(bw, getTab(7)
//				+ "<button type=\"button\" class=\"btn btn-default saveBtn\" onclick=\"saveInfo()\">保存</button>");
//		write(bw, getTab(7) + "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>");
//		write(bw, getTab(6) + "</div>");
//		write(bw, getTab(5) + "</div>");
//		write(bw, getTab(4) + "</div>");
//		write(bw, getTab(3) + "</div>");
//		write(bw, getTab(2) + "</div>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/jquery-1.9.1.min.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/jquery.cookie.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../js/extensions/jquery-ajax.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/bootstrap/js/bootstrap.min.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/bootstrap-table/bootstrap-table.min.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/bootstrap-table/locale/bootstrap-table-zh-CN.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/bootstrap-switch/js/bootstrap-switch.min.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/layui/layui.js\" charset=\"utf-8\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/layui/x-layui.js\" charset=\"utf-8\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../dep/bootstrapValidator/js/bootstrapValidator.min.js\"></script>");
//		write(bw, getTab(2)
//				+ "<script src=\"../../../dep/bootstrap-datetimepicker_new/js/bootstrap-datetimepicker.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../js/EwinCommon/common.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"" + processName(beanName) + ".js\"></script>");
//		write(bw, getTab(1) + "</body>");
//		write(bw, "</html>");
//		bw.flush();
//		bw.close();
//	}
//
//	private String getFiledSize(String type) {
//		String result = "";
//		if ((type.contains("varchar") || type.contains("int") || type.contains("float") || type.contains("double"))
//				&& type.contains("(")) {
//			int startIndex = type.indexOf("(");
//			int endIndex = type.indexOf(")");
//			result = type.substring(startIndex + 1, endIndex);
//		}
//		return result;
//	}
//
//	private String getFiledMaxSize(String type) {
//		String result = "";
//		if ((type.contains("varchar") || type.contains("int") || type.contains("float") || type.contains("double"))
//				&& type.contains("(")) {
//			int startIndex = type.indexOf("(");
//			int endIndex = type.indexOf(")");
//			result = type.substring(startIndex + 1, endIndex);
//		}
//		return result;
//	}
//
//	private String getFiledType(String column) {
//		String result = "string";
//		if (column.contains("varchar")) {
//			result = "string";
//		}
//		if (column.contains("int") || column.contains("float") || column.contains("double")) {
//			result = "number";
//		}
//		return result;
//	}
//
//	private String getType(String column) {
//		String result = "text";
//		if (column.contains("varchar") || column.contains("char") || column.contains("char")) {
//			result = "text";
//		}
//		if (column.contains("int") || column.contains("float") || column.contains("double")
//				|| column.contains("tinyint") || column.contains("integer") || column.contains("bigint")
//				|| column.contains("decimal") || column.contains("numeric")) {
//			result = "number";
//		}
//		if (column.contains("date")) {
//			result = "day";
//		}
//		return result;
//	}
//
//	private void buildValidFiled(BufferedWriter bw, List<String> columns, List<String> types, List<String> comments,
//			String tableComment, String tableName) throws IOException {
//		write(bw, getTab(1) + "$('#formEdit').bootstrapValidator({");
//		write(bw, getTab(2) + "message: '验证不通过',");
//		write(bw, getTab(2) + "feedbackIcons: {");
//		write(bw, getTab(3) + "valid: 'glyphicon glyphicon-ok',");
//		write(bw, getTab(3) + "invalid: 'glyphicon glyphicon-remove',");
//		write(bw, getTab(3) + "validating: 'glyphicon glyphicon-refresh'");
//		write(bw, getTab(2) + "},");
//		write(bw, getTab(2) + "fields: {");
//		int index = 0;
//		for (String column : columns) {
//			if ("version".equals(processField(columns.get(index)))
//					|| "createBy".equals(processField(columns.get(index)))
//					|| "createDate".equals(processField(columns.get(index)))
//					|| "updateBy".equals(processField(columns.get(index)))
//					|| "updateDate".equals(processField(columns.get(index)))) {
//				continue;
//			}
//			if (index != 0) {
//				write(bw, getTab(3) + processName(processField(column)) + ": {");
//				write(bw, getTab(4) + "validators: {");
//				if (index == 1) {
//					write(bw, getTab(5) + "notEmpty: {");
//					write(bw, getTab(6) + "message: " + "'" + comments.get(index) + "不能为空'");
//					write(bw, getTab(5) + "},");
//				}
//				write(bw, getTab(5) + "stringLength: {");
//				write(bw, getTab(6) + "min: 0,");
//				write(bw, getTab(6) + "max: " + getFiledSize(types.get(index)) + ",");
//				write(bw, getTab(6) + "message: " + "'" + comments.get(index) + "长度不能超过"
//						+ getFiledSize(types.get(index)) + "'");
//				write(bw, getTab(5) + "}");
//				write(bw, getTab(4) + "}");
//				if (index != columns.size() - 6) {
//					write(bw, getTab(3) + "},");
//				} else {
//					write(bw, getTab(3) + "}");
//				}
//			}
//			index = index + 1;
//		}
//		write(bw, getTab(2) + "}");
//		write(bw, getTab(1) + "});");
//	}
//
//	private void buildTableFiled(BufferedWriter bw, List<String> columns, List<String> types, List<String> comments,
//			String tableComment, String tableName) throws IOException {
//		int index = 0;
//		for (String column : columns) {
//			if ("version".equals(processField(columns.get(index)))
//					|| "createBy".equals(processField(columns.get(index)))
//					|| "createDate".equals(processField(columns.get(index)))
//					|| "updateBy".equals(processField(columns.get(index)))
//					|| "updateDate".equals(processField(columns.get(index)))) {
//				continue;
//			}
//			write(bw, getTab(2) + "},{");
//			write(bw, getTab(3) + "field: '" + processField(column) + "',");
//			write(bw, getTab(3) + "title: '" + comments.get(index) + "',");
//			write(bw, getTab(3) + "align: 'center'");
//			if (index == columns.size() - 6) {
//				write(bw, getTab(2) + "}]");
//			}
//			index = index + 1;
//		}
//	}
//
//	private void buildTableFiled_Use_Web_Framework(BufferedWriter bw, List<String> columns, List<String> types,
//			List<String> comments, String tableComment, String tableName) throws IOException {
//		int index = 0;
//		for (String column : columns) {
//			if ("version".equals(processField(columns.get(index)))
//					|| "createBy".equals(processField(columns.get(index)))
//					|| "createDate".equals(processField(columns.get(index)))
//					|| "updateBy".equals(processField(columns.get(index)))
//					|| "updateDate".equals(processField(columns.get(index)))) {
//				continue;
//			}
//			write(bw, getTab(3) + "},{");
//			write(bw, getTab(4) + "field: '" + processField(column) + "',");
//			write(bw, getTab(4) + "title: '" + comments.get(index) + "',");
//			write(bw, getTab(4) + "align: 'center',");
//			write(bw, getTab(4) + "sortable:true");
//			if (index == columns.size() - 6) {
//				write(bw, getTab(3) + "}]");
//			}
//			index = index + 1;
//		}
//	}
//
//	/**
//	 * 构建js
//	 *
//	 * @throws IOException
//	 */
//	private void buildJs(List<String> columns, List<String> types, List<String> comments, String tableComment,
//			String tableName) throws IOException {
//		File folder = new File(file_path + web_path + "/" + beanName);
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//
//		File mapperFile = new File(file_path + web_path + "\\" + beanName, processName(beanName) + ".js");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
//		write(bw, "var mod_flag;");
//		bw.newLine();
//		write(bw, "$(function () {");
//		write(bw, getTab(1) + "//getDictionary('SPECIALDATE_TYPE','search_type'); //数据字典下拉");
//		write(bw, getTab(1) + "initTable();");
//		write(bw, getTab(1) + "validForm();");
//		write(bw, getTab(1) + "layui.use(['layer'], function(){");
//		write(bw, getTab(2) + "layer = layui.layer;//弹出层");
//		write(bw, getTab(1) + "});");
//		write(bw, "});");
//		bw.newLine();
//		write(bw, "function validForm(){");
//		buildValidFiled(bw, columns, types, comments, tableComment, tableName);
//		write(bw, "};");
//		bw.newLine();
//		write(bw, "function initTable(){");
//		write(bw, getTab(1) + "$('#tb_" + processName(beanName) + "').bootstrapTable({");
//		write(bw, getTab(2) + "url: apiUrl + \"" + base_url + processName(beanName)
//				+ "/querylistByPage\",         //请求后台的URL（*）");
//		write(bw, getTab(2) + "method: 'post',                              //请求方式（*）");
//		write(bw, getTab(2) + "toolbar: '#toolbar',                         //工具按钮用哪个容器");
//		write(bw, getTab(2) + "showExport: false,                           //是否显示导出");
//		write(bw, getTab(2) + "exportDataType: 'all',                       //basic', 'all', 'selected'");
//		write(bw, getTab(2) + "striped: true,                               //是否显示行间隔色");
//		write(bw, getTab(2) + "cache: false,                                //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）");
//		write(bw, getTab(2) + "pagination: true,                            //是否显示分页（*）");
//		write(bw, getTab(2) + "dataField: 'data',			   	           //这是返回的json数组的key.默认好像是'rows'.这里只有前后端约定好就行");
//		write(bw, getTab(2) + "sortable: false,                             //是否启用排序");
//		write(bw, getTab(2) + "sortOrder: 'asc',                            //排序方式");
//		write(bw, getTab(2) + "queryParams:function queryParams(params) {   //设置查询参数");
//		write(bw, getTab(3) + "var temp = {                                 //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的");
//		write(bw, getTab(4) + "pageSize: params.limit,                      //页面大小");
//		write(bw, getTab(4) + "pageIndex : params.offset/params.limit+1,    //当前页面,默认是上面设置的1(pageNumber)");
//		write(bw, getTab(3) + "};");
//		write(bw, getTab(3) + "return temp;");
//		write(bw, getTab(2) + "},");
//		write(bw, getTab(2) + "sidePagination: 'server',           //分页方式：client客户端分页，server服务端分页（*）");
//		write(bw, getTab(2) + "pageNumber:1,                       //初始化加载第一页，默认第一页");
//		write(bw, getTab(2) + "pageSize: 10,                       //每页的记录行数（*）");
//		write(bw, getTab(2) + "pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）");
//		write(bw, getTab(2) + "search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端");
//		write(bw, getTab(2) + "strictSearch: true,");
//		write(bw, getTab(2) + "showColumns: false,                  //是否显示所有的列");
//		write(bw, getTab(2) + "showRefresh: false,                  //是否显示刷新按钮");
//		write(bw, getTab(2) + "minimumCountColumns: 2,             //最少允许的列数");
//		write(bw, getTab(2) + "clickToSelect: true,                //是否启用点击选中行");
//		write(bw, getTab(2) + "height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度");
//		write(bw, getTab(2) + "uniqueId: '" + processField(columns.get(0)) + "',     //每一行的唯一标识，一般为主键列");
//		write(bw, getTab(2) + "showToggle:false,                   //是否显示详细视图和列表视图的切换按钮");
//		write(bw, getTab(2) + "cardView: false,                    //是否显示详细视图");
//		write(bw, getTab(2) + "detailView: false,                   //是否显示父子表");
//		write(bw, getTab(2) + "responseHandler:function(res){");
//		write(bw, getTab(3) + "var errcode = res.code;//在此做了错误代码的判断");
//		write(bw, getTab(3) + "if(errcode != 10000){");
//		write(bw, getTab(4) + "layer.msg(res.message,{icon:2,time:1000});");
//		write(bw, getTab(4) + "return;");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(3) + "return {");
//		write(bw, getTab(4) + "total : res.count, //总页数,前面的key必须为'total'");
//		write(bw, getTab(4) + "data : res.results //行数据，前面的key要与之前设置的dataField的值一致.");
//		write(bw, getTab(3) + "};");
//		write(bw, getTab(2) + "},");
//		write(bw, getTab(2) + "columns: [{");
//		write(bw, getTab(3) + "checkbox: true");
//		buildTableFiled(bw, columns, types, comments, tableComment, tableName);
//		bw.newLine();
//		write(bw, getTab(1) + "});");
//		write(bw, "};");
//		bw.newLine();
//		write(bw, "function queryInfo(){");
//		write(bw, getTab(1) + "$('#tb_" + processName(beanName) + "').bootstrapTable(\"refresh\");");
//		write(bw, "};");
//		bw.newLine();
//		write(bw, "$(\"#addModal\").on(\"hidden.bs.modal\", function() {");
//		write(bw, getTab(1) + "var form = $(\"#formEdit\");");
//		write(bw, getTab(1) + "$(this).removeData(\"bs.modal\");");
//		write(bw, getTab(1) + "form[0].reset();");
//		write(bw, getTab(1) + "form.data('bootstrapValidator').resetForm();  ");
//		write(bw, "});");
//		bw.newLine();
//		write(bw, "//打开新增窗口");
//		write(bw, "function openAddWin(){");
//		write(bw, getTab(1) + "mod_flag = 0;");
//		write(bw, getTab(1) + "$(\"#titleId\").html('新增');");
//		write(bw, getTab(1) + "$('#addModal').modal(\"show\");");
//		write(bw, "}");
//		bw.newLine();
//		write(bw, "//打开编辑窗口");
//		write(bw, "function openEditWin(){");
//		write(bw, getTab(1) + "var form = $(\"#formEdit\");");
//		write(bw, getTab(1) + "var rows = $(\"#tb_" + processName(beanName) + "\").bootstrapTable('getSelections');");
//		write(bw, getTab(1) + "if (rows.length < 1) {");
//		write(bw, getTab(2) + "layer.msg(\"没有选择的数据！\",{icon:7,time:1000});");
//		write(bw, getTab(2) + "return;");
//		write(bw, getTab(1) + "}");
//		write(bw, getTab(1) + "if (rows.length > 1) {");
//		write(bw, getTab(2) + "layer.msg(\"只能选择一条数据！\",{icon:7,time:1000});");
//		write(bw, getTab(2) + "return;");
//		write(bw, getTab(2) + "}");
//		write(bw, getTab(1) + "var row = rows[0];");
//		write(bw, getTab(1) + "setFormValue(form,row);");
//		write(bw, getTab(1) + "$(\"#titleId\").html('编辑');");
//		write(bw, getTab(1) + "mod_flag = 1;");
//		write(bw, getTab(1) + "$('#addModal').modal(\"show\");");
//		write(bw, "}");
//		bw.newLine();
//		write(bw, "//保存信息");
//		write(bw, "function saveInfo(){");
//		write(bw, getTab(1) + "var form = $('#formEdit');");
//		write(bw, getTab(1) + "form.data('bootstrapValidator').validate();");
//		write(bw, getTab(1) + "if(!form.data('bootstrapValidator').isValid()){");
//		write(bw, getTab(2) + "return;");
//		write(bw, getTab(1) + "}");
//		write(bw, getTab(1) + "var data=$('#formEdit').serializeObject();");
//		write(bw, getTab(1) + "data=JSON.stringify(data);");
//		write(bw, getTab(1) + "if (mod_flag == 0){");
//		write(bw, getTab(2) + "url = apiUrl + \"" + base_url + processName(beanName) + "/add\";");
//		write(bw, getTab(1) + "} else {");
//		write(bw, getTab(2) + "url = apiUrl + \"" + base_url + processName(beanName) + "/update\";");
//		write(bw, getTab(1) + "}");
//		write(bw, getTab(1) + "$.ajax({");
//		write(bw, getTab(2) + "type: 'POST',");
//		write(bw, getTab(2) + "url: url,");
//		write(bw, getTab(2) + "data: data,");
//		write(bw, getTab(2) + "dataType: 'json',");
//		write(bw, getTab(2) + "contentType: \"application/json\",");
//		write(bw, getTab(2) + "success: function (data, textStatus, jqXHR) {");
//		write(bw, getTab(3) + "var errcode = data.code;//在此做了错误代码的判断");
//		write(bw, getTab(3) + "if(errcode != 10000){");
//		write(bw, getTab(4) + "layer.msg(data.message,{icon:2,time:1000});");
//		write(bw, getTab(4) + "return;");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(3) + "$('#addModal').modal('hide');");
//		write(bw, getTab(3) + "$('#tb_" + processName(beanName) + "').bootstrapTable(\"refresh\");");
//		write(bw, getTab(3) + "layer.msg('保存成功!',{icon:1,time:1000});");
//		write(bw, getTab(2) + "}");
//		write(bw, getTab(1) + "});");
//		write(bw, "}");
//		bw.newLine();
//		write(bw, "//删除");
//		write(bw, "function deleteInfo(){");
//		write(bw, getTab(1) + "var rows = $(\"#tb_" + processName(beanName) + "\").bootstrapTable(\"getSelections\");");
//		write(bw, getTab(1) + "if (rows.length < 1) {");
//		write(bw, getTab(2) + "layer.msg(\"没有选择的数据！\",{icon:2,time:1000});");
//		write(bw, getTab(2) + "return;");
//		write(bw, getTab(1) + "}");
//		write(bw, getTab(1) + "layer.confirm('删除数据不可恢复，确定删除吗？',{icon:3,time:1000},function(index){");
//		write(bw, getTab(2) + "var rowid = [];");
//		write(bw, getTab(2) + "$.each(rows, function (index, row) {");
//		write(bw, getTab(3) + "rowid.push(row." + processField(columns.get(0)) + ");");
//		write(bw, getTab(2) + "});");
//		write(bw, getTab(2) + "data={" + processField(columns.get(0)) + ":rowid}");
//		write(bw, getTab(2) + "$.ajax({");
//		write(bw, getTab(3) + "type: \"POST\",");
//		write(bw, getTab(3) + "url: apiUrl + \"" + base_url + processName(beanName) + "/delete\",");
//		write(bw, getTab(3) + "data: JSON.stringify(data),");
//		write(bw, getTab(3) + "dataType: \"json\",");
//		write(bw, getTab(3) + "contentType: \"application/json\",");
//		write(bw, getTab(3) + "success: function (data) {");
//		write(bw, getTab(4) + "var errcode = data.code;//在此做了错误代码的判断");
//		write(bw, getTab(4) + "if(errcode != 10000){");
//		write(bw, getTab(5) + "alert(\"错误消息: \" + data.message);");
//		write(bw, getTab(5) + "return;");
//		write(bw, getTab(4) + "}");
//		write(bw, getTab(4) + "$('#tb_" + processName(beanName)
//				+ "').bootstrapTable(\"refreshOptions\",{pageNumber:1});");
//		write(bw, getTab(4) + "layer.msg('删除成功!',{icon:1,time:1000});");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "});");
//		write(bw, getTab(1) + "});");
//		write(bw, "}");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 构建html
//	 *
//	 * @throws IOException
//	 */
//	private void buildHtml_Use_Web_Framework(List<String> columns, List<String> types, List<String> comments,
//			String tableComment, String tableName) throws IOException {
//		File folder = new File(file_path + web_path + "/" + beanName);
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//		File mapperFile = new File(file_path + web_path + "/" + beanName, processName(beanName) + ".html");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
//		write(bw, "<!DOCTYPE html>");
//		write(bw, "<html>");
//		write(bw, getTab(1) + "<head>");
//		write(bw, getTab(2) + "<meta charset=\"UTF-8\">");
//		write(bw, getTab(2) + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
//		write(bw, getTab(2) + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
//		write(bw, getTab(2) + "<title>" + tableComment + "</title>");
//		write(bw, getTab(2) + "<link href=\"../../../dep/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" />");
//		write(bw,
//				getTab(2) + "<link href=\"../../../dep/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrap-table/bootstrap-table.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2) + "<link href=\"../../../css/bootstrap-small.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2) + "<link href=\"../../../dep/layui/css/x-admin.css\" rel=\"stylesheet\" media=\"all\">");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrap-switch/css/bootstrap3/bootstrap-switch.min.css\" rel=\"stylesheet\">");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrapValidator/css/bootstrapValidator.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrap3-editable/css/bootstrap-editable.css\" rel=\"stylesheet\" />");
//		write(bw,
//				getTab(2) + "<link href=\"../../../dep/select2-4.0.3/dist/css/select2.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../dep/bootstrap-datapicker/dist-min/css/datepicker3.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2)
//				+ "<link href=\"../../../bootstrap-datetimepicker_new/css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2) + "<link href=\"../../../css/EwinCommon/newcommon.css\" rel=\"stylesheet\" />");
//		write(bw, getTab(2) + "<!--[if lt IE 9]>");
//		write(bw, getTab(2) + "<script src=\"../../../Scripts/html5shiv.js\"></script>");
//		write(bw, getTab(2) + "<script src=\"../../../Scripts/respond.min.js\"></script>");
//		write(bw, getTab(2) + "<![endif]-->");
//		write(bw, getTab(1) + "</head>");
//		write(bw, getTab(1) + "<body style=\"min-width: 1024px\">");
//		write(bw, getTab(2) + "<div class=\"panel-body\" style=\"padding-bottom:0px;\">");
//		write(bw, getTab(3) + "<!--搜索框-->");
//		write(bw, getTab(3) + "<div class=\"panel panel-default searchForm\" style=\"margin-top: 20px\"></div>");
//		write(bw, getTab(3) + "<!--表格-->");
//		write(bw, getTab(3) + "<div class=\"mainTable\" style=\"float: left; width: 100%\"></div>");
//		write(bw, getTab(3) + "<!--弹出框-->");
//		write(bw, getTab(3)
//				+ "<div id=\"mainFromEdit\" class=\"modal fade\" role=\"dialog\" data-backdrop=\"static\"></div>");
//		write(bw, getTab(2) + "</div>");
//		write(bw, getTab(1) + "</body>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/jquery-1.9.1.min.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/jquery.cookie.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../js/extensions/jquery-ajax.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/bootstrap/js/bootstrap.min.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/bootstrap-table/bootstrap-table.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/bootstrap-table/locale/bootstrap-table-zh-CN.js\"></script>");
//		write(bw,
//				getTab(1) + "<script src=\"../../../dep/bootstrap-table/extensions/export/tableExport.js\"></script>");
//		write(bw, getTab(1)
//				+ "<script src=\"../../../dep/bootstrap-table/extensions/export/bootstrap-table-export.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/bootstrap3-editable/js/bootstrap-editable.js\"></script>");
//		write(bw, getTab(1)
//				+ "<script src=\"../../../dep/bootstrap-table/extensions/editable/bootstrap-table-editable.min.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/layui/layui.js\" charset=\"utf-8\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/layui/x-layui.js\" charset=\"utf-8\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/bootstrap-switch/js/bootstrap-switch.min.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/bootstrapValidator/js/bootstrapValidator.min.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../dep/select2-4.0.3/dist/js/select2.min.js\"></script>");
//		write(bw, getTab(1)
//				+ "<script src=\"../../../dep/bootstrap-datapicker/dist-min/js/bootstrap-datepicker.js\"></script>");
//		write(bw, getTab(1)
//				+ "<script src=\"../../../dep/bootstrap-datetimepicker_new/js/bootstrap-datetimepicker.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"../../../js/EwinCommon/newcommon.js\"></script>");
//		write(bw, getTab(1) + "<script src=\"" + processName(beanName) + ".js\"></script>");
//		write(bw, "</html>");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 构建js
//	 *
//	 * @throws IOException
//	 */
//	private void buildJs_Use_Web_Framework(List<String> columns, List<String> types, List<String> comments,
//			String tableComment, String tableName) throws IOException {
//		File folder = new File(file_path + web_path + "/" + beanName);
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//
//		File mapperFile = new File(file_path + web_path + "\\" + beanName, processName(beanName) + ".js");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperFile), "utf-8"));
//		write(bw, "layui.use('layer',function(){");
//		write(bw, getTab(1) + "layer=layui.layer;");
//		write(bw, "});");
//		bw.newLine();
//		write(bw, "$(function(){");
//		write(bw, getTab(1) + "//搜索条件");
//		write(bw, getTab(1) + "var mainSearchData=[{");
//		int no = getFiled(columns, "no");
//		if (no > 0) {
//			write(bw, getTab(2) + "idName:'textSearch" + processCapName(processField(columns.get(no))) + "',");
//			write(bw, getTab(2) + "text:'" + comments.get(no) + "',");
//			write(bw, getTab(2) + "field:'" + processField(columns.get(no)) + "'");
//		}
//		int name = getFiled(columns, "name");
//		if (name > 0) {
//			write(bw, getTab(1) + "},{");
//			write(bw, getTab(2) + "idName:'textSearch" + processCapName(processField(columns.get(name))) + "',");
//			write(bw, getTab(2) + "text:'" + comments.get(name) + "',");
//			write(bw, getTab(2) + "field:'" + processField(columns.get(name)) + "'");
//		}
//		write(bw, getTab(1) + "}]");
//		bw.newLine();
//		write(bw, getTab(1) + "Ew.search('.searchForm',{");
//		write(bw, getTab(2) + "title:'查询',");
//		write(bw, getTab(2) + "textValues:mainSearchData,");
//		write(bw, getTab(2) + "btnValues:[{");
//		write(bw, getTab(3) + "btnId:'btnSearch',");
//		write(bw, getTab(3) + "text:'搜索',");
//		write(bw, getTab(3) + "onClick:function(data){");
//		String tableId = "table" + beanName;
//		write(bw, getTab(4) + "$('#" + tableId + "').bootstrapTable('refresh');");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "},{");
//		write(bw, getTab(3) + "btnId:'btnClear',");
//		write(bw, getTab(3) + "text:'重置',");
//		write(bw, getTab(3) + "tableid:['" + tableId + "']");
//		write(bw, getTab(2) + "}]");
//		write(bw, getTab(1) + "});");
//		bw.newLine();
//		write(bw, getTab(1) + "//主表格");
//		write(bw, getTab(1) + "Ew.table('.mainTable',{");
//		write(bw, getTab(2) + "btnValues:[{");
//		write(bw, getTab(3) + "btnId:'BtnAdd',text:'新增',onClick:function(){");
//		write(bw, getTab(4) + "daliogShow('add');");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "},{");
//		write(bw, getTab(3) + "btnId:'BtnEdit',text:'编辑',otherOption:[{id:'" + tableId
//				+ "',selectNum: 1}],onClick:function(){");
//		write(bw, getTab(4) + "daliogShow('change');");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "},{");
//		write(bw, getTab(3) + "btnId:'BtnDelete',text:'删除',isTrue:true,otherOption:[{id:'" + tableId
//				+ "',selMinNum: 1}],onClick:function(){");
//		write(bw, getTab(4) + "var rows = $('#" + tableId + "').bootstrapTable('getSelections');");
//		write(bw, getTab(4) + "ids = [];");
//		write(bw, getTab(4) + "var flag = true;");
//		write(bw, getTab(4) + "$.each(rows,function(index,row){");
//		write(bw, getTab(5) + "ids.push(row." + processField(columns.get(0)) + ");");
//		write(bw, getTab(4) + "});");
//		write(bw, getTab(4) + "datas = JSON.stringify({" + processField(columns.get(0)) + " : ids});");
//		write(bw, getTab(4) + "var url = '" + base_url + processName(beanName) + "/delete'");
//		write(bw, getTab(4) + "$.when(Ew.ewAjax(url,datas)).done(function(results){");
//		write(bw, getTab(5) + "$('#" + tableId + "').bootstrapTable('refresh');");
//		write(bw, getTab(4) + "});");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "},{");
//		write(bw, getTab(3) + "btnId:'BtnExportTpl',text:'模板下载',onClick:function(){");
//		write(bw, getTab(4) + "window.top.location.href= apiUrl +'" + base_url + processName(beanName) + "/exportTpl'");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "},{");
//		write(bw, getTab(3) + "btnId:'BtnInput',text:'导入',onClick:function(){");
//
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "},{");
//		write(bw, getTab(3) + "btnId:'BtnExport',text:'导出',onClick:function(){");
//		if (no > 0) {
//			write(bw, getTab(4) + "var " + processCapName(columns.get(no)) + " = $('#textSearch"
//					+ processCapName(columns.get(no)) + "').val();");
//		}
//		if (name > 0) {
//			write(bw, getTab(4) + "var " + processCapName(columns.get(name)) + " = $('#textSearch"
//					+ processCapName(columns.get(name)) + "').val();");
//		}
//		write(bw, getTab(4) + "window.top.location.href= apiUrl +'" + base_url + processName(beanName) + "/export'");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "}],");
//		write(bw, getTab(2) + "tableId:'" + tableId + "',");
//		write(bw, getTab(2) + "tableValue:{");
//		write(bw, getTab(3) + "searchParams:mainSearchData,");
//		write(bw, getTab(3) + "queryParams:function(){");
//		write(bw, getTab(4) + "return{}");
//		write(bw, getTab(3) + "},");
//		write(bw, getTab(3) + "onClickRow:function(item,$element){");
//		bw.newLine();
//		write(bw, getTab(3) + "},");
//		write(bw, getTab(3) + "onLoadSuccess:function(){");
//		bw.newLine();
//		write(bw, getTab(3) + "},");
//		write(bw, getTab(3) + "url:'" + base_url + processName(beanName) + "/querylistByPage',");
//		write(bw, getTab(3) + "columns:[{");
//		write(bw, getTab(4) + "checkbox: true");
//		buildTableFiled_Use_Web_Framework(bw, columns, types, comments, tableComment, tableName);
//		write(bw, getTab(2) + "}");
//		write(bw, getTab(1) + "});");
//		write(bw, "})");
//		bw.newLine();
//		write(bw, "function daliogShow(type){");
//		write(bw, getTab(1) + "var title=type=='add'?'新增':'编辑';");
//		write(bw, getTab(1) + "var defaultTable=type=='add'?'':'" + tableId + "';");
//		write(bw, getTab(1) + "Ew.dialog('mainFromEdit',{");
//		write(bw, getTab(2) + "title:title,");
//		write(bw, getTab(2) + "btnValues:[{");
//		write(bw, getTab(3) + "btnId:'btnSave',");
//		write(bw, getTab(3) + "text:'保存',");
//		write(bw, getTab(3) + "formid:'form',");
//		write(bw, getTab(3) + "onClick:function(data){");
//		write(bw, getTab(4) + "if(type=='change'){");
//		write(bw, getTab(5) + "data." + processField(columns.get(0))
//				+ " = $('#'+defaultTable).bootstrapTable('getSelections')[0]." + processField(columns.get(0)) + ";");
//		write(bw, getTab(4) + "}");
//		write(bw, getTab(4) + "datas = JSON.stringify(data);");
//		write(bw, getTab(4) + "var url = (type=='add'?'" + base_url + processName(beanName) + "/add':'" + base_url
//				+ processName(beanName) + "/update');");
//		write(bw, getTab(4) + "$.when(Ew.ewAjax(url,datas)).done(function(results){");
//		write(bw, getTab(5) + "$('#mainFromEdit').modal('hide');");
//		write(bw, getTab(5) + "$('#" + tableId + "').bootstrapTable('refresh');");
//		write(bw, getTab(4) + "});");
//		write(bw, getTab(3) + "}");
//		write(bw, getTab(2) + "},{");
//		write(bw, getTab(3) + "btnId:'btnCancel',");
//		write(bw, getTab(3) + "text:'取消'");
//		write(bw, getTab(2) + "}],");
//		write(bw, getTab(2) + "form:{");
//		write(bw, getTab(3) + "formId:'form',");
//		write(bw, getTab(3) + "columnNum:2,");
//		write(bw, getTab(3) + "listWidth:250,");
//		buildInputFiled_Use_Web_Framework(bw, columns, types, comments, tableComment, tableName);
//		write(bw, getTab(3) + "defaultTable:defaultTable");
//		write(bw, getTab(2) + "}");
//		write(bw, getTab(1) + "})");
//		write(bw, "}");
//		bw.flush();
//		bw.close();
//	}
//
//	/**
//	 * 构建实体类映射XML文件
//	 *
//	 * @param columns
//	 * @param types
//	 * @param comments
//	 * @throws IOException
//	 */
//	private void buildMapperXml(List<String> columns, List<String> types, List<String> comments) throws IOException {
//		File folder = new File(file_path + xml_path);
//		if (!folder.exists()) {
//			folder.mkdirs();
//		}
//
//		File mapperXmlFile = new File(file_path + xml_path, mapperName + ".xml");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperXmlFile)));
//		write(bw, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		write(bw, "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" ");
//		write(bw, "    \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
//		write(bw, "<mapper namespace=\"" + mapper_package + "." + daoName + "\">");
//		bw.newLine();
//
//		/*
//		 * write(bw,"\t<!--实体映射-->"); bw.newLine(); write(bw,"\t<resultMap id=\"" +
//		 * this.processResultMapId(beanName) + "ResultMap\" type=\"" + beanName +
//		 * "\">"); bw.newLine(); write(bw,"\t\t<!--" + comments.get(0) + "-->");
//		 * bw.newLine(); write(bw,"\t\t<id property=\"" +
//		 * this.processField(columns.get(0)) + "\" column=\"" + columns.get(0) +
//		 * "\" />"); bw.newLine(); int size = columns.size(); for ( int i = 1 ; i < size
//		 * ; i++ ) { write(bw,"\t\t<!--" + comments.get(i) + "-->"); bw.newLine();
//		 * write(bw,"\t\t<result property=\"" + this.processField(columns.get(i)) +
//		 * "\" column=\"" + columns.get(i) + "\" />"); bw.newLine(); }
//		 * write(bw,"\t</resultMap>");
//		 *
//		 * bw.newLine(); bw.newLine(); bw.newLine();
//		 */
//
//		// 下面开始写SqlMapper中的方法
//		// this.outputSqlMapperMethod(bw, columns, types);
//		buildSQL(bw, columns, types);
//
//		write(bw, "</mapper>");
//		bw.flush();
//		bw.close();
//	}
//
//	private void buildSQL(BufferedWriter bw, List<String> columns, List<String> types) throws IOException {
//		int size = columns.size();
//		// 通用结果列
//		write(bw, getTab(1) + "<!-- 通用查询结果列-->");
//		write(bw, getTab(1) + "<sql id=\"Base_Column_List\">");
//
//		String tableCol = "";
//		String splitString = "";
//		for (int i = 0; i < size; i++) {
//			if (0 != i) {
//				splitString = " ";
//			}
//			tableCol = tableCol + splitString + columns.get(i);
//			if (i != size - 1) {
//				tableCol = tableCol + ",";
//			}
//		}
//		splitString = "";
//		String tableColVal = "";
//		for (int i = 0; i < size; i++) {
//			if (0 != i) {
//				splitString = " ";
//			}
//			tableColVal = tableColVal + splitString + "#{" + processName(beanName) + "." + processField(columns.get(i))
//					+ "}";
//			if (i != size - 1) {
//				tableColVal = tableColVal + ",";
//			}
//		}
//
//		write(bw, getTab(2) + tableCol);
//		write(bw, getTab(1) + "</sql>");
//		bw.newLine();
//
//		// 返回MAP
//		write(bw, getTab(1) + "<!--返回MAP -->");
//		write(bw, getTab(1) + "<resultMap id=\"BaseResultMap\" type=\"" + bean_package + "." + beanName + "\">");
//
//		for (int i = 0; i < size; i++) {
//			write(bw, getTab(1) + "<result column=\"" + columns.get(i) + "\" property=\"" + processField(columns.get(i))
//					+ "\"/>");
//		}
//		write(bw, getTab(1) + "</resultMap>");
//
//		bw.newLine();
//		// 查询完
//
//	}
//
//	/**
//	 * 获取所有的数据库表注释
//	 *
//	 * @return
//	 * @throws SQLException
//	 */
//	private Map<String, String> getTableComment() throws SQLException {
//		Map<String, String> maps = new HashMap<String, String>();
//		PreparedStatement pstate = conn.prepareStatement("show table status");
//		ResultSet results = pstate.executeQuery();
//		while (results.next()) {
//			String tableName = results.getString("NAME");
//			String comment = results.getString("COMMENT");
//			maps.put(tableName, comment);
//		}
//		return maps;
//	}
//
//	public void generate() throws ClassNotFoundException, SQLException, IOException {
//		init();
//		String prefix = "show full fields from ";
//		List<String> columns = null;
//		List<String> types = null;
//		List<String> comments = null;
//		PreparedStatement pstate = null;
//		List<String> tables = getTables();
//		Map<String, String> tableComments = getTableComment();
//		for (String table : tables) {
//			columns = new ArrayList<String>();
//			types = new ArrayList<String>();
//			comments = new ArrayList<String>();
//			pstate = conn.prepareStatement(prefix + table);
//			ResultSet results = pstate.executeQuery();
//			while (results.next()) {
//				columns.add(results.getString("FIELD"));
//				types.add(results.getString("TYPE"));
//				comments.add(results.getString("COMMENT"));
//			}
//			tableName = table;
//			processTable(table);
//			// this.outputBaseBean();
//			String tableComment = tableComments.get(tableName);
//			buildEntityBean(columns, types, comments, tableComment, tableName);
//			buildQueryVo(columns, types, comments, tableComment, tableName);
//			buildMapper(columns, tableComment);
//			buildMapperXml(columns, types, comments);
//			buildServerInterface(columns, tableComment);
//			buildServer(columns, tableComment);
//			buildController(columns, types, comments, tableComment, tableName);
//			buildHtml_Use_Web_Framework(columns, types, comments, tableComment, table);
//			buildJs_Use_Web_Framework(columns, types, comments, tableComment, table);
////            buildHtml(columns, types, comments, tableComment, tableName);
////            buildJs(columns, types, comments, tableComment, tableName);
//
//		}
//		conn.close();
//	}
//
//	private void write(BufferedWriter bw, String msg) throws IOException {
//		bw.write(msg);
//		bw.newLine();
//	}
//
//	// 名称处理
//	public static String nameStra(String name, int type) {
//		StringBuilder sb = new StringBuilder(name);
//		if (type == 1)
//			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
//		for (int i = 0; i < sb.length(); i++) {
//			if ((sb.charAt(i) + "").equals("_")) {
//				sb.replace(i, i + 2, Character.toUpperCase(sb.charAt(i + 1)) + "");
//			}
//		}
//		return sb.toString();
//	}
//
//	public static void main(String[] args) {
//		Calendar calendar = Calendar.getInstance();
//		date = df.format(calendar.getTime());
//		try {
//			new GenerateTools().generate();
//			// 自动打开生成文件的目录
//			String sPath = file_path.replace("/", "\\");
//			java.lang.Runtime.getRuntime().exec("cmd /c start explorer " + sPath);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
