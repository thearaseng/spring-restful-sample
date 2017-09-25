package com.theara.restful.restfulwebservice.service;

import com.theara.restful.restfulwebservice.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public int insert(User user){
        entityManager.persist(user);
        return user.getId();
    }

}
