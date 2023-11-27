package com.enoca.springmvc.service;

import com.enoca.springmvc.entity.Comment;
import com.enoca.springmvc.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    List<Favorite> getFavorites();
    void saveFavorite(Favorite favorite);
    Favorite getFavorite(Integer id);
    void deleteFavorite(Integer id);
}
