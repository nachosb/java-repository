import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Clase que implementa el tablero donde se moveran las naves.
 * 
 * @author Juan Ignacio Solís blázquez 
 * @version 2013/03/12
 */
public class Tablero extends JPanel implements ActionListener
{
    private Timer timer;
    private Image bg;
    private Nave nave;
    private NaveEnemiga naveX;
    private ArrayList<NaveEnemiga> navesEnemigas;
    private ArrayList<Misil> misiles;
    private int alto, ancho;
    private int dificultad, cantidad, velocidad, proporcion;
    private int navesMostradas;
    boolean muerto;
    RType padre;

    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int ancho, int alto, int dificultad, RType padreEntrada)
    {
        // hacemos que el panel sea transparente
        setOpaque(false);       

        muerto = false;

        padre = padreEntrada;

        // Seleccionamos la imagen que hará de fondo
        ImageIcon ii = new ImageIcon(this.getClass().getResource("fondo.png"));
        bg = ii.getImage();

        this.ancho = ancho;
        this.alto = alto;
        this.dificultad = dificultad;

        switch(dificultad)
        {
            case 1:
            cantidad = 10;
            velocidad = 1;
            proporcion = 60;
            break;

            case 2:
            cantidad = 15;
            velocidad = 2;
            proporcion = 50;
            break;

            case 3:
            cantidad = 20;
            velocidad = 3;
            proporcion = 40;
            break;

            default:
            cantidad = 30;
            velocidad = 4;
            proporcion = 30;
            break;
        }

        navesEnemigas = new ArrayList<NaveEnemiga>(cantidad);
        misiles = new ArrayList<Misil>();

        // Creamos la nave espacial controlada por el usaurio
        nave = new Nave();

        // Anadimos las neves enemigas
        anadirNaveEnemiga(cantidad);

        // Generamos un escuchador de teclado
        addKeyListener(new TAdapter());

        //Ponemos el panel como Focusable
        setFocusable(true);

        /// ??? no se para que sirve esto
        setDoubleBuffered(true);

        //timer.start();
        // Posicionamos un timer para ir actualizando el juego
        timer = new Timer(10, this);
        timer.start();
    }

    /**
     * Obtiene el ancho
     */
    public int getAlto()
    {
        return alto;
    }

    public void anadirNaveEnemiga(int cantidad)
    {
        // creamos el array con la cantidad necesaria de naves segun la dificultad solicitada        

        int tipoNum = 0;
        char tipo = ' ';
        int diferencial = 0;

        for (int i = 0; i < cantidad; i++)
        { 

            if (i % 3 == 0)
            {
                tipoNum = (int) ((Math.random() * 100));

                diferencial = 0;
            }

            if (tipoNum < proporcion) {
                tipo = 'A';
            } else {
                tipo = 'B';
            }
            navesEnemigas.add(new NaveEnemiga(ancho, alto, tipo, diferencial));

            diferencial += 30;
        }
    }

    /**
     * Obtiene el ancho
     */
    public int getAncho()
    {
        return ancho;
    }

    @Override
    public void paintComponent(Graphics g) {        
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

        g.drawImage(nave.getImagen(), nave.getX(), nave.getY(), this);

        for(NaveEnemiga naveEnemiga:navesEnemigas)
        {
            g.drawImage(naveEnemiga.getImagen(), naveEnemiga.getX(), naveEnemiga.getY(), this);
        }

        misiles = nave.getMissiles();

        for(Misil misil:misiles)
        {
            g.drawImage(misil.getImagen(), misil.getX(), misil.getY(), this);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        nave.mover(alto, ancho);

        for (int indNaveEnemiga = 0; indNaveEnemiga < navesEnemigas.size(); indNaveEnemiga++) {
            NaveEnemiga auxNE = (NaveEnemiga) navesEnemigas.get(indNaveEnemiga);

            for (int indMisil = 0; indMisil < misiles.size(); indMisil++) {
                Misil auxMi = (Misil) misiles.get(indMisil);
                if (auxMi.getRectangulo().intersects(auxNE.getRectangulo()) == true) 
                {
                    nave.eliminarMisil(indMisil); 
                    navesEnemigas.remove(indNaveEnemiga);
                    break;
                }  
            }
        }  

        for (int indMisil = 0; indMisil < misiles.size(); indMisil++) {
            Misil auxMi = (Misil) misiles.get(indMisil);
            auxMi.mover(4);

            if (auxMi.getX() > ancho)
            {
                nave.eliminarMisil(indMisil);
            }
        }

        for(NaveEnemiga naveEnemiga:navesEnemigas)
        {            
            if (naveEnemiga.getTipoNave() == 'B')
            {
                naveEnemiga.moverX(velocidad + 1);
                naveEnemiga.moverY(velocidad);

                if (naveEnemiga.getY() < 0)
                {
                    naveEnemiga.setY(alto);
                }

                if (naveEnemiga.getY() > alto)
                {
                    naveEnemiga.setY(0);
                }
            } else {
                naveEnemiga.moverX(velocidad);
            }

            if (naveEnemiga.getX() <= 0)
            {
                naveEnemiga.setX(ancho);
            }

            if (naveEnemiga.getRectangulo().intersects(nave.getRectangulo()) == true)
            {
                muerto = true;
            }

        }
        repaint();  
        if (muerto)
        {
            timer.stop();

            JOptionPane.showMessageDialog(null,"La Cagaste Burlancaster", "Dedicado a Julian!!!", JOptionPane.INFORMATION_MESSAGE);

            padre.pantallaInicial();
        }

        if (navesEnemigas.isEmpty())
        {
            timer.stop();

            JOptionPane.showMessageDialog(null,"Eres el mejor!!!!!", "Dedicado a Julian!!!", JOptionPane.INFORMATION_MESSAGE);

            padre.pantallaInicial();
        }

    }
    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            nave.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            nave.keyPressed(e);
        }
    }
}