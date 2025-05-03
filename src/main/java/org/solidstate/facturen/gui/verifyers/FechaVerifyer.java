/*    */ package org.solidstate.facturen.gui.verifyers;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.InputVerifier;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JFormattedTextField;
/*    */ import org.solidstate.utils.DateUtils;
/*    */ 
/*    */ 
/*    */ public class FechaVerifyer
/*    */   extends InputVerifier
/*    */ {
/*    */   public boolean verify(JComponent input) {
/* 14 */     boolean esValido = false;
/* 15 */     JFormattedTextField jTextField = (JFormattedTextField)input;
/* 16 */     String verificar = jTextField.getText();
/*    */     try {
/* 18 */       DateUtils.getDateFromString(verificar);
/* 19 */       esValido = true;
/* 20 */       jTextField.setBackground(Color.WHITE);
/* 21 */     } catch (Exception e) {
/* 22 */       esValido = false;
/* 23 */       jTextField.setBackground(Color.RED);
/*    */     } 
/* 25 */     return esValido;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/verifyers/FechaVerifyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */