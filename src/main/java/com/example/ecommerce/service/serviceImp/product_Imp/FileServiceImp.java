package com.example.ecommerce.service.serviceImp.product_Imp;

import com.example.ecommerce.exception.ImageError;
import com.example.ecommerce.service.product_service.FileService;
import com.example.ecommerce.util.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FileServiceImp implements FileService {
    @Override
    public String uploadImg(String path, MultipartFile file) throws IOException {

        String name=file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();

        //file name
        String fileName=uuid.concat(name.substring(name.lastIndexOf('.')));

        String uploadPath = path + File.separator + fileName;

        File f=new File(path);

        if(!f.exists()) f.mkdir();

        //Todo:compress before upload if size>100K

        Files.copy(file.getInputStream(), Path.of(uploadPath));



        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        File file=new File(path+File.separator+fileName);
        InputStream inputStream=new FileInputStream(file);
        return inputStream;
    }

    @Override
    public boolean deleteImg(String path, String name) {
        String filePath = path + File.separator + name;

        File f=new File(filePath);
        return f.delete();

    }
}
