package gd.pvt.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gd.pvt.model.Item;
import gd.pvt.model.Order;
import gd.pvt.model.Receipt;
import gd.pvt.repo.ItemRepository;
import gd.pvt.repo.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemRepository itemRepository;

	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	public Order save(Order order) {
		return orderRepository.save(order);
	}

	public void addItem(Long id, Long itemId) {
		Order order = orderRepository.findOne(id);
		Item item = itemRepository.findOne(itemId);

		item.setOrder(order);
		order.getItems().add(item);

		orderRepository.save(order);
	}

	public Receipt pay(Long id, BigDecimal payment) {
		Order order = orderRepository.findOne(id);

		Receipt receipt = new Receipt();
		receipt.setPayment(payment);
		receipt.setOrder(order);
		return receipt;
	}
}
