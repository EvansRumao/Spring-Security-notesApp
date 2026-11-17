package com.security.notesApp.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Lob
    private String content;

    private String ownerUsername;
}
