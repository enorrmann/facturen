/*     */ package org.solidstate.facturen.gui;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.text.ParseException;
/*     */ import java.util.List;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JInternalFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JifPersonas
/*     */   extends JInternalFrame
/*     */ {
/*     */   private Persona persona;
/*     */   private List<Persona> personas;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JFormattedTextField jftfCuit;
/*     */   private JList<Persona> jlPersonas;
/*     */   private JTextField jtfNombre;
/*     */   private JTextField jtfTelefono;
/*     */   private JTextField jtfTelefonoViajante;
/*     */   
/*     */   public JifPersonas() {
/*  56 */     this.persona = null;
/*  57 */     initComponents();
/*  58 */     setModeloLista();
/*     */   }
/*     */   
/*     */   private void initComponents() {
/*  62 */     this.jButton1 = new JButton();
/*  63 */     this.jButton2 = new JButton();
/*  64 */     this.jScrollPane1 = new JScrollPane();
/*  65 */     this.jlPersonas = new JList<Persona>();
/*  66 */     this.jLabel1 = new JLabel();
/*  67 */     this.jLabel2 = new JLabel();
/*  68 */     this.jLabel3 = new JLabel();
/*  69 */     this.jLabel4 = new JLabel();
/*  70 */     this.jtfNombre = new JTextField();
/*  71 */     this.jftfCuit = new JFormattedTextField();
/*  72 */     this.jtfTelefono = new JTextField();
/*  73 */     this.jtfTelefonoViajante = new JTextField();
/*  74 */     setClosable(true);
/*  75 */     setResizable(true);
/*  76 */     setTitle("Ingreso de Proveedores");
/*  77 */     this.jButton1.setText("Cerrar");
/*  78 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  80 */             JifPersonas.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*  83 */     this.jButton2.setText("Guardar");
/*  84 */     this.jButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  86 */             JifPersonas.this.jButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/*  89 */     this.jlPersonas.setModel(new AbstractListModel<Persona>() {
/*  90 */           String[] strings = new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/*     */           
/*     */           public int getSize() {
/*  93 */             return this.strings.length;
/*     */           }
/*     */           
/*     */           public Persona getElementAt(int i) {
/*  97 *///             return this.strings[i];
return null;
/*     */           }
/*     */         });
/* 100 */     this.jlPersonas.addListSelectionListener(new ListSelectionListener() {
/*     */           public void valueChanged(ListSelectionEvent evt) {
/* 102 */             JifPersonas.this.jlPersonasValueChanged(evt);
/*     */           }
/*     */         });
/* 105 */     this.jScrollPane1.setViewportView(this.jlPersonas);
/* 106 */     this.jLabel1.setText("Nombre:");
/* 107 */     this.jLabel2.setText("Numero de CUIT:");
/* 108 */     this.jLabel3.setText("Telefono:");
/* 109 */     this.jLabel4.setText("Telefono viajante:");
/*     */     try {
/* 111 */       this.jftfCuit.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##-########-#")));
/* 112 */     } catch (ParseException ex) {
/* 113 */       ex.printStackTrace();
/*     */     } 
/* 115 */     this.jftfCuit.setHorizontalAlignment(0);
/* 116 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 117 */     getContentPane().setLayout(layout);
/* 118 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 190, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1).addComponent(this.jLabel3).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jtfTelefonoViajante, -1, 148, 32767).addComponent(this.jtfTelefono, -1, 148, 32767).addComponent(this.jtfNombre, -1, 148, 32767).addComponent(this.jftfCuit, -1, 148, 32767)).addGap(12, 12, 12)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addContainerGap()))));
/* 119 */     layout.linkSize(0, new Component[] { this.jButton1, this.jButton2 });
/* 120 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jtfNombre, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jftfCuit, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jtfTelefono, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jtfTelefonoViajante, -2, -1, -2))).addComponent(this.jScrollPane1, -1, 293, 32767)).addGap(31, 31, 31).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
/* 121 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 125 */     registrarPersona();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 129 */     cerrar();
/*     */   }
/*     */   
/*     */   private void jlPersonasValueChanged(ListSelectionEvent evt) {
/* 133 */     if (this.jlPersonas.getSelectedValue() == null)
/*     */       return; 
/* 135 */     setPersona(this.jlPersonas.getSelectedValue());
/*     */   }
/*     */   
/*     */   private void registrarPersona() {
/* 139 */     String nombre = this.jtfNombre.getText();
/* 140 */     String cuit = this.jftfCuit.getText();
/* 141 */     String telefono = this.jtfTelefono.getText();
/* 142 */     String telefonoViajante = this.jtfTelefonoViajante.getText();
/* 143 */     if ("".equalsIgnoreCase(nombre))
/*     */       return; 
/* 145 */     if (this.persona == null)
/* 146 */       this.persona = new Persona(); 
/* 147 */     this.persona.setCuit(cuit);
/* 148 */     this.persona.setRazonSocial(nombre);
/* 149 */     this.persona.setTelefono(telefono);
/* 150 */     this.persona.setTelefonoViajante(telefonoViajante);
/* 151 */     boolean exito = BusinessDelegator.getInstance().registrarPersona(this.persona);
/* 152 */     String titulo = "";
/* 153 */     String mensaje = "";
/* 154 */     if (exito) {
/* 155 */       mensaje = "Se ha registrado la persona";
/* 156 */       titulo = "Registrado";
/* 157 */       limpiarCampos();
/* 158 */       this.persona = null;
/* 159 */       setModeloLista();
/* 160 */       JOptionPane.showMessageDialog(this, mensaje, titulo, 1);
/*     */     } else {
/* 162 */       mensaje = "Error registrando el proveedor";
/* 163 */       titulo = "Error";
/* 164 */       JOptionPane.showMessageDialog(this, mensaje, titulo, 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void limpiarCampos() {
/* 169 */     this.jtfNombre.setText("");
/* 170 */     this.jftfCuit.setText("");
/* 171 */     this.jftfCuit.setValue("");
/* 172 */     this.jtfTelefono.setText("");
/* 173 */     this.jtfTelefonoViajante.setText("");
/*     */   }
/*     */   
/*     */   private void setModeloLista() {
/* 177 */     this.personas = BusinessDelegator.getInstance().getPersonasAll();
/* 178 */     this.jlPersonas.setModel(new AbstractListModel<Persona>() {
/* 179 */           Persona[] arrayPersonas = (Persona[])JifPersonas.this.personas.toArray((Object[])new Persona[0]);
/*     */           
/*     */           public int getSize() {
/* 182 */             return this.arrayPersonas.length;
/*     */           }
/*     */           
/*     */           public Persona getElementAt(int i) {
/* 186 */             return this.arrayPersonas[i];
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void cerrar() {
/* 192 */     limpiarCampos();
/* 193 */     dispose();
/*     */   }
/*     */   
/*     */   private void setPersona(Persona unaPersona) {
/* 197 */     this.persona = unaPersona;
/* 198 */     this.jtfNombre.setText(unaPersona.getRazonSocial());
/* 199 */     this.jftfCuit.setText(unaPersona.getCuit());
/* 200 */     this.jtfTelefono.setText(unaPersona.getTelefono());
/* 201 */     this.jtfTelefonoViajante.setText(unaPersona.getTelefonoViajante());
/*     */   }
/*     */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JifPersonas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */