package hn.ficohsa.msvc_ficohsa_insurance.security;

import java.io.IOException;
import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import hn.ficohsa.msvc_ficohsa_insurance.enums.AuthCodeCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.LevelLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProcessLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProjectsCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.TypeLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.services.impls.CustomUserDetailsService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final JwtService jwtService;
  private final CustomUserDetailsService userDetailsService;
  private final HandlerExceptionResolver handlerExceptionResolver;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String header = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (Objects.isNull(header) || !header.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    try {
      String token = header.substring(7);
      String username = this.jwtService.extractUsername(token);

      if (Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
        UserDetails user = this.userDetailsService.loadUserByUsername(username);

        if (!this.jwtService.isTokenValid(token, user)) {
          throw FicohsaInsuranceException.builder()
              .project(ProjectsCatalog.MSVC_FICOHSA_INSURANCE)
              .type(TypeLogCatalog.AUTH.name())
              .process(ProcessLogCatalog.INVALID_TOKEN.name())
              .codeCatalog(AuthCodeCatalog.INVALID_TOKEN)
              .level(LevelLogCatalog.WARN)
              .build();
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            user,
            null,
            user.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }

      filterChain.doFilter(request, response);
    } catch (FicohsaInsuranceException e) {
      // Disparar el resolveException para mapear la exception en el GlobalExceptionHandler
      this.handlerExceptionResolver.resolveException(request, response, null, e);
    } catch (JwtException | IllegalArgumentException e) {
      FicohsaInsuranceException exception = FicohsaInsuranceException.builder()
          .project(ProjectsCatalog.MSVC_FICOHSA_INSURANCE)
          .type(TypeLogCatalog.AUTH.name())
          .process(ProcessLogCatalog.INVALID_TOKEN.name())
          .codeCatalog(AuthCodeCatalog.INVALID_TOKEN)
          .level(LevelLogCatalog.WARN)
          .build();

      // Disparar el resolveException para mapear la exception en el GlobalExceptionHandler
      this.handlerExceptionResolver.resolveException(request, response, null, exception);

    }
  }

}
