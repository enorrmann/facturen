/*    */ package org.solidstate.facturen.gui.verifyers;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.InputVerifier;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ public class PeriodoVerifyer
/*    */   extends InputVerifier
/*    */ {
/*    */   public boolean verify(JComponent input) {
/* 12 */     boolean esValido = false;
/* 13 */     JTextField jTextField = (JTextField)input;
/* 14 */     String verificar = jTextField.getText();
/*    */     
/* 16 */     if (verificar.length() != 7) {
/* 17 */       jTextField.setBackground(Color.RED);
/* 18 */       return false;
/*    */     } 
/*    */     try {
/* 21 */       int mes = Integer.parseInt(verificar.substring(0, 2));
/* 22 */       int anio = Integer.parseInt(verificar.substring(3, 7));
/* 23 */       if (mes > 0 && mes < 13 && anio > 2007 && anio < 2050) {
/* 24 */         esValido = true;
/* 25 */         jTextField.setBackground(Color.WHITE);
/*    */       } else {
/* 27 */         esValido = false;
/* 28 */         jTextField.setBackground(Color.RED);
/*    */       } 
/* 30 */     } catch (Exception e) {
/* 31 */       esValido = false;
/* 32 */       jTextField.setBackground(Color.RED);
/*    */     } 
/* 34 */     return esValido;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/verifyers/PeriodoVerifyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */