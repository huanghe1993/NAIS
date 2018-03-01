package com.anyikang.config.mybatis;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
public class MybatisPlusConfig {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private MybatisProperties properties;

    @Autowired(required = false)
    private Interceptor[] interceptors;

    @Autowired(required = false)
    private DatabaseIdProvider databaseIdProvider;

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
    
    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
        mybatisPlus.setDataSource(dataSource);
        
        mybatisPlus.setVfs(SpringBootVFS.class);
        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            mybatisPlus.setConfigLocation(new DefaultResourceLoader().getResource(this.properties.getConfigLocation()));
        }
        
        mybatisPlus.setConfiguration(properties.getConfiguration());
        if (!ObjectUtils.isEmpty(this.interceptors)) {
            mybatisPlus.setPlugins(this.interceptors);
        }
        
        GlobalConfiguration globalConfig = new GlobalConfiguration();
        globalConfig.setDbType(DBType.MYSQL.name());
        globalConfig.setIdType(3);//#主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
//        globalConfig.setFieldStrategy(2);//#字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
//        globalConfig.setDbColumnUnderline(true);#驼峰下划线转换
//        globalConfig.setRefresh(true);//#刷新mapper 调试神器
//        globalConfig.setCapitalMode(true);//#数据库大写下划线转换
//        globalConfig.setKeyGenerator(keyGenerator);//#序列接口实现类配置
//        globalConfig.setLogicDeleteValue(0);#逻辑删除配置
//        globalConfig.setLogicNotDeleteValue(1);
//        globalConfig.setMetaObjectHandler(metaObjectHandler);//#自定义填充策略接口实现
//        globalConfig.setSqlInjector(sqlInjector);//#自定义SQL注入器
        
        mybatisPlus.setGlobalConfig(globalConfig);
        
        MybatisConfiguration mc = new MybatisConfiguration();
        mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        mc.setCallSettersOnNulls(true);
        mybatisPlus.setConfiguration(mc);
        
        if (this.databaseIdProvider != null) {
            mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
        }
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
        }
        return mybatisPlus;
    }
}
