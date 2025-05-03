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
/*    */ 
/*    */ 
/*    */ public class SituacionIvaVerifyer
/*    */   extends InputVerifier
/*    */ {
/*    */   private final String tipoFactura;
/*    */   
/*    */   public SituacionIvaVerifyer(String tipoFactura) {
/* 21 */     this.tipoFactura = tipoFactura;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean verify(JComponent input) {
/* 27 */     boolean esValido = false;
/* 28 */     JTextField jTextField = (JTextField)input;
/* 29 */     String verificar = jTextField.getText();
/* 30 */     if (verificar == null || "".equals(verificar)) {
/* 31 */       esValido = false;
/*    */     } else {
/*    */       try {
/* 34 */         int tipo = Integer.parseInt(verificar);
/*    */         
/* 36 */         esValido = ((this.tipoFactura.equalsIgnoreCase("a") && tipo == 1) || (this.tipoFactura.equalsIgnoreCase("b") && (tipo == 2 || tipo == 3 || tipo == 4)));
/* 37 */       } catch (Exception e) {
/* 38 */         esValido = false;
/*    */       } 
/*    */     } 
/*    */     
/* 42 */     if (esValido) {
/* 43 */       jTextField.setBackground(Color.WHITE);
/*    */     } else {
/* 45 */       jTextField.setBackground(Color.RED);
/* 46 */       jTextField.selectAll();
/*    */     } 
/*    */     
/* 49 */     return esValido;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/verifyers/SituacionIvaVerifyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */