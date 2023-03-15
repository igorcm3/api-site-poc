package br.com.unoesc.apisitesub.services;

import java.util.List;
import java.util.Optional;
import br.com.unoesc.apisitesub.models.Area;
import br.com.unoesc.apisitesub.models.dto.AreaDTO;
import br.com.unoesc.apisitesub.repositories.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by igorcm3 on 12/03/2023 - 21:15
 */
@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

    public Optional<Area> findByCodigo(final Long codigoArea){
        return this.areaRepository.findById(codigoArea);
    }

    public List<Area> findAll(){
        return this.areaRepository.findAll();
    }

    public Area saveArea(Area area){
        Area areaSaved = this.areaRepository.save(area);
        return this.areaRepository.save(area);
    }

    public Area saveOrUpdate(AreaDTO areaDTO){
        Optional<Area> areaOpt = findByCodigo(areaDTO.getCodigo());
        Area area;
        if(areaOpt.isPresent()){
            area = areaOpt.get();

        }else{
            area = areaDTOtoArea(areaDTO);
        }
        return saveArea(area);
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
