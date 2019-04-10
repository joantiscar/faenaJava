/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CancionesStore.java
 *
 * Created on Jun 17, 2009, 11:43:48 AM
 */
package view;

import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Album;
import model.Cancion;
/**
 *
 * @author nb
 */
public class Vista extends javax.swing.JFrame {

    /** Creates new form DVDStoreAdmin */
    public Vista() {
        initComponents();
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancionNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cancionDuracioTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        cancionDeleteButton = new javax.swing.JButton();
        cancionInsertButton = new javax.swing.JButton();
        cancionModifyButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        albumDeleteButton = new javax.swing.JButton();
        albumInsertButton = new javax.swing.JButton();
        albumModifyButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AlbumNameTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        albumArtistaTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        albumResultTable = new javax.swing.JTable();
        albumDataTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cançons");

        jLabel2.setText("Nom");

        jLabel3.setText("Duracio");

        cancionDuracioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancionDuracioTextFieldActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nom", "Duracio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(resultTable);

        cancionDeleteButton.setText("Borrar");

        cancionInsertButton.setText("Afegir cançó a l'album seleccionat");
        cancionInsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancionInsertButtonActionPerformed(evt);
            }
        });

        cancionModifyButton.setText("Modificar");

        jLabel5.setText("Data");

        albumDeleteButton.setText("Borrar");

        albumInsertButton.setText("Insertar");
        albumInsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumInsertButtonActionPerformed(evt);
            }
        });

        albumModifyButton.setText("Modificar");

        jLabel6.setText("Albums");

        jLabel7.setText("Nom");

        jLabel8.setText("Artista");

        albumArtistaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumArtistaTextFieldActionPerformed(evt);
            }
        });

        albumResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nom", "Artista", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(albumResultTable);

        albumDataTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumDataTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancionNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancionDuracioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancionInsertButton)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancionModifyButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancionDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AlbumNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(albumArtistaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(albumDataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(albumModifyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(albumInsertButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addComponent(albumDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(albumDataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(albumModifyButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(albumDeleteButton)
                        .addComponent(albumInsertButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AlbumNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(albumArtistaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancionInsertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancionDuracioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cancionNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancionModifyButton)
                            .addComponent(cancionDeleteButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancionDuracioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancionDuracioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancionDuracioTextFieldActionPerformed

    private void cancionInsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancionInsertButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancionInsertButtonActionPerformed

    private void albumInsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumInsertButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_albumInsertButtonActionPerformed

    private void albumArtistaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumArtistaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_albumArtistaTextFieldActionPerformed

    private void albumDataTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumDataTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_albumDataTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new CancionesStore().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AlbumNameTextField;
    private javax.swing.JTextField albumArtistaTextField;
    private javax.swing.JTextField albumDataTextField;
    private javax.swing.JButton albumDeleteButton;
    private javax.swing.JButton albumInsertButton;
    private javax.swing.JButton albumModifyButton;
    private javax.swing.JTable albumResultTable;
    private javax.swing.JButton cancionDeleteButton;
    private javax.swing.JTextField cancionDuracioTextField;
    private javax.swing.JButton cancionInsertButton;
    private javax.swing.JButton cancionModifyButton;
    private javax.swing.JTextField cancionNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable resultTable;
    // End of variables declaration//GEN-END:variables



    public void albumsDisplayResult(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Nom");
        tableHeaders.add("Artista");
        tableHeaders.add("Data");

        for (Object o : resultList) {
            Album album = (Album) o;
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(album.getNom());
            oneRow.add(album.getArtista());
            oneRow.add(album.getData());
            tableData.add(oneRow);
        }
        albumResultTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        
       

    }

    public void cancionesDisplayResult(List resultList) {
 Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Nom");
        tableHeaders.add("Duracio");

        for (Object o : resultList) {
            Cancion cancion = (Cancion) o;
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(cancion.getNom());
            oneRow.add(cancion.getDuracio());
            tableData.add(oneRow);
        }
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));

    }

    public JTextField getAlbumNameTextField() {
        return AlbumNameTextField;
    }

    public void setAlbumNameTextField(JTextField AlbumNameTextField) {
        this.AlbumNameTextField = AlbumNameTextField;
    }

    public JTextField getAlbumArtistaTextField() {
        return albumArtistaTextField;
    }

    public void setAlbumArtistaTextField(JTextField albumArtistaTextField) {
        this.albumArtistaTextField = albumArtistaTextField;
    }

    public JTextField getAlbumDataTextField() {
        return albumDataTextField;
    }

    public void setAlbumDataTextField(JTextField albumDataTextField) {
        this.albumDataTextField = albumDataTextField;
    }

    public JButton getAlbumDeleteButton() {
        return albumDeleteButton;
    }

    public void setAlbumDeleteButton(JButton albumDeleteButton) {
        this.albumDeleteButton = albumDeleteButton;
    }

    public JButton getAlbumInsertButton() {
        return albumInsertButton;
    }

    public void setAlbumInsertButton(JButton albumInsertButton) {
        this.albumInsertButton = albumInsertButton;
    }

    public JButton getAlbumModifyButton() {
        return albumModifyButton;
    }

    public void setAlbumModifyButton(JButton albumModifyButton) {
        this.albumModifyButton = albumModifyButton;
    }

    public JTable getAlbumResultTable() {
        return albumResultTable;
    }

    public void setAlbumResultTable(JTable albumResultTable) {
        this.albumResultTable = albumResultTable;
    }

    public JButton getCancionDeleteButton() {
        return cancionDeleteButton;
    }

    public void setCancionDeleteButton(JButton cancionDeleteButton) {
        this.cancionDeleteButton = cancionDeleteButton;
    }

    public JTextField getCancionDuracioTextField() {
        return cancionDuracioTextField;
    }

    public void setCancionDuracioTextField(JTextField cancionDuracioTextField) {
        this.cancionDuracioTextField = cancionDuracioTextField;
    }

    public JButton getCancionInsertButton() {
        return cancionInsertButton;
    }

    public void setCancionInsertButton(JButton cancionInsertButton) {
        this.cancionInsertButton = cancionInsertButton;
    }

    public JButton getCancionModifyButton() {
        return cancionModifyButton;
    }

    public void setCancionModifyButton(JButton cancionModifyButton) {
        this.cancionModifyButton = cancionModifyButton;
    }

    public JTextField getCancionNameTextField() {
        return cancionNameTextField;
    }

    public void setCancionNameTextField(JTextField cancionNameTextField) {
        this.cancionNameTextField = cancionNameTextField;
    }

    public JTable getResultTable() {
        return resultTable;
    }

    public void setResultTable(JTable resultTable) {
        this.resultTable = resultTable;
    }
    

    
 
}
