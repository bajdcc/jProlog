package com.bajdcc.main;

import com.bajdcc.prolog.PrologExecutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PrologDialog extends JDialog {
    private JPanel contentPane;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton run;
    private JButton stop;
    private JButton ex;
    private JButton exit;

    private static final String text = "所有人{} = {\"埃夫里\",\"布莱克\",\"克朗\",\"戴维斯\",\"其他人\"};\n" +
            "时间{} = {1,2,3,4};\n" +
            "时间 死亡时刻;\n" +
            "时间 在寓所(所有人);\n" +
            "所有人 凶手;\n" +
            "\n" +
            "互斥(在寓所(\"埃夫里\"),在寓所(\"布莱克\"),在寓所(\"克朗\"),在寓所(\"戴维斯\"));\n" +
            "\n" +
            "在寓所(凶手) = 死亡时刻;\n" +
            "\n" +
            "凶手 != \"其他人\"; //(1)\n" +
            "在寓所(\"埃夫里\") >= 死亡时刻; //(2)\n" +
            "在寓所(\"布莱克\") != 2; //(3)\n" +
            "在寓所(\"布莱克\") <= 死亡时刻; //(4)\n" +
            "在寓所(\"克朗\") != 3; //(5)\n" +
            "在寓所(\"克朗\") >= 死亡时刻; //(6)\n" +
            "在寓所(\"戴维斯\") < 在寓所(凶手); //(7)\n" +
            "在寓所(\"戴维斯\") <= 死亡时刻; //(7)\n" +
            "\n" +
            "输出(\"凶手是: \",凶手);\n";

    SwingWorker<Object, Object> sw;

    public PrologDialog() {
        setTitle("jProlog Gui Application / bajdcc");
        setContentPane(contentPane);
        setResizable(false);
        setModal(true);

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ex.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                useExample();
            }
        });
        run.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                execRun();
            }
        });
        stop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                execStop();
            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onCancel();
            }
        });
    }

    private void useExample() {
        if (sw == null) {
            textArea1.setText(text);
        }
    }

    private void execRun() {
        if (sw != null) {
            return;
        }
        textArea2.setText("");
        ex.setEnabled(false);
        stop.setEnabled(true);
        run.setEnabled(false);
        String context = textArea1.getText();
        sw = new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {
                PrologExecutor.getInstance().setOut(new PrintStream(new OutputStream() {
                    private StringBuilder sb = new StringBuilder();

                    @Override
                    public void write(int b) throws IOException {
                        SwingUtilities.invokeLater(() -> {
                            sb.append(b);
                            textArea2.setText(sb.toString());
                        });
                    }

                    @Override
                    public void write(byte[] b, int off, int len) throws IOException {
                        final String message = new String(b, off, len);
                        SwingUtilities.invokeLater(() -> {
                            sb.append(message);
                            textArea2.setText(sb.toString());
                        });
                    }
                }));
                PrologExecutor.getInstance().setFuture(this);
                PrologExecutor.getInstance().run(context);
                return null;
            }

            @Override
            protected void done() {
                PrologExecutor.getInstance().setOut(System.out);
                PrologExecutor.getInstance().setFuture(null);
                ex.setEnabled(true);
                run.setEnabled(true);
                stop.setEnabled(false);
                sw = null;
            }
        };
        sw.execute();
    }

    private void execStop() {
        if (sw == null) {
            return;
        }
        sw.cancel(false);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        PrologDialog dialog = new PrologDialog();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        System.exit(0);
    }
}
