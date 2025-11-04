package br.com.fiap.globalSolution.DTO;

public class UserLoginResponseDto
{
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserLoginResponseDto(String token) {
        this.token = token;
    }

    public UserLoginResponseDto() {
    }
}
