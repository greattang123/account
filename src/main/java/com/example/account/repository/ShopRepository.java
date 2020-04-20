package com.example.account.repository;

import com.example.account.entity.Shop;
import com.example.account.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends CustomizedRepository<Shop, Integer> {
    @Query("select s from Shop s where s.id =:id")
    Shop findById(@Param("id") int id);

    @Query("select s from Shop s where s.name =:name")
    Shop findByName(@Param("name") String name);

    @Query("select s from Shop s where s.location =:location")
    Shop findByLocation(@Param("location") String location);

    @Query("from Shop ")
    List<Shop> findAllShop();
}
