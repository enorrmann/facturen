/*    */ package org.solidstate.facturen.gui.verifyers;
/*    */ 
/*    */ public class VerifyerFactory {
/*  4 */   private static final PeriodoVerifyer periodoVerifyer = new PeriodoVerifyer();
/*  5 */   private static final FechaVerifyer fechaVerifyer = new FechaVerifyer();
/*  6 */   private static final DecimalVerifyer decimalVerifyer = new DecimalVerifyer();
/*  7 */   private static final TipoFacturaVerifyer tipoFacturaVerifyer = new TipoFacturaVerifyer();
/*    */   
/*    */   public static DecimalVerifyer getDecimalVerifyer() {
/* 10 */     return decimalVerifyer;
/*    */   }
/*    */   
/*    */   public static FechaVerifyer getFechaVerifyer() {
/* 14 */     return fechaVerifyer;
/*    */   }
/*    */   
/*    */   public static PeriodoVerifyer getPeriodoVerifyer() {
/* 18 */     return periodoVerifyer;
/*    */   }
/*    */   
/*    */   public static TipoFacturaVerifyer getTipoFacturaVerifyer() {
/* 22 */     return tipoFacturaVerifyer;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/verifyers/VerifyerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */