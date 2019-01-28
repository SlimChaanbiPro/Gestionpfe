package com.slim.Config;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.AccessUrl;
import com.slim.Domain.Authority;
import com.slim.Repository.IAuthority;
import com.slim.security.TokenHelper;
import com.slim.security.Auth.LogoutSuccess;
import com.slim.security.Auth.RestAuthenticationEntryPoint;
import com.slim.security.Auth.TokenAuthenticationFilter;
/**
 * @author slim
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Transactional
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private IAuthority iAuthority;

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private LogoutSuccess logoutSuccess;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		/* .passwordEncoder( passwordEncoder() ) */;
	}

	@Autowired
	TokenHelper tokenHelper;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("/api/user/getall").hasRole("deny");

		List<Authority> authorities = iAuthority.findAll();
		//System.out.println("size ******" + authorities.get(0).getAccessUrls().size());

		// http.authorizeRequests().antMatchers("api/user/getall").denyAll();ù
		for (Authority authority : authorities) {

			String role = authority.getName();
			role = role.replaceAll("ROLE_", "");
			//System.out.println(role);
			List<AccessUrl> accessUrls = authority.getAccessUrls();


		}

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint).and().authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS).permitAll().antMatchers("/auth/**").permitAll().anyRequest()
				.authenticated().and()
				.addFilterBefore(new TokenAuthenticationFilter(tokenHelper, userDetailsService),
						BasicAuthenticationFilter.class)
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
				.logoutSuccessHandler(logoutSuccess).deleteCookies(TOKEN_COOKIE);

	
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/docApi/swagger-ui.html").permitAll();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TokenAuthenticationFilter will ignore the below paths
		web.ignoring().antMatchers(HttpMethod.POST, "/auth/login","/**","/");
		web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/**/*.html", "/**/*.css","/",
				"/**/*.js");
		web.ignoring().antMatchers("/**");

	}
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
