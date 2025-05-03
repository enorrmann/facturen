/*    */ package org.solidstate.facturen.entities;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.NamedQueries;
/*    */ import javax.persistence.NamedQuery;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @NamedQueries({@NamedQuery(name = "getDocumentoDeCompraAll", query = "SELECT c FROM DocumentoDeCompra c WHERE c.periodoFiscal = :periodoFiscal AND c.totalFactura > 0 ORDER BY c.fechaFactura , c.persona.razonSocial"), @NamedQuery(name = "getDocumentoDeCompraPercepcionDGR", query = "SELECT c FROM DocumentoDeCompra c WHERE c.periodoFiscal = :periodoFiscal AND c.percepcionDGR > 0 ORDER BY c.persona.razonSocial, c.fechaFactura"), @NamedQuery(name = "getDocumentoDeCompraByPersona", query = "SELECT f FROM DocumentoDeCompra f where f.persona = :persona ORDER BY f.periodoFiscal, f.fechaFactura")})
/*    */ public class DocumentoDeCompra
/*    */   extends Factura
/*    */ {
/*    */   @Column(precision = 12, scale = 2)
/*    */   private BigDecimal percepcionDGR;
/*    */   @Column(precision = 12, scale = 2)
/*    */   private BigDecimal gravadoGastos;
/*    */   @Column(precision = 12, scale = 2)
/*    */   private BigDecimal percepcion993;
/*    */   private String observaciones;
/*    */   
/*    */   public DocumentoDeCompra() {}
/*    */   
/*    */   public DocumentoDeCompra(FormaDePago formaDePago, Date fechaFactura, String letraFactura, String numeroFactura, Persona persona, BigDecimal montoImponible, BigDecimal iva21, BigDecimal totaFactura, BigDecimal percepcionDGR, BigDecimal gravadoGastos, BigDecimal percepcion993, String observaciones, String periodoFiscal) {
/* 35 */     super(formaDePago, fechaFactura, letraFactura, numeroFactura, persona, montoImponible, iva21, totaFactura, periodoFiscal);
/*    */     
/* 37 */     this.percepcionDGR = percepcionDGR;
/* 38 */     this.gravadoGastos = gravadoGastos;
/* 39 */     this.percepcion993 = percepcion993;
/* 40 */     this.observaciones = observaciones;
/*    */   }
/*    */ 
/*    */   
/*    */   public BigDecimal getGravadoGastos() {
/* 45 */     return this.gravadoGastos;
/*    */   }
/*    */   
/*    */   public void setGravadoGastos(BigDecimal gravadoGastos) {
/* 49 */     this.gravadoGastos = gravadoGastos;
/*    */   }
/*    */   
/*    */   public String getObservaciones() {
/* 53 */     return this.observaciones;
/*    */   }
/*    */   
/*    */   public void setObservaciones(String observaciones) {
/* 57 */     this.observaciones = observaciones;
/*    */   }
/*    */   
/*    */   public BigDecimal getPercepcion993() {
/* 61 */     return this.percepcion993;
/*    */   }
/*    */   
/*    */   public void setPercepcion993(BigDecimal percepcion993) {
/* 65 */     this.percepcion993 = percepcion993;
/*    */   }
/*    */   
/*    */   public BigDecimal getPercepcionDGR() {
/* 69 */     return this.percepcionDGR;
/*    */   }
/*    */   
/*    */   public void setPercepcionDGR(BigDecimal percepcionDGR) {
/* 73 */     this.percepcionDGR = percepcionDGR;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/entities/DocumentoDeCompra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */