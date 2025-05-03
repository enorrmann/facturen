/*    */ package org.solidstate.utils;
/*    */ 
/*    */ public class StringUtils
/*    */ {
/*    */   public static String paddingString(String s, int n, char c, boolean paddingLeft) {
/*  6 */     StringBuffer str = new StringBuffer(s);
/*  7 */     int strLength = str.length();
/*  8 */     if (n > 0 && n > strLength) {
/*  9 */       for (int i = 0; i <= n; i++) {
/* 10 */         if (paddingLeft) {
/* 11 */           if (i < n - strLength)
/* 12 */             str.insert(0, c); 
/* 13 */         } else if (i > strLength) {
/* 14 */           str.append(c);
/*    */         } 
/*    */       } 
/*    */     }
/* 18 */     return str.toString();
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/utils/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */