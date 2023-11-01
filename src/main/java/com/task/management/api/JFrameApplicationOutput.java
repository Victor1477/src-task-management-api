package com.task.management.api;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;

public class JFrameApplicationOutput extends OutputStream {

    private JFrame jFrame;
    private JTextArea jTextArea;
    private JScrollPane jScrollPane;

    public JFrameApplicationOutput() {
        jFrame = new JFrame("AccountManagerApi");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(400, 150, 1280, 768);

        jTextArea = new JTextArea();
        jTextArea.setBackground(Color.BLACK);
        jTextArea.setForeground(Color.GREEN);
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 11);
        jTextArea.setFont(font);
        jTextArea.setVisible(true);

        jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVisible(true);

        jFrame.add(jScrollPane);
        jFrame.setVisible(true);
    }

    @Override
    public void write(int b) throws IOException {
        jTextArea.append(String.valueOf((char) b));
        jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
    }
}
