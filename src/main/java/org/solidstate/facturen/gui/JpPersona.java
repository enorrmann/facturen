/*     */ package org.solidstate.facturen.gui;
/*     */ 
/*     */ import java.awt.KeyboardFocusManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.text.ParseException;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.text.DefaultFormatterFactory;
/*     */ import javax.swing.text.MaskFormatter;
/*     */ import org.solidstate.facturen.core.BusinessDelegator;
/*     */ import org.solidstate.facturen.entities.Persona;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JpPersona
/*     */   extends JPanel
/*     */ {
/*     */   private Persona personaSeleccionada;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JTextField jtfCuentaNumero;
/*     */   private JFormattedTextField jtfCuit;
/*     */   private JTextField jtfNombre;
/*  38 */   private Long tipoPersona = null;
/*     */   
/*     */   public JpPersona() {
/*  41 */     initComponents();
/*     */   }
/*     */   
/*     */   private void initComponents() {
/*  45 */     this.jLabel1 = new JLabel();
/*  46 */     this.jtfCuentaNumero = new JTextField();
/*  47 */     this.jLabel2 = new JLabel();
/*  48 */     this.jtfCuit = new JFormattedTextField();
/*  49 */     this.jLabel3 = new JLabel();
/*  50 */     this.jtfNombre = new JTextField();
/*  51 */     setBorder(BorderFactory.createTitledBorder("Empresa"));
/*  52 */     addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/*  54 */             JpPersona.this.formFocusGained(evt);
/*     */           }
/*     */         });
/*  57 */     this.jLabel1.setText("Nro:");
/*  58 */     this.jtfCuentaNumero.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  60 */             JpPersona.this.jtfCuentaNumeroActionPerformed(evt);
/*     */           }
/*     */         });
/*  63 */     this.jtfCuentaNumero.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/*  65 */             JpPersona.this.jtfCuentaNumeroKeyPressed(evt);
/*     */           }
/*     */         });
/*  68 */     this.jLabel2.setText("C.U.I.T.");
/*     */     try {
/*  70 */       this.jtfCuit.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##-########-#")));
/*  71 */     } catch (ParseException ex) {
/*  72 */       ex.printStackTrace();
/*     */     } 
/*  74 */     this.jtfCuit.setHorizontalAlignment(0);
/*  75 */     this.jtfCuit.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  77 */             JpPersona.this.jtfCuitActionPerformed(evt);
/*     */           }
/*     */         });
/*  80 */     this.jLabel3.setText("Razon Social:");
/*  81 */     this.jtfNombre.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  83 */             JpPersona.this.jtfNombreActionPerformed(evt);
/*     */           }
/*     */         });
/*  86 */     GroupLayout layout = new GroupLayout(this);
/*  87 */     setLayout(layout);
/*  88 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfCuentaNumero, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfCuit, -1, 170, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfNombre, -1, 267, 32767))).addContainerGap()));
/*  89 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jtfCuentaNumero, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.jtfCuit, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jtfNombre, -2, -1, -2)).addContainerGap(-1, 32767)));
/*     */   }
/*     */   
/*     */   private void jtfCuentaNumeroKeyPressed(KeyEvent evt) {
/*  93 */     if (evt.getKeyCode() == 113) {
/*  94 */       showDialogoPersonas();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jtfCuentaNumeroActionPerformed(ActionEvent evt) {
/*  99 */     getPersonaById();
/* 100 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfCuitActionPerformed(ActionEvent evt) {
/* 104 */     getPersonaByCuit();
/* 105 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void jtfNombreActionPerformed(ActionEvent evt) {
/* 109 */     focusNextfield();
/*     */   }
/*     */   
/*     */   private void formFocusGained(FocusEvent evt) {
/* 113 */     this.jtfCuentaNumero.requestFocus();
/*     */   }
/*     */   
/*     */   public void clearFields() {
/* 117 */     this.personaSeleccionada = new Persona();
/* 118 */     this.jtfNombre.setText("");
/* 119 */     this.jtfCuit.setValue("");
/* 120 */     this.jtfCuit.setText("");
/* 121 */     this.jtfCuentaNumero.setText("");
/*     */   }
/*     */   
/*     */   private void showDialogoPersonas() {
/* 125 */     this.personaSeleccionada = JfPrincipal.getInstance().showDialogoPersonas(this, this.tipoPersona);
/* 126 */     setFieldsFromPersona();
/*     */   }
/*     */   
/*     */   private void setFieldsFromPersona() {
/* 130 */     if (this.personaSeleccionada == null) {
/* 131 */       this.personaSeleccionada = new Persona();
/* 132 */       enablePersona();
/*     */     } else {
/* 134 */       disablePersona();
/*     */     } 
/* 136 */     this.jtfNombre.setText(this.personaSeleccionada.getRazonSocial());
/* 137 */     this.jtfCuit.setText(this.personaSeleccionada.getCuit());
/* 138 */     if (this.personaSeleccionada.getId() != null) {
/* 139 */       this.jtfCuentaNumero.setText(this.personaSeleccionada.getId() + "");
/*     */     } else {
/* 141 */       this.jtfCuentaNumero.setText("");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void disablePersona() {
/* 146 */     this.jtfCuit.setEditable(false);
/* 147 */     this.jtfCuit.setFocusable(false);
/* 148 */     this.jtfNombre.setEditable(false);
/* 149 */     this.jtfNombre.setFocusable(false);
/*     */   }
/*     */   
/*     */   private void enablePersona() {
/* 153 */     this.jtfCuit.setEditable(true);
/* 154 */     this.jtfCuit.setFocusable(true);
/* 155 */     this.jtfNombre.setEditable(true);
/* 156 */     this.jtfNombre.setFocusable(true);
/*     */   }
/*     */   
/*     */   private void getPersonaById() {
/* 160 */     this.jtfCuit.setValue("");
/* 161 */     String numCuenta = this.jtfCuentaNumero.getText();
/* 162 */     Long idPersona = null;
/*     */     try {
/* 164 */       idPersona = Long.valueOf(Long.parseLong(numCuenta));
/* 165 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 167 */     if (!numCuenta.equals("") && idPersona != null) {
/* 168 */       this.personaSeleccionada = BusinessDelegator.getInstance().findPersonaById(idPersona);
/*     */     } else {
/* 170 */       this.personaSeleccionada = null;
/*     */     } 
/* 172 */     setFieldsFromPersona();
/*     */   }
/*     */ 
/*     */   
/*     */   private void getPersonaByCuit() {
/* 177 */     String cuit = this.jtfCuit.getText();
/* 178 */     if (cuit != null && !cuit.trim().equals("")) {
/* 179 */       this.personaSeleccionada = BusinessDelegator.getInstance().findPersonaByCuit(cuit);
/* 180 */       this.jtfCuentaNumero.setText(this.personaSeleccionada.getId() + "");
/*     */     } else {
/* 182 */       this.jtfCuentaNumero.setText("");
/* 183 */       this.personaSeleccionada = null;
/*     */     } 
/* 185 */     setFieldsFromPersona();
/*     */   }
/*     */   
/*     */   public Persona getPersona() {
/* 189 */     return this.personaSeleccionada;
/*     */   }
/*     */   
/*     */   public void setPersona(Persona unaPersona) {
/* 193 */     if (unaPersona == null) {
/* 194 */       this.personaSeleccionada = new Persona();
/*     */     }
/* 196 */     this.personaSeleccionada = unaPersona;
/* 197 */     setFieldsFromPersona();
/*     */   }
/*     */   
/*     */   public void setCamposPersona(Long tipoPersona) {
/* 201 */     if (this.personaSeleccionada == null) {
/* 202 */       this.personaSeleccionada = new Persona();
/*     */     }
/* 204 */     this.personaSeleccionada.setCuit(this.jtfCuit.getText());
/* 205 */     this.personaSeleccionada.setRazonSocial(this.jtfNombre.getText());
/* 206 */     this.personaSeleccionada.setTipoPersona(tipoPersona);
/*     */   }
/*     */   
/*     */   private void focusNextfield() {
/* 210 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
/*     */   }
/*     */   
/*     */   void setTipoPersona(Long tipoPersona) {
/* 214 */     this.tipoPersona = tipoPersona;
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JpPersona.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */