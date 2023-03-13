package br.com.unoesc.academicolegadopub.services;

import java.util.List;
import java.util.Optional;
import br.com.unoesc.academicolegadopub.models.NivelEnsino;
import br.com.unoesc.academicolegadopub.models.dto.NivelEnsinoDTO;
import br.com.unoesc.academicolegadopub.repositories.NivelEnsinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by igorcm3 on 12/03/2023 - 21:51
 */
@Service
@RequiredArgsConstructor
public class NivelEnsinoService {

    private final NivelEnsinoRepository nivelEnsinoRepository;

    public Optional<NivelEnsino> findByCodigo(final Long codigoNivelEnsino){
        return this.nivelEnsinoRepository.findById(codigoNivelEnsino);
    }

    public List<NivelEnsino> findAll(){
        return this.nivelEnsinoRepository.findAll();
    }

    public NivelEnsino saveNivelEnsino(NivelEnsino nivelEnsino){
        return this.nivelEnsinoRepository.save(nivelEnsino);
    }

    public void deleteNivelEnsino(NivelEnsino nivelEnsino){
        this.nivelEnsinoRepository.delete(nivelEnsino);
    }

    public void deleteNivelEnsinoByCodigo(Long codigoNivelEnsino){
        this.nivelEnsinoRepository.deleteById(codigoNivelEnsino);
    }


    public NivelEnsino nivelEnsinoDTOtoNivelEnsino(final NivelEnsinoDTO dto) {
        return NivelEnsino.builder().codigo(dto.getCodigo()).nomeNivelEnsino(dto.getNomeNivelEnsino()).build();
    }

    public NivelEnsinoDTO nivelEnsinoToDTO(final NivelEnsino nv) {
        return NivelEnsinoDTO.builder().codigo(nv.getCodigo()).nomeNivelEnsino(nv.getNomeNivelEnsino()).build();
    }
}
