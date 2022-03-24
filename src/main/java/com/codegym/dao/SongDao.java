package com.codegym.dao;

import com.codegym.model.Song;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SongDao implements ISongDao {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static { //Cấu hình tạo kết nối ứng dụng với CSDL
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> findAll() {
        String query ="SELECT s FROM Song as s";
        TypedQuery<Song> typedQuery =entityManager.createQuery(query, Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public Song findById(long id) {
        return null;
    }

    @Override
    public Song save(Song song) {
        return null;
    }

    @Override
    public void removeById(long id) {

    }
}
