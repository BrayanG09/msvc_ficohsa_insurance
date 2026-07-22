package hn.ficohsa.msvc_ficohsa_insurance.services.impls;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.auth.AuthRequestDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.auth.AuthResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.enums.AuthCodeCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.LevelLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProcessLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.TypeLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.security.JwtService;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.AuthService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final AuthenticationManager authenticationManager;
  private final CustomUserDetailsService userDetailsService;
  private final JwtService jwtService;

  @Override
  public AuthResponseDTO verify(AuthRequestDTO request) throws FicohsaInsuranceException {
    try {
      this.authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              request.getUsername(),
              request.getPassword()));

      UserDetails user = this.userDetailsService.loadUserByUsername(request.getUsername());

      return AuthResponseDTO.builder()
          .token(this.jwtService.generateToken(user))
          .build();
    } catch (FicohsaInsuranceException ex) {
      throw ex;
    } catch (BadCredentialsException | UsernameNotFoundException ex) {
      throw FicohsaInsuranceException.builder()
          .userIdentifier(request.getUsername())
          .type(TypeLogCatalog.AUTH.name())
          .process(ProcessLogCatalog.INVALID_CREDENTIALS.name())
          .codeCatalog(AuthCodeCatalog.INVALID_CREDENTIALS)
          .level(LevelLogCatalog.WARN)
          .exception(ex)
          .build();
    }
  }
}
