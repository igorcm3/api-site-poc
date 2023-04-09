package br.com.unoesc.apisitesub.services;

import java.util.List;
import java.util.Optional;
import br.com.unoesc.apisitesub.models.NivelEnsino;
import br.com.unoesc.apisitesub.models.dto.NivelEnsinoDTO;
import br.com.unoesc.apisitesub.repositories.NivelEnsinoRepository;
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

    public NivelEnsino saveOrUpdate(final NivelEnsinoDTO nivelEnsinoDTO) {
        Optional<NivelEnsino> nivelEnsinoOpt = findByCodigo(nivelEnsinoDTO.getCodigo());
        NivelEnsino nivelEnsino;
        if(nivelEnsinoOpt.isPresent()){
            nivelEnsino = nivelEnsinoOpt.get();
            nivelEnsino.setNomeNivelEnsino(nivelEnsinoDTO.getNomeNivelEnsino());
        }else{
            nivelEnsino = nivelEnsinoDTOtoNivelEnsino(nivelEnsinoDTO);
        }
        return saveNivelEnsino(nivelEnsino);
    }
}
