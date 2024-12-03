package org.personal.thymeleaf.repository;

import org.personal.thymeleaf.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
