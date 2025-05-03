/*     */ package org.solidstate.facturen.entities;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import javax.persistence.CascadeType;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ @Entity
/*     */ @Table(name = "FACTURA")
/*     */ @NamedQuery(name = "getFacturasByPersona", query = "SELECT f FROM Factura f where f.persona = :persona ORDER BY f.fechaFactura")
/*     */ public class Factura
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.AUTO)
/*     */   private Long id;
/*     */   private FormaDePago formaDePago;
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date fechaFactura;
/*     */   private String letraFactura;
/*     */   private String numeroFactura;
/*     */   private String periodoFiscal;
/*     */   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
/*     */   private Persona persona;
/*     */   @Column(precision = 12, scale = 2)
/*     */   private BigDecimal montoImponible;
/*     */   @Column(precision = 12, scale = 2)
/*     */   private BigDecimal iva21;
/*     */   @Column(precision = 12, scale = 2)
/*     */   private BigDecimal totalFactura;
/*     */   
/*     */   public Factura() {}
/*     */   
/*     */   public Factura(FormaDePago formaDePago, Date fechaFactura, String letraFactura, String numeroFactura, Persona persona, BigDecimal montoImponible, BigDecimal iva21, BigDecimal totalFactura, String periodoFiscal) {
/*  52 */     this.formaDePago = formaDePago;
/*  53 */     this.fechaFactura = fechaFactura;
/*  54 */     this.letraFactura = letraFactura;
/*  55 */     this.numeroFactura = numeroFactura;
/*  56 */     this.persona = persona;
/*  57 */     this.montoImponible = montoImponible;
/*  58 */     this.iva21 = iva21;
/*  59 */     this.totalFactura = totalFactura;
/*  60 */     this.periodoFiscal = periodoFiscal;
/*     */   }
/*     */   
/*     */   public Date getFechaFactura() {
/*  64 */     return this.fechaFactura;
/*     */   }
/*     */   
/*     */   public void setFechaFactura(Date fechaFactura) {
/*  68 */     this.fechaFactura = fechaFactura;
/*     */   }
/*     */   
/*     */   public BigDecimal getIva21() {
/*  72 */     return this.iva21;
/*     */   }
/*     */   
/*     */   public void setIva21(BigDecimal iva21) {
/*  76 */     this.iva21 = iva21;
/*     */   }
/*     */   
/*     */   public String getLetraFactura() {
/*  80 */     return this.letraFactura;
/*     */   }
/*     */   
/*     */   public void setLetraFactura(String letraFactura) {
/*  84 */     this.letraFactura = letraFactura;
/*     */   }
/*     */   
/*     */   public BigDecimal getMontoImponible() {
/*  88 */     return this.montoImponible;
/*     */   }
/*     */   
/*     */   public void setMontoImponible(BigDecimal montoImponible) {
/*  92 */     this.montoImponible = montoImponible;
/*     */   }
/*     */   
/*     */   public Persona getPersona() {
/*  96 */     return this.persona;
/*     */   }
/*     */   
/*     */   public void setPersona(Persona persona) {
/* 100 */     this.persona = persona;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalFactura() {
/* 104 */     return this.totalFactura;
/*     */   }
/*     */   
/*     */   public void setTotalFactura(BigDecimal totaFactura) {
/* 108 */     this.totalFactura = totaFactura;
/*     */   }
/*     */   
/*     */   public FormaDePago getFormaDePago() {
/* 112 */     return this.formaDePago;
/*     */   }
/*     */   
/*     */   public void setFormaDePago(FormaDePago formaDePago) {
/* 116 */     this.formaDePago = formaDePago;
/*     */   }
/*     */   
/*     */   public String getNumeroFactura() {
/* 120 */     return this.numeroFactura;
/*     */   }
/*     */   
/*     */   public void setNumeroFactura(String numeroFactura) {
/* 124 */     this.numeroFactura = numeroFactura;
/*     */   }
/*     */   
/*     */   public Long getId() {
/* 128 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 132 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getPeriodoFiscal() {
/* 136 */     return this.periodoFiscal;
/*     */   }
/*     */   
/*     */   public void setPeriodoFiscal(String periodoFiscal) {
/* 140 */     this.periodoFiscal = periodoFiscal;
/*     */   }
/*     */   
/*     */   public void invertirMontos() {
/* 144 */     if (this.montoImponible != null) {
/* 145 */       this.montoImponible = this.montoImponible.negate();
/*     */     }
/*     */     
/* 148 */     if (this.iva21 != null) {
/* 149 */       this.iva21 = this.iva21.negate();
/*     */     }
/*     */     
/* 152 */     if (this.totalFactura != null)
/* 153 */       this.totalFactura = this.totalFactura.negate(); 
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/entities/Factura.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */