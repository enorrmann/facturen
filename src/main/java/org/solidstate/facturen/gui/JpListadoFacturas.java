/*    */ package org.solidstate.facturen.gui;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.util.List;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.LayoutStyle;
/*    */ import org.solidstate.facturen.core.BusinessDelegator;
/*    */ import org.solidstate.facturen.entities.DocumentoDeCompra;
/*    */ import org.solidstate.facturen.entities.DocumentoDeVenta;
/*    */ import org.solidstate.facturen.entities.Factura;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JpListadoFacturas
/*    */   extends JPanel
/*    */ {
/*    */   private ModeloTablaFacturas modeloTablaFacturas;
/*    */   private JScrollPane jScrollPane1;
/*    */   private JButton jbBorrar;
/*    */   private JButton jbModificar;
/*    */   private JTable jtFacturas;
/*    */   
/*    */   public JpListadoFacturas() {
/* 32 */     this.modeloTablaFacturas = new ModeloTablaFacturas();
/* 33 */     initComponents();
/*    */   }
/*    */   
/*    */   private void initComponents() {
/* 37 */     this.jScrollPane1 = new JScrollPane();
/* 38 */     this.jtFacturas = new JTable();
/* 39 */     this.jbModificar = new JButton();
/* 40 */     this.jbBorrar = new JButton();
/* 41 */     this.jtFacturas.setModel(this.modeloTablaFacturas);
/* 42 */     this.jScrollPane1.setViewportView(this.jtFacturas);
/* 43 */     this.jbModificar.setText("Modificar");
/* 44 */     this.jbModificar.addActionListener(new ActionListener() {
/*    */           public void actionPerformed(ActionEvent evt) {
/* 46 */             JpListadoFacturas.this.jbModificarActionPerformed(evt);
/*    */           }
/*    */         });
/* 49 */     this.jbBorrar.setText("Borrar");
/* 50 */     this.jbBorrar.addActionListener(new ActionListener() {
/*    */           public void actionPerformed(ActionEvent evt) {
/* 52 */             JpListadoFacturas.this.jbBorrarActionPerformed(evt);
/*    */           }
/*    */         });
/* 55 */     GroupLayout layout = new GroupLayout(this);
/* 56 */     setLayout(layout);
/* 57 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 375, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jbModificar).addComponent(this.jbBorrar)).addContainerGap()));
/* 58 */     layout.linkSize(0, new Component[] { this.jbBorrar, this.jbModificar });
/* 59 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jbModificar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbBorrar)).addComponent(this.jScrollPane1, -2, 275, -2)).addContainerGap(13, 32767)));
/*    */   }
/*    */   
/*    */   private void jbModificarActionPerformed(ActionEvent evt) {
/* 63 */     mostrarFactura();
/*    */   }
/*    */   
/*    */   private void jbBorrarActionPerformed(ActionEvent evt) {
/* 67 */     borrarFactura();
/*    */   }
/*    */   
/*    */   public void setFacturas(List<DocumentoDeCompra> facturas) {
/* 71 */     ((ModeloTablaFacturas)this.jtFacturas.getModel()).setFacturas(facturas);
/*    */   }
/*    */   
/*    */   private void mostrarFactura() {
/* 75 */     if (this.jtFacturas.getSelectedRow() < 0) {
/*    */       return;
/*    */     }
/* 78 */     Factura unaFactura = ((ModeloTablaFacturas)this.jtFacturas.getModel()).getFactura(this.jtFacturas.getSelectedRow());
/* 79 */     if (unaFactura instanceof DocumentoDeCompra) {
/* 80 */       JfPrincipal.getInstance().showJifFacturaCompra((DocumentoDeCompra)unaFactura);
/*    */     }
/* 82 */     if (unaFactura instanceof DocumentoDeVenta) {
/* 83 */       JfPrincipal.getInstance().showJifFacturaVenta((DocumentoDeVenta)unaFactura);
/*    */     }
/*    */   }
/*    */   
/*    */   private void borrarFactura() {
/* 88 */     if (this.jtFacturas.getSelectedRow() < 0) {
/*    */       return;
/*    */     }
/* 91 */     Factura unaFactura = ((ModeloTablaFacturas)this.jtFacturas.getModel()).getFactura(this.jtFacturas.getSelectedRow());
/* 92 */     int borrar = JOptionPane.showInternalConfirmDialog(this, "Borrar la factura numero " + unaFactura.getNumeroFactura() + " de " + unaFactura.getPersona().getRazonSocial() + " ?");
/* 93 */     if (borrar == 0) {
/* 94 */       BusinessDelegator.getInstance().borrarFactura(unaFactura);
/* 95 */       setFacturas(BusinessDelegator.getInstance().getFacturasByPersona(unaFactura.getPersona()));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JpListadoFacturas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */