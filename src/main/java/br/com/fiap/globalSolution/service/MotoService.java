package br.com.fiap.globalSolution.service;

import br.com.fiap.globalSolution.DTO.MotoRequestDTO;
import br.com.fiap.globalSolution.DTO.MotoResponseDTO;
import br.com.fiap.globalSolution.entity.Motos;
import br.com.fiap.globalSolution.entity.StatusVaga;
import br.com.fiap.globalSolution.entity.Vagas;
import br.com.fiap.globalSolution.mapper.MotoMapper;
import br.com.fiap.globalSolution.repository.MotoRepository;
import br.com.fiap.globalSolution.repository.VagaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService
{
    @Autowired
    private MotoMapper motoMapper;
    @Autowired
    private MotoRepository motoRepository;
    @Autowired
    private VagaRepository vagaRepository;

    public MotoResponseDTO createMoto (MotoRequestDTO request)
    {
        Motos moto = this.motoMapper.requestToMoto(request);
        moto = this.motoRepository.save(moto);
        return this.motoMapper.motoToResponse(moto);
    }

    public MotoResponseDTO findMotoByPlaca(String placa)
    {
        Optional<Motos> moto = this.motoRepository.findMotosByPlaca(placa);
        if(moto.isPresent())
        {
            if(moto.get().getVaga()!= null)
            {
                MotoResponseDTO motoResponse = this.motoMapper.motoToResponse(moto.get());
                motoResponse.setColuna(moto.get().getVaga().getColuna());
                motoResponse.setLinha(moto.get().getVaga().getLinha());
                motoResponse.setIdVaga(moto.get().getVaga().getId());
                return motoResponse;
            }
            else
            {
                return this.motoMapper.motoToResponse(moto.get());
            }

        }
        else
        {
            throw new RuntimeException();
        }
    }

    public void deleteMotoByPlaca(String placa)
    {
        Optional<Motos> moto = this.motoRepository.findMotosByPlaca(placa);
        if(moto.isPresent())
        {
            this.motoRepository.delete(moto.get());
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public MotoResponseDTO updateMoto(MotoRequestDTO motoRequestDTO, String placa)
    {
        Optional<Motos> moto = this.motoRepository.findMotosByPlaca(placa);
        if(moto.isPresent())
        {
            this.motoMapper.updateMotoFromRequest(motoRequestDTO,moto.get());
            Motos motoSalva = this.motoRepository.save(moto.get());
            return this.motoMapper.motoToResponse(motoSalva);
        }
        else
        {
            throw new RuntimeException();
        }

    }

    @Transactional
    public MotoResponseDTO moverMotoParaVaga(String placa, Long vagaId) {

        // 1. Busca a moto pela placa
        Motos moto = this.motoRepository.findMotosByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada com placa: " + placa));

        // 2. Busca a vaga de destino
        Vagas vagaDestino = this.vagaRepository.findById(vagaId)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com ID: " + vagaId));

        // 3. Verifica se a vaga está livre
        if (vagaDestino.getStatusVaga() != StatusVaga.LIVRE) {
            throw new RuntimeException();
        }

        // 4. Move a moto para a nova vaga
        moto.setVaga(vagaDestino);
        vagaDestino.setStatusVaga(StatusVaga.OCUPADA);


        // 5. Salva as alterações
        Motos motoAtualizada = this.motoRepository.save(moto);
        Vagas vagaAtualizada = this.vagaRepository.save(vagaDestino);

        MotoResponseDTO motoResponseDTO = this.motoMapper.motoToResponse(motoAtualizada);
        motoResponseDTO.setColuna(vagaDestino.getColuna());
        motoResponseDTO.setLinha(vagaDestino.getLinha());
        motoResponseDTO.setIdVaga(vagaDestino.getId());


        // 6. Converte para DTO
        return motoResponseDTO;
    }

    public List<Motos> findAll()
    {
        return this.motoRepository.findAll();
    }




}
