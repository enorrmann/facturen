/*     */ package org.solidstate.facturen.entities;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import org.solidstate.facturen.utils.IvaUtil;
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
/*     */ @Entity
/*     */ @NamedQueries({@NamedQuery(name = "getDocumentoDeVentaAll", query = "SELECT c FROM DocumentoDeVenta c WHERE c.periodoFiscal = :periodoFiscal AND c.totalFactura > 0 ORDER BY c.fechaFactura,c.numeroFactura , c.persona.razonSocial")})
/*     */ public class DocumentoDeVenta
/*     */   extends Factura
/*     */ {
/*     */   private Long situacionImpositiva;
/*     */   private String situacionImpositivaString;
/*     */   private Long concepto;
/*     */   @Column(precision = 12, scale = 2)
/*     */   private BigDecimal alicuotaDGR;
/*     */   @Column(precision = 12, scale = 2)
/*     */   private BigDecimal alicuotaTasaHigiene;
/*     */   @Column(precision = 12, scale = 2)
/*     */   private BigDecimal montoAlicuotaDGR;
/*     */   @Column(precision = 12, scale = 2)
/*     */   private BigDecimal montoAlicuotaTasaHigiene;
/*     */   
/*     */   public void setFechaFactura(Date fechaFactura) {
/*  38 */     super.setFechaFactura(fechaFactura);
/*  39 */     setPeriodoFiscal(DateUtils.getPeriodoFromFecha(fechaFactura));
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getSituacionImpositiva() {
/*  44 */     return this.situacionImpositiva;
/*     */   }
/*     */   
/*     */   public void setSituacionImpositiva(Long situacionImpositiva) {
/*  48 */     this.situacionImpositiva = situacionImpositiva;
/*  49 */     setSituacionImpositivaString(IvaUtil.getSIString(situacionImpositiva));
/*     */   }
/*     */   
/*     */   public BigDecimal getMontoAlicuotaDGR() {
/*  53 */     return this.montoAlicuotaDGR;
/*     */   }
/*     */   
/*     */   public void setMontoAlicuotaDGR(BigDecimal alicuotaDGR) {
/*  57 */     this.montoAlicuotaDGR = alicuotaDGR;
/*     */   }
/*     */   
/*     */   public BigDecimal getMontoAlicuotaTasaHigiene() {
/*  61 */     return this.montoAlicuotaTasaHigiene;
/*     */   }
/*     */   
/*     */   public void setMontoAlicuotaTasaHigiene(BigDecimal alicuotaTasaHigiene) {
/*  65 */     this.montoAlicuotaTasaHigiene = alicuotaTasaHigiene;
/*     */   }
/*     */   
/*     */   public Long getConcepto() {
/*  69 */     return this.concepto;
/*     */   }
/*     */   
/*     */   public void setConcepto(Long concepto) {
/*  73 */     this.concepto = concepto;
/*     */   }
/*     */   
/*     */   public BigDecimal getAlicuotaDGR() {
/*  77 */     return this.alicuotaDGR;
/*     */   }
/*     */   
/*     */   public void setAlicuotaDGR(BigDecimal alicuotaDGR) {
/*  81 */     this.alicuotaDGR = alicuotaDGR;
/*     */   }
/*     */   
/*     */   public BigDecimal getAlicuotaTasaHigiene() {
/*  85 */     return this.alicuotaTasaHigiene;
/*     */   }
/*     */   
/*     */   public void setAlicuotaTasaHigiene(BigDecimal alicuotaTasaHigiene) {
/*  89 */     this.alicuotaTasaHigiene = alicuotaTasaHigiene;
/*     */   }
/*     */   
/*     */   public String getSituacionImpositivaString() {
/*  93 */     return this.situacionImpositivaString;
/*     */   }
/*     */   
/*     */   public void setSituacionImpositivaString(String situacionImpositivaString) {
/*  97 */     this.situacionImpositivaString = situacionImpositivaString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void invertirMontos() {
/* 103 */     if (this.alicuotaDGR != null) {
/* 104 */       this.alicuotaDGR = this.alicuotaDGR.negate();
/*     */     }
/*     */     
/* 107 */     if (this.alicuotaTasaHigiene != null) {
/* 108 */       this.alicuotaTasaHigiene = this.alicuotaTasaHigiene.negate();
/*     */     }
/*     */     
/* 111 */     if (this.montoAlicuotaDGR != null) {
/* 112 */       this.montoAlicuotaDGR = this.montoAlicuotaDGR.negate();
/*     */     }
/*     */     
/* 115 */     if (this.montoAlicuotaTasaHigiene != null) {
/* 116 */       this.montoAlicuotaTasaHigiene = this.montoAlicuotaTasaHigiene.negate();
/*     */     }
/* 118 */     super.invertirMontos();
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/entities/DocumentoDeVenta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */