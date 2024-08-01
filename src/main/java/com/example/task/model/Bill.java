package com.example.task.model;

import java.util.List;

public class Bill {
  private List<Item> items;

  public Bill(List<Item> items) {
    this.items = items;
  }

  public double totalAmount() {
    return items.stream().mapToDouble(Item::getPrice).sum();
  }

  public List<Item> getItems() {
    return items;
  }
}