package com.wellnez.wellnez_backend.service;

import com.wellnez.wellnez_backend.dto.ContentRequest;
import com.wellnez.wellnez_backend.model.Content;
import com.wellnez.wellnez_backend.respository.ContentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContentService {

    private final ContentRepository repo;

    public ContentService(ContentRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Content addArticle(ContentRequest req) {
        Content c = new Content(
                req.getAdminId(),
                req.getTitle(),
                req.getBodyContent(),
                LocalDateTime.now(),   // created_at
                0                      // view_count awal
        );
        return repo.save(c);
    }

    // READ – semua artikel (buat halaman user biasa / admin dashboard)
    public List<Content> getAll() {
        return repo.findAll();
    }

    // READ – artikel milik 1 admin
    public List<Content> getByAdmin(Long adminId) {
        return repo.findByAdminId(adminId);
    }

    // UPDATE
    public Content updateArticle(Long id, ContentRequest req) {
        Content c = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Artikel tidak ditemukan"));

        c.setTitle(req.getTitle());
        c.setBodyContent(req.getBodyContent());
        // created_at dan view_count tidak diubah di sini

        return repo.save(c);
    }

    // DELETE
    public void deleteArticle(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Artikel tidak ditemukan");
        }
        repo.deleteById(id);
    }
}
