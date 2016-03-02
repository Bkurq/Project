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
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import RecordManagement.FileParser;
import RecordManagement.RecordManager;

import java.awt.FlowLayout;

import javax.swing.JSeparator;

import client.Client;
import usermanagement.DoctorUser;
import usermanagement.User;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Color;
import javax.swing.UIManager;

public class ClientGUI {

	private JFrame frmMdview;
	private JPasswordField textFieldPassword;
	private JTextField textFieldUserName, textFieldPatient, textFieldDoctor, textFieldNurse, textFieldDivision;
	private Vector<FileParser> medicalRecords;
	private JList listRecords;
	private User user;
	private JTextPane textPaneRecord;
	private JButton buttonLogOut, buttonSave, buttonDiscard, buttonRecord, buttonAdd, buttonEdit, buttonRemove, buttonLogIn;
	private JScrollPane scrollPaneText;
	

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
		RecordManager recordManager = new RecordManager("records");
		medicalRecords = new Vector<FileParser>(recordManager.getRecords());
		user = new DoctorUser("Doctor5", "Division1");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMdview = new JFrame();
		frmMdview.getContentPane().setBackground(new Color(245, 255, 250));
		frmMdview.setIconImage(Toolkit.getDefaultToolkit().getImage(ClientGUI.class.getResource("/gui/icon.png")));
		frmMdview.setTitle("Journalakuten");
		frmMdview.setBounds(100, 100, 800, 597);
		frmMdview.setMinimumSize(new Dimension(800, 597));
		frmMdview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelAuthentication = new JPanel();
		panelAuthentication.setBackground(new Color(255, 255, 255));
		panelAuthentication.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelAction = new JPanel();
		panelAction.setBackground(new Color(255, 255, 255));
		panelAction.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelRecords = new JPanel();
		panelRecords.setBackground(new Color(255, 255, 255));
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
		
		textFieldPatient = new JTextField();
		textFieldPatient.setToolTipText("Patient's name");
		textFieldPatient.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldPatient.setColumns(10);
		
		JScrollPane scrollPaneRecords = new JScrollPane();
		
		buttonSave = new JButton("Spara \u00E4ndringar");
		buttonSave.setForeground(Color.BLACK);
		buttonSave.setBackground(UIManager.getColor("Button.background"));
		buttonSave.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		buttonDiscard = new JButton("Ignorera \u00E4ndringar");
		buttonDiscard.setForeground(Color.BLACK);
		buttonDiscard.setBackground(UIManager.getColor("Button.background"));
		buttonDiscard.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonDiscard.setToolTipText("");
		
		textFieldDoctor = new JTextField();
		textFieldDoctor.setToolTipText("Doctor's name");
		textFieldDoctor.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldDoctor.setColumns(10);
		
		textFieldNurse = new JTextField();
		textFieldNurse.setToolTipText("Nurse's name");
		textFieldNurse.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldNurse.setColumns(10);
		
		textFieldDivision = new JTextField();
		textFieldDivision.setToolTipText("Hospital division");
		textFieldDivision.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldDivision.setColumns(10);
		
