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
/*    */ public class TipoFacturaVerifyer
/*    */   extends InputVerifier
/*    */ {
/*    */   public boolean verify(JComponent input) {
/* 15 */     boolean esValido = false;
/* 16 */     JTextField jTextField = (JTextField)input;
/* 17 */     String verificar = jTextField.getText();
/* 18 */     if (verificar == null || "".equals(verificar)) {
/* 19 */       esValido = false;
/*    */     } else {
/*    */       try {
/* 22 */         int tipo = Integer.parseInt(verificar);
/* 23 */         esValido = (tipo == 1 || tipo == 2);
/* 24 */       } catch (Exception e) {
/* 25 */         esValido = false;
/*    */       } 
/*    */     } 
/*    */     
/* 29 */     if (esValido) {
/* 30 */       jTextField.setBackground(Color.WHITE);
/*    */     } else {
/* 32 */       jTextField.setBackground(Color.RED);
/*    */     } 
/*    */     
/* 35 */     return esValido;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/verifyers/TipoFacturaVerifyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */