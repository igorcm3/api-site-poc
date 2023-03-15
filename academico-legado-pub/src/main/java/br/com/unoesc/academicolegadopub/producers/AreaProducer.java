package br.com.unoesc.academicolegadopub.producers;

import br.com.unoesc.academicolegadopub.models.dto.AreaDTO;
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

    @Value("${area.saved.queue}")
    private String areaQueueStr;

    public void sendSaveArea(AreaDTO areaDTO){
        rabbitTemplate.convertAndSend(areaQueueStr, areaDTO);
    }

}
