package com.example.account.repository;

import com.example.account.entity.Account;
import com.example.account.entity.Shop;
import com.example.account.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CustomizedRepository<Account, Integer> {
    @Query("select a from Account a where a.id =:id")
    Account findById(@Param("id") int id);

    @Query("select a from Account a where a.time =:time")
    List<Account> findByTime(@Param("time") String time);

    @Query("select a from Account a where a.user.id =:uid")
    List<Account> findByUser(@Param("uid") int uid);

    @Query("select a from Account a where a.shop.id =:sid")
    List<Account> findByShop(@Param("sid") int sid);
}
