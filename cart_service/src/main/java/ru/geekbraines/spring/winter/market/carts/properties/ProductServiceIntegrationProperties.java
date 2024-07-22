package ru.geekbraines.spring.winter.market.carts.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import lombok.Data;
import lombok.NoArgsConstructor;

//@ConstructorBinding //  убрал в конструктор
@ConfigurationProperties(prefix= "integrations.product-service")
@Data
@NoArgsConstructor
public class ProductServiceIntegrationProperties {

    // это мы целый кусок пропертей из ямл фала записали сюда
    // (где дефис - пишем кемелКейс)  ---   т.е. мы упаковали пачку настроек в один бин. 

    private String url;
    private Integer readTimeout;
    private Integer writeTimeout;
    private Integer connectTimeout;

    @ConstructorBinding 
    public ProductServiceIntegrationProperties(String url, Integer readTimeout, Integer writeTimeout,
            Integer connectTimeout) {
        this.url = url;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
        this.connectTimeout = connectTimeout;
    }

    
    

}
