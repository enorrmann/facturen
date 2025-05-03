/*    */ package org.solidstate.facturen.gui;
/*    */ 
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.DefaultComboBoxModel;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.LayoutStyle;
/*    */ import org.solidstate.facturen.core.BusinessDelegator;
/*    */ import org.solidstate.utils.StringUtils;
/*    */ 
/*    */ public class JpPeriodoActivo
/*    */   extends JPanel {
/*    */   private JComboBox jcbAnio;
/*    */   private JComboBox jcbMes;
/*    */   
/*    */   public JpPeriodoActivo() {
/* 18 */     initComponents();
/* 19 */     updateCombos();
/*    */   }
/*    */   
/*    */   private void initComponents() {
/* 23 */     this.jcbMes = new JComboBox();
/* 24 */     this.jcbAnio = new JComboBox();
/* 25 */     setBorder(BorderFactory.createTitledBorder("Periodo activo"));
/* 26 */     this.jcbMes.setModel(new DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
/*    */ 
/*    */     
/* 29 */     this.jcbAnio.setModel(new DefaultComboBoxModel<>(new String[] { "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
/*    */ 
/*    */     
/* 32 */     GroupLayout groupLayout = new GroupLayout(this);
/* 33 */     setLayout(groupLayout);
/* 34 */     groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.jcbMes, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jcbAnio, -2, -1, -2).addContainerGap(-1, 32767)));
/* 35 */     groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jcbMes, -2, -1, -2).addComponent(this.jcbAnio, -2, -1, -2)).addContainerGap(-1, 32767)));
/*    */   }
/*    */   
/*    */   public void updateCombos() {
/* 39 */     String str = BusinessDelegator.getInstance().getPeriodoActivo();
/* 40 */     int i = Integer.parseInt(str.substring(0, 2)) - 1;
/* 41 */     int j = Integer.parseInt(str.substring(2, 6));
/* 42 */     this.jcbMes.setSelectedIndex(i);
/* 43 */     this.jcbAnio.setSelectedIndex(j - 2008);
/*    */   }
/*    */   
/*    */   public String getPeriodo() {
/* 47 */     int i = this.jcbMes.getSelectedIndex() + 1;
/* 48 */     return StringUtils.paddingString(Integer.toString(i), 2, '0', true) + this.jcbAnio.getSelectedItem();
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/org/solidstate/facturen/gui/JpPeriodoActivo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */