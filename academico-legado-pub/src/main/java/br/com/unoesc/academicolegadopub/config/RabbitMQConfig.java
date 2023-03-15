package br.com.unoesc.academicolegadopub.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by igorcm3 on 12/03/2023 - 22:42
 */
@EnableRabbit
@Component
@Slf4j
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    private String HOST_NAME;

    @Value("${spring.rabbitmq.username}")
    private String USER_NAME;

    @Value("${spring.rabbitmq.password}")
    private String PASSWORD;

    @Value("${area.saved.queue}")
    private String areaSavedQueueStr;

    @Value("${area.deleted.queue}")
    private String areaDeletedQueueStr;
    @Value("${nivel-ensino.saved.queue}")
    private String nivelEnsinoSavedQueueStr;

    @Value("${nivel-ensino.deleted.queue}")
    private String nivelEnsinoDeletedQueueStr;

    @Value("${direct-exchange}")
    private String exchangeStr;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(HOST_NAME);
        connectionFactory.setUsername(USER_NAME);
        connectionFactory.setPassword(PASSWORD);
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue areaSavedQueue() {
        return new Queue(areaSavedQueueStr, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeStr);
    }

    @Bean
    public Binding areaSavedQueueBinding(Queue areaSavedQueue, DirectExchange exchange) {
        return BindingBuilder.bind(areaSavedQueue).to(exchange).withQueueName();
    }

    @Bean
    public Queue areaDeletedQueue() {
        return new Queue(areaDeletedQueueStr, true);
    }

    @Bean
    public Binding areaDeletedQueueBinding(Queue areaDeletedQueue, DirectExchange exchange) {
        return BindingBuilder.bind(areaDeletedQueue).to(exchange).withQueueName();
    }

    @Bean
    public Queue nivelEnsinoSavedQueue() {
        return new Queue(nivelEnsinoSavedQueueStr, true);
    }

    @Bean
    public Binding nivelEnsinoSavedQueueBinding(Queue nivelEnsinoSavedQueue, DirectExchange exchange) {
        return BindingBuilder.bind(nivelEnsinoSavedQueue).to(exchange).withQueueName();
    }

    @Bean
    public Queue nivelEnsinoDeletedQueue() {
        return new Queue(nivelEnsinoDeletedQueueStr, true);
    }

    @Bean
    public Binding nivelEnsinoDeletedQueueBinding(Queue nivelEnsinoDeletedQueue, DirectExchange exchange) {
        return BindingBuilder.bind(nivelEnsinoDeletedQueue).to(exchange).withQueueName();
    }

}
