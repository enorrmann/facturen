/*    */ package org.solidstate.facturen.entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.NamedQueries;
/*    */ import javax.persistence.NamedQuery;
/*    */ import org.solidstate.utils.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @NamedQueries({@NamedQuery(name = "getPersonasAll", query = "SELECT p FROM Persona p ORDER BY p.razonSocial"), @NamedQuery(name = "findPersonaByCuit", query = "SELECT p FROM Persona p where p.cuit = :cuit"), @NamedQuery(name = "getPersonasByTipo", query = "SELECT p FROM Persona p where p.tipoPersona = :tipoPersona")})
/*    */ public class Persona
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   public static final Long PROVEEDOR = Long.valueOf(1L);
/* 23 */   public static final Long CLIENTE = Long.valueOf(2L);
/*    */   
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.AUTO)
/*    */   private Long id;
/*    */   private Long tipoPersona;
/*    */   private String razonSocial;
/*    */   private String cuit;
/*    */   private SituacionImpositiva situacionImpositivaUsual;
/*    */   private String telefono;
/*    */   private String telefonoViajante;
/*    */   
/*    */   public String getCuit() {
/* 36 */     return this.cuit;
/*    */   }
/*    */   
/*    */   public void setCuit(String cuit) {
/* 40 */     this.cuit = cuit;
/*    */   }
/*    */   
/*    */   public String getRazonSocial() {
/* 44 */     return this.razonSocial;
/*    */   }
/*    */   
/*    */   public void setRazonSocial(String razonSocial) {
/* 48 */     this.razonSocial = razonSocial.toUpperCase();
/*    */   }
/*    */   
/*    */   public SituacionImpositiva getSituacionImpositivaUsual() {
/* 52 */     return this.situacionImpositivaUsual;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setSituacionImpositivaUsual(SituacionImpositiva situacionImpositivaUsual) {
/* 57 */     this.situacionImpositivaUsual = situacionImpositivaUsual;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 61 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 65 */     this.id = id;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 70 */     return StringUtils.paddingString(this.id+"", 
/* 71 */         5, ' ', true) + " - " + this.razonSocial;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTelefono() {
/* 76 */     return this.telefono;
/*    */   }
/*    */   
/*    */   public void setTelefono(String telefono) {
/* 80 */     this.telefono = telefono;
/*    */   }
/*    */   
/*    */   public String getTelefonoViajante() {
/* 84 */     return this.telefonoViajante;
/*    */   }
/*    */   
/*    */   public void setTelefonoViajante(String telefonoViajante) {
/* 88 */     this.telefonoViajante = telefonoViajante;
/*    */   }
/*    */   
/*    */   public Long getTipoPersona() {
/* 92 */     return this.tipoPersona;
/*    */   }
/*    */   
/*    */   public void setTipoPersona(Long tipoPersona) {
/* 96 */     this.tipoPersona = tipoPersona;
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/entities/Persona.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */