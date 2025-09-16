package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.entity.Motos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoRepository extends JpaRepository<Motos,Long>
{
    Optional<Motos> findMotosByPlaca(String placa);
}
