/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView;

import BasicView.exceptions.NonexistentEntityException;
import BasicView.exceptions.PreexistingEntityException;
import BasicView.exceptions.RollbackFailureException;
import com.bisacorporation.entities.EstadisticasDoc;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author JHON
 */
public class EstadisticasDocJpaController implements Serializable {

    public EstadisticasDocJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadisticasDoc estadisticasDoc) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(estadisticasDoc);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEstadisticasDoc(estadisticasDoc.getIdRepoestadis()) != null) {
                throw new PreexistingEntityException("EstadisticasDoc " + estadisticasDoc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadisticasDoc estadisticasDoc) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            estadisticasDoc = em.merge(estadisticasDoc);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = estadisticasDoc.getIdRepoestadis();
                if (findEstadisticasDoc(id) == null) {
                    throw new NonexistentEntityException("The estadisticasDoc with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            EstadisticasDoc estadisticasDoc;
            try {
                estadisticasDoc = em.getReference(EstadisticasDoc.class, id);
                estadisticasDoc.getIdRepoestadis();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadisticasDoc with id " + id + " no longer exists.", enfe);
            }
            em.remove(estadisticasDoc);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadisticasDoc> findEstadisticasDocEntities() {
        return findEstadisticasDocEntities(true, -1, -1);
    }

    public List<EstadisticasDoc> findEstadisticasDocEntities(int maxResults, int firstResult) {
        return findEstadisticasDocEntities(false, maxResults, firstResult);
    }

    private List<EstadisticasDoc> findEstadisticasDocEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadisticasDoc.class));
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

    public EstadisticasDoc findEstadisticasDoc(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadisticasDoc.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadisticasDocCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadisticasDoc> rt = cq.from(EstadisticasDoc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
