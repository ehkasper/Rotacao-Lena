/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * main.java
 *
 * Created on Mar 28, 2013, 8:51:04 PM
 */
package view;

import controller.MainController;
import java.awt.Color;
import javax.swing.JFileChooser;

/**
 *
 * @author eduardo
 */
public class Main extends javax.swing.JFrame {
    private MainController controller;
    private int zoom = 0;
    
    /** Creates new form main */
    public Main() {
        initComponents();
        getContentPane().setBackground(Color.WHITE); 
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btImageChooser = new javax.swing.JButton();
        fieldImagePath = new javax.swing.JTextField();
        panelValues = new javax.swing.JPanel();
        btnHistograma = new javax.swing.JButton();
        lblTitleMediana = new javax.swing.JLabel();
        lblMediana = new javax.swing.JLabel();
        lblTitleMedia = new javax.swing.JLabel();
        lblMedia = new javax.swing.JLabel();
        lblVariancia = new javax.swing.JLabel();
        lblTitleModa = new javax.swing.JLabel();
        lblModa = new javax.swing.JLabel();
        lblTitleVariancia = new javax.swing.JLabel();
        lblImagemOriginal = new javax.swing.JLabel();
        lblImagemProcessada = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitleTrabalho1 = new javax.swing.JLabel();
        comboTrabalho1 = new javax.swing.JComboBox();
        lblTitleTrabalho2 = new javax.swing.JLabel();
        comboAngulo = new javax.swing.JSpinner();
        btnZoomIn = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        btnEspelhar = new javax.swing.JButton();
        lblResizebleImage = new javax.swing.JLabel();
        panelProcessedImage = new javax.swing.JScrollPane();
        lblProcessedImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comp. Gráfica");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("mainFrame"); // NOI18N
        setResizable(false);

        btImageChooser.setText("Escolher Imagem");
        btImageChooser.setToolTipText("Ao clicar, escolha uma imagem a partir de seu computador");
        btImageChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImageChooserActionPerformed(evt);
            }
        });

        fieldImagePath.setEnabled(false);
        fieldImagePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldImagePathActionPerformed(evt);
            }
        });

        panelValues.setOpaque(false);

        btnHistograma.setText("Histograma");
        btnHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistogramaActionPerformed(evt);
            }
        });

        lblTitleMediana.setText("Mediana");

        lblMediana.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblMediana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTitleMedia.setText("Média");

        lblMedia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblMedia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblVariancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblVariancia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTitleModa.setText("Moda");

        lblModa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblModa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTitleVariancia.setText("Variância");
        lblTitleVariancia.setBorder(null);

        javax.swing.GroupLayout panelValuesLayout = new javax.swing.GroupLayout(panelValues);
        panelValues.setLayout(panelValuesLayout);
        panelValuesLayout.setHorizontalGroup(
            panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValuesLayout.createSequentialGroup()
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblModa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitleModa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleVariancia)
                    .addComponent(lblVariancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitleMedia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleMediana)
                    .addComponent(lblMediana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistograma)
                .addContainerGap())
        );
        panelValuesLayout.setVerticalGroup(
            panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValuesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleVariancia)
                    .addComponent(lblTitleMediana)
                    .addComponent(lblTitleMedia)
                    .addComponent(lblTitleModa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMediana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistograma)
                    .addComponent(lblMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblModa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVariancia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblImagemOriginal.setText("Imagem Original");

        lblImagemProcessada.setText("Imagem Processada");

        jPanel1.setOpaque(false);

        lblTitleTrabalho1.setText("Trabalho 1");

        comboTrabalho1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "A", "B", "C", "D", "E" }));
        comboTrabalho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTrabalho1ActionPerformed(evt);
            }
        });

        lblTitleTrabalho2.setText("Trabalho 2");

        comboAngulo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                comboAnguloStateChanged(evt);
            }
        });
        comboAngulo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                comboAnguloInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        btnZoomIn.setText("+");
        btnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomInActionPerformed(evt);
            }
        });

        btnZoomOut.setText("-");
        btnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOutActionPerformed(evt);
            }
        });

        btnEspelhar.setText("Espelhar");
        btnEspelhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspelharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleTrabalho1)
                    .addComponent(comboTrabalho1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitleTrabalho2)
                    .addComponent(btnEspelhar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAngulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZoomIn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleTrabalho1)
                    .addComponent(lblTitleTrabalho2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTrabalho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAngulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZoomIn)
                    .addComponent(btnZoomOut)
                    .addComponent(btnEspelhar))
                .addContainerGap())
        );

        lblResizebleImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelProcessedImage.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelProcessedImage.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lblProcessedImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblProcessedImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProcessedImageMouseEntered(evt);
            }
        });
        panelProcessedImage.setViewportView(lblProcessedImage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btImageChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagemOriginal)
                            .addComponent(panelValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResizebleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImagemProcessada)
                                    .addComponent(panelProcessedImage, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(80, 80, 80)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btImageChooser)
                    .addComponent(fieldImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImagemOriginal)
                    .addComponent(lblImagemProcessada))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProcessedImage, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(lblResizebleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btImageChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImageChooserActionPerformed
    
    JFileChooser fileChooser =  new JFileChooser();
    
    fileChooser.setDialogTitle("Abrir Imagem");
    
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
    int result = fileChooser.showOpenDialog(this);
    
    if (result != 1)
    {
        zoom = 0;
        controller = new MainController(this, fileChooser.getSelectedFile());
    }


}//GEN-LAST:event_btImageChooserActionPerformed

