package br.ufsc.FasutopOlympics.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufsc.FasutopOlympics.actors.PlayerActor;
import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.FasutopOlympics.model.TILETYPE;
import br.ufsc.FasutopOlympics.model.Tile;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.Color;
import javax.swing.JMenu;
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
	private JPanel contentPane;
	public JButton[] butts;
	
	private boolean trapmode = false;
	/**
	 * Launch the application.
	 */
	
	//where the stuff is done.
	private ActionListener l = new ActionListener() {
		public void actionPerformed(final ActionEvent e) {

		}
	};
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmReconnect;
	private JMenuItem mntmDisconnect;
	private JMenuItem mntmRestart;
	private JMenuItem mntmReturn;
	private JLabel lblPlayer;
	private JLabel lblPoints;

	/**
	 * Create the frame.
	 */
	public void trapmode() {
		trapmode = true;
	}
	public GameScreen(Player localPlayer) {
		
		setPreferredSize(new Dimension(550, 550));
		getContentPane().setBackground(Color.DARK_GRAY);
		addAction();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		lblPlayer = new JLabel("Player  -  " + localPlayer.getName());
		lblPlayer.setForeground(Color.GREEN);
		lblPlayer.setBounds(114, 33, 165, 25);
		getContentPane().add(lblPlayer);
		
		lblPoints = new JLabel("Score  -  " + localPlayer.getScore());
		lblPoints.setForeground(Color.GREEN);
		lblPoints.setBounds(302, 33, 100, 25);
		getContentPane().add(lblPoints);
		
		pos1 = new JButton();
		pos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos1, 0, 0);
			}
		});
		pos2 = new JButton();
		pos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos2, 0, 1);
			}
		});
		pos3 = new JButton();
		pos3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos3, 0, 2);
			}
		});
		pos4 = new JButton();
		pos4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos4, 0, 3);
			}
		});
		pos5 = new JButton();
		pos5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos5, 0, 4);
			}
		});
		pos6 = new JButton();
		pos6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos6, 0, 5);
			}
		});
		pos7 = new JButton();
		pos7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos7, 1, 0);
			}
		});
		pos8 = new JButton();
		pos8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos8, 1, 1);
			}
		});
		pos9 = new JButton();
		pos9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos9, 1, 2);
			}
		});
		pos10 = new JButton();
		pos10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos10, 1, 3);
			}
		});
		pos11 = new JButton();
		pos11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos11, 1, 4);
			}
		});
		pos12 = new JButton();
		pos12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos12, 2, 5);
			}
		});
		pos13 = new JButton();
		pos13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos13, 2, 0);
			}
		});
		pos14 = new JButton();
		pos14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos14, 2, 1);
			}
		});
		pos15 = new JButton();
		pos15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos15, 2, 2);
			}
		});
		pos16 = new JButton();
		pos16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos16, 2, 3);
			}
		});
		pos17 = new JButton();
		pos17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos17, 2, 4);
			}
		});
		pos18 = new JButton();
		pos18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos18, 2, 5);
			}
		});
		pos19 = new JButton();
		pos19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos19, 3, 0);
			}
		});
		pos20 = new JButton();
		pos20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos20, 3, 1);
			}
		});
		pos21 = new JButton();
		pos21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos21, 3, 2);
			}
		});
		pos22 = new JButton();
		pos22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos22, 3, 3);
			}
		});
		pos23 = new JButton();
		pos23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos23, 3, 4);
			}
		});
		pos24 = new JButton();
		pos24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos24, 3, 5);
			}
		});
		pos25 = new JButton();
		pos25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos25, 4, 0);
			}
		});
		pos26 = new JButton();
		pos26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos26, 4, 1);
			}
		});
		pos27 = new JButton();
		pos27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos27, 4, 2);
			}
		});
		pos28 = new JButton();
		pos28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos28, 4, 3);
			}
		});
		pos29 = new JButton();
		pos29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos29, 4, 4);
			}
		});
		pos30 = new JButton();
		pos30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos30, 4, 5);
			}
		});
		pos31 = new JButton();
		pos31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos31, 5, 0);
			}
		});
		pos32 = new JButton();
		pos32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos32, 5, 1);
			}
		});
		pos33 = new JButton();
		pos33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos33, 5, 2);
			}
		});
		pos34 = new JButton();
		pos34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos34, 5, 3);
			}
		});
		pos35 = new JButton();
		pos35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos35, 5, 4);
			}
		});
		pos36 = new JButton();
		pos36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(pos36, 5, 5);
			}
		});
		
		getContentPane().add(pos1);getContentPane().add(pos2);getContentPane().add(pos3);getContentPane().add(pos4);getContentPane().add(pos5);getContentPane().add(pos6);getContentPane().add(pos7);getContentPane().add(pos8);getContentPane().add(pos9);
		getContentPane().add(pos10);getContentPane().add(pos11);getContentPane().add(pos12);getContentPane().add(pos13);getContentPane().add(pos14);getContentPane().add(pos15);getContentPane().add(pos16);getContentPane().add(pos17);
		getContentPane().add(pos18);getContentPane().add(pos19);getContentPane().add(pos20);getContentPane().add(pos21);getContentPane().add(pos22);getContentPane().add(pos23);getContentPane().add(pos24);getContentPane().add(pos25);
		getContentPane().add(pos26);getContentPane().add(pos27);getContentPane().add(pos28);getContentPane().add(pos29);getContentPane().add(pos30);getContentPane().add(pos31);getContentPane().add(pos32);getContentPane().add(pos33);
		getContentPane().add(pos34);getContentPane().add(pos35);getContentPane().add(pos36);
		
		butts = new JButton[] {pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8,pos9,pos10,pos11,pos12,pos13,pos14,pos15,pos16,pos17,pos18,pos19,pos20,pos21,pos22,pos23,pos24,pos25,pos26,pos27,pos28,pos29,pos30,pos31,pos32,pos33,pos34,pos35,pos36};
		
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
		
	
		
		mntmRestart = new JMenuItem("Restart");
		mntmRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(1 != JOptionPane.showConfirmDialog(getContentPane(), "Are you sure?")) {
					PlayerActor.getInstance().restart();
					setVisible(false);
				}
			}
		});
		mntmRestart.setForeground(Color.CYAN);
		mntmRestart.setBackground(Color.BLACK);
		mnMenu.add(mntmRestart);
		
		mntmReturn = new JMenuItem("Main Menu");
		mntmReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(1 != JOptionPane.showConfirmDialog(getContentPane(), "Are you sure?")) {
					try {
						PlayerActor.getInstance().disconnect();
						setVisible(false);
						PlayerActor.getInstance().showMainMenu();
					} catch (NaoConectadoException e1) {
						
					}
				}
			}
		});
		mntmReturn.setForeground(Color.CYAN);
		mntmReturn.setBackground(Color.BLACK);
		mnMenu.add(mntmReturn);
		
		//setting initial(unknown) tiles
		Image iconLogo = new ImageIcon("resources/Images/unknownTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(iconLogo);
		for(JButton button : butts) {
			button.setIcon(imageIcon);
			pack();
			repaint();
		}
		playerTileFill(pos1);
		updateLabels(PlayerActor.getInstance().getLocalPlayer());
		


	}
	protected void buttonAction(JButton bt, int i, int j) {
		Player localp = PlayerActor.getInstance().getLocalPlayer();
		Tile[][] tiles = PlayerActor.getInstance().getTiles();
		int playerx = localp.getX();
		int playery = localp.getY();
		if (!trapmode) {
			if(PlayerActor.getInstance().winCheck() == null) {
				if(!PlayerActor.getInstance().sendMove(i,j)) {
					informMessage("Could not move to selected Tile!");
							
					}else {
						playerTileFill(bt);
						tileFill(butts[matrixToLine(playerx, playery)], tiles[playery][playerx].getTileType()) ;
						updateLabels(localp);
						repaint();
						
					}
			}else {
				informMessage(PlayerActor.getInstance().winCheck());
				PlayerActor.getInstance().prepareMatch();
			}
		}else {
			tiles[j][i].setTrapped(true);
			tileFill(bt, TILETYPE.TRAPPED);
		}
		
	}
	public void updateLabels(Player player) {
		lblPlayer.setText("Player  -  "+player.getName() + "  Position: "+ player.getX() + ", "+player.getY());
		lblPoints.setText("Score  -  "+player.getScore());
	}
	protected void playerTileFill(JButton jButton) {
		Image iconLogo = new ImageIcon("resources/Images/playerTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(iconLogo);
		jButton.setIcon(imageIcon);
		pack();
		repaint();
		
	}
	public int[] lineToMatrix(int l) {
		int r = 0;
		while(l > 6) {
			l -= 6;
			r++;
		}
		int[] pos = {l, r};
		return pos;
	}
	public int matrixToLine(int l, int r) {
		return l + (r*6);
	}
	
	public void tileFill(JButton button, TILETYPE type) {
		Image iconLogo = new ImageIcon().getImage();
		switch(type) {
		case QUESTION:
			iconLogo = new ImageIcon("resources/Images/questionTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		case OBSTACLE:
			iconLogo = new ImageIcon("resources/Images/obstacleTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		case TRAPPED:
			iconLogo = new ImageIcon("resources/Images/trappedTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
			break;
		default:
			iconLogo = new ImageIcon("resources/Images/blankTile.png").getImage().getScaledInstance(pos1.getWidth(), pos1.getHeight(), Image.SCALE_SMOOTH);
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
	public JButton getButtonByPosition(int playerx, int playery) {
		// TODO Auto-generated method stub
		return butts[matrixToLine(playerx, playery)];
	}
}
