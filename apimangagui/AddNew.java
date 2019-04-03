/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package apimangagui;

import static apimangagui.MainMenu.addNewFrame;
import static apimangagui.MainMenu.mainMenuFrame;
import static apimangagui.MainMenu.folderErrFrame;
import static apimangagui.MainMenu.progressAddFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import java.io.File;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mint
 */
public class AddNew
        extends javax.swing.JFrame implements PropertyChangeListener {

    Confirmation confirmationFrame;//диалог подтверждения 
    static String chosenLink = "";
    static File chosenFile;
    public int index = 0;
    public int maxIndex;

    static boolean chosenNames = true;
    static boolean chosenChapterStyle = false;//true = нули
    static boolean saveCovers = true;
    static boolean browseCovers = true;
    static boolean oneFolderManga = false;

    public Thread startDownload;// поток apimanga

    public AddNew() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apimanga");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel1.setText("Ссылка на страничку с мангой");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(138, 138, 138));
        jLabel2.setText("Например, http://readmanga.ru/noragami");

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jButton1.setText("Продолжить");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Назад");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel3.setText("Путь сохранения");

        jTextField2.setEditable(false);
        jTextField2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField2CaretUpdate(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Пронумеровать названия страниц");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Дополнить номера глав нулями");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Сохранить обложки в отдельную папку");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Просмотреть обложки во время загрузки");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("Все страницы в одну папку");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox4)
                                .addComponent(jCheckBox3)
                                .addComponent(jCheckBox5)
                                .addComponent(jCheckBox2))))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mainMenuFrame.setLocation(getLocationOnScreen());
        mainMenuFrame.setVisible(true);
        addNewFrame.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setPreferredSize(new Dimension(addNewFrame.getWidth() * 3 / 2, addNewFrame.getHeight() * 3 / 2));
        fileChooser.setDialogTitle("Выберите папку");
        fileChooser.setApproveButtonToolTipText("Choose folder for manga");
        switch (fileChooser.showSaveDialog(null)) {
            case JFileChooser.APPROVE_OPTION:
                chosenFile = fileChooser.getSelectedFile();
                jTextField2.setText(chosenFile.toString());
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
            case JFileChooser.ERROR_OPTION:
                java.awt.EventQueue.invokeLater(() -> {
                    folderErrFrame.setVisible(true);
                });
                break;
        }
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()) {
            jButton1.setEnabled(false);
        } else if (jTextField1.getBackground() == jTextField2.getBackground()) {
            jButton1.setEnabled(true);
        } else {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        if (jTextField1.getText().isEmpty()) {
            jTextField1.setBackground(jTextField2.getBackground());
            jButton1.setEnabled(false);
        } else {
            try {
                chosenLink = jTextField1.getText();
                URL tryURL = new URL(chosenLink);

                jTextField1.setBackground(jTextField2.getBackground());//прошла
                if (jTextField2.getText().isEmpty()) {
                    jButton1.setEnabled(false);
                } else {
                    jButton1.setEnabled(true);
                }
// UrlValidator  urlValidator=new UrlValidator();
                //  if(urlValidator.isValid(inputUrl)){System.out.println("apimangagui.AddNew.jTextField1CaretUpdate()" + ex);}

            } catch (MalformedURLException ex) {
                jTextField1.setBackground(Color.decode("#fda4ad"));
                jButton1.setEnabled(false);
            }

        }

    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        chosenNames = !chosenNames;
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        chosenChapterStyle = !chosenChapterStyle;
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        oneFolderManga = jCheckBox5.isSelected();
        chosenLink = jTextField1.getText();
        chosenFile = new File(jTextField2.getText());
        startDownload = new Thread(() -> {
            Apimanga runApimanga = new Apimanga();
            try {
                runApimanga.apimanga();
            } catch (InterruptedException e) {
            }
        });
        startDownload.start();
//        Processors processors=new Processors();
        //      processors.addPropertyChangeListener(this);
        //    processors.execute();

        progressAddFrame.setLocation(addNewFrame.getLocationOnScreen());
        addNewFrame.setVisible(false);
        progressAddFrame.setVisible(true);
        ProgressAdd.jProgressBar1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        saveCovers = !saveCovers;        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jTextField2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField2CaretUpdate
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()) {
            jButton1.setEnabled(false);
        } else if (jTextField1.getBackground() == jTextField2.getBackground()) {
            jButton1.setEnabled(true);
        } else {
            jButton1.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2CaretUpdate

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        browseCovers = !browseCovers;     // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed

        if (jCheckBox5.isSelected()) {
            confirmationFrame = new Confirmation(new javax.swing.JFrame(), true);
            java.awt.EventQueue.invokeLater(() -> {
                confirmationFrame.setLocation(addNewFrame.getX() + addNewFrame.getWidth() / 4, addNewFrame.getY() + addNewFrame.getHeight() / 4);
                confirmationFrame.setVisible(true);
                if (confirmationFrame.getReturnStatus()) {
                    jCheckBox5.setSelected(true);

                    jCheckBox1.setSelected(true);
                    jCheckBox1.setEnabled(false);

                    jCheckBox2.setSelected(true);
                    jCheckBox2.setEnabled(false);
                } else {
                    jCheckBox5.setSelected(false);
                }

            });
        } else {
            jCheckBox1.setEnabled(true);

            jCheckBox2.setEnabled(true);
        }

    }//GEN-LAST:event_jCheckBox5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
   @Override
    public void propertyChange(PropertyChangeEvent evt) {
        int progress;
        if ("progress".equals(evt.getPropertyName())) {
            progress = (Integer) evt.getNewValue();
            ProgressAdd.jProgressBar1.setValue(progress);
            if (progress == 100) {
                ProgressAdd.jProgressBar1.setValue(0);
                if (ProcentChapters.finished) {//если конец
                    changeIconBytime.resetIcon();
                    MainMenu.progressAddFrame.resetText();
                    MainMenu.progressAddFrame.setVisible(false);
                    MainMenu.addNewSuccessFrame.setVisible(true);
                }
            }
        }
    }

}

