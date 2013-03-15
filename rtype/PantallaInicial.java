import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * Clase que genera el JPanel que contiene la informacion que mostrará
 * la ventana inicial del juego.
 * 
 * @author Juan Ignacio Solís Blázquez 
 * @version 2013-03-12
 */
public class PantallaInicial extends JPanel
{
    private JButton botonFacil, botonNormal, botonComplicado, botonImposible;
    private final RType padre;
    private JPanel panelSuperior, panelInferior, panelBotonFacil, panelBotonNormal, panelBotonComplicado, panelBotonImposible;

    /**
     * Constructor para la pantalla Inicial
     */
    public PantallaInicial(RType padreEntrada)
    {
        // Crearemos los paneles necesarios:
        panelSuperior = new JPanel();
        panelInferior = new JPanel();
        panelBotonFacil = new JPanel();
        panelBotonNormal = new JPanel();
        panelBotonComplicado = new JPanel();
        panelBotonImposible = new JPanel();

        // Hacemos focusable el panel inferior
        panelInferior.setFocusable(true);

        // guardamos un apuntador a la clase llamante para poder usar sus métodos
        padre = padreEntrada;

        // Indicamos el formato de los paneles
        this.setLayout(new GridLayout(2, 1));
        panelSuperior.setLayout(new GridLayout(4, 1));
        panelInferior.setLayout(new GridLayout(2, 2));
        panelBotonFacil.setLayout(new GridLayout(1, 1));
        panelBotonNormal.setLayout(new GridLayout(1, 1));
        panelBotonComplicado.setLayout(new GridLayout(1, 1));
        panelBotonImposible.setLayout(new GridLayout(1, 1));

        // bordeamos todos los paneles como un borde vacio
        panelSuperior.setBorder( new EmptyBorder(20, 20, 0, 20));
        panelInferior.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelBotonFacil.setBorder(new EmptyBorder(2, 2, 2, 2));        
        panelBotonNormal.setBorder(new EmptyBorder(2, 2, 2, 2));        
        panelBotonComplicado.setBorder(new EmptyBorder(2, 2, 2, 2));
        panelBotonImposible.setBorder(new EmptyBorder(2, 2, 2, 2));

        // Creamos el texto que aparecerá en la pantalla de bienvenida
        JLabel texto1 = new JLabel("Práctica programación orientada a objetos", JLabel.CENTER);
        texto1.setFont(new Font("Serif", Font.BOLD, 20));
        panelSuperior.add(texto1);



        JLabel texto2 = new JLabel("R-Type", JLabel.CENTER);
        JLabel texto3 = new JLabel("Autor: Juan Ignacio Solís Blázquez");
        JLabel texto4 = new JLabel("Por favor, elija el nivel de dificultad:");

        // Damos formato al texto

        texto2.setFont(new Font("Serif", Font.BOLD, 22));
        texto2.setForeground(Color.RED);
        texto3.setFont(new Font("Serif", Font.ITALIC, 20));
        texto4.setFont(new Font("Serif", Font.ITALIC, 20));

        // Añadidos los campos de texto al panelSuperior
        panelSuperior.add(texto2);
        panelSuperior.add(texto3);
        panelSuperior.add(texto4);

        // Creamos los botones
        botonFacil = new JButton("Facil"); 
        botonNormal = new JButton("Normal");
        botonComplicado = new JButton("Complicado");
        botonImposible = new JButton("Imposible");

        // Evitamos que sean focusables
        botonFacil.setFocusable(false);
        botonNormal.setFocusable(false);
        botonComplicado.setFocusable(false);
        botonImposible.setFocusable(false);

        // Creamos escuchadores de evento para los botones
        botonFacil.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    padre.jugar(1);
                }
            });

        botonNormal.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    padre.jugar(2);
                }
            });

        botonComplicado.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    padre.jugar(3);
                }
            });

        botonImposible.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    padre.jugar(4);
                }
            });

        // Añadimos a cada panel su boton correspondiente
        panelBotonFacil.add(botonFacil);
        panelBotonNormal.add(botonNormal);
        panelBotonComplicado.add(botonComplicado);
        panelBotonImposible.add(botonImposible);

        // Añadimos los paneles de botones al panel inferior.
        panelInferior.add(panelBotonFacil);
        panelInferior.add(panelBotonNormal);
        panelInferior.add(panelBotonComplicado);
        panelInferior.add(panelBotonImposible);

        // Añadimos el panel superior e inferior al panel principal
        this.add(panelSuperior);
        this.add(panelInferior);
    }
}
