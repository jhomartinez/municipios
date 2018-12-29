/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView;

import com.bisacorporation.entities.ReporteRegistraduria3;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JHON
 */
@Stateless
public class ReporteRegistraduria3Facade extends AbstractFacade<ReporteRegistraduria3> {
    @PersistenceContext(unitName = "DBBISA")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteRegistraduria3Facade() {
        super(ReporteRegistraduria3.class);
    }
    
}
