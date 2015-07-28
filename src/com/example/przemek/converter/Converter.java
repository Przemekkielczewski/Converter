package com.example.przemek.converter;

import javax.swing.JFrame;
import com.example.przemek.controller.ConverterController;
import com.example.przemek.model.ConverterModel;
import com.example.przemek.view.ConverterFrame;

public class Converter {

	public static void main(String[] args) {
		//done
		ConverterFrame frame = new ConverterFrame();
		ConverterModel converterModel = new ConverterModel();
		ConverterController converterController = 
				new ConverterController (frame, converterModel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
