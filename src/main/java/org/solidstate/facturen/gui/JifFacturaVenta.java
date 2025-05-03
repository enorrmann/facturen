/*     */ package org.solidstate.facturen.gui;
import java.awt.KeyboardFocusManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.ParseException;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;

/*     */ import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.InputVerifier;
import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
/*     */ import javax.swing.JLabel;
import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/*     */ import org.solidstate.facturen.core.BusinessDelegator;
/*     */ import org.solidstate.facturen.entities.DocumentoDeVenta;
import org.solidstate.facturen.entities.FacturaVenta;
import org.solidstate.facturen.entities.NotaDeCreditoVenta;
/*     */ import org.solidstate.facturen.entities.Persona;
import org.solidstate.facturen.gui.verifyers.ConceptoVerifyer;
/*     */ import org.solidstate.facturen.gui.verifyers.DecimalVerifyer;
/*     */ import org.solidstate.facturen.gui.verifyers.FechaVerifyer;
/*     */ import org.solidstate.facturen.gui.verifyers.PeriodoVerifyer;
/*     */ import org.solidstate.facturen.gui.verifyers.SituacionIvaVerifyer;
/*     */ import org.solidstate.facturen.gui.verifyers.TipoFacturaVerifyer;
/*     */ import org.solidstate.facturen.utils.Alicuotas;
/*     */ import org.solidstate.utils.DateUtils;
/*     */ 
/*     */ public class JifFacturaVenta extends JInternalFrame {
/*  34 */   InputVerifier facturaAVerifyer = (InputVerifier)new SituacionIvaVerifyer("a");
/*  35 */   InputVerifier facturaBVerifyer = (InputVerifier)new SituacionIvaVerifyer("b");
/*     */   
/*     */   private DocumentoDeVenta facturaSeleccionada;
/*     */   
/*     */   private DecimalVerifyer decimalVerifyer;
/*     */   
/*     */   private PeriodoVerifyer periodoVerifyer;
/*     */   private FechaVerifyer fechaVerifyer;
/*     */   private TipoFacturaVerifyer tipoFacturaVerifyer;
/*     */   private ButtonGroup buttonGroup1;
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel12;
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   
/*     */   private void initComponents() {
/*  57 */     this.buttonGroup1 = new ButtonGroup();
/*  58 */     this.jpPersona1 = new JpPersona();
/*  59 */     this.jPanel1 = new JPanel();
/*  60 */     this.jLabel2 = new JLabel();
/*  61 */     this.jftfFecha = new JFormattedTextField();
/*  62 */     this.jLabel3 = new JLabel();
/*  63 */     this.jcbTipoFactura = new JComboBox();
/*  64 */     this.jLabel4 = new JLabel();
/*  65 */     this.jtfNumero = new JTextField();
/*  66 */     this.jLabel5 = new JLabel();
/*  67 */     this.jLabel7 = new JLabel();
/*  68 */     this.jlTasaHigiene = new JLabel();
/*  69 */     this.jLabel9 = new JLabel();
/*  70 */     this.jLabel10 = new JLabel();
/*  71 */     this.jtfImporte = new JTextField();
/*  72 */     this.jtfIva = new JTextField();
/*  73 */     this.jtfTasaHigiene = new JTextField();
/*  74 */     this.jtfPercepcionDgr = new JTextField();
/*  75 */     this.jtfTotalFactura = new JTextField();
/*  76 */     this.jlConcepto = new JLabel();
/*  77 */     this.jtfConcepto = new JTextField();
/*  78 */     this.jLabel12 = new JLabel();
/*  79 */     this.jLabel1 = new JLabel();
/*  80 */     this.jtfSituacionIva = new JTextField();
/*  81 */     this.jLabel13 = new JLabel();
/*  82 */     this.jButton1 = new JButton();
/*  83 */     this.jLabel11 = new JLabel();
/*  84 */     this.jtfTipo = new JTextField();
/*     */     
/*  86 */     setClosable(true);
/*  87 */     setResizable(true);
/*  88 */     setTitle("Factura de VENTA");
/*     */     
/*  90 */     this.jpPersona1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Cliente")));
/*     */     
/*  92 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder("Factura"));
/*     */     
/*  94 */     this.jLabel2.setText("Fecha");
/*     */     
/*     */     try {
/*  97 */       this.jftfFecha.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
/*  98 */     } catch (ParseException ex) {
/*  99 */       ex.printStackTrace();
/*     */     } 
/* 101 */     this.jftfFecha.setHorizontalAlignment(0);
/* 102 */     this.jftfFecha.setInputVerifier((InputVerifier)this.fechaVerifyer);
/* 103 */     this.jftfFecha.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 105 */             JifFacturaVenta.this.jftfFechaActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 109 */     this.jLabel3.setText("Tipo");
/*     */     
/* 111 */     this.jcbTipoFactura.setModel(new DefaultComboBoxModel<String>(new String[] { "A", "B" }));
/* 112 */     this.jcbTipoFactura.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 114 */             JifFacturaVenta.this.jcbTipoFacturaActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 118 */     this.jLabel4.setText("Numero");
/*     */     
/* 120 */     this.jtfNumero.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 122 */             JifFacturaVenta.this.jtfNumeroActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 126 */     this.jLabel5.setText("IMPORTE Gravado");
/*     */     
/* 128 */     this.jLabel7.setText("I.V.A");
/*     */     
/* 130 */     this.jlTasaHigiene.setText("Tasa Higiene");
/*     */     
/* 132 */     this.jLabel9.setText("D.G.R.");
/*     */     
/* 134 */     this.jLabel10.setText("TOTAL FACTURA");
/*     */     
/* 136 */     this.jtfImporte.setEditable(false);
/* 137 */     this.jtfImporte.setFocusable(false);
/* 138 */     this.jtfImporte.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 139 */     this.jtfImporte.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 141 */             JifFacturaVenta.this.jtfImporteActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 145 */     this.jtfIva.setEditable(false);
/* 146 */     this.jtfIva.setFocusable(false);
/* 147 */     this.jtfIva.setInputVerifier((InputVerifier)this.decimalVerifyer);
/*     */     
/* 149 */     this.jtfTasaHigiene.setEditable(false);
/* 150 */     this.jtfTasaHigiene.setFocusable(false);
/* 151 */     this.jtfTasaHigiene.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 152 */     this.jtfTasaHigiene.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 154 */             JifFacturaVenta.this.jtfTasaHigieneActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 158 */     this.jtfPercepcionDgr.setEditable(false);
/* 159 */     this.jtfPercepcionDgr.setFocusable(false);
/* 160 */     this.jtfPercepcionDgr.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 161 */     this.jtfPercepcionDgr.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 163 */             JifFacturaVenta.this.jtfPercepcionDgrActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 167 */     this.jtfTotalFactura.setInputVerifier((InputVerifier)this.decimalVerifyer);
/* 168 */     this.jtfTotalFactura.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 170 */             JifFacturaVenta.this.jtfTotalFacturaActionPerformed(evt);
/*     */           }
/*     */         });
/* 173 */     this.jtfTotalFactura.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 175 */             JifFacturaVenta.this.jtfTotalFacturaKeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 179 */     this.jlConcepto.setText("Concepto");
/*     */     
/* 181 */     this.jtfConcepto.setText("1");
/* 182 */     this.jtfConcepto.setInputVerifier((InputVerifier)new ConceptoVerifyer());
/* 183 */     this.jtfConcepto.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 185 */             JifFacturaVenta.this.jtfConceptoFocusGained(evt);
/*     */           }
/*     */         });
/* 188 */     this.jtfConcepto.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 190 */             JifFacturaVenta.this.jtfConceptoActionPerformed(evt);
/*     */           }
/*     */         });
/* 193 */     this.jtfConcepto.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 195 */             JifFacturaVenta.this.jtfConceptoKeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 199 */     this.jLabel12.setText("1 - Ventas / 2 - Honorarios");
/*     */     
/* 201 */     this.jLabel1.setText("Situacion Iva");
/*     */     
/* 203 */     this.jtfSituacionIva.setText("1");
/* 204 */     this.jtfSituacionIva.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 206 */             JifFacturaVenta.this.jtfSituacionIvaFocusGained(evt);
/*     */           }
/*     */         });
/* 209 */     this.jtfSituacionIva.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 211 */             JifFacturaVenta.this.jtfSituacionIvaActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 215 */     this.jLabel13.setText("1 - RI / 2 - MT / 3 - CF / 4 - EX");
/*     */     
/* 217 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 218 */     this.jPanel1.setLayout(jPanel1Layout);
/* 219 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 220 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 221 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 222 */           .addContainerGap()
/* 223 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 224 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 225 */               .addComponent(this.jLabel2)
/* 226 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 227 */               .addComponent(this.jftfFecha, -2, 87, -2)
/* 228 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 229 */               .addComponent(this.jLabel3)
/* 230 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 231 */               .addComponent(this.jcbTipoFactura, -2, -1, -2)
/* 232 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 233 */               .addComponent(this.jLabel4)
/* 234 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 235 */               .addComponent(this.jtfNumero, -1, 79, 32767))
/* 236 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 237 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 238 */                 .addComponent(this.jlConcepto)
/* 239 */                 .addComponent(this.jLabel7)
/* 240 */                 .addComponent(this.jlTasaHigiene)
/* 241 */                 .addComponent(this.jLabel9)
/* 242 */                 .addComponent(this.jLabel10)
/* 243 */                 .addComponent(this.jLabel5)
/* 244 */                 .addComponent(this.jLabel1))
/* 245 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 246 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 247 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/* 248 */                   .addComponent(this.jtfSituacionIva, -2, -1, -2)
/* 249 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 250 */                   .addComponent(this.jLabel13, -1, -1, 32767))
/* 251 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/* 252 */                   .addComponent(this.jtfConcepto, -2, -1, -2)
/* 253 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 254 */                   .addComponent(this.jLabel12, -1, -1, 32767))
/* 255 */                 .addComponent(this.jtfIva, -1, 287, 32767)
/* 256 */                 .addComponent(this.jtfTasaHigiene, -1, 287, 32767)
/* 257 */                 .addComponent(this.jtfPercepcionDgr, -1, 287, 32767)
/* 258 */                 .addComponent(this.jtfTotalFactura, -1, 287, 32767)
/* 259 */                 .addComponent(this.jtfImporte, -1, 287, 32767))))
/* 260 */           .addContainerGap()));
/*     */     
/* 262 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 263 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 264 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 265 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 266 */             .addComponent(this.jLabel2)
/* 267 */             .addComponent(this.jftfFecha, -2, -1, -2)
/* 268 */             .addComponent(this.jLabel3)
/* 269 */             .addComponent(this.jcbTipoFactura, -2, -1, -2)
/* 270 */             .addComponent(this.jLabel4)
/* 271 */             .addComponent(this.jtfNumero, -2, -1, -2))
/* 272 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 273 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 274 */             .addComponent(this.jlConcepto)
/* 275 */             .addComponent(this.jtfConcepto, -2, -1, -2)
/* 276 */             .addComponent(this.jLabel12))
/* 277 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 278 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 279 */             .addComponent(this.jLabel1)
/* 280 */             .addComponent(this.jtfSituacionIva, -2, -1, -2)
/* 281 */             .addComponent(this.jLabel13))
/* 282 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 283 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 284 */             .addComponent(this.jLabel10)
/* 285 */             .addComponent(this.jtfTotalFactura, -2, -1, -2))
/* 286 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 287 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 288 */             .addComponent(this.jLabel5)
/* 289 */             .addComponent(this.jtfImporte, -2, -1, -2))
/* 290 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 291 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 292 */             .addComponent(this.jLabel7)
/* 293 */             .addComponent(this.jtfIva, -2, -1, -2))
/* 294 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 295 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 296 */             .addComponent(this.jlTasaHigiene)
/* 297 */             .addComponent(this.jtfTasaHigiene, -2, -1, -2))
/* 298 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 299 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 300 */             .addComponent(this.jLabel9)
/* 301 */             .addComponent(this.jtfPercepcionDgr, -2, -1, -2))
/* 302 */           .addContainerGap(53, 32767)));
/*     */ 
/*     */     
/* 305 */     this.jButton1.setText("Guardar");
/* 306 */     this.jButton1.setNextFocusableComponent(this.jpPersona1);
/* 307 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 309 */             JifFacturaVenta.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 312 */     this.jButton1.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/* 314 */             JifFacturaVenta.this.jButton1KeyPressed(evt);
/*     */           }
/*     */         });
/*     */     
/* 318 */     this.jLabel11.setText("1- Factura / 2- Nota de Credito");
/*     */     
/* 320 */     this.jtfTipo.setText("1");
/* 321 */     this.jtfTipo.setInputVerifier((InputVerifier)this.tipoFacturaVerifyer);
/* 322 */     this.jtfTipo.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 324 */             JifFacturaVenta.this.jtfTipoActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 328 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 329 */     getContentPane().setLayout(layout);
/* 330 */     layout.setHorizontalGroup(layout
/* 331 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 332 */         .addGroup(layout.createSequentialGroup()
/* 333 */           .addContainerGap()
/* 334 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 335 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 336 */             .addComponent(this.jpPersona1, -1, 456, 32767)
/* 337 */             .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 338 */               .addComponent(this.jLabel11)
/* 339 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 340 */               .addComponent(this.jtfTipo, -2, 35, -2)
/* 341 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 118, 32767)
/* 342 */               .addComponent(this.jButton1)))
/* 343 */           .addContainerGap()));
/*     */     
/* 345 */     layout.setVerticalGroup(layout
/* 346 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 347 */         .addGroup(layout.createSequentialGroup()
/* 348 */           .addContainerGap()
/* 349 */           .addComponent(this.jpPersona1, -2, -1, -2)
/* 350 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 351 */           .addComponent(this.jPanel1, -2, -1, -2)
/* 352 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 353 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 354 */             .addComponent(this.jButton1)
/* 355 */             .addComponent(this.jLabel11)
/* 356 */             .addComponent(this.jtfTipo, -2, -1, -2))
/* 357 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 360 */     pack();
/*     */   }
/*     */   private JLabel jLabel7; private JLabel jLabel9; private JPanel jPanel1; private JComboBox jcbTipoFactura; private JFormattedTextField jftfFecha; private JLabel jlConcepto; private JLabel jlTasaHigiene; private JpPersona jpPersona1; private JTextField jtfConcepto; private JTextField jtfImporte; private JTextField jtfIva; private JTextField jtfNumero; private JTextField jtfPercepcionDgr; private JTextField jtfSituacionIva; private JTextField jtfTasaHigiene; private JTextField jtfTipo; private JTextField jtfTotalFactura;
/*     */   private void jtfNumeroActionPerformed(ActionEvent evt) {
/* 364 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 368 */     saveFactura();
/* 369 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfImporteActionPerformed(ActionEvent evt) {
/* 373 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfTasaHigieneActionPerformed(ActionEvent evt) {
/* 377 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfPercepcionDgrActionPerformed(ActionEvent evt) {
/* 381 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfTotalFacturaActionPerformed(ActionEvent evt) {
/* 385 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jftfFechaActionPerformed(ActionEvent evt) {
/* 389 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jcbTipoFacturaActionPerformed(ActionEvent evt) {
/* 393 */     String tipoFactura = this.jcbTipoFactura.getSelectedItem().toString();
/* 394 */     if (tipoFactura.equalsIgnoreCase("a")) {
/* 395 */       this.jtfSituacionIva.setInputVerifier(this.facturaAVerifyer);
/*     */     } else {
/* 397 */       this.jtfSituacionIva.setInputVerifier(this.facturaBVerifyer);
/*     */     } 
/* 399 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfTipoActionPerformed(ActionEvent evt) {
/* 403 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jButton1KeyPressed(KeyEvent evt) {
/* 407 */     if (evt.getKeyCode() == 10) {
/* 408 */       saveFactura();
/* 409 */       focusNextfield();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jtfTotalFacturaKeyReleased(KeyEvent evt) {
/* 414 */     calcularMontos();
/*     */   }
/*     */   
/*     */   private void jtfSituacionIvaActionPerformed(ActionEvent evt) {
/* 418 */     focusNextfield();
/*     */   }
/*     */   private void jtfConceptoActionPerformed(ActionEvent evt) {
/* 421 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfConceptoFocusGained(FocusEvent evt) {
/* 425 */     this.jtfConcepto.selectAll();
/*     */   }
/*     */   
/*     */   private void jtfSituacionIvaFocusGained(FocusEvent evt) {
/* 429 */     this.jtfSituacionIva.selectAll();
/*     */   }
/*     */   
/*     */   private void jtfConceptoKeyReleased(KeyEvent evt) {
/* 433 */     calcularMontos();
/*     */   }
/*     */   
/*     */   private void saveFactura() {
/*     */     try {
/* 438 */       this.jpPersona1.setCamposPersona(Persona.CLIENTE);
/* 439 */       setCamposFactura();
/* 440 */       if (this.jpPersona1.getPersona().getRazonSocial() == null || this.jpPersona1.getPersona().getRazonSocial().equals("") || this.facturaSeleccionada.getNumeroFactura().equals("") || this.facturaSeleccionada.getNumeroFactura() == null) {
/* 441 */         JOptionPane.showMessageDialog(this, "Falta completar algun dato importante", "Error", 0);
/*     */         return;
/*     */       } 
/* 444 */       BusinessDelegator.getInstance().mergeDocumentoDeVenta(this.facturaSeleccionada);
/* 445 */       nuevaFactura();
/* 446 */     } catch (Exception ex) {
/* 447 */       Logger.getLogger(JifFacturaVenta.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 448 */       JOptionPane.showMessageDialog(this, "Ha ocurrido un error al guardar la factura", "Error", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setCamposFactura() {
/* 453 */     if (this.facturaSeleccionada == null) {
/* 454 */       if (this.jtfTipo.getText().equals("2")) {
/* 455 */         this.facturaSeleccionada = (DocumentoDeVenta)new NotaDeCreditoVenta();
/*     */       } else {
/* 457 */         this.facturaSeleccionada = (DocumentoDeVenta)new FacturaVenta();
/*     */       } 
/*     */     }
/* 460 */     Date fechaFactura = null;
/*     */     try {
/* 462 */       fechaFactura = DateUtils.getDateFromString(this.jftfFecha.getText());
/* 463 */     } catch (ParseException parseException) {}
/*     */ 
/*     */     
/* 466 */     BigDecimal iva21 = null;
/*     */     try {
/* 468 */       iva21 = new BigDecimal(this.jtfIva.getText());
/* 469 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 471 */     String letraFactura = this.jcbTipoFactura.getSelectedItem().toString();
/* 472 */     BigDecimal montoImponible = null;
/*     */     try {
/* 474 */       montoImponible = new BigDecimal(this.jtfImporte.getText());
/* 475 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 477 */     String numeroFactura = this.jtfNumero.getText();
/*     */     
/* 479 */     BigDecimal tasaHigiene = null;
/*     */     try {
/* 481 */       tasaHigiene = new BigDecimal(this.jtfTasaHigiene.getText());
/* 482 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 484 */     BigDecimal dgr = null;
/*     */     try {
/* 486 */       dgr = new BigDecimal(this.jtfPercepcionDgr.getText());
/* 487 */     } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */     
/* 490 */     BigDecimal totalFactura = null;
/*     */     try {
/* 492 */       totalFactura = new BigDecimal(this.jtfTotalFactura.getText());
/* 493 */     } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */     
/* 496 */     Long situacionIva = null;
/*     */     try {
/* 498 */       situacionIva = Long.valueOf(Long.parseLong(this.jtfSituacionIva.getText()));
/* 499 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 501 */     Long concepto = null;
/*     */     try {
/* 503 */       concepto = Long.valueOf(Long.parseLong(this.jtfConcepto.getText()));
/* 504 */     } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */     
/* 507 */     this.facturaSeleccionada.setFechaFactura(fechaFactura);
/* 508 */     this.facturaSeleccionada.setSituacionImpositiva(situacionIva);
/* 509 */     this.facturaSeleccionada.setConcepto(concepto);
/*     */     
/* 511 */     this.facturaSeleccionada.setMontoAlicuotaTasaHigiene(tasaHigiene);
/* 512 */     this.facturaSeleccionada.setAlicuotaDGR(Alicuotas.getAlicuotaDgr(concepto));
/* 513 */     this.facturaSeleccionada.setAlicuotaTasaHigiene(Alicuotas.getAlicuotaTasaHigiene(concepto));
/* 514 */     this.facturaSeleccionada.setIva21(iva21);
/* 515 */     this.facturaSeleccionada.setLetraFactura(letraFactura);
/* 516 */     this.facturaSeleccionada.setMontoImponible(montoImponible);
/* 517 */     this.facturaSeleccionada.setNumeroFactura(numeroFactura);
/*     */     
/* 519 */     this.facturaSeleccionada.setMontoAlicuotaDGR(dgr);
/* 520 */     this.facturaSeleccionada.setPersona(this.jpPersona1.getPersona());
/* 521 */     this.facturaSeleccionada.setTotalFactura(totalFactura);
/*     */   }
/*     */   
/*     */   private void clearFields() {
/* 525 */     this.facturaSeleccionada = null;
/* 526 */     this.jpPersona1.clearFields();
/* 527 */     this.jftfFecha.setText("");
/*     */     
/* 529 */     this.jtfNumero.setText("");
/* 530 */     this.jtfImporte.setText("");
/* 531 */     this.jtfPercepcionDgr.setText("");
/* 532 */     this.jtfTasaHigiene.setText("");
/* 533 */     this.jtfIva.setText("");
/* 534 */     this.jtfTotalFactura.setText("");
/*     */   }
/*     */   
/*     */   private void nuevaFactura() {
/* 538 */     clearFields();
/*     */   }
/*     */   
/*     */   private void setFieldsFromFactura() {
/* 542 */     this.jftfFecha.setText(DateUtils.getFormatoCorto(this.facturaSeleccionada.getFechaFactura()));
/*     */     
/* 544 */     if (this.facturaSeleccionada.getConcepto() != null) {
/* 545 */       this.jtfConcepto.setText(this.facturaSeleccionada.getConcepto() + "");
/*     */     }
/*     */     
/* 548 */     if (this.facturaSeleccionada.getLetraFactura() != null) {
/* 549 */       this.jcbTipoFactura.setSelectedItem(this.facturaSeleccionada.getLetraFactura().toUpperCase());
/*     */     }
/*     */     
/* 552 */     if (this.facturaSeleccionada.getMontoImponible() != null) {
/* 553 */       this.jtfImporte.setText(this.facturaSeleccionada.getMontoImponible().toString());
/*     */     }
/* 555 */     if (this.facturaSeleccionada.getIva21() != null) {
/* 556 */       this.jtfIva.setText(this.facturaSeleccionada.getIva21().toString());
/*     */     }
/* 558 */     this.jtfNumero.setText(this.facturaSeleccionada.getNumeroFactura());
/* 559 */     if (this.facturaSeleccionada.getMontoAlicuotaTasaHigiene() != null) {
/* 560 */       this.jtfTasaHigiene.setText(this.facturaSeleccionada.getMontoAlicuotaTasaHigiene().toString());
/*     */     }
/* 562 */     if (this.facturaSeleccionada.getMontoAlicuotaDGR() != null) {
/* 563 */       this.jtfPercepcionDgr.setText(this.facturaSeleccionada.getMontoAlicuotaDGR().toString());
/*     */     }
/* 565 */     if (this.facturaSeleccionada.getTotalFactura() != null) {
/* 566 */       this.jtfTotalFactura.setText(this.facturaSeleccionada.getTotalFactura().toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFactura(DocumentoDeVenta documento) {
/*     */     try {
/* 573 */       clearFields();
/* 574 */       this.facturaSeleccionada = BusinessDelegator.getInstance().mergeDocumentoDeVenta(documento);
/* 575 */       this.jpPersona1.setPersona(documento.getPersona());
/* 576 */       if (this.facturaSeleccionada instanceof FacturaVenta) {
/* 577 */         this.facturaSeleccionada = this.facturaSeleccionada;
/* 578 */         this.jtfTipo.setText("1");
/*     */       } 
/* 580 */       if (this.facturaSeleccionada instanceof NotaDeCreditoVenta) {
/* 581 */         this.facturaSeleccionada = this.facturaSeleccionada;
/* 582 */         this.jtfTipo.setText("2");
/*     */       } 
/*     */       
/* 585 */       setFieldsFromFactura();
/* 586 */     } catch (Exception ex) {
/* 587 */       Logger.getLogger(JifFacturaVenta.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void focusNextfield() {
/* 592 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
/*     */   } public JifFacturaVenta() {
/* 594 */     this.facturaSeleccionada = null;
/* 595 */     this.decimalVerifyer = new DecimalVerifyer();
/* 596 */     this.periodoVerifyer = new PeriodoVerifyer();
/* 597 */     this.fechaVerifyer = new FechaVerifyer();
/* 598 */     this.tipoFacturaVerifyer = new TipoFacturaVerifyer();
/*     */     initComponents();
/*     */     this.jtfSituacionIva.setInputVerifier(this.facturaAVerifyer);
/*     */     this.jpPersona1.setTipoPersona(Persona.CLIENTE);
/*     */   }
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
/*     */   private void calcularMontos() {
/* 631 */     BigDecimal totalFactura = getValue(this.jtfTotalFactura);
/* 632 */     if (totalFactura != null) {
/* 633 */       calcularIva(totalFactura);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void calcularIva(BigDecimal totalFactura) {
/*     */     try {
/* 641 */       BigDecimal porcentajeIva = new BigDecimal("1.21");
/* 642 */       BigDecimal importe = totalFactura.divide(porcentajeIva, 2, RoundingMode.HALF_UP);
/*     */       
/* 644 */       calcularDgr(importe);
/* 645 */       calcularTasaHigiene(importe);
/* 646 */       BigDecimal iva = totalFactura.subtract(importe);
/*     */       
/* 648 */       this.jtfImporte.setText(importe.toString());
/* 649 */       this.jtfIva.setText(iva.toString());
/*     */     }
/* 651 */     catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private BigDecimal getValue(JTextField jtf) {
/*     */     try {
/* 658 */       BigDecimal bd = new BigDecimal(jtf.getText());
/* 659 */       return bd;
/* 660 */     } catch (Exception e) {
/* 661 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void calcularDgr(BigDecimal totalFactura) {
/* 666 */     String concepto = this.jtfConcepto.getText();
/* 667 */     BigDecimal porcentajeDgr = Alicuotas.getPorcentajeAlicuotaDgr(concepto);
/* 668 */     if (porcentajeDgr != null) {
/* 669 */       BigDecimal dgr = totalFactura.multiply(porcentajeDgr);
/* 670 */       dgr = dgr.setScale(2, RoundingMode.HALF_UP);
/* 671 */       this.jtfPercepcionDgr.setText(dgr.toString());
/*     */     } else {
/* 673 */       this.jtfPercepcionDgr.setText((String)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void calcularTasaHigiene(BigDecimal totalFactura) {
/* 679 */     String concepto = this.jtfConcepto.getText();
/* 680 */     BigDecimal tasaHigiene = Alicuotas.getPorcentajeAlicuotaTasaHigiene(concepto);
/* 681 */     BigDecimal tasa = totalFactura.multiply(tasaHigiene);
/* 682 */     tasa = tasa.setScale(2, RoundingMode.HALF_UP);
/* 683 */     this.jtfTasaHigiene.setText(tasa.toString());
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JifFacturaVenta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */