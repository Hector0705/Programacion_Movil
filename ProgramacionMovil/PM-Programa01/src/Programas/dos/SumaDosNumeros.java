package Programas.dos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SumaDosNumeros extends JFrame {
    JTextField num1, num2;
    JButton btnSumar;
    JPanel panelCosas;

    public SumaDosNumeros(){
        setTitle("Programa 02");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        num1 = new JTextField(10);
        num2 = new JTextField(10);
        btnSumar = new JButton("Sumar");
        panelCosas = new JPanel();

        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1 = Integer.parseInt(num1.getText()+"");
                int n2 = Integer.parseInt(num2.getText()+"");
                //JOptionPane.showMessageDialog(null, (n1+n2)+"");                
                JOptionPane.showMessageDialog(null, String.valueOf(n1+n2));
            }
        });


        panelCosas.add(num1);
        panelCosas.add(num2);
        panelCosas.add(btnSumar);
        add(panelCosas);
    }

    public static void main(String[] args) {
        SumaDosNumeros sdn = new SumaDosNumeros();
        sdn.setVisible(true);
    }

}