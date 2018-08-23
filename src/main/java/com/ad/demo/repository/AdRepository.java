package com.ad.demo.repository;

import com.ad.demo.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad,Integer> {
}
