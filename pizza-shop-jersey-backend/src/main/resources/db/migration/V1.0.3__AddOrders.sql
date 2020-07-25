insert into `order` (created, status, discount)
values (now(), 0, 0), (now(), 0, 0);

insert into order_pizza (orderId, pizzaId)
values (1, 1), (1, 2), (1, 3), (2, 1), (2, 2);