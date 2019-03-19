package main.java.com.slimtrade.gui.menubar;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.ResourceBundle;

import main.java.com.slimtrade.core.Main;
import main.java.com.slimtrade.core.observing.AdvancedMouseAdapter;
import main.java.com.slimtrade.core.utility.PoeInterface;
import main.java.com.slimtrade.core.utility.TradeOffer;
import main.java.com.slimtrade.core.utility.TradeUtility;
import main.java.com.slimtrade.enums.MenubarButtonLocation;
import main.java.com.slimtrade.enums.MessageType;
import main.java.com.slimtrade.gui.FrameManager;
import main.java.com.slimtrade.gui.basic.BasicDialog;
import main.java.com.slimtrade.gui.basic.BasicPanel;
import main.java.com.slimtrade.gui.enums.ExpandDirection;

public class MenubarDialog extends BasicDialog {

	private static final long serialVersionUID = 1L;
	private boolean test = true;
	private static int buttonCount = 6;
	private static int spacerCount = 2;
	private static int spacerHeight = (int) (MenubarButton.HEIGHT * 0.8);

	public static final int WIDTH = MenubarButton.WIDTH;
	public static final int HEIGHT = (MenubarButton.HEIGHT * buttonCount) + (spacerHeight * spacerCount);

	private MenubarButton historyButton;
	// private MenubarButton stashTabButton;
	private MenubarButton chatScannerButton;
	// private MenubarButton characterButton;
	private MenubarButton testButton;
	private MenubarButton optionsButton;
	private MenubarButton quitButton;
	private MenubarButton minimizeButton;

	private boolean visible = false;
	private boolean order = false;

	private Component[] componentList;
	// private ArrayList<Component> componentList = new ArrayList<Component>();
	Container container = this.getContentPane();
	private ExpandDirection expandDirection = ExpandDirection.DOWN;
	
	

