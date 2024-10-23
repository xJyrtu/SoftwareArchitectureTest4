package com.x.client;


import com.x.server.TraditionalSimplifiedWebServiceSoap;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WebServiceClient {
    private static TraditionalSimplifiedWebServiceSoap service;

    public static void main(String[] args) {
        // 创建Web服务的代理实例
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(TraditionalSimplifiedWebServiceSoap.class);
        factory.setAddress("http://ws.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx");

        service = factory.create(TraditionalSimplifiedWebServiceSoap.class);

        // 创建主窗口
        JFrame frame = new JFrame("中文简繁体转换工具");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);


        String[] options = {"繁体字转换为简体字", "简体字转换为繁体字"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(50, 30, 300, 30);
        frame.add(comboBox);

        JTextField inputField = new JTextField();
        inputField.setBounds(50, 80, 300, 30);
        frame.add(inputField);

        JButton convertButton = new JButton("转换");
        convertButton.setBounds(150, 120, 100, 30);
        frame.add(convertButton);


        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(50, 160, 300, 80);
        resultArea.setEditable(false);
        frame.add(resultArea);


        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                String result = null;

                if (comboBox.getSelectedIndex() == 0) {

                    result = service.toSimplifiedChinese(inputText);
                } else {

                    result = service.toTraditionalChinese(inputText);
                }

                if (result != null) {
                    resultArea.setText("转换结果: " + result);
                } else {
                    resultArea.setText("转换失败，请重试。");
                }
            }
        });

        frame.setVisible(true);
    }
}