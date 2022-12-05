package com.example.ecommerce.service.product_service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {

    public String uploadImg(String path, MultipartFile file) throws IOException;

    public InputStream getResource(String path,String fileName) throws FileNotFoundException;

    public boolean deleteImg(String path,String name);
}
