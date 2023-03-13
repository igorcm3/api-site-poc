package br.com.unoesc.academicolegadopub.services;

import java.util.List;
import java.util.Optional;
import br.com.unoesc.academicolegadopub.models.Area;
import br.com.unoesc.academicolegadopub.models.dto.AreaDTO;
import br.com.unoesc.academicolegadopub.producers.AreaProducer;
import br.com.unoesc.academicolegadopub.repositories.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by igorcm3 on 12/03/2023 - 21:15
 */
@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

    private final AreaProducer areaProducer;

    public Optional<Area> findByCodigo(final Long codigoArea){
        return this.areaRepository.findById(codigoArea);
    }

    public List<Area> findAll(){
        return this.areaRepository.findAll();
    }

    public Area saveArea(Area area){
        Area areaSaved = this.areaRepository.save(area);
        areaProducer.sendSaveArea(areaToDTO(areaSaved));
        return this.areaRepository.save(area);
    }

    public void deleteArea(Area area){
        this.areaRepository.delete(area);
    }

    public void deleteAreaByCodigo(Long codigoArea){
        this.areaRepository.deleteById(codigoArea);
    }


    public Area areaDTOtoArea(final AreaDTO dto) {
        return Area.builder().codigo(dto.getCodigo()).nomeArea(dto.getNomeArea()).build();
    }

    public AreaDTO areaToDTO(final Area dto) {
        return AreaDTO.builder().codigo(dto.getCodigo()).nomeArea(dto.getNomeArea()).build();
    }
}
