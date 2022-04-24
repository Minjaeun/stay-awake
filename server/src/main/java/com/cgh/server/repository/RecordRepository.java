package com.cgh.server.repository;

import com.cgh.server.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findRecordsByStartBetween(LocalDateTime from, LocalDateTime to);
}
