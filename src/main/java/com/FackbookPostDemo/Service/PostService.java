package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.Post;
import java.util.List;

public interface PostService {

    public Post savePost(Post post);

    public List<Post> getAllPosts();

    public Post getPost(int id);

    public String deletePost(int id);
}
