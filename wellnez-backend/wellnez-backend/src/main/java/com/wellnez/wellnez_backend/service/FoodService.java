package com.wellnez.wellnez_backend.service;

import com.wellnez.wellnez_backend.dto.FoodRequest;
import com.wellnez.wellnez_backend.model.FoodConsumption;
import com.wellnez.wellnez_backend.respository.FoodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodService {

    private final FoodRepository repo;

    public FoodService(FoodRepository repo) {
        this.repo = repo;
    }

    // CREATE (Add Food)
    public FoodConsumption addFood(FoodRequest req) {

        // "2025-01-04 09:30:00" -> "2025-01-04T09:30:00"
        LocalDateTime time = LocalDateTime.parse(
                req.getConsumptionTime().replace(" ", "T")
        );

        FoodConsumption f = new FoodConsumption();
        f.setUserId(req.getUserId());
        f.setFoodName(req.getFoodName());
        f.setCalories(req.getCalories());
        f.setQuantity(req.getQuantity());
        f.setConsumptionTime(time);

        return repo.save(f);
    }

    // READ ALL
    public List<FoodConsumption> getAll() {
        return repo.findAll();
    }

    // READ BY USER
    public List<FoodConsumption> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    // UPDATE
    public FoodConsumption updateFood(Long id, FoodRequest req) {
        FoodConsumption f = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Food not found with id " + id));
    
        LocalDateTime time = LocalDateTime.parse(
            req.getConsumptionTime().replace(" ", "T")
        );
    
        f.setUserId(req.getUserId());
        f.setFoodName(req.getFoodName());
        f.setCalories(req.getCalories());
        f.setQuantity(req.getQuantity());
        f.setConsumptionTime(time);
    
        return repo.save(f);
    }

    // DELETE
    public void deleteFood(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Food not found with id: " + id);
        }
        repo.deleteById(id);
    }    
}
