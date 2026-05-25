package radioButtom;
import javax.swing.*;    
import java.awt.event.*;    

public class EjemploRadioButtonConAccion extends JFrame implements ActionListener {    
    JRadioButton rb1, rb2;    
    JButton boton;    

    EjemploRadioButtonConAccion() {      
        rb1 = new JRadioButton("Masculino");    
        rb1.setBounds(100, 50, 100, 30);      

        rb2 = new JRadioButton("Femenino");    
        rb2.setBounds(100, 100, 100, 30);    

        ButtonGroup grupo = new ButtonGroup();    
        grupo.add(rb1);  
        grupo.add(rb2);    

        boton = new JButton("Seleccionar");    
        boton.setBounds(100, 150, 120, 30);    
        boton.addActionListener(this);    

        add(rb1);  
        add(rb2);  
        add(boton);    

        setSize(300, 300);    
        setLayout(null);    
        setVisible(true);    
    }    

    public void actionPerformed(ActionEvent e) {    
        if (rb1.isSelected()) {    
            JOptionPane.showMessageDialog(this, "Has seleccionado: Masculino");    
        }    
        if (rb2.isSelected()) {    
            JOptionPane.showMessageDialog(this, "Has seleccionado: Femenino");    
        }    
    }    

    public static void main(String args[]) {    
        new EjemploRadioButtonConAccion();    
    }    
}   
