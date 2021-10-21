package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.Post;
import com.FackbookPostDemo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(int id) {
        return postRepository.findById(id).get();
    }

    @Override
    public String deletePost(int id) {
        postRepository.deleteById(id);
        return "Post Deleted";
    }
}
