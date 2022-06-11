/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaEscritorio;

import controlador.ControladorCerrarMesa;
import modelo.Servicio;
import controlador.VistaCerrarMesaInterface;
import javax.swing.JOptionPane;
/**
 *
 * @author faustoperillo
 */
public class VistaCerrarMesa extends javax.swing.JDialog implements VistaCerrarMesaInterface {

    private ControladorCerrarMesa controladorCerrarMesa;
    /**
     * Creates new form CerrarMesaCliente
     */
    public VistaCerrarMesa(java.awt.Frame parent, boolean modal, Servicio servicio) {
        super(parent, modal);
        initComponents();
        controladorCerrarMesa = new ControladorCerrarMesa(this, servicio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idCliente = new javax.swing.JTextField();
        buscarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        totalSinBeneficio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nombreBeneficio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        totalBeneficio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        totalAPagar = new javax.swing.JTextField();
        buttonConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ingrese ID cliente:");

        buscarCliente.setText("Buscar");
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Cliente:");

        nombreCliente.setEditable(false);
        nombreCliente.setFont(new java.awt.Font("Lucida Grande", 3, 16)); // NOI18N
        nombreCliente.setFocusable(false);
        nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Total sin beneficio:");

        totalSinBeneficio.setEditable(false);

        jLabel4.setText("Beneficio:");

        nombreBeneficio.setEditable(false);

        jLabel5.setText("Total beneficio:");

        totalBeneficio.setEditable(false);

        jLabel6.setText("Total a pagar:");

        totalAPagar.setEditable(false);
        totalAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAPagarActionPerformed(evt);
            }
        });

        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonConfirmar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalSinBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nombreBeneficio)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalBeneficio)
                                    .addComponent(totalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarCliente)
                    .addComponent(jLabel2)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(nombreBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(totalSinBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(buttonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        buscarClienteIngresado();
    }//GEN-LAST:event_buscarClienteActionPerformed

    private void nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreClienteActionPerformed

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
        controladorCerrarMesa.cerrarMesa();
    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void totalAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarCliente;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JTextField idCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nombreBeneficio;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JTextField totalAPagar;
    private javax.swing.JTextField totalBeneficio;
    private javax.swing.JTextField totalSinBeneficio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void buscarClienteIngresado() {
        String idIngresado = idCliente.getText();
        controladorCerrarMesa.buscarCliente(idIngresado);
    }
    
    @Override
    public void cargarNombreCliente(String nombre) {
        nombreCliente.setText(nombre);
    }
    
    @Override
    public void mostrarTotalServicio(float total) {
        totalSinBeneficio.setText(Float.toString(total));
    }
    
    @Override
    public void cargarTotalBeneficio(float montoDescuento) {
        totalBeneficio.setText(Float.toString(montoDescuento));
    }
    
    @Override
    public void cargarTotalAPagar(float montoTotalMenosBeneficio) {
        totalAPagar.setText(Float.toString(montoTotalMenosBeneficio));
    }
    
    @Override
    public void mostrarNombreBeneficio(String nombre) {
        nombreBeneficio.setText(nombre);
    }
    
    @Override
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    
    @Override
    public void limpiarIdCliente() {
        idCliente.setText("");
    }
}
