package com.s3329840.items.dao;

import com.s3329840.items.exceptions.ItemNotFoundException;
import com.s3329840.items.model.Item;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("itemDAO")
public class Items {

    private List<Item> items = new ArrayList<Item>();

    public Items() {
        items.add(new Item(1, "That", "Over there", "trial.img", 10.00));
        items.add(new Item(2, "This", "Over here", "trail.img", 01.00));
    }

    
    public void findAll(){
        List<Item> items = List.of(new Item(3, "Thing", "It is a thing", "test.img", 30.00),
                new Item(4, "Majig", "Another thing", "testier.img", 31.00));
        for(Item item : items) {
            items.add(item);
        }

    }

    
    public List<Item> getItems() {
        return items;
    }

    
    public List<Item> getItem(int id){
        List<Item> exists = items.stream().filter(a -> a.getId() == id).collect(Collectors.toList());

        if (exists.isEmpty()) {
            throw new ItemNotFoundException(id);
        }

        return exists;
    }

    
    public void add(Item newItem) {
        Item item = new Item();
        item.setId(newItem.getId());
        item.setName(newItem.getName());
        item.setDesc(newItem.getDesc());
        item.setImage(newItem.getImage());
        item.setPrice(newItem.getPrice());
        items.add(item);
    }

    
    public void delete(Item itemToDelete){
        for (Item item : items) {
            if (item.getId() == itemToDelete.getId()) {
                items.remove(item);
            }
            else throw new ItemNotFoundException(itemToDelete.getId());
        }
    }

    
    public void update(Item item) {
        int id = 0;
        int itemsIndex = 0;
        
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getId() == item.getId()){
                id = item.getId();
                itemsIndex = i;
            }
        }

        Item updatedItem = new Item();
        updatedItem.setId(id);
        updatedItem.setName(item.getName());
        updatedItem.setDesc(item.getDesc());
        updatedItem.setImage(item.getImage());
        updatedItem.setPrice(item.getPrice());
        items.set(itemsIndex, updatedItem);
    }
}
