package tilde.tacocloud.data;

import tilde.tacocloud.Order;

public interface OrderRepository {
    Order save(Order order);
}