private void fieldImagePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldImagePathActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_fieldImagePathActionPerformed

private void btnHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistogramaActionPerformed
    (new Histograma(controller.getImagem())).setVisible(true);
}//GEN-LAST:event_btnHistogramaActionPerformed

private void comboTrabalho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTrabalho1ActionPerformed

    
    if( comboTrabalho1.getSelectedIndex() >= 0 && comboTrabalho1.getSelectedIndex() < 6)
    {
        controller.transformTrabalhoUm(comboTrabalho1.getSelectedIndex());
    }
    
}//GEN-LAST:event_comboTrabalho1ActionPerformed

private void lblProcessedImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProcessedImageMouseEntered
}//GEN-LAST:event_lblProcessedImageMouseEntered

private void comboAnguloInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_comboAnguloInputMethodTextChanged

}//GEN-LAST:event_comboAnguloInputMethodTextChanged

private void comboAnguloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_comboAnguloStateChanged
    
    controller.transformTrabalhoDois(Float.parseFloat(comboAngulo.getValue().toString()));
       
}//GEN-LAST:event_comboAnguloStateChanged

private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed
    zoom++;
    zoom = zoom == -1 ? 0 : zoom;
    controller.transformZoom(zoom);
    btnZoomOut.setEnabled(zoom > -2);
}//GEN-LAST:event_btnZoomInActionPerformed

private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed
    zoom--;
    zoom = zoom == -1 ? -2 : zoom;
    controller.transformZoom(zoom);
    btnZoomOut.setEnabled(zoom > -2);
}//GEN-LAST:event_btnZoomOutActionPerformed

    private void btnEspelharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspelharActionPerformed
        controller.transformEspelhada();
    }//GEN-LAST:event_btnEspelharActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImageChooser;
    private javax.swing.JButton btnEspelhar;
    private javax.swing.JButton btnHistograma;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private javax.swing.JSpinner comboAngulo;
    private javax.swing.JComboBox comboTrabalho1;
    public javax.swing.JTextField fieldImagePath;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImagemOriginal;
    private javax.swing.JLabel lblImagemProcessada;
    public javax.swing.JLabel lblMedia;
    public javax.swing.JLabel lblMediana;
    public javax.swing.JLabel lblModa;
    public javax.swing.JLabel lblProcessedImage;
    public javax.swing.JLabel lblResizebleImage;
    private javax.swing.JLabel lblTitleMedia;
    private javax.swing.JLabel lblTitleMediana;
    private javax.swing.JLabel lblTitleModa;
    private javax.swing.JLabel lblTitleTrabalho1;
    private javax.swing.JLabel lblTitleTrabalho2;
    private javax.swing.JLabel lblTitleVariancia;
    public javax.swing.JLabel lblVariancia;
    public javax.swing.JScrollPane panelProcessedImage;
    private javax.swing.JPanel panelValues;
    // End of variables declaration//GEN-END:variables

}