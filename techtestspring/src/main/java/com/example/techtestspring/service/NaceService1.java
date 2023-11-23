package com.example.techtestspring.service;

import com.example.techtestspring.modal.NaceDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.List;

public interface NaceService1 {
    void save(MultipartFile file);
    List<NaceDetails> getAllDetails();
    Optional<NaceDetails> getNaceDetails(long id);
}
