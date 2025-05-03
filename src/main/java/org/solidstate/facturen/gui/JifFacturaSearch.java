/*    */ package org.solidstate.facturen.gui;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JInternalFrame;
/*    */ import javax.swing.LayoutStyle;
/*    */ import org.solidstate.facturen.core.BusinessDelegator;
/*    */ 
/*    */ public class JifFacturaSearch
/*    */   extends JInternalFrame
/*    */ {
/*    */   private JButton jButton1;
/*    */   private JpListadoFacturas jpListadoFacturas1;
/*    */   private JpPersona jpPersona1;
/*    */   
/*    */   public JifFacturaSearch() {
/* 19 */     initComponents();
/*    */   }
/*    */   
/*    */   private void initComponents() {
/* 23 */     this.jpPersona1 = new JpPersona();
/* 24 */     this.jpListadoFacturas1 = new JpListadoFacturas();
/* 25 */     this.jButton1 = new JButton();
/* 26 */     setClosable(true);
/* 27 */     setResizable(true);
/* 28 */     setTitle("Seleccionar Factura");
/* 29 */     this.jButton1.setText("Buscar");
/* 30 */     this.jButton1.addActionListener(new ActionListener() {
/*    */           public void actionPerformed(ActionEvent evt) {
/* 32 */             JifFacturaSearch.this.jButton1ActionPerformed(evt);
/*    */           }
/*    */         });
/* 35 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 36 */     getContentPane().setLayout(layout);
/* 37 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jpPersona1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1)).addComponent(this.jpListadoFacturas1, -2, -1, -2)).addContainerGap(-1, 32767)));
/* 38 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1).addGroup(layout.createSequentialGroup().addComponent(this.jpPersona1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpListadoFacturas1, -2, -1, -2))).addContainerGap(-1, 32767)));
/* 39 */     pack();
/*    */   }
/*    */   
/*    */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 43 */     buscarFacturas();
/*    */   }
/*    */   
/*    */   private void buscarFacturas() {
/* 47 */     this.jpListadoFacturas1.setFacturas(BusinessDelegator.getInstance().getFacturasByPersona(this.jpPersona1.getPersona()));
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JifFacturaSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */