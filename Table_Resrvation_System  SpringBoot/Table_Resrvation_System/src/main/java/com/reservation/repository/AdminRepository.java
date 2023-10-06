package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.DelicaciesModel;

@Repository
public interface AdminRepository extends JpaRepository<DelicaciesModel, Integer> {
public DelicaciesModel findById(int id);
}
