/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TimeAdjust.java
 *
 * Created on Jan 7, 2014, 9:22:52 AM
 */
package bellManagement.java;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class TimeAdjust extends javax.swing.JFrame {

    /** Creates new form TimeAdjust */
    DataInputStream file;
    int nTime;
    int delay;
    String time[];
    int tTime[][];
    String ofc[];
    
    public TimeAdjust() {
        try{
            file=new DataInputStream(new FileInputStream(MainMenu.txtfile));
            nTime=Integer.parseInt(file.readLine());
            delay=Integer.parseInt(file.readLine());
            time = new String[nTime];
            tTime = new int[nTime][3];
            ofc=new String[nTime];
            
            for(int i=0;i<nTime;i++){
                time[i]="00:00:00";
                tTime[i][0]=0;
                tTime[i][1]=0;
                tTime[i][2]=0;
                ofc[i]="OFF";
            }
            
            for(int i=0;i<nTime;i++){
                String str=file.readLine();
                if(str.equals("")){
                    str="00:00:00,OFF";
                }
                
                int dum=0;
                String s="";
                for(int j=0;j<str.length();j++){
                    char ch=str.charAt(j);
                    
                    if(ch==':'){
                        dum++;
                        s="";
                    }
                    else if(ch==','){
                        dum=10;
                        s="";
                    }
                    else
                        s=s+ch;
                    
                    if(s.length()>=1 && dum!=10){
                    if(dum<3)
                        tTime[i][dum]=Integer.parseInt(s);
                    }
                    else
                        ofc[i]=s;
                    
                }
                time[i]=String.valueOf(tTime[i][0])+":"+String.valueOf(tTime[i][1])+":"+String.valueOf(tTime[i][2]);
            }
            file.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        initComponents();
        tSlot.setValue(nTime);
        tDur.setValue(delay);
        if(MainMenu.txtfile.equals("time1.txt"))
            dayBox.setSelectedIndex(0);
        if(MainMenu.txtfile.equals("time2.txt"))
            dayBox.setSelectedIndex(1);
        if(MainMenu.txtfile.equals("time3.txt"))
            dayBox.setSelectedIndex(2);

    }

    //change the file name to static variable denoting the name of text file
    void UpdateTslots(){    //Add this fuction to the Item Value changed function of JComboBox containing day of week
        try{
            file=new DataInputStream(new FileInputStream(MainMenu.txtfile));//Change to the valid variable name
            nTime=Integer.valueOf(file.readLine());
            delay=Integer.valueOf(file.readLine());
            try{
            tSlot.setValue(nTime);
            tDur.setValue(delay);
            }catch(Exception ex){JOptionPane.showMessageDialog(this, ex);}
            file.close();
        }catch(Exception ex){        }
    }
    void initializeTime(){  //Add this to saveSettings() function at the top
        try{
            file=new DataInputStream(new FileInputStream(MainMenu.txtfile));//Change to the valid variable name
            file.readLine();
            file.readLine();
            time = new String[nTime];
            tTime = new int[nTime][3];
            ofc=new String[nTime];
            
            for(int i=0;i<nTime;i++){
                time[i]="00:00:00";
                tTime[i][0]=0;
                tTime[i][1]=0;
                tTime[i][2]=0;
                ofc[i]="OFF";
            }
            
            for(int i=0;i<nTime;i++){
                String str="";
                try{
                    str=file.readLine();
                }catch(NullPointerException ex){str="00:00:00,OFF";}
                
                int dum=0;
                String s="";
                try{
                for(int j=0;j<str.length();j++){
                    char ch=str.charAt(j);
                    
                    if(ch==':'){
                        dum++;
                        s="";
                    }
                    else if(ch==','){
                        dum=10;
                        s="";
                    }
                    else
                        s=s+ch;
                    
                    if(s.length()>=1 && dum!=10){
                    if(dum<3)
                       tTime[i][dum]=Integer.parseInt(s);
                    }
                    else
                        ofc[i]=s;
                    
                }
                }catch(NullPointerException ex){}
                
                time[i]=String.valueOf(tTime[i][0])+":"+String.valueOf(tTime[i][1])+":"+String.valueOf(tTime[i][2]);
            }
            file.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
        tSlot.setValue(nTime);
        tDur.setValue(delay);

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
        jButton1 = new javax.swing.JButton();
        tSlot = new javax.swing.JSpinner();
        tDur = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        heading1 = new javax.swing.JLabel();
        heading2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dayBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("No. of Time Slots");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Time Duration");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        heading1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        heading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading1.setText("De Nobili School, CMRI");

        heading2.setFont(new java.awt.Font("Times New Roman", 1, 16));
        heading2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading2.setText("Bell Management");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Day Settings");

        dayBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal Day", "Weekly Test", "Half Day" }));
        dayBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                UpdateTslots(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
            .addComponent(heading1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
            .addComponent(heading2, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dayBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tSlot)
                            .addComponent(tDur, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(heading1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heading2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tDur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    delay=Integer.parseInt(String.valueOf(tDur.getValue()));
    nTime=Integer.parseInt(String.valueOf(tSlot.getValue()));
    if(dayBox.getSelectedIndex()==0)
        MainMenu.txtfile="time1.txt";
    else if(dayBox.getSelectedIndex()==1)
        MainMenu.txtfile="time2.txt";
    else if(dayBox.getSelectedIndex()==2)
        MainMenu.txtfile="time3.txt";
    
    initializeTime();
    saveSettings();
    dispose();
    new MainMenu().setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed

private void UpdateTslots(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_UpdateTslots
    if(dayBox.getSelectedIndex()==0)
        MainMenu.txtfile="time1.txt";
    else if(dayBox.getSelectedIndex()==1)
        MainMenu.txtfile="time2.txt";
    else if(dayBox.getSelectedIndex()==2)
        MainMenu.txtfile="time3.txt";
    UpdateTslots();
}//GEN-LAST:event_UpdateTslots
private void saveSettings() {                                             
    try{
        DataOutputStream file=new DataOutputStream(new FileOutputStream(MainMenu.txtfile));
        file.flush();
        file.writeBytes(nTime+"\n"+String.valueOf(delay)+"\n");
        for(int i=0;i<nTime;i++){
            file.writeBytes(time[i]+",");
            if(ofc[i].equals("ON"))
                file.writeBytes("ON"+"\n");
            else
                file.writeBytes("OFF"+"\n");
        }
        JOptionPane.showMessageDialog(this, "Save Successful !!!!!!");
    }catch(Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage());}
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
            java.util.logging.Logger.getLogger(TimeAdjust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeAdjust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeAdjust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeAdjust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TimeAdjust().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox dayBox;
    private javax.swing.JLabel heading1;
    private javax.swing.JLabel heading2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner tDur;
    private javax.swing.JSpinner tSlot;
    // End of variables declaration//GEN-END:variables
}
