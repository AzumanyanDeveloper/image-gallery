package com.imagegallery.imagegallery.controller;

import com.imagegallery.imagegallery.model.Category;
import com.imagegallery.imagegallery.model.Image;
import com.imagegallery.imagegallery.service.CategoryService;
import com.imagegallery.imagegallery.service.ImageService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {


    private final CategoryService categoryService;

    private final ImageService imageService;

    @Value("${file.upload.dir}")
    private String uploadDir;


    @GetMapping("/register")
    public String goRegister(Model model) {
        return "register";
    }


    @GetMapping("/index")
    public String getIndex(Model model) {

        return "index";
    }

    @GetMapping("/stock")
    public String getStock() {
        return "stock";
    }


    @GetMapping("/single")
    public String getSingle(Model model, @RequestParam("id") int id) {
        List<Image> imageByCategoryId = imageService.findImageByCategoryId(id);
        List<Category> allcategory = categoryService.findAll();
        model.addAttribute("categoryes", allcategory);
        model.addAttribute("imagesByCategoryId", imageByCategoryId);
        return "single";
    }


    @GetMapping("/admin")
    public String getAdmin(Model model) {
        List<Category> allcategory = categoryService.findAll();
        model.addAttribute("categoryes", allcategory);
        return "admin";
    }

    @GetMapping(
            value = "/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody
    byte[] getImage(@RequestParam("name") String imageName) throws IOException {

        InputStream in = new FileInputStream(uploadDir + File.separator + imageName);
        return IOUtils.toByteArray(in);
    }

    @GetMapping("/services")
    public String getService(Model model){
        List<Category> allcategory = categoryService.findAll();
        model.addAttribute("categoryes", allcategory);
        return "services";
    }

    @GetMapping("/about")
    public String getAbout(Model model){
        List<Category> allcategory = categoryService.findAll();
        model.addAttribute("categoryes", allcategory);
        return "about";
    }

    @GetMapping("/contact")
    public String getContact(Model model){
        List<Category> allcategory = categoryService.findAll();
        model.addAttribute("categoryes", allcategory);
        return "contact";
    }




}
