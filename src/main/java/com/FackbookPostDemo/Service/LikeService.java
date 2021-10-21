package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.Like;

import java.util.List;

public interface LikeService {

    public Like saveLike(Like like);

    public List<Like> getAllLikes();

    public Like getLike(int id);

    public String deleteLike(int id);
}
