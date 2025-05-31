package com.dung.UniStore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@RequiredArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId; // ID sản phẩm
    private String username;
    private String content;
    private LocalDateTime timestamp;

    // Getters, setters, constructors
}
