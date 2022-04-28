package _config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

/**
 * <p>
 * [Web Root 設定檔]
 * </p>
 *
 * <pre>
 * * 配置 DataSource Configuration
 * * 配置 JdbcTemplate
 * </pre>
 *
 * @author asucanor
 * @since 2021/05/31
 */
@ComponentScan({
        "_config",
})
@PropertySource(value = {"classpath:sys.properties"}, ignoreResourceNotFound = true, encoding = "UTF-8")
@Configuration
public class WebRootConfig {

    @Value("${sys.id}")
    private String sysId;

    @Value("${dataSource.jndiName}")
    private String jndiName;

    /**
     * [DateSource 使用 JNDI]
     *
     * @author asucanor
     * @since 2021/06/01
     */
    //主要的
    @Primary
    @Bean
    public DataSource dataSource() {

        String info = String.format(">>> 系統 %s 初始化開始 ==================", sysId);
        System.out.println(info);

        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(jndiName);
    }

    /**
     * [JdbcTemplate 注入 DataSource]
     *
     * @author asucanor
     * @since 2021/06/01
     */
    @Primary
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
