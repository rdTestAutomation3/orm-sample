package com.rd.repository;

import com.rd.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rd.config.HibernateConfig;

import java.util.List;

public class UserRepository {

    /**
     * Veritabanına yeni bir kullanıcı kaydeder.
     *
     * @param user Kaydedilecek kullanıcı nesnesi
     */
    public void saveUser(User user) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);  // persist yerine save değil
            transaction.commit();
            System.out.println("User saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Veritabanındaki tüm kullanıcıları döner.
     *
     * @return Kullanıcıların listesi
     */
    public List<User> getAllUsers() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).getResultList(); // getResultList standart
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Verilen ID'ye göre kullanıcıyı döner.
     *
     * @param id Kullanıcının ID'si
     * @return Bulunan kullanıcı veya null
     */
    public User getUserById(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.find(User.class, id);  // find daha modern ve güvenli
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Verilen kullanıcı nesnesini günceller.
     *
     * @param user Güncellenecek kullanıcı nesnesi
     */
    public void updateUser(User user) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user); // merge daha doğru bir güncelleme sağlar
            transaction.commit();
            System.out.println("User updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verilen ID'ye göre kullanıcıyı siler.
     *
     * @param id Silinecek kullanıcının ID'si
     */
    public void deleteUser(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.find(User.class, id);
            if (user != null) {
                session.remove(user); // delete yerine remove kullanımı önerilir
                System.out.println("User deleted successfully.");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
