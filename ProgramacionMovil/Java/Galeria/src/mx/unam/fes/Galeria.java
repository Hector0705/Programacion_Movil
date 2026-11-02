package mx.unam.fes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.net.URL;

public class Galeria extends JFrame {
    JButton btnAtras, btnAdelante, btnPlay;
    JPanel panelBotones, panelImagen;
    ImageIcon[] imagenes;
    String[] titulos; // Arreglo para los títulos
    int imagenActual;
    JLabel etiquetaImagen, etiquetaTitulo;

    Timer timer;
    boolean reproduciendo;

    public Galeria() {
        setTitle("Galeria de Hector Gonzalez");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelBotones = new JPanel();
        panelImagen = new JPanel();
        btnAtras = new JButton("Atras");
        btnAdelante = new JButton("Adelante");
        btnPlay = new JButton("Reproducir");

        imagenes = new ImageIcon[10];
        titulos = new String[10];

        imagenes[0] = cargarImagen("nombre.jpeg");
        titulos[0] = "Mi Nombre";

        imagenes[1] = cargarImagen("aot.jpeg");
        titulos[1] = "Attack on Titan";

        imagenes[2] = cargarImagen("batman.jpg");
        titulos[2] = "Batman";

        imagenes[3] = cargarImagen("berserk-4k-3q.jpg");
        titulos[3] = "Berserk";

        imagenes[4] = cargarImagen("breakingbad.jpg");
        titulos[4] = "Breaking Bad";

        imagenes[5] = cargarImagen("FLASH.jpg");
        titulos[5] = "The Flash";

        imagenes[6] = cargarImagen("GOT.jpeg");
        titulos[6] = "Game of Thrones";

        imagenes[7] = cargarImagen("inven.jpg");
        titulos[7] = "Invincible";

        imagenes[8] = cargarImagen("ita.jpeg");
        titulos[8] = "Itachi";

        imagenes[9] = cargarImagen("mika.jpg");
        titulos[9] = "Mikasa";

        etiquetaImagen = new JLabel();
        panelImagen.add(etiquetaImagen);

        etiquetaTitulo = new JLabel("", SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 22));

        mostrarImagen();

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagenActual == 0) {
                    imagenActual = 9;
                } else {
                    imagenActual--;
                }
                mostrarImagen();
            }
        });

        btnAdelante.addActionListener(e -> {
            if (imagenActual == 9) {
                imagenActual = 0;
            } else {
                imagenActual++;
            }
            mostrarImagen();
        });

        btnPlay.addActionListener(e -> {
            if (!reproduciendo) {
                btnPlay.setText("Detener");
                reproduciendo = true;
                timer.start();
            } else {
                btnPlay.setText("Reproducir");
                reproduciendo = false;
                timer.stop();
            }
        });

        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagenActual == 9) {
                    imagenActual = 0;
                } else {
                    imagenActual++;
                }
                mostrarImagen();
            }
        });

        panelBotones.add(btnAtras);
        panelBotones.add(btnAdelante);
        panelBotones.add(btnPlay);

        // Agregar los componentes a la ventana
        add(etiquetaTitulo, BorderLayout.NORTH);
        add(panelImagen, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private ImageIcon cargarImagen(String nombreArchivo) {
        String rutaInterna = "/mx/unam/fes/imagenes/" + nombreArchivo;
        URL urlImagen = getClass().getResource(rutaInterna);

        if (urlImagen != null) {
            return new ImageIcon(urlImagen);
        } else {
            System.err.println("Error: No se encontró la imagen en la ruta " + rutaInterna);
            return new ImageIcon();
        }
    }

    public void mostrarImagen() {
        ImageIcon icono = imagenes[imagenActual];

        if (icono != null && icono.getImageLoadStatus() != java.awt.MediaTracker.ERRORED && icono.getIconWidth() > 0) {
            Image imagen = icono.getImage();
            Image imagenEscalada = imagen.getScaledInstance(
                    400,
                    400,
                    Image.SCALE_SMOOTH
            );
            etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
        } else {
            etiquetaImagen.setIcon(null);
        }

        etiquetaTitulo.setText(titulos[imagenActual]);
    }

    public static void main(String[] args) {
        Galeria g = new Galeria();
        g.setVisible(true);
    }
}