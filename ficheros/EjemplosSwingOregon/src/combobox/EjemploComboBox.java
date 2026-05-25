package combobox;

import javax.swing.*;    

public class EjemploComboBox {    
    JFrame frame;    

    EjemploComboBox() {    
        frame = new JFrame("Ejemplo de JComboBox");    

        String[] paises = {"India", "Australia", "U.S.A", "Inglaterra", "Nueva Zelanda"};        
        JComboBox<String> comboBox = new JComboBox<>(paises);    
        comboBox.setBounds(50, 50, 150, 30);    

        frame.add(comboBox);        
        frame.setLayout(null);    
        frame.setSize(400, 400);    
        frame.setVisible(true);         
    }    

    public static void main(String[] args) {    
        new EjemploComboBox();         
    }    
}
