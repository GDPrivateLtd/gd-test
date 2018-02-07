package gd.pvt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import gd.pvt.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}