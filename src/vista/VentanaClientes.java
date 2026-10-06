package vista;

import modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaClientes extends JFrame {

    // Estructura de datos para almacenar clientes
    private List<Cliente> clientes;
    private int indiceActual = 0;

    // Componentes gráficos
    private JLabel lblNumero, lblNombre, lblEdad, lblPuntos;
    private JTextField txtNumero, txtNombre, txtEdad, txtPuntos;
    private JButton btnAnterior, btnSiguiente;

    public VentanaClientes() {
        super("Gestión de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3.1 & 3.2: Inicializar y precargar 3 clientes
        clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Ana García", 28, 150.50));
        clientes.add(new Cliente(2, "Carlos Pérez", 35, 320.00));
        clientes.add(new Cliente(3, "María López", 42, 89.75));

        // Etiquetas descriptivas (3.2.1)
        lblNumero = new JLabel("Número: ");
        lblNombre = new JLabel("Nombre: ");
        lblEdad = new JLabel("Edad: ");
        lblPuntos = new JLabel("Puntos: ");

        // Campos de texto para visualizar atributos (3.2.1)
        txtNumero = new JTextField(15);
        txtNumero.setEditable(false);
        txtNombre = new JTextField(15);
        txtNombre.setEditable(false);
        txtEdad = new JTextField(15);
        txtEdad.setEditable(false);
        txtPuntos = new JTextField(15);
        txtPuntos.setEditable(false);

        // Botones de navegación (3.2.2)
        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");

        // Listeners para navegación
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceActual > 0) {
                    indiceActual--;
                    mostrarClienteActual();
                }
            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceActual < clientes.size() - 1) {
                    indiceActual++;
                    mostrarClienteActual();
                }
            }
        });

        // 3.3: Organización con JPanels y distintos Layouts
        JPanel panelEtiquetas = new JPanel(new GridLayout(4, 1, 5, 5));
        panelEtiquetas.add(lblNumero);
        panelEtiquetas.add(lblNombre);
        panelEtiquetas.add(lblEdad);
        panelEtiquetas.add(lblPuntos);

        JPanel panelCampos = new JPanel(new GridLayout(4, 1, 5, 5));
        panelCampos.add(txtNumero);
        panelCampos.add(txtNombre);
        panelCampos.add(txtEdad);
        panelCampos.add(txtPuntos);

        JPanel panelDatos = new JPanel(new BorderLayout(10, 10));
        panelDatos.add(panelEtiquetas, BorderLayout.WEST);
        panelDatos.add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);

        JPanel contentPane = new JPanel(new BorderLayout(15, 15));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.add(panelDatos, BorderLayout.CENTER);
        contentPane.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(contentPane);

        // Visualizar el primer cliente al iniciar
        mostrarClienteActual();
    }

    // Método para actualizar los campos y gestionar estado de botones (3.2.3 & 3.2.4)
    private void mostrarClienteActual() {
        if (clientes.isEmpty()) return;

        Cliente c = clientes.get(indiceActual);
        // Uso exclusivo de getters de la vista sobre la clase cliente (Requisito 4)
        txtNumero.setText(String.valueOf(c.getNumero()));
        txtNombre.setText(c.getNombre());
        txtEdad.setText(String.valueOf(c.getEdad()));
        txtPuntos.setText(String.valueOf(c.getPuntos()));

        // Activar / desactivar botones según la posición
        btnAnterior.setEnabled(indiceActual > 0);
        btnSiguiente.setEnabled(indiceActual < clientes.size() - 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaClientes frame = new VentanaClientes();
                frame.pack();
                frame.setLocationRelativeTo(null); // Centrar en pantalla
                frame.setVisible(true);
            }
        });
    }
}