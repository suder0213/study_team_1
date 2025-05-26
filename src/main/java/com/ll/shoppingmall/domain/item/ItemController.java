package com.ll.shoppingmall.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    @ResponseBody
    public List<Item> getItems() {
        return itemService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Item> getItem(@PathVariable long id) {
        return itemService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Item createItem(
            @RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean modifyItem(
            @PathVariable long id,
            @RequestBody Item item) {
        return itemService.modifyItem(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteItem(
            @PathVariable long id) {
        return itemService.deleteItem(id);
    }
}
