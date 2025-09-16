package br.com.fiap.globalSolution.service;

import br.com.fiap.globalSolution.DTO.MotoRequestDTO;
import br.com.fiap.globalSolution.DTO.MotoResponseDTO;
import br.com.fiap.globalSolution.entity.Motos;
import br.com.fiap.globalSolution.mapper.MotoMapper;
import br.com.fiap.globalSolution.repository.MotoRepository;
import br.com.fiap.globalSolution.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return this.motoMapper.motoToResponse(moto.get());
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

}
