package com.example.securityboot.repository;


import com.example.securityboot.models.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UsersRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select distinct u from User u join fetch u.roles",
                User.class).getResultList();
    }
    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void updateUser(long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }
    @Override
    public User getUserByName(String name) {
        return (User) entityManager.createQuery(
                "from User u join fetch u.roles where u.name=:name"
        ).setParameter("name", name).getSingleResult();
    }
}