class ProcentChapters extends SwingWorker<Void, Void> {

    int progress = 0;
    String visualchapter;
    public static boolean finished = false;

    @Override
    protected Void doInBackground() {
        String[] tempArrayForMakingDraw;
        String stroke1, stroke2, stroke3;
        int nextWord;
        int strokeLen = 35;
        int intForCountLinesWrap = 0;
        while (!finished) {
            stroke2 = " ";
            stroke3 = " ";
            try {
                intForCountLinesWrap = 0;
                Thread.sleep(300);
                /*СУТЬ
                если слов меньше чем 3 то они выводятся на первую строку
                иначе
                если 1ое слово цифра 2ое слово - 3ье цифра, то на первую строку идут они, дальше все распределяется как надо
                иначе
                если первое цифра, тоона идеть на 1 строку, остально как надо
                иначе
                все выводятся как надо
                
                как надо:
                при достижении определенной суммарной длины перенос на строку
                
                Если очень длинное, то третья строка уедет
                ~мне все равно~
                 */
                tempArrayForMakingDraw = Apimanga.chapterNames[Apimanga.chaptersCount].split(" ");
                nextWord = 0;
                stroke1 = " ";
                if (tempArrayForMakingDraw.length > 3) {

                    if (isNumeric(tempArrayForMakingDraw[0])) {
                        if (isNumeric(tempArrayForMakingDraw[2]) && "-".equals(tempArrayForMakingDraw[1])) {
                            stroke1 = tempArrayForMakingDraw[0] + ' ' + tempArrayForMakingDraw[1] + ' ' + tempArrayForMakingDraw[2] + ' ';
                            nextWord = 3;
                        } else {
                            stroke1 = tempArrayForMakingDraw[0] + ' ';
                            nextWord = 1;
                        }

                        for (int i = nextWord; i < tempArrayForMakingDraw.length; i++) {
                            intForCountLinesWrap += tempArrayForMakingDraw[i].length() + 1;
                            if (intForCountLinesWrap > strokeLen) {//перенос строки

                                stroke3 += tempArrayForMakingDraw[i] + ' ';
                            } else {
                                stroke2 += tempArrayForMakingDraw[i] + ' ';
                            }
                        }
                    } else {//поскольку в этом случае первая строка не уникальна необходим собственный перебор
                        for (int i = 0; i < tempArrayForMakingDraw.length; i++) {
                            intForCountLinesWrap += tempArrayForMakingDraw[i].length() + 1;
                            if (intForCountLinesWrap > strokeLen) {//перенос строки
                                if (intForCountLinesWrap > strokeLen * 2) {
                                    stroke3 += tempArrayForMakingDraw[i] + ' ';
                                } else {
                                    stroke2 += tempArrayForMakingDraw[i] + ' ';
                                }
                            } else {
                                stroke1 += tempArrayForMakingDraw[i] + ' ';
                            }
                        }
                    }

                } else {
                    stroke1 = Apimanga.chapterNames[Apimanga.chaptersCount];
                }
                ProgressAdd.jLabel3.setText(stroke1);
                ProgressAdd.jLabel6.setText(stroke2);
                ProgressAdd.jLabel7.setText(stroke3);
                ProgressAdd.jLabel4.setText(Apimanga.pagesCount + " из " + Apimanga.pagesLinks.length);
                progress = (100 * (Apimanga.pagesCount + Apimanga.pagesLinks.length * Apimanga.chaptersCount)) / Apimanga.chapterLinks.length / Apimanga.pagesLinks.length;
            } catch (Exception ignore) {
            }

            if (progress >= 100) {
                progress = 100;
                finished = true;
            }
            setProgress(progress);

        }

        return null;
    }

