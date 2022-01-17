package cn.hhu.xy.config.database;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cn.hhu.xy
 * @date 2021/8/13
 * @description 静态类，数据源上下文配置，用于切换数据源
 * */
@Slf4j
public class DynamicDSContextHolder {

        /**
         * 用于轮循的计数器
         */
        private static int counter = 0;

        /**
         * Maintain variable for every thread, to avoid effect other thread TODO
         * ThreadLocal.withInitial(() -> DSKey.xy_mysql.name())
         */
        private static final ThreadLocal<Object> CONTEXT_HOLDER = ThreadLocal.withInitial(DSKey.xyMysql::name);


        /**
         * All DataSource List
         */
        public static List<Object> dataSourceKeys = new ArrayList<>();

        /**
         * The constant slaveDataSourceKeys.
         */
        public static List<Object> slaveDataSourceKeys = new ArrayList<>();

        /**
         * To switch DataSource
         *
         * @param key the key
         */
        public static void setDataSourceKey(String key) {
            CONTEXT_HOLDER.set(key);
        }

        /**
         * Use master data source.TODO
         */
        public static void useMasterDataSource() {
            CONTEXT_HOLDER.set(DSKey.xyMysql.name());
        }

        /**
         * 当使用只读数据源时通过轮循方式选择要使用的数据源 TODO
         */
        public static void useSlaveDataSource() {

            try {
                int datasourceKeyIndex = counter % slaveDataSourceKeys.size();
                CONTEXT_HOLDER.set(String.valueOf(slaveDataSourceKeys.get(datasourceKeyIndex)));
                counter++;
            } catch (Exception e) {
                log.error("Switch slave datasource failed, error message is {}", e.getMessage());
                useMasterDataSource();
                e.printStackTrace();
            }
        }

        /**
         * Get current DataSource
         *
         * @return data source key
         */
        public static String getDataSourceKey() {
            return CONTEXT_HOLDER.get().toString();
        }

        /**
         * To set DataSource as default
         */
        public static void clearDataSourceKey() {
            CONTEXT_HOLDER.remove();
        }

        /**
         * Check if give DataSource is in current DataSource list
         *
         * @param key the key
         * @return boolean boolean
         */
        public static boolean containDataSourceKey(String key) {
            return dataSourceKeys.contains(key);
        }




}
