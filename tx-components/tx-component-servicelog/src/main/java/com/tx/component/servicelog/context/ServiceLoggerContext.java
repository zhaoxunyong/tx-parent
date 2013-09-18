package com.tx.component.servicelog.context;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;

import com.tx.component.servicelog.logger.ServiceLogger;
import com.tx.component.servicelog.model.ServiceLog;
import com.tx.core.dbscript.model.DataSourceTypeEnum;
import com.tx.core.exceptions.util.AssertUtils;
import com.tx.core.jdbc.sqlsource.SimpleSqlSourceBuilder;

/**
  * 日志容器<br/>
  * 1、用以提供业务日志记录功能
  * <功能详细描述>
  * 
  * @author  brady
  * @version  [版本号, 2012-12-17]
  * @see  [相关类/方法]
  * @since  [产品/模块版本]
 */
public class ServiceLoggerContext implements InitializingBean{
    
    /** 懒汉模式获取日志容器句柄 */
    private static Map<Class<? extends ServiceLog>, ServiceLogger> loggerContextMapping = new HashMap<Class<? extends ServiceLog>, ServiceLogger>();
    
    private SimpleSqlSourceBuilder simpleSqlSourceBuilder;
    
    private DataSourceTypeEnum dataSourceType;
    
    private DataSource dataSource;
    
    /**
     * 私有化构造方法
     */
    private ServiceLoggerContext() {
        super();
    }
    
    /**
     * 获取日志容器
     * 
     * @return
     */
    public static ServiceLogger getLogger(
            Class<? extends ServiceLog> serviceLogClass) {
        AssertUtils.notNull(serviceLogClass, "serviceLogClass is null");
        
        ServiceLogger res = null;
        synchronized (serviceLogClass) {
            if (loggerContextMapping.containsKey(serviceLogClass)) {
                res = loggerContextMapping.get(serviceLogClass);
            } else {
                
            }
        }
        
        return res;
    }

    /**
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
    }
    
    
}
