package cn.fred.controller;

import cn.fred.service.ProductService;
import cn.fred.config.vo.Product;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private DiscoveryClient client ; // 进行Eureka的发现服务

    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.productService.get(id) ;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.productService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.productService.list() ;
    }

    /**
     * Eureka服务里面看到的信息这里都能拿到
     * @return
     */
    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client ;
    }
}
