package mx.unam.fes;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JFrame {
    JComboBox<String> comboColores;
    JPanel panelDibujo, panelSuperior;
    JButton btnLimpiar;

    BufferedImage imagen;
    Image imagenFondo;
    Graphics2D g2;

    int xAnterior, yAnterior;

    public Dibujo() {
        setTitle("Paint");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        comboColores = new JComboBox<>();
        comboColores.addItem("Rojo");
        comboColores.addItem("Verde");
        comboColores.addItem("Azul");

        btnLimpiar = new JButton("Limpiar");

        panelSuperior = new JPanel();
        panelSuperior.add(comboColores);
        panelSuperior.add(btnLimpiar);

        add(panelSuperior, BorderLayout.NORTH);

        try {
            imagenFondo = ImageIO.read(Objects.requireNonNull(getClass().getResource("/mx/unam/fes/imagen/img.png")));
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen de fondo: " + e.getMessage());
        }

        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), null);
                }

                g.drawImage(imagen, 40, 10, null);
            }
        };
        panelDibujo.setBackground(Color.yellow);

        imagen = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        g2 = imagen.createGraphics();

        g2.setColor(Color.red);

        comboColores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int colorSeleccionado = comboColores.getSelectedIndex();
                switch (colorSeleccionado) {
                    case 0: g2.setColor(Color.red); break;
                    case 1: g2.setColor(Color.green); break;
                    case 2: g2.setColor(Color.blue); break;
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g2.setComposite(AlphaComposite.Clear);
                g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());

                g2.setComposite(AlphaComposite.SrcOver);

                panelDibujo.repaint();
            }
        });

        panelDibujo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                xAnterior = e.getX() - 40;
                yAnterior = e.getY() - 10;
            }
        });

        panelDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() - 40;
                int y = e.getY() - 10;

                g2.drawLine(xAnterior, yAnterior, x, y);

                xAnterior = x;
                yAnterior = y;

                panelDibujo.repaint();
            }
        });

        add(panelDibujo, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Dibujo d = new Dibujo();
        d.setVisible(true);
    }
}
