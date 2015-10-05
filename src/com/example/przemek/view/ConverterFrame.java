package com.example.przemek.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ConverterFrame extends JFrame{
	
	private JPanel mainPanel;
	private String mainPanelTitle;
	private JTextField rootName;
	private JTextField objectName;
	private JTextField separatorType;
	private JLabel rootLabel;
	private JLabel objectLabel;
	private JLabel separatorLabel;
	
	private JPanel labelPanel;
	private String labelPanelTitle;
	private JTextArea infoField;
	private final JFileChooser chooser;
	private FileNameExtensionFilter filter;
	
	private JPanel buttonPanel;
	private JButton convertXmlButton;
	private JButton convertJsonButton;
	private JButton exitButton;
	private JButton helpButton;
	
	public ConverterFrame() {
	this.setSize(600, 650);
	this.setTitle("CSV Converter");
	
	mainPanel = new JPanel();
	mainPanelTitle = new String("Enter format parameters");
	mainPanel.setLayout(new GridLayout(3,2));
	mainPanel.setBorder(BorderFactory.createTitledBorder
			(BorderFactory.createEtchedBorder(), mainPanelTitle));
	rootLabel = new JLabel("Enter Root name: ", SwingConstants.RIGHT);
	rootName = new JTextField(8);
	objectLabel = new JLabel("Enter objects name: ", SwingConstants.RIGHT);
	objectName = new JTextField(8);
	separatorLabel = new JLabel("Enter Separator: ", SwingConstants.RIGHT);
	separatorType = new JTextField(8);
	mainPanel.add(rootLabel);
	mainPanel.add(rootName);
	mainPanel.add(objectLabel);
	mainPanel.add(objectName);
	mainPanel.add(separatorLabel);
	mainPanel.add(separatorType);
	this.add(mainPanel, BorderLayout.NORTH);
	
	labelPanel = new JPanel();
	labelPanelTitle = new String("Choose File");
	labelPanel.setBorder(BorderFactory.createTitledBorder
			(BorderFactory.createEtchedBorder(), labelPanelTitle));
	infoField = new JTextArea(6, 30);
	infoField.setLineWrap(true);
	infoField.setEditable(false);
	chooser = new JFileChooser(".");
	filter = new FileNameExtensionFilter("csv file, txt file",
			"csv", "txt");
	chooser.setFileFilter(filter);
	chooser.setControlButtonsAreShown(false);
	labelPanel.add(chooser);
	labelPanel.add(infoField);
	this.add(labelPanel, BorderLayout.CENTER);
	
	buttonPanel = new JPanel();
	convertXmlButton = new JButton("Convert to xml");
	convertJsonButton = new JButton("Convert to Json");
	exitButton = new JButton("Exit");
	helpButton = new JButton("Help");
	buttonPanel.add(convertXmlButton);
	buttonPanel.add(convertJsonButton);
	buttonPanel.add(exitButton);
	buttonPanel.add(helpButton);
	this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	//menu
	public String getRootName () {
		return rootName.getText();
	}
	
	public String getobjectName () {
		return objectName.getText();
	}
	
	public String getseparatorType () {
		return separatorType.getText();
	}
	
	public File getChooserFile () {
		return chooser.getSelectedFile();
	}
	
	public void setInfoField (String info) {
		this.infoField.setText(info);
	}
	
	public void addConvertXmlListener (ActionListener actionListener) {
		this.convertXmlButton.addActionListener(actionListener);
	}
	
	public void addConvertJsonListener (ActionListener actionListener) {
		this.convertJsonButton.addActionListener(actionListener);
	}
	
	public void addExitListener (ActionListener actionListener) {
		this.exitButton.addActionListener(actionListener);
	}
	
	public void addHelpListener (ActionListener actionListener) {
		this.helpButton.addActionListener(actionListener);
	}
}
