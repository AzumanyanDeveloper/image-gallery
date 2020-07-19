package com.imagegallery.imagegallery.service;

import com.imagegallery.imagegallery.model.Image;
import com.imagegallery.imagegallery.dao.ImagesDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ImageService {


    private final ImagesDao imagesDao;

    public void save(Image image) {
        imagesDao.save(image);
    }


    public List<Image> findImageByCategoryId(int categoryId) {
        return imagesDao.findAllByCategoryId(categoryId);
    }

    public List<Image> findAllImages() {
        return imagesDao.findAll();
    }
}
