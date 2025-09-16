package br.com.fiap.globalSolution.service;

import br.com.fiap.globalSolution.DTO.VagaRequestDTO;
import br.com.fiap.globalSolution.entity.Vagas;
import br.com.fiap.globalSolution.mapper.VagaMapper;
import br.com.fiap.globalSolution.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VagaService
{
    @Autowired
    private VagaMapper vagaMapper;
    @Autowired
    private VagaRepository vagaRepository;

    public Vagas createVaga(VagaRequestDTO request)
    {
        Vagas vaga =  this.vagaMapper.requestToVaga(request);
        vaga = this.vagaRepository.save(vaga);
        return vaga;
    }

    //SE DER ERRO É AQUI
    public Vagas updateVaga(Long id, VagaRequestDTO request) {

        Optional<Vagas> vaga = this.vagaRepository.findById(id);


        this.vagaMapper.updateVagaFromRequest(request, vaga.get());


        return this.vagaRepository.save(vaga.get());
    }

    public Vagas findVagaById(Long id) {
        return this.vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com ID: " + id));
    }



    public void deleteVaga(Long id) {
        Vagas vaga = this.vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com ID: " + id));

        this.vagaRepository.delete(vaga);
    }
}
