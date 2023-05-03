package br.com.unoesc.academicolegadopub.producers;

import br.com.unoesc.academicolegadopub.models.dto.AreaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by igorcm3 on 12/03/2023 - 23:02
 */
@Component
@RequiredArgsConstructor
public class AreaProducer {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper mapper;

    @Value("${area.saved.queue}")
    private String areaQueueStr;

    @Value("${area.deleted.queue}")
    private String areaDeleteQueueStr;

    public void sendSaveArea(AreaDTO areaDTO) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(areaQueueStr, mapper.writeValueAsString(areaDTO));
    }

    public void sendDeleteArea(Long codigoArea) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(areaDeleteQueueStr, mapper.writeValueAsString(codigoArea));
    }

}
