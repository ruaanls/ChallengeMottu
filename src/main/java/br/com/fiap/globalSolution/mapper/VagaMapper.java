package br.com.fiap.globalSolution.mapper;

import br.com.fiap.globalSolution.DTO.VagaRequestDTO;
import br.com.fiap.globalSolution.entity.Vagas;

public class VagaMapper
{
    public Vagas requestToVaga (VagaRequestDTO vagaRequestDTO)
    {
        Vagas vagas = new Vagas();
        vagas.setStatusVaga(vagaRequestDTO.getStatusVaga());
        vagas.setColuna(vagaRequestDTO.getColuna());
        vagas.setLinha(vagaRequestDTO.getLinha());
        return vagas;
    }

    public void updateVagaFromRequest(VagaRequestDTO request, Vagas vaga) {

        if (request.getLinha() != null) {
            vaga.setLinha(request.getLinha());
        }
        if (request.getColuna() != null) {
            vaga.setColuna(request.getColuna());
        }
        if(request.getStatusVaga()!= null)
        {
            vaga.setStatusVaga(request.getStatusVaga());
        }

    }
}
