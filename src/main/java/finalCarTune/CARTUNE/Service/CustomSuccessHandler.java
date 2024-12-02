package finalCarTune.CARTUNE.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
    public class CustomSuccessHandler implements AuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                            Authentication authentication) throws IOException, ServletException {
            // Check if the user has the "ADMIN" role
            boolean isAdmin = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(role -> role.equals("ADMIN"));

            // Check if the user has the "USER" role
            boolean isUser = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(role -> role.equals("USER"));

            // Redirect based on role
            if (isAdmin) {
                response.sendRedirect("/admin-page");
            } else if (isUser) {
                response.sendRedirect("/user-page");
            } else {
                // Fallback in case no recognized roles are found
                response.sendRedirect("/login?error");
            }
        }
    }
