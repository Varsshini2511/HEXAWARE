package com.hexaware.shopmart.dao;

import java.util.List;

import com.hexaware.shopmart.entity.Item;

public interface ItemDao {

	void addItem(Item item);
    void updateItem(Item item);
    void deleteItem(String itemName);
    List<Item> listAllItems();
    Item getItemByName(String itemName);
}
