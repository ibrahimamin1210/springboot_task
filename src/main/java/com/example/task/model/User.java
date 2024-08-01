package com.example.task.model;

public class User {
  private String userId;
  private boolean isEmployee;
  private boolean isAffiliate;
  private boolean isLoyalCustomer;

  public User(String userId, boolean isEmployee, boolean isAffiliate, boolean isLoyalCustomer) {
    this.userId = userId;
    this.isEmployee = isEmployee;
    this.isAffiliate = isAffiliate;
    this.isLoyalCustomer = isLoyalCustomer;
  }

  public boolean isEmployee() {
    return isEmployee;
  }

  public boolean isAffiliate() {
    return isAffiliate;
  }

  public boolean isLoyalCustomer() {
    return isLoyalCustomer;
  }
}