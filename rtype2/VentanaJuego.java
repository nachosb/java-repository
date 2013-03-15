import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Clase panel de swing donde se jugará el juego R-Type.
 * 
 * @author Juan Ignacio Solís Blázquez
 * @version 0.1
 */
public class VentanaJuego extends JPanel
{
    // Arrays necesarios para las estrellas, naves enemigas y misiles
    private ArrayList<Estrella> estrellas;
    private ArrayList<NaveEnemiga> navesEnemigas;

    // variables para almacenar el nivel de dificultad, el número de estrellas, el alto y ancho de la resolucion
    private int nivel, ancho, alto, numEstrellas;

    // Numero de naves por nivel de dificultad (sin dificultad, facil, normal, complidado, imposible)
    private int[] arrNaves = { 0, 10, 15, 20, 30 };

    // Timer que nos permite actualizar el juego cada x microsegundos
    private Timer timer;

    /**
     * Constructor de la clase VentanaJuego
     */
    public VentanaJuego(RType ventanaPadre, int nivel, int ancho, int alto)
    {
        this.nivel = nivel;
        this.ancho = ancho;
        this.alto = alto;
        numEstrellas = (int) (ancho / 5);

        setPreferredSize(new Dimension (ancho, alto));
        setBackground(Color.BLACK);

        // Activamos el buffer doble para mejorar la cantidad de memoria usada y con ello la velocidad y la suavidad de los movimientos
        setDoubleBuffered(true);

        generarEstellas();

        generarNaves();

        timer = new Timer(20, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    moverHorizontal();
                    repaint();
                }
            });

        timer.start();
    }

    /**
     * Método que generará y cargará estrellas en un array de estrellas
     * 
     */
    private void generarEstellas()
    {
        //hay 3 clases de estrellas según su diametro (80% serán de diametro 2, 15% diametro 4 y un 5% diametro 6
        estrellas = new ArrayList<Estrella>();

        int tipo1 = (int) (numEstrellas * 0.80f);
        int tipo2 = (int) (numEstrellas * 0.15f);
        int tipo3 = (int) (numEstrellas * 0.05f);
        int diametro = 0;

        for (int i = 0; i < numEstrellas; i++ ) {
            if (i <= tipo1) {
                diametro = 2;
            } else if (i <= tipo2){
                diametro = 3;
            } else {
                diametro = 5;
            }
            estrellas.add(new Estrella(ancho, alto, diametro));
        }
    }

    /**
     * Método que generará y cargará las naves enemigas segun la dificultad elegida
     * 
     */
    private void generarNaves()
    {
        // Tipo de nave enemiga
        char tipo = ' ';
        boolean solapamiento = true;

        //hay 2 clases de naves se elegirán en grupos de 5 alternativamente
        navesEnemigas = new ArrayList<NaveEnemiga>();

        for (int i = 0; i < arrNaves[nivel]; i++ ) {
            if (i % 5 == 0) {
                if (tipo == ' ' || tipo == 'B') {
                    tipo = 'A';
                } else {
                    tipo = 'B';
                }
            }            
            navesEnemigas.add(new NaveEnemiga(ancho, alto, tipo));
            
            if (navesEnemigas.get(i).getImagen() == null) {
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen de las naves enemigas", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }

    }

    /**
     * Método para pintar en la pantalla los objetos
     */
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;

        // Indicamos que el color de las estrellas será blanco
        g.setColor(Color.WHITE);

        for (Estrella estrella:estrellas)
        {
            g.fillOval( estrella.getX(), estrella.getY(), estrella.getRadio(), estrella.getRadio() );
        }

        g.setColor(null);

        for (NaveEnemiga naveEnemiga:navesEnemigas)
        {
            g.drawImage(naveEnemiga.getImagen(), naveEnemiga.getX(), naveEnemiga.getY(), this);
        }

        // liberamos memoria del buffer
        g.dispose();

        // Sincronizamos con la tasa de refresco del sistema
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Método para mover en horizontal (estrellas, misiles y naves enemigas)
     */
    private void moverHorizontal()
    {
        moverEstrellas(1);

        moverNaves(2);
    }

    /**
     * Método para mover las estrellas
     */
    private void moverEstrellas(int velocidad)
    {
        for (Estrella estrella:estrellas)
            if (estrella.getX() - velocidad < 0)
            {
                estrella.setX(ancho);
            } else {
                estrella.setX(estrella.getX() - velocidad);
        }
    }

    /**
     * Método para mover las estrellas
     */
    private void moverNaves(int velocidad)
    {
        for (NaveEnemiga naveEnemiga:navesEnemigas)
            if (naveEnemiga.getX() - velocidad < 0)
            {
                naveEnemiga.setX(ancho);
            } else {
                naveEnemiga.setX(naveEnemiga.getX() - velocidad);
        }
    }
}
