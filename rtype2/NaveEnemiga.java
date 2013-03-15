import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
/**
 * Clase para instanciar las naves enemigas controladas por el ordenador.
 * 
 * @author Juan Ignacio Solís Blázquez 
 * @version 0.1
 */
public class NaveEnemiga extends Objetos
{
    // Imagen de la nave
    private Image imagen;

    // Tipo de nave creada
    private char tipo;

    // Valores del tamaño de la nave
    private int anchoNave, altoNave;

    /**
     * Constructor de objetos de la clase NaveEnemiga
     */
    public NaveEnemiga(int ancho, int alto, char tipo)
    {
        this.tipo = tipo;
        maxX = ancho; 
        maxY = alto;

        // Obtenemos la imagen que aparece en la pantalla inicial
        obtenerImagen();

        this.x = maxX + (int) (Math.random() * maxX * 0.25f);
        this.y = (int) (Math.random() * maxY);
        
        System.out.println(y);

        if (y > alto - altoNave)
        {
            y -= altoNave * 2;
        }
    }

    /**
     * Método para obtener la imagen de la nave
     */
    private void obtenerImagen()
    {
        ImageIcon icon;
        if (tipo == 'A')
        {
            icon = new ImageIcon("enemigoA.png");
        } else {
            icon = new ImageIcon("enemigob.png");
        }

        if (icon.getImageLoadStatus()  == MediaTracker.ERRORED) {
            imagen = null;
            altoNave = 0;
            anchoNave = 0;
        } else {
            imagen = icon.getImage();
            altoNave = icon.getIconHeight();
            anchoNave = icon.getIconWidth();
        }
    }
    /**
     * Método para obtener la imagen asociada a la nave
     */    
    public Image getImagen()
    {
        return imagen;    
    }
}
