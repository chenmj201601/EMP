package com.netinfo.emp;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.encryptions.SHAEncryption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

/**
 * Project emp-utils-demo
 * Package com.netinfo.emp
 * <p>
 * Created by Charley on 2017/3/13.
 */
public class UtilsMain {
    private JPanel panel1;
    private JTextField txtApiId;
    private JTextField txtUserToken;
    private JTextField txtRequestToken;
    private JTextField txtTimestamp;
    private JButton btnGenerate;
    private JTabbedPane tabRequestToken;
    private JButton btnCheck;
    private JTextField txtParam01Name;
    private JTextField txtParam01Value;
    private JTextField txtParam02Name;
    private JTextField txtParam02Value;
    private JTextField txtParam03Name;
    private JTextField txtParam03Value;
    private JButton btnReset;

    public UtilsMain() {
        btnGenerate.addActionListener(this::Generate_Clicked);
        btnCheck.addActionListener(this::Check_Clicked);
        btnReset.addActionListener(this::Reset_Clicked);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UtilsMain");
        UtilsMain main = new UtilsMain();
        frame.setContentPane(main.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.pack();
        frame.setVisible(true);
    }

    private void Generate_Clicked(ActionEvent e) {
        try {
            String strApiId = txtApiId.getText();
            String strUserToken = txtUserToken.getText();
            String strTimestamp = txtTimestamp.getText();
            if ("".equals(strTimestamp)) {
                strTimestamp = ((Long) System.currentTimeMillis()).toString();
                txtTimestamp.setText(strTimestamp);
            }
            String strParam01 = txtParam01Name.getText();
            String strParam02 = txtParam02Name.getText();
            String strParam03 = txtParam03Name.getText();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s=%s", Defines.FIELD_API_ID, strApiId));
            sb.append(String.format("%s=%s", Defines.FIELD_USER_TOKEN, strUserToken));
            sb.append(String.format("%s=%s", Defines.FIELD_TIMESTAMP, strTimestamp));
            Map<String, String> listParam = new HashMap<>();
            if (!"".equals(strParam01)) {
                listParam.put(strParam01, txtParam01Value.getText());
            }
            if (!"".equals(strParam02)) {
                listParam.put(strParam02, txtParam02Value.getText());
            }
            if (!"".equals(strParam03)) {
                listParam.put(strParam03, txtParam02Value.getText());
            }
            List<Map.Entry<String, String>> list = new ArrayList<>(listParam.entrySet());
            Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
            for (String key : listParam.keySet()) {
                sb.append(String.format("%s=%s", key, listParam.get(key)));
            }
            sb.append(Defines.REQUEST_KEY);
            String requestToken = SHAEncryption.encryptString(sb.toString(), EncryptionMode.SHA256_00_HEX_ASCII);
            txtRequestToken.setText(requestToken);
        } catch (Exception ex) {
            txtRequestToken.setText(ex.getMessage());
        }
    }

    private void Check_Clicked(ActionEvent e) {
        try {
            String strApiId = txtApiId.getText();
            String strUserToken = txtUserToken.getText();
            String strRequestToken = txtRequestToken.getText();
            String strTimestamp = txtTimestamp.getText();
            String strParam01 = txtParam01Name.getText();
            String strParam02 = txtParam02Name.getText();
            String strParam03 = txtParam03Name.getText();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s=%s", Defines.FIELD_API_ID, strApiId));
            sb.append(String.format("%s=%s", Defines.FIELD_USER_TOKEN, strUserToken));
            sb.append(String.format("%s=%s", Defines.FIELD_TIMESTAMP, strTimestamp));
            Map<String, String> listParam = new HashMap<>();
            if (!"".equals(strParam01)) {
                listParam.put(strParam01, txtParam01Value.getText());
            }
            if (!"".equals(strParam02)) {
                listParam.put(strParam02, txtParam02Value.getText());
            }
            if (!"".equals(strParam03)) {
                listParam.put(strParam03, txtParam02Value.getText());
            }
            List<Map.Entry<String, String>> list = new ArrayList<>(listParam.entrySet());
            Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
            for (String key : listParam.keySet()) {
                sb.append(String.format("%s=%s", key, listParam.get(key)));
            }
            sb.append(Defines.REQUEST_KEY);
            String requestToken = SHAEncryption.encryptString(sb.toString(), EncryptionMode.SHA256_00_HEX_ASCII);
            if (strRequestToken.equals(requestToken)) {
                txtRequestToken.setText("OK");
            } else {
                txtRequestToken.setText("Fail");
            }
        } catch (Exception ex) {
            txtRequestToken.setText(ex.getMessage());
        }
    }

    private void Reset_Clicked(ActionEvent e) {
        try {
            txtApiId.setText("");
            txtUserToken.setText("");
            txtRequestToken.setText("");
            txtTimestamp.setText("");
            txtParam01Name.setText("");
            txtParam01Value.setText("");
            txtParam02Name.setText("");
            txtParam02Value.setText("");
            txtParam03Name.setText("");
            txtParam03Value.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
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
        tabRequestToken = new JTabbedPane();
        panel1.add(tabRequestToken, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        tabRequestToken.addTab("Untitled", panel2);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel3);
        final JLabel label1 = new JLabel();
        label1.setText("Api Id");
        panel3.add(label1);
        txtApiId = new JTextField();
        txtApiId.setColumns(50);
        panel3.add(txtApiId);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel4);
        final JLabel label2 = new JLabel();
        label2.setText("User Token");
        panel4.add(label2);
        txtUserToken = new JTextField();
        txtUserToken.setColumns(50);
        panel4.add(txtUserToken);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel5);
        final JLabel label3 = new JLabel();
        label3.setText("Request Token");
        panel5.add(label3);
        txtRequestToken = new JTextField();
        txtRequestToken.setColumns(50);
        panel5.add(txtRequestToken);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel6);
        final JLabel label4 = new JLabel();
        label4.setText("Timestamp");
        panel6.add(label4);
        txtTimestamp = new JTextField();
        txtTimestamp.setColumns(50);
        panel6.add(txtTimestamp);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel7);
        final JLabel label5 = new JLabel();
        label5.setText("Param 01");
        panel7.add(label5);
        txtParam01Name = new JTextField();
        txtParam01Name.setColumns(25);
        panel7.add(txtParam01Name);
        final JLabel label6 = new JLabel();
        label6.setText("Value");
        panel7.add(label6);
        txtParam01Value = new JTextField();
        txtParam01Value.setColumns(25);
        panel7.add(txtParam01Value);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel8);
        final JLabel label7 = new JLabel();
        label7.setText("Param 02");
        panel8.add(label7);
        txtParam02Name = new JTextField();
        txtParam02Name.setColumns(25);
        panel8.add(txtParam02Name);
        final JLabel label8 = new JLabel();
        label8.setText("Value");
        panel8.add(label8);
        txtParam02Value = new JTextField();
        txtParam02Value.setColumns(25);
        panel8.add(txtParam02Value);
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel9);
        final JLabel label9 = new JLabel();
        label9.setText("Param 03");
        panel9.add(label9);
        txtParam03Name = new JTextField();
        txtParam03Name.setColumns(25);
        panel9.add(txtParam03Name);
        final JLabel label10 = new JLabel();
        label10.setText("Value");
        panel9.add(label10);
        txtParam03Value = new JTextField();
        txtParam03Value.setColumns(25);
        panel9.add(txtParam03Value);
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(panel10);
        btnGenerate = new JButton();
        btnGenerate.setText("Generate");
        panel10.add(btnGenerate);
        btnCheck = new JButton();
        btnCheck.setText("Check");
        panel10.add(btnCheck);
        btnReset = new JButton();
        btnReset.setText("Reset");
        panel10.add(btnReset);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
