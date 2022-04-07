package com.cgh.server.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long subject;

    private int time;

    private Date date;
}
