package org.bedoing.blog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

//@Configuration
//@PropertySource({"classpath:application.yml"})
//@PropertySource({"classpath:application.properties"})
public class DatabaseConfig {
    /*private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment env;

    @Bean
    @Profile("local")
    public DataSource local() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript(env.getProperty("demo.db.schema"))
                .build();
        return db;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }*/
}
