package com.spring.admin.service;

import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void store(MultipartFile file);
    void init();

}
