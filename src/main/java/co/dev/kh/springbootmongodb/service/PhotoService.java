package co.dev.kh.springbootmongodb.service;

import co.dev.kh.springbootmongodb.collection.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    Photo getPhoto(String id);

    String addPhoto(String originalFilename, MultipartFile image) throws IOException;
}
