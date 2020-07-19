package com.imagegallery.imagegallery.controller;


import com.imagegallery.imagegallery.model.Category;
import com.imagegallery.imagegallery.model.Image;
import com.imagegallery.imagegallery.service.CategoryService;
import com.imagegallery.imagegallery.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private CategoryService categoryService;

    @Value("${file.upload.dir}")
    private String uploadDir;

    @GetMapping("/")
    public String getImages(Model model) {
        List<Image> allImages = imageService.findAllImages();
        List<Category> allCategoryes = categoryService.findAll();
        model.addAttribute("allimages", allImages);
        model.addAttribute("allcategoryes",allCategoryes);
        return "index";
    }

    @PostMapping("/addImage")
    public String addImage(@ModelAttribute Image image, @RequestParam ("image") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File imagedir = new File(uploadDir,name);
        file.transferTo(imagedir);
        image.setPicUrl(name);
        imageService.save(image);
        return "redirect:/";
    }


}
