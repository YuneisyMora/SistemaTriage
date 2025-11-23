/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cr.uned.ac.proyectotriage.view;

/**
 *
 */
public class ProyectoTriage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewPrincipal vistaPrincipal = new ViewPrincipal();
                vistaPrincipal.setVisible(true);
                vistaPrincipal.setLocationRelativeTo(null); //centra la ventana 
                vistaPrincipal.setResizable(false);
            }
        });
    }
    
}
