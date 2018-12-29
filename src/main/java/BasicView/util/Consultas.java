/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView.util;

/**
 *
 * @author JHON
 */
public class Consultas {

    public final static String ENCONTRAR_REG_BY_DIA
            = "SELECT "
            + "SUM(l.lmrInsertados) as LMR_INSERTADOS, "
            + "SUM(l.lmrActualizados) as LMR_ACTUALIZADOS, "
            + "SUM(l.lmrBorrados) as LMR_BORRADOS, "
            + "SUM(l.lmrErrores) as LMR_ERRORES FROM LmrLogmigracionregtipo l "
            + "WHERE l.lmrFechainicial BETWEEN :lmrFechainicial1 AND :lmrFechainicial2";
    public final static String ENCONTRAR_REG_TIPO_BY_DIA =
              "SELECT DISTINCT m FROM MrtMigracionregtipo m, LmrLogmigracionregtipo l "
            + "WHERE m.mrtIdmigracionregtipo = l.mrtIdmigracionregtipo AND "
            + "l.lmrFechainicial BETWEEN :lmrFechainicial1 AND :lmrFechainicial2";
    public final static String ENCONTRAR_REG_DETALLE_ERROR =
              "SELECT e FROM EmiErrormigracion e, MrtMigracionregtipo m, LmrLogmigracionregtipo l "
            + "WHERE e.mrtIdmigracionregtipo = m.mrtIdmigracionregtipo AND "
            + "l.mrtIdmigracionregtipo = m.mrtIdmigracionregtipo AND "
            + "l.lmrFechainicial BETWEEN :lmrFechainicial1 AND :lmrFechainicial2";
            
    public final static String ENCONTRAR_REG_TOTALES_DIA =
            "SELECT SUM(l.LMR_INSERTADOS + l.LMR_ACTUALIZADOS + l.LMR_BORRADOS + l.LMR_ERRORES) CANT_REG " +
            "FROM CALIDAD.LMR_LOGMIGRACIONREGTIPO l";
    
    public final static String ENCONTRAR_REG_INSERT_BY_DIA =
            "SELECT "
            + "SUM(l.lmrInsertados) FROM LmrLogmigracionregtipo l "
            + "WHERE l.lmrFechainicial BETWEEN :lmrFechainicial1 AND :lmrFechainicial2";
}
