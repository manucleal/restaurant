/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLogin;
import controlador.VistaLoginInterface;
import javax.swing.JOptionPane;

/**
 *
 * @author ecoitino
 */
public abstract class VistaLogin extends javax.swing.JDialog implements VistaLoginInterface {

    protected ControladorLogin controladorLogin;

    /**
     * Creates new form Login
     */
    public VistaLogin(java.awt.Frame parent, boolean modal, String title) {
        super(parent, modal);
        initComponents();
        setTitle(title);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bIngresar.setText("Ingresar");
        bIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIngresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Usuario:");

        jLabel2.setText("Contraseña:");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(tfPassword))
                        .addGap(97, 97, 97))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(bIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIngresarActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_bIngresarActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_tfNombreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JPasswordField tfPassword;
    // End of variables declaration//GEN-END:variables

    private void login() {
        String nombreUsuario = tfNombre.getText();
        String password = new String(tfPassword.getPassword());
        login(nombreUsuario, password);
    }

    @Override
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    protected abstract void login(String nombreUsuario, String password);

    public abstract void llamarProximoCasoUso(Object obj);
}
