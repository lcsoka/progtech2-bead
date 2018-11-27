/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.components;

import hu.elte.vnt4j6.frontend.GuiManager;
import hu.elte.vnt4j6.frontend.windows.MainWindow;
import hu.elte.vnt4j6.frontend.windows.PersonalityWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lcsoka
 */
public final class StudentsPanel extends JPanel {

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
    private JTable resultTable;
    private boolean opened = false;

    public StudentsPanel(MainWindow frame) {
        this.window = frame;
        initStudentsPanel();
        initButtons();
    }

    public void initStudentsPanel() {
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

        titleLbl = new JLabel("Students");
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
        contentPanel.setLayout(gbContentPanel);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 20;
        gbc.gridheight = 14;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbLayout.setConstraints(contentPanel, gbc);
        contentPanel.setLayout(new GridLayout(1, 0));
        // Table view
        resultTable = new JTable(5, 5);

        /**
         * this::newSelection => method reference
         * https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
         *
         * https://stackoverflow.com/questions/41069817/making-an-action-listener-for-a-jbutton-as-a-method
         *
         */
        resultTable.getSelectionModel().addListSelectionListener(this::newSelection);
        resultTable.setDefaultEditor(Object.class, null);
        contentPanel.add(new JScrollPane(resultTable));

        add(contentPanel);

    }

    private void initFooterPanel() {
        footerPanel = new JPanel();
        GridBagLayout gbFooterPanel = new GridBagLayout();
        GridBagConstraints gbcFooterPanel = new GridBagConstraints();
        footerPanel.setLayout(gbFooterPanel);

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
        editBtn.setEnabled(false);
        footerPanel.add(editBtn);

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
        addBtn.addActionListener(this::addPersonality);
        editBtn.addActionListener(this::editPersonality);
    }

    private void addPersonality(ActionEvent e) {
        PersonalityWindow personalityWindow = new PersonalityWindow();
        personalityWindow.pack();
        personalityWindow.setVisible(true);
    }

    private void editPersonality(ActionEvent e) {
        // TODO: Validator
        long id = Long.parseLong(resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString());
        String name = resultTable.getValueAt(resultTable.getSelectedRow(), 1).toString();
        
        PersonalityWindow personalityWindow = new PersonalityWindow(id,name);
        personalityWindow.pack();
        personalityWindow.setVisible(true);
    }

    private void newSelection(ListSelectionEvent event) {
        if (event.getValueIsAdjusting() && resultTable.getSelectedRow() > -1) {
            editBtn.setEnabled(true);
        } 
    }

    public <E> void addContentToTable(List<E> content, Object[] columnNames) {
        resultTable.removeAll();
        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
        content.forEach(row -> dtm.addRow((Object[]) row));
        resultTable.setModel(dtm);
    }

    public String getSelectedRowIndex() {
        return (String) resultTable.getValueAt(resultTable.getSelectedRow(), 0);
    }

    public void closePersonalityWindow() {
        this.opened = false;
    }

}
