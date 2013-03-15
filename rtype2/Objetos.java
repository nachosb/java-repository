import java.awt.*;
/**
 * Clase abstracta Objetos - Se usará como molde para los distintos objetos (naves, misiles, etc...)
 * que se usan en el juego
 * 
 * @author: Juan Ignacio Solís Blázquez
 * Date: 2013-03-14
 */
public abstract class Objetos
{
    // Variables para indicar la posición en el eje horizontal x y el eje vertical y
    protected int x, y;
    
    // Variables para indicar el ancho y el alto del icono del objeto
    protected int alto, ancho;
    
    // variable para indicar el ancho y alto maximo de la resolucion 
    protected int maxX, maxY;

    /**
     * Método que devuelve la posición en el eje horizontal
     * 
     * @return Posicion en el eje x que ocupa el objeto
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Método que informa la posición en el eje horizontal
     * 
     * @param Posicion en el eje x a informar
     */
    public void setX(int x)
    {
        this.x = x;
    }
    
    /**
     * Método que devuelve la posición en el eje vertical
     * 
     * @return Posicion en el eje y que ocupa el objeto
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Método que informa la posición en el eje vertical
     * 
     * @param Posicion en el eje y a informar
     */
    public void setY(int y)
    {
        this.y = y;
    }
    
    /**
     * Método que devuelve la dimensión (rectángulo) que ocupa el objeto
     * 
     * @return Rectángulo que ocupa el objeto
     */
    public Rectangle getDimension()
    {
        return new Rectangle(x, y, ancho, alto);
    }
    
    /**
     * Método que devuelve el ancho del objeto
     * 
     * @return ancho del objeto
     */
    public int getAncho()
    {
        return ancho;
    }
    
    /**
     * Método que informa el ancho del objeto
     * 
     * @param ancho del objeto
     */
    public void setAncho(int ancho)
    {
        this.ancho = ancho;
    }
    
    /**
     * Método que devuelve el alto del objeto
     * 
     * @return alto del objeto
     */
    public int getAlto()
    {
        return alto;
    }
    
    /**
     * Método que informa el alto del objeto
     * 
     * @param alto del objeto
     */
    public void setAlto(int alto)
    {
        this.alto = alto;
    }
    
    /**
     * Método que devuelve el ancho máximo
     * 
     * @return ancho maximo de la resolucion
     */
    public int getMaxX()
    {
        return maxX;
    }
    
    /**
     * Método que informa el ancho máximo
     * 
     * @param ancho maximo de la resolucion
     */
    public void setMaxX(int anchoMaximo)
    {
        maxX = anchoMaximo;
    }
    
    /**
     * Método que devuelve el alto máximo
     * 
     * @return alto maximo de la resolucion
     */
    public int getMaxY()
    {
        return maxY;
    }
    
    /**
     * Método que informa el alto máximo
     * 
     * @param alto maximo de la resolucion
     */
    public void setMaxY(int altoMaximo)
    {
        maxY = altoMaximo;
    }
}
