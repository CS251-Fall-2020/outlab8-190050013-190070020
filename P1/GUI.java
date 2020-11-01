import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class GUI{
  JFrame f;
  JTable j;
  JButton file;
  JButton process;
  JScrollPane sp;
  ArrayList<String> plainText;
  ArrayList<String> results;
  String filePath;
  String columns[] = {"plaintext","results"};
  DefaultTableModel model;

  GUI()
  {
    plainText = new ArrayList<String>(0);
    results = new ArrayList<String>(0);
    filePath = "";

    f = new JFrame();
    file = new JButton("Select File");
    process = new JButton("Process");
    j = new JTable();
    final DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columns);
    j.setModel(model);

    j.setRowHeight(30);
    //final JTextField PlainTextField = new JTextField();
    //final JTextField ResultsField = new JTextField();

    //PlainTextField.setBounds(20,220,100,25);
    //ResultsField.setBounds(20,310,100,25);

    sp = new JScrollPane(j);
    sp.setBounds(0,0,880,220);

    file.setBounds(50, 300, 100, 25);
    process.setBounds(250, 300, 100, 25);

    f.setLayout(null);
    f.add(sp);
    //f.add(PlainTextField);
    //f.add(ResultsField);
    f.add(file);
    f.add(process);

    f.setSize(900,400);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);


    file.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(f);
        if(returnVal == JFileChooser.APPROVE_OPTION){
        filePath = fc.getSelectedFile().getName();
      }
      }
    });


    process.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e)
      {
        try{
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line = "";

        try{
        while((line = br.readLine()) != null)
        {

          int lastIndexOfHyphen = line.lastIndexOf("-");
          String[] contents = new String[2];
          contents[0] = line.substring(0,lastIndexOfHyphen - 1);
          contents[1] = line.substring(lastIndexOfHyphen + 1).trim();


          try
          {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(contents[0].getBytes());
            BigInteger calculatedMD5 = new BigInteger(1, messageDigest);
            String givenMD5 = contents[1].trim();
            String calculatedMD5_string = calculatedMD5.toString(16);
            plainText.add(contents[0]);

            while( calculatedMD5_string.length() < 32)
            {
              calculatedMD5_string = "0" + calculatedMD5_string;
            }

            if(calculatedMD5_string.equals(givenMD5))
            {
              results.add("verified");
            }
            else
            {
              results.add("not verified");
            }
          }

          catch(NoSuchAlgorithmException E)
          {
            throw new RuntimeException(E);
          }
        }
      }
      catch(IOException E)
      {
        throw new RuntimeException(E);
      }
      catch(Exception E)
      {
        throw new RuntimeException(E);
      }

        for(int i = model.getRowCount(); i > 0; i--)
        {
          model.removeRow(i - 1);
        }

        String[] data = new String[2];

        for(int i = 0; i < results.size(); i++)
        {
          data[0] = plainText.get(i);
          data[1] = results.get(i);

          model.addRow(data);
        }
      }
      catch(FileNotFoundException F)
      {
        throw new RuntimeException(F);
      }



      }


    });

  }

  public static void main(String[] args)
  {
    try{
      GUI queryGUI = new GUI();
    }
    catch(Exception e)
    {
      throw new RuntimeException(e);
    }
  }

}
