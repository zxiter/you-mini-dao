package org.jeecgframework.minidao.def;

/**
 * 
 * @Title:MiniDaoConstants
 * @description:MiniDao 常量文件
 * @author 张代浩
 * @date 20130817
 * @version V1.0
 */
public class MiniDaoConstants {

	/**
	 * 接口方法定义规则： 添加：insert,add,create 修改：update,modify,store 删除：delete,remove
	 * 查询：以上各单词之外
	 */
	public static final String INF_METHOD_ACTIVE = "insert,add,create,update,modify,store,delete,remove";

	public static final String INF_METHOD_BATCH = "batch";

	/**
	 * 方法只有一个参数，并用户没有使用@Argument标签，模板中引用参数默认为：dto
	 */
	public static final String SQL_FTL_DTO = "dto";

	public static final String METHOD_SAVE_BY_HIBERNATE = "saveByHibernate";

	public static final String METHOD_DELETE_BY_HIBERNATE = "deleteByHibernate";

	public static final String METHOD_UPDATE_BY_HIBERNATE = "updateByHibernate";

	public static final String METHOD_SAVEORUPDATE_BY_HIBERNATE = "saveOrUpdateByHibernate";

	public static final String METHOD_GET_BY_HIBERNATE = "getByHibernate";

	public static final String METHOD_LIST_BY_HIBERNATE = "findByHibernate";

	public static final String METHOD_COUNT_BY_HIBERNATE = "countByHibernate";

}
