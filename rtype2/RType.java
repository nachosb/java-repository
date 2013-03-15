import javax.swing.*;
import java.awt.*;
/**
 * Clase principal del juego R-Type.
 * Instancia un objeto pantalla incial que solicita al usuario que introduzca la dificultad
 * Instancia un objeto juego para jugar con la dificultad solicitada anteriormente
 * 
 * @author Juan Ignacio Solís Blázquez 
 * @version 0.1
 */
public class RType extends JFrame
{
    // Resolución por defecto
    private int ancho, alto;

    /**
     * Constructor de la clase RType
     */
    public RType()
    {
        ancho = 800;
        alto = 600;
        
        // Ponemos la localización relativa a null
        setLocationRelativeTo(null);
        
        // Ejecutamos el método que genera la pantalla inicial al crear el objeto
        pantallaInicial();
    }

    /**
     * Método que muestra en la pantalla el panel de la ventana de bienvenida o inicial
     * 
     */

    public void pantallaInicial()
    {        
        // Borramos todo lo que contenga esta ventana
        getContentPane().removeAll();
        
        // Realizamos validacion de la ventana
        getContentPane().validate();

        // Liberamos recursos de la ventana
        dispose();
        
        // Añadimos el panel de la ventana inicial
        add(new VentanaInicial(this, ancho, alto));

        // Indicamos que se elimine el objeto ventana en caso de cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Evitamos que puedan cambiar el tamaño de la pantalla
        setResizable(false);

        // Ajustamos la pantalla al tamaño del panel de la ventana inicial
        pack();

        // Hacemos visible la pantalla
        setVisible(true);
    }

    /**
     * Método que muestra en la pantalla el panel de la ventana de bienvenida o inicial
     * 
     * @param Dificultad del juego seleccionada
     */

    public void pantallaJuego(int nivel, int ancho, int alto)
    {   
        this.ancho = ancho;
        this.alto = alto;
        
        // Borramos todo lo que contenga esta ventana
        getContentPane().removeAll();
        
        // Realizamos validacion de la ventana
        getContentPane().validate();

        // Liberamos recursos de la ventana
        dispose();
        
        // Añadimos el panel de juego a la ventana
        add(new VentanaJuego(this, nivel, ancho, alto));
        
        // La pantalla del juego se ajusta a la resolución devuelta por la instancia de la ventana inicial
        setSize(ancho, alto);

        // Hacemos visibles los cambios
        setVisible(true);
    }

    /**
     * Método main del juego R-Type
     * 
     * @param  args argumentos iniciales del programa
     */
    public static void main(String[] args)
    {
        new RType();
    }
    
    /**
     * Método para modificar el ancho
     * 
     * @param ancho de la ventana
     */
    public void setAncho(int ancho)
    {
        this.ancho = ancho;
    }
    
    /**
     * Método para modificar el alto
     * 
     * @param alto de la ventana
     */
    public void setAlto(int alto)
    {
        this.alto = alto;
    }
    
}
