package com.netinfo.emp.demos;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.encryptions.AESEncryption;
import com.netinfo.emp.encryptions.SHAEncryption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Project emp-encryption-demo
 * Package com.netinfo.emp.demos
 * <p>
 * Created by Charley on 2017/3/1.
 */
public class EncryptionMain {
    private JPanel panel1;
    private JTextField txtSource;
    private JTextField txtTarget;
    private JComboBox comboMode;
    private JButton btnEncrypt;
    private JButton btnDecrypt;

    public EncryptionMain() {
        btnEncrypt.addActionListener(this::Encrypt_Clicked);
        btnDecrypt.addActionListener(this::Decrypt_Clicked);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EncryptionMain");
        EncryptionMain main = new EncryptionMain();
        main.setModeData();
        frame.setContentPane(main.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setPreferredSize(new Dimension(800, 500));
        frame.pack();
        frame.setVisible(true);
        main.setDefaultMode();
    }

    public void setModeData() {
        comboMode.removeAllItems();
        ModeItem item = new ModeItem();
        item.setName("AES256_01_HEX_ASCII");
        item.setMode(EncryptionMode.AES256_01_HEX_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_02_HEX_ASCII");
        item.setMode(EncryptionMode.AES256_02_HEX_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_03_HEX_ASCII");
        item.setMode(EncryptionMode.AES256_03_HEX_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_04_HEX_ASCII");
        item.setMode(EncryptionMode.AES256_04_HEX_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_05_HEX_ASCII");
        item.setMode(EncryptionMode.AES256_05_HEX_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_06_HEX_ASCII");
        item.setMode(EncryptionMode.AES256_06_HEX_ASCII);
        comboMode.addItem(item);

        item = new ModeItem();
        item.setName("AES256_01_BASE64_ASCII");
        item.setMode(EncryptionMode.AES256_01_BASE64_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_02_BASE64_ASCII");
        item.setMode(EncryptionMode.AES256_02_BASE64_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_03_BASE64_ASCII");
        item.setMode(EncryptionMode.AES256_03_BASE64_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_04_BASE64_ASCII");
        item.setMode(EncryptionMode.AES256_04_BASE64_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_05_BASE64_ASCII");
        item.setMode(EncryptionMode.AES256_05_BASE64_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_06_BASE64_ASCII");
        item.setMode(EncryptionMode.AES256_06_BASE64_ASCII);
        comboMode.addItem(item);

        item = new ModeItem();
        item.setName("AES256_01_HEX_UTF8");
        item.setMode(EncryptionMode.AES256_01_HEX_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_02_HEX_UTF8");
        item.setMode(EncryptionMode.AES256_02_HEX_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_03_HEX_UTF8");
        item.setMode(EncryptionMode.AES256_03_HEX_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_04_HEX_UTF8");
        item.setMode(EncryptionMode.AES256_04_HEX_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_05_HEX_UTF8");
        item.setMode(EncryptionMode.AES256_05_HEX_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_06_HEX_UTF8");
        item.setMode(EncryptionMode.AES256_06_HEX_UTF8);
        comboMode.addItem(item);

        item = new ModeItem();
        item.setName("AES256_01_BASE64_UTF8");
        item.setMode(EncryptionMode.AES256_01_BASE64_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_02_BASE64_UTF8");
        item.setMode(EncryptionMode.AES256_02_BASE64_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_03_BASE64_UTF8");
        item.setMode(EncryptionMode.AES256_03_BASE64_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_04_BASE64_UTF8");
        item.setMode(EncryptionMode.AES256_04_BASE64_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_05_BASE64_UTF8");
        item.setMode(EncryptionMode.AES256_05_BASE64_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_06_BASE64_UTF8");
        item.setMode(EncryptionMode.AES256_06_BASE64_UTF8);
        comboMode.addItem(item);

        item = new ModeItem();
        item.setName("AES256_01_HEX_UNICODE");
        item.setMode(EncryptionMode.AES256_01_HEX_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_02_HEX_UNICODE");
        item.setMode(EncryptionMode.AES256_02_HEX_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_03_HEX_UNICODE");
        item.setMode(EncryptionMode.AES256_03_HEX_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_04_HEX_UNICODE");
        item.setMode(EncryptionMode.AES256_04_HEX_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_05_HEX_UNICODE");
        item.setMode(EncryptionMode.AES256_05_HEX_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_06_HEX_UNICODE");
        item.setMode(EncryptionMode.AES256_06_HEX_UNICODE);
        comboMode.addItem(item);

        item = new ModeItem();
        item.setName("AES256_01_BASE64_UNICODE");
        item.setMode(EncryptionMode.AES256_01_BASE64_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_02_BASE64_UNICODE");
        item.setMode(EncryptionMode.AES256_02_BASE64_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_03_BASE64_UNICODE");
        item.setMode(EncryptionMode.AES256_03_BASE64_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_04_BASE64_UNICODE");
        item.setMode(EncryptionMode.AES256_04_BASE64_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_05_BASE64_UNICODE");
        item.setMode(EncryptionMode.AES256_05_BASE64_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("AES256_06_BASE64_UNICODE");
        item.setMode(EncryptionMode.AES256_06_BASE64_UNICODE);
        comboMode.addItem(item);


        item = new ModeItem();
        item.setName("SHA256_00_HEX_ASCII");
        item.setMode(EncryptionMode.SHA256_00_HEX_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA256_00_BASE64_ASCII");
        item.setMode(EncryptionMode.SHA256_00_BASE64_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA256_00_HEX_UTF8");
        item.setMode(EncryptionMode.SHA256_00_HEX_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA256_00_BASE64_UTF8");
        item.setMode(EncryptionMode.SHA256_00_BASE64_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA256_00_HEX_UNICODE");
        item.setMode(EncryptionMode.SHA256_00_HEX_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA256_00_BASE64_UNICODE");
        item.setMode(EncryptionMode.SHA256_00_BASE64_UNICODE);
        comboMode.addItem(item);

        item = new ModeItem();
        item.setName("SHA512_00_HEX_ASCII");
        item.setMode(EncryptionMode.SHA512_00_HEX_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA512_00_BASE64_ASCII");
        item.setMode(EncryptionMode.SHA512_00_BASE64_ASCII);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA512_00_HEX_UTF8");
        item.setMode(EncryptionMode.SHA512_00_HEX_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA512_00_BASE64_UTF8");
        item.setMode(EncryptionMode.SHA512_00_BASE64_UTF8);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA512_00_HEX_UNICODE");
        item.setMode(EncryptionMode.SHA512_00_HEX_UNICODE);
        comboMode.addItem(item);
        item = new ModeItem();
        item.setName("SHA512_00_BASE64_UNICODE");
        item.setMode(EncryptionMode.SHA512_00_BASE64_UNICODE);
        comboMode.addItem(item);

    }

    public void setDefaultMode() {
        for (int i = 0; i < comboMode.getItemCount(); i++) {
            ModeItem modeItem = (ModeItem) comboMode.getItemAt(i);
            if (modeItem.getMode() == EncryptionMode.AES256_02_HEX_UNICODE) {
                comboMode.setSelectedItem(modeItem);
            }
        }
    }

    private void Encrypt_Clicked(ActionEvent e) {
        ModeItem modeItem = (ModeItem) comboMode.getSelectedItem();
        String strSource = txtSource.getText();
        int mode = modeItem.getMode();
        int type = mode / 1000;
        String strTarget;
        try {
            switch (type) {
                case 2:
                    strTarget = AESEncryption.encryptString(strSource, mode);
                    break;
                case 3:
                case 4:
                    strTarget = SHAEncryption.encryptString(strSource, mode);
                    break;
                default:
                    txtTarget.setText("Mode invalid");
                    return;
            }
            txtTarget.setText(strTarget);
        } catch (Exception e1) {
            e1.printStackTrace();
            txtTarget.setText(e1.getMessage());
        }
    }

    private void Decrypt_Clicked(ActionEvent e) {
        ModeItem modeItem = (ModeItem) comboMode.getSelectedItem();
        String strSource = txtSource.getText();
        int mode = modeItem.getMode();
        int type = mode / 1000;
        String strTarget;
        try {
            switch (type) {
                case 2:
                    strTarget = AESEncryption.decryptString(strSource, mode);
                    break;
                default:
                    txtTarget.setText("Mode invalid");
                    return;
            }
            txtTarget.setText(strTarget);
        } catch (Exception e1) {
            e1.printStackTrace();
            txtTarget.setText(e1.getMessage());
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel2.add(panel3);
        final JLabel label1 = new JLabel();
        label1.setText("Source");
        panel3.add(label1);
        txtSource = new JTextField();
        txtSource.setColumns(50);
        panel3.add(txtSource);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel2.add(panel4);
        final JLabel label2 = new JLabel();
        label2.setText("Target");
        panel4.add(label2);
        txtTarget = new JTextField();
        txtTarget.setColumns(50);
        panel4.add(txtTarget);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel2.add(panel5);
        comboMode = new JComboBox();
        panel5.add(comboMode);
        btnEncrypt = new JButton();
        btnEncrypt.setText("Encrypt");
        panel5.add(btnEncrypt);
        btnDecrypt = new JButton();
        btnDecrypt.setText("Decrypt");
        panel5.add(btnDecrypt);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
