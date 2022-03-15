package com.practice.java.stream.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author swjana
 *
 */
@Slf4j
public class StreamApiTest {

	@Test
	@DisplayName("Find the distinct name from the Stream")
	void exercise1() {
		
		long startTime = System.currentTimeMillis();
		List<String> words = Stream.of("Anup", "Swarup", "Mayur", "Swarup", "Tapan").collect(Collectors.toList());
		
		List<String> strResult = words.stream()
									.distinct()
									.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		
		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		strResult.forEach(customer -> log.info(customer.toString()));
	}
	
	@Test
	@DisplayName("Collectors.toMap() – Count Duplicates:: finding out that which all "
			+ "elements are duplicates and how many times they appeared in the original list. "
			+ "We can use a Map to store this information.")
	void exercise2() {
		
		long startTime = System.currentTimeMillis();
		List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
		
		Map<Integer, Long> result = numbersList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
		
		long endTime = System.currentTimeMillis();
		
		log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
	}
	
	
	@Test
	@DisplayName("{ \"Apple\", \"Orange\", \"Orange\", \"Banana\", \"Apple\", \"Orange\" } -use java 8 streams\r\n"
			+ "expected output in map format <fruit name, no. of occurences>\r\n"
			+ "in the descending order of the count\r\n"
			+ "Orange 3\r\n"
			+ "Apple 2\r\n"
			+ "Banana 1")
	void exercise3() {
		List<String> fruits = Arrays.asList("Apple", "Orange", "Orange", "Banana", "Apple", "Orange");
		long startTime = System.currentTimeMillis();
		Map<String, Long> result = fruits.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
//		fruits.stream().map(c -> c).collect(Function.identity(), HashMap::new, Collectors.counting());	// works as well
		long endTime = System.currentTimeMillis();
		
		log.info(String.format("exercise 3 - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
		
		log.info("sort by larger number of fruit");
		result.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).forEach(entry -> log.info(entry.getKey() + "->" + entry.getValue()));
	}
	
	@Test
	@DisplayName("Find the distinct name from the Stream")
	void exercise4() {
		
		long startTime = System.currentTimeMillis();
		List<Customer> customers = getCustomers();
		List<Customer> result = customers.stream()
									.filter(distintByKey(customer -> customer.getName()))
									.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		
		log.info(String.format("exercise 4 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(customer -> log.info(customer.toString()));
	}
	
	@Test
	@DisplayName("Print customer name with ticker and its quantity")
	void exercise5() {
		
		List<Order> orders = getOrders();
		
		long startTime = System.currentTimeMillis();
		Map<String, Map<String, IntSummaryStatistics>> map = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustName, Collectors.groupingBy(Order::getTicker, Collectors.summarizingInt(Order::getQuantity))));
		for (Entry<String, Map<String, IntSummaryStatistics>> entry : map.entrySet()) {
			
			Map<String, IntSummaryStatistics> stock = entry.getValue();
			stock.entrySet().forEach(entryStock -> log.info(entry.getKey() + " " + entryStock.getKey() + " " + entryStock.getValue().getSum()));
		}
		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
	}
	
	private List<Order> getOrders() {
		
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("Swarup", "IBM", 500));
		orders.add(new Order("Mike", "Msft", 1000));
		orders.add(new Order("Mike", "Google", 200));
		orders.add(new Order("Mike", "Msft", -50));
		orders.add(new Order("Swarup", "Msft", 1000));
		return orders;
	}

	private List<Customer> getCustomers() {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer(1L, "Stefan Walker", 1));
		list.add(new Customer(2L, "Daija Von", 1));
		list.add(new Customer(3L, "Ariane Rodriguez", 1));
		list.add(new Customer(4L, "Marques Nikolaus", 2));
		list.add(new Customer(5L, "Rachelle Greenfelder", 0));
		list.add(new Customer(6L, "Larissa White", 2));
		list.add(new Customer(7L, "Fae Heidenreich", 1));
		list.add(new Customer(8L, "Dino Will", 2));
		list.add(new Customer(9L, "Eloy Stroman", 1));
		list.add(new Customer(10L, "Brisa O'Connell", 1));
		return list;
	}

	private <T> Predicate<T> distintByKey(Function<? super T, Object> keyExtractor) {

		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
class Customer {
	private Long id;
	private String name;
	private Integer tier;
}

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
class Order {

	private String custName;
	private String ticker;
	private int quantity;
}