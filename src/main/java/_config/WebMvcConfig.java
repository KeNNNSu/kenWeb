package _config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * <p>
 * [Web Servlet(MVC) 設定檔]
 * </p>
 *
 * @author cano.su
 * @since 2022/04/27
 */
@EnableWebMvc
@ComponentScan({"application.controller"})
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final String ENCODING_UTF8 = "UTF-8";

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * [設定 靜態資源]
     *
     * @author asucanor
     * @since 2022/04/27
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**/").addResourceLocations("/static/css/");
        registry.addResourceHandler("/js/**/").addResourceLocations("/static/js/");
    }

    /**
     * [設定 模板解析器]
     *
     * @author asucanor
     * @since 2021/06/05
     */
    @Bean
    public ITemplateResolver templateResolver() {

        // 使用配合 Spring 的模板解析器
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/"); // 傳給 engine 取得要使用的模板前綴
        templateResolver.setSuffix(".html"); // 傳給 engine 取得要使用的模板後綴

        // 模板設定
        templateResolver.setTemplateMode(TemplateMode.HTML); // 模板模式(預設值 HTML, 但不建議省略)
        templateResolver.setCharacterEncoding(ENCODING_UTF8); // 模板編碼

        // 模板是否緩存
        templateResolver.setCacheable(false);

        return templateResolver;
    }

    /**
     * [設定 模板引擎]
     *
     * <pre>
     * * 自定義方言設定於此
     * </pre>
     *
     * @author asucanor
     * @since 2021/06/05
     */
    @Bean
    public SpringTemplateEngine templateEngine() {

        /* 使用 配合 Spring 的解析模板引擎 */
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();

        /* 設定 啟用於 SpringEL 表達式中啟用 SpringEL 編譯器 */
        templateEngine.setEnableSpringELCompiler(true);

        /* 設定 相對應的視圖解析器 */
        templateEngine.setTemplateResolver(templateResolver());

        /* 設定 自定義方言 */
        templateEngine.addDialect(new Java8TimeDialect()); // 新增 thymeleaf extras 方言擴充 java8time

        return templateEngine;
    }

    /**
     * [設定 視圖解析器]
     *
     * @author asucanor
     * @since 2021/06/05
     */
    @Bean
    public ViewResolver viewResolver() {

        /* 設定 thymeleaf 視圖解析器 */
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        /* 設定 相對應的 template engine */
        viewResolver.setTemplateEngine(templateEngine());

        // 於模板解析器有設定, 故以下設定可省略
        viewResolver.setCharacterEncoding(ENCODING_UTF8); // 設定編碼
        viewResolver.setContentType("text/html"); // 設定 ContentType
        viewResolver.setCache(false); // 模板是否緩存

        return viewResolver;
    }

}
