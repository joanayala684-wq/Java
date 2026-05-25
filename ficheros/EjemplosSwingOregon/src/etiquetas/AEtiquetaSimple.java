package etiquetas;

import javax.swing.*;  

public class AEtiquetaSimple {  
    public static void main(String[] args) {  
        JFrame frame = new JFrame("Ejemplo de JLabel");  
        JLabel etiqueta1, etiqueta2;  

        etiqueta1 = new JLabel("Primera Etiqueta");  
        etiqueta1.setBounds(50, 50, 150, 30);  

        etiqueta2 = new JLabel("Segunda Etiqueta");  
        etiqueta2.setBounds(50, 100, 150, 30);  

        frame.add(etiqueta1);  
        frame.add(etiqueta2);  

        frame.setSize(300, 300);  
        frame.setLayout(null);  
        frame.setVisible(true);  
    }  
}

