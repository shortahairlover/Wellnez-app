package com.wellnez.wellnez_backend.respository;

import com.wellnez.wellnez_backend.model.FoodConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodRepository extends JpaRepository<FoodConsumption, Long> {

    // untuk list data food per user
    List<FoodConsumption> findByUserId(Long userId);
}
