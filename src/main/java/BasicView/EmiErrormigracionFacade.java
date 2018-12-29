/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView;

import com.bisacorporation.entities.EmiErrormigracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JHON
 */
@Stateless
public class EmiErrormigracionFacade extends AbstractFacade<EmiErrormigracion> {

    @PersistenceContext(unitName = "DBBISA")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmiErrormigracionFacade() {
        super(EmiErrormigracion.class);
    }
    
}
