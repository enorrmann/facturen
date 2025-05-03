/*    */ package org.solidstate.facturen.gui;
/*    */ 
/*    */ import java.awt.Frame;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.LayoutStyle;
/*    */ 
/*    */ public class JDPeriodoImpresion
/*    */   extends JDialog {
/*    */   private JButton jbAceptar;
/*    */   private JpPeriodoActivo jpPeriodoActivo1;
/*    */   
/*    */   public JDPeriodoImpresion(Frame parent, boolean modal) {
/* 17 */     super(parent, modal);
/* 18 */     initComponents();
/*    */   }
/*    */   
/*    */   private void initComponents() {
/* 22 */     this.jpPeriodoActivo1 = new JpPeriodoActivo();
/* 23 */     this.jbAceptar = new JButton();
/* 24 */     setDefaultCloseOperation(2);
/* 25 */     this.jbAceptar.setText("Vista Previa");
/* 26 */     this.jbAceptar.addActionListener(new ActionListener() {
/*    */           public void actionPerformed(ActionEvent evt) {
/* 28 */             JDPeriodoImpresion.this.jbAceptarActionPerformed(evt);
/*    */           }
/*    */         });
/* 31 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 32 */     getContentPane().setLayout(layout);
/* 33 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jpPeriodoActivo1, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(124, 32767).addComponent(this.jbAceptar).addContainerGap()));
/* 34 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jpPeriodoActivo1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbAceptar).addContainerGap(-1, 32767)));
/* 35 */     pack();
/*    */   }
/*    */   
/*    */   private void jbAceptarActionPerformed(ActionEvent evt) {
/* 39 */     hideDialog();
/*    */   }
/*    */   
/*    */   private void hideDialog() {
/* 43 */     setVisible(false);
/*    */   }
/*    */   
/*    */   public String getPeriodoImpresion() {
/* 47 */     return this.jpPeriodoActivo1.getPeriodo();
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JDPeriodoImpresion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */