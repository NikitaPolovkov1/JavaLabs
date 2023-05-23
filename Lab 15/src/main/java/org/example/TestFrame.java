package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.tools.JavaFileManager;

import java.awt.event.*;
import java.util.Vector;





public class TestFrame extends JFrame {


    private HashMap<String, String> students = new HashMap<String, String>();

    private DefaultListModel<String> dlm = new DefaultListModel<String>();
    public TestFrame() {
        super("Test frame");
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        students.put("Половков Н.С.", "Дата рождения: 11.03.2005\nАдрес: Кижеватова 0/3");
        students.put("Витушко А.В.", "Дата рождения: 11.04.2005\nАдрес: Кижеватова 02/3");
        students.put("Семенюк Н.С.", "Дата рождения: 11.05.2005\nАдрес: Кижеватова 62/3");
        students.put("Лукашонок Н.С.", "Дата рождения: 11.06.2005\nАдрес: Кижеватова 603/3");
        students.put("Конько Н.С.", "Дата рождения: 11.07.2005\nАдрес: Кижеватова 601/3");
        students.put("Зыль Н.С.", "Дата рождения: 11.08.2005\nАдрес: Кижеватова 602/3");
        students.put("Косило Н.С.", "Дата рождения: 11.09.2005\nАдрес: Кижеватова 6002/3");


        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextArea textArea1 = new JTextArea();
        textArea1.setBounds(300, 60, 300, 400);
        panel.add(textArea1);



        for (String string : students.keySet()) {
            dlm.add(0, string);
        }

        // Вектор данных

        JList<String> list2 = new JList<String>(dlm);


        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selected = list2.getSelectedValue();
                textArea1.setText(selected + "\n" + students.get(selected));
            }
        });

        JScrollPane jScrollPane = new JScrollPane(list2);
        jScrollPane.setBounds(0, 60, 300, 400 );
        panel.add(jScrollPane);


        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 200, 20);
        panel.add(textArea);

        JTextArea textArea2 = new JTextArea();
        textArea2.setBounds(250, 0, 200, 20);
        panel.add(textArea2);


        JButton addButton = new JButton("Добавить в список");
        addButton.setBounds(0, 25, 200, 30);
        panel.add(addButton);

        JButton readFileButton = new JButton("Открыть файл");
        readFileButton.setBounds(0, 480, 200, 30);
        panel.add(readFileButton);


        readFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(panel);
                if(option == JFileChooser.APPROVE_OPTION){
                    JSONParser jsonParser = new JSONParser();
                    try {
                        Object obj = new JSONParser().parse(new FileReader(fileChooser.getSelectedFile()));
                        JSONArray studentArray = (JSONArray) obj;
                        System.out.println(studentArray);
                        dlm.removeAllElements();
                        students.clear();
                        for (Object temp:
                             studentArray) {

                            JSONObject stud = (JSONObject) temp;
                            JSONObject stud2 =  (JSONObject) stud.get("student");
                            String value = (String) stud2.get("value");
                            System.out.println(value);

                            String key = (String) stud2.get("key");
                            System.out.println(key);
                            students.put(key, value);



                        }

                        for (String string : students.keySet()) {
                            dlm.add(0, string);
                        }
                        validate();

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }


                }else{

                }
            }
        });

        JButton createFileButton = new JButton("Записать в файл");
        createFileButton.setBounds(250, 480, 200, 30);
        panel.add(createFileButton);


        createFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(); // create filechooser
                int retVal = fileChooser.showSaveDialog(panel); // open the save dialog
                if (retVal == JFileChooser.APPROVE_OPTION) {    // check for approval
                    // create a bufferedwriter with the specified file
                    JSONArray studentList = new JSONArray();
                    for (String key : students.keySet())
                    {
                        JSONObject studentObject = new JSONObject();
                        JSONObject studentDetails = new JSONObject();
                        studentDetails.put("value", students.get(key));
                        studentDetails.put("key", key);

                        studentObject.put("student", studentDetails);

                        System.out.println(studentObject);
                        studentList.add(studentObject);

                    }

                    try (FileWriter writer = new FileWriter(fileChooser.getSelectedFile())) {
                        writer.write(studentList.toJSONString());
                        writer.flush();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });



        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String key = textArea.getText();
                String value = textArea2.getText();
                if(!CheckValues(key, value)){
                    System.out.println("введите нормальные данные");
                    textArea.setText("введите нормальные данные");
                    return;
                }
                students.put(key, value);
                dlm.add(dlm.getSize(), key);
                validate();
            }
        });

        JButton deleteButton = new JButton("Удалить из списка");
        deleteButton.setBounds(200, 25, 200 , 30);
        panel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dlm.remove(dlm.getSize() -1);
                validate();
            }
        });

        JButton deleteAllButton = new JButton("Удалить всё");
        deleteAllButton.setBounds(400, 25, 200, 30);
        panel.add(deleteAllButton);

        deleteAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dlm.removeAllElements();
                validate();
            }
        });

        getContentPane().add(panel);

        setPreferredSize(new Dimension(600, 600));

    }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject studentObject = (JSONObject) employee.get("student");

        //Get employee first name
        String value = (String) studentObject.get("value");
        System.out.println(value);

        //Get employee last name
        String key = (String) studentObject.get("key");
        System.out.println(key);

    }
    public static boolean CheckValues(String key, String value){
        if(key.equals("") || value.equals("")){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                TestFrame frame = new TestFrame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}