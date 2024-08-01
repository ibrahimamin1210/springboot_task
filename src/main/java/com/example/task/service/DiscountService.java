package com.example.task.service;

import java.util.ArrayList;
import java.util.List;

import com.example.task.model.Bill;
import com.example.task.model.User;

public class DiscountService {
  private List<DiscountPolicy> discountPolicies;

  public DiscountService() {
    this.discountPolicies = new ArrayList<>();
    this.discountPolicies.add(new EmployeeDiscount());
    this.discountPolicies.add(new AffiliateDiscount());
    this.discountPolicies.add(new LoyaltyDiscount());
    this.discountPolicies.add(new BillDiscount());
  }

  public double applyDiscounts(Bill bill, User user) {
    return discountPolicies.stream()
        .mapToDouble(policy -> policy.calculateDiscount(bill, user))
        .sum();
  }
}