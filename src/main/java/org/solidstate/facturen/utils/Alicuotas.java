/*    */ package org.solidstate.facturen.utils;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.RoundingMode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Alicuotas
/*    */ {
/* 12 */   public static String ALICUOTA_DGR_VENTA_PRODUCTOS = "3";
/* 13 */   public static String ALICUOTA_DGR_VENTA_HONORARIOS = "2";
/* 14 */   public static String ALICUOTA_TASA_HIGINE_VENTA_PRODUCTOS = "3";
/* 15 */   public static String ALICUOTA_TASA_HIGINE_VENTA_HONORARIOS = "0";
/* 16 */   private static final BigDecimal CIEN = BigDecimal.valueOf(100L);
/*    */   
/*    */   public static BigDecimal getAlicuotaTasaHigiene(String concepto) {
/* 19 */     if (concepto.equals("1")) {
/* 20 */       BigDecimal ali = new BigDecimal(ALICUOTA_TASA_HIGINE_VENTA_PRODUCTOS);
/* 21 */       return ali.setScale(2, RoundingMode.HALF_UP);
/*    */     } 
/* 23 */     return BigDecimal.ZERO;
/*    */   }
/*    */ 
/*    */   
/*    */   public static BigDecimal getAlicuotaDgr(String concepto) {
/*    */     BigDecimal ali;
/* 29 */     if (concepto.equals("1")) {
/* 30 */       ali = new BigDecimal(ALICUOTA_DGR_VENTA_PRODUCTOS);
/*    */     } else {
/* 32 */       ali = new BigDecimal(ALICUOTA_DGR_VENTA_HONORARIOS);
/*    */     } 
/* 34 */     return ali.setScale(2, RoundingMode.HALF_UP);
/*    */   }
/*    */ 
/*    */   
/*    */   public static BigDecimal getPorcentajeAlicuotaTasaHigiene(String concepto) {
/* 39 */     if (concepto.equals("1")) {
/* 40 */       return getAlicuotaTasaHigiene(concepto).divide(CIEN);
/*    */     }
/* 42 */     return BigDecimal.ZERO;
/*    */   }
/*    */ 
/*    */   
/*    */   public static BigDecimal getPorcentajeAlicuotaDgr(String concepto) {
/* 47 */     return getAlicuotaDgr(concepto).divide(CIEN);
/*    */   }
/*    */   
/*    */   public static BigDecimal getAlicuotaDgr(Long concepto) {
/* 51 */     return getAlicuotaDgr(concepto + "");
/*    */   }
/*    */   
/*    */   public static BigDecimal getAlicuotaTasaHigiene(Long concepto) {
/* 55 */     return getAlicuotaTasaHigiene(concepto + "");
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/utils/Alicuotas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */