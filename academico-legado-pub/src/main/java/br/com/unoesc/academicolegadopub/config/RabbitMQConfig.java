package br.com.unoesc.academicolegadopub.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by igorcm3 on 12/03/2023 - 22:42
 */
@Configuration
public class RabbitMQConfig {

    @Value("${area.saved.queue}")
    private String areaSavedQueueStr;

    @Value("${nivel-ensino.saved.queue}")
    private String nivelEnsinoSavedQueueStr;

    @Value("${direct-exchange}")
    private String exchangeStr;

    @Bean
    public Queue areaSavedQueue() {
        return new Queue(areaSavedQueueStr, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeStr);
    }

    @Bean
    Binding areaQueueBinding() {
        return BindingBuilder.bind(areaSavedQueue()).to(exchange()).withQueueName();
    }


}
