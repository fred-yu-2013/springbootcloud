package cn.fred.mybatisplus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fred
 * @since 2020-07-05
 */
@TableName("product")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    private Long productId;

    private String productName;

    private String productDesc;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.productId;
    }

    @Override
    public String toString() {
        return "Product{" +
        "productId=" + productId +
        ", productName=" + productName +
        ", productDesc=" + productDesc +
        "}";
    }
}
