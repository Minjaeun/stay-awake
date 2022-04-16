package com.cgh.server.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Subject subject;

    private LocalDateTime start;

    private LocalDateTime end;
}
