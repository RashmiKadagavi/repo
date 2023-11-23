package com.example.techtestspring.service;


import com.example.techtestspring.modal.NaceDetails;
import com.example.techtestspring.repository.NaceRepository;
import com.example.techtestspring.util.NaceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class NaceService {
    @Autowired
    NaceRepository nacerepository;

    public void save(MultipartFile file) {
        try {
            List<NaceDetails> details = NaceHelper.csvToNaceDetails(file.getInputStream());
            nacerepository.saveAll(details);
        } catch (IOException e) {
            throw new RuntimeException("fail to store nace data: " + e.getMessage());
        }
    }



    public List<NaceDetails> getAllDetails() {
        return nacerepository.findAll();
    }
    public Optional<NaceDetails> getNaceDetails(long id) {
        return nacerepository.findById(id);
    }
}
