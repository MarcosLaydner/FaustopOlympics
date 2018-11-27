package br.ufsc.FaustopOlympics.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TrayIcon.MessageType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufsc.FasutopOlympics.control.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
		JLabel lblNewLabel = new JLabel("Olimpíadas do Faustop");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 254);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOlimpadasDoFaustop = new JLabel("Olimpíadas do Faustop");
		lblOlimpadasDoFaustop.setForeground(Color.YELLOW);
		lblOlimpadasDoFaustop.setBounds(5, 5, 424, 14);
		contentPane.add(lblOlimpadasDoFaustop);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setForeground(Color.GREEN);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map.getInstance().connect(JOptionPane.showInputDialog(contentPane, "Please input your name:", "Connect", JOptionPane.QUESTION_MESSAGE));
			}
		});
		btnConnect.setBackground(Color.BLACK);
		btnConnect.setBounds(164, 52, 108, 23);
		contentPane.add(btnConnect);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBackground(Color.BLACK);
		btnStart.setForeground(Color.GREEN);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setBounds(164, 86, 108, 23);
		contentPane.add(btnStart);
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setForeground(Color.GREEN);
		btnDisconnect.setBackground(Color.BLACK);
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDisconnect.setBounds(164, 120, 108, 23);
		contentPane.add(btnDisconnect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.GREEN);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setBounds(164, 154, 108, 23);
		contentPane.add(btnExit);
		
		JButton btnGamescr = new JButton("GameScr");
		btnGamescr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map.getInstance().showGameScreen();
			}
		});
		btnGamescr.setBounds(335, 52, 89, 23);
		contentPane.add(btnGamescr);
	}
}
