package com.labskeleton.kuzmenko.config;

import com.labskeleton.kuzmenko.security.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.ExceptionTranslationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {




    @Configuration
    @Order(2)
    public static class ApiJwtSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .cors().and().csrf().disable().authorizeRequests()
                    .antMatchers("/api/login").permitAll()
//                    .antMatchers(HttpMethod.POST, "/rest/user").permitAll()
                    .antMatchers("/api/refresh").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .addFilterAfter(new JwtAuthenticationFilter(), ExceptionTranslationFilter.class);
//                    .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint());

        }
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {

//        @Override
//        @Bean
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
        //        @Autowired
//        private DaoAuthenticationProvider authenticationProvider;
//
//        @Override
//        public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
//            authenticationManagerBuilder.authenticationProvider(authenticationProvider);
//        }
//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            web
//                    .ignoring()
//                    .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**");
//        }
//
        @Override
        protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
                    .and()
                    .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
                    .and()
                    .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http
                    .cors().and().csrf().disable().authorizeRequests()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                    .loginProcessingUrl("/perform_login")
                    .defaultSuccessUrl("/users")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                    .logout()
                    .logoutUrl("/perform_logout")
                    .deleteCookies("JSESSIONID")
//                    .logoutSuccessHandler(logoutSuccessHandler())
            ;

//
//            http.
//                    authorizeRequests()
//                    .antMatchers("/").permitAll()
//                    .antMatchers("/users").permitAll()
//                    .antMatchers("/registration", "/verify/*", "/resend", "/users/**").permitAll()
//                    .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//                    .authenticated().and().csrf().disable().formLogin()
//                    .loginProcessingUrl("/login")
//                    .loginPage("/login").failureUrl("/login?error=true")
//                    .defaultSuccessUrl("/homepage")
//                    .usernameParameter("email")
//                    .passwordParameter("password")
//                    .and().logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                    .logoutSuccessUrl("/").and().exceptionHandling()
//                    .accessDeniedPage("/access-denied");
//

//            http
//                    .authorizeRequests()
////                    .antMatchers("/", "/users").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/login.html")
//                    .permitAll()
//                    .and()
//                    .logout()
//                    .permitAll();


        }
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

}