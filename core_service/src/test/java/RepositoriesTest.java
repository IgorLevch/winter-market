import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import ru.geekbraines.spring.winter.market.core.entities.Product;
import ru.geekbraines.spring.winter.market.core.repositories.ProductRepository;

@DataJpaTest // тестирование слоя репозитория
@ActiveProfiles("test")  // это означает, что БД берем из файла тестовой БД (см.    readme.txt)
public class RepositoriesTest {

    @Autowired
    private ProductRepository productRepository;
    // С аннотацией @DataJpaTest  можем работать только со слоем Репозиториев
    // т.к. тестировать будем БД, то после окончания теста по базе будет проведен ролл-бек (все данные, которые мы в ходе 
    // теста внесли , будут из БД удалены); каждый тест работает в рамкках своей транзакции с последующим откатом 


    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void productRepositoryTest(){
        Product product = new Product(3L,"Bread",BigDecimal.valueOf(56));
        entityManager.persist(product);
        entityManager.flush();

        List<Product> productList = productRepository.findAll();

        Assertions.assertEquals(2, productList.size());
        Assertions.assertEquals("Bread", productList.get(1).getTitle());

    }
    @Test
    public void initDbTest(){
        List<Product> productList = productRepository.findAll();
        Assertions.assertEquals(1, productList.size());


    }




}
