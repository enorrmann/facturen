/*    */ package org.solidstate.facturen.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IvaUtil
/*    */ {
/*    */   public static String getSIString(Long si) {
/* 11 */     String siString = "RI";
/*    */     
/* 13 */     switch (si.intValue()) {
/*    */       case 1:
/* 15 */         siString = "RI";
/*    */         break;
/*    */       case 2:
/* 18 */         siString = "MT";
/*    */         break;
/*    */       case 3:
/* 21 */         siString = "CF";
/*    */         break;
/*    */       case 4:
/* 24 */         siString = "EX";
/*    */         break;
/*    */     } 
/*    */     
/* 28 */     return siString;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/utils/IvaUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */