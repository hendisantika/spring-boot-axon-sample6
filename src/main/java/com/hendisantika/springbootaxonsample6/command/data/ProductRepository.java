package com.hendisantika.springbootaxonsample6.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample6
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/01/22
 * Time: 19.35
 */
public interface ProductRepository extends JpaRepository<Product, String> {
}
