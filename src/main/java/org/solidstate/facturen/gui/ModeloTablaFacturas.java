/*    */ package org.solidstate.facturen.gui;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.swing.table.AbstractTableModel;
/*    */ import org.solidstate.facturen.entities.DocumentoDeCompra;
/*    */ import org.solidstate.facturen.entities.Factura;
/*    */ import org.solidstate.utils.DateUtils;
/*    */ 
/*    */ public class ModeloTablaFacturas
/*    */   extends AbstractTableModel
/*    */ {
/*    */   private List<DocumentoDeCompra> facturas;
/* 13 */   private String[] columnNames = new String[] { "Tipo", "Periodo", "Fecha", "Numero", "Importe" };
/*    */   
/*    */   public int getRowCount() {
/* 16 */     if (this.facturas == null) {
/* 17 */       return 0;
/*    */     }
/* 19 */     return this.facturas.size();
/*    */   }
/*    */   
/*    */   public int getColumnCount() {
/* 23 */     return this.columnNames.length;
/*    */   }
/*    */   
/*    */   public String getColumnName(int col) {
/* 27 */     return this.columnNames[col];
/*    */   }
/*    */   
/*    */   public Object getValueAt(int rowIndex, int columnIndex) {
/* 31 */     Factura unaFactura = (Factura)this.facturas.get(rowIndex);
/* 32 */     switch (columnIndex) {
/*    */       case 0:
/* 34 */         if (unaFactura instanceof org.solidstate.facturen.entities.NotaDeCredito) {
/* 35 */           return "NC";
/*    */         }
/* 37 */         if (unaFactura instanceof org.solidstate.facturen.entities.FacturaCompra) {
/* 38 */           return "FC";
/*    */         }
/* 40 */         if (unaFactura instanceof org.solidstate.facturen.entities.FacturaVenta) {
/* 41 */           return "FV";
/*    */         }
/* 43 */         if (unaFactura instanceof org.solidstate.facturen.entities.NotaDeCreditoVenta) {
/* 44 */           return "NCV";
/*    */         }
/* 46 */         return "PER";
/*    */       case 1:
/* 48 */         return unaFactura.getPeriodoFiscal();
/*    */       case 2:
/* 50 */         return DateUtils.getFormatoCorto(unaFactura.getFechaFactura());
/*    */       case 3:
/* 52 */         return unaFactura.getNumeroFactura();
/*    */       case 4:
/* 54 */         return unaFactura.getTotalFactura();
/*    */     } 
/* 56 */     return null;
/*    */   }
/*    */   
/*    */   public void setFacturas(List<DocumentoDeCompra> facturas) {
/* 60 */     this.facturas = facturas;
/* 61 */     fireTableDataChanged();
/*    */   }
/*    */   
/*    */   public Factura getFactura(int fila) {
/* 65 */     return (Factura)this.facturas.get(fila);
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/ModeloTablaFacturas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */