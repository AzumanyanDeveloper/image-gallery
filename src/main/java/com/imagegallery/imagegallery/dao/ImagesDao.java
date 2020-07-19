package com.imagegallery.imagegallery.dao;

import com.imagegallery.imagegallery.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesDao extends JpaRepository<Image,Integer> {
  List<Image> findAllByCategoryId(int categoryId);
}