		buttonRecord = new JButton("Se loggen");
		buttonRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(user.canRecord(medicalRecords.get(listRecords.getMaxSelectionIndex()))) {
						textPaneRecord.setText(medicalRecords.get(listRecords.getMaxSelectionIndex()).getLog());
					} else {
						textPaneRecord.setText("Du har ingen rätt att visa den här loggen");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Välj en patientjournal", "Fel", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonRecord.setToolTipText("");
		buttonRecord.setForeground(Color.BLACK);
		buttonRecord.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonRecord.setBackground(UIManager.getColor("Button.background"));
		
		scrollPaneText = new JScrollPane();
		GroupLayout gl_panelRecords = new GroupLayout(panelRecords);
		gl_panelRecords.setHorizontalGroup(
			gl_panelRecords.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelRecords.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneText, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addComponent(buttonSave, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonRecord, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonDiscard, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
						.addComponent(scrollPaneRecords, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addComponent(textFieldPatient, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneText, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelRecords.createParallelGroup(Alignment.BASELINE)
							.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonDiscard, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonRecord, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		textPaneRecord = new JTextPane();
		scrollPaneText.setViewportView(textPaneRecord);
		textPaneRecord.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		listRecords = new JList(medicalRecords);
		listRecords.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		listRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel listSelectionModel = listRecords.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent e) {
	        	displayRecord(e);
	        }
	    });
		scrollPaneRecords.setViewportView(listRecords);
		panelRecords.setLayout(gl_panelRecords);
		
		buttonAdd = new JButton("L\u00E4gg till");
		buttonAdd.setBackground(UIManager.getColor("Button.background"));
		buttonAdd.setForeground(Color.BLACK);
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonAdd.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonAdd.setBounds(10, 11, 212, 50);
		
		buttonEdit = new JButton("Redigera");
		buttonEdit.setForeground(Color.BLACK);
		buttonEdit.setBackground(UIManager.getColor("Button.background"));
		buttonEdit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonEdit.setBounds(10, 72, 212, 50);
		
		buttonRemove = new JButton("Ta bort");
		buttonRemove.setForeground(Color.BLACK);
		buttonRemove.setBackground(UIManager.getColor("Button.background"));
		buttonRemove.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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
		
		buttonLogIn = new JButton("Logga in");
		buttonLogIn.setForeground(new Color(255, 255, 255));
		buttonLogIn.setBackground(new Color(50, 205, 50));
		buttonLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(textFieldUserName.getText());
//				System.out.println(textFieldPassword.getText());
//				System.out.println("clientkeystore"+textFieldUserName.getText());
//				//fпїЅrsпїЅk kпїЅra Client med rпїЅtt username
//				String[] clientargs = {"localhost","9876",textFieldUserName.getText(),textFieldPassword.getText()};
//				try {
//					Client.main(clientargs);
//				} catch (Exception e) {
//					//throw new IOException(e.getMessage());
//					System.out.println(e.getMessage());
//				}
				
			}
		});
		buttonLogIn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonLogIn.setBounds(10, 166, 212, 50);
		panelAuthentication.add(buttonLogIn);
		
		buttonLogOut = new JButton("Logga ut");
		buttonLogOut.setBackground(new Color(250, 128, 114));
		buttonLogOut.setForeground(new Color(255, 255, 255));
		buttonLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonLogOut.setBounds(10, 227, 212, 50);
		panelAuthentication.add(buttonLogOut);
		frmMdview.getContentPane().setLayout(groupLayout);
		buttonAdd.setEnabled(false);
		buttonRemove.setEnabled(false);
		buttonEdit.setEnabled(false);
		buttonSave.setEnabled(false);
		buttonDiscard.setEnabled(false);
	}

	public void displayRecord(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		listChangeEnableButtons(medicalRecords.get(lsm.getMaxSelectionIndex()));
		textFieldPatient.setText("");
		textFieldDoctor.setText("");
		textFieldNurse.setText("");
		textFieldDivision.setText("");
		textPaneRecord.setText("");
		if (user.canRead(medicalRecords.get(lsm.getMaxSelectionIndex()))) {
			textFieldPatient.setText(medicalRecords.get(lsm.getMaxSelectionIndex()).getPatient());
			textFieldDoctor.setText(medicalRecords.get(lsm.getMaxSelectionIndex()).getDoctor());
			textFieldNurse.setText(medicalRecords.get(lsm.getMaxSelectionIndex()).getNurse());
			textFieldDivision.setText(medicalRecords.get(lsm.getMaxSelectionIndex()).getDivision());
			textPaneRecord.setText(medicalRecords.get(lsm.getMaxSelectionIndex()).getRecord());
		} else {
			textPaneRecord.setText("Du har ingen rätt att visa den här patientjournalen");
		}
	}

	private void listChangeEnableButtons(FileParser fileParser) {
		if(user.canWrite(fileParser)) {
			buttonEdit.setEnabled(true);
		} else {
			buttonEdit.setEnabled(false);
		}
		if(user.canDelete(fileParser)) {
			buttonRemove.setEnabled(false);
		} else {
			buttonRemove.setEnabled(false);
		}
		
	}
}
