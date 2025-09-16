package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.entity.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vagas, Long>
{
}
