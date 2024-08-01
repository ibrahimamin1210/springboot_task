package com.example.task;

import java.util.Arrays;


import com.example.task.model.Bill;
import com.example.task.model.Item;
import com.example.task.model.User;
import com.example.task.service.AffiliateDiscount;
import com.example.task.service.BillDiscount;
import com.example.task.service.DiscountService;
import com.example.task.service.EmployeeDiscount;

@SpringBootTest
class TaskApplicationTests {

	private final EmployeeDiscount employeeDiscount = new EmployeeDiscount();
	private final AffiliateDiscount affiliateDiscount = new AffiliateDiscount();
	private final BillDiscount billDiscount = new BillDiscount();
	private final DiscountService discountService = new DiscountService();

	@Test
	void shouldApply30PercentDiscountForEmployeesOnNonGroceryItems() {
		User user = new User("1", true, false, false);
		Bill bill = new Bill(Arrays.asList(new Item("Laptop", 1000, false)));
		double discount = employeeDiscount.calculateDiscount(bill, user);
		assertEquals(300, discount);
	}

	@Test
	void shouldNotApplyDiscountForEmployeesOnGroceryItems() {
		User user = new User("1", true, false, false);
		Bill bill = new Bill(Arrays.asList(new Item("Apple", 100, true)));
		double discount = employeeDiscount.calculateDiscount(bill, user);
		assertEquals(0, discount);
	}

	@Test
	void shouldNotApplyDiscountForNonEmployees() {
		User user = new User("1", false, false, false);
		Bill bill = new Bill(Arrays.asList(new Item("Laptop", 1000, false)));
		double discount = employeeDiscount.calculateDiscount(bill, user);
		assertEquals(0, discount);
	}

	@Test
	void shouldApply10PercentDiscountForAffiliatesOnNonGroceryItems() {
		User user = new User("1", false, true, false);
		Bill bill = new Bill(Arrays.asList(new Item("Laptop", 500, false)));
		double discount = affiliateDiscount.calculateDiscount(bill, user);
		assertEquals(50, discount);
	}

	@Test
	void shouldApply5DollarsForEvery100DollarsInBill() {
		User user = new User("1", false, false, false);
		Bill bill = new Bill(Arrays.asList(new Item("Fridge", 550, false)));
		double discount = billDiscount.calculateDiscount(bill, user);
		assertEquals(25, discount);
	}

	@Test
	void shouldAggregateDiscountsCorrectly() {
		User user = new User("1", true, true, true); // Eligible for all discounts, but only one should apply
		Bill bill = new Bill(Arrays.asList(new Item("Laptop", 1000, false), new Item("Apple", 50, true)));

		double discounts = discountService.applyDiscounts(bill, user);
		assertEquals(300, discounts); // Only the highest single percentage discount applies
	}
}