package _config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <p>
 * [Spring MVC 初始化]
 * </p>
 *
 * @author cano.su
 * @since 2022/04/27
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private final Logger logger = LogManager.getLogger(SpringMvcInitializer.class);

    public SpringMvcInitializer() {
        super();
        logger.info("================== KEN WEB 啟動 ==================");
    }

    /**
     * [設定檔註冊] -DataSource 配置
     *
     * @author cano.su
     * @since 2022/04/27
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        Class<?>[] cfgs = {WebRootConfig.class};
        return cfgs;
    }

    /**
     * [Servlet 註冊 (MVC)]
     *
     * @author cano.su
     * @since 2022/04/27
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class<?>[] cfgs = {WebMvcConfig.class};
        return cfgs;
    }

    /**
     * [設定 Servlet(Spring) 管理路徑]
     *
     * @author cano.su
     * @since 2022/04/27
     */
    @Override
    protected String[] getServletMappings() {
        String[] cfgs = {"/"}; // 全部
        return cfgs;
    }

}
