package br.com.unoesc.apisitesub.controllers;

import java.util.Optional;
import java.util.stream.Collectors;
import br.com.unoesc.apisitesub.models.NivelEnsino;
import br.com.unoesc.apisitesub.models.ResponseError;
import br.com.unoesc.apisitesub.models.dto.NivelEnsinoDTO;
import br.com.unoesc.apisitesub.services.NivelEnsinoService;
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
 * Created by igorcm3 on 12/03/2023 - 21:55
 */
@RestController
@RequestMapping("/niveisEnsino" )
@RequiredArgsConstructor
@Slf4j
public class NivelEnsinoController {

    private final NivelEnsinoService nivelEnsinoService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveNivelEnsino(@RequestBody NivelEnsinoDTO dto){
        ResponseError responseError = new ResponseError();
        try {
            NivelEnsino nivelEnsino = nivelEnsinoService.nivelEnsinoDTOtoNivelEnsino(dto);
            nivelEnsinoService.saveNivelEnsino(nivelEnsino);
            return ResponseEntity.ok(nivelEnsinoService.nivelEnsinoToDTO(nivelEnsino));
        }catch(Exception e){
            log.info("Erro ao salvar NivelEnsino: {}", dto);
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @PostMapping(value = "/delete/{codigo}")
    public ResponseEntity<?> deleteNivelEnsino(@PathVariable("codigo") Long codigo){
        ResponseError responseError = new ResponseError();
        try {
            nivelEnsinoService.deleteNivelEnsinoByCodigo(codigo);
            return ResponseEntity.ok("NivelEnsino "+codigo+" deletada com sucesso!");
        }catch(Exception e){
            log.info("Erro ao deletar NivelEnsino com codigo: {}", codigo);
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @GetMapping(value = "/nivelEnsino/{codigo}")
    public ResponseEntity<?> findNivelEnsinoByCodigo(@PathVariable("codigo") Long codigo){
        ResponseError responseError = new ResponseError();
        try {
            Optional<NivelEnsino> nivelEnsinoOpt = nivelEnsinoService.findByCodigo(codigo);
            if (!nivelEnsinoOpt.isPresent()) {
                responseError.getError().add("Nivel de ensino não encontrado!");
                return ResponseEntity.ok().body(responseError);
            }
            return ResponseEntity.ok(nivelEnsinoService.nivelEnsinoToDTO(nivelEnsinoOpt.get()));
        }catch(Exception e){
            log.info("Erro ao buscar NivelEnsino pelo codigo: {}", codigo);
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        ResponseError responseError = new ResponseError();
        try {
            return ResponseEntity.ok(nivelEnsinoService.findAll().stream().map(nivelEnsinoService::nivelEnsinoToDTO).collect(Collectors.toList()));
        }catch(Exception e){
            log.info("Erro ao buscar todos os NivelEnsinos");
            responseError.getError().add(e.toString());
            return ResponseEntity.badRequest().body(responseError);
        }
    }    
}
