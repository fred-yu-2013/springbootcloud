package cn.fred.config.test;

import cn.fred.ProviderServiceApp;
import cn.fred.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = {ProviderServiceApp.class})
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @Resource
    private ProductService productService;

    @Test
    public void testGet() {
        System.out.println(productService.get(1));
    }
}
