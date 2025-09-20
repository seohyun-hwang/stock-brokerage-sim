package com.stockbrokeragesim.repositories;

import com.stockbrokeragesim.models.StockOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockOptionRepo extends JpaRepository<StockOption, Integer> {

}
