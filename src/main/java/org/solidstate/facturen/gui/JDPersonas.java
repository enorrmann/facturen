/*     */ package org.solidstate.facturen.gui;
/*     */ 
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.List;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ import org.solidstate.facturen.core.BusinessDelegator;
/*     */ import org.solidstate.facturen.entities.Persona;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JDPersonas
/*     */   extends JDialog
/*     */ {
/*     */   private List<Persona> personas;
/*     */   private Persona persona;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JButton jbAceptar;
/*     */   private JList<Persona> jlPersonas;
/*     */   
/*     */   public JDPersonas(Frame parent, boolean modal) {
/*  31 */     super(parent, modal);
/*  32 */     initComponents();
/*     */   }
/*     */   
/*     */   private void initComponents() {
/*  36 */     this.jScrollPane1 = new JScrollPane();
/*  37 */     this.jlPersonas = new JList<Persona>();
/*  38 */     this.jbAceptar = new JButton();
/*  39 */     setDefaultCloseOperation(2);
/*  40 */     this.jlPersonas.setModel(new AbstractListModel<Persona>() {
/*  41 */           String[] strings = new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/*     */           
/*     */           public int getSize() {
/*  44 */             return this.strings.length;
/*     */           }
/*     */           
/*     */           public Persona getElementAt(int i) {
/*  48 */             //return this.strings[i];
                        return null;
/*     */           }
/*     */         });
/*  51 */     this.jlPersonas.addListSelectionListener(new ListSelectionListener() {
/*     */           public void valueChanged(ListSelectionEvent evt) {
/*  53 */             JDPersonas.this.jlPersonasValueChanged(evt);
/*     */           }
/*     */         });
/*  56 */     this.jScrollPane1.setViewportView(this.jlPersonas);
/*  57 */     this.jbAceptar.setText("Aceptar");
/*  58 */     this.jbAceptar.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  60 */             JDPersonas.this.jbAceptarActionPerformed(evt);
/*     */           }
/*     */         });
/*  63 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  64 */     getContentPane().setLayout(layout);
/*  65 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jbAceptar, GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, -1, 376, 32767)).addContainerGap()));
/*  66 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 241, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbAceptar).addContainerGap()));
/*  67 */     pack();
/*     */   }
/*     */   
/*     */   private void jbAceptarActionPerformed(ActionEvent evt) {
/*  71 */     hideDialog();
/*     */   }
/*     */   
/*     */   private void jlPersonasValueChanged(ListSelectionEvent evt) {
/*  75 */     setPersona(this.jlPersonas.getSelectedValue());
/*     */   }
/*     */   
/*     */   private void hideDialog() {
/*  79 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void setPersona(Persona unaPersona) {
/*  83 */     this.persona = unaPersona;
/*     */   }
/*     */   
/*     */   public Persona getPersona() {
/*  87 */     this.personas.clear();
/*  88 */     return this.persona;
/*     */   }
/*     */   
/*     */   private void setModeloLista(Long tipoPersona) {
/*  92 */     this.personas = BusinessDelegator.getInstance().getPersonasByTipo(tipoPersona);
/*  93 */     this.jlPersonas.setModel(new AbstractListModel<Persona>() {
/*  94 */           Persona[] arrayPersonas = (Persona[])JDPersonas.this.personas.toArray((Object[])new Persona[0]);
/*     */           
/*     */           public int getSize() {
/*  97 */             return this.arrayPersonas.length;
/*     */           }
/*     */           
/*     */           public Persona getElementAt(int i) {
/* 101 */             return this.arrayPersonas[i];
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void setVisible(boolean visible, Long tipoPersona) {
/* 107 */     if (visible)
/* 108 */       setModeloLista(tipoPersona); 
/* 109 */     this.personas.clear();
/* 110 */     setVisible(visible);
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JDPersonas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */