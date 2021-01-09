package ru.khaustov.springcrud.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.khaustov.springcrud.models.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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
}
