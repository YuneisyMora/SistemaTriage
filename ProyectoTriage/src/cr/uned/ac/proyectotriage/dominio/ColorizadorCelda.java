/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.uned.ac.proyectotriage.dominio;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 */
public class ColorizadorCelda extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable tabla, Object valor, boolean estaSeleccionado, boolean tieneFoco,
            int fila, int columna) {

        Component celda = super.getTableCellRendererComponent(tabla, valor, estaSeleccionado, tieneFoco, fila, columna);

        
        celda.setForeground(Color.BLACK);

        if (valor != null) {
            String colorTexto = valor.toString();

            switch (colorTexto) {
                case "Rojo":
                    celda.setBackground(new Color(255, 0, 0));
                    break;

                case "Amarillo":
                    celda.setBackground(new Color(255, 255, 0));
                    break;

                case "Verde":
                    celda.setBackground(new Color(0, 204, 0)); 
                    break;

                default:
                    celda.setBackground(Color.WHITE);
                    break;
            }
        } else {
            celda.setBackground(Color.WHITE);
        }

        return celda;
    }
}
