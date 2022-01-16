package com.hendisantika.springbootaxonsample6.query.controller;

import com.hendisantika.springbootaxonsample6.command.data.ProductRestModel;
import com.hendisantika.springbootaxonsample6.query.query.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample6
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/01/22
 * Time: 19.44
 */
@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getAllProducts() {
        GetProductsQuery getProductsQuery =
                new GetProductsQuery();

        List<ProductRestModel> productRestModels =
                queryGateway.query(getProductsQuery,
                                ResponseTypes.multipleInstancesOf(ProductRestModel.class))
                        .join();

        return productRestModels;
    }
}
