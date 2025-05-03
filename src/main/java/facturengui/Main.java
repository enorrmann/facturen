/*    */ package facturengui;
/*    */ 
/*    */ import java.awt.EventQueue;
/*    */ import org.solidstate.facturen.gui.JfPrincipal;
/*    */ 
/*    */ public class Main {
/*    */   public static void main(String[] args) {
/*  8 */     EventQueue.invokeLater(new Runnable() {
/*    */           public void run() {
/* 10 */             (new JfPrincipal()).setVisible(true);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              /home/emilio/veterinaria_facturen/facturas/FacturenGui.jar!/facturengui/Main.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */