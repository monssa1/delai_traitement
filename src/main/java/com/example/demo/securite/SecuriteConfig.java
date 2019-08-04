//package com.example.demo.securite;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.encoding.Md4PasswordEncoder;
////import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
////import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.Md4PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecuriteConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//	private DataSource dataSource;
//	@SuppressWarnings("deprecation")
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//			/*
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN","USER");
//		auth.inMemoryAuthentication().withUser("user").password("{noop}Passer@123").roles("USER");*/
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery("select username as principal, password as credentials ,active from users where username=?")
//		.authoritiesByUsernameQuery("select username as principal , role as role from users_roles where username=?")
//		.rolePrefix("ROLE_")
//		//.passwordEncoder(new  )
//		.passwordEncoder(new Md4PasswordEncoder())
//		;
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//http.formLogin().loginPage("/login");
//		http.authorizeRequests().antMatchers("/adddossier","/listedossier","/lic","/con","/front").hasRole("USER");
//		http.authorizeRequests().antMatchers("/bur","ch","emp").hasRole("ADMIN");
//	}
//}
