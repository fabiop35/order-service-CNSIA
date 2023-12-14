package com.cnsia.orderservice.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

import com.cnsia.orderservice.order.domain.Order;
import com.cnsia.orderservice.order.domain.OrderRepository;
import com.cnsia.orderservice.order.domain.OrderStatus;
import com.cnsia.orderservice.book.Book;
import com.cnsia.orderservice.book.BookClient;


@Service
public class OrderService { 

   private final BookClient bookClient;
   private final OrderRepository orderRepository;

  public OrderService(BookClient bookClient, OrderRepository orderRepository) {
    this.bookClient = bookClient;
    this.orderRepository = orderRepository;
  }
  
   public Flux<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public Mono<Order> submitOrder(String isbn, int quantity) {

    return bookClient.getBookByIsbn(isbn)
		.map(book -> buildAcceptedOrder(book, quantity))
        .defaultIfEmpty(buildRejectedOrder(isbn, quantity))
        .flatMap(orderRepository::save);

  }

  public static Order buildAcceptedOrder(Book book, int quantity) {
		return Order.of(book.isbn(), book.title() + " - " + book.author(),
				book.price(), quantity, OrderStatus.ACCEPTED);
	}

  public static Order buildRejectedOrder(String bookIsbn, int quantity) {

    return Order.of(bookIsbn, null, null, quantity, OrderStatus.REJECTED);

  }

}
