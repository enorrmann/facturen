/*    */ package org.solidstate.utils;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.GregorianCalendar;
/*    */ import java.util.Locale;
/*    */ 
/*    */ public class DateUtils {
/*    */   public static String getFormatoCorto(Date fecha) {
/* 12 */     if (fecha == null)
/* 13 */       return ""; 
/* 14 */     String format = "dd/MM/yyyy";
/* 15 */     SimpleDateFormat sdf = new SimpleDateFormat(format);
/*    */     
/* 17 */     return sdf.format(fecha);
/*    */   }
/*    */   
/*    */   public static String getFormatoLargo(Date fecha) {
/* 21 */     DateFormat dateFormatter = DateFormat.getDateInstance(1, 
/* 22 */         Locale.getDefault());
/* 23 */     return dateFormatter.format(fecha);
/*    */   }
/*    */   
/*    */   public static String getPeriodoFromFecha(Date fecha) {
/* 27 */     String periodoString = getFormatoCorto(fecha);
/* 28 */     return periodoString.substring(2).replaceAll("/", "");
/*    */   }
/*    */   
/*    */   public static String getPeriodoFromFechaActual() {
/* 32 */     int mes = GregorianCalendar.getInstance().get(2) + 1;
/*    */ 
/*    */     
/* 35 */     String periodoActivo = StringUtils.paddingString(Integer.toString(mes), 2, '0', true) + GregorianCalendar.getInstance().get(1);
/* 36 */     return periodoActivo;
/*    */   }
/*    */ 
/*    */   
/*    */   public static Date getDateFromString(String stringFecha) throws ParseException {
/* 41 */     String format = "dd/MM/yyyy";
/* 42 */     SimpleDateFormat sdf = new SimpleDateFormat(format);
/* 43 */     sdf.setLenient(false);
/* 44 */     return sdf.parse(stringFecha);
/*    */   }
/*    */   
/*    */   public static String getPeriodoLargo(String stringFecha) {
/* 48 */     String format = "MMyyyy";
/* 49 */     String format2 = "MMMMM 'de' yyyy";
/* 50 */     SimpleDateFormat sdf = new SimpleDateFormat(format);
/* 51 */     SimpleDateFormat sdf2 = new SimpleDateFormat(format2);
/* 52 */     sdf.setLenient(false);
/* 53 */     sdf2.setLenient(false);
/* 54 */     Date fechaNueva = null;
/*    */     try {
/* 56 */       fechaNueva = sdf.parse(stringFecha);
/* 57 */     } catch (ParseException e) {
/* 58 */       e.printStackTrace();
/*    */     } 
/* 60 */     return sdf2.format(fechaNueva);
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/utils/DateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */