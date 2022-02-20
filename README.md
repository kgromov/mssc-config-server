## Jdbc as backend for Spring cloud config:
* add spring-jdbc (spring-boot-starter-jdbc) dependency
* add connector
 *configure datasource in application properties/yml
 * run with `jdbc` profile
 * change default sql property if needed (depends on Dialect) - `spring.cloud.config.server.jdbc.sql`
 
 ___
 
 * configure explicitly JdbcEnvironmentRepository
 * optionally configure JdbcTemplate