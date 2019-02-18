package main.java.com.slimtrade.gui.history;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.com.slimtrade.core.utility.TradeOffer;
import main.java.com.slimtrade.gui.FrameManager;
import main.java.com.slimtrade.gui.panels.BufferPanel;
import main.java.com.slimtrade.gui.stash.ResizableWindow;

public class HistoryWindow extends ResizableWindow {
	private static final long serialVersionUID = 1L;
	// TODO : Move gc to parent?
	private GridBagConstraints gc = new GridBagConstraints();
	public Insets inset = new Insets(0, 0, 0, 0);

	HistoryPanel incomingPanel = new HistoryPanel();
	HistoryPanel outgoingPanel = new HistoryPanel();
	// private ArrayList<TradeOffer> incomingTradeData = new
	// ArrayList<TradeOffer>();

	public HistoryWindow() {
		super("NEW HISTORY");
		this.setPreferredSize(new Dimension(900, 600));

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = inset;
		container.setLayout(new BorderLayout());

		// GridBagPanel historyContainer = new GridBagPanel();

		JScrollPane incomingScroll = new JScrollPane(incomingPanel);
		JScrollPane outgoingScroll = new JScrollPane(outgoingPanel);

//		incomingScroll.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
//		outgoingScroll.setBorder(null);

		JPanel buttonPanel = new JPanel();
		JPanel innerPanel = new JPanel();

		// incomingPanel.setBackground(Color.GREEN);

		innerPanel.setLayout(new BorderLayout());
		innerPanel.add(buttonPanel, BorderLayout.NORTH);
		innerPanel.add(new BufferPanel(10, 0), BorderLayout.WEST);
		innerPanel.add(new BufferPanel(0, 10), BorderLayout.SOUTH);
		innerPanel.add(new BufferPanel(10, 0), BorderLayout.EAST);
		
		JButton incomingButton = new JButton("Incoming");
		JButton outgoingButton = new JButton("Outgoing");
		JButton savedButton = new JButton("Saved");

		buttonPanel.add(incomingButton);
		buttonPanel.add(outgoingButton);
		buttonPanel.add(savedButton);

		// scrollPane

		container.add(innerPanel, BorderLayout.CENTER);

		JPanel bufferPanel = new BufferPanel(0, 10);

		ResizableWindow local = this;
		incomingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outgoingScroll.setVisible(false);
				incomingScroll.setVisible(true);
				innerPanel.add(incomingScroll, BorderLayout.CENTER);

				innerPanel.revalidate();
				innerPanel.repaint();

				// local.autoResize();
				// local.pack();
				// local.repaint();
			}
		});
		outgoingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incomingScroll.setVisible(false);
				outgoingScroll.setVisible(true);
				innerPanel.add(outgoingScroll, BorderLayout.CENTER);

				innerPanel.revalidate();
				innerPanel.repaint();

				// local.autoResize();
				// local.pack();
				// local.repaint();
			}
		});
		incomingScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		outgoingScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		innerPanel.add(incomingScroll, BorderLayout.CENTER);
		innerPanel.revalidate();
		innerPanel.repaint();

		this.pack();
		FrameManager.centerFrame(this);
		// incomingScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	public void addTrade(TradeOffer trade, boolean updateUI) {
		switch (trade.msgType) {
		case CHAT_SCANNER:
			break;
		case INCOMING_TRADE:
			incomingPanel.addTrade(trade, updateUI);
			break;
		case OUTGOING_TRADE:
			outgoingPanel.addTrade(trade, updateUI);
			break;
		case UNKNOWN:
			break;
		default:
			break;

		}
	}

	public void buildHistory() {
		outgoingPanel.initUI();
		incomingPanel.initUI();
		incomingPanel.revalidate();
		incomingPanel.repaint();
		this.revalidate();
		this.repaint();
	}

}
