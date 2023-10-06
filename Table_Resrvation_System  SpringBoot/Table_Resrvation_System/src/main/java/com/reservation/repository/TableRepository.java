package com.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.TableModel;

@Repository
public interface TableRepository extends JpaRepository<TableModel, Integer>{
 public List<TableModel> findByTablerow(String tablerow);
 public TableModel findById(int id);
 public List<TableModel> findByTableusername(String username);
}
