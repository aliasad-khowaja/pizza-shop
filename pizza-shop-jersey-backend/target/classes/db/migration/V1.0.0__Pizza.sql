create table pizza(
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY idx_unique_pizza_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;