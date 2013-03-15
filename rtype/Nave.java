import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Clase que implementa la nave espacial que controla el jugador.
 * 
 * @author Juan Ignacio Solís Blázquez 
 * @version 2013-03-12
 */
public class Nave
{
    private int x; // posición de la nave en el eje x
    private int y; // posición de la nave en el eje y
    private int dx; // variable que controla el movimiento en el eje x
    private int dy; // variable que controla el movimiento en el eje y
    private Image imagenNave;
    private int anchoNave, altoNave;
    private ArrayList<Misil> misiles; // Array para almacenar los misiles

    /**
     * Constructor de la nave
     */
    public Nave()
    {
        // definimos la imagen de la nave
        ImageIcon ii = new ImageIcon(this.getClass().getResource("nave.png"));
        imagenNave = ii.getImage();
        
        altoNave = ii.getIconHeight();
        anchoNave = ii.getIconWidth(); 
        
        // Damos la posición inicial de la nave
        x = 60;
        y = 360;
        
        // Generamos un array para almacenar los misiles
        misiles = new ArrayList<Misil>();
    }

    /**
     * Método para obtener la posición x actual de la nave
     */
    
    public int getX()
    {
        return x;    
    }
    
    /**
     * Método para obtener la posición y actual de la nave
     */
    
    public int getY()
    {
        return y;    
    }
    
    /**
     * Método para obtener la imagen asociada a la nave
     */
    
    public Image getImagen()
    {
        return imagenNave;    
    }
    
    /**
     * Método que mueve la nave según el valor que tenga el campo dx y dy.
     * 
     * @param  limite de altura del tablero de juego, límite de anchura del tablero de juego
     */
    public void mover(int alto, int ancho)
    {
        // movemos la pantalla según se haya indicado con las teclas pulsadas
        x += dx;
        y += dy;
        
        // la nave no se puede mover fuera de los bordes de la pantalla
        if (x < 0) {x = 0;}
        if (x > (ancho - anchoNave)) {x = (ancho - anchoNave);}
        if (y < 0) {y = 0;}
        if (y > (alto - altoNave * 2) ) {y = (alto - altoNave * 2);}
    }
    
    /**
     * Método de control del pulsado de las teclas
     */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            disparo();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }
    
    /**
     * Método de control de la release de las teclas
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    /**
     * Método que devuelve un objeto rectángulo con la información del espacio ocupado por la nave
     * 
     * @return rectangulo que ocupa la nave
     */
    public Rectangle getRectangulo()
    {
        return new Rectangle(x, y, anchoNave, altoNave);
    }
    
    /**
     * Método que añade un misil al array de misiles
     */
    public void disparo() {
        misiles.add(new Misil(x + anchoNave, y + altoNave/2));
    }

    /**
     * Método que devuelve el array de misiles
     * 
     * @return array con los misiles existentes
     */
    public ArrayList<Misil> getMissiles()
    {
        return misiles;
    }
    
    public void eliminarMisil(int index)
    {
        misiles.remove(index);
    }
    
}
