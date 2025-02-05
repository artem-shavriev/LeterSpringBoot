package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    List<Item> itemList = new ArrayList<>();

    @Override
    public List<Item> findByUserId(long userId) {
        List<Item> findItems = new ArrayList<>();

        itemList.forEach(item -> {
            if (item.getUserId() == userId) {
                findItems.add(item);
            }
        });
        return findItems;
    }

    @Override
    public Item save(Item item) {
        item.setId(createId());
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        itemList.forEach(item -> {
            if (item.getUserId() == userId || item.getId() == itemId) {
                itemList.remove(item);
            }
        });
    }

    Long createId() {
        long id = 0L;

        while (id == 0L) {
            Long idGenerator = new Random().nextLong(1, 1000);

            List<Long> idList = new ArrayList<>();
            itemList.forEach(item -> idList.add(item.getId()));

            if (!idList.contains(idGenerator)) {
                id = idGenerator;
            }
        }
        return id;
    }
}

