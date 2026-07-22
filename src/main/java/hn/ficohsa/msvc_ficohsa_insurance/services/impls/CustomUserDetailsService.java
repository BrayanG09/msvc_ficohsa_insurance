package hn.ficohsa.msvc_ficohsa_insurance.services.impls;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hn.ficohsa.msvc_ficohsa_insurance.entities.User;
import hn.ficohsa.msvc_ficohsa_insurance.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = this.repository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));

    return org.springframework.security.core.userdetails.User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .disabled(!user.getEnabled())
        .authorities(List.of())
        .build();
  }

}
