package persistencia;

import Logica.ClassUser;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
//Agregamos la siguiente libreria
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.exceptions.NonexistentEntityException;

//Despues de haber creado la persistencia creamos el Jpa Controller 
public class ClassUserJpaController implements Serializable {

    public ClassUserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //Creamos un constructor nuevo 
    public ClassUserJpaController() {
        //colocamos el nombre de la unidad de persistencia
        emf=Persistence.createEntityManagerFactory("CoworkingPU");
    }
    //Despues creamos la controladora de persistencia como una java class en persistencia
   
    public void create(ClassUser ClassUser) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ClassUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClassUser ClassUser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ClassUser = em.merge(ClassUser);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ClassUser.getId_usu();
                if (findClassUser(id) == null) {
                    throw new NonexistentEntityException("The classUser with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ClassUser ClassUser;
            try {
                ClassUser = em.getReference(ClassUser.class, id);
                ClassUser.getId_usu();
                
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The classUser with id " + id + " no longer exists.", enfe);
            }
            if (em.getReference(ClassUser.class, id) == null) {
                em.getTransaction().commit();
                }
                else{
                em.remove(ClassUser);
                em.getTransaction().commit();
                }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClassUser> findClassUserEntities() {
        return findClassUserEntities(true, -1, -1);
    }

    public List<ClassUser> findClassUserEntities(int maxResults, int firstResult) {
        return findClassUserEntities(false, maxResults, firstResult);
    }

    private List<ClassUser> findClassUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClassUser.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ClassUser findClassUser(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClassUser.class, id);
        } finally {
            em.close();
        }
    }

    public int getClassUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClassUser> rt = cq.from(ClassUser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
