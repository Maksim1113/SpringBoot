package ru.khaustov.springcrud.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.khaustov.springcrud.models.UserModel;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    private SessionFactory sessionFactory;
    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<UserModel> getAllUsers(){

            Session session = sessionFactory.getCurrentSession();
        List<UserModel> users = session.createQuery("from UserModel",
                UserModel.class).getResultList();
        return users;
    }

    @Override
    @Transactional
    public UserModel getUser(long id){
        UserModel user = new UserModel();
        Session session = sessionFactory.getCurrentSession();
        return user = session.get(UserModel.class, id);
    }

    @Override
    @Transactional
    public void addUser(UserModel user) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from UserModel " +
                "where id = :id").setParameter("id", id).executeUpdate();
    }
}