    @Override
    public void done() {
        changeIconBytime.endSession();
    }

    boolean isNumeric(String possiblyDigit) {
        try {
            Integer.parseInt(possiblyDigit);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}

/*class Processors extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() {
        Random generator = new Random();
        int maxIndex = generator.nextInt(10000);
        ProgressAdd.jLabel4.setText("0 из " + maxIndex);
        try {
            Thread.sleep(700);
        } catch (InterruptedException ignore) {
        }
        while (ProgressAdd.jLabel9.getText().equals("Подготовка")) {
            try {
                Thread.sleep(50);
                switch (generator.nextInt(4)) {

                    case 0:
                        ProgressAdd.jLabel4.setText(generator.nextInt(10000) + " из " + maxIndex);
                        break;
                    case 1:
                        ProgressAdd.jLabel4.setText(Math.round(generator.nextGaussian() * 1000) / 1000 + " из " + maxIndex);
                        break;
                    case 2:
                        ProgressAdd.jLabel4.setText(Math.round(generator.nextFloat() * 1000) / 1000 + " из " + maxIndex);
                        break;
                    case 3:
                        ProgressAdd.jLabel4.setText(generator.nextBoolean() + " из " + maxIndex);
                        break;
                }
            } catch (Exception ignore) {
            }

        }

        setProgress(100);
        return null;
    }

}*/
class ProcentCovers extends SwingWorker<Void, Void> {

    int progress = 0;
    String visualchapter;
    static boolean finished = false;

    @Override
    protected Void doInBackground() {
        while (!finished) {
            try {
                Thread.sleep(200);
                if (Apimanga.savingCovers) {
                    ProgressAdd.jLabel4.setText(Apimanga.loadingCoverIndex + " из " + Apimanga.coversLinks.length);
                    progress = 100 * Apimanga.loadingCoverIndex / Apimanga.coversLinks.length;

                }

            } catch (Exception ignore) {
            }

            if (progress >= 100) {
                progress = 100;
                finished = true;
            }
            setProgress(progress);

        }
        return null;
    }

}
