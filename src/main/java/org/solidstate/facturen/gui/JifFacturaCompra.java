/*     */ package org.solidstate.facturen.gui;
/*     */ 
/*     */ import java.awt.KeyboardFocusManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.ParseException;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.InputVerifier;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JInternalFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.text.DefaultFormatterFactory;
/*     */ import javax.swing.text.MaskFormatter;
/*     */ import org.solidstate.facturen.core.BusinessDelegator;
/*     */ import org.solidstate.facturen.entities.DocumentoDeCompra;
/*     */ import org.solidstate.facturen.entities.FacturaCompra;
/*     */ import org.solidstate.facturen.entities.NotaDeCredito;
/*     */ import org.solidstate.facturen.entities.Persona;
/*     */ import org.solidstate.facturen.gui.verifyers.DecimalVerifyer;
/*     */ import org.solidstate.facturen.gui.verifyers.FechaVerifyer;
/*     */ import org.solidstate.facturen.gui.verifyers.PeriodoVerifyer;
/*     */ import org.solidstate.facturen.gui.verifyers.TipoFacturaVerifyer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JifFacturaCompra
/*     */   extends JInternalFrame
/*     */ {
/*     */   private DocumentoDeCompra facturaCompraSeleccionada;
/*     */   private DecimalVerifyer decimalVerifyer;
/*     */   private PeriodoVerifyer periodoVerifyer;
/*     */   private FechaVerifyer fechaVerifyer;
/*     */   private TipoFacturaVerifyer tipoFacturaVerifyer;
/*     */   private ButtonGroup buttonGroup1;
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JPanel jPanel1;
/*     */   private JComboBox jcbTipoFactura;
/*     */   private JFormattedTextField jftfFecha;
/*     */   private JFormattedTextField jftfPeriodo;
/*     */   private JpPersona jpPersona1;
/*     */   private JTextField jtfGravadoGastos;
/*     */   private JTextField jtfImporte;
/*     */   private JTextField jtfIva;
/*     */   private JTextField jtfNumero;
/*     */   private JTextField jtfPercepcion993;
/*     */   private JTextField jtfPercepcionDgr;
/*     */   private JTextField jtfTipo;
/*     */   private JTextField jtfTotalFactura;
/*     */   
/*     */   public JifFacturaCompra() {
/* 105 */     this.decimalVerifyer = new DecimalVerifyer();
/* 106 */     this.periodoVerifyer = new PeriodoVerifyer();
/* 107 */     this.fechaVerifyer = new FechaVerifyer();
/* 108 */     this.tipoFacturaVerifyer = new TipoFacturaVerifyer();
/* 109 */     initComponents();
/* 110 */     this.jftfPeriodo.setText(BusinessDelegator.getInstance().getPeriodoActivo());
/* 111 */     this.jpPersona1.setTipoPersona(Persona.PROVEEDOR);
/*     */   }
/*     */   
/*     */   private void initComponents() {
/* 115 */     this.buttonGroup1 = new ButtonGroup();
/* 116 */     this.jLabel1 = new JLabel();
/* 117 */     this.jftfPeriodo = new JFormattedTextField();
/* 118 */     this.jpPersona1 = new JpPersona();
/* 119 */     this.jPanel1 = new JPanel();
/* 120 */     this.jLabel2 = new JLabel();
/* 121 */     this.jftfFecha = new JFormattedTextField();
/* 122 */     this.jLabel3 = new JLabel();
/* 123 */     this.jcbTipoFactura = new JComboBox();
/* 124 */     this.jLabel4 = new JLabel();
/* 125 */     this.jtfNumero = new JTextField();
/* 126 */     this.jLabel5 = new JLabel();
/* 127 */     this.jLabel6 = new JLabel();
/* 128 */     this.jLabel7 = new JLabel();
/* 129 */     this.jLabel8 = new JLabel();
/* 130 */     this.jLabel9 = new JLabel();
/* 131 */     this.jLabel10 = new JLabel();
/* 132 */     this.jtfImporte = new JTextField();
/* 133 */     this.jtfGravadoGastos = new JTextField();
/* 134 */     this.jtfIva = new JTextField();
/* 135 */     this.jtfPercepcion993 = new JTextField();
/* 136 */     this.jtfPercepcionDgr = new JTextField();
/* 137 */     this.jtfTotalFactura = new JTextField();
/* 138 */     this.jButton1 = new JButton();
/* 139 */     this.jLabel11 = new JLabel();
/* 140 */     this.jtfTipo = new JTextField();
/* 141 */     setClosable(true);
/* 142 */     setResizable(true);
/* 143 */     this.jLabel1.setText("Periodo");
/*     */     try {
/* 145 */       this.jftfPeriodo.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/####")));
/* 146 */     } catch (ParseException ex) {
/* 147 */       ex.printStackTrace();
/*     */     } 
/* 149 */     this.jftfPeriodo.setHorizontalAlignment(0);
/* 150 */     this.jftfPeriodo.setInputVerifier((InputVerifier)this.periodoVerifyer);
/* 151 */     this.jftfPeriodo.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 153 */             JifFacturaCompra.this.jftfPeriodoActionPerformed(evt);
/*     */           }
/*     */         });
/* 156 */     this.jftfPeriodo.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/* 158 */             JifFacturaCompra.this.jftfPeriodoKeyPressed(evt);
/*     */           }
/*     */         });
/* 161 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder("Factura"));
/* 162 */     this.jLabel2.setText("Fecha");
/*     */     try {
/* 164 */       this.jftfFecha.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
/* 165 */     } catch (ParseException ex) {
/* 166 */       ex.printStackTrace();
/*     */     } 
/* 168 */     this.jftfFecha.setHorizontalAlignment(0);
/* 169 */     this.jftfFecha.setInputVerifier((InputVerifier)this.fechaVerifyer);
/* 170 */     this.jftfFecha.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 172 */             JifFacturaCompra.this.jftfFechaActionPerformed(evt);
/*     */           }
/*     */         });
/* 175 */     this.jftfFecha.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/* 177 */             JifFacturaCompra.this.jftfFechaKeyPressed(evt);
/*     */           }
/*     */         });
/* 180 */     this.jLabel3.setText("Tipo");
/* 181 */     this.jcbTipoFactura.setModel(new DefaultComboBoxModel<String>(new String[] { "A", "B" }));
/* 182 */     this.jcbTipoFactura.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 184 */             JifFacturaCompra.this.jcbTipoFacturaActionPerformed(evt);
/*     */           }
/*     */         });
/* 187 */     this.jcbTipoFactura.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/* 189 */             JifFacturaCompra.this.jcbTipoFacturaKeyPressed(evt);
/*     */           }
/*     */         });
/* 192 */     this.jLabel4.setText("Numero");
/* 193 */     this.jtfNumero.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 195 */             JifFacturaCompra.this.jtfNumeroActionPerformed(evt);
/*     */           }
/*     */         });
/* 198 */     this.jLabel5.setText("COMPRAS Gravado");
/* 199 */     this.jLabel6.setText("GASTOS Gravado");
/* 200 */     this.jLabel7.setText("I.V.A");
/* 201 */     this.jLabel8.setText("Percepcion 9/93");
/* 202 */     this.jLabel9.setText("Percepcion D.G.R.");
/* 203 */     this.jLabel10.setText("TOTAL FACTURA");
/* 204 */     this.jtfImporte.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 205 */     this.jtfImporte.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 207 */             JifFacturaCompra.this.jtfImporteActionPerformed(evt);
/*     */           }
/*     */         });
/* 210 */     this.jtfGravadoGastos.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 211 */     this.jtfGravadoGastos.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 213 */             JifFacturaCompra.this.jtfGravadoGastosActionPerformed(evt);
/*     */           }
/*     */         });
/* 216 */     this.jtfIva.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 217 */     this.jtfIva.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 219 */             JifFacturaCompra.this.jtfIvaActionPerformed(evt);
/*     */           }
/*     */         });
/* 222 */     this.jtfPercepcion993.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 223 */     this.jtfPercepcion993.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 225 */             JifFacturaCompra.this.jtfPercepcion993ActionPerformed(evt);
/*     */           }
/*     */         });
/* 228 */     this.jtfPercepcionDgr.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 229 */     this.jtfPercepcionDgr.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 231 */             JifFacturaCompra.this.jtfPercepcionDgrActionPerformed(evt);
/*     */           }
/*     */         });
/* 234 */     this.jtfTotalFactura.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 235 */     this.jtfTotalFactura.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 237 */             JifFacturaCompra.this.jtfTotalFacturaActionPerformed(evt);
/*     */           }
/*     */         });
/* 240 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 241 */     this.jPanel1.setLayout(jPanel1Layout);
/* 242 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jftfFecha, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jcbTipoFactura, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfNumero, -1, 79, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jLabel7).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jtfGravadoGastos, -1, 254, 32767).addComponent(this.jtfImporte, -1, 254, 32767).addComponent(this.jtfIva, -1, 254, 32767).addComponent(this.jtfPercepcion993, -1, 254, 32767).addComponent(this.jtfPercepcionDgr, -1, 254, 32767).addComponent(this.jtfTotalFactura, -1, 254, 32767)))).addContainerGap()));
/* 243 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jftfFecha, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.jcbTipoFactura, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.jtfNumero, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jtfImporte, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jtfGravadoGastos, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jtfIva, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.jtfPercepcion993, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jtfPercepcionDgr, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.jtfTotalFactura, -2, -1, -2)).addContainerGap(-1, 32767)));
/* 244 */     this.jButton1.setText("Guardar");
/* 245 */     this.jButton1.setNextFocusableComponent(this.jpPersona1);
/* 246 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 248 */             JifFacturaCompra.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 251 */     this.jButton1.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/* 253 */             JifFacturaCompra.this.jButton1KeyPressed(evt);
/*     */           }
/*     */         });
/* 256 */     this.jLabel11.setText("1- Factura / 2- Nota de Credito");
/* 257 */     this.jtfTipo.setText("1");
/* 258 */     this.jtfTipo.setInputVerifier((InputVerifier)this.tipoFacturaVerifyer);
/* 259 */     this.jtfTipo.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 261 */             JifFacturaCompra.this.jtfTipoActionPerformed(evt);
/*     */           }
/*     */         });
/* 264 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 265 */     getContentPane().setLayout(layout);
/* 266 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jftfPeriodo, -2, 82, -2)).addComponent(this.jpPersona1, -1, 424, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfTipo, -2, 35, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 118, 32767).addComponent(this.jButton1))).addContainerGap()));
/* 267 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jftfPeriodo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpPersona1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jLabel11).addComponent(this.jtfTipo, -2, -1, -2)).addContainerGap(16, 32767)));
/* 268 */     pack();
/*     */   }
/*     */   
/*     */   private void jtfNumeroActionPerformed(ActionEvent evt) {
/* 272 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 276 */     saveFacturaCompra();
/* 277 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfImporteActionPerformed(ActionEvent evt) {
/* 281 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfGravadoGastosActionPerformed(ActionEvent evt) {
/* 285 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfIvaActionPerformed(ActionEvent evt) {
/* 289 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfPercepcion993ActionPerformed(ActionEvent evt) {
/* 293 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfPercepcionDgrActionPerformed(ActionEvent evt) {
/* 297 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfTotalFacturaActionPerformed(ActionEvent evt) {
/* 301 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jftfPeriodoActionPerformed(ActionEvent evt) {
/* 305 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jftfFechaActionPerformed(ActionEvent evt) {
/* 309 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jcbTipoFacturaActionPerformed(ActionEvent evt) {
/* 313 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfTipoActionPerformed(ActionEvent evt) {
/* 317 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jButton1KeyPressed(KeyEvent evt) {
/* 321 */     if (evt.getKeyCode() == 10) {
/* 322 */       saveFacturaCompra();
/* 323 */       focusNextfield();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jcbTipoFacturaKeyPressed(KeyEvent evt) {
/* 328 */     if (evt.getKeyCode() == 10) {
/* 329 */       focusNextfield();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jftfPeriodoKeyPressed(KeyEvent evt) {
/* 334 */     if (evt.getKeyCode() == 10) {
/* 335 */       focusNextfield();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jftfFechaKeyPressed(KeyEvent evt) {
/* 340 */     if (evt.getKeyCode() == 10) {
/* 341 */       focusNextfield();
/*     */     }
/*     */   }
/*     */   
/*     */   private void saveFacturaCompra() {
/*     */     try {
/* 347 */       this.jpPersona1.setCamposPersona(Persona.PROVEEDOR);
/* 348 */       setCamposFacturaCompra();
/* 349 */       if (this.jpPersona1.getPersona().getRazonSocial() == null || this.jpPersona1.getPersona().getRazonSocial().equals("") || this.facturaCompraSeleccionada.getNumeroFactura() == null || this.facturaCompraSeleccionada.getNumeroFactura().equals("")) {
/* 350 */         JOptionPane.showMessageDialog(this, "Falta completar algun dato importante", "Error", 0);
/*     */         return;
/*     */       } 
/* 353 */       BusinessDelegator.getInstance().mergeDocumentoDeCompra(this.facturaCompraSeleccionada);
/* 354 */       nuevaFacturaCompra();
/* 355 */     } catch (Exception ex) {
/* 356 */       Logger.getLogger(JifFacturaCompra.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 357 */       JOptionPane.showMessageDialog(this, "Ha ocurrido un error al guardar la factura", "Error", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setCamposFacturaCompra() {
/* 362 */     if (this.facturaCompraSeleccionada == null) {
/* 363 */       if (this.jtfTipo.getText().equals("2")) {
/* 364 */         this.facturaCompraSeleccionada = (DocumentoDeCompra)new NotaDeCredito();
/*     */       } else {
/* 366 */         this.facturaCompraSeleccionada = (DocumentoDeCompra)new FacturaCompra();
/*     */       } 
/*     */     }
/* 369 */     Date fechaFactura = null;
/*     */     try {
/* 371 */       fechaFactura = DateUtils.getDateFromString(this.jftfFecha.getText());
/* 372 */     } catch (ParseException parseException) {}
/*     */     
/* 374 */     BigDecimal gravadoGastos = null;
/*     */     try {
/* 376 */       gravadoGastos = new BigDecimal(this.jtfGravadoGastos.getText());
/* 377 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 379 */     BigDecimal iva21 = null;
/*     */     try {
/* 381 */       iva21 = new BigDecimal(this.jtfIva.getText());
/* 382 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 384 */     String letraFactura = this.jcbTipoFactura.getSelectedItem().toString();
/* 385 */     BigDecimal montoImponible = null;
/*     */     try {
/* 387 */       montoImponible = new BigDecimal(this.jtfImporte.getText());
/* 388 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 390 */     String numeroFactura = this.jtfNumero.getText();
/* 391 */     BigDecimal percepcion993 = null;
/*     */     try {
/* 393 */       percepcion993 = new BigDecimal(this.jtfPercepcion993.getText());
/* 394 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 396 */     BigDecimal percepcionDGR = null;
/*     */     try {
/* 398 */       percepcionDGR = new BigDecimal(this.jtfPercepcionDgr.getText());
/* 399 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 401 */     String periodoFiscal = this.jftfPeriodo.getText().replaceAll("/", "");
/* 402 */     BigDecimal totalFactura = null;
/*     */     try {
/* 404 */       totalFactura = new BigDecimal(this.jtfTotalFactura.getText());
/* 405 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 407 */     this.facturaCompraSeleccionada.setFechaFactura(fechaFactura);
/* 408 */     this.facturaCompraSeleccionada.setGravadoGastos(gravadoGastos);
/* 409 */     this.facturaCompraSeleccionada.setIva21(iva21);
/* 410 */     this.facturaCompraSeleccionada.setLetraFactura(letraFactura);
/* 411 */     this.facturaCompraSeleccionada.setMontoImponible(montoImponible);
/* 412 */     this.facturaCompraSeleccionada.setNumeroFactura(numeroFactura);
/* 413 */     this.facturaCompraSeleccionada.setPercepcion993(percepcion993);
/* 414 */     this.facturaCompraSeleccionada.setPercepcionDGR(percepcionDGR);
/* 415 */     this.facturaCompraSeleccionada.setPeriodoFiscal(periodoFiscal);
/* 416 */     this.facturaCompraSeleccionada.setPersona(this.jpPersona1.getPersona());
/* 417 */     this.facturaCompraSeleccionada.setTotalFactura(totalFactura);
/*     */   }
/*     */   
/*     */   private void clearFields() {
/* 421 */     this.facturaCompraSeleccionada = null;
/* 422 */     this.jpPersona1.clearFields();
/* 423 */     this.jftfFecha.setText("");
/* 424 */     this.jtfNumero.setText("");
/* 425 */     this.jftfPeriodo.setText(BusinessDelegator.getInstance().getPeriodoActivo());
/* 426 */     this.jtfImporte.setText("");
/* 427 */     this.jtfGravadoGastos.setText("");
/* 428 */     this.jtfPercepcionDgr.setText("");
/* 429 */     this.jtfPercepcion993.setText("");
/* 430 */     this.jtfIva.setText("");
/* 431 */     this.jtfTotalFactura.setText("");
/*     */   }
/*     */   
/*     */   private void nuevaFacturaCompra() {
/* 435 */     clearFields();
/*     */   }
/*     */   
/*     */   private void setFieldsFromFacturaCompra() {
/* 439 */     if (this.facturaCompraSeleccionada.getLetraFactura() != null) {
/* 440 */       this.jcbTipoFactura.setSelectedItem(this.facturaCompraSeleccionada.getLetraFactura().toUpperCase());
/*     */     }
/*     */     
/* 443 */     this.jftfFecha.setText(DateUtils.getFormatoCorto(this.facturaCompraSeleccionada.getFechaFactura()));
/* 444 */     if (this.facturaCompraSeleccionada.getGravadoGastos() != null) {
/* 445 */       this.jtfGravadoGastos.setText(this.facturaCompraSeleccionada.getGravadoGastos().toString());
/*     */     }
/* 447 */     if (this.facturaCompraSeleccionada.getMontoImponible() != null) {
/* 448 */       this.jtfImporte.setText(this.facturaCompraSeleccionada.getMontoImponible().toString());
/*     */     }
/* 450 */     if (this.facturaCompraSeleccionada.getIva21() != null) {
/* 451 */       this.jtfIva.setText(this.facturaCompraSeleccionada.getIva21().toString());
/*     */     }
/* 453 */     this.jtfNumero.setText(this.facturaCompraSeleccionada.getNumeroFactura());
/* 454 */     if (this.facturaCompraSeleccionada.getPercepcion993() != null) {
/* 455 */       this.jtfPercepcion993.setText(this.facturaCompraSeleccionada.getPercepcion993().toString());
/*     */     }
/* 457 */     if (this.facturaCompraSeleccionada.getPercepcionDGR() != null) {
/* 458 */       this.jtfPercepcionDgr.setText(this.facturaCompraSeleccionada.getPercepcionDGR().toString());
/*     */     }
/* 460 */     this.jftfPeriodo.setText(this.facturaCompraSeleccionada.getPeriodoFiscal());
/* 461 */     if (this.facturaCompraSeleccionada.getTotalFactura() != null) {
/* 462 */       this.jtfTotalFactura.setText(this.facturaCompraSeleccionada.getTotalFactura().toString());
/*     */     }
/*     */   }
/*     */   
/*     */   public void setFacturaCompra(DocumentoDeCompra documentoDeCompra) {
/*     */     try {
/* 468 */       clearFields();
/* 469 */       this.facturaCompraSeleccionada = BusinessDelegator.getInstance().mergeDocumentoDeCompra(documentoDeCompra);
/* 470 */       this.jpPersona1.setPersona(documentoDeCompra.getPersona());
/* 471 */       if (this.facturaCompraSeleccionada instanceof FacturaCompra) {
/* 472 */         this.facturaCompraSeleccionada = this.facturaCompraSeleccionada;
/* 473 */         this.jtfTipo.setText("1");
/*     */       } 
/* 475 */       if (this.facturaCompraSeleccionada instanceof NotaDeCredito) {
/* 476 */         this.facturaCompraSeleccionada = this.facturaCompraSeleccionada;
/* 477 */         this.jtfTipo.setText("2");
/*     */       } 
/* 479 */       setFieldsFromFacturaCompra();
/* 480 */     } catch (Exception ex) {
/* 481 */       Logger.getLogger(JifFacturaCompra.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void focusNextfield() {
/* 486 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JifFacturaCompra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */