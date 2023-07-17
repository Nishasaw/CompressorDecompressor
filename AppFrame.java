package GUI;

import com_decomp.Compressor;
import com_decomp.Decompressor;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;


public class AppFrame extends JFrame implements ActionListener {
    JButton CompressButton;
    JButton DecompressButton;
    AppFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        CompressButton=new JButton("Select file to Compress");
        CompressButton.setBounds(500,100,200,40);
        CompressButton.addActionListener(this);
        this.add(CompressButton);

        DecompressButton=new JButton("Select file to Decompress");
        DecompressButton.setBounds(30,100,200,40);
        DecompressButton.addActionListener(this);
        this.add(DecompressButton);

        this.add(CompressButton);
        this.add(DecompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.cyan);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
       if (e.getSource()==CompressButton)
       {
           JFileChooser fileChooser=new JFileChooser();
           int response=fileChooser.showSaveDialog(null);
           if(response==JFileChooser.APPROVE_OPTION){
              File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
              System.out.print(file);
              try{
                  Compressor.method(file);
              }
              catch(Exception ee)
              {
                  JOptionPane.showMessageDialog(null,ee.toString());
              }
           }
       }
        if (e.getSource()==DecompressButton)
        {
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }




}

