package ru.khaustov.springcrud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.khaustov.springcrud.models.UserModel;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    private SessionFactory sessionFactory;
    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserModel> getAllUsers(){
        Transaction transaction = null;
        List<UserModel> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(UserModel.class);
            users = query.getResultList();
            transaction.commit();
            session.close();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }

        return users;
    }

    @Override
    public UserModel getUser(long id){
        Transaction transaction = null;
        String sql = "SELECT FROM users WHERE id = :id";

        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).setParameter("id", id).executeUpdate();
            transaction.commit();
            session.close();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void addUser(UserModel user) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }

    }

    @Override
    public void updateUser(long id, UserModel upUser) {
        getUser(id).setName(upUser.getName());
        getUser(id).setAge(upUser.getAge());
    }

    @Override
    public void deleteUser(long id) {
        Transaction transaction = null;
        String sql = "DELETE FROM users WHERE id = :id";

        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).setParameter("id", id).executeUpdate();
            transaction.commit();
            session.close();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
    }
}
