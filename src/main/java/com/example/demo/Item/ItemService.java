package com.example.demo.Item;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemService {

    private final ItemRepository itemRepository;
    
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems () {
        return itemRepository.findAll();
    }

    public void addNewItem(Item item) {
        Optional<Item> itemOptional = itemRepository
        .findItemByName(item.getName());
        if(itemOptional.isPresent()){
            throw new IllegalStateException("item already exists.");

        }
        itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists){
            throw new IllegalStateException(
                "Item with id " + itemId + "does not exists.");
        }
        itemRepository.deleteById(itemId);
    }

    @Transactional
    public void updateItem(Long itemId, Item body) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists){
            throw new IllegalStateException(
                "Item with id " + itemId + "does not exists.");
        }
        Item existingItem = itemRepository.getReferenceById(itemId);        
        
        if(body.getName()!= null){
            existingItem.setName(body.getName());
        };
        if(body.getDescription()!= null){
            existingItem.setDescription(body.getDescription());
        };
        if(body.getPrice() != null){
            existingItem.setPrice(body.getPrice());
        };

        itemRepository.save(existingItem);
    }
    
}
