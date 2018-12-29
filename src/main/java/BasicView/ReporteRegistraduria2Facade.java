/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView;

import com.bisacorporation.entities.ReporteRegistraduria2;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JHON
 */
@Stateless
public class ReporteRegistraduria2Facade extends AbstractFacade<ReporteRegistraduria2> {
    @PersistenceContext(unitName = "DBBISA")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteRegistraduria2Facade() {
        super(ReporteRegistraduria2.class);
    }
    
}
