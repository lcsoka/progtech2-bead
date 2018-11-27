/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.components;

import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.frontend.GuiManager;
import hu.elte.vnt4j6.frontend.windows.HouseWindow;
import hu.elte.vnt4j6.frontend.windows.MainWindow;
import hu.elte.vnt4j6.frontend.windows.PersonalityWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.LinkedList;
//from   ww  w . j a v a 2  s  . co m
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/**
 *
 * @author lcsoka
 */
public final class HousesPanel extends JPanel {

    private final MainWindow window;
    private GridBagLayout gbLayout;
    private GridBagConstraints gbc;
    private JPanel headerPanel;
    private JPanel contentPanel;
    private JPanel footerPanel;
    private JLabel titleLbl;
    private JLabel houseNameLbl;
    private JLabel studentCountLbl;
    private JButton addBtn;
    private JButton editBtn;
    private JPanel scrollPanel;
    private List<JLabel> images = new LinkedList<JLabel>();
    private List<House> houses;
    private House currentHouse;

    public HousesPanel(MainWindow frame) {
        this.window = frame;
        initHousePanels();
        initButtons();

        houses = GuiManager.listAllHouses();
    }

    public void initHousePanels() {
        gbLayout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbLayout);

        initHeaderPanel();
        initContentPanel();
        initFooterPanel();

    }

    private void initHeaderPanel() {
        headerPanel = new JPanel();
        GridBagLayout gbHeaderPanel = new GridBagLayout();
        GridBagConstraints gbcHeaderPanel = new GridBagConstraints();
        headerPanel.setLayout(gbHeaderPanel);

        addBtn = new JButton("Add");
        gbcHeaderPanel.gridx = 18;
        gbcHeaderPanel.gridy = 1;
        gbcHeaderPanel.gridwidth = 1;
        gbcHeaderPanel.gridheight = 1;
        gbcHeaderPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcHeaderPanel.weightx = 1;
        gbcHeaderPanel.weighty = 0;
        gbcHeaderPanel.anchor = GridBagConstraints.EAST;
        gbcHeaderPanel.insets = new Insets(10, 10, 10, 10);
        gbHeaderPanel.setConstraints(addBtn, gbcHeaderPanel);
        headerPanel.add(addBtn);

        titleLbl = new JLabel("House");
        gbcHeaderPanel.gridx = 1;
        gbcHeaderPanel.gridy = 1;
        gbcHeaderPanel.gridwidth = 8;
        gbcHeaderPanel.gridheight = 1;
        gbcHeaderPanel.fill = GridBagConstraints.BOTH;
        gbcHeaderPanel.weightx = 1;
        gbcHeaderPanel.weighty = 1;
        gbcHeaderPanel.anchor = GridBagConstraints.WEST;
        gbcHeaderPanel.insets = new Insets(10, 10, 10, 10);
        gbHeaderPanel.setConstraints(titleLbl, gbcHeaderPanel);
        headerPanel.add(titleLbl);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 20;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbLayout.setConstraints(headerPanel, gbc);
        add(headerPanel);
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createTitledBorder(""));
        GridBagLayout gbContentPanel = new GridBagLayout();
        GridBagConstraints gbcContentPanel = new GridBagConstraints();
        contentPanel.setLayout(new BorderLayout());

        scrollPanel = new JPanel();
        scrollPanel.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(scrollPanel);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 20;
        gbc.gridheight = 14;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbLayout.setConstraints(contentPanel, gbc);
        contentPanel.add(scrollPane);
        add(contentPanel);

    }

    private void initFooterPanel() {
        footerPanel = new JPanel();
        GridBagLayout gbFooterPanel = new GridBagLayout();
        GridBagConstraints gbcFooterPanel = new GridBagConstraints();
        footerPanel.setLayout(gbFooterPanel);

        houseNameLbl = new JLabel("House name:");
        gbcFooterPanel.gridx = 0;
        gbcFooterPanel.gridy = 1;
        gbcFooterPanel.gridwidth = 1;
        gbcFooterPanel.gridheight = 1;
        gbcFooterPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcFooterPanel.weightx = 0;
        gbcFooterPanel.weighty = 0;
        gbcFooterPanel.anchor = GridBagConstraints.WEST;
        gbcFooterPanel.insets = new Insets(10, 10, 0, 10);
        gbFooterPanel.setConstraints(houseNameLbl, gbcFooterPanel);
        footerPanel.add(houseNameLbl);

        studentCountLbl = new JLabel("Student count:");
        gbcFooterPanel.gridx = 0;
        gbcFooterPanel.gridy = 2;
        gbcFooterPanel.gridwidth = 1;
        gbcFooterPanel.gridheight = 1;
        gbcFooterPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcFooterPanel.weightx = 0;
        gbcFooterPanel.weighty = 0;
        gbcFooterPanel.anchor = GridBagConstraints.WEST;
        gbcFooterPanel.insets = new Insets(10, 10, 10, 10);
        gbFooterPanel.setConstraints(studentCountLbl, gbcFooterPanel);
        footerPanel.add(studentCountLbl);

        editBtn = new JButton("Edit");
        gbcFooterPanel.gridx = 18;
        gbcFooterPanel.gridy = 2;
        gbcFooterPanel.gridwidth = 1;
        gbcFooterPanel.gridheight = 1;
        gbcFooterPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcFooterPanel.weightx = 1;
        gbcFooterPanel.weighty = 0;
        gbcFooterPanel.anchor = GridBagConstraints.EAST;
        gbcFooterPanel.insets = new Insets(10, 10, 10, 10);
        gbFooterPanel.setConstraints(editBtn, gbcFooterPanel);
        footerPanel.add(editBtn);

        houseNameLbl = new JLabel("Test");
        gbcFooterPanel.gridx = 1;
        gbcFooterPanel.gridy = 1;
        gbcFooterPanel.gridwidth = 1;
        gbcFooterPanel.gridheight = 1;
        gbcFooterPanel.fill = GridBagConstraints.BOTH;
        gbcFooterPanel.weightx = 0;
        gbcFooterPanel.weighty = 0;
        gbcFooterPanel.anchor = GridBagConstraints.WEST;
        gbcFooterPanel.insets = new Insets(10, 0, 0, 0);
        gbFooterPanel.setConstraints(houseNameLbl, gbcFooterPanel);
        footerPanel.add(houseNameLbl);

        studentCountLbl = new JLabel("35");
        gbcFooterPanel.gridx = 1;
        gbcFooterPanel.gridy = 2;
        gbcFooterPanel.gridwidth = 1;
        gbcFooterPanel.gridheight = 1;
        gbcFooterPanel.fill = GridBagConstraints.BOTH;
        gbcFooterPanel.weightx = 0;
        gbcFooterPanel.weighty = 0;
        gbcFooterPanel.anchor = GridBagConstraints.WEST;
        gbcFooterPanel.insets = new Insets(10, 0, 10, 0);
        gbFooterPanel.setConstraints(studentCountLbl, gbcFooterPanel);
        footerPanel.add(studentCountLbl);

        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.gridwidth = 20;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbLayout.setConstraints(footerPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.gridwidth = 20;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbLayout.setConstraints(footerPanel, gbc);
        add(footerPanel);
    }

    private void initButtons() {
        addBtn.addActionListener(this::addHouse);
    }

    private void addHouse(ActionEvent e) {
//        window.addHouse();
        HouseWindow houseWindow = new HouseWindow();
        houseWindow.pack();
        houseWindow.setVisible(true);

    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
        if (houses.size() > 0) {
            for (House house : houses) {
                ImageIcon icon = new ImageIcon(house.getLogo());
                Image img = icon.getImage();
                Image newImage = img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                icon.setImage(newImage);

                JLabel lbl = new JLabel(house.getHouseName());
                lbl.setHorizontalTextPosition(JLabel.CENTER);
                lbl.setVerticalTextPosition(JLabel.BOTTOM);
                lbl.setOpaque(true);
                lbl.setIcon(icon);
                lbl.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        selectHouse(lbl, house);
                    }
                });

                this.images.add(lbl);
                scrollPanel.add(lbl);
            }
            // Select first
            selectHouse(this.images.get(0), this.houses.get(0));
        }
    }

    private void selectHouse(JLabel selected, House house) {
        this.images.forEach((lbl) -> {
            lbl.setBackground(null);
            lbl.setForeground(Color.black);
        });
        selected.setBackground(Color.DARK_GRAY);
        selected.setForeground(Color.white);
        currentHouse = house;
        houseNameLbl.setText(house.getHouseName());
        int studentCount = GuiManager.getStudentCount(house.getId());
        studentCountLbl.setText("" + studentCount);
    }
}
