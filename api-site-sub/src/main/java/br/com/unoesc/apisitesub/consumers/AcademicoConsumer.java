package br.com.unoesc.apisitesub.consumers;

import br.com.unoesc.apisitesub.models.dto.AreaDTO;
import br.com.unoesc.apisitesub.services.AreaService;
import br.com.unoesc.apisitesub.services.NivelEnsinoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by igorcm3 on 08/03/2023 - 20:43
 */
@Component
@RequiredArgsConstructor
public class AcademicoConsumer {

    private final AreaService areaService;

    private final NivelEnsinoService nivelEnsinoService;

    private final ObjectMapper mapper;

    @RabbitListener(queues = "${area.saved.queue}")
    public void areaSavedConsumer(String areaDTOStr) throws JsonProcessingException {
        areaService.saveOrUpdate(mapper.readValue(areaDTOStr, AreaDTO.class));
    }

    @RabbitListener(queues = "${area.deleted.queue}")
    public void areaDeletedConsumer(String codigoArea) throws JsonProcessingException {
        areaService.deleteAreaByCodigo(mapper.readValue(codigoArea, Long.class));
    }

//    @RabbitListener(queues = "${nivel-ensino.saved.queue} ")
//    public void nivelEnsinoSavedConsumer(String nivelEnsinoDTOStr) throws JsonProcessingException {
//        nivelEnsinoService.saveOrUpdate(mapper.readValue(nivelEnsinoDTOStr, NivelEnsinoDTO.class));
//    }
//
//    @RabbitListener(queues = "${nivel-ensino.deleted.queue} ")
//    public void nivelEnsinoDeletedConsumer(String nivelEnsinoDTOStr) throws JsonProcessingException {
//        nivelEnsinoService.saveOrUpdate(mapper.readValue(nivelEnsinoDTOStr, NivelEnsinoDTO.class));
//    }
}
