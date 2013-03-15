import javax.swing.*;
import java.awt.*;
/**
 * Clase que implementa los objetos del juego.
 * 
 * @author Juan Ignacio Solís Blázquez 
 * @version 2013-03-12
 */
public class Misil
{
    private int x, y; // posición del misil;
    private int altoMisil, anchoMisil; // alto y ancho del icono del misil
    private Image imagenMisil; // imagen del misil
    boolean visible;


    /**
     * Constructor de la clase misil
     */
    public Misil(int inicioX, int inicioY)
    {
        // posicion inicial del misil que debe coincidir con la posicion de la nave
        x = inicioX;
        y = inicioY;
        
        // Marcamos como visible al crear el misil
        visible = true;
        
        // definimos la imagen de la nave
        ImageIcon ii = new ImageIcon(this.getClass().getResource("misil.png"));
        imagenMisil = ii.getImage();
        
        altoMisil = ii.getIconHeight();
        anchoMisil = ii.getIconWidth(); 
    }

    /**
     * Método para mover el misil
     * El misil sólo avanza en horizontal
     * 
     * @param  velocidad velocidad de movimiento del misil
     */
    public void mover(int velocidad)
    {
        x += velocidad;
    }
    
    /**
     * Método que devuelve la posicion horizontal del misil
     * 
     * @return  x posición horizontal del misil
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Método que devuelve la posicion verticual del misil
     *
     * @return y posición vertical del misil
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Método que devuelve el rectángulo que ocupa el misil
     *
     * @return rectángulo que ocupa el misil
     */
    public Rectangle getRectangulo()
    {
        return new Rectangle(x, y, anchoMisil, altoMisil);
    }

    /**
     * Método para obtener la imagen asociada a la nave
     */
    
    public Image getImagen()
    {
        return imagenMisil;    
    }
    
    /**
     * Método para obtener la imagen asociada a la nave
     */
    
    public boolean getVisible()
    {
        return visible;    
    }
    
    /**
     * Método para obtener la imagen asociada a la nave
     */
    
    public void setVisible(boolean tipoVisible)
    {
        visible = tipoVisible;    
    }
}
