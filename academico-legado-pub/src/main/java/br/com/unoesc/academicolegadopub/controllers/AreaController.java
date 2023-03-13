package br.com.unoesc.academicolegadopub.controllers;

import java.util.Optional;
import java.util.stream.Collectors;
import br.com.unoesc.academicolegadopub.models.Area;
import br.com.unoesc.academicolegadopub.models.ResponseError;
import br.com.unoesc.academicolegadopub.models.dto.AreaDTO;
import br.com.unoesc.academicolegadopub.services.AreaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by igorcm3 on 12/03/2023 - 21:20
 */
@RestController
@RequestMapping("/areas" )
@RequiredArgsConstructor
@Slf4j
public class AreaController {

    private final AreaService areaService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveArea(@RequestBody AreaDTO dto){
        ResponseError responseError = new ResponseError();
        try {
            Area area = areaService.areaDTOtoArea(dto);
            areaService.saveArea(area);
            return ResponseEntity.ok(areaService.areaToDTO(area));
        }catch(Exception e){
            log.info("Erro ao salvar Area: {}", dto);
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @PostMapping(value = "/delete/{codigo}")
    public ResponseEntity<?> deleteArea(@PathVariable("codigo") Long codigo){
        ResponseError responseError = new ResponseError();
        try {
            areaService.deleteAreaByCodigo(codigo);
            return ResponseEntity.ok("Area "+codigo+" deletada com sucesso!");
        }catch(Exception e){
            log.info("Erro ao deletar Area com codigo: {}", codigo);
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @GetMapping(value = "/area/{codigo}")
    public ResponseEntity<?> findAreaByCodigo(@PathVariable("codigo") Long codigo){
        ResponseError responseError = new ResponseError();
        try {
            Optional<Area> areaOpt = areaService.findByCodigo(codigo);
            if (!areaOpt.isPresent()) {
                responseError.getError().add("Area não encontrada!");
                return ResponseEntity.ok().body(responseError);
            }
            return ResponseEntity.ok(areaService.areaToDTO(areaOpt.get()));
        }catch(Exception e){
            log.info("Erro ao buscar Area pelo codigo: {}", codigo);
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        ResponseError responseError = new ResponseError();
        try {
            return ResponseEntity.ok(areaService.findAll().stream().map(areaService::areaToDTO).collect(Collectors.toList()));
        }catch(Exception e){
            log.info("Erro ao buscar todas as Areas");
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }
}
