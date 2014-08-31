import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by erickchali on 8/29/14.
 */
/*
El programa debe crear dos matrices una de cajas de texto y una de eiquetas,
si la caja de texto en una posicion x,y tiene un numero se pinta de un color
si la caja de texto en una posicion x,y tiene algo que no sea numero se pinta de color negro
0 = blanco
1 = rojo
2 = azul
3 = amarillo
mayor a 3 = verde
lo que no sea numero = negro
* */
public class CrearCuadros extends JFrame implements ActionListener {
    //Variables que vamos a utilizar
    JPanel p1,p2,p3,sp1,sp2;
    String[] dimensiones = {"4","5","6","7","8","9","10"};
    JComboBox squareSize;
    JTextField[][] cajitas;
    JLabel[][] lienzos;
    JButton pintar,limpiar;
    JLabel titulo,demo;
    int numCom;

    //metodo constructor que va a crear las cosas al momento de cargar la ventana.
    public CrearCuadros(){
        super("Pintar cuadritos");
        this.setLayout(new FlowLayout());
        //se inicializan los componentes que se van a utilizar
        squareSize = new JComboBox(dimensiones);
        squareSize.setSelectedIndex(0);
        squareSize.addActionListener(this);

        titulo = new JLabel("Dimension de la matriz cuadrada");

        pintar = new JButton("Colorear");
        pintar.addActionListener(this);

        //estos 3 paneles son los que van a contener los elementos de la ventana para que se vea bien.
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setPreferredSize(new Dimension(300, 400));

        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.setPreferredSize(new Dimension(300, 400));

        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.setPreferredSize(new Dimension(500, 100));

        /*al momento de inicializar la pantalla solo se debe mostrar el boton de pintar, el combobox y el label.
        asi que se los agregamos al panel 3.
        */
        p3.add(titulo);
        p3.add(squareSize);
        p3.add(pintar);

        //se añaden los paneles a la ventana principal.
        this.add(p3);
        this.add(p1);
        this.add(p2);
    }

    //Evento que va a manejar a las opciones del combo box, y al boton de pintar.
    @Override
    public void actionPerformed(ActionEvent e) {
        String dimen = (String)squareSize.getSelectedItem();
        if(e.getSource()==squareSize){
            try{
                /*
                tenemos subpanel 1 y subpanel 2, que van a servir para cargar la matriz, luego seran añadidos al panel 1 y 2
                respectivamente.
                removeAll() sirve para limpiar el subpanel 1 y 2 para que cada vez que se seleccione un numero diferente del
                combobox se limpie y cree una nueva matriz.
                repaint() sirve para que una vez que se haya limpiado se actualice el JFrame.
                "n" es el numero que se selecciona del combobox
                "w" y "h" son el ancho y altura de los subpaneles para que el tamaño sea dinamico.
                * */
                int n=0,w=0,h=0;
                sp1 = new JPanel();
                sp1.setLayout(new FlowLayout());
                sp2 = new JPanel();
                sp2.setLayout(new FlowLayout());
                sp1.removeAll();
                sp1.repaint();
                sp2.removeAll();
                sp2.repaint();
                p1.removeAll();
                p1.repaint();
                p2.removeAll();
                p2.repaint();

                //tomamos el valor de combo box
                n = Integer.parseInt(dimen);
                numCom = n;
                //w y h medidos al pulso para que los componentes quepan en el subpanel
                w=(28*(n+1));
                h=(30*(n+1));
                //se le da un tamaño al subpanel de tamaño w*h
                sp1.setPreferredSize(new Dimension(w,h));
                cajitas = new JTextField[n][n];
                for (int x =0;x<n;x++){
                    for (int y =0;y<n;y++){
                        //se crea una nueva caja, se le da un tamaño "cuadrado"
                        /*validate() y repaint() sirven en conjunto para actualizar el subpanel y que se vayan agregando
                        las cajitas creadas
                        */
                        cajitas[x][y] = new JTextField();
                        cajitas[x][y].setPreferredSize(new Dimension(25, 25));
                        sp1.add(cajitas[x][y]);
                        sp1.validate();
                        sp1.repaint();
                    }
                }
                // por ultimo le añadimos al panel 1 el subpanel 1 y se actualiza con validate() y repaint()
                p1.add(sp1);
                p1.validate();
                p1.repaint();

                sp2.setPreferredSize(new Dimension(w,h));
                lienzos = new JLabel[n][n];
                for (int v =0;v<n;v++){
                    for (int z =0;z<n;z++){
                        lienzos[v][z] = new JLabel(" ");
                        lienzos[v][z].setPreferredSize(new Dimension(25, 25));
                        lienzos[v][z].setBackground(Color.white);
                        lienzos[v][z].setOpaque(true);

                        sp2.add(lienzos[v][z]);
                        sp2.validate();
                        sp2.repaint();
                    }
                }
                p2.add(sp2);
                p2.validate();
                p2.repaint();
                this.validate();
                this.repaint();
            }catch(Exception ex){

            }
        }else if(e.getSource()==pintar){
            // se recorre la matriz desde 0 hasta el numero que da la dimension de la matriz
            for(int x=0 ; x < numCom ; x++){
                for(int y=0 ; y < numCom ; y++){
                    try{
                        //se intenta convertir en numero el contenido de las cajitas
                        int comparacion = Integer.parseInt(cajitas[x][y].getText().toString());
                        //si es un numero se compara para pintar dependiendo del color que tenga.
                        if(comparacion == 0){
                            lienzos[x][y].setBackground(Color.white);
                            lienzos[x][y].setOpaque(true);
                        }else if(comparacion == 1){
                            lienzos[x][y].setBackground(Color.red);
                            lienzos[x][y].setOpaque(true);
                        }else if(comparacion == 2){
                            lienzos[x][y].setBackground(Color.blue);
                            lienzos[x][y].setOpaque(true);
                        }else if(comparacion == 3){
                            lienzos[x][y].setBackground(Color.yellow);
                            lienzos[x][y].setOpaque(true);
                        }else if(comparacion > 3){
                            lienzos[x][y].setBackground(Color.green);
                            lienzos[x][y].setOpaque(true);
                        }
                    }catch(Exception ex){
                        // si no era un numero se pinta de negro.
                        //setOpaque(true) es para que se pueda pintar, sin esto no cambia de color.
                        lienzos[x][y].setBackground(Color.black);
                        lienzos[x][y].setOpaque(true);
                    }

                }

            }
        }
    }
}
