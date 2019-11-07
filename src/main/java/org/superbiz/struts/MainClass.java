package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainClass {

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter(){
        FilterRegistrationBean<SiteMeshFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new SiteMeshFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean strutsPrepareAndExecuteFilter(){
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new StrutsPrepareAndExecuteFilter());
        bean.addUrlPatterns("/", "/addUserForm.action", "/addUser.action", "/findUserForm.action", "/findUser.action",
                "/listAllUsers.action");
        bean.setOrder(2);
        return bean;

    }
}
