package cn.hhu.xy.config.database;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @author cn.hhu.xy
 * @date 2021/8/13
 * @description 访问数据库时会调用 determineCurrentLookupKey 方法，获取数据库实例的key
 * */
@Slf4j
public class DynamicRoutingDS extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        Object key = DynamicDSContextHolder.getDataSourceKey();
        log.info("Current DataSource is: " + key);
        return key;
    }
}
