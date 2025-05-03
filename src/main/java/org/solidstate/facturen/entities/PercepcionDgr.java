/*    */ package org.solidstate.facturen.entities;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ public class PercepcionDgr
/*    */   extends DocumentoDeCompra
/*    */ {
/*    */   public PercepcionDgr() {}
/*    */   
/*    */   public PercepcionDgr(Date fechaFactura, String numeroFactura, Persona persona, BigDecimal percepcionDGR, String periodoFiscal) {
/* 17 */     super(null, fechaFactura, null, numeroFactura, persona, null, null, null, percepcionDGR, null, null, null, periodoFiscal);
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/entities/PercepcionDgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */