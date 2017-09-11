package org.superbiz.moviefun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by ctsuser1 on 9/11/17.
 */

@SpringBootApplication
public class Applictaion {
    public static void main(String[] args) {
        SpringApplication.run(Applictaion.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ActionServlet actionServlet){
        return new ServletRegistrationBean(actionServlet, "/moviefun/*");
    }

}


