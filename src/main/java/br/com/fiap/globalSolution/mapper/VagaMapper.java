package br.com.fiap.globalSolution.mapper;

import br.com.fiap.globalSolution.DTO.VagaRequestDTO;
import br.com.fiap.globalSolution.entity.StatusVaga;
import br.com.fiap.globalSolution.entity.Vagas;
import org.springframework.stereotype.Component;

@Component
public class VagaMapper
{
    public Vagas requestToVaga (VagaRequestDTO vagaRequestDTO)
    {
        Vagas vagas = new Vagas();
        vagas.setStatusVaga(StatusVaga.LIVRE);
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


    }
}
