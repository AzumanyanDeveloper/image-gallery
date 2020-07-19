package com.imagegallery.imagegallery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "pic_url")
    private String picUrl;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private Category category;


}
