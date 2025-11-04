package br.com.fiap.globalSolution.service;

import br.com.fiap.globalSolution.DTO.UserLoginDto;
import br.com.fiap.globalSolution.DTO.UserLoginResponseDto;
import br.com.fiap.globalSolution.DTO.UserRegistroDto;
import br.com.fiap.globalSolution.entity.UserJpa;
import br.com.fiap.globalSolution.mapper.UserMapper;
import br.com.fiap.globalSolution.repository.JpaUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    private final JpaUserRepository jpaUserRepository;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;
    private UserMapper userMapper;

    public AuthService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public void registrar (UserRegistroDto registroDto)
    {
        String senhaCriptografada = new BCryptPasswordEncoder().encode(registroDto.getSenha());
        UserJpa userJpa = this.userMapper.requestToUser(registroDto, senhaCriptografada);
        this.jpaUserRepository.save(userJpa);
    }

    public UserLoginResponseDto login (UserLoginDto userLoginDto)
    {
        var usernamePassoword = new UsernamePasswordAuthenticationToken(userLoginDto.getCpf(), userLoginDto.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassoword);
        UserJpa login = (UserJpa) auth.getPrincipal();
        var token = this.tokenService.generateToken(login);
        return this.userMapper.requestToLogin(token);
    }
}
