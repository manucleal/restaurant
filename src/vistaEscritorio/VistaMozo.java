/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorMozo;
import controlador.VistaMozoInterface;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.ItemServicio;
import modelo.Mesa;
import modelo.Producto;
import modelo.Servicio;


/**
 *
 * @author ecoitino
 */
public class VistaMozo extends javax.swing.JDialog implements VistaMozoInterface {

    public ControladorMozo controladorMozo;
    /**
     * Creates new form vistaMozo
     */
    public VistaMozo(java.awt.Frame parent, boolean modal, Conexion conexion) {
        super(parent, modal);
        setLocationRelativeTo(parent);
        initComponents();
        setSize(new Dimension(1000, 800));
        controladorMozo = new ControladorMozo(this, conexion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButtons = new javax.swing.JPanel();
        abrirMesa = new javax.swing.JButton();
        cerrarMesa = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        buttonAgregarProducto = new javax.swing.JButton();
        labelMesa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textFieldCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatosServicio = new javax.swing.JTable();
        comboBoxProductosConStock = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        totalServicio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelButtons.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelButtons.setMinimumSize(new java.awt.Dimension(500, 100));
        panelButtons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        abrirMesa.setText("Abrir");
        abrirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMesaActionPerformed(evt);
            }
        });

        cerrarMesa.setText("Cerrar");
        cerrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarMesaActionPerformed(evt);
            }
        });

        jButton3.setText("Transferir");

        buttonAgregarProducto.setText("Agregar Producto");
        buttonAgregarProducto.setDoubleBuffered(true);
        buttonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarProductoActionPerformed(evt);
            }
        });

        labelMesa.setEditable(false);
        labelMesa.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        labelMesa.setActionCommand("<Not Set>");
        labelMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelMesaActionPerformed(evt);
            }
        });

        jLabel1.setText("Producto:");

        jLabel2.setText("Descripción:");

        jLabel3.setText("Cantidad:");

        tableDatosServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Descripción", "Precio Unitario", "Sub total", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDatosServicio);
        if (tableDatosServicio.getColumnModel().getColumnCount() > 0) {
            tableDatosServicio.getColumnModel().getColumn(0).setResizable(false);
            tableDatosServicio.getColumnModel().getColumn(1).setResizable(false);
            tableDatosServicio.getColumnModel().getColumn(2).setResizable(false);
            tableDatosServicio.getColumnModel().getColumn(3).setResizable(false);
            tableDatosServicio.getColumnModel().getColumn(4).setResizable(false);
            tableDatosServicio.getColumnModel().getColumn(5).setResizable(false);
        }

        comboBoxProductosConStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProductosConStockActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4.setText("Total:");

        totalServicio.setEditable(false);
        totalServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(comboBoxProductosConStock, 0, 136, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(abrirMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cerrarMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(labelMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(abrirMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cerrarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(textFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxProductosConStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelMesaActionPerformed
         
    }//GEN-LAST:event_labelMesaActionPerformed

    private void abrirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirMesaActionPerformed
        controladorMozo.abrirMesa();
    }//GEN-LAST:event_abrirMesaActionPerformed

    private void cerrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarMesaActionPerformed
        //si es cliente abro dialog para ingresar datos, sino cierro mesa
        controladorMozo.cerrarMesa();
    }//GEN-LAST:event_cerrarMesaActionPerformed

    private void buttonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarProductoActionPerformed
        String descripcion = textFieldDescripcion.getText();
        String cantidad = textFieldCantidad.getText();
        Producto producto = (Producto)comboBoxProductosConStock.getSelectedItem();
        controladorMozo.agregarProducto(producto, descripcion, cantidad);
    }//GEN-LAST:event_buttonAgregarProductoActionPerformed

    private void comboBoxProductosConStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProductosConStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProductosConStockActionPerformed

    private void totalServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalServicioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controladorMozo.logout();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirMesa;
    private javax.swing.JButton buttonAgregarProducto;
    private javax.swing.JButton cerrarMesa;
    private javax.swing.JComboBox comboBoxProductosConStock;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField labelMesa;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JTable tableDatosServicio;
    private javax.swing.JTextField textFieldCantidad;
    private javax.swing.JTextField textFieldDescripcion;
    private javax.swing.JTextField totalServicio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarNombreUsuario(String nombreCompleto) {
        setTitle("Atención de mesas | Mozo: " + nombreCompleto);
    }

    @Override
    public void mostrarMesas(ArrayList<Mesa> mesas) {
        panelButtons.setLayout(new GridLayout(2, 3));        
        for (Mesa mesa : mesas) {
            Clicklistener click = new Clicklistener();
            JButtonMesa button = new JButtonMesa("Mesa " + mesa.getNumero());
            button.setMesa(mesa);
            button.addActionListener(click);            
            button.setMargin(new Insets(2, 2, 2, 2));
            button.setOpaque(true);
            panelButtons.add(button);
        }
    }
    
    @Override
    public void mostrarLabelMesa(int nombreMesa) {
        labelMesa.setText("Mesa " + nombreMesa);
    }
    
    @Override
    public void mostrarDatosServicio(ArrayList<ItemServicio> items) {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Producto");
        modelTable.addColumn("Cantidad");
        modelTable.addColumn("Descripción");
        modelTable.addColumn("Precio Unitario");
        modelTable.addColumn("Sub total");
        modelTable.addColumn( "Estado");
        modelTable.setRowCount(items.size());
        int contador = 0;
        
        for(ItemServicio item : items) {
            modelTable.setValueAt(item.getProducto().getNombre(), contador , 0);
            modelTable.setValueAt(item.getCantidad(), contador , 1);
            modelTable.setValueAt(item.getDescripcion(), contador , 2);
            modelTable.setValueAt(item.getProducto().getPrecio(), contador , 3);
            modelTable.setValueAt(item.getSubTotal(), contador , 4);
            modelTable.setValueAt("", contador , 5);
            contador++;
        }
        tableDatosServicio.setModel(modelTable);
    }
    
    @Override
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void llamarVentanaCerrarMesaCliente(Servicio servicio) {
        new VistaCerrarMesaCliente(null,false,servicio).setVisible(true);
    }
    
    @Override
    public void mostrarProductosConStock(ArrayList<Producto> productos) {
        comboBoxProductosConStock.removeAllItems();
        productos.forEach(producto -> comboBoxProductosConStock.addItem(producto));
    }

    @Override
    public void limpiarInputProducto() {
        textFieldCantidad.setText(null);
        textFieldDescripcion.setText(null);
    }
    
    @Override
    public void mostrarTotalServicio(float total) {
        totalServicio.setText(Float.toString(total));
    }
    
    private class Clicklistener implements ActionListener {        
        @Override
        public void actionPerformed(ActionEvent e) {
            JButtonMesa jButtonMesa = (JButtonMesa)e.getSource();
            Mesa mesa = jButtonMesa.getMesa();
            controladorMozo.cargarDatosMesaSeleccionada(mesa);
        }    
    }
    
    private class JButtonMesa extends JButton {
    
        private Mesa mesa;

        public JButtonMesa(String text) {
            super(text);
        }

        public Mesa getMesa() {
            return mesa;
        }

        public void setMesa(Mesa mesa) {
            this.mesa = mesa;
        }                    
    }       
}
