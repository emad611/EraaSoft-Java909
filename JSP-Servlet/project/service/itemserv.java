package item.service;

import java.util.List;

import item.model.Item;

public interface itemserv {
List<Item> getItems();
Item getItem(Long id);
void createItem(Item item);
void updateItem(Item item);
void removeItem(Long id);
}
