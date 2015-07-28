package com.example.przemek.controller;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.przemek.model.ConverterModel;
import com.example.przemek.view.ConverterFrame;

public class ConverterController {

	ConverterFrame converterFrame;
	ConverterModel converterModel;

	public ConverterController(ConverterFrame frame, ConverterModel model) {
		this.converterFrame = frame;
		this.converterModel = model;

		this.converterFrame.addParseListener(new listenerForParse());
		this.converterFrame.addExitListener(new listenerForExit());
		this.converterFrame.addHelpListener(new listenerForHelp());
	}
	
	class listenerForParse implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			converterFrame.setInfoField("Parsing started");
			converterModel.parseCsvXml
			(converterFrame.getChooserFile(), converterFrame.getRootName(), 
					converterFrame.getobjectName(), 
					converterFrame.getseparatorType());
			converterFrame.setInfoField("Parsing started\n" + 
					converterModel.progressInfo());
		}
	}

	class listenerForExit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class listenerForHelp implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog
			(converterFrame, "In order to make xml file out of csv file \n"
					+ "you need to define root element which will be \n"
					+ "also the name of created file. Object name which \n"
					+ "is name of root element objects and separator \n"
					+ "which separates the values. If there is space \n"
					+ "after a coma write it also in the separator \n"
					+ "field. Converter requires header in csv file.");
		}
	}
}
