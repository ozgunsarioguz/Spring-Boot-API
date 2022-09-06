package com.example.demo.Item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/item") 
public class ItemController {

    private final ItemService itemService;

    @Autowired
	public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
	public List<Item> getItems () {
        return itemService.getItems();
	}
    
    @PostMapping
    public void createNewItem(@RequestBody Item item){
        itemService.addNewItem(item);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(
        @PathVariable ("itemId") Long itemId){
        itemService.deleteItem(itemId);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(@PathVariable ("itemId") Long itemId,
    @RequestBody Item updatedItem){
        itemService.updateItem(itemId, updatedItem);
    }
    
}
