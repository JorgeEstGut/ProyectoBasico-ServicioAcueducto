/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jega_
 */
public final class frmMenu extends javax.swing.JFrame {
    
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();
    DefaultTableModel dtm3Acu = new DefaultTableModel();
    DefaultTableModel dtm3Alc = new DefaultTableModel();
    DefaultTableModel dtm3Ase = new DefaultTableModel();
    DefaultTableModel dtm3Sub = new DefaultTableModel();
    DefaultTableModel dtm4 = new DefaultTableModel();
    DefaultListModel<String> listFact = new DefaultListModel<>();
    DefaultTableModel dtm5bar = new DefaultTableModel();
    
    
    public int getPoliza() {
        try {
            return Integer.parseInt(txtNroPoliza.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public int getIndexSelect() {
        return listFacturas.getSelectedIndex();
    }
    /**
     * Creates new form frmMenu
     */
    public frmMenu() {
        initComponents();
        setLocationRelativeTo(null);
        listFacturas.setModel(listFact);

        //tabla Clientes
        String[] titulo = new String[] {"Nro. Póliza", "Cédula", "Nombres", "Apellidos", "Municipio", "Barrio", "Sexo", "Estrato"};
        dtm.setColumnIdentifiers(titulo);
        tabRegClientes.setModel(dtm);
        
        try {
            LectorCliente();
        } catch (Exception ex) {
            
        }
        
        //tabla Lecturas
        String[] titulo2 = new String[] {"Nro. Póliza", "Lectura Anterior", "Lectura Actual", "Fecha"};
        dtm2.setColumnIdentifiers(titulo2);
        tabLecturas.setModel(dtm2);
        
        try {
            LectorLecturas();
        } catch (Exception ex) {
            
        }
        
        URL iconURL = getClass().getResource("/imagenes/iconLo.png");
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
        } else {
            System.err.println("No se pudo encontrar el archivo de ícono.");
        }
        
        //tabla Municipios
        String[] titulo4 = new String[] {"Municipios"};
        dtm4.setColumnIdentifiers(titulo4);
        tabMunicipios.setModel(dtm4);
        
        try {
            Municipios();
        } catch (Exception ex) {
            
        }
        
        //tabla tarifas
        //Acueducto
        String[] titulo3Acu = new String[] {"Estrato", "($) Precio por m³"};
        dtm3Acu.setColumnIdentifiers(titulo3Acu);
        tabAcueducto.setModel(dtm3Acu);
        
        try {
            LectorAcueducto();
        } catch (Exception ex) {
            
        }
        
        //Subsidio
        String[] titulo3Sub = new String[] {"Estrato", "(%) Promedio de subsidio"};
        dtm3Sub.setColumnIdentifiers(titulo3Sub);
        tabSubsidios.setModel(dtm3Sub);
        
        try {
            LectorSubsidio();
        } catch (Exception ex) {
            
        }
        
        //Aseo
        String[] titulo3Ase = new String[] {"Estrato", "($) Precio por kg"};
        dtm3Ase.setColumnIdentifiers(titulo3Ase);
        tabAseo.setModel(dtm3Ase);
        
        try {
            LectorAseo();
        } catch (Exception ex) {
            
        }
        
        //Alcantarillado
        String[] titulo3Alc = new String[] {"Estrato", "(%) Porcentaje m³"};
        dtm3Alc.setColumnIdentifiers(titulo3Alc);
        tabAlcantarillado.setModel(dtm3Alc);
        
        try {
            LectorAlcantarillado();
        } catch (Exception ex) {
            
        }
        
        //cargar municipios → barrios
        try {
            ArrayList<String> listaMunicipios = cargarMunicipios();
            combMuni.setModel(new javax.swing.DefaultComboBoxModel<>(listaMunicipios.toArray(String[]::new)));
         } catch (IOException ex) {
            Logger.getLogger(frmClientes.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        //tabla Barrios
        String[] tituloTabBar = new String[] {"Barrios"};
        dtm5bar.setColumnIdentifiers(tituloTabBar);
        tabBarrios.setModel(dtm5bar);
    }
    
    public List<List<Object>> obtenerDatosTablaAcueducto() {
        List<List<Object>> datosTabla = new ArrayList<>();
        int filas = tabAcueducto.getRowCount();
        int columnas = tabAcueducto.getColumnCount();
        
        for (int i = 0; i < filas; i++) {
            List<Object> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(tabAcueducto.getValueAt(i, j));
            }
            datosTabla.add(fila);
        }
        
        return datosTabla;
    }
    
    public List<List<Object>> obtenerDatosTablaAlcantarillado() {
        List<List<Object>> datosTabla = new ArrayList<>();
        int filas = tabAlcantarillado.getRowCount();
        int columnas = tabAlcantarillado.getColumnCount();
        
        for (int i = 0; i < filas; i++) {
            List<Object> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(tabAlcantarillado.getValueAt(i, j));
            }
            datosTabla.add(fila);
        }
        
        return datosTabla;
    }
    
    public List<List<Object>> obtenerDatosTablaAseo() {
        List<List<Object>> datosTabla = new ArrayList<>();
        int filas = tabAseo.getRowCount();
        int columnas = tabAseo.getColumnCount();
        
        for (int i = 0; i < filas; i++) {
            List<Object> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(tabAseo.getValueAt(i, j));
            }
            datosTabla.add(fila);
        }
        
        return datosTabla;
    }
    
    public List<List<Object>> obtenerDatosTablaSubsidio() {
        List<List<Object>> datosTabla = new ArrayList<>();
        int filas = tabSubsidios.getRowCount();
        int columnas = tabSubsidios.getColumnCount();
        
        for (int i = 0; i < filas; i++) {
            List<Object> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(tabSubsidios.getValueAt(i, j));
            }
            datosTabla.add(fila);
        }
        
        return datosTabla;
    }
    
