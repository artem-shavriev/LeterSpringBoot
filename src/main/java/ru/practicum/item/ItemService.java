package ru.practicum.item;

import java.util.List;

public interface ItemService {
    public List<Item> getItems(Long userId);

    public Item addNewItem(Long userId, Item item);

    public void deleteItem(Long userId, Long itemId);
}
