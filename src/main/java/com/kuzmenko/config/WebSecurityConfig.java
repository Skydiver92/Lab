//package com.kuzmenko.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.thymeleaf.templateresolver.DefaultTemplateResolver;
//
//@Configuration
//@EnableWebMvc
////@ComponentScan(basePackages = { "com.kuzmenko.controller.mvc" })
//public class WebSecurityConfig implements WebMvcConfigurer {
//
//
//
//
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/webjars/**")
//                .addResourceLocations("/webjars/");
//    }
////    @Bean
////    public UserDetailsService userDetailsService() throws Exception {
////        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
////        return manager;
////    }
////    @Bean
////    public ViewResolver viewResolver() {
////        InternalResourceViewResolver bean = new InternalResourceViewResolver();
////
////        bean.setPrefix("/static/");
////        bean.setSuffix(".html");
////
////        return bean;
////    }
////    @Override
////    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/users");
////    }
//
//}
