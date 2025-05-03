/*   */ package org.solidstate.facturen.gui;
/*   */ 
/*   */ import net.sf.jasperreports.engine.JRException;
/*   */ import net.sf.jasperreports.engine.JasperPrint;
/*   */ import net.sf.jasperreports.view.JRViewer;
/*   */ 
/*   */ public class VistaImpresion extends JRViewer {
/*   */   public VistaImpresion(JasperPrint jrPrint) throws JRException {
/* 9 */     super(jrPrint);
/*   */   }
/*   */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/VistaImpresion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */