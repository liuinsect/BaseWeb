package com.liusoft.baseWeb.client.constant;

/**
 * 统一监控打点key定义
 * @author cdsudan
 *
 */
public class ProfilerConstant {

    /**
     * <gemini_v2.2.0 版本的分流接口监控Key
     */
	public static final String PROFILER_DIVIDER_WEB = "GEMINI.CONTROLLER.DivideController.web";

    /**
     * <gemini_lib_v2.2.0之前的分流接口监控Key
     */
    public static final String PROFILER_DIVIDER_LIB = "GEMINI.CONTROLLER.DivideController.lib";

    /**
     * 并行实验web分流接口监控Key
     */
    public static final String PROFILER_DIVIDER_PARALLEL_WEB = "GEMINI.CONTROLLER.DivideController.parallel.web";


    /**
     * 并行实验lib分流接口监控Key
     */
    public static final String PROFILER_DIVIDER_PARALLEL_LIB = "GEMINI.CONTROLLER.DivideController.parallel.lib";


    /**
     * 二方库libBySaf版本监控key
     */
    public static final String PROFILER_LIB_LIBDIVIDE_LIBBYSAF = "GEMINI.LIB.libDivide.libBySaf";

    /**
     * 二方库数据服务获取用户信息接口监控Key
     */
    public static final String PROFILER_LIB_DATASERVICE_GETUSERINFOBYPIN = "GEMINI.LIB.dataService.getUserInfoByPin";

    /**
     * 二方库数据服务获取地域信息接口监控Key
     */
    public static final String PROFILER_LIB_DATASERVICE_GETVISITORAREA = "GEMINI.LIB.dataService.getVisitorArea";



	
	public static final String PROFILER_SELECTOR_RANDOM = "GEMINI.SERVICE.RandomSelector.selector";
	public static final String PROFILER_SELECTOR_ACCOUNT = "GEMINI.SERVICE.jdAccountSelector.selector";
	public static final String PROFILER_SELECTOR_PROVINCE = "GEMINI.SERVICE.ProvinceSelector.selector";
	public static final String PROFILER_SELECTOR_LEVEL = "GEMINI.SERVICE.LevelSelector.selector";
	public static final String PROFILER_SELECTOR_CUSTOM = "GEMINI.SERVICE.CustomSelector.selector";

    /**
     * saf 接口
     */
	public static final String PROFILER_INTERFACE_USERINFO = "GEMINI.SAF.LevelSelector.getJiceUserInfoBasicByPin";
	//二方库获取会员等级信息
	public static final String PROFILER_INTERFACE_ACCOUNTLEVEL = "GEMINI.SAF.LevelSelector.getJdAccountLevelByPin";

    /**
     * IP库接口
     */
    public static final String PROFILER_INTERFACE_IPREPERTORY = "GEMINI.HTTP.ProvinceSelector.IPRepertory";
	
	public static final String PROFILER_TASK_TESTSTATUS = "GEMINI.TASK.checkTestStatusJob";
    public static final String PROFILER_TASK_DIRECTIONALTASKSTATUS = "GEMINI.TASK.checkDirectionalTaskStatusJob";
	public static final String PROFILER_TASK_SYNCTESTDATA = "GEMINI.TASK.SyncTestDataJob";
	public static final String PROFILER_TASK_DAEMONTASK = "GEMINI.TASK.DaemonTaskJob";
	public static final String PROFILER_TASK_MATURITYMAIL = "GEMINI.TASK.SendMaturityMailJob";
	public static final String PROFILER_TASK_NOTIFYDELMAIL = "GEMINI.TASK.SendNotiyDelMailJob";
	public static final String PROFILER_TASK_DELAYSTART = "GEMINI.TASK.checkDelayStartTestJob";
	
	/**
	 * 数据同步异常监控key
	 */
	public static final String PROFILER_TASK_SYNCTESTDATA_ERR = "GEMINI.TASK.SyncTestDataJobError";
	
