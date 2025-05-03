/*     */ package org.solidstate.facturen.reporting;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.sf.jasperreports.engine.JRDataSource;
/*     */ import net.sf.jasperreports.engine.JRException;
/*     */ import net.sf.jasperreports.engine.JasperFillManager;
/*     */ import net.sf.jasperreports.engine.JasperPrint;
/*     */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*     */ import org.solidstate.facturen.core.BusinessDelegator;
/*     */ import org.solidstate.facturen.entities.DocumentoDeCompra;
/*     */ import org.solidstate.facturen.entities.DocumentoDeVenta;
/*     */ import org.solidstate.utils.DateUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Reporte
/*     */ {
/*     */   private static final String PATH_TO_REPORTS = "org/solidstate/facturen/reporting/";
/*     */   
/*     */   public static JasperPrint getLibroIvaCompras() {
/*  32 */     List<DocumentoDeCompra> filasReporte = BusinessDelegator.getInstance().getFacturaCompraAll();
/*  33 */     invertirMontosNC(filasReporte);
/*  34 */     JasperPrint impresion = null;
/*  35 */     Map<Object, Object> parametros = new HashMap<Object, Object>();
/*  36 */     String periodo = DateUtils.getPeriodoLargo(BusinessDelegator.getInstance().getPeriodoImpresion());
/*  37 */     parametros.put("periodo", periodo);
/*     */     try {
/*  39 */       impresion = JasperFillManager.fillReport(
/*  40 */           getReportInputStream("IvaCompras"), parametros, (JRDataSource)new JRBeanCollectionDataSource(filasReporte));
/*     */     }
/*  42 */     catch (JRException ex) {
/*  43 */       ex.printStackTrace();
/*     */     } 
/*  45 */     return impresion;
/*     */   }
/*     */   
/*     */   public static JasperPrint getResumenDgr() {
/*  49 */     List<DocumentoDeCompra> filasReporte = BusinessDelegator.getInstance().getFacturaPercepcionDGR();
/*  50 */     invertirMontosNC(filasReporte);
/*  51 */     JasperPrint impresion = null;
/*  52 */     Map<Object, Object> parametros = new HashMap<Object, Object>();
/*  53 */     String periodo = DateUtils.getPeriodoLargo(BusinessDelegator.getInstance().getPeriodoImpresion());
/*  54 */     parametros.put("periodo", periodo);
/*     */     try {
/*  56 */       impresion = JasperFillManager.fillReport(
/*  57 */           getReportInputStream("ResumenDGR2"), parametros, (JRDataSource)new JRBeanCollectionDataSource(filasReporte));
/*     */     }
/*  59 */     catch (JRException ex) {
/*  60 */       ex.printStackTrace();
/*     */     } 
/*  62 */     return impresion;
/*     */   }
/*     */   
/*     */   private static InputStream getReportInputStream(String reportName) {
/*  66 */     return Reporte.class.getClassLoader().getResourceAsStream("org/solidstate/facturen/reporting/" + reportName + ".jasper");
/*     */   }
/*     */ 
/*     */   
/*     */   private static void invertirMontosNC(List<DocumentoDeCompra> documentosDeCompras) {
/*  71 */     for (DocumentoDeCompra unDocumentoDeCompra : documentosDeCompras) {
/*  72 */       if (unDocumentoDeCompra instanceof org.solidstate.facturen.entities.NotaDeCredito) {
/*  73 */         if (unDocumentoDeCompra.getGravadoGastos() != null) {
/*  74 */           unDocumentoDeCompra.setGravadoGastos(unDocumentoDeCompra.getGravadoGastos().negate());
/*     */         }
/*  76 */         if (unDocumentoDeCompra.getIva21() != null) {
/*  77 */           unDocumentoDeCompra.setIva21(unDocumentoDeCompra.getIva21().negate());
/*     */         }
/*  79 */         if (unDocumentoDeCompra.getMontoImponible() != null) {
/*  80 */           unDocumentoDeCompra.setMontoImponible(unDocumentoDeCompra.getMontoImponible().negate());
/*     */         }
/*  82 */         if (unDocumentoDeCompra.getPercepcion993() != null) {
/*  83 */           unDocumentoDeCompra.setPercepcion993(unDocumentoDeCompra.getPercepcion993().negate());
/*     */         }
/*  85 */         if (unDocumentoDeCompra.getPercepcionDGR() != null) {
/*  86 */           unDocumentoDeCompra.setPercepcionDGR(unDocumentoDeCompra.getPercepcionDGR().negate());
/*     */         }
/*  88 */         if (unDocumentoDeCompra.getTotalFactura() != null) {
/*  89 */           unDocumentoDeCompra.setTotalFactura(unDocumentoDeCompra.getTotalFactura().negate());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void invertirMontosNCVenta(List<DocumentoDeVenta> documentos) {
/*  96 */     for (DocumentoDeVenta unDocumentoDeVenta : documentos) {
/*  97 */       if (unDocumentoDeVenta instanceof org.solidstate.facturen.entities.NotaDeCreditoVenta) {
/*  98 */         unDocumentoDeVenta.invertirMontos();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static JasperPrint getLibroIvaVentas() {
/* 106 */     List<DocumentoDeVenta> filasReporte = BusinessDelegator.getInstance().getFacturaVentaAll();
/* 107 */     invertirMontosNCVenta(filasReporte);
/* 108 */     JasperPrint impresion = null;
/* 109 */     Map<Object, Object> parametros = new HashMap<Object, Object>();
/* 110 */     String periodo = DateUtils.getPeriodoLargo(BusinessDelegator.getInstance().getPeriodoImpresion());
/* 111 */     parametros.put("periodo", periodo);
/*     */     try {
/* 113 */       InputStream is = getReportInputStream("FacturasVenta");
/* 114 */       JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(filasReporte);
/* 115 */       impresion = JasperFillManager.fillReport(is, parametros, (JRDataSource)ds);
/* 116 */     } catch (JRException ex) {
/* 117 */       ex.printStackTrace();
/*     */     } 
/* 119 */     return impresion;
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/reporting/Reporte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */