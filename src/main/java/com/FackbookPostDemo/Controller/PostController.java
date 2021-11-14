package com.FackbookPostDemo.Controller;

import com.FackbookPostDemo.Entity.Post;
import com.FackbookPostDemo.Repository.UserRepository;
import com.FackbookPostDemo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/savePost/{id}")
    public Post savePost(@PathVariable int id, @RequestBody Post post) {
        post.setUser(userRepository.findById(id).get());

        return postService.savePost(post);
    }

    @GetMapping("/getAllPosts")
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/getPost/{id}")
    public Post getPost(@PathVariable int id) {
        return postService.getPost(id);
    }

    @DeleteMapping("/deletePost/{id}")
    public String deletePost(@PathVariable int id) {
        return postService.deletePost(id);
    }
}