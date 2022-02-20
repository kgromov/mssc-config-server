package guru.sfg.brewery.configserver.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//@Configuration
public class JdbcConfig {

    @Bean("mySqlTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("mySql") DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    @Bean("mySql")
    public DataSource dataSource(@Qualifier("mySqlProperties") DataSourceProperties properties) {
        return properties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean("mySqlProperties")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
}
