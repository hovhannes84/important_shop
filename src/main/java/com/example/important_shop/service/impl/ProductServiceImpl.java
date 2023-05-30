package com.example.important_shop.service.impl;

import com.example.important_shop.entity.Product;
import com.example.important_shop.entity.User;
import com.example.important_shop.repository.ProductRepository;
import com.example.important_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Value("${important_shop.upload.image.path}")
    private String imageUploadPath;

    @Override
    public List<Product> findProducts() {
        List<Product> products =productRepository.findAll();
        return products;
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void addProduct(User currentUser, MultipartFile multipartFile, Product product) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            product.setImgPath(fileName);
        }
        productRepository.save(product);
    }
    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);

    }
}


