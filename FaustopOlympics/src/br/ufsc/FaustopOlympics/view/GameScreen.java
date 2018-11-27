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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameScreen frame = new GameScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
						
					}
					
					tileFill(btList.get(i), Map.getInstance().getTiles()[j][k].getTileType());
					repaint();
				}
			}
				
			repaint();
		}
	};

	/**
	 * Create the frame.
	 */
	public GameScreen() {
		addAction();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(677, 570));
		getContentPane().setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(0, 0, 65, 25);
		getContentPane().add(btnMenu);
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(90, 0, 165, 25);
		getContentPane().add(lblPlayer);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(278, 0, 100, 25);
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
		
		int l1 = 135;
		int l2 = 175;
		int l3 = 215;
		int l4 = 255;
		int l5 = 295;
		int l6 = 335;
		int r1 = 90;
		int r2 = 130;
		int r3 = 170;
		int r4 = 210;
		int r5 = 250;
		int r6 = 290;
		
		pos1.setBounds(l1, r1, 40, 40);
		pos2.setBounds(l2, r1, 40, 40);
		pos3.setBounds(l3, r1, 40, 40);
		pos4.setBounds(l4, r1, 40, 40);
		pos5.setBounds(l5, r1, 40, 40);
		pos6.setBounds(l6, r1, 40, 40);

		pos7.setBounds(l1, r2, 40, 40);
		pos8.setBounds(l2, r2, 40, 40);
		pos9.setBounds(l3, r2, 40, 40);
		pos10.setBounds(l4, r2, 40, 40);
		pos11.setBounds(l5, r2, 40, 40);
		pos12.setBounds(l6, r2, 40, 40);

		pos13.setBounds(l1, r3, 40, 40);
		pos14.setBounds(l2, r3, 40, 40);
		pos15.setBounds(l3, r3, 40, 40);
		pos16.setBounds(l4, r3, 40, 40);
		pos17.setBounds(l5, r3, 40, 40);
		pos18.setBounds(l6, r3, 40, 40);

		pos19.setBounds(l1, r4, 40, 40);
		pos20.setBounds(l2, r4, 40, 40);
		pos21.setBounds(l3, r4, 40, 40);
		pos22.setBounds(l4, r4, 40, 40);
		pos23.setBounds(l5, r4, 40, 40);
		pos24.setBounds(l6, r4, 40, 40);

		pos25.setBounds(l1, r5, 40, 40);
		pos26.setBounds(l2, r5, 40, 40);
		pos27.setBounds(l3, r5, 40, 40);
		pos28.setBounds(l4, r5, 40, 40);
		pos29.setBounds(l5, r5, 40, 40);
		pos30.setBounds(l6, r5, 40, 40);
		
		pos31.setBounds(l1, r6, 40, 40);
		pos32.setBounds(l2, r6, 40, 40);
		pos33.setBounds(l3, r6, 40, 40);
		pos34.setBounds(l4, r6, 40, 40);
		pos35.setBounds(l5, r6, 40, 40);
		pos36.setBounds(l6, r6, 40, 40);
		
		for(JButton bt : getButtons()) {
			Image iconLogo = new ImageIcon("FaustopOlympics/resources/Images/unknownTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(iconLogo);
			bt.setIcon(imageIcon);
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

}
