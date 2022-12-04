package com.example.ecommerce.service.serviceImp.product_Imp;

import com.example.ecommerce.service.product_service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

public class FileServiceImp implements FileService {
    @Override
    public String uploadImg(String path, MultipartFile file) {

        String name=file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();

        //file name
        String fileName=uuid.concat(name.substring(name.lastIndexOf('.')));

        File uploadFile = new File(path + File.separator + fileName);

        if(!uploadFile.exists()) uploadFile.mkdir();



        return null;
    }

    @Override
    public InputStream getResource(String path, String fileName) {
        return null;
    }
}
