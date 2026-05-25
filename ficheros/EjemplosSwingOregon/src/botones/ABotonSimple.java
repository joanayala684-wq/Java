package botones;

import javax.swing.*;    

public class ABotonSimple {  
    public static void main(String[] args) {  
        JFrame frame = new JFrame("Ejemplo de JButton");  
        JButton boton = new JButton("Haz clic aquí");  
        boton.setBounds(50, 100, 120, 30);  // Posición y tamaño del botón

        frame.add(boton);  // Agregar botón al JFrame
        frame.setSize(400, 400);  // Tamaño del JFrame
        frame.setLayout(null);  // Sin gestor de diseño
        frame.setVisible(true);  // Hacer visible el JFrame
    }  
}