package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.Like;
import com.FackbookPostDemo.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeRepository likeRepository;

    @Override
    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    @Override
    public Like getLike(int id) {
        return likeRepository.findById(id).get();
    }

    @Override
    public String deleteLike(int id) {
        likeRepository.deleteById(id);
        return "Deleted";
    }
}
