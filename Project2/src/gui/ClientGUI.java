package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
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
import java.awt.Font;

public class ClientGUI {

	private JFrame frame;
	private JTextField textFieldUserName;
	private JPasswordField textFieldPassword;
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 597);
		frame.setMinimumSize(new Dimension(701, 597));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelAuthentication = new JPanel();
		panelAuthentication.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelAction = new JPanel();
		panelAction.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelRecords = new JPanel();
		panelRecords.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
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
		textPaneRecord.setText("Record");
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldName.setText("Namn");
		textFieldName.setColumns(10);
		
		JScrollPane scrollPaneRecords = new JScrollPane();
		
		JButton buttonSave = new JButton("Spara \u00E4ndringar");
		buttonSave.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JButton buttonDiscard = new JButton("Ignorera \u00E4ndringar");
		buttonDiscard.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonDiscard.setToolTipText("");
		GroupLayout gl_panelRecords = new GroupLayout(panelRecords);
		gl_panelRecords.setHorizontalGroup(
			gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelRecords.createSequentialGroup()
					.addContainerGap()
					.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelRecords.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addComponent(textPaneRecord, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addGroup(gl_panelRecords.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPaneRecords, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
								.addGroup(gl_panelRecords.createSequentialGroup()
									.addComponent(buttonSave, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(buttonDiscard, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
							.addGap(10))))
		);
		gl_panelRecords.setVerticalGroup(
			gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRecords.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneRecords, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneRecord, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonDiscard, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
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
		
		JButton buttonAdd = new JButton("Lägg till");
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
			}
		});
		buttonLogIn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonLogIn.setBounds(10, 166, 212, 50);
		panelAuthentication.add(buttonLogIn);
		
		JButton buttonLogOut = new JButton("Logga ut");
		buttonLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		buttonLogOut.setBounds(10, 227, 212, 50);
		panelAuthentication.add(buttonLogOut);
		frame.getContentPane().setLayout(groupLayout);
	}
}
