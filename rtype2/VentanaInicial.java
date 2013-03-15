import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
/**
 * Clase panel de swing que mostrará la información de bienvenida o inicial
 * 
 * @author Juan Ignacio Solís Blázquez
 * @version 0.1
 */
public class VentanaInicial extends JPanel
{
    // Botones a utilizar para seleccionar la dificultad
    private JButton btFacil, btNormal, btComplicado, btImposible;

    // Paneles a utilizar para poner el texto y los botones
    private JPanel panelSuperior, panelInferior, panelBotones, panelSelResolucion;

    // Paneles de botones nos permite poner un borde vacio
    private JPanel pBoton1, pBoton2, pBoton3, pBoton4;

    // Apuntador a la clase llamante
    private RType framePadre;

    // Areas de etiquetas de texto
    private JLabel labelTitulo, labelIcono, labelSelDif, labelCreador, labelSelResolucion;

    // Dimensión del juego en ancho y alto
    private int ancho, alto;

    // Imagen de portada
    private BufferedImage imagen;

    // Combo que permitirá elegir la resolucion
    private JComboBox<String> listaResoluciones;
    
    // arraylist de resoluciones posible
    private ArrayList<String> resoluciones;

    /**
     * Constructor de la clase VentanaInicial
     * 
     * @ param RType de llamada, ancho y alto actual
     */
    public VentanaInicial(RType pantallaPadre, int ancho, int alto)
    {
        this.ancho = ancho;
        this.alto = alto;

        // inicializamos el arraylist de resoluciones
        resoluciones = new ArrayList<String>();
        
        resoluciones.add("800x600");
        resoluciones.add("1024x768");
        resoluciones.add("1200x1024");
        resoluciones.add("1366x768");
        
        // Aceptamos y guardamos el JFrame que ha llamado a este panel para poder usar su metodos publicos
        framePadre = pantallaPadre;

        // Establecemos el layout de este panel (dos filas y una columna
        setLayout(new GridLayout(2,1));

        // Ponemos el panel como focusable
        setFocusable(true);

        // Creamos los botones, paneles y etiquetas necesarias
        crearObjetos();

        // Obtenemos la imagen que aparece en la pantalla inicial
        obtenerImagen(); 

        // Añadimos la etiqueta del título al panel
        panelSuperior.add(labelTitulo, BorderLayout.NORTH);

        // Añadimos el dibujo
        panelSuperior.add(labelIcono, BorderLayout.CENTER);

        // Añadimos la etiqueta de creador
        panelSuperior.add(labelCreador, BorderLayout.SOUTH);

        // Añadimos los botones al panel
        añadirBotones(panelBotones);

        // Añadimos la etiqueta de selección de dificultad
        panelInferior.add(labelSelDif);

        // Añadimos el panel de los botones en el final de este panel
        panelInferior.add(panelBotones);

        // Añadimos al ultimo panel la selección de la resolucion
        panelSelResolucion.add(labelSelResolucion);
        panelSelResolucion.add(listaResoluciones);

        panelInferior.add(panelSelResolucion);

        // Añadimos los paneles
        add(panelSuperior);
        add(panelInferior);
    }

    /**
     * Método para obtener la imagen de portada
     */

    private void obtenerImagen()
    {
        ImageIcon icono = new ImageIcon("nave_inicial.jpg");

        if (icono.getImageLoadStatus()  == MediaTracker.ERRORED) {
            JOptionPane.showMessageDialog(this, "Error al cargar la imagen inicial", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        labelIcono = new JLabel("", icono, JLabel.CENTER);
    }

    /**
     * Método de creación de objetos necesarios
     */
    private void crearObjetos()
    {
        // Creamos los paneles
        panelSuperior = new JPanel();
        panelInferior = new JPanel();
        panelSelResolucion = new JPanel();
        pBoton1 = new JPanel();
        pBoton2 = new JPanel();
        pBoton3 = new JPanel();
        pBoton4 = new JPanel();

        //ponemos layout a los paneles de boton 
        pBoton1.setLayout(new BorderLayout());
        pBoton2.setLayout(new BorderLayout());
        pBoton3.setLayout(new BorderLayout());
        pBoton4.setLayout(new BorderLayout());

        // Ponemos los layout de ambos paneles como BorderLayout
        panelSuperior.setLayout(new BorderLayout());
        panelInferior.setLayout(new GridLayout(3,1));

        // Creamos el panel para añadir los botones
        panelBotones = new JPanel();

        // Ponemos el layout para el panel de los botones como gridlayout
        panelBotones.setLayout(new GridLayout(2, 2));

        // Creamos la etiqueta del título
        labelTitulo = new JLabel("Prácticas de Programación Orientada a Objetos", JLabel.CENTER);

        // Creamos un borde vacio alrededor de la etiqueta
        labelTitulo.setBorder(new EmptyBorder(20,20,20,20));

        // Rodeamos cada panel de boton de un borde
        pBoton1.setBorder(new EmptyBorder(6, 6, 6, 6));
        pBoton2.setBorder(new EmptyBorder(6, 6, 6, 6));
        pBoton3.setBorder(new EmptyBorder(6, 6, 6, 6));
        pBoton4.setBorder(new EmptyBorder(6, 6, 6, 6));

        // Le damos formato al texto
        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 16));

        labelSelDif = new JLabel("Por favor, seleccione la dificultad", JLabel.CENTER);

        labelCreador = new JLabel("Autor: Juan Ignacio Solís Blázquez", JLabel.CENTER);

        labelSelResolucion = new JLabel("Elija la resolucion:");

        listaResoluciones = new JComboBox<String>();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        if (dim.width >= 800 && dim.height >= 600)
        {
            listaResoluciones.addItem("800x600");
        } 
        
        if (dim.width >= 1024 && dim.height >= 768) {
            listaResoluciones.addItem("1024x768");
        } 
        
        if (dim.width >= 1200 && dim.height >= 1024) {
            listaResoluciones.addItem("1200x1024");
        } 
        
        if (dim.width >= 1366 && dim.height >= 768) {
            listaResoluciones.addItem("1366x768");
        }
        
        listaResoluciones.setSelectedIndex(0);

        listaResoluciones.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){
                    if (listaResoluciones.getSelectedItem().toString().equals("800x600")) {
                        framePadre.setAncho(800);
                        framePadre.setAlto(600);
                        ancho = 800;
                        alto = 600;
                    } else if(listaResoluciones.getSelectedItem().toString().equals("1024x768")) {
                        framePadre.setAncho(1024);
                        framePadre.setAlto(768);
                        ancho = 1024;
                        alto = 768;
                    } else {
                        framePadre.setAncho(1200);
                        framePadre.setAlto(1024);
                        ancho = 1200;
                        alto = 1024;
                    }
                }
            });

        // Creamos los botones necesarios
        crearBotones();
    }

    /**
     * Crea los 4 botones necesarios para la selección del nivel de dificultad
     */
    private void crearBotones()
    {
        btFacil = new JButton("Facil");
        btNormal = new JButton("Normal");
        btComplicado = new JButton("Complicado");
        btImposible = new JButton("Imposible");

        // Los hacemos no focusables
        btFacil.setFocusable(false);
        btNormal.setFocusable(false);
        btComplicado.setFocusable(false);
        btImposible.setFocusable(false);

        crearEscuchaBotones();
    }

    /**
     * Crea la eschucha de los botones, usando clases anonimas para su implementacion
     */
    private void crearEscuchaBotones()
    {
        //Object[] valoresPosibles = { "1200x1024", "1024x768", "800x600" };
        //Object valorSeleccionado;
        //valorSeleccionado = JOptionPane.showInputDialog(null, "Elija la resolucion", "Input", JOptionPane.INFORMATION_MESSAGE, null, valoresPosibles, valoresPosibles[0]);

        btFacil.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    framePadre.pantallaJuego(1, ancho, alto);
                }
            });

        btNormal.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    framePadre.pantallaJuego(2, ancho, alto);
                }
            });

        btComplicado.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    framePadre.pantallaJuego(3, ancho, alto);
                }
            });

        btImposible.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    framePadre.pantallaJuego(4, ancho, alto);
                }
            });
    }

    /**
     * Añade los cuatro botones al panel que le entre
     */
    private void añadirBotones(JPanel panel)
    {
        pBoton1.add(btFacil);
        pBoton2.add(btNormal);
        pBoton3.add(btComplicado);
        pBoton4.add(btImposible);

        panel.add(pBoton1);
        panel.add(pBoton2);
        panel.add(pBoton3);
        panel.add(pBoton4);
    }
}
