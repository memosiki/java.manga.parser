package apimangagui;

import java.awt.Point;

public class Resuming extends javax.swing.JFrame {

    public Resuming() {
        initComponents();
        ModeChanger.standartLocation = auto.getLocation();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeChooser = new javax.swing.JComboBox<>();
        auto = new javax.swing.JPanel();
        autoMangaLink = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        autoCheckCovers = new javax.swing.JCheckBox();
        chDone2 = new javax.swing.JButton();
        autoBack = new javax.swing.JButton();
        chFileChooser2 = new javax.swing.JButton();
        chMangaPath2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        chapter = new javax.swing.JPanel();
        chMangaLink = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chFrom = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        chTo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        chOnlyOne = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        chDone3 = new javax.swing.JButton();
        chBack3 = new javax.swing.JButton();
        chFileChooser3 = new javax.swing.JButton();
        chMangaPath3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        volume = new javax.swing.JPanel();
        chMangaPath1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        chDone1 = new javax.swing.JButton();
        chBack1 = new javax.swing.JButton();
        chFileChooser1 = new javax.swing.JButton();
        chTo2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        chOnlyOne2 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        chMangaLink2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        chFrom2 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        modeChooser.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        modeChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Автоматическое дополнение", "Отдельные главы", "Определенные тома" }));
        modeChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeChooserActionPerformed(evt);
            }
        });

        auto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        auto.setPreferredSize(new java.awt.Dimension(576, 337));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel1.setText("Ссылка на мангу");

        autoCheckCovers.setText("Проверить обложки");
        autoCheckCovers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoCheckCoversActionPerformed(evt);
            }
        });

        chDone2.setText("Вперед");
        chDone2.setPreferredSize(new java.awt.Dimension(48, 30));
        chDone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chDone2ActionPerformed(evt);
            }
        });

        autoBack.setText("Назад");
        autoBack.setPreferredSize(new java.awt.Dimension(48, 30));
        autoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoBackActionPerformed(evt);
            }
        });

        chFileChooser2.setText("...");

        jLabel16.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel16.setText("Целевая папка");

        javax.swing.GroupLayout autoLayout = new javax.swing.GroupLayout(auto);
        auto.setLayout(autoLayout);
        autoLayout.setHorizontalGroup(
            autoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(autoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(autoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autoMangaLink, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(autoLayout.createSequentialGroup()
                        .addGroup(autoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(autoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(autoCheckCovers))
                            .addComponent(jLabel1)
                            .addGroup(autoLayout.createSequentialGroup()
                                .addGroup(autoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(autoLayout.createSequentialGroup()
                                        .addGroup(autoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(autoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(autoLayout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(52, 52, 52)))
                                        .addGap(236, 236, 236)
                                        .addComponent(chDone2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(chMangaPath2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        autoLayout.setVerticalGroup(
            autoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(autoLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(autoMangaLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(autoCheckCovers)
                .addGap(52, 52, 52)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(autoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chMangaPath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chFileChooser2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(autoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chDone2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        chapter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        chapter.setPreferredSize(new java.awt.Dimension(576, 337));

        jLabel4.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel4.setText("Ссылка на мангу");

        chFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("C главы");

        chTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("По главу");

        chOnlyOne.setText("Только одну");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(138, 138, 138));
        jLabel9.setText("Включительно");

        chDone3.setText("Вперед");
        chDone3.setPreferredSize(new java.awt.Dimension(48, 30));

        chBack3.setText("Назад");
        chBack3.setPreferredSize(new java.awt.Dimension(48, 30));
        chBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBack3ActionPerformed(evt);
            }
        });

        chFileChooser3.setText("...");

        jLabel17.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel17.setText("Целевая папка");

        javax.swing.GroupLayout chapterLayout = new javax.swing.GroupLayout(chapter);
        chapter.setLayout(chapterLayout);
        chapterLayout.setHorizontalGroup(
            chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chapterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chMangaLink)
                    .addGroup(chapterLayout.createSequentialGroup()
                        .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(chapterLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(chOnlyOne)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(chapterLayout.createSequentialGroup()
                                .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chapterLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel6))
                                .addGap(0, 161, Short.MAX_VALUE))))
                    .addGroup(chapterLayout.createSequentialGroup()
                        .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(chapterLayout.createSequentialGroup()
                                .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(chapterLayout.createSequentialGroup()
                                        .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(chBack3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(chapterLayout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(52, 52, 52)))
                                        .addGap(236, 236, 236)
                                        .addComponent(chDone3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(chMangaPath3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chFileChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        chapterLayout.setVerticalGroup(
            chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chapterLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chMangaLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(chOnlyOne))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chMangaPath3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chFileChooser3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(chapterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chDone3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chBack3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        volume.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        volume.setPreferredSize(new java.awt.Dimension(576, 337));

        jLabel12.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel12.setText("Целевая папка");

        chDone1.setText("Вперед");
        chDone1.setPreferredSize(new java.awt.Dimension(48, 30));

        chBack1.setText("Назад");
        chBack1.setPreferredSize(new java.awt.Dimension(48, 30));
        chBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBack1ActionPerformed(evt);
            }
        });

        chFileChooser1.setText("...");

        chTo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("По главу");

        chOnlyOne2.setText("Только одну");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 2, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(138, 138, 138));
        jLabel10.setText("Включительно");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel8.setText("Ссылка на мангу");

        chFrom2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setText("C главы");

        javax.swing.GroupLayout volumeLayout = new javax.swing.GroupLayout(volume);
        volume.setLayout(volumeLayout);
        volumeLayout.setHorizontalGroup(
            volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(volumeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chMangaLink2)
                    .addGroup(volumeLayout.createSequentialGroup()
                        .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chFrom2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addGroup(volumeLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(chOnlyOne2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chTo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(volumeLayout.createSequentialGroup()
                                .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(volumeLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel7))
                                .addGap(0, 161, Short.MAX_VALUE))))
                    .addGroup(volumeLayout.createSequentialGroup()
                        .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(volumeLayout.createSequentialGroup()
                                .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(volumeLayout.createSequentialGroup()
                                        .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(chBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(volumeLayout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(52, 52, 52)))
                                        .addGap(236, 236, 236)
                                        .addComponent(chDone1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(chMangaPath1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        volumeLayout.setVerticalGroup(
            volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(volumeLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chMangaLink2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chFrom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chTo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(chOnlyOne2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chMangaPath1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chFileChooser1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(volumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chDone1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(auto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modeChooser, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chapter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(modeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(auto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(chapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void autoCheckCoversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoCheckCoversActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoCheckCoversActionPerformed

    private void modeChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeChooserActionPerformed
        switch (modeChooser.getSelectedIndex()) {
            case 0://auto
                ModeChanger.turnOnAuto();
                break;
            case 1://chapter`
                ModeChanger.turnOnChapter();
                break;
            case 2://volume
                ModeChanger.turnOnVolume();
                break;
        }
    }//GEN-LAST:event_modeChooserActionPerformed

    private void chDone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chDone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chDone2ActionPerformed

    private void autoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoBackActionPerformed
        Back(); // TODO add your handling code here:
    }//GEN-LAST:event_autoBackActionPerformed

    private void chBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBack3ActionPerformed
        Back();
    }//GEN-LAST:event_chBack3ActionPerformed

    private void chBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBack1ActionPerformed
        Back();
    }//GEN-LAST:event_chBack1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel auto;
    private javax.swing.JButton autoBack;
    private javax.swing.JCheckBox autoCheckCovers;
    private javax.swing.JTextField autoMangaLink;
    private javax.swing.JButton chBack1;
    private javax.swing.JButton chBack3;
    private javax.swing.JButton chDone1;
    private javax.swing.JButton chDone2;
    private javax.swing.JButton chDone3;
    private javax.swing.JButton chFileChooser1;
    private javax.swing.JButton chFileChooser2;
    private javax.swing.JButton chFileChooser3;
    private javax.swing.JComboBox<String> chFrom;
    private javax.swing.JComboBox<String> chFrom2;
    private javax.swing.JTextField chMangaLink;
    private javax.swing.JTextField chMangaLink2;
    private javax.swing.JTextField chMangaPath1;
    private javax.swing.JTextField chMangaPath2;
    private javax.swing.JTextField chMangaPath3;
    private javax.swing.JCheckBox chOnlyOne;
    private javax.swing.JCheckBox chOnlyOne2;
    private javax.swing.JComboBox<String> chTo;
    private javax.swing.JComboBox<String> chTo2;
    public static javax.swing.JPanel chapter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> modeChooser;
    public static javax.swing.JPanel volume;
    // End of variables declaration//GEN-END:variables
void Back() {
//        MainMenu.mainMenuFrame.setLocation(mainMenuFrame.getLocationOnScreen());
      //  resumingFrame.setVisible(false);
     //   mainMenuFrame.setVisible(true);
    }
}

class ModeChanger {

    public static Point standartLocation;

    static void turnOnAuto() {
        //System.err.println(standartLocation);
        Resuming.auto.setLocation(standartLocation);
        Resuming.chapter.setVisible(false);
        Resuming.volume.setVisible(false);
        Resuming.auto.setVisible(true);

    }

    static void turnOnChapter() {
        //  System.err.println(standartLocation);
        Resuming.chapter.setLocation(standartLocation);
        Resuming.auto.setVisible(false);
        Resuming.volume.setVisible(false);
        Resuming.chapter.setVisible(true);

    }

    static void turnOnVolume() {
        //   System.err.println(standartLocation);
        Resuming.volume.setLocation(standartLocation);
        Resuming.chapter.setVisible(false);
        Resuming.auto.setVisible(false);
        Resuming.volume.setVisible(true);

    }
}
