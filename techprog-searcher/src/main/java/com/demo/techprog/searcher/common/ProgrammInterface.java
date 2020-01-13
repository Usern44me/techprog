package com.demo.techprog.searcher.common;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class ProgrammInterface extends JFrame {
    private JButton button = new JButton("Search");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input:");
    private String inputstr = "";

    public ProgrammInterface() {
        super("Simple Example");
        this.setBounds(100,100,400,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();

        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }
    public String getText()
    {
        return inputstr;
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) { // input.getText() вход с вводной строки
            (new Text()).setTxt(input.getText());
            JOptionPane.showMessageDialog(null,
                    "Result added in Result.html\n",
                    "Result",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
    static class Text {
        private static String txt = "";

        public static String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
            System.out.println(this.txt);
        }
    }


}
