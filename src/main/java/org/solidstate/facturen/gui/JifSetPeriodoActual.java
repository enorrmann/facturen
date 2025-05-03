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
/*    */ public class JifSetPeriodoActual
/*    */   extends JInternalFrame {
/*    */   private JButton jbCambiar;
/*    */   private JpPeriodoActivo jpPeriodoActivo1;
/*    */   
/*    */   public JifSetPeriodoActual() {
/* 17 */     initComponents();
/* 18 */     this.jpPeriodoActivo1.updateCombos();
/*    */   }
/*    */   
/*    */   private void initComponents() {
/* 22 */     this.jpPeriodoActivo1 = new JpPeriodoActivo();
/* 23 */     this.jbCambiar = new JButton();
/* 24 */     setClosable(true);
/* 25 */     setTitle("Seleccionar periodo Activo");
/* 26 */     this.jbCambiar.setText("Aceptar");
/* 27 */     this.jbCambiar.addActionListener(new ActionListener() {
/*    */           public void actionPerformed(ActionEvent evt) {
/* 29 */             JifSetPeriodoActual.this.jbCambiarActionPerformed(evt);
/*    */           }
/*    */         });
/* 32 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 33 */     getContentPane().setLayout(layout);
/* 34 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jpPeriodoActivo1, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(173, 32767).addComponent(this.jbCambiar).addContainerGap()));
/* 35 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jpPeriodoActivo1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addComponent(this.jbCambiar).addContainerGap()));
/* 36 */     pack();
/*    */   }
/*    */   
/*    */   private void jbCambiarActionPerformed(ActionEvent evt) {
/* 40 */     BusinessDelegator.getInstance().setPeriodoActivo(this.jpPeriodoActivo1.getPeriodo());
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JifSetPeriodoActual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */