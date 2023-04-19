package br.com.fiap.progamer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.progamer.bean.ProfileBean;
import br.com.fiap.progamer.model.ProfileModel;

public class ProfileDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("progamer");

    public void save(ProfileBean profileBean) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            ProfileModel profileModel = new ProfileModel();
            profileModel.setName(profileBean.getName());
            profileModel.setEmail(profileBean.getEmail());
            profileModel.setProfile(profileBean.getProfile());
            profileModel.setPassword(profileBean.getPassword());

            em.persist(profileModel);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Erro ao salvar o perfil", e);
        } finally {
            em.close();
        }
    }

    public ProfileModel findById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(ProfileModel.class, id);
        } finally {
            em.close();
        }
    }

    public List<ProfileModel> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ProfileModel> query = em.createQuery("FROM ProfileModel", ProfileModel.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void delete(ProfileModel profileModel) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            em.remove(em.merge(profileModel));

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Erro ao excluir o perfil", e);
        } finally {
            em.close();
        }
    }

	public void create(ProfileModel profileModel) {
	}
}
