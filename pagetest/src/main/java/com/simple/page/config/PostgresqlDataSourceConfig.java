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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 项目: test
 * <p>
 * 功能描述: 新增数据源
 *
 * @author: WuChengXing
 * @create: 2022-05-17 10:40
 **/
@Configuration
@MapperScan(basePackages = {"com.simple.demo.mapper.postgresql"}, sqlSessionFactoryRef = "postgresqlSessionFactory", sqlSessionTemplateRef = "postgresqlSqlSessionTemplate")
@EnableTransactionManagement
public class PostgresqlDataSourceConfig {

    @Value("${classpath*:mapper/postgresql/*.xml}")
    private String mapperUrl;

    public PostgresqlDataSourceConfig() {
    }

    @Bean(name = "postgresqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgresql")
    public DruidDataSource postgresqlDataSource() throws SQLException {
        return new DruidDataSource();
    }

    @Bean(name = {"postgresqlSessionFactory"})
    public SqlSessionFactory sessionFactory(@Qualifier("postgresqlDataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources(this.mapperUrl));
        return sessionFactory.getObject();
    }

    @Bean("postgresqlSqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("postgresqlSessionFactory") SqlSessionFactory sessionFactory) throws IOException {
        return new SqlSessionTemplate(sessionFactory);
    }


    @Bean(name = "postgresqlTransactionManager")
    public DataSourceTransactionManager oneTransactionManager(@Qualifier("postgresqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
