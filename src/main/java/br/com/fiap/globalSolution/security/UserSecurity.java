package br.com.fiap.globalSolution.security;

import br.com.fiap.globalSolution.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserSecurity implements UserDetailsService {

    @Autowired
    private JpaUserRepository jpaUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = jpaUserRepository.findByCpf(username);
        if(user == null)
        {
            throw new InternalAuthenticationServiceException("Usuário não encontrado: " + username);
        }
        return user;
    }
}
