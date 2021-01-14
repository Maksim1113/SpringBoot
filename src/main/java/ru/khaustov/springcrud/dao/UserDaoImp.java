package ru.khaustov.springcrud.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.khaustov.springcrud.models.RoleModel;
import ru.khaustov.springcrud.models.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<UserModel> getAllUsers(){

        List<UserModel> users = entityManager.createQuery("select a from UserModel a", UserModel.class).getResultList();
        return users;
    }

    @Override
    @Transactional
    public UserModel getUser(long id){
        UserModel user = new UserModel();
        Query query = entityManager.createQuery("select e from UserModel e where e.id = :id");
        query.setParameter("id", id);
        return user = (UserModel) query.getSingleResult();
    }

    @Override
    @Transactional
    public void addUser(UserModel user) {
        if (user.getId() == 0) {
           user.setRoles(Collections.singleton(new RoleModel(1L, "ROLE_USER")));
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void deleteUser(long id){
        String sql = "DELETE FROM UserModel WHERE id = :id";
        entityManager.createQuery(sql).setParameter("id", id).executeUpdate();
    }

    @Override
    public UserModel getUserByName(String username) {
        UserModel user = new UserModel();
        Query query = entityManager.createQuery("select e from UserModel e where e.username = :username");
        query.setParameter("username", username);
        return user = (UserModel) query.getSingleResult();
    }
}
