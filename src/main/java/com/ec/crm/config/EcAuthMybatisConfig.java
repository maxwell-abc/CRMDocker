package com.ec.crm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * <br>
 *
 * @author liujiang
 * @date 2021/1/21 22:44
 */
@Configuration
@ConditionalOnProperty("datasource.ec-auth.url")
@MapperScan(basePackages = "com.ec.auth.mapper", sqlSessionFactoryRef = "ecAuthSqlSessionFactory")
public class EcAuthMybatisConfig {
    @Bean(name = "ecAuthDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "datasource.ec-auth")
    public DruidDataSource ecAuthDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "ecAuthSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("ecAuthDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 开启关联查询延迟加载
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setAggressiveLazyLoading(false);
        configuration.setLazyLoadingEnabled(true);
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/**/*.xml"));
        factoryBean.setTypeAliasesPackage("com.ec.auth.bean");
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate ecAuthSqlSessionTemplate(
            @Qualifier("ecAuthSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("ecAuthTransactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(ecAuthDataSource());
    }
}
