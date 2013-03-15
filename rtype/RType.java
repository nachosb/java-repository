import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase generadora del juego R-Type.
 * 
 * @author Juan Ignacio Solís Blázquez. 
 * @version 2013-03-12
 */
public class RType
{
    // Pantalla del juego
    JFrame pantalla;
    
    // Panel del menu inicial
    PantallaInicial pantallaInicial;
    
    // Panel del juego
    Tablero juego;
    
    // Guardamos la dimensión de la pantalla donde se está ejecutando la aplicación
    Dimension dim;
   
    /**
     * Constructor de la clase RType
     */
    public RType()
    {
        // generamos la pantalla
        pantalla = new JFrame();
        
        // Indicamos que al presionar el botón de salida de la pantalla se destruya la pantalla
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Damos Título a la pantalla
        pantalla.setTitle("R-Type");
        
        //Marcamos la pantalla para evitar que se modifique su tamaño
        pantalla.setResizable(false);
        
        pantallaInicial();        
    }
    
    /**
     * Método que implementa la pantalla inicial
     */
    public void pantallaInicial()
    {
        // Ponemos la pantalla como no visible
        pantalla.setVisible(false);
        
        // Eliminamos el campo de pantalla inicial en el caso de que este activo
        if (juego != null)
        {
            pantalla.remove(juego);
        }
        // Liberamos memoria de la pantalla
        pantalla.dispose();
        
        // Damos tamaño a la pantalla
        pantalla.setSize(500, 500);

        // creamos el panel del menu principal
        pantallaInicial = new PantallaInicial(this);
        
        // añadimos el panel del menu principal a la pantalla
        pantalla.add(pantallaInicial);
        
        // Calculamos la dimensión de la pantalla en la que estamos ejecutando la aplicación
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Colocamos la pantalla en el centro del area visible de la pantalla donde estamos ejecutando
        pantalla.setLocation(dim.width/2-pantalla.getSize().width/2, dim.height/2-pantalla.getSize().height/2);
        
        // Hacemos la pantalla visible        
        pantalla.setVisible(true);
        
    }
    
    
    /**
     * Método que implementa el juego con el nivel seleccionado
     */
    public void jugar(int dificultad)
    {
        pantalla.setVisible(false);
        pantalla.remove(pantallaInicial);
        pantalla.dispose();
        juego = new Tablero(800, 600, dificultad, this);
        pantalla.add(juego);    
        pantalla.setSize(800, 600);
        pantalla.setLocation(dim.width/2-pantalla.getSize().width/2, dim.height/2-pantalla.getSize().height/2);
        pantalla.setVisible(true);
    }
    
    /**
     * Método principal
     */
    public static void main(String[] args)
    {
        new RType();
    }
}
