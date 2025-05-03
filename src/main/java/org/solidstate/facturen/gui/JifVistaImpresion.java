/*    */ package org.solidstate.facturen.gui;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Toolkit;
/*    */ import javax.swing.JInternalFrame;
/*    */ import javax.swing.event.InternalFrameEvent;
/*    */ import javax.swing.event.InternalFrameListener;
/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import net.sf.jasperreports.engine.JasperPrint;
/*    */ 
/*    */ public class JifVistaImpresion extends JInternalFrame {
/* 13 */   VistaImpresion miVista = null;
/*    */   
/*    */   public JifVistaImpresion(JasperPrint reporte) {
/*    */     try {
/* 17 */       this.miVista = new VistaImpresion(reporte);
/* 18 */     } catch (JRException ex) {
/* 19 */       ex.printStackTrace();
/*    */     } 
/* 21 */     initComponents();
/* 22 */     getContentPane().add((Component)this.miVista, "Center");
/* 23 */     setResizable(true);
/* 24 */     setMaximizable(true);
/*    */   }
/*    */   
/*    */   private void initComponents() {
/* 28 */     setClosable(true);
/* 29 */     setTitle("Vista Previa");
/* 30 */     addInternalFrameListener(new InternalFrameListener() {
/*    */           public void internalFrameActivated(InternalFrameEvent evt) {}
/*    */           
/*    */           public void internalFrameClosed(InternalFrameEvent evt) {}
/*    */           
/*    */           public void internalFrameClosing(InternalFrameEvent evt) {
/* 36 */             JifVistaImpresion.this.formInternalFrameClosing(evt);
/*    */           }
/*    */           
/*    */           public void internalFrameDeactivated(InternalFrameEvent evt) {}
/*    */           
/*    */           public void internalFrameDeiconified(InternalFrameEvent evt) {}
/*    */           
/*    */           public void internalFrameIconified(InternalFrameEvent evt) {}
/*    */           
/*    */           public void internalFrameOpened(InternalFrameEvent evt) {}
/*    */         });
/* 47 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 48 */     setBounds((screenSize.width - 660) / 2, (screenSize.height - 520) / 2, 660, 520);
/*    */   }
/*    */   
/*    */   private void formInternalFrameClosing(InternalFrameEvent evt) {
/* 52 */     dispose();
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JifVistaImpresion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */