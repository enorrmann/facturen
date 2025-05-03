/*     */ package org.solidstate.facturen.gui;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JDesktopPane;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JInternalFrame;
/*     */ import javax.swing.JLayeredPane;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import net.sf.jasperreports.engine.JasperPrint;
/*     */ import org.solidstate.facturen.core.BusinessDelegator;
/*     */ import org.solidstate.facturen.entities.DocumentoDeCompra;
/*     */ import org.solidstate.facturen.entities.DocumentoDeVenta;
/*     */ import org.solidstate.facturen.entities.PercepcionDgr;
/*     */ import org.solidstate.facturen.entities.Persona;
/*     */ import org.solidstate.facturen.reporting.Reporte;
/*     */ 
/*     */ public class JfPrincipal
/*     */   extends JFrame {
/*  24 */   private final JDPersonas jdPersonas = new JDPersonas(this, true);
/*     */   
/*     */   private static JfPrincipal jfPrincipal;
/*     */   
/*  28 */   private JDPeriodoImpresion jdPeriodoImpresion = new JDPeriodoImpresion(this, true);
/*  29 */   private JMenuItem jmiFacturasDeVenta = new JMenuItem("Facturas de Venta");
/*     */   
/*     */   private JDesktopPane desktopPane;
/*     */   
/*     */   private JMenuBar jMenuBar1;
/*     */   
/*     */   private JMenuItem jMenuItem1;
/*     */   
/*     */   private JMenuItem jMenuItem2;
/*     */   
/*     */   private JMenuItem jMenuItem3;
/*     */   
/*     */   private JMenuItem jMenuItem4;
/*     */   
/*     */   private JMenuItem jMenuItem5;
/*     */   
/*     */   private JMenuItem jmiIvaVentas;
/*     */   
/*     */   private JMenuItem jMenuItem6;
/*     */   
/*     */   private JMenuItem jMenuItem7;
/*     */   
/*     */   private JMenu menuAdministracion;
/*     */   
/*     */   private JMenu menuMovimientos;
/*     */   private JMenu menuReportes;
/*     */   
/*     */   public JfPrincipal() {
/*  57 */     if (jfPrincipal == null) {
/*  58 */       jfPrincipal = this;
/*     */     }
/*  60 */     initComponents();
/*     */   }
/*     */   
/*     */   private void initComponents() {
/*  64 */     this.desktopPane = new JDesktopPane();
/*  65 */     this.jMenuBar1 = new JMenuBar();
/*  66 */     this.menuMovimientos = new JMenu();
/*  67 */     this.jMenuItem4 = new JMenuItem();
/*  68 */     this.jMenuItem7 = new JMenuItem();
/*  69 */     this.menuReportes = new JMenu();
/*  70 */     this.jMenuItem5 = new JMenuItem();
/*  71 */     this.jmiIvaVentas = new JMenuItem();
/*  72 */     this.jMenuItem6 = new JMenuItem();
/*  73 */     this.menuAdministracion = new JMenu();
/*  74 */     this.jMenuItem1 = new JMenuItem();
/*  75 */     this.jMenuItem2 = new JMenuItem();
/*  76 */     this.jMenuItem3 = new JMenuItem();
/*  77 */     setDefaultCloseOperation(3);
/*  78 */     setTitle("IVA compras, etc..");
/*  79 */     this.menuMovimientos.setText("Movimientos");
/*     */     
/*  81 */     this.jMenuItem4.setText("Facturas de Compra");
/*  82 */     this.jMenuItem4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  84 */             JfPrincipal.this.jMenuItem4ActionPerformed(evt);
/*     */           }
/*     */         });
/*  87 */     this.menuMovimientos.add(this.jMenuItem4);
/*  88 */     this.menuMovimientos.add(this.jmiFacturasDeVenta);
/*  89 */     this.jmiFacturasDeVenta.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  92 */             JfPrincipal.this.jmiFacturasDeVentaActionPerformed(evt);
/*     */           }
/*     */         });
/*  95 */     this.jMenuItem7.setText("Percepciones");
/*  96 */     this.jMenuItem7.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  98 */             JfPrincipal.this.jMenuItem7ActionPerformed(evt);
/*     */           }
/*     */         });
/* 101 */     this.menuMovimientos.add(this.jMenuItem7);
/* 102 */     this.jMenuBar1.add(this.menuMovimientos);
/* 103 */     this.menuReportes.setText("Reportes");
/* 104 */     this.jMenuItem5.setText("Libro Iva Compras");
/* 105 */     this.jmiIvaVentas.setText("Libro Iva Ventas");
/*     */     
/* 107 */     this.jMenuItem5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 109 */             JfPrincipal.this.jMenuItem5ActionPerformed(evt);
/*     */           }
/*     */         });
/* 112 */     this.jmiIvaVentas.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 114 */             JfPrincipal.this.jmiIvaVentasActionPerformed(evt);
/*     */           }
/*     */         });
/* 117 */     this.menuReportes.add(this.jMenuItem5);
/* 118 */     this.menuReportes.add(this.jmiIvaVentas);
/* 119 */     this.jMenuItem6.setText("Resumen D.G.R.");
/* 120 */     this.jMenuItem6.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 122 */             JfPrincipal.this.jMenuItem6ActionPerformed(evt);
/*     */           }
/*     */         });
/* 125 */     this.menuReportes.add(this.jMenuItem6);
/* 126 */     this.jMenuBar1.add(this.menuReportes);
/* 127 */     this.menuAdministracion.setText("Administracion");
/* 128 */     this.jMenuItem1.setText("Proveedores");
/* 129 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 131 */             JfPrincipal.this.jMenuItem1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 134 */     this.menuAdministracion.add(this.jMenuItem1);
/* 135 */     this.jMenuItem2.setText("Seleccionar Factura");
/* 136 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 138 */             JfPrincipal.this.jMenuItem2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 141 */     this.menuAdministracion.add(this.jMenuItem2);
/* 142 */     this.jMenuItem3.setText("Seleccionar Periodo");
/* 143 */     this.jMenuItem3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 145 */             JfPrincipal.this.jMenuItem3ActionPerformed(evt);
/*     */           }
/*     */         });
/* 148 */     this.menuAdministracion.add(this.jMenuItem3);
/* 149 */     this.jMenuBar1.add(this.menuAdministracion);
/* 150 */     setJMenuBar(this.jMenuBar1);
/* 151 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 152 */     getContentPane().setLayout(layout);
/* 153 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.desktopPane, -1, 400, 32767));
/* 154 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.desktopPane, -1, 275, 32767));
/* 155 */     pack();
/*     */   }
/*     */   
/*     */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/* 159 */     showJif(new JifPersonas());
/*     */   }
/*     */   
/*     */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/* 163 */     showJif(new JifFacturaSearch());
/*     */   }
/*     */   
/*     */   private void jMenuItem3ActionPerformed(ActionEvent evt) {
/* 167 */     showJif(new JifSetPeriodoActual());
/*     */   }
/*     */   
/*     */   private void jMenuItem4ActionPerformed(ActionEvent evt) {
/* 171 */     showJif(new JifFacturaCompra());
/*     */   }
/*     */   
/*     */   private void jMenuItem5ActionPerformed(ActionEvent evt) {
/* 175 */     showDialogoPeriodoImpresion(this);
/* 176 */     showJifVistaImpresion(Reporte.getLibroIvaCompras());
/*     */   }
/*     */   
/*     */   private void jMenuItem6ActionPerformed(ActionEvent evt) {
/* 180 */     showDialogoPeriodoImpresion(this);
/* 181 */     showJifVistaImpresion(Reporte.getResumenDgr());
/*     */   }
/*     */   
/*     */   private void jMenuItem7ActionPerformed(ActionEvent evt) {
/* 185 */     showJif(new JifPercepcion());
/*     */   }
/*     */   
/*     */   public void showJifVistaImpresion(JasperPrint reporte) {
/* 189 */     showJif(new JifVistaImpresion(reporte));
/*     */   }
/*     */   
/*     */   public void showJif(JInternalFrame jInternalFrame) {
/* 193 */     jInternalFrame.setVisible(true);
/* 194 */     this.desktopPane.add(jInternalFrame, JLayeredPane.DEFAULT_LAYER);
/*     */   }
/*     */   
/*     */   public static JfPrincipal getInstance() {
/* 198 */     return jfPrincipal;
/*     */   }
/*     */   
/*     */   public Persona showDialogoPersonas(Component parent, Long tipoPersona) {
/* 202 */     this.jdPersonas.setLocationRelativeTo(parent);
/* 203 */     this.jdPersonas.setVisible(true, tipoPersona);
/* 204 */     return this.jdPersonas.getPersona();
/*     */   }
/*     */   
/*     */   public void showDialogoPeriodoImpresion(Component parent) {
/* 208 */     this.jdPeriodoImpresion.setLocationRelativeTo(parent);
/* 209 */     this.jdPeriodoImpresion.setVisible(true);
/* 210 */     BusinessDelegator.getInstance().setPeriodoImpresion(this.jdPeriodoImpresion.getPeriodoImpresion());
/*     */   }
/*     */   
/*     */   private void jmiFacturasDeVentaActionPerformed(ActionEvent evt) {
/* 214 */     showJif(new JifFacturaVenta());
/*     */   }
/*     */   
/*     */   public void showJifFacturaCompra(DocumentoDeCompra documentoDeCompra) {
/* 218 */     if (documentoDeCompra == null) {
/*     */       return;
/*     */     }
/* 221 */     if (documentoDeCompra instanceof org.solidstate.facturen.entities.FacturaCompra) {
/* 222 */       JifFacturaCompra jifFacturaCompra = new JifFacturaCompra();
/* 223 */       jifFacturaCompra.setFacturaCompra(documentoDeCompra);
/* 224 */       showJif(jifFacturaCompra);
/* 225 */     } else if (documentoDeCompra instanceof PercepcionDgr) {
/* 226 */       JifPercepcion jifPercepcion = new JifPercepcion();
/* 227 */       jifPercepcion.setPercepcionDgr((PercepcionDgr)documentoDeCompra);
/* 228 */       showJif(jifPercepcion);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void showJifFacturaVenta(DocumentoDeVenta documento) {
/* 233 */     if (documento == null) {
/*     */       return;
/*     */     }
/* 236 */     JifFacturaVenta jif = new JifFacturaVenta();
/* 237 */     jif.setFactura(documento);
/* 238 */     showJif(jif);
/*     */   }
/*     */   
/*     */   private void jmiIvaVentasActionPerformed(ActionEvent evt) {
/* 242 */     showDialogoPeriodoImpresion(this);
/* 243 */     showJifVistaImpresion(Reporte.getLibroIvaVentas());
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JfPrincipal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */