/*    */ package org.solidstate.facturen.gui.verifyers;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.math.BigDecimal;
/*    */ import javax.swing.InputVerifier;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ public class DecimalVerifyer
/*    */   extends InputVerifier
/*    */ {
/*    */   public boolean verify(JComponent input) {
/* 13 */     boolean esValido = false;
/* 14 */     JTextField jTextField = (JTextField)input;
/* 15 */     String verificar = jTextField.getText();
/* 16 */     if ("".equals(verificar)) {
/* 17 */       esValido = true;
/* 18 */       jTextField.setBackground(Color.WHITE);
/*    */     } else {
/*    */       try {
/* 21 */         new BigDecimal(verificar);
/* 22 */         esValido = true;
/* 23 */         jTextField.setBackground(Color.WHITE);
/* 24 */       } catch (Exception e) {
/* 25 */         esValido = false;
/* 26 */         jTextField.setBackground(Color.RED);
/*    */       } 
/*    */     } 
/*    */     
/* 30 */     return esValido;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/verifyers/DecimalVerifyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */