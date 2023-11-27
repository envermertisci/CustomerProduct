package com.enoca.springmvc.service;


import com.enoca.springmvc.dao.FavoriteDAO;
import com.enoca.springmvc.entity.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteDAO favoriteDAO;

    @Override
    public List<Favorite> getFavorites() {
        return favoriteDAO.getFavorites();
    }

    @Override
    public void saveFavorite(final Favorite favorite) {
        favoriteDAO.saveFavorite(favorite);
    }
    @Override

    public Favorite getFavorite(final Integer id) {
        return favoriteDAO.getFavorite(id);
    }


    @Override
    public void deleteFavorite(final Integer id) {
        favoriteDAO.deleteFavorite(id);
    }
}


