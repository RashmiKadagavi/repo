package com.example.techtestspring.serviceImpl;


import com.example.techtestspring.modal.NaceDetails;
import com.example.techtestspring.repository.NaceRepository;
import com.example.techtestspring.service.NaceService1;
import com.example.techtestspring.util.NaceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class NaceServiceImpl implements NaceService1 {
    @Autowired
    NaceRepository nacerepository;

@Override
    public void save(MultipartFile file) {
        try {
            List<NaceDetails> details = NaceHelper.csvToNaceDetails(file.getInputStream());
            nacerepository.saveAll(details);
        } catch (IOException e) {
            throw new RuntimeException("fail to store nace data: " + e.getMessage());
        }
    }


@Override
    public List<NaceDetails> getAllDetails() {
        return nacerepository.findAll();
    }

    @Override
    public Optional<NaceDetails> getNaceDetails(long id) {

    return nacerepository.findById(id);
    }
}
