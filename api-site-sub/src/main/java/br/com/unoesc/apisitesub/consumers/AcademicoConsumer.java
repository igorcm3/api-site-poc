package br.com.unoesc.apisitesub.consumers;

import br.com.unoesc.apisitesub.models.dto.AreaDTO;
import br.com.unoesc.apisitesub.services.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by igorcm3 on 13/03/2023 - 20:43
 */
@Component
@RequiredArgsConstructor
public class AcademicoConsumer {

    private final AreaService areaService;

    @RabbitListener(queues = "${area.saved.queue}")
    public void areaSavedConsumer(AreaDTO areaDTO){
        areaService.saveOrUpdate(areaDTO);
    }
}
