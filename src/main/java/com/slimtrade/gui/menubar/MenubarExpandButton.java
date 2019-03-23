package main.java.com.slimtrade.gui.menubar;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.com.slimtrade.core.Main;
import main.java.com.slimtrade.core.observing.AdvancedMouseAdapter;
import main.java.com.slimtrade.core.utility.TradeUtility;
import main.java.com.slimtrade.enums.MenubarButtonLocation;
import main.java.com.slimtrade.gui.FrameManager;
import main.java.com.slimtrade.gui.basic.BasicDialog;
import main.java.com.slimtrade.gui.buttons.IconButton;

public class MenubarExpandButton extends BasicDialog{

	private static final long serialVersionUID = 1L;
	private int size = MenubarButton.HEIGHT;
//	private boolean visible;
	
	public MenubarExpandButton(){
		this.setBounds(0, TradeUtility.screenSize.height-size, size, size);
		this.setBackground(Color.RED);
		IconButton showMenubarButton = new IconButton("/resources/icons/menu1.png", size);
		this.add(showMenubarButton);
		
		showMenubarButton.addMouseListener(new AdvancedMouseAdapter() {
		    public void click(MouseEvent e) {
		    	FrameManager.menubar.setShow(true);
		    	FrameManager.menubarToggle.setShow(false);
		    }
		});
		
//		showMenubarButton.addMouseListener(new MouseAdapter(){
//			public void mouseEntered(MouseEvent e){
//				FrameManager.menubar.setShow(true);
//		    	FrameManager.menubarToggle.setShow(false);
//			}
//		});
	}
	
	public void updateLocation(){
		int x = Main.saveManager.getInt("overlayManager", "menubar", "x");
		int y = Main.saveManager.getInt("overlayManager", "menubar", "y");
		
		MenubarButtonLocation loc = MenubarButtonLocation.valueOf(Main.saveManager.getEnumValue(MenubarButtonLocation.class, "overlayManager", "menubar", "buttonLocation"));
		//		String loc = Main.saveManager.getString("overlayManager", "menubar", "buttonLocation");
		
		int modX = 0;
		int modY = 0;
		switch(loc){
		case NW:
			modX = MenubarButtonLocation.NW.getModX();
			modY = MenubarButtonLocation.NW.getModY();
			break;
		case NE:
			modX = MenubarButtonLocation.NE.getModX();
			modY = MenubarButtonLocation.NE.getModY();
			break;
		case SW:
			modX = MenubarButtonLocation.SW.getModX();
			modY = MenubarButtonLocation.SW.getModY();
			break;
		case SE:
			modX = MenubarButtonLocation.SE.getModX();
			modY = MenubarButtonLocation.SE.getModY();
			break;
		}
		this.setLocation(x+modX, y+modY);
		this.revalidate();
		this.repaint();
	}
	
}
