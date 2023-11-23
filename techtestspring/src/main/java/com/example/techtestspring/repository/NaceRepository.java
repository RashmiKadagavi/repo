package com.example.techtestspring.repository;

import com.example.techtestspring.modal.NaceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository extends JpaRepository<NaceDetails, Long>{
}

