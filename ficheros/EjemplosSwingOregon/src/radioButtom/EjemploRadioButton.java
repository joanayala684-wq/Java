package radioButtom;

import javax.swing.*;    

public class EjemploRadioButton {    
    JFrame frame;    

    EjemploRadioButton() {    
        frame = new JFrame();     

        JRadioButton r1 = new JRadioButton("A) Masculino");    
        JRadioButton r2 = new JRadioButton("B) Femenino");    

        r1.setBounds(75, 50, 150, 30);    
        r2.setBounds(75, 100, 150, 30);    

        ButtonGroup grupo = new ButtonGroup();    
        grupo.add(r1);  
        grupo.add(r2);    

        frame.add(r1);  
        frame.add(r2);      

        frame.setSize(300, 300);    
        frame.setLayout(null);    
        frame.setVisible(true);    
    }    

    public static void main(String[] args) {    
        new EjemploRadioButton();    
    }    
}

