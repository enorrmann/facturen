/*    */ package org.solidstate.facturen.gui.verifyers;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.InputVerifier;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConceptoVerifyer
/*    */   extends InputVerifier
/*    */ {
/*    */   public boolean verify(JComponent input) {
/* 17 */     boolean esValido = false;
/* 18 */     JTextField jTextField = (JTextField)input;
/* 19 */     String verificar = jTextField.getText();
/* 20 */     if (verificar == null || "".equals(verificar)) {
/* 21 */       esValido = false;
/*    */     } else {
/*    */       try {
/* 24 */         int tipo = Integer.parseInt(verificar);
/* 25 */         esValido = (tipo == 1 || tipo == 2);
/* 26 */       } catch (Exception e) {
/* 27 */         esValido = false;
/*    */       } 
/*    */     } 
/*    */     
/* 31 */     if (esValido) {
/* 32 */       jTextField.setBackground(Color.WHITE);
/*    */     } else {
/* 34 */       jTextField.setBackground(Color.RED);
/*    */     } 
/*    */     
/* 37 */     return esValido;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/verifyers/ConceptoVerifyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */