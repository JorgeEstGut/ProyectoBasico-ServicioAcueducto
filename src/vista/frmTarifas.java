/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Ctarifas;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import modelo.Tarifas;

/**
 *
 * @author jega_
 */
public class frmTarifas extends javax.swing.JFrame {
    
    private frmMenu menu;
    /**
     * Creates new form frmTarifas
     */
    public frmTarifas() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        URL iconURL = getClass().getResource("/imagenes/iconLo.png");
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
        } else {
            System.err.println("No se pudo encontrar el archivo de ícono.");
        }
    }
    
    public void setMenu(frmMenu menu) {
        this.menu = menu;
    }
    
    private static boolean esNumerico(String str) {
        if (str == null || str.isEmpty()) return false;
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            return true;
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Backgroud = new javax.swing.JPanel();
        pnlValores = new javax.swing.JPanel();
        etiTablaEdit = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        combOpciones = new javax.swing.JComboBox();
        txtEst3 = new javax.swing.JTextField();
        txtVal3 = new javax.swing.JTextField();
        txtEst2 = new javax.swing.JTextField();
        txtVal2 = new javax.swing.JTextField();
        txtEst1 = new javax.swing.JTextField();
        txtVal1 = new javax.swing.JTextField();
        txtEst4 = new javax.swing.JTextField();
        txtVal4 = new javax.swing.JTextField();
        txtEst5 = new javax.swing.JTextField();
        txtVal5 = new javax.swing.JTextField();
        txtEst6 = new javax.swing.JTextField();
        txtVal6 = new javax.swing.JTextField();
        etiTitulos = new javax.swing.JLabel();
        etiEstratos = new javax.swing.JLabel();
        imgPerson = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        etiTitulo = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Tarifas");
        setResizable(false);

        Backgroud.setBackground(new java.awt.Color(255, 255, 255));
        Backgroud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlValores.setBackground(new java.awt.Color(234, 234, 234));
        pnlValores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiTablaEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiTablaEdit.setForeground(new java.awt.Color(0, 102, 255));
        etiTablaEdit.setText("TABLA A EDITAR:");
        pnlValores.add(etiTablaEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        btnRegistrar.setBackground(new java.awt.Color(0, 102, 204));
        btnRegistrar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("APLICAR CAMBIOS");
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlValores.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 40));

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("RETROCEDER");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlValores.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 40));

        combOpciones.setBackground(new java.awt.Color(0, 102, 204));
        combOpciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combOpciones.setForeground(new java.awt.Color(255, 255, 255));
        combOpciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO HAY SELECCIÓN", "ACUEDUCTO", "ALCANTARILLADO", "ASEO", "SUBSIDIO" }));
        combOpciones.setBorder(null);
        combOpciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combOpcionesItemStateChanged(evt);
            }
        });
        pnlValores.add(combOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 30));

        txtEst3.setEditable(false);
        pnlValores.add(txtEst3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 140, -1));
        pnlValores.add(txtVal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 150, -1));

        txtEst2.setEditable(false);
        pnlValores.add(txtEst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 140, -1));
        pnlValores.add(txtVal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 150, -1));

        txtEst1.setEditable(false);
        txtEst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEst1ActionPerformed(evt);
            }
        });
        pnlValores.add(txtEst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 140, -1));
        pnlValores.add(txtVal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 150, -1));

        txtEst4.setEditable(false);
        pnlValores.add(txtEst4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 140, -1));
        pnlValores.add(txtVal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 150, -1));

        txtEst5.setEditable(false);
        pnlValores.add(txtEst5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 140, -1));
        pnlValores.add(txtVal5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 150, -1));

        txtEst6.setEditable(false);
        pnlValores.add(txtEst6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 140, -1));
        pnlValores.add(txtVal6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 150, -1));

        etiTitulos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etiTitulos.setForeground(new java.awt.Color(0, 102, 204));
        etiTitulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlValores.add(etiTitulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 150, 20));

        etiEstratos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etiEstratos.setForeground(new java.awt.Color(0, 102, 204));
        etiEstratos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlValores.add(etiEstratos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 140, 20));

        Backgroud.add(pnlValores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 730, 270));

        imgPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/male-clerk-at-a-convenience-store-upper-body-svgrepo-com.png"))); // NOI18N
        Backgroud.add(imgPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlTitulo.setBackground(new java.awt.Color(0, 153, 255));

        etiTitulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etiTitulo.setText("EDITAR TARIFAS");

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aaa-barranquilla-logo-90D5360AB1-seeklogo.com.png"))); // NOI18N

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                        .addComponent(imgLogo)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                        .addComponent(etiTitulo)
                        .addGap(156, 156, 156))))
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Backgroud.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 730, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Backgroud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if ("NO HAY SELECCIÓN".equals(String.valueOf(combOpciones.getSelectedItem()))) {
            JOptionPane.showMessageDialog(null, "Elija una tabla a modificar", "¡Atención!", WARNING_MESSAGE);
        } else {
           int est1 = Integer.parseInt(txtEst1.getText()), est2 = Integer.parseInt(txtEst2.getText()), est3 = Integer.parseInt(txtEst3.getText()), est4 = Integer.parseInt(txtEst4.getText()), est5 = Integer.parseInt(txtEst5.getText()),est6 = Integer.parseInt(txtEst6.getText());
           int val1 = -1, val2 = -1, val3 = -1, val4 = -1, val5 = -1,val6 = -1;
           boolean ver = true;
           
           if (esNumerico(txtVal1.getText()) && esNumerico(txtVal2.getText()) && esNumerico(txtVal3.getText()) && esNumerico(txtVal4.getText()) && esNumerico(txtVal5.getText()) && esNumerico(txtVal6.getText())) {
               val1 = Integer.parseInt(txtVal1.getText());
               val2 = Integer.parseInt(txtVal2.getText());
               val3 = Integer.parseInt(txtVal3.getText());
               val4 = Integer.parseInt(txtVal4.getText());
               val5 = Integer.parseInt(txtVal5.getText());
               val6 = Integer.parseInt(txtVal6.getText());
           } else {
               ver = false;
           }
           
           if (ver) {
               Tarifas M = new Tarifas(est1, val1, est2, val2, est3, val3, est4, val4, est5, val5, est6, val6);
               Ctarifas m = new Ctarifas();
               
               JOptionPane.showMessageDialog(null, "Valores Aplicados", "Mensaje", HEIGHT);
               try {
                   if (null != String.valueOf(combOpciones.getSelectedItem())) switch (String.valueOf(combOpciones.getSelectedItem())) {
                       case "ACUEDUCTO" -> m.Registrar(M, "ACUEDUCTO");
                       case "ALCANTARILLADO" -> m.Registrar(M, "ALCANTARILLADO");
                       case "ASEO" -> m.Registrar(M, "ASEO");
                       case "SUBSIDIO" -> m.Registrar(M, "SUBSIDIO");
                       default -> {
                       }
                   }
                   menu.ActualizarTabTarifas();
               } catch (IOException ex) {
                   
               }
           } else {
               JOptionPane.showMessageDialog(null, "Valores no admitidos", "Error", ERROR);
           }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void combOpcionesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combOpcionesItemStateChanged
        
        if ("ACUEDUCTO".equals(String.valueOf(combOpciones.getSelectedItem()))) {
            etiEstratos.setText("Estrato");
            etiTitulos.setText("($) Precio por m³");
            ArrayList<String> lista = new ArrayList<>();
        
            try {
                frmMenu menu = new frmMenu();
                List<List<Object>> datosTabla = menu.obtenerDatosTablaAcueducto();
            
                for (List<Object> fila : datosTabla) {
                    Object[] rowData = fila.toArray();
                    for (Object valor : rowData) {
                        lista.add(String.valueOf(valor));
                    }
                }
                
                txtEst1.setText(lista.get(0));
                txtVal1.setText(lista.get(1));
                txtEst2.setText(lista.get(2));
                txtVal2.setText(lista.get(3));
                txtEst3.setText(lista.get(4));
                txtVal3.setText(lista.get(5));
                txtEst4.setText(lista.get(6));
                txtVal4.setText(lista.get(7));
                txtEst5.setText(lista.get(8));
                txtVal5.setText(lista.get(9));
                txtEst6.setText(lista.get(10));
                txtVal6.setText(lista.get(11));
            } catch (Exception ex) {
            
            }
        } else if ("ALCANTARILLADO".equals(String.valueOf(combOpciones.getSelectedItem()))) {
            etiEstratos.setText("Estrato");
            etiTitulos.setText("(%) Porcentaje m³");
            ArrayList<String> lista = new ArrayList<>();
        
            try {
                frmMenu menu = new frmMenu();
                List<List<Object>> datosTabla = menu.obtenerDatosTablaAlcantarillado();
            
                for (List<Object> fila : datosTabla) {
                    Object[] rowData = fila.toArray();
                    for (Object valor : rowData) {
                        lista.add(String.valueOf(valor));
                    }
                }
                
                txtEst1.setText(lista.get(0));
                txtVal1.setText(lista.get(1));
                txtEst2.setText(lista.get(2));
                txtVal2.setText(lista.get(3));
                txtEst3.setText(lista.get(4));
                txtVal3.setText(lista.get(5));
                txtEst4.setText(lista.get(6));
                txtVal4.setText(lista.get(7));
                txtEst5.setText(lista.get(8));
                txtVal5.setText(lista.get(9));
                txtEst6.setText(lista.get(10));
                txtVal6.setText(lista.get(11));
            } catch (Exception ex) {
            
            }
        } else if ("ASEO".equals(String.valueOf(combOpciones.getSelectedItem()))) {
            etiEstratos.setText("Estrato");
            etiTitulos.setText("($) Precio por kg");
            ArrayList<String> lista = new ArrayList<>();
        
            try {
                frmMenu menu = new frmMenu();
                List<List<Object>> datosTabla = menu.obtenerDatosTablaAseo();
            
                for (List<Object> fila : datosTabla) {
                    Object[] rowData = fila.toArray();
                    for (Object valor : rowData) {
                        lista.add(String.valueOf(valor));
                    }
                }
                
                txtEst1.setText(lista.get(0));
                txtVal1.setText(lista.get(1));
                txtEst2.setText(lista.get(2));
                txtVal2.setText(lista.get(3));
                txtEst3.setText(lista.get(4));
                txtVal3.setText(lista.get(5));
                txtEst4.setText(lista.get(6));
                txtVal4.setText(lista.get(7));
                txtEst5.setText(lista.get(8));
                txtVal5.setText(lista.get(9));
                txtEst6.setText(lista.get(10));
                txtVal6.setText(lista.get(11));

            } catch (Exception ex) {
            
            }
        } else if ("SUBSIDIO".equals(String.valueOf(combOpciones.getSelectedItem()))) {
            etiEstratos.setText("Estrato");
            etiTitulos.setText("(%) Promedio de subsidio");
            ArrayList<String> lista = new ArrayList<>();
        
            try {
                frmMenu menu = new frmMenu();
                List<List<Object>> datosTabla = menu.obtenerDatosTablaSubsidio();
            
                for (List<Object> fila : datosTabla) {
                    Object[] rowData = fila.toArray();
                    for (Object valor : rowData) {
                        lista.add(String.valueOf(valor));
                    }
                }
                
                txtEst1.setText(lista.get(0));
                txtVal1.setText(lista.get(1));
                txtEst2.setText(lista.get(2));
                txtVal2.setText(lista.get(3));
                txtEst3.setText(lista.get(4));
                txtVal3.setText(lista.get(5));
                txtEst4.setText(lista.get(6));
                txtVal4.setText(lista.get(7));
                txtEst5.setText(lista.get(8));
                txtVal5.setText(lista.get(9));
                txtEst6.setText(lista.get(10));
                txtVal6.setText(lista.get(11));
            } catch (Exception ex) {
            
            }
        } else {
            etiEstratos.setText("");
            etiTitulos.setText("");
            txtEst1.setText("");
            txtVal1.setText("");
            txtEst2.setText("");
            txtVal2.setText("");
            txtEst3.setText("");
            txtVal3.setText("");
            txtEst4.setText("");
            txtVal4.setText("");
            txtEst5.setText("");
            txtVal5.setText("");
            txtEst6.setText("");
            txtVal6.setText("");
        }
    }//GEN-LAST:event_combOpcionesItemStateChanged

    private void txtEst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEst1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEst1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(frmTarifas.class.getName()).log(Level.SEVERE, null, ex);
                }
                new frmTarifas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Backgroud;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox combOpciones;
    private javax.swing.JLabel etiEstratos;
    private javax.swing.JLabel etiTablaEdit;
    private javax.swing.JLabel etiTitulo;
    private javax.swing.JLabel etiTitulos;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgPerson;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlValores;
    private javax.swing.JTextField txtEst1;
    private javax.swing.JTextField txtEst2;
    private javax.swing.JTextField txtEst3;
    private javax.swing.JTextField txtEst4;
    private javax.swing.JTextField txtEst5;
    private javax.swing.JTextField txtEst6;
    private javax.swing.JTextField txtVal1;
    private javax.swing.JTextField txtVal2;
    private javax.swing.JTextField txtVal3;
    private javax.swing.JTextField txtVal4;
    private javax.swing.JTextField txtVal5;
    private javax.swing.JTextField txtVal6;
    // End of variables declaration//GEN-END:variables
}
