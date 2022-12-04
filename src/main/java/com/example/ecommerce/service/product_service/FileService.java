package com.example.ecommerce.service.product_service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {

    public String uploadImg(String path, MultipartFile file);

    public InputStream getResource(String path,String fileName);
}