    private static boolean esNumerico(String str) {
        if (str == null || str.isEmpty()) return false;
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            return true;
        }
    
    public void LectorCliente() throws Exception {
        String archivo = "Clientes.txt"; // Replace with the actual file path
        List<List<Object>> datosFinal = new ArrayList<>(); // List to store processed data

        try (FileReader reader = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(reader);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datosLinea = linea.split("::"); // Split the line by "::"

                 List<Object> filaProcesada = new ArrayList<>(); // List to store processed fields
                for (String dato : datosLinea) {
                    if (esNumerico(dato)) {
                    filaProcesada.add(Integer.valueOf(dato));
                    } else {
                        filaProcesada.add(dato);
                    }
                }
                datosFinal.add(filaProcesada); // Add the processed row to the final list
            }
        }
        // Print the final data
        for (List<Object> fila : datosFinal) {
            // Convert the List<Object> to an Object array
            Object[] rowData = fila.toArray();
            dtm.addRow(rowData);
        }
        // Use the processed data as needed
    }
    
    public void LectorLecturas() throws Exception {
        String archivo = "Lecturas.txt"; // Replace with the actual file path
        List<List<Object>> datosFinal = new ArrayList<>(); // List to store processed data

        try (FileReader reader = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(reader);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datosLinea = linea.split("::"); // Split the line by "::"

                 List<Object> filaProcesada = new ArrayList<>(); // List to store processed fields
                for (String dato : datosLinea) {
                    if (esNumerico(dato)) {
                    filaProcesada.add(Integer.valueOf(dato));
                    } else {
                        filaProcesada.add(dato);
                    }
                }
                datosFinal.add(filaProcesada); // Add the processed row to the final list
            }
        }
        // Print the final data
        for (List<Object> fila : datosFinal) {
            // Convert the List<Object> to an Object array
            Object[] rowData = fila.toArray();
            dtm2.addRow(rowData);
        }
        // Use the processed data as needed
    }
    
    public void Municipios() throws Exception {
        String archivo = "baseDatos/lugares/municipios/Municipios.txt"; // Replace with the actual file path
        ArrayList<String> municipios = new ArrayList<>();
        try (FileReader reader = new FileReader(archivo)) {
             BufferedReader br = new BufferedReader(reader);
             String linea;
             while ((linea = br.readLine()) != null) {
                municipios.add(linea.trim());
            }
         }   
        // Print the final data
        for (String fila : municipios) {
            // Convert the List<Object> to an Object array
            Object[] rowData = { fila };
            dtm4.addRow(rowData);
        }
        // Use the processed data as needed
    }
    
    public void LectorAcueducto() throws Exception {
        String archivo = "baseDatos/tarifas/ACUEDUCTO.txt";
        List<List<Object>> datosFinal = new ArrayList<>(); // List to store processed data
        try (FileReader reader = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while ((linea = br.readLine()) != null) {
            String[] datosLinea = linea.split("::"); // Split the line by "::"

                 List<Object> filaProcesada = new ArrayList<>(); // List to store processed fields
                for (String dato : datosLinea) {
                    if (esNumerico(dato)) {
                    filaProcesada.add(Integer.valueOf(dato));
                    } else {
                        filaProcesada.add(dato);
                    }
                }
                datosFinal.add(filaProcesada); // Add the processed row to the final list
            }
        }
        // Print the final data
        for (List<Object> fila : datosFinal) {
            // Convert the List<Object> to an Object array
            Object[] rowData = fila.toArray();
            dtm3Acu.addRow(rowData);
        }
    }
    
    public void LectorSubsidio() throws Exception {
        String archivo = "baseDatos/tarifas/SUBSIDIO.txt";
        List<List<Object>> datosFinal = new ArrayList<>();
        try (FileReader reader = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while ((linea = br.readLine()) != null) {
            String[] datosLinea = linea.split("::"); // Split the line by "::"

                 List<Object> filaProcesada = new ArrayList<>(); // List to store processed fields
                for (String dato : datosLinea) {
                    if (esNumerico(dato)) {
                    filaProcesada.add(Integer.valueOf(dato));
                    } else {
                        filaProcesada.add(dato);
                    }
                }
                datosFinal.add(filaProcesada); // Add the processed row to the final list
            }
        }
        // Print the final data
        for (List<Object> fila : datosFinal) {
            // Convert the List<Object> to an Object array
            Object[] rowData = fila.toArray();
            dtm3Sub.addRow(rowData);
        }
    }
    
    public void LectorAseo() throws Exception {
        String archivo = "baseDatos/tarifas/ASEO.txt";
        List<List<Object>> datosFinal = new ArrayList<>();
        try (FileReader reader = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while ((linea = br.readLine()) != null) {
            String[] datosLinea = linea.split("::"); // Split the line by "::"

                 List<Object> filaProcesada = new ArrayList<>(); // List to store processed fields
                for (String dato : datosLinea) {
                    if (esNumerico(dato)) {
                    filaProcesada.add(Integer.valueOf(dato));
                    } else {
                        filaProcesada.add(dato);
                    }
                }
                datosFinal.add(filaProcesada); // Add the processed row to the final list
            }
        }
        // Print the final data
        for (List<Object> fila : datosFinal) {
            // Convert the List<Object> to an Object array
            Object[] rowData = fila.toArray();
            dtm3Ase.addRow(rowData);
        }
    }
    
    public void LectorAlcantarillado() throws Exception {
        String archivo = "baseDatos/tarifas/ALCANTARILLADO.txt";
        List<List<Object>> datosFinal = new ArrayList<>();
        try (FileReader reader = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while ((linea = br.readLine()) != null) {
            String[] datosLinea = linea.split("::"); // Split the line by "::"

                 List<Object> filaProcesada = new ArrayList<>(); // List to store processed fields
                for (String dato : datosLinea) {
                    if (esNumerico(dato)) {
                    filaProcesada.add(Integer.valueOf(dato));
                    } else {
                        filaProcesada.add(dato);
                    }
                }
                datosFinal.add(filaProcesada); // Add the processed row to the final list
            }
        }
        // Print the final data
        for (List<Object> fila : datosFinal) {
            // Convert the List<Object> to an Object array
            Object[] rowData = fila.toArray();
            dtm3Alc.addRow(rowData);
        }
    }
    
    public String[] datosFilaCliente(int poliza) {
         int numRows = tabRegClientes.getRowCount();
        for (int i = 0; i < numRows; i++) {
            int numeroPoliza = (int) tabRegClientes.getValueAt(i, 0);
            if(numeroPoliza == poliza) {
                String[] datos = new String[tabRegClientes.getColumnCount()];
                for (int j = 0; j < tabRegClientes.getColumnCount(); j++) {
                    datos[j] = String.valueOf(tabRegClientes.getValueAt(i, j));
                }
                return datos;
            }
        }
        return null;
    }
    
    public List<String[]> obtenerLecturas(int poliza) {
        List<String[]> filasCoincidentes = new ArrayList<>();
        int rowCount = tabLecturas.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            int valorFila = (int) tabLecturas.getValueAt(i, 0);
            if (valorFila == poliza) {
                String[] datosFila = new String[tabLecturas.getColumnCount()];
                for (int j = 0; j < tabLecturas.getColumnCount(); j++) {
                    datosFila[j] = String.valueOf(tabLecturas.getValueAt(i, j));
                }
                filasCoincidentes.add(datosFila);
            }
        }
        return filasCoincidentes;
    }
    
    public List<Integer> obtenerNumerosPoliza() {
        List<Integer> numerosPoliza = new ArrayList<>();
        int numRows = tabRegClientes.getRowCount();
        for (int i = 0; i < numRows; i++) {
            int numeroPoliza = (int) tabRegClientes.getValueAt(i, 0);
            numerosPoliza.add(numeroPoliza);
        }
        return numerosPoliza;
    }
    
    public List<Integer> obtenerNumerosPolizaLect() {
        List<Integer> numerosPoliza = new ArrayList<>();
    int numRows = tabLecturas.getRowCount();
    for (int i = 0; i < numRows; i++) {
        Object value = tabLecturas.getValueAt(i, 0);
        if (value instanceof Integer) {
            numerosPoliza.add((Integer) value);
        } else if (value instanceof String) {
            try {
                int numeroPoliza = Integer.parseInt((String) value);
                numerosPoliza.add(numeroPoliza);
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir a número de póliza: " + value);
            }
        }
    }
    return numerosPoliza;
    }
    
    public void ActualizarTabClientes() {
        try {
            dtm.setRowCount(0); 
            LectorCliente();
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ActualizarTabLecturas() {
        try {
            dtm2.setRowCount(0); 
            LectorLecturas(); 
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ActualizarTabMunicipios() {
        try {
            dtm4.setRowCount(0); 
            Municipios();
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ActualizarTabBarrios() {
        try {
            dtm5bar.setRowCount(0); 
            String municipioSeleccionado = (String) combMuni.getSelectedItem();
            ArrayList<String> listaBarrios = barrios(municipioSeleccionado);
            for (String fila : listaBarrios) {
               Object[] rowData = { fila };
               dtm5bar.addRow(rowData);
             }
        } catch (IOException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ActualizarTabTarifas() {
        try {
            dtm3Acu.setRowCount(0);
            dtm3Alc.setRowCount(0);
            dtm3Ase.setRowCount(0);
            dtm3Sub.setRowCount(0);
            LectorAcueducto();
            LectorAlcantarillado();
            LectorAseo();
            LectorSubsidio();
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String[]> MostrarFacturas(int a) throws Exception {
        String archivo = "baseDatos/facturas/Facturas.txt";
        ArrayList<String> facturas = new ArrayList<>();
        ArrayList<String[]> coincidencias = new ArrayList<>();

        try (FileReader reader = new FileReader(archivo); 
             BufferedReader br = new BufferedReader(reader)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                facturas.add(linea.trim());
            }
        } catch (Exception e) {
            throw new Exception("Error al leer el archivo: " + e.getMessage());
        }

        for (String fila : facturas) {
            String[] rowData = fila.split("::");
            if (rowData.length > 0 && Integer.parseInt(rowData[0].trim()) == a) {
                coincidencias.add(rowData);
            }
        }

        return coincidencias;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        tpContenedor = new javax.swing.JTabbedPane();
        pnlClientes = new javax.swing.JPanel();
        btnNuevoCliente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabRegClientes = new javax.swing.JTable();
        pnlLecturas = new javax.swing.JPanel();
        btnNuevaLectura = new javax.swing.JButton();
        spTabLecturas = new javax.swing.JScrollPane();
        tabLecturas = new javax.swing.JTable();
        pnlTarifas = new javax.swing.JPanel();
        spTabTarifas = new javax.swing.JScrollPane();
        pnlContTarifas = new javax.swing.JPanel();
        spAcueducto = new javax.swing.JScrollPane();
        tabAcueducto = new javax.swing.JTable();
        spSubsidios = new javax.swing.JScrollPane();
        tabSubsidios = new javax.swing.JTable();
        spAlcantarillado = new javax.swing.JScrollPane();
        tabAlcantarillado = new javax.swing.JTable();
        spAseo = new javax.swing.JScrollPane();
        tabAseo = new javax.swing.JTable();
        etiAseo = new javax.swing.JLabel();
        etiAcueducto = new javax.swing.JLabel();
        etiSubsidios = new javax.swing.JLabel();
        etiAlcantarillado = new javax.swing.JLabel();
        btnEditarTarifas = new javax.swing.JButton();
        pnlMunicipios = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabMunicipios = new javax.swing.JTable();
        btnNuevoMunicipio = new javax.swing.JButton();
        pnlBarrios = new javax.swing.JPanel();
        combMuni = new javax.swing.JComboBox<>();
        etiMuni = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabBarrios = new javax.swing.JTable();
        btnNuevoBarrio = new javax.swing.JButton();
        pnlFacturas = new javax.swing.JPanel();
        spListFacturas = new javax.swing.JScrollPane();
        listFacturas = new javax.swing.JList<>();
        etiNroPoliza = new javax.swing.JLabel();
        txtNroPoliza = new javax.swing.JTextField();
        btnBuscarPoliza = new javax.swing.JButton();
        mbpMenu = new javax.swing.JMenuBar();
        mbSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Triple A S.A. E.S.P.");
        setResizable(false);

        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tpContenedor.setBackground(new java.awt.Color(0, 102, 204));
        tpContenedor.setForeground(new java.awt.Color(232, 232, 232));
        tpContenedor.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpContenedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        pnlClientes.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        btnNuevoCliente.setBackground(new java.awt.Color(0, 102, 204));
        btnNuevoCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevoCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoCliente.setText("NUEVO CLIENTE");
        btnNuevoCliente.setBorder(null);
        btnNuevoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        tabRegClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabRegClientes);

        javax.swing.GroupLayout pnlClientesLayout = new javax.swing.GroupLayout(pnlClientes);
        pnlClientes.setLayout(pnlClientesLayout);
        pnlClientesLayout.setHorizontalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pnlClientesLayout.setVerticalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpContenedor.addTab("Clientes", new javax.swing.ImageIcon(getClass().getResource("/imagenes/user-social-svgrepo-com.png")), pnlClientes); // NOI18N

        pnlLecturas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        btnNuevaLectura.setBackground(new java.awt.Color(0, 102, 204));
        btnNuevaLectura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevaLectura.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaLectura.setText("NUEVA LECTURA");
        btnNuevaLectura.setBorder(null);
        btnNuevaLectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaLecturaActionPerformed(evt);
            }
        });

        tabLecturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spTabLecturas.setViewportView(tabLecturas);

        javax.swing.GroupLayout pnlLecturasLayout = new javax.swing.GroupLayout(pnlLecturas);
        pnlLecturas.setLayout(pnlLecturasLayout);
        pnlLecturasLayout.setHorizontalGroup(
            pnlLecturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTabLecturas, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLecturasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevaLectura, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlLecturasLayout.setVerticalGroup(
            pnlLecturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLecturasLayout.createSequentialGroup()
                .addComponent(spTabLecturas, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaLectura, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        tpContenedor.addTab("Lecturas", new javax.swing.ImageIcon(getClass().getResource("/imagenes/read-svgrepo-com.png")), pnlLecturas); // NOI18N

        pnlTarifas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        pnlContTarifas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spAcueducto.setViewportView(tabAcueducto);

        pnlContTarifas.add(spAcueducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 35, 331, 151));

        spSubsidios.setViewportView(tabSubsidios);

        pnlContTarifas.add(spSubsidios, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 35, 420, 151));

        spAlcantarillado.setViewportView(tabAlcantarillado);

        pnlContTarifas.add(spAlcantarillado, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 227, 420, 150));

        spAseo.setViewportView(tabAseo);

        pnlContTarifas.add(spAseo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 227, 331, 151));

        etiAseo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiAseo.setForeground(new java.awt.Color(0, 102, 204));
        etiAseo.setText("ASEO");
        pnlContTarifas.add(etiAseo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        etiAcueducto.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiAcueducto.setForeground(new java.awt.Color(0, 102, 204));
        etiAcueducto.setText("ACUEDUCTO");
        pnlContTarifas.add(etiAcueducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        etiSubsidios.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiSubsidios.setForeground(new java.awt.Color(0, 102, 204));
        etiSubsidios.setText("SUBSIDIOS");
        pnlContTarifas.add(etiSubsidios, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        etiAlcantarillado.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        etiAlcantarillado.setForeground(new java.awt.Color(0, 102, 204));
        etiAlcantarillado.setText("ALCANTARILLADO");
        pnlContTarifas.add(etiAlcantarillado, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        spTabTarifas.setViewportView(pnlContTarifas);

        btnEditarTarifas.setBackground(new java.awt.Color(0, 102, 204));
        btnEditarTarifas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarTarifas.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarTarifas.setText("EDITAR TARIFAS");
        btnEditarTarifas.setBorder(null);
        btnEditarTarifas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTarifasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTarifasLayout = new javax.swing.GroupLayout(pnlTarifas);
        pnlTarifas.setLayout(pnlTarifasLayout);
        pnlTarifasLayout.setHorizontalGroup(
            pnlTarifasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTabTarifas, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTarifasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarTarifas, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlTarifasLayout.setVerticalGroup(
            pnlTarifasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarifasLayout.createSequentialGroup()
                .addComponent(spTabTarifas, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarTarifas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        tpContenedor.addTab("Tarifas", new javax.swing.ImageIcon(getClass().getResource("/imagenes/cash-coins-currency-svgrepo-com.png")), pnlTarifas); // NOI18N

        pnlMunicipios.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tabMunicipios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabMunicipios);

        btnNuevoMunicipio.setBackground(new java.awt.Color(0, 102, 204));
        btnNuevoMunicipio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevoMunicipio.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoMunicipio.setText("NUEVO MUNICIPIO");
        btnNuevoMunicipio.setBorder(null);
        btnNuevoMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMunicipioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMunicipiosLayout = new javax.swing.GroupLayout(pnlMunicipios);
        pnlMunicipios.setLayout(pnlMunicipiosLayout);
        pnlMunicipiosLayout.setHorizontalGroup(
            pnlMunicipiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMunicipiosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        pnlMunicipiosLayout.setVerticalGroup(
            pnlMunicipiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMunicipiosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevoMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tpContenedor.addTab("Municipios", new javax.swing.ImageIcon(getClass().getResource("/imagenes/city-river-svgrepo-com.png")), pnlMunicipios); // NOI18N

        pnlBarrios.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        combMuni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combMuni.setForeground(new java.awt.Color(51, 51, 51));
        combMuni.setBorder(null);
        combMuni.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combMuniItemStateChanged(evt);
            }
        });
        combMuni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combMuniActionPerformed(evt);
            }
        });

        etiMuni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiMuni.setForeground(new java.awt.Color(0, 102, 204));
        etiMuni.setText("CIUDAD / MUNICIPIO");

        tabBarrios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabBarrios.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(tabBarrios);

        btnNuevoBarrio.setBackground(new java.awt.Color(0, 102, 204));
        btnNuevoBarrio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevoBarrio.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoBarrio.setText("NUEVO BARRIO");
        btnNuevoBarrio.setBorder(null);
        btnNuevoBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoBarrioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBarriosLayout = new javax.swing.GroupLayout(pnlBarrios);
        pnlBarrios.setLayout(pnlBarriosLayout);
        pnlBarriosLayout.setHorizontalGroup(
            pnlBarriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarriosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBarriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNuevoBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBarriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(etiMuni)
                        .addComponent(combMuni, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlBarriosLayout.setVerticalGroup(
            pnlBarriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarriosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(etiMuni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combMuni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevoBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tpContenedor.addTab("Barrios", new javax.swing.ImageIcon(getClass().getResource("/imagenes/residential-area-svgrepo-com.png")), pnlBarrios); // NOI18N

        pnlFacturas.setForeground(new java.awt.Color(51, 51, 51));
        pnlFacturas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        listFacturas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        spListFacturas.setViewportView(listFacturas);

        etiNroPoliza.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiNroPoliza.setForeground(new java.awt.Color(0, 102, 204));
        etiNroPoliza.setText("NRO. PÓLIZA:");

        txtNroPoliza.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtNroPoliza.setForeground(new java.awt.Color(51, 51, 51));
        txtNroPoliza.setBorder(null);
        txtNroPoliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroPolizaActionPerformed(evt);
            }
        });

        btnBuscarPoliza.setBackground(new java.awt.Color(0, 102, 204));
        btnBuscarPoliza.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarPoliza.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPoliza.setText("CONSULTAR");
        btnBuscarPoliza.setBorder(null);
        btnBuscarPoliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPolizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFacturasLayout = new javax.swing.GroupLayout(pnlFacturas);
        pnlFacturas.setLayout(pnlFacturasLayout);
        pnlFacturasLayout.setHorizontalGroup(
            pnlFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFacturasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFacturasLayout.createSequentialGroup()
                        .addComponent(etiNroPoliza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNroPoliza, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPoliza, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spListFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlFacturasLayout.setVerticalGroup(
            pnlFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFacturasLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiNroPoliza, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtNroPoliza)
                    .addComponent(btnBuscarPoliza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(spListFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        tpContenedor.addTab("Facturas", new javax.swing.ImageIcon(getClass().getResource("/imagenes/invoice-dollar-svgrepo-com.png")), pnlFacturas); // NOI18N

        Background.add(tpContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 470));

        mbpMenu.setBackground(new java.awt.Color(0, 102, 204));
        mbpMenu.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true), null));
        mbpMenu.setForeground(new java.awt.Color(232, 232, 232));

        mbSalir.setBackground(new java.awt.Color(255, 255, 255));
        mbSalir.setForeground(new java.awt.Color(232, 232, 232));
        mbSalir.setText("Salir");
        mbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mbSalirMouseClicked(evt);
            }
        });
        mbpMenu.add(mbSalir);

        setJMenuBar(mbpMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mbSalirMouseClicked

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        frmClientes ventanaClientes = new frmClientes();
        ventanaClientes.setMenu(this); // Pasar la referencia a frmMenu
        ventanaClientes.setVisible(true);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnNuevaLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaLecturaActionPerformed
        frmLecturas ventanaLecturas = new frmLecturas();
        ventanaLecturas.setMenu(this);
        ventanaLecturas.setVisible(true);
    }//GEN-LAST:event_btnNuevaLecturaActionPerformed

    private void btnEditarTarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTarifasActionPerformed
        frmTarifas ventanaTarifas = new frmTarifas();
        ventanaTarifas.setMenu(this);
        ventanaTarifas.setVisible(true);
    }//GEN-LAST:event_btnEditarTarifasActionPerformed

    private void txtNroPolizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroPolizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroPolizaActionPerformed
    //Llama a AgregarFacturasLista y  MostrarFacturas
    private void btnBuscarPolizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPolizaActionPerformed
        if (esNumerico(txtNroPoliza.getText())) {
        List<Integer> numerosPoliza = obtenerNumerosPolizaLect();
        List<Integer> veriExist = obtenerNumerosPoliza();
        int nro = Integer.parseInt(txtNroPoliza.getText());
        if (!numerosPoliza.contains(nro)) {
            if (!veriExist.contains(nro)) {
                JOptionPane.showMessageDialog(null, "El numero de póliza no se encuentra registrado", "¡Atención!", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(null, "Sin Facturas Generadas");
            }
        } else {
            listFact.clear();
            try {
                ArrayList<String[]> result = MostrarFacturas(nro);
                AgregarFacturasLista(result);
            } catch (Exception e) {
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Nro. de póliza invalida", "¡Atención!", HEIGHT);
    }
    }//GEN-LAST:event_btnBuscarPolizaActionPerformed
    //para agregar a la lista de Facturas (trabaja junto a btnBuscarPolizaActionPerformed )
    public void AgregarFacturasLista(ArrayList<String[]> a) {
            try {
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i).length >= 3) { //Deben haber minimo 3 elementos.
                        String mensaje = " | NRO. PÓLIZA: " + a.get(i)[0] + " | FECHA DE LECTURA: " +  a.get(i)[1] + " | VALOR FACTURA: $" + a.get(i)[2];
                        listFact.addElement(mensaje);
                    }
                }
            } catch (NumberFormatException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void combMuniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combMuniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combMuniActionPerformed

    private void combMuniItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combMuniItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String municipioSeleccionado = (String) combMuni.getSelectedItem();
            try {
                dtm5bar.setRowCount(0); // Limpia el contenido actual de la tabla
                ArrayList<String> listaBarrios = barrios(municipioSeleccionado);
                for (String fila : listaBarrios) {
                // Convert the List<Object> to an Object array
                Object[] rowData = { fila };
                dtm5bar.addRow(rowData);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmClientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No hay barrios registrados para " + municipioSeleccionado);
            }
        }
    }//GEN-LAST:event_combMuniItemStateChanged

    private void btnNuevoMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMunicipioActionPerformed
        frmMunicipios ventanaMuni = new frmMunicipios();
        ventanaMuni.setMenu(this);
        ventanaMuni.setVisible(true);
    }//GEN-LAST:event_btnNuevoMunicipioActionPerformed

    private void btnNuevoBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoBarrioActionPerformed
        frmBarrios ventanaBar = new frmBarrios();
        ventanaBar.setMenu(this);
        ventanaBar.setVisible(true);
    }//GEN-LAST:event_btnNuevoBarrioActionPerformed

    
    public ArrayList<String> cargarMunicipios() throws IOException {
        String archivo = "baseDatos/lugares/municipios/Municipios.txt";
        ArrayList<String> municipios = new ArrayList<>();
        try (FileReader reader = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while ((linea = br.readLine()) != null) {
            municipios.add(linea.trim());
            }
        }
        return municipios;
    }
    
    public ArrayList<String> barrios(String mun) throws IOException {
        String archivo = "baseDatos/lugares/barrios/" + mun + ".txt";
        ArrayList<String> barrios = new ArrayList<>();
        try (FileReader reader = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(reader);
            String linea;
            
            while ((linea = br.readLine()) != null) {
            barrios.add(linea.trim());
            }
        }
        return barrios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            new frmMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnBuscarPoliza;
    private javax.swing.JButton btnEditarTarifas;
    private javax.swing.JButton btnNuevaLectura;
    private javax.swing.JButton btnNuevoBarrio;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoMunicipio;
    private javax.swing.JComboBox<String> combMuni;
    private javax.swing.JLabel etiAcueducto;
    private javax.swing.JLabel etiAlcantarillado;
    private javax.swing.JLabel etiAseo;
    private javax.swing.JLabel etiMuni;
    private javax.swing.JLabel etiNroPoliza;
    private javax.swing.JLabel etiSubsidios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listFacturas;
    private javax.swing.JMenu mbSalir;
    private javax.swing.JMenuBar mbpMenu;
    private javax.swing.JPanel pnlBarrios;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlContTarifas;
    private javax.swing.JPanel pnlFacturas;
    private javax.swing.JPanel pnlLecturas;
    private javax.swing.JPanel pnlMunicipios;
    private javax.swing.JPanel pnlTarifas;
    private javax.swing.JScrollPane spAcueducto;
    private javax.swing.JScrollPane spAlcantarillado;
    private javax.swing.JScrollPane spAseo;
    private javax.swing.JScrollPane spListFacturas;
    private javax.swing.JScrollPane spSubsidios;
    private javax.swing.JScrollPane spTabLecturas;
    private javax.swing.JScrollPane spTabTarifas;
    private javax.swing.JTable tabAcueducto;
    private javax.swing.JTable tabAlcantarillado;
    private javax.swing.JTable tabAseo;
    private javax.swing.JTable tabBarrios;
    private javax.swing.JTable tabLecturas;
    private javax.swing.JTable tabMunicipios;
    private javax.swing.JTable tabRegClientes;
    private javax.swing.JTable tabSubsidios;
    private javax.swing.JTabbedPane tpContenedor;
    private javax.swing.JTextField txtNroPoliza;
    // End of variables declaration//GEN-END:variables
}
