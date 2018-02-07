package gd.pvt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import gd.pvt.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}