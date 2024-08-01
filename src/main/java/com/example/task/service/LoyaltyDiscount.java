package com.example.task.service;

import com.example.task.model.Bill;
import com.example.task.model.User;

public class LoyaltyDiscount implements DiscountPolicy {
  @Override
  public double calculateDiscount(Bill bill, User user) {
    if (!user.isLoyalCustomer()) return 0;
    return bill.getItems().stream()
        .filter(item -> !item.isGrocery())
        .mapToDouble(Item::getPrice)
        .sum() * 0.05;
  }