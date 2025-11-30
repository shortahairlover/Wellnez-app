package com.wellnez.wellnez_backend.controller;

import com.wellnez.wellnez_backend.dto.FoodRequest;
import com.wellnez.wellnez_backend.model.FoodConsumption;
import com.wellnez.wellnez_backend.service.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "http://localhost:3000") // sesuaikan dengan port frontend Wellnez
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<FoodConsumption> addFood(@RequestBody FoodRequest req) {
        return ResponseEntity.ok(foodService.addFood(req));
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<FoodConsumption>> getAll() {
        return ResponseEntity.ok(foodService.getAll());
    }

    // READ BY USER
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FoodConsumption>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(foodService.getByUser(userId));
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<FoodConsumption> updateFood(
            @PathVariable("id") Long id,      // <-- penting: pakai ("id")
            @RequestBody FoodRequest req
    ) {
    return ResponseEntity.ok(foodService.updateFood(id, req));
}

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable("id") Long id) {
    foodService.deleteFood(id);
    return ResponseEntity.noContent().build();
}

}