	/**
	 * 发送邮件报表监控key
	 */
	public static final String PROFILER_SEND_REPORT_MAIL = "GEMINI.TASK.reportEmail";
    /**
     * jd reids客户端监控key
     */
    /**
     *del方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_DEL = "GEMINI.CACHE.jd.redis.del";

    /**
     * get方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_GET = "GEMINI.CACHE.jd.redis.get";

    /**
     * set方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_SET = "GEMINI.CACHE.jd.redis.set";

    /**
     * setex 方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_SETEX = "GEMINI.CACHE.jd.redis.setex";


    /**
     * incrBy 方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_INCRBY = "GEMINI.CACHE.jd.redis.incrBy";

    /**
     * sadd 方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_SADD = "GEMINI.CACHE.jd.redis.sadd";


    /**
     * smembers 方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_SMEMBERS = "GEMINI.CACHE.jd.redis.smembers";

    /**
     *  EXPIRE 方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_EXPIRE = "GEMINI.CACHE.jd.redis.expire";

    /**
     * ttl方法
     */
    public static final String PROFILER_CACHE_JD_REDIS_TTL = "GEMINI.CACHE.jd.redis.ttl";

    /**
     * update buffer 入口监控key
     */
    public static final String PROFILER_STATISTICS_UPDATE_BUFFER = "GEMINI.STATISTICS.update.buffer";


    /**
     * 校验实验自定义id监控Key
     */
    public static final String PROFILER_SOA_CHECKTESTALIASID = "GEMINI.SOA.checkTestAliasId";


    /**
     * 校验实验自定义id监控Key
     */
    public static final String PROFILER_SOA_CREATE = "GEMINI.SOA.create";


    /**
     * 校验实验自定义id监控Key
     */
    public static final String PROFILER_SOA_UPDATE = "GEMINI.SOA.update";


    /**
     * SOA接口校验实验自定义id监控Key
     */
    public static final String PROFILER_SOA_QUERYTESTSBYALIASIDS = "GEMINI.SOA.queryTestsByAliasIds";


    /**
     * SOA接口查询实验接口监控Key
     */
    public static final String PROFILER_SOA_QUERYTESTS = "GEMINI.SOA.queryTests";

    /**
     * SOA接口启动实验接口监控Key
     */
    public static final String PROFILER_SOA_START = "GEMINI.SOA.start";

    /**
     * SOA接口暂停实验接口监控Key
     */
    public static final String PROFILER_SOA_PAUSE = "GEMINI.SOA.pause";

    /**
     * SOA接口停止实验接口监控Key
     */
    public static final String PROFILER_SOA_STOP = "GEMINI.SOA.stop";

    /**
     * SOA报表接口监控Key
     */
    public static final String PROFILER_SOA_REPORT_QUERYTESTDATA = "GEMINI.SOA.Report.queryTestData";
    
    
    //********SOA定向定向投放任务任务常量**********************//

    /**
     * 校验定向定向投放任务自定义id监控Key
     */
    public static final String PROFILER_SOA_DIRECTIONAL_CHECKTESTALIASID = "GEMINI.SOA.directional.checkTestAliasId";


    /**
     * 校验定向定向投放任务自定义id监控Key
     */
    public static final String PROFILER_SOA_DIRECTIONAL_CREATE = "GEMINI.SOA.directional.create";


    /**
     * 校验定向定向投放任务自定义id监控Key
     */
    public static final String PROFILER_SOA_DIRECTIONAL_UPDATE = "GEMINI.SOA.directional.update";


    /**
     * SOA接口校验定向定向投放任务自定义id监控Key
     */
    public static final String PROFILER_SOA_DIRECTIONAL_QUERYBYALIASIDS = "GEMINI.SOA.directional.queryTestsByAliasIds";


    /**
     * SOA接口查询定向定向投放任务接口监控Key
     */
    public static final String PROFILER_SOA_DIRECTIONAL_QUERYTESTS = "GEMINI.SOA.directional.queryTests";

    /**
     * SOA接口启动定向定向投放任务接口监控Key
     */
    public static final String PROFILER_SOA_DIRECTIONAL_START = "GEMINI.SOA.directional.start";

    /**
     * SOA接口暂停定向定向投放任务接口监控Key
     */
    public static final String PROFILER_SOA_DIRECTIONAL_PAUSE = "GEMINI.SOA.directional.pause";

    /**
     * SOA接口停止定向定向投放任务接口监控Key
     */
    public static final String PROFILER_SOA_DIRECTIONAL_STOP = "GEMINI.SOA.directional.stop";

    /**
     * SOA报表接口监控Key
     */
    public static final String PROFILER_SOA_REPORT_DIRECTIONAL_QUERYTESTDATA = "GEMINI.SOA.Report.directional.queryTestData";

}
