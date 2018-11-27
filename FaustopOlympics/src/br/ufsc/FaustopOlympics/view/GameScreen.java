package br.ufsc.FaustopOlympics.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufsc.FasutopOlympics.control.Map;
import br.ufsc.FasutopOlympics.model.TILETYPE;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JMenuBar;

public class GameScreen extends JFrame {
	
	private JButton pos1;
	private JButton pos2;
	private JButton pos3;
	private JButton pos4;
	private JButton pos5;
	private JButton pos6;
	private JButton pos7;
	private JButton pos8;
	private JButton pos9;
	private JButton pos10;
	private JButton pos11;
	private JButton pos12;
	private JButton pos13;
	private JButton pos14;
	private JButton pos15;
	private JButton pos16;
	private JButton pos17;
	private JButton pos18;
	private JButton pos19;
	private JButton pos20;
	private JButton pos21;
	private JButton pos22;
	private JButton pos23;
	private JButton pos24;
	private JButton pos25;
	private JButton pos26;
	private JButton pos27;
	private JButton pos28;
	private JButton pos29;
	private JButton pos30;
	private JButton pos31;
	private JButton pos32;
	private JButton pos33;
	private JButton pos34;
	private JButton pos35;
	private JButton pos36;
	private List<JButton> btList = getButtons();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	//where the stuff is done.
	private ActionListener l = new ActionListener() {
		public void actionPerformed(final ActionEvent e) {
			for( int i = 0; i < 36; i++ ) {
				if(btList.get(i).equals((JButton) e.getSource())) {
					//translating [0-35] to coordinates [0-5][0-5]
					int j = i;
					int k = 0;
					while(j > 5) {
						j -=6;
						k++;
					}
					if(!Map.getInstance().treatMove(j,k)) {
						informMessage("Could not move to selected Tile!");
						
					}else {
						tileFill(btList.get(i), Map.getInstance().getTiles()[j][k].getTileType());
						repaint();
					}
					
				}
			}
				
			repaint();
		}
	};
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmReconnect;
	private JMenuItem mntmDisconnect;
	private JMenuItem mntmRestart;
	private JMenuItem mntmReturn;
	private JMenuItem mntmExit;

