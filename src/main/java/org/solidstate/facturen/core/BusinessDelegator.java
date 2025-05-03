/*     */ package org.solidstate.facturen.core;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.EntityManagerFactory;
/*     */ import javax.persistence.Persistence;
/*     */ import javax.persistence.Query;
/*     */ import org.solidstate.facturen.entities.DocumentoDeCompra;
/*     */ import org.solidstate.facturen.entities.DocumentoDeVenta;
/*     */ import org.solidstate.facturen.entities.Factura;
/*     */ import org.solidstate.facturen.entities.Persona;
/*     */ import org.solidstate.utils.DateUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BusinessDelegator
/*     */ {
/*     */   private static EntityManagerFactory entityManagerFactory;
/*  19 */   private static BusinessDelegator businessDelegator = null;
/*     */   private static EntityManager entityManager;
/*     */   private String statusMessage;
/*     */   private String periodoActivo;
/*     */   private String periodoImpresion;
/*     */   
/*     */   private BusinessDelegator() {
/*  26 */     entityManagerFactory = Persistence.createEntityManagerFactory("FacturenPU");
/*  27 */     entityManager = entityManagerFactory.createEntityManager();
/*  28 */     this.periodoActivo = DateUtils.getPeriodoFromFechaActual();
/*     */   }
/*     */   
/*     */   public static BusinessDelegator getInstance() {
/*  32 */     if (businessDelegator == null) {
/*  33 */       businessDelegator = new BusinessDelegator();
/*     */     }
/*  35 */     return businessDelegator;
/*     */   }
/*     */   
/*     */   public void borrarFactura(Factura unaFactura) {
/*  39 */     entityManager.getTransaction().begin();
/*  40 */     entityManager.remove(entityManager.merge(unaFactura));
/*  41 */     entityManager.getTransaction().commit();
/*     */   }
/*     */   
/*     */   public List<DocumentoDeCompra> getFacturaCompraAll() {
/*  45 */     Query query = entityManager.createNamedQuery("getDocumentoDeCompraAll");
/*  46 */     query.setParameter("periodoFiscal", this.periodoImpresion);
/*  47 */     List<DocumentoDeCompra> lista = query.getResultList();
/*  48 */     entityManager.clear();
/*  49 */     return lista;
/*     */   }
/*     */   
/*     */   public List<DocumentoDeCompra> getFacturaPercepcionDGR() {
/*  53 */     Query query = entityManager.createNamedQuery("getDocumentoDeCompraPercepcionDGR");
/*  54 */     query.setParameter("periodoFiscal", this.periodoImpresion);
/*  55 */     List<DocumentoDeCompra> lista = query.getResultList();
/*  56 */     entityManager.clear();
/*  57 */     return lista;
/*     */   }
/*     */   
/*     */   public DocumentoDeCompra mergeDocumentoDeCompra(DocumentoDeCompra documentoDeCompra) throws Exception {
/*  61 */     entityManager.getTransaction().begin();
/*  62 */     DocumentoDeCompra dc = (DocumentoDeCompra)entityManager.merge(documentoDeCompra);
/*  63 */     entityManager.getTransaction().commit();
/*  64 */     return dc;
/*     */   }
/*     */   
/*     */   public List<Persona> getPersonasAll() {
/*  68 */     Query query = entityManager.createNamedQuery("getPersonasAll");
/*  69 */     return query.getResultList();
/*     */   }
/*     */   
/*     */   public Persona findPersonaById(Long idPersona) {
/*  73 */     return (Persona)entityManager.find(Persona.class, idPersona);
/*     */   }
/*     */   
/*     */   public boolean isCuitAsignado() {
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   public String getStatusMessage() {
/*  81 */     return this.statusMessage;
/*     */   }
/*     */   
/*     */   public void setStatusMessage(String statusMessage) {
/*  85 */     this.statusMessage = statusMessage;
/*     */   }
/*     */   
/*     */   public boolean registrarPersona(Persona unaPersona) {
/*     */     try {
/*  90 */       entityManager.getTransaction().begin();
/*  91 */       entityManager.merge(unaPersona);
/*  92 */       entityManager.getTransaction().commit();
/*  93 */     } catch (Exception e) {
/*  94 */       return false;
/*     */     } 
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   public List<DocumentoDeCompra> getDocumentoDeCompraByPersona(Persona unaPersona) {
/* 100 */     Query query = entityManager.createNamedQuery("getDocumentoDeCompraByPersona");
/* 101 */     query.setParameter("persona", unaPersona);
/* 102 */     return query.getResultList();
/*     */   }
/*     */   
/*     */   public List<DocumentoDeCompra> getFacturasByPersona(Persona unaPersona) {
/* 106 */     Query query = entityManager.createNamedQuery("getFacturasByPersona");
/* 107 */     query.setParameter("persona", unaPersona);
/* 108 */     return query.getResultList();
/*     */   }
/*     */   
/*     */   public String getPeriodoActivo() {
/* 112 */     if (this.periodoActivo == null || this.periodoActivo.length() != 6) {
/* 113 */       this.periodoActivo = DateUtils.getPeriodoFromFechaActual();
/*     */     }
/* 115 */     return this.periodoActivo;
/*     */   }
/*     */   
/*     */   public void setPeriodoActivo(String periodoActivo) {
/* 119 */     this.periodoActivo = periodoActivo;
/*     */   }
/*     */   
/*     */   public String getPeriodoImpresion() {
/* 123 */     if (this.periodoImpresion == null || this.periodoImpresion
/* 124 */       .length() != 6) {
/* 125 */       this.periodoImpresion = DateUtils.getPeriodoFromFechaActual();
/*     */     }
/* 127 */     return this.periodoImpresion;
/*     */   }
/*     */   
/*     */   public void setPeriodoImpresion(String periodo) {
/* 131 */     this.periodoImpresion = periodo;
/*     */   }
/*     */   
/*     */   public Object getMergedObject(Object object) {
/* 135 */     return entityManager.merge(object);
/*     */   }
/*     */   
/*     */   public DocumentoDeVenta mergeDocumentoDeVenta(DocumentoDeVenta facturaSeleccionada) {
/* 139 */     entityManager.getTransaction().begin();
/* 140 */     DocumentoDeVenta dc = (DocumentoDeVenta)entityManager.merge(facturaSeleccionada);
/* 141 */     entityManager.getTransaction().commit();
/* 142 */     return dc;
/*     */   }
/*     */   
/*     */   public List<DocumentoDeVenta> getFacturaVentaAll() {
/* 146 */     Query query = entityManager.createNamedQuery("getDocumentoDeVentaAll");
/* 147 */     query.setParameter("periodoFiscal", this.periodoImpresion);
/* 148 */     List<DocumentoDeVenta> lista = query.getResultList();
/* 149 */     entityManager.clear();
/* 150 */     return lista;
/*     */   }
/*     */   
/*     */   public Persona findPersonaByCuit(String cuit) {
/* 154 */     Query query = entityManager.createNamedQuery("findPersonaByCuit");
/* 155 */     query.setParameter("cuit", cuit);
/* 156 */     List<Persona> lista = query.getResultList();
/* 157 */     return lista.isEmpty() ? null : lista.get(0);
/*     */   }
/*     */   
/*     */   public List<Persona> getPersonasByTipo(Long tipoPersona) {
/* 161 */     if (tipoPersona == null) {
/* 162 */       Query query1 = entityManager.createNamedQuery("getPersonasAll");
/* 163 */       return query1.getResultList();
/*     */     } 
/* 165 */     Query query = entityManager.createNamedQuery("getPersonasByTipo");
/* 166 */     query.setParameter("tipoPersona", tipoPersona);
/* 167 */     return query.getResultList();
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/core/BusinessDelegator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */