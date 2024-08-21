package ru.geekbraines.spring.winter.market.carts.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;
import ru.geekbraines.spring.winter.market.carts.properties.ProductServiceIntegrationProperties;

import java.util.concurrent.*;

@Configuration
@EnableConfigurationProperties(
    ProductServiceIntegrationProperties.class
)
@RequiredArgsConstructor
public class AppConfig {

  // @Value("${integrations.product-service.url}")    ---   это так мы делали, пока не было Пропертиес (ProductServiceIntegrationProperties)
  // private String url; // имплементировали из ямл файла. 

    private final ProductServiceIntegrationProperties productServiceIntegrationProperties; // это второй вариант, без @Value

    // @Bean   // данный Бин предназначен для отправки запросов по РЕСТу
    // public RestTemplate restTemplate(){

    //     return new RestTemplate();  РЕСТ ТЕмплейт нам не нужен, т.к. есть WebClient
    // }


  // RestTemplate - это синхронный вариант отправки запросов. А синхронность - это плоховато. 
  // WebClient - асинхронный
    @Bean
    public WebClient productServiceWebClient(){ //для интеграции с каждым сервисом мы создаем свой веб-клиент
      // наш интегрируется с продуктовым сервисом, поэтому пишем productServiceWebClient 

        TcpClient tcpClient = TcpClient // создаем tcp клиента 
        .create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, productServiceIntegrationProperties.getConnectTimeout()) 
        // выше настраиваем таймаут в миллисекундах на подключение 
        .doOnConnected(connection->{
          connection.addHandlerLast(new ReadTimeoutHandler(productServiceIntegrationProperties.getReadTimeout(), TimeUnit.MILLISECONDS));
          connection.addHandlerLast(new WriteTimeoutHandler(productServiceIntegrationProperties.getWriteTimeout(), TimeUnit.MILLISECONDS));
        });  // добавляем 2 тайм-аута на чтение и отправку данных серверу (тайм-ауты очень важны, чтобы мы не зависали до бесконечности
        // в ожидании непонятных ответов)

        return WebClient
        .builder()
        .baseUrl(productServiceIntegrationProperties.getUrl()) // куда он будет подключаться 
        .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
        .build();
          // как настраивать эту штуку - см. в yaml файле : 

  //         integrations:
  // product-service:
  //   url: http://localhost:8189/winter/
  //   read-timeout: 10000    --    это 10 секунд
  //   write-timeout: 5000    --- это 5 секунд
  //   connect-teimeout: 5000
    }


}
