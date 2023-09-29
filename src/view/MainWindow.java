package view;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel jPanel;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JLabel jLabel;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField jTextField;
    private JButton jButton;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButton10;
    private JTable jTable;
    private JTable jTable2;

    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;

    public MainWindow() {
        this.setSize(500, 500);
        this.setTitle("Proyecto MDIS");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        // Cambiamos el layout principal a BorderLayout
        this.setLayout(new BorderLayout(10, 10)); // Espacio horizontal y vertical de 10 píxeles
        //Paneles
        jPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        jPanel2 = new JPanel(new GridLayout(2, 5));

        jPanel3 = new JPanel(new GridLayout(2, 2, 10, 10));
        jPanel3.setPreferredSize(new Dimension(200, 200)); // Establecemos el tamaño preferido de jPanel2

        //Componentes
        jLabel = new JLabel("Ingresar funcion booleana: ");
        jLabel2 = new JLabel("Tabla de verdad");
        jLabel3 = new JLabel("Mapa de Karnough");
        jLabel4 = new JLabel("Solucion: ");
        jTextField = new JTextField(20);
        jButton = new JButton("X");
        jButton2 = new JButton("Y");
        jButton3 = new JButton("Z");
        jButton4 = new JButton("W");
        jButton5 = new JButton("OK");
        jButton6 = new JButton("^");
        jButton7 = new JButton("v");
        jButton8 = new JButton("'");
        jButton9 = new JButton("(");
        jButton10 = new JButton(")");
        jTable = new JTable(9, 4);
        jTable2 = new JTable(5, 4);

        //Agregar componentes
        jPanel2.add(jButton);
        jPanel2.add(jButton2);
        jPanel2.add(jButton3);
        jPanel2.add(jButton4);
        jPanel2.add(jButton5);
        jPanel2.add(jButton6);
        jPanel2.add(jButton7);
        jPanel2.add(jButton8);
        jPanel2.add(jButton9);
        jPanel2.add(jButton10);

        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jPanel2);

        jPanel3.add(jLabel2);
        jPanel3.add(jLabel3);
        scrollPane = new JScrollPane(jTable);
        scrollPane2 = new JScrollPane(jTable2);
        jPanel3.add(scrollPane);
        jPanel3.add(scrollPane2);

        this.add(jPanel, BorderLayout.NORTH);
        this.add(jPanel3, BorderLayout.CENTER);
        this.add(jLabel4, BorderLayout.SOUTH);

        this.add(jLabel4, BorderLayout.SOUTH); // Agregamos jPanel en la región sur
    }
}
