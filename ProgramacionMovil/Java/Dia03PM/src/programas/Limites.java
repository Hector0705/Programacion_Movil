package programas;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Limites extends JFrame{
    JButton btnRojo, btnVerde,  btnAzul;
    JPanel panelPintar;

    public Limites(){
        setTitle("GridLayout");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        btnRojo = new JButton("rojo");
        btnRojo.setBounds(10,10,60,60);

        btnRojo.addActionListener(ActionEvent -> {
            panelPintar.setBackground(Color.red);
        });

        btnAzul = new JButton("azul");
        btnAzul.setBounds(150,300, 100, 50);

        btnAzul.addActionListener(ActionEvent -> {
            panelPintar.setBackground(Color.blue);
        });

        btnVerde = new JButton("verde");
        btnVerde.setBounds(150,150, 100, 50);

        btnVerde.addActionListener(ActionEvent -> {
            panelPintar.setBackground(Color.green);
        });

        panelPintar = new JPanel();
        panelPintar.setBackground(Color.yellow);
        panelPintar.setBounds(150, 200, 80, 80);

        add(btnRojo);
        add(btnVerde);
        add(btnAzul);
        add(panelPintar);
    }

    public static void main(String[] args) {
        Limites l = new Limites();
        l.setVisible(true);
    }
}
