import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que implementa las naves enemigas.
 * 
 * @author Juan Ignacio Solís Blázquez 
 * @version 2013-03-12
 */
public class NaveEnemiga
{
    private int x, y, altoNave, anchoNave;
    private char tipoNave;
    private Image imagenEnemigo;
    private boolean visible;
    private boolean esPositivo;

    /**
     * Constructor de la clase NaveEnemiga
     */
    public NaveEnemiga(int ancho, int alto, char tipo, int diferencial)
    {
        tipoNave = tipo;

        visible = true;

        if (tipo == 'A')
        {
            //ImageIcon ii = new ImageIcon(this.getClass().getResource("enemigoA.png"));
            ImageIcon ii = new ImageIcon(this.getClass().getResource("enemigoA.png"));
            imagenEnemigo = ii.getImage();
            altoNave = ii.getIconHeight();
            anchoNave = ii.getIconWidth();
        } else {
            ImageIcon ii = new ImageIcon(this.getClass().getResource("enemigoB.png"));
            imagenEnemigo = ii.getImage();
            altoNave = ii.getIconHeight();
            anchoNave = ii.getIconWidth();
        }

        x = ancho - anchoNave - diferencial;
        y = (int) ((Math.random() * (alto - altoNave * 2)));

        // Al crear la nave elegimos al azar la dirección en el eje Y

        esPositivo = (((int) ((Math.random() * 100))) < 50);
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public char getTipoNave()
    {
        return tipoNave;
    }

    /**
     * Método para obtener la imagen asociada a la nave
     */

    public Image getImagen()
    {
        return imagenEnemigo;    
    }

    public void moverX(int velocidad)
    {
        x -= velocidad;
    }

    public void moverY(int velocidad)
    {
        if (esPositivo)
        {
            y += velocidad;
        } else {
            y -= velocidad;
        }
    }

    public Rectangle getRectangulo()
    {
        return new Rectangle(x, y, anchoNave, altoNave);
    }

    public void setVisible(boolean visibilidad)
    {
        visible = visibilidad;
    }

    public boolean getVisible()
    {
        return visible;
    }
}
