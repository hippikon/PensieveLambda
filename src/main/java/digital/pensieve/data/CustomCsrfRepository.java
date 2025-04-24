package digital.pensieve.data;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import java.util.UUID;

@Slf4j
public class CustomCsrfRepository implements CsrfTokenRepository {

    private String uuid = "00000000-0000-0800-0000-000000000001";

    @Override
    public CsrfToken loadToken(HttpServletRequest request){
        return new DefaultCsrfToken("xsrf","", uuid);
    }

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        System.out.println("Request headers are "+ request.getHeaderNames());
        return null;
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("CSRF Token is {}" + token);
    }
}