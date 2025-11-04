package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.entity.UserJpa;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserJpa,String> {

    UserDetails findByCpf(String cpf);
    Optional<UserJpa> findUserJpaByCpf(String cpf);
}
