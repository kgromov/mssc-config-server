package guru.sfg.brewery.configserver.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentProperties;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

//@Configuration
public class RepoConfig {

    @Bean
    public JdbcEnvironmentRepository jdbcEnvironmentRepository(@Qualifier("mySqlTemplate") JdbcTemplate jdbcTemplate) {
        JdbcEnvironmentProperties properties = new JdbcEnvironmentProperties();
        properties.setSql("SELECT `KEY`, `VALUE` from PROPERTIES where `APPLICATION`=? and `PROFILE`=? and `LABEL`=?");
        return new JdbcEnvironmentRepository(jdbcTemplate, properties);
    }
}
