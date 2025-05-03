/*    */ package org.solidstate.facturen.entities;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ public class NotaDeCredito
/*    */   extends DocumentoDeCompra
/*    */ {
/*    */   public NotaDeCredito() {}
/*    */   
/*    */   public NotaDeCredito(FormaDePago formaDePago, Date fechaFactura, String letraFactura, String numeroFactura, Persona persona, BigDecimal montoImponible, BigDecimal iva21, BigDecimal totaFactura, BigDecimal percepcionDGR, BigDecimal gravadoGastos, BigDecimal percepcion993, String observaciones, String periodoFiscal) {
/* 18 */     super(formaDePago, fechaFactura, letraFactura, numeroFactura, persona, montoImponible, iva21, totaFactura, percepcionDGR, gravadoGastos, percepcion993, observaciones, periodoFiscal);
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/entities/NotaDeCredito.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */