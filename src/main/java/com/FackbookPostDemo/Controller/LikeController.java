package com.FackbookPostDemo.Controller;

import com.FackbookPostDemo.Entity.Like;
import com.FackbookPostDemo.Repository.PostRepository;
import com.FackbookPostDemo.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {

    @Autowired
    LikeService likeService;
    @Autowired
    PostRepository postRepository;

    @PostMapping("/saveLike/{id}")
    public Like saveLike(@PathVariable int id, @RequestBody Like like) {
        like.setPost(postRepository.findById(id).get());
        return likeService.saveLike(like);
    }

    @GetMapping("/getAllLikes")
    public List<Like> getULikes() {
        return likeService.getAllLikes();
    }

    @GetMapping("/getLike/{id}")
    public Like getLike(@PathVariable int id) {
        return likeService.getLike(id);
    }

    @DeleteMapping("/deleteLike/{id}")
    public String deleteLike(@PathVariable int id) {
        return likeService.deleteLike(id);
    }


}
