package cn.fred.mybatisplus.service.impl;

import cn.fred.mybatisplus.entity.Product;
import cn.fred.mybatisplus.mapper.ProductMapper;
import cn.fred.mybatisplus.service.IProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fred
 * @since 2020-07-05
 */
//@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
