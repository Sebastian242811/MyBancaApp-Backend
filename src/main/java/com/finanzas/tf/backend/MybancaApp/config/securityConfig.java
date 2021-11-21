package com.finanzas.tf.backend.MybancaApp.config;

import com.finanzas.tf.backend.MybancaApp.filter.CustomAuthenticationFilter;
import com.finanzas.tf.backend.MybancaApp.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**","/rol/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/usuario/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/usuario/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/usuario/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/cartera/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/cartera/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/cartera/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/cliente/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/cliente/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/cliente/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/descuento/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/descuento/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/descuento/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/tasa/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/tasa/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/tasa/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/movimiento/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/movimiento/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/movimiento/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/tipocalendario/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/tipocalendario/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/tipocalendario/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/valor/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/valor/**").hasAnyAuthority("Administrador","Cliente");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/valor/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers("/moneda/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().antMatchers("/rol/**").hasAnyAuthority("Administrador");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
