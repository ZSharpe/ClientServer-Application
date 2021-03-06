
package clientserver;
import java.io.*;
import java.net.*;

public class Client extends javax.swing.JFrame {

    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RetrieveProduct = new javax.swing.JButton();
        retrieveCustomer = new javax.swing.JButton();
        rpNext = new javax.swing.JButton();
        rpPrevious = new javax.swing.JButton();
        rcNext = new javax.swing.JButton();
        rcPrevious = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        exit = new javax.swing.JButton();
        update = new javax.swing.JButton();
        record = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RetrieveProduct.setText("Retrieve Product");
        RetrieveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetrieveProductActionPerformed(evt);
            }
        });

        retrieveCustomer.setText("Retrieve Customer");
        retrieveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveCustomerActionPerformed(evt);
            }
        });

        rpNext.setText("Next");
        rpNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpNextActionPerformed(evt);
            }
        });

        rpPrevious.setText("Previous");
        rpPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpPreviousActionPerformed(evt);
            }
        });

        rcNext.setText("Next");

        rcPrevious.setText("Previous");

        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        record.setText("Enter a Record!");
        record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(record)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RetrieveProduct)
                                    .addComponent(rpPrevious)
                                    .addComponent(update))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rpNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(retrieveCustomer)
                            .addComponent(rcNext)
                            .addComponent(rcPrevious)
                            .addComponent(exit))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RetrieveProduct)
                    .addComponent(retrieveCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rpNext)
                    .addComponent(rcNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rpPrevious)
                    .addComponent(rcPrevious))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(record, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RetrieveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetrieveProductActionPerformed
        
        try{
        output.writeObject("Retrieve");
        output.flush();
        display.setText((String)input.readObject()); 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_RetrieveProductActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
       
        try{
        output.writeObject("Update");
        output.writeObject(record.getText());
        output.flush();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recordActionPerformed

    private void rpNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpNextActionPerformed
        try{
        output.writeObject("Next");
        output.flush();
        display.setText((String)input.readObject()); 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_rpNextActionPerformed

    private void rpPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpPreviousActionPerformed
        try{
        output.writeObject("Previous");
        output.flush();
        display.setText((String)input.readObject()); 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_rpPreviousActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void retrieveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retrieveCustomerActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnknownHostException,IOException,ClassNotFoundException,InterruptedException{ 
        Client client = new Client();
        
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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Client().setVisible(true);
                client.setVisible(true);
            }
            
        });
        
        client.startSocket();
    }
    
    //Class Variable Declaration
    ObjectOutputStream output;
    ObjectInputStream input;
    Socket socket;
    String m = "new text!";
    
    //Initialization for socket / server connection.
    private void startSocket(){
        try{
            
        socket = new Socket("127.0.0.1",9001);    
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        //String message = (String)input.readObject();
        
        record.setText((String)input.readObject());
        
        
        }catch(Exception e){
            System.out.println("Exception Occured: \n" + e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RetrieveProduct;
    private javax.swing.JTextArea display;
    private javax.swing.JButton exit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rcNext;
    private javax.swing.JButton rcPrevious;
    private javax.swing.JTextField record;
    private javax.swing.JButton retrieveCustomer;
    private javax.swing.JButton rpNext;
    private javax.swing.JButton rpPrevious;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
