package br.com.fiap.globalSolution.controller;

import br.com.fiap.globalSolution.DTO.UserLoginDto;
import br.com.fiap.globalSolution.DTO.UserLoginResponseDto;
import br.com.fiap.globalSolution.DTO.UserRegistroDto;
import br.com.fiap.globalSolution.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{
    private AuthService userService;

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody @Valid UserLoginDto data)
    {
        UserLoginResponseDto loginResponse =  this.userService.login(data);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);

    }

    @PostMapping("/registro")
    public ResponseEntity register(@RequestBody @Valid UserRegistroDto data)
    {
        this.userService.registrar(data);
        return ResponseEntity.ok().build();
    }
}