	/**
	 * Create the frame.
	 */
	public GameScreen() {
		setPreferredSize(new Dimension(550, 550));
		getContentPane().setBackground(Color.DARK_GRAY);
		addAction();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setForeground(Color.GREEN);
		lblPlayer.setBounds(114, 33, 165, 25);
		getContentPane().add(lblPlayer);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setForeground(Color.GREEN);
		lblPoints.setBounds(302, 33, 100, 25);
		getContentPane().add(lblPoints);
		
		pos1 = new JButton();
		pos2 = new JButton();
		pos3 = new JButton();
		pos4 = new JButton();
		pos5 = new JButton();
		pos6 = new JButton();
		pos7 = new JButton();
		pos8 = new JButton();
		pos9 = new JButton();
		pos10 = new JButton();
		pos11 = new JButton();
		pos12 = new JButton();
		pos13 = new JButton();
		pos14 = new JButton();
		pos15 = new JButton();
		pos16 = new JButton();
		pos17 = new JButton();
		pos18 = new JButton();
		pos19 = new JButton();
		pos20 = new JButton();
		pos21 = new JButton();
		pos22 = new JButton();
		pos23 = new JButton();
		pos24 = new JButton();
		pos25 = new JButton();
		pos26 = new JButton();
		pos27 = new JButton();
		pos28 = new JButton();
		pos29 = new JButton();
		pos30 = new JButton();
		pos31 = new JButton();
		pos32 = new JButton();
		pos33 = new JButton();
		pos34 = new JButton();
		pos35 = new JButton();
		pos36 = new JButton();
		
		getContentPane().add(pos1);getContentPane().add(pos2);getContentPane().add(pos3);getContentPane().add(pos4);getContentPane().add(pos5);getContentPane().add(pos6);getContentPane().add(pos7);getContentPane().add(pos8);getContentPane().add(pos9);
		getContentPane().add(pos10);getContentPane().add(pos11);getContentPane().add(pos12);getContentPane().add(pos13);getContentPane().add(pos14);getContentPane().add(pos15);getContentPane().add(pos16);getContentPane().add(pos17);
		getContentPane().add(pos18);getContentPane().add(pos19);getContentPane().add(pos20);getContentPane().add(pos21);getContentPane().add(pos22);getContentPane().add(pos23);getContentPane().add(pos24);getContentPane().add(pos25);
		getContentPane().add(pos26);getContentPane().add(pos27);getContentPane().add(pos28);getContentPane().add(pos29);getContentPane().add(pos30);getContentPane().add(pos31);getContentPane().add(pos32);getContentPane().add(pos33);
		getContentPane().add(pos34);getContentPane().add(pos35);getContentPane().add(pos36);
		
		
		
		pos1.setBounds(100, 80, 50, 50);
		pos2.setBounds(151, 80, 50, 50);
		pos3.setBounds(201, 80, 50, 50);
		pos4.setBounds(251, 80, 50, 50);
		pos5.setBounds(301, 80, 50, 50);
		pos6.setBounds(352, 80, 50, 50);

		pos7.setBounds(100, 131, 50, 50);
		pos8.setBounds(151, 131, 50, 50);
		pos9.setBounds(201, 131, 50, 50);
		pos10.setBounds(251, 131, 50, 50);
		pos11.setBounds(301, 131, 50, 50);
		pos12.setBounds(352, 131, 50, 50);

		pos13.setBounds(100, 181, 50, 50);
		pos14.setBounds(151, 181, 50, 50);
		pos15.setBounds(201, 181, 50, 50);
		pos16.setBounds(251, 181, 50, 50);
		pos17.setBounds(301, 181, 50, 50);
		pos18.setBounds(352, 181, 50, 50);

		pos19.setBounds(100, 232, 50, 50);
		pos20.setBounds(151, 232, 50, 50);
		pos21.setBounds(201, 232, 50, 50);
		pos22.setBounds(251, 232, 50, 50);
		pos23.setBounds(301, 232, 50, 50);
		pos24.setBounds(352, 232, 50, 50);

		pos25.setBounds(100, 283, 50, 50);
		pos26.setBounds(151, 283, 50, 50);
		pos27.setBounds(201, 283, 50, 50);
		pos28.setBounds(251, 283, 50, 50);
		pos29.setBounds(301, 283, 50, 50);
		pos30.setBounds(352, 283, 50, 50);
		
		pos31.setBounds(100, 334, 50, 50);
		pos32.setBounds(151, 334, 50, 50);
		pos33.setBounds(201, 334, 50, 50);
		pos34.setBounds(251, 334, 50, 50);
		pos35.setBounds(301, 334, 50, 50);
		pos36.setBounds(352, 334, 50, 50);
		
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.CYAN);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 50, 21);
		getContentPane().add(menuBar);
		
		mnMenu = new JMenu("Menu");
		mnMenu.setForeground(Color.CYAN);
		mnMenu.setBackground(Color.BLACK);
		menuBar.add(mnMenu);
		
		mntmReconnect = new JMenuItem("Reconnect");
		mntmReconnect.setForeground(Color.CYAN);
		mntmReconnect.setBackground(Color.BLACK);
		mnMenu.add(mntmReconnect);
		
		mntmDisconnect = new JMenuItem("Disconnect");
		mntmDisconnect.setForeground(Color.CYAN);
		mntmDisconnect.setBackground(Color.BLACK);
		mnMenu.add(mntmDisconnect);
		
		mntmRestart = new JMenuItem("Restart");
		mntmRestart.setForeground(Color.CYAN);
		mntmRestart.setBackground(Color.BLACK);
		mnMenu.add(mntmRestart);
		
		mntmReturn = new JMenuItem("Return");
		mntmReturn.setForeground(Color.CYAN);
		mntmReturn.setBackground(Color.BLACK);
		mnMenu.add(mntmReturn);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setForeground(Color.CYAN);
		mntmExit.setBackground(Color.BLACK);
		mnMenu.add(mntmExit);
		
		//setting initial(unknown) tiles
		Image iconLogo = new ImageIcon("FaustopOlympics/resources/Images/unknownTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(iconLogo);
		for(JButton button : getButtons()) {
			button.setIcon(imageIcon);
			pack();
			repaint();
		}
		
		
		

		
	}
	public List<JButton> getButtons() {
		List<JButton> buttons = new ArrayList<>();
		Component[] components = getContentPane().getComponents();
		for(Component comp : components) {
			if(comp instanceof JButton) {
				buttons.add((JButton) comp);
			}
		}
		return buttons;
		
	}
	public void tileFill(JButton button, TILETYPE type) {
		Image iconLogo = new ImageIcon().getImage();
		switch(type) {
		case QUESTION:
			iconLogo = new ImageIcon("FaustopOlympics/resources/Images/questionTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		case OBSTACLE:
			iconLogo = new ImageIcon("FaustopOlympics/resources/Images/questionTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		case BLANK:
			iconLogo = new ImageIcon("FaustopOlympics/resources/Images/questionTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		case PRIZE:
			iconLogo = new ImageIcon("FaustopOlympics/resources/Images/questionTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		case PRIZE_TRAP:
			iconLogo = new ImageIcon("FaustopOlympics/resources/Images/questionTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		case PRIZE_BONUS:
			iconLogo = new ImageIcon("FaustopOlympics/resources/Images/questionTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		case TRAPPED:
			iconLogo = new ImageIcon("FaustopOlympics/resources/Images/questionTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
				
		
		}
		ImageIcon imageIcon = new ImageIcon(iconLogo);
		button.setIcon(imageIcon);
		pack();
		repaint();
	}
	
	private void addAction() {
		Component[] components = getContentPane().getComponents();
		for (Component component : components) {
			if(component instanceof JButton)
				((JButton) component).addActionListener(l);
		}
	}
	public void informMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Aviso", JOptionPane.PLAIN_MESSAGE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
