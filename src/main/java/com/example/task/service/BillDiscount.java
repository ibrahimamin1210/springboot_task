package com.example.task.service;

import com.example.task.model.Bill;
import com.example.task.model.User;

public class BillDiscount implements DiscountPolicy {
  @Override
  public double calculateDiscount(Bill bill, User user) {
    int discountPerHundred = 5;
    return ((int) bill.totalAmount() / 100) * discountPerHundred;
  }
}