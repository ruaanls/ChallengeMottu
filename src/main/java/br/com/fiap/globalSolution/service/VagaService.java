package br.com.fiap.globalSolution.service;

import br.com.fiap.globalSolution.DTO.LinhaResponseDTO;
import br.com.fiap.globalSolution.DTO.VagaRequestDTO;
import br.com.fiap.globalSolution.DTO.VagaResponseDTO;
import br.com.fiap.globalSolution.entity.Motos;
import br.com.fiap.globalSolution.entity.StatusVaga;
import br.com.fiap.globalSolution.entity.Vagas;
import br.com.fiap.globalSolution.mapper.VagaMapper;
import br.com.fiap.globalSolution.repository.MotoRepository;
import br.com.fiap.globalSolution.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VagaService
{

    @Autowired
    private VagaMapper vagaMapper;
    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private MotoRepository motoRepository;

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

    public VagaResponseDTO findVagaById(Long id) {
        Vagas vaga = this.vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com ID: " + id));
        VagaResponseDTO vagaResponse = new VagaResponseDTO();
        vagaResponse.setId(vaga.getId());
        vagaResponse.setPosicao(vaga.getLinha()+ vaga.getColuna());
        vagaResponse.setStatus(vaga.getStatusVaga());
        if(vaga.getMoto() != null)
        {
            vagaResponse.setPlaca(vaga.getMoto().getPlaca());
            vagaResponse.setModelo(vaga.getMoto().getModelo());
            vagaResponse.setAno(vaga.getMoto().getAno());
            vagaResponse.setCor(vaga.getMoto().getCor());
            vagaResponse.setStatusMoto(vaga.getMoto().getStatus());

            return vagaResponse;
        }
        else
        {
            vagaResponse.setPlaca(null);
            vagaResponse.setModelo(null);
            vagaResponse.setAno(0);
            vagaResponse.setCor(null);
            vagaResponse.setStatusMoto(null);
        }

        return vagaResponse;
    }



    public void deleteVaga(Long id) {
        Vagas vaga = this.vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com ID: " + id));

        this.vagaRepository.delete(vaga);
    }

    public LinhaResponseDTO vagasLivres(String linha)
    {
        List<Vagas> vagas = this.vagaRepository.findVagasLivresByLinha(linha);
        LinhaResponseDTO linhaResponseDTO = new LinhaResponseDTO();
        List<VagaResponseDTO> vagasDTO = new ArrayList<>();
        int vagasLivres = 0;

        for(Vagas vaga : vagas)
        {
            VagaResponseDTO vagaResponse = new VagaResponseDTO();
            vagaResponse.setId(vaga.getId());
            vagaResponse.setPosicao(vaga.getLinha()+ vaga.getColuna());

            Optional<Motos> motoNaVaga = this.motoRepository.findByVaga(vaga);
            if(motoNaVaga.isPresent())
            {
                vagaResponse.setStatus(StatusVaga.OCUPADA);
                vagaResponse.setPlaca(motoNaVaga.get().getPlaca());
                vagaResponse.setModelo(motoNaVaga.get().getModelo());
                vagaResponse.setAno(motoNaVaga.get().getAno());
                vagaResponse.setCor(motoNaVaga.get().getCor());
                vagaResponse.setStatusMoto(motoNaVaga.get().getStatus());
            }
            else
            {
                vagaResponse.setStatus(StatusVaga.LIVRE);
                vagaResponse.setPlaca(null);
                vagaResponse.setModelo(null);
                vagaResponse.setAno(0);
                vagaResponse.setCor(null);
                vagaResponse.setStatusMoto(null);
                vagasLivres++;
            }
            vagasDTO.add(vagaResponse);

        }
        linhaResponseDTO.setLinha(linha);
        linhaResponseDTO.setVagas(vagasDTO);
        linhaResponseDTO.setVagasLivres(vagasLivres);
        return linhaResponseDTO;
    }

    public List<Vagas> findAll()
    {
        return this.vagaRepository.findAll();
    }

    public List<Vagas> findAllVagasStatus(StatusVaga statusVaga)
    {
        return this.vagaRepository.findByStatusVaga(statusVaga);
    }
}
