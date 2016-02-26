package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.FlowLayout;

import javax.swing.JSeparator;

import client.Client;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;

public class ClientGUI {

	private JFrame frmMdview;
	private JTextField textFieldUserName;
	private JPasswordField textFieldPassword;
	private JTextField textFieldPatient;
	private JTextField textFieldDoctor;
	private JTextField textFieldNurse;
	private JTextField textFieldDivision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frmMdview.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMdview = new JFrame();
		frmMdview.setIconImage(Toolkit.getDefaultToolkit().getImage(ClientGUI.class.getResource("/gui/icon.png")));
		frmMdview.setTitle("Journalakuten");
		frmMdview.setBounds(100, 100, 800, 597);
		frmMdview.setMinimumSize(new Dimension(800, 597));
		frmMdview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelAuthentication = new JPanel();
		panelAuthentication.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelAction = new JPanel();
		panelAction.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelRecords = new JPanel();
		panelRecords.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(frmMdview.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelAction, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelAuthentication, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelRecords, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelRecords, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelAuthentication, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addComponent(panelAction, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JTextPane textPaneRecord = new JTextPane();
		textPaneRecord.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		textFieldPatient = new JTextField();
		textFieldPatient.setToolTipText("Patient's name");
		textFieldPatient.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldPatient.setColumns(10);
		
		JScrollPane scrollPaneRecords = new JScrollPane();
		
		JButton buttonSave = new JButton("Spara \u00E4ndringar");
		buttonSave.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JButton buttonDiscard = new JButton("Ignorera \u00E4ndringar");
		buttonDiscard.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonDiscard.setToolTipText("");
		
		textFieldDoctor = new JTextField();
		textFieldDoctor.setToolTipText("Doctor's name");
		textFieldDoctor.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldDoctor.setColumns(10);
		
		textFieldNurse = new JTextField();
		textFieldNurse.setToolTipText("Nurse's name");
		textFieldNurse.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldNurse.setColumns(10);
		
		textFieldDivision = new JTextField();
		textFieldDivision.setToolTipText("Hospital division");
		textFieldDivision.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldDivision.setColumns(10);
		GroupLayout gl_panelRecords = new GroupLayout(panelRecords);
		gl_panelRecords.setHorizontalGroup(
			gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRecords.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING)
						.addComponent(textPaneRecord, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addComponent(buttonSave, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(buttonDiscard, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
						.addComponent(scrollPaneRecords, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addComponent(textFieldPatient, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldDoctor, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldNurse, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldDivision, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelRecords.setVerticalGroup(
			gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRecords.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneRecords, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRecords.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldDoctor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldNurse, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldPatient, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDivision, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneRecord, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addGap(12)
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonDiscard, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JList listRecords = new JList();
		listRecords.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		listRecords.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneRecords.setViewportView(listRecords);
		panelRecords.setLayout(gl_panelRecords);
		
		JButton buttonAdd = new JButton("L\u00E4gg till");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonAdd.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonAdd.setBounds(10, 11, 212, 50);
		
		JButton buttonEdit = new JButton("Redigera");
		buttonEdit.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonEdit.setBounds(10, 72, 212, 50);
		
		JButton buttonRemove = new JButton("Ta bort");
		buttonRemove.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonRemove.setBounds(10, 133, 212, 50);
		panelAction.setLayout(null);
		panelAction.add(buttonAdd);
		panelAction.add(buttonEdit);
		panelAction.add(buttonRemove);
		panelAuthentication.setLayout(null);
		
		JLabel labelUserName = new JLabel("Anv\u00E4ndarnamn");
		labelUserName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelUserName.setLabelFor(labelUserName);
		labelUserName.setBounds(10, 10, 205, 14);
		panelAuthentication.add(labelUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(10, 35, 212, 30);
		textFieldUserName.setColumns(10);
		panelAuthentication.add(textFieldUserName);
		
		JLabel labelPassword = new JLabel("L\u00F6senord");
		labelPassword.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelPassword.setLabelFor(labelPassword);
		labelPassword.setBounds(10, 76, 205, 14);
		panelAuthentication.add(labelPassword);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(10, 101, 212, 30);
		panelAuthentication.add(textFieldPassword);
		
		JButton buttonLogIn = new JButton("Logga in");
		buttonLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(textFieldUserName.getText());
				System.out.println(textFieldPassword.getText());
				System.out.println("clientkeystore"+textFieldUserName.getText());
				//försök köra Client med rätt username
				String[] clientargs = {"localhost","9876",textFieldUserName.getText(),textFieldPassword.getText()};
				try {
					Client.main(clientargs);
				} catch (Exception e) {
					//throw new IOException(e.getMessage());
					System.out.println(e.getMessage());
				}
			}
		});
		buttonLogIn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonLogIn.setBounds(10, 166, 212, 50);
		panelAuthentication.add(buttonLogIn);
		
		JButton buttonLogOut = new JButton("Logga ut");
		buttonLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonLogOut.setBounds(10, 227, 212, 50);
		panelAuthentication.add(buttonLogOut);
		frmMdview.getContentPane().setLayout(groupLayout);
	}
}
