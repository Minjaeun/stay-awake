package com.cgh.server.service;

import com.cgh.server.domain.Subject;
import com.cgh.server.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

    SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Optional<Subject> findById(Long id){
        return subjectRepository.findById(id);
    }
}
