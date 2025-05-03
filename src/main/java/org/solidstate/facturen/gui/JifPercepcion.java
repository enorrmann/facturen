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
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.InputVerifier;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JInternalFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.text.DefaultFormatterFactory;
/*     */ import javax.swing.text.MaskFormatter;
/*     */ import org.solidstate.facturen.core.BusinessDelegator;
/*     */ import org.solidstate.facturen.entities.DocumentoDeCompra;
/*     */ import org.solidstate.facturen.entities.PercepcionDgr;
/*     */ import org.solidstate.facturen.entities.Persona;
/*     */ import org.solidstate.facturen.gui.verifyers.VerifyerFactory;
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
/*     */ public class JifPercepcion
/*     */   extends JInternalFrame
/*     */ {
/*     */   private PercepcionDgr percepcionDgrSeleccionada;
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JFormattedTextField jftfFecha;
/*     */   private JFormattedTextField jftfPeriodo;
/*     */   private JpPersona jpPersona1;
/*     */   private JTextField jtfImportePrecepcion;
/*     */   private JTextField jtfNumero;
/*     */   
/*     */   public JifPercepcion() {
/*  55 */     initComponents();
/*  56 */     this.jftfPeriodo.setText(BusinessDelegator.getInstance().getPeriodoActivo());
/*  57 */     this.jpPersona1.setTipoPersona(Persona.PROVEEDOR);
/*     */   }
/*     */   
/*     */   private void initComponents() {
/*  61 */     this.jftfPeriodo = new JFormattedTextField();
/*  62 */     this.jftfFecha = new JFormattedTextField();
/*  63 */     this.jLabel1 = new JLabel();
/*  64 */     this.jLabel2 = new JLabel();
/*  65 */     this.jpPersona1 = new JpPersona();
/*  66 */     this.jLabel3 = new JLabel();
/*  67 */     this.jtfImportePrecepcion = new JTextField();
/*  68 */     this.jButton1 = new JButton();
/*  69 */     this.jLabel4 = new JLabel();
/*  70 */     this.jtfNumero = new JTextField();
/*  71 */     setClosable(true);
/*  72 */     setTitle("Percepciones");
/*     */     try {
/*  74 */       this.jftfPeriodo.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/####")));
/*  75 */     } catch (ParseException ex) {
/*  76 */       ex.printStackTrace();
/*     */     } 
/*  78 */     this.jftfPeriodo.setHorizontalAlignment(0);
/*  79 */     this.jftfPeriodo.setInputVerifier((InputVerifier)VerifyerFactory.getPeriodoVerifyer());
/*  80 */     this.jftfPeriodo.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  82 */             JifPercepcion.this.jftfPeriodoActionPerformed(evt);
/*     */           }
/*     */         });
/*  85 */     this.jftfPeriodo.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/*  87 */             JifPercepcion.this.jftfPeriodoKeyPressed(evt);
/*     */           }
/*     */         });
/*     */     try {
/*  91 */       this.jftfFecha.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
/*  92 */     } catch (ParseException ex) {
/*  93 */       ex.printStackTrace();
/*     */     } 
/*  95 */     this.jftfFecha.setHorizontalAlignment(0);
/*  96 */     this.jftfFecha.setInputVerifier((InputVerifier)VerifyerFactory.getFechaVerifyer());
/*  97 */     this.jftfFecha.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  99 */             JifPercepcion.this.jftfFechaActionPerformed(evt);
/*     */           }
/*     */         });
/* 102 */     this.jftfFecha.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/* 104 */             JifPercepcion.this.jftfFechaKeyPressed(evt);
/*     */           }
/*     */         });
/* 107 */     this.jLabel1.setText("Periodo");
/* 108 */     this.jLabel2.setText("Fecha");
/* 109 */     this.jLabel3.setText("Importe Percepcion");
/* 110 */     this.jtfImportePrecepcion.setInputVerifier((InputVerifier)VerifyerFactory.getDecimalVerifyer());
/* 111 */     this.jtfImportePrecepcion.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 113 */             JifPercepcion.this.jtfImportePrecepcionActionPerformed(evt);
/*     */           }
/*     */         });
/* 116 */     this.jButton1.setText("Guardar");
/* 117 */     this.jButton1.setNextFocusableComponent(this.jftfFecha);
/* 118 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 120 */             JifPercepcion.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 123 */     this.jButton1.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/* 125 */             JifPercepcion.this.jButton1KeyPressed(evt);
/*     */           }
/*     */         });
/* 128 */     this.jLabel4.setText("Num Comprobante");
/* 129 */     this.jtfNumero.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 131 */             JifPercepcion.this.jtfNumeroActionPerformed(evt);
/*     */           }
/*     */         });
/* 134 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 135 */     getContentPane().setLayout(layout);
/* 136 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jftfPeriodo, -2, 82, -2).addComponent(this.jftfFecha, -2, 87, -2))).addComponent(this.jpPersona1, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfNumero, -1, 265, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfImportePrecepcion, -1, 264, 32767)).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING)).addContainerGap()));
/* 137 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jftfPeriodo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jftfFecha, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpPersona1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jtfNumero, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jtfImportePrecepcion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addContainerGap(18, 32767)));
/* 138 */     pack();
/*     */   }
/*     */   
/*     */   private void jftfPeriodoActionPerformed(ActionEvent evt) {
/* 142 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jftfPeriodoKeyPressed(KeyEvent evt) {
/* 146 */     if (evt.getKeyCode() == 10)
/* 147 */       focusNextfield(); 
/*     */   }
/*     */   
/*     */   private void jftfFechaActionPerformed(ActionEvent evt) {
/* 151 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jftfFechaKeyPressed(KeyEvent evt) {
/* 155 */     if (evt.getKeyCode() == 10)
/* 156 */       focusNextfield(); 
/*     */   }
/*     */   
/*     */   private void jtfImportePrecepcionActionPerformed(ActionEvent evt) {
/* 160 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jButton1KeyPressed(KeyEvent evt) {
/* 164 */     if (evt.getKeyCode() == 10) {
/* 165 */       savePercepcion();
/* 166 */       focusNextfield();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jtfNumeroActionPerformed(ActionEvent evt) {
/* 171 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 175 */     savePercepcion();
/* 176 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void focusNextfield() {
/* 180 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
/*     */   }
/*     */   
/*     */   private void savePercepcion() {
/*     */     try {
/* 185 */       this.jpPersona1.setCamposPersona(Persona.PROVEEDOR);
/* 186 */       setCamposPercepcion();
/* 187 */       BusinessDelegator.getInstance().mergeDocumentoDeCompra((DocumentoDeCompra)this.percepcionDgrSeleccionada);
/* 188 */       clearFields();
/* 189 */     } catch (Exception ex) {
/* 190 */       Logger.getLogger(JifFacturaCompra.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 191 */       JOptionPane.showMessageDialog(this, "Ha ocurrido un error al guardar la factura", "Error", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setCamposPercepcion() {
/* 196 */     if (this.percepcionDgrSeleccionada == null)
/* 197 */       this.percepcionDgrSeleccionada = new PercepcionDgr(); 
/* 198 */     Date fechaFactura = null;
/*     */     try {
/* 200 */       fechaFactura = DateUtils.getDateFromString(this.jftfFecha.getText());
/* 201 */     } catch (ParseException parseException) {}
/* 202 */     String numeroFactura = this.jtfNumero.getText();
/* 203 */     String periodoFiscal = this.jftfPeriodo.getText().replaceAll("/", "");
/* 204 */     BigDecimal importePercepcion = null;
/*     */     try {
/* 206 */       importePercepcion = new BigDecimal(this.jtfImportePrecepcion.getText());
/* 207 */     } catch (NumberFormatException numberFormatException) {}
/* 208 */     this.percepcionDgrSeleccionada.setPersona(this.jpPersona1.getPersona());
/* 209 */     this.percepcionDgrSeleccionada.setPercepcionDGR(importePercepcion);
/* 210 */     this.percepcionDgrSeleccionada.setFechaFactura(fechaFactura);
/* 211 */     this.percepcionDgrSeleccionada.setNumeroFactura(numeroFactura);
/* 212 */     this.percepcionDgrSeleccionada.setPeriodoFiscal(periodoFiscal);
/*     */   }
/*     */   
/*     */   private void clearFields() {
/* 216 */     this.percepcionDgrSeleccionada = null;
/* 217 */     this.jpPersona1.clearFields();
/* 218 */     this.jftfFecha.setText("");
/* 219 */     this.jtfNumero.setText("");
/* 220 */     this.jtfImportePrecepcion.setText("");
/* 221 */     this.jftfPeriodo.setText(BusinessDelegator.getInstance().getPeriodoActivo());
/*     */   }
/*     */   
/*     */   public void setPercepcionDgr(PercepcionDgr percepcionDgr) {
/*     */     try {
/* 226 */       clearFields();
/* 227 */       this.percepcionDgrSeleccionada = (PercepcionDgr)BusinessDelegator.getInstance().mergeDocumentoDeCompra((DocumentoDeCompra)percepcionDgr);
/* 228 */       this.jpPersona1.setPersona(this.percepcionDgrSeleccionada.getPersona());
/* 229 */       setFieldsFromPercepcionDgr();
/* 230 */     } catch (Exception ex) {
/* 231 */       Logger.getLogger(JifFacturaCompra.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setFieldsFromPercepcionDgr() {
/* 236 */     this.jftfPeriodo.setText(this.percepcionDgrSeleccionada.getPeriodoFiscal());
/* 237 */     this.jftfFecha.setText(DateUtils.getFormatoCorto(this.percepcionDgrSeleccionada.getFechaFactura()));
/* 238 */     this.jtfNumero.setText(this.percepcionDgrSeleccionada.getNumeroFactura());
/* 239 */     if (this.percepcionDgrSeleccionada.getPercepcionDGR() != null)
/* 240 */       this.jtfImportePrecepcion.setText(this.percepcionDgrSeleccionada.getPercepcionDGR().toString()); 
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JifPercepcion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */