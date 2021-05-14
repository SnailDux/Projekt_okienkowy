package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
	// write your code here

        JFrame frame = new JFrame("nazwa");
        frame.setSize(400,500);
        frame.setVisible(true);

        JTextArea textArea = new JTextArea();
    //    textArea.setEditable(false);
        textArea.append("long text");
        JPanel panel = new JPanel();
        panel.add(textArea);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
    }
}
