create table `order` (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    created DATE NOT NULL,
    status INT UNSIGNED NOT NULL,
    discount DOUBLE DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table order_pizza(
    orderId BIGINT UNSIGNED NOT NULL,
    pizzaId BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (orderId) REFERENCES `order`(id),
    FOREIGN KEY (pizzaId) REFERENCES pizza(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;