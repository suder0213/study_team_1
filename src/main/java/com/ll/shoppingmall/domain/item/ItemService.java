package com.ll.shoppingmall.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;


    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(long id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        itemRepository.save(item);
        return item;
    }

    public boolean modifyItem(long id, Item item) {
        List<Item> items = itemRepository.findAll();
        Item itemf = items.stream()
                .filter(_item ->_item.getId() == id
                ).findFirst()
                .orElse(null);
        if (itemf == null) return false;
        itemf.setName(item.getName());
        itemf.setPrice(item.getPrice());
        return true;
    }

    public boolean deleteItem(long id) {
        List<Item> items = itemRepository.findAll();
        Item itemf = items.stream()
                .filter(_customer -> _customer.getId() == id
                ).findFirst()
                .orElse(null);
        if (itemf == null) return false;
        itemRepository.delete(itemf);
        return true;
    }

}
