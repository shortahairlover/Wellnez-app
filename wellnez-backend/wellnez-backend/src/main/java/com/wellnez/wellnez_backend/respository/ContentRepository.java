package com.wellnez.wellnez_backend.respository;

import com.wellnez.wellnez_backend.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findByAdminId(Long adminId);
}
