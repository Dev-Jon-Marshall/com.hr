package com.astontech.hr;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Jonathan.Marshall on 3/8/2017.
 */
@SpringBootApplication
public class Application
{
    @Value("${spring.datasource.url}")
    private String dataSource_URL;
    @Value("${spring.datasource.username}")
    private String dataSource_userName;
    @Value("${spring.datasource.password}")
    private String dataSource_password;


    @Bean
    public DataSource dataSourceI()
    {
        DataSource ds = new DataSource();

        ds.setUrl(dataSource_URL);
        ds.setUsername(dataSource_userName);
        ds.setPassword(dataSource_password);

        return ds;
    }


    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
