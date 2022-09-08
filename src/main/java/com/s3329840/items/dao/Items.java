package com.s3329840.items.dao;

import com.s3329840.items.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class Items {

    private List<Item> items = new ArrayList<Item>();

    public void findAll(){
        List<Item> items = List.of(new Item(1, "Thing", "It is a thing", "test.img", 30.00),
                new Item(2, "Majig", "Another thing", "testier.img", 31.00));
        for(Item item : items) {
            items.add(item);
        }

    }

    public List<Item> getItems() {
        return items;
    }

    public List<Item> getItem(int id){
        return items.stream().filter(a -> a.getId() == id).collect(Collectors.toList());
    }

    public void add(Item newItem) {
        Item item = new Item();
        item.setId(newItem.getId());
        item.setName(newItem.getName());
        item.setDesc(newItem.getDesc());
        item.setImage(newItem.getImage());
        item.setPrice(newItem.getPrice());
    }

    public void delete(int id){
        items.removeIf(a -> a.getId() == (id));
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
