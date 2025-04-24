package digital.pensieve.config;

import digital.pensieve.data.CustomCsrfRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.web.csrf.*;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.http.HttpClient;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Slf4j
public class SecurityConfiguration {

    @Autowired
    CustomCsrfRepository csrfRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("CSRF token is {}", http.csrf().toString());
        http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
                .permitAll())
//        http
//        .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//        )
        .httpBasic(withDefaults())
        .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
        )
        .csrf(
            (csrf) -> csrf
            .csrfTokenRepository(csrfRepository)
        );

        return http.build();
    }

    @Bean
    @Order(1000)
    @Primary
    @Conditional(value = Cond.class)
    public CsrfFilter csrfFilter() {
        return new CsrfFilter(csrfRepository);
    }

}
