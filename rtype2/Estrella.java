/**
 * Clase para instanciar objetos tipo estrella que se moveran por el fondo de la pantalla de juego
 * para dar la impresión de que la nave se mueve.
 * 
 * @author Juan Ignacio Solís Blázquez 
 * @version 0.1
 */
public class Estrella extends Objetos
{
    // radio en pixeles de la estrella
    private int radio;
    
    /**
     * Constructor de objectos de la clase Estrellas
     */
    public Estrella(int ancho, int alto, int radio)
    {
        this.radio = radio;
        maxX = ancho;
        maxY = alto;
        
        // dentro del ancho y el alto, posicionaremos al azar la estrella
        this.x = (int) (Math.random() * maxX);
        this.y = (int) (Math.random() * maxY);        
    }
    
    /**
     * Metodo que devuelve el radio
     * 
     * @ return radio de la estrella
     */
    public int getRadio()
    {
        return radio;
    }
    
    /**
     * Metodo que permite modificar el radio
     * 
     * @ return radio de la estrella
     */
    public void setRadio(int radio)
    {
        this.radio = radio;
    }
}
