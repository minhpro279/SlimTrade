package com.slimtrade.gui.menubar;

import java.awt.Dimension;

import com.slimtrade.gui.options.ListButton;

public class MenubarButton extends ListButton {
	
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 200;
	public static int HEIGHT= 22;
	
	public MenubarButton(){
		super("");
//		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(false);
	}
	
	public MenubarButton(String text){
		super("");
		this.setText(text);
//		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(false);
	}

}
