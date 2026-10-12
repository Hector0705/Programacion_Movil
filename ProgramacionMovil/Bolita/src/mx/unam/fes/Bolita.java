package mx.unam.fes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bolita extends JPanel {

    int x, y;
    Image imgFondo;
    Image imgCursor;

    public Bolita() {
        setSize(450, 430);
        x = 50;
        y = 50;

        imgFondo = cargarImagen("batman.jpg");

        imgCursor = cargarImagen("bolita.png");

        if (imgCursor != null) {
            imgCursor = imgCursor.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        }

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (imgCursor != null) {
                    x = e.getX() - (imgCursor.getWidth(null) / 2);
                    y = e.getY() - (imgCursor.getHeight(null) / 2);
                    repaint();
                }
            }
        };

        addMouseMotionListener(mouse);
    }

    private Image cargarImagen(String nombreArchivo) {
        String rutaInterna = "/mx/unam/fes/imagenes/" + nombreArchivo;
        URL urlImagen = getClass().getResource(rutaInterna);

        if (urlImagen != null) {
            return new ImageIcon(urlImagen).getImage();
        } else {
            System.err.println("Error: No se encontró la imagen en " + rutaInterna);
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imgFondo != null) {
            g.drawImage(imgFondo, 0, 0, getWidth(), getHeight(), this);
        } else {
            setBackground(Color.DARK_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        if (imgCursor != null) {
            g.drawImage(imgCursor, x, y, this);
        }
    }
}

class Ventana extends JFrame {

    public Ventana() {
        setSize(450, 430);
        setTitle("Bolita");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Bolita bolita = new Bolita();
        add(bolita);
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}