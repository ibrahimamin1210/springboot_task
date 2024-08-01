package com.example.task.service;

import com.example.task.model.Bill;
import com.example.task.model.User;

public interface DiscountPolicy {
  double calculateDiscount(Bill bill, User user);
}