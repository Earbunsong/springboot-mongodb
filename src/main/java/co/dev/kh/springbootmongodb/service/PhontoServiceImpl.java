package co.dev.kh.springbootmongodb.service;

import co.dev.kh.springbootmongodb.collection.Photo;
import co.dev.kh.springbootmongodb.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhontoServiceImpl implements PhotoService{
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public Photo getPhoto(String id) {
        return photoRepository.findById(id).get();
    }

    @Override
    public String addPhoto(String originalFilename, MultipartFile image) throws IOException {
        Photo photo = new Photo();
        photo.setTitle(originalFilename);
        photo.setPhoto(new Binary(BsonBinarySubType.BINARY,image.getBytes()));
        return photoRepository.save(photo).getId();
    }
}
