package com.simple.page.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 项目: test
 * <p>
 * 功能描述: mysql动态数据源
 *
 * @author: WuChengXing
 * @create: 2022-05-17 14:33
 **/
@Configuration
@MapperScan(basePackages = {"com.simple.page.mapper.mysql"}, sqlSessionFactoryRef = "mysqlSessionFactory", sqlSessionTemplateRef = "mysqlSqlSessionTemplate")
@EnableTransactionManagement
public class MysqlDataSourceConfig {

    @Value("${classpath*:mapper/mysql/*.xml}")
    private String mapperUrl;

    public MysqlDataSourceConfig() {
    }

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db")
    @Primary
    public DruidDataSource dataSource() throws SQLException {
        return new DruidDataSource();
    }

    @Bean(name = {"mysqlSessionFactory"})
    @Primary
    public SqlSessionFactory sessionFactory(@Qualifier("mysqlDataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources(this.mapperUrl));
        return sessionFactory.getObject();
    }

    @Bean("mysqlSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("mysqlSessionFactory") SqlSessionFactory sessionFactory) throws IOException {
        return new SqlSessionTemplate(sessionFactory);
    }


    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager oneTransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
