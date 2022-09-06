package com.example.demo.Item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository
    extends JpaRepository<Item, Long> {
    
    @Query("SELECT i FROM Item i WHERE i.name = ?1")
    Optional<Item> findItemByName(String name);

}
