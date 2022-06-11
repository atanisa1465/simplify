import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class CreateEventForm extends JPanel {

    private JLabel monthLabel, dayLabel, yearLabel;
    private final Box eventBox;
    private JButton okay, cancel;
    private JComboBox billsBox;
    private final String[] bills = {"Test", "Homework","Other"};
    private final String[] quickPaymentAmount = {"English", "Math", "Computer Science", "Science", "Social Studies", "Other"};
    private final JRadioButton eventButton[] = new JRadioButton[quickPaymentAmount.length];
    private final JPanel descriptionPanel;
    private JTextField descriptionTitle;
    private final JTextField manualInput = new JTextField(6);
    private Box horizontal5;
    private final JTabbedPane theAppTabs;
    private Events demo;
    private EmptyBorder padding = new EmptyBorder(10, 0, 10, 0);
    private Font font = new java.awt.Font("Lucida Grande", 0, 14);

    public CreateEventForm(Events demo, JTabbedPane theAppTabs) {
        this.setBackground(new java.awt.Color(245, 247, 251));
        this.theAppTabs = theAppTabs;
        this.demo = demo;
        eventBox = Box.createVerticalBox();
        eventBox.setBackground(new java.awt.Color(245, 247, 251));
        JPanel topLayer = createTopLayer(demo);
        JPanel secondLayer = createSecondLayer();
        JPanel thirdLayer = createThirdLayer();
        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(new java.awt.Color(245, 247, 251));
        displayRadioButton();
        JPanel decisionPanel = createOkayAndCancelButtons();
        decisionPanel.setBackground(new java.awt.Color(245, 247, 251));
        eventBox.add(topLayer);
        eventBox.add(secondLayer);
        eventBox.add(thirdLayer);
        eventBox.add(descriptionPanel);
        eventBox.add(decisionPanel);
        this.add(eventBox);
        this.setVisible(true);
    }

    private JPanel createThirdLayer() {
        ComboBoxListener comboChanger = new ComboBoxListener();
        JPanel thirdLayer = new JPanel();
        billsBox = new JComboBox(bills);
        billsBox.addActionListener(comboChanger);
        thirdLayer.add(billsBox);
        thirdLayer.setBorder(padding);
        thirdLayer.setBackground(new java.awt.Color(245, 247, 251));
        return thirdLayer;
    }

    private JPanel createSecondLayer() {
        JPanel secondLayer = new JPanel();
        secondLayer.setBackground(new java.awt.Color(245, 247, 251));
        JLabel questionToUser = new JLabel("What Would You Like To Plan?");
        questionToUser.setFont(font);
        secondLayer.add(questionToUser);
        secondLayer.setBorder(padding);
        return secondLayer;
    }

    private JPanel createTopLayer(Events demo1) {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new java.awt.Color(245, 247, 251));
        monthLabel = new JLabel(demo1.getMonth());
        dayLabel = new JLabel(demo1.getDay());
        yearLabel = new JLabel(demo1.getYear());
        monthLabel.setFont(font);
        dayLabel.setFont(font);
        yearLabel.setFont(font);
        topPanel.add(monthLabel);
        topPanel.add(dayLabel);
        topPanel.add(yearLabel);
        return topPanel;
    }

    private JPanel createOkayAndCancelButtons() {
        OkayCancelListener okayCancelChanger = new OkayCancelListener();
        JPanel decisionPanel = new JPanel();
        okay = new JButton("Set Event");
        cancel = new JButton("Cancel");
        okay.setBackground(new java.awt.Color(246, 232, 253));
        cancel.setBackground(new java.awt.Color(246, 232, 253));
        okay.setFont(font);
        cancel.setFont(font);
        okay.addActionListener(okayCancelChanger);
        cancel.addActionListener(okayCancelChanger);
        decisionPanel.add(cancel);
        decisionPanel.add(okay);
        decisionPanel.setBorder(padding);
        decisionPanel.setBackground(new java.awt.Color(245, 247, 251));
        return decisionPanel;
    }

    //The majority of this method was not written by me
    //Source: Stack Overflow
    private void displayRadioButton() {
        EmptyBorder horizontalPadding = new EmptyBorder(0, 10, 0, 10);
        ButtonGroup quickPaymentGroup = new ButtonGroup();
        RadioButtonListener radioGroupListener = new RadioButtonListener();
        Box vertical = Box.createVerticalBox();
        vertical.setBackground(new java.awt.Color(245, 247, 251));
        Box horizontal = Box.createHorizontalBox();
        horizontal.setBorder(padding);
        horizontal.setBackground(new java.awt.Color(245, 247, 251));
        Box horizontal2 = Box.createHorizontalBox();
        horizontal2.setBorder(padding);
        horizontal2.setBackground(new java.awt.Color(245, 247, 251));
        Box horizontal3 = Box.createHorizontalBox();
        horizontal3.setBorder(padding);
        horizontal3.setBackground(new java.awt.Color(245, 247, 251));
        Box horizontal4 = Box.createHorizontalBox();
        horizontal4.setBorder(padding);
        horizontal4.setBackground(new java.awt.Color(245, 247, 251));
        horizontal5 = Box.createHorizontalBox();
        horizontal5.setBackground(new java.awt.Color(245, 247, 251));

        for (int i = 0; i < eventButton.length; i++) {
            if (i < 2) {
                quickPaymentGroup.add(eventButton[i] = new JRadioButton(quickPaymentAmount[i]));
                eventButton[i].setFont(font);
                eventButton[i].addActionListener(radioGroupListener);
                eventButton[i].setBorder(horizontalPadding);
                eventButton[i].setBackground(new java.awt.Color(245, 247, 251));
                horizontal.add(eventButton[i]);
            } else if (i >= 2 && i < 4) {
                quickPaymentGroup.add(eventButton[i] = new JRadioButton(quickPaymentAmount[i]));
                eventButton[i].addActionListener(radioGroupListener);
                eventButton[i].setFont(font);
                eventButton[i].setBorder(horizontalPadding);
                eventButton[i].setBackground(new java.awt.Color(245, 247, 251));
                horizontal2.add(eventButton[i]);
            } else if (i >= 4 && i < 6) {
                quickPaymentGroup.add(eventButton[i] = new JRadioButton(quickPaymentAmount[i]));
                eventButton[i].addActionListener(radioGroupListener);
                eventButton[i].setFont(font);
                eventButton[i].setBorder(horizontalPadding);
                eventButton[i].setBackground(new java.awt.Color(245, 247, 251));
                horizontal3.add(eventButton[i]);
            } else {
                quickPaymentGroup.add(eventButton[i] = new JRadioButton(quickPaymentAmount[i]));
                eventButton[i].addActionListener(radioGroupListener);
                eventButton[i].setFont(font);
                eventButton[i].setBorder(horizontalPadding);
                eventButton[i].setBackground(new java.awt.Color(245, 247, 251));
                horizontal4.add(eventButton[i]);
            }
        }
        vertical.add(horizontal);
        vertical.add(horizontal2);
        vertical.add(horizontal3);
        vertical.add(horizontal4);
        vertical.add(horizontal5);
        descriptionPanel.add(vertical);
        descriptionPanel.updateUI();
    }

    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AbstractButton radioButton = (AbstractButton) e.getSource();
            if (radioButton.getText().equals("Other")) { horizontal5.add(manualInput); } 
            else { horizontal5.remove(manualInput); }
            updateUI();
        }
    }

    private class OkayCancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == okay) {
                String getBillSelected = billsBox.getSelectedItem().toString();//grabs bills[] 
                if (!getBillSelected.equals("Other")) {
                    String getRadioValue = null;
                    boolean isOtherPaymentButtonSelected = eventButton[5].isSelected();
                    if (isOtherPaymentButtonSelected) {
                        String money = "";
                        getRadioValue = money.concat(manualInput.getText());
                    } else {
                        for (JRadioButton eventButton1 : eventButton) {
                            if (eventButton1.isSelected()) {
                                getRadioValue = eventButton1.getText();
                            }
                        }
                    }
                    String newEvent =getRadioValue+" "+getBillSelected;
                    demo.setEvent(newEvent);
                    EventLinkedList.instanceOf().add(demo);
                } 
                else {
                    String titleOfDescription = descriptionTitle.getText();
                    demo.setEvent(titleOfDescription);
                    EventLinkedList.instanceOf().add(demo);
                }
            }
            else if (e.getSource() == cancel) {}
            theAppTabs.setEnabledAt(0, true);
            theAppTabs.setEnabledAt(1, true);
            theAppTabs.remove(2);
            theAppTabs.setSelectedIndex(0);
        }

    }

    private class textTitleAction implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            if (descriptionTitle.getText().equals("Enter your event title")) {
                descriptionTitle.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (descriptionTitle.getText().equals("")) {
                descriptionTitle.setText("Enter your event title");
            }
        }

    }

    private class ComboBoxListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            descriptionPanel.removeAll();
            switch (billsBox.getSelectedIndex()) {
                case 0:
                case 1: displayRadioButton(); break;
                case 2:
                    textTitleAction textTitle = new textTitleAction();
                    Box vert = Box.createVerticalBox();
                    descriptionTitle = new JTextField(30);
                    descriptionTitle.setText("Enter your event title");
                    descriptionTitle.addFocusListener(textTitle);
                    vert.add(descriptionTitle);
                    descriptionPanel.add(vert);
                    descriptionPanel.updateUI();
                    break;
            }
        }

    }

}