	public MenubarDialog() {
		// TODO : Modify constructor of menubar buttons

		// TODO : Switch to gridbag
		this.setBounds(0, TradeUtility.screenSize.height - HEIGHT, WIDTH, HEIGHT);
		container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		// TODO : Update Locale
		historyButton = new MenubarButton("");
		// stashTabButton = new MenubarButton("");
		chatScannerButton = new MenubarButton("Chat Scanner");
		// characterButton = new MenubarButton("");
		testButton = new MenubarButton("");
		optionsButton = new MenubarButton("");
		quitButton = new MenubarButton("");
		minimizeButton = new MenubarButton("");

//		testButton.setToolTipText("This is a test.");

		container.add(historyButton);
		// container.add(stashTabButton);
		container.add(chatScannerButton);
		// container.add(characterButton);
		if(test){
			container.add(testButton);
		}
		container.add(optionsButton);
		container.add(new BasicPanel(MenubarButton.WIDTH, spacerHeight));
		container.add(quitButton);
		container.add(new BasicPanel(MenubarButton.WIDTH, spacerHeight));
		container.add(minimizeButton);

		this.refreshButtonText();

		componentList = container.getComponents();

		// TODO : Move button actions

		// HISTORY
		historyButton.addMouseListener(new AdvancedMouseAdapter() {
			public void click(MouseEvent evt) {
				if (!FrameManager.historyWindow.isVisible()) {
					FrameManager.hideMenuFrames();
					FrameManager.historyWindow.setShow(true);
				}
			}
		});

		// Chat Scanner
		chatScannerButton.addMouseListener(new AdvancedMouseAdapter() {
			public void click(MouseEvent evt) {
				if (!FrameManager.chatScannerWindow.isVisible()) {
					FrameManager.hideMenuFrames();
					FrameManager.chatScannerWindow.setShow(true);
				}
			}
		});

		// TEST
		testButton.addMouseListener(new AdvancedMouseAdapter() {
			public void click(MouseEvent evt) {
				Random rng = new Random();
				TradeOffer t = new TradeOffer("", "", MessageType.INCOMING_TRADE, "<GLD>", "SmashyMcFireBalls", "Superior Item Name", 3, "chaos", 3.5, "STASH_TAB", rng.nextInt(12) + 1, rng.nextInt(12) + 1, "", "");
				TradeOffer t2 = new TradeOffer("", "", MessageType.OUTGOING_TRADE, "<GLD>", "SmashyMcFireBalls", "Superior Item Name", 3, "chaos", 5, "STASH_TAB", rng.nextInt(12) + 1, rng.nextInt(12) + 1, "", "");
				TradeOffer t3 = new TradeOffer("", "", MessageType.OUTGOING_TRADE, "<GLD>", "SmashyMcFireBalls", "Superior Item Name", 3, "chaos", 5, "STASH_TAB", rng.nextInt(12) + 1, rng.nextInt(12) + 1, "", "");
				TradeOffer t4 = new TradeOffer("", "", MessageType.OUTGOING_TRADE, "<GLD>", "SmashyMcFireBalls", "Superior Item Name", 3, "chaos", 7, "STASH_TAB", rng.nextInt(12) + 1, rng.nextInt(12) + 1, "", "");
				TradeOffer t5 = new TradeOffer("", "", MessageType.OUTGOING_TRADE, "<GLD>", "SmashyMcFireBalls", "Item Name", 3, "chaos", 7, "STASH_TAB", rng.nextInt(12) + 1, rng.nextInt(12) + 1, "", "");
				TradeOffer t6 = new TradeOffer("", "", MessageType.OUTGOING_TRADE, "<GLD>", "SmashyMcFireBalls", "Item Name", 3.5, "chaos", 3.5, "STASH_TAB", rng.nextInt(12) + 1, rng.nextInt(12) + 1, "", "");
				TradeOffer t7 = new TradeOffer("", "", MessageType.CHAT_SCANNER,  "<GLD>", "SmashyMcFireBalls", "Search Name", "example text", null, null);
				FrameManager.messageManager.addMessage(t);
				FrameManager.messageManager.addMessage(t2);
//				FrameManager.messageManager.addMessage(t3);
//				FrameManager.messageManager.addMessage(t4);
//				FrameManager.messageManager.addMessage(t5);
//				FrameManager.messageManager.addMessage(t6);
				FrameManager.messageManager.addMessage(t7);
				// FrameManager.historyWindow.setOrder(false);
			}
		});

		// OPTIONS
		optionsButton.addMouseListener(new AdvancedMouseAdapter() {
			public void click(MouseEvent evt) {
				if(!FrameManager.optionsWindow.isVisible()){
					FrameManager.hideMenuFrames();
					FrameManager.optionsWindow.setShow(true);
				}
			}
		});

		// QUIT PROGRAM
		quitButton.addMouseListener(new AdvancedMouseAdapter() {
			public void click(MouseEvent e) {
				System.exit(0);
			}
		});

		// TODO : Is there a way to avoid calling refresh here?
		minimizeButton.addMouseListener(new AdvancedMouseAdapter() {
			public void click(MouseEvent e) {
				FrameManager.menubarToggle.setShow(true);
				FrameManager.menubar.setShow(false);
			}
		});
	}

	private void refreshButtonText() {
		ResourceBundle lang = ResourceBundle.getBundle("lang");
		optionsButton.setText(lang.getString("optionsButton"));
		historyButton.setText(lang.getString("historyButton"));
		// stashTabButton.setText(lang.getString("stashButton"));
		// characterButton.setText(lang.getString("characterButton"));
		testButton.setText(lang.getString("testButton"));
		// clearButton.setText(lang.getString("clearDebugButton"));
		// refreshButton.setText(lang.getString("refreshButton"));
		quitButton.setText(lang.getString("quitButton"));
		minimizeButton.setText(lang.getString("minimizeButton"));
	}

	public void updateLocation() {
		this.setLocation(Main.saveManager.getInt("overlayManager", "menubar", "x"), Main.saveManager.getInt("overlayManager", "menubar", "y"));

	}

	public void reorder() {
		MenubarButtonLocation loc = MenubarButtonLocation.valueOf(Main.saveManager.getEnumValue(MenubarButtonLocation.class, "overlayManager", "menubar", "buttonLocation"));
		switch (loc) {
		case NE:
		case NW:
			for (Component c : componentList) {
				container.add(c, 0);
			}
			break;
		case SE:
		case SW:
			for (Component c : componentList) {
				container.add(c);
			}
			break;
		}
		this.revalidate();
		this.repaint();
	}

}
