/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView;

import com.bisacorporation.entities.LmrLogmigracionregtipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JHON
 */
@Stateless
public class LmrLogmigracionregtipoFacade extends AbstractFacade<LmrLogmigracionregtipo> {
    @PersistenceContext(unitName = "DBBISA")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LmrLogmigracionregtipoFacade() {
        super(LmrLogmigracionregtipo.class);
    }
    
}
