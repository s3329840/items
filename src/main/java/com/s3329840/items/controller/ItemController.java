package com.s3329840.items.controller;

import com.s3329840.items.dao.Items;
import com.s3329840.items.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("itemDAO")
    private final Items items = new Items();

    /*ItemController(Items items){
        this.items = items;
    }*/

    @PostMapping("/item")
    public Item addItem(@RequestBody Item newItem) {
        items.add(newItem);
        return newItem;
    }

    @GetMapping("/item/item{id}")
    public List<Item> getOneItem(@PathVariable int id){
        List<Item> found = items.getItem(id);
        return found;
    }

    @GetMapping("item/item")
    public List<Item> getAllItems(){
        return items.getItems();
    }

    @PutMapping("item/item")
    public Item updateItem(@RequestBody Item itemToUpdate) {
        items.update(itemToUpdate);
        return itemToUpdate;
    }

    @DeleteMapping("item/item")
    public void deleteItem(@RequestBody Item itemToDelete) {
        items.delete(itemToDelete);
    };

}
