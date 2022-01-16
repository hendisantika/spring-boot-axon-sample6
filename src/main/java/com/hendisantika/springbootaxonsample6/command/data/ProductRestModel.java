package com.hendisantika.springbootaxonsample6.command.data;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample6
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/01/22
 * Time: 19.36
 */
@Data
@Builder
public class ProductRestModel {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
