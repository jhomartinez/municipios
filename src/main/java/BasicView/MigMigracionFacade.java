/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView;

import com.bisacorporation.entities.MigMigracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JHON
 */
@Stateless
public class MigMigracionFacade extends AbstractFacade<MigMigracion> {

    @PersistenceContext(unitName = "DBBISA")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MigMigracionFacade() {
        super(MigMigracion.class);
    }
    
}
