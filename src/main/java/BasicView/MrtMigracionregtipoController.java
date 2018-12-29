package BasicView;

import BasicView.util.Consultas;
import com.bisacorporation.entities.MrtMigracionregtipo;
import BasicView.util.JsfUtil;
import BasicView.util.PaginationHelper;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
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

@Named("mrtMigracionregtipoController")
@SessionScoped
public class MrtMigracionregtipoController implements Serializable {

    private MrtMigracionregtipo current;
    private DataModel items = null;
    @EJB
    private MrtMigracionregtipoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private EntityManager manager;

    public MrtMigracionregtipoController() {
    }

    public MrtMigracionregtipo getSelected() {
        if (current == null) {
            current = new MrtMigracionregtipo();
            selectedItemIndex = -1;
        }
        return current;
    }

    private MrtMigracionregtipoFacade getFacade() {
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
        current = (MrtMigracionregtipo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new MrtMigracionregtipo();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("MrtMigracionregtipoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (MrtMigracionregtipo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("MrtMigracionregtipoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (MrtMigracionregtipo) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("MrtMigracionregtipoDeleted"));
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

    public MrtMigracionregtipo getMrtMigracionregtipo(java.math.BigDecimal id) {
        return ejbFacade.find(id);
    }
    
    public void createPersistence(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBBISA");
        manager = factory.createEntityManager();
    }
    
    public List<MrtMigracionregtipo> obtenerRegTipoDeHoy(Date date1, Date date2) {
        System.out.println("Fecha inicontarMigDeHoycial-start:" + date1.toString());
        System.out.println("Fecha inicial-end:" + date2.toString());
        ejbFacade = new MrtMigracionregtipoFacade();
        createPersistence();
        /*Query q = manager
                .createQuery(Consultas.ENCONTRAR_REG_INSERT_BY_DIA)
                .setParameter("lmrFechainicial1", date1).setParameter("lmrFechainicial2", date2);*/
        MrtMigracionregtipo x = new MrtMigracionregtipo();
        Query q = manager
                .createQuery(Consultas.ENCONTRAR_REG_TIPO_BY_DIA)
                .setParameter("lmrFechainicial1", date1).setParameter("lmrFechainicial2", date2);
        return q.getResultList();
    }

    @FacesConverter(forClass = MrtMigracionregtipo.class)
    public static class MrtMigracionregtipoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MrtMigracionregtipoController controller = (MrtMigracionregtipoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mrtMigracionregtipoController");
            return controller.getMrtMigracionregtipo(getKey(value));
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
            if (object instanceof MrtMigracionregtipo) {
                MrtMigracionregtipo o = (MrtMigracionregtipo) object;
                return getStringKey(o.getMrtIdmigracionregtipo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + MrtMigracionregtipo.class.getName());
            }
        }

    }

}
