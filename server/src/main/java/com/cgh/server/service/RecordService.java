package com.cgh.server.service;

import com.cgh.server.domain.Record;
import com.cgh.server.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordService {

    RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> findRecordsByStartBetween(LocalDateTime from, LocalDateTime to) {
        return recordRepository.findRecordsByStartBetween(from, to);
    }
}
