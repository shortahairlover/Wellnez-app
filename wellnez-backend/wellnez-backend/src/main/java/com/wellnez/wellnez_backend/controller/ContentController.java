package com.wellnez.wellnez_backend.controller;

import com.wellnez.wellnez_backend.dto.ContentRequest;
import com.wellnez.wellnez_backend.model.Content;
import com.wellnez.wellnez_backend.service.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin(origins = "http://localhost:3000")  // sesuaikan port front-end
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<Content> add(@RequestBody ContentRequest req) {
        return ResponseEntity.ok(contentService.addArticle(req));
    }

    // READ – semua artikel
    @GetMapping("/all")
    public ResponseEntity<List<Content>> getAll() {
        return ResponseEntity.ok(contentService.getAll());
    }

    // READ – artikel milik 1 admin (untuk dashboard admin)
    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Content>> getByAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(contentService.getByAdmin(adminId));
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Content> update(
            @PathVariable Long id,
            @RequestBody ContentRequest req) {
        return ResponseEntity.ok(contentService.updateArticle(id, req));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contentService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
