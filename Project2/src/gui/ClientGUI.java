package gui;

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
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtNamn;

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
		frame.setBounds(100, 100, 632, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textPane.setText("Record");
		
		txtNamn = new JTextField();
		txtNamn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNamn.setText("Namn");
		txtNamn.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button_4 = new JButton("Spara \u00E4ndringar");
		button_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JButton button_5 = new JButton("Ignorera \u00E4ndringar");
		button_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		button_5.setToolTipText("");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNamn, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_5, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
							.addGap(10))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtNamn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
		);
		
		JList list = new JList();
		list.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		panel_2.setLayout(gl_panel_2);
		
		JButton button_1 = new JButton("L\u00E4gga till");
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		button_1.setBounds(10, 11, 212, 50);
		
		JButton button_2 = new JButton("Redigera");
		button_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		button_2.setBounds(10, 72, 212, 50);
		
		JButton button_3 = new JButton("Ta bort");
		button_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		button_3.setBounds(10, 133, 212, 50);
		panel_1.setLayout(null);
		panel_1.add(button_1);
		panel_1.add(button_2);
		panel_1.add(button_3);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Anv\u00E4ndarnamn");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label.setLabelFor(label);
		label.setBounds(10, 10, 205, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(10, 35, 212, 30);
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("L\u00F6senord");
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_1.setLabelFor(label_1);
		label_1.setBounds(10, 76, 205, 14);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 101, 212, 30);
		panel.add(passwordField);
		
		JButton button = new JButton("Logga in");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		button.setBounds(10, 166, 212, 50);
		panel.add(button);
		
		JButton btnLoggaUt = new JButton("Logga ut");
		btnLoggaUt.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnLoggaUt.setBounds(10, 227, 212, 50);
		panel.add(btnLoggaUt);
		frame.getContentPane().setLayout(groupLayout);
	}
}
