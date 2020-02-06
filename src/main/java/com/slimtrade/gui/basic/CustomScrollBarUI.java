package com.slimtrade.gui.basic;

import com.slimtrade.core.managers.ColorManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {

//    Color trackColor = Color.RED;
//    Color thumbColor = Color.BLACK;
//    Color thumbDarkShadowColor = trackColor;
//    Color thumbLightShadowColor = trackColor;

    public CustomScrollBarUI() {
        super();
        UIManager.put("ScrollBar.width", 12);
        UIManager.put("ScrollBar.height", 12);
    }


    @Override
    protected void configureScrollBarColors() {
        this.trackColor = ColorManager.LOW_CONSTRAST_1;
        this.thumbColor = ColorManager.HIGH_CONTRAST_1;

    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        JButton decreaseButton = new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }
        };
        return decreaseButton;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        JButton increaseButton = new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }
        };
        return increaseButton;
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        g.clearRect(r.x, r.y, r.width, r.height);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled()) {
            return;
        } else if (isDragging) {
            color = ColorManager.HIGH_CONTRAST_2;
        } else if (isThumbRollover()) {
            color = ColorManager.LOW_CONSTRAST_2;
        } else {
            color = ColorManager.PRIMARY;
        }
        g2.setPaint(ColorManager.BACKGROUND);
        g2.fillRect(r.x, r.y, r.width, r.height);
        g2.setPaint(color);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, CustomScrollbar.ARC_WIDTH, CustomScrollbar.ARC_HEIGHT);
        g2.dispose();
    }

    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        g.clearRect(r.x, r.y, r.width, r.height);
        super.paintTrack(g, c, r);
        Color color = ColorManager.BACKGROUND;
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(color);
        g2.fillRect(r.x, r.y, r.width, r.height);
        g2.dispose();
    }

}