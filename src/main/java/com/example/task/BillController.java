package com.example.task;

import com.example.task.model.Bill;
import com.example.task.model.User;
import com.example.task.service.DiscountService;

@RestController
public class BillController {
  private DiscountService discountService = new DiscountService();

  @PostMapping("/calculate")
  public ResponseEntity<Double> calculateNetPayable(@RequestBody Bill bill, @RequestParam String userId) {
    User user = getUserFromId(userId); // Assume a method to fetch user data
    double discounts = discountService.applyDiscounts(bill, user);
    double netPayable = bill.totalAmount() - discounts;
    return ResponseEntity.ok(netPayable);
  }

  private User getUserFromId(String userId) {
    return new User(userId, true, false, false);
  }
}