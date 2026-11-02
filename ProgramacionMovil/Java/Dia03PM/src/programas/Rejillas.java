package programas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Rejillas extends JFrame{
    JLabel txtTitulo, txtResultado;
    JTextField edadDada;
    JPanel panelControles;
    JButton btnCalcularEdad;

    public Rejillas(){
        setTitle("GridLayout");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3,1));

        txtTitulo = new JLabel("Dame tu edad:");
        edadDada = new JTextField(3);
        panelControles = new JPanel();

        panelControles.add(txtTitulo);
        panelControles.add(edadDada);

        btnCalcularEdad = new JButton("Calcular Edad");

        btnCalcularEdad.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int edad = Integer.parseInt(edadDada.getText()+"");
                if(edad>=18){
                    txtResultado.setText("eres mayor de edad");
                }else{
                    txtResultado.setText("eres menor de edad");
                }
            }
        });


        txtResultado = new JLabel("");

        add(panelControles);
        add(btnCalcularEdad);
        add(txtResultado);
    }
    public static void main(String[] args) {
        Rejillas r = new Rejillas();
        r.setVisible(true);
    }
}