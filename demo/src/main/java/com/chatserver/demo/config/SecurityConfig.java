package com.chatserver.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // 인가 or 인증 설정
    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors(cors -> cors.disable())			//cors 방지
			.csrf(csrf -> csrf.disable())			//csrf 방지
			.formLogin(form -> form.disable());		//기본 로그인페이지 없애기
 
		return http.build();
	}    


    // url / 허용
    @Bean
    public HttpFirewall allUrlDoubleSlash() {
       StrictHttpFirewall firewall = new StrictHttpFirewall();
       firewall.setAllowUrlEncodedDoubleSlash(true);
       return firewall;
    }
    
    
    // oath 관련 설정
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .requestMatchers("/login", "/oauth2/authorization/**").permitAll()  // 인증 URL을 허용
//                 .anyRequest().authenticated()
//             .and()
//             .oauth2Login();  // OAuth2 로그인 활성화
//         return http.build();
//     }
//    
    
    
}
