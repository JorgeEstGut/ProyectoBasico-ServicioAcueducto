/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Cmunicipio;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Municipio;

/**
 *
 * @author usuario_RCUL82
 */
public class frmMunicipios extends javax.swing.JFrame {

    private frmMenu menu;
    
    public void setMenu(frmMenu menu) {
        this.menu = menu;
    }
    /**
     * Creates new form frmMunicipios
     */
    public frmMunicipios() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Backgroud = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JPanel();
        etiNuevoMuni = new javax.swing.JLabel();
        spNuevoMuni = new javax.swing.JSeparator();
        txtNuevoMuni = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        imgPerson = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        etiTitulo = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Municipio");

        Backgroud.setBackground(new java.awt.Color(255, 255, 255));
        Backgroud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRetroceder.setBackground(new java.awt.Color(234, 234, 234));
        btnRetroceder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiNuevoMuni.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        etiNuevoMuni.setForeground(new java.awt.Color(0, 102, 255));
        etiNuevoMuni.setText("Nuevo Municipio");
        btnRetroceder.add(etiNuevoMuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        spNuevoMuni.setBackground(new java.awt.Color(255, 255, 255));
        spNuevoMuni.setForeground(new java.awt.Color(255, 255, 255));
        btnRetroceder.add(spNuevoMuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 165, 10));

        txtNuevoMuni.setBackground(new java.awt.Color(224, 224, 224));
        txtNuevoMuni.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtNuevoMuni.setForeground(new java.awt.Color(51, 51, 51));
        txtNuevoMuni.setBorder(null);
        btnRetroceder.add(txtNuevoMuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 165, 30));

        btnRegistrar.setBackground(new java.awt.Color(0, 102, 204));
        btnRegistrar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        btnRetroceder.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 110, 40));

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
        btnRetroceder.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 110, 40));

        Backgroud.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 740, 160));

        imgPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/male-clerk-at-a-convenience-store-upper-body-svgrepo-com.png"))); // NOI18N
        Backgroud.add(imgPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlTitulo.setBackground(new java.awt.Color(0, 153, 255));

        etiTitulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etiTitulo.setText("REGISTRO DE MUNICIPIO");

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aaa-barranquilla-logo-90D5360AB1-seeklogo.com.png"))); // NOI18N

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                        .addComponent(imgLogo)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                        .addComponent(etiTitulo)
                        .addGap(96, 96, 96))))
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

        Backgroud.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Backgroud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Backgroud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        String municipio = null;

        boolean ver = true;
        String msg ="";

        if (txtNuevoMuni.getText() != null) {
            municipio = txtNuevoMuni.getText().toUpperCase();
        } else {
            msg += "Campo vacio\n";
            ver = false;
        }

        if (ver) {
            Municipio M = new Municipio(municipio);

            Cmunicipio m = new Cmunicipio();

            JOptionPane.showMessageDialog(null, "Registro Guardado", "Mensaje", HEIGHT);
            try {
                m.Registrar(M);
                txtNuevoMuni.setText("");
                menu.ActualizarTabMunicipios();
            } catch (IOException ex) {
                //Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, msg + "Por favor, complete todos los campos.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(frmMunicipios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMunicipios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMunicipios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMunicipios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMunicipios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Backgroud;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel btnRetroceder;
    private javax.swing.JLabel etiNuevoMuni;
    private javax.swing.JLabel etiTitulo;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgPerson;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JSeparator spNuevoMuni;
    private javax.swing.JTextField txtNuevoMuni;
    // End of variables declaration//GEN-END:variables
}