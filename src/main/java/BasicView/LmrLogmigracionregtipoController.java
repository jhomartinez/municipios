package BasicView;

import BasicView.util.Consultas;
import com.bisacorporation.entities.LmrLogmigracionregtipo;
import BasicView.util.JsfUtil;
import BasicView.util.PaginationHelper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Named("lmrLogmigracionregtipoController")
@Stateless
public class LmrLogmigracionregtipoController implements Serializable {
    
    private LmrLogmigracionregtipo current;
    private DataModel items = null;
    @EJB
    private LmrLogmigracionregtipoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private EntityManager manager;
    
    public LmrLogmigracionregtipoController() {
    }
    
    public LmrLogmigracionregtipo getSelected() {
        if (current == null) {
            current = new LmrLogmigracionregtipo();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    private LmrLogmigracionregtipoFacade getFacade() {
        return ejbFacade;
    }
    
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }
                
                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }
    
    public String prepareList() {
        recreateModel();
        return "List";
    }
    
    public String prepareView() {
        current = (LmrLogmigracionregtipo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }
    
    public String prepareCreate() {
        current = new LmrLogmigracionregtipo();
        selectedItemIndex = -1;
        return "Create";
    }
    
    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("LmrLogmigracionregtipoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    
    public String prepareEdit() {
        current = (LmrLogmigracionregtipo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }
    
    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("LmrLogmigracionregtipoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    
    public String destroy() {
        current = (LmrLogmigracionregtipo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }
    
    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }
    
    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("LmrLogmigracionregtipoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }
    
    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }
    
    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }
    
    private void recreateModel() {
        items = null;
    }
    
    private void recreatePagination() {
        pagination = null;
    }
    
    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }
    
    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }
    
    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }
    
    public List<LmrLogmigracionregtipo> encontrarRegByDia(Date date1, Date date2) {
        ejbFacade = new LmrLogmigracionregtipoFacade();
        System.out.println("Fecha inicial-start:" + date1.toString());
        System.out.println("Fecha inicial-end:" + date2.toString());
        //Query q = manager.createNamedQuery("LmrLogmigracionregtipo.findByLmrFechainicial").setParameter("lmrFechainicial", date1).setParameter("lmrFechainicia2", date2);
        Query q = manager
                .createQuery("SELECT l FROM LmrLogmigracionregtipo l "
                        + "WHERE l.lmrFechainicial BETWEEN :lmrFechainicial1 AND :lmrFechainicial2")
                .setParameter("lmrFechainicial1", date1).setParameter("lmrFechainicial2", date2);
        //Query q = em.createNativeQuery("SELECT * FROM CALIDAD.LMR_LOGMIGRACIONREGTIPO", LmrLogmigracionregtipo.class);
        List<LmrLogmigracionregtipo> lista = q.getResultList();
        return lista;
    }
    
    public void createPersistence(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBBISA");
        manager = factory.createEntityManager();
    }
    
    public LmrLogmigracionregtipo contarMigDeHoy(Date date1, Date date2) {
        System.out.println("Fecha inicontarMigDeHoycial-start:" + date1.toString());
        System.out.println("Fecha inicial-end:" + date2.toString());
        ejbFacade = new LmrLogmigracionregtipoFacade();
        createPersistence();
        /*Query q = manager
                .createQuery(Consultas.ENCONTRAR_REG_INSERT_BY_DIA)
                .setParameter("lmrFechainicial1", date1).setParameter("lmrFechainicial2", date2);*/
        LmrLogmigracionregtipo x = new LmrLogmigracionregtipo();
        Query q = manager
                .createQuery(Consultas.ENCONTRAR_REG_BY_DIA)
                .setParameter("lmrFechainicial1", date1).setParameter("lmrFechainicial2", date2);        
        Object o = q.getSingleResult();
        if (o instanceof Object[]) {
            Object[] row = (Object[]) o;
            x.setLmrInsertados((BigInteger) row[0]);
            x.setLmrActualizados((BigInteger) row[1]);
            x.setLmrBorrados((BigInteger) row[2]);
            x.setLmrErrores((BigInteger) row[3]);
        }
        return x;
    }    
    
    public LmrLogmigracionregtipo getLmrLogmigracionregtipo(java.math.BigDecimal id) {
        return ejbFacade.find(id);
    }
    
    @FacesConverter(forClass = LmrLogmigracionregtipo.class)
    public static class LmrLogmigracionregtipoControllerConverter implements Converter {
        
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LmrLogmigracionregtipoController controller = (LmrLogmigracionregtipoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "lmrLogmigracionregtipoController");
            return controller.getLmrLogmigracionregtipo(getKey(value));
        }
        
        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }
        
        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }
        
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof LmrLogmigracionregtipo) {
                LmrLogmigracionregtipo o = (LmrLogmigracionregtipo) object;
                return getStringKey(o.getLmrIdlogmigracion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + LmrLogmigracionregtipo.class.getName());
            }
        }
        
    }
    
}
