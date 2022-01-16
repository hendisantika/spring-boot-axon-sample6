package com.hendisantika.springbootaxonsample6.query.projection;

import com.hendisantika.springbootaxonsample6.command.data.Product;
import com.hendisantika.springbootaxonsample6.command.data.ProductRepository;
import com.hendisantika.springbootaxonsample6.command.data.ProductRestModel;
import com.hendisantika.springbootaxonsample6.query.query.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample6
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/01/22
 * Time: 19.43
 */
@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
        List<Product> products =
                productRepository.findAll();

        List<ProductRestModel> productRestModels =
                products.stream()
                        .map(product -> ProductRestModel
                                .builder()
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName())
                                .build())
                        .collect(Collectors.toList());

        return productRestModels;
    }
}
