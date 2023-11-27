package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Comment;
import com.enoca.springmvc.entity.Favorite;

import java.util.List;

public interface FavoriteDAO {

    List<Favorite> getFavorites();
    void deleteFavorite(Integer id);
    void saveFavorite(Favorite favorite);
    Favorite getFavorite(Integer id);
}
