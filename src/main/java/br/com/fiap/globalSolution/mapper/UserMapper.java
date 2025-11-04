package br.com.fiap.globalSolution.mapper;

import br.com.fiap.globalSolution.DTO.UserLoginResponseDto;
import br.com.fiap.globalSolution.DTO.UserRegistroDto;
import br.com.fiap.globalSolution.entity.UserJpa;

public class UserMapper
{
    public UserJpa requestToUser(UserRegistroDto registroDto, String password)
    {
        UserJpa userJpa = new UserJpa();
        userJpa.setCpf(registroDto.getCpf());
        userJpa.setEmail(registroDto.getEmail());
        userJpa.setTipo(registroDto.getTipoConta());
        userJpa.setNome_completo(registroDto.getNome());
        userJpa.setSenha(password);
        return userJpa;
    }

    public UserLoginResponseDto requestToLogin(String token)
    {
        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
        userLoginResponseDto.setToken(token);
        return userLoginResponseDto;
    }






}
