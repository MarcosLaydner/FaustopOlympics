package br.ufsc.FasutopOlympics.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufsc.FasutopOlympics.actors.PlayerActor;
import br.ufsc.FasutopOlympics.control.Map;
import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.FasutopOlympics.model.Question;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class QuestionScreen extends JFrame {

	private JPanel contentPane;
	private String selec = "empty";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean passed = false;
	private Player player;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public QuestionScreen(Question question, Player currentPlayer) {
		player = currentPlayer;
		String opt1 = question.getOpt1();
		String opt2 = question.getOpt2();
		String opt3 = question.getOpt3();
		String opt4 = question.getOpt4();
		String ans = question.getRightopt();
		String quest = question.getQuestion();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuestionTime = new JLabel("Question Time!!!!");
		lblQuestionTime.setForeground(Color.ORANGE);
		lblQuestionTime.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblQuestionTime.setBounds(117, 11, 199, 38);
		contentPane.add(lblQuestionTime);
		
		JLabel lblQuestion = new JLabel(quest);
		lblQuestion.setForeground(Color.GREEN);
		lblQuestion.setBounds(43, 71, 2000, 42);
		contentPane.add(lblQuestion);
		
		JRadioButton rdbtnOption = new JRadioButton(opt1);
		buttonGroup.add(rdbtnOption);
		rdbtnOption.setForeground(Color.CYAN);
		rdbtnOption.setBackground(Color.BLACK);
		rdbtnOption.setBounds(43, 108, 162, 23);
		contentPane.add(rdbtnOption);
		
		JRadioButton rdbtnOption_1 = new JRadioButton(opt2);
		buttonGroup.add(rdbtnOption_1);
		rdbtnOption_1.setForeground(Color.CYAN);
		rdbtnOption_1.setBackground(Color.BLACK);
		rdbtnOption_1.setBounds(225, 108, 162, 23);
		contentPane.add(rdbtnOption_1);
		
		JRadioButton rdbtnOption_2 = new JRadioButton(opt3);
		buttonGroup.add(rdbtnOption_2);
		rdbtnOption_2.setForeground(Color.CYAN);
		rdbtnOption_2.setBackground(Color.BLACK);
		rdbtnOption_2.setBounds(43, 175, 162, 23);
		contentPane.add(rdbtnOption_2);
		
		JRadioButton rdbtnOption_3 = new JRadioButton(opt4);
		buttonGroup.add(rdbtnOption_3);
		rdbtnOption_3.setForeground(Color.CYAN);
		rdbtnOption_3.setBackground(Color.BLACK);
		rdbtnOption_3.setBounds(225, 175, 162, 23);
		contentPane.add(rdbtnOption_3);
		
		JButton btnConfirm = new JButton("Confirm");
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnOption.isSelected()) {
					selec = rdbtnOption.getText();
				}else if(rdbtnOption_1.isSelected()) {
					selec = rdbtnOption_1.getText();
				}else if(rdbtnOption_2.isSelected()) {
					selec = rdbtnOption_2.getText();
				}else {
					selec = rdbtnOption_3.getText();
				}
				if(!selec.equals("empty")) {
					if(selec.equals(ans)) {
						if(!passed) {
							PlayerActor.getInstance().getOtherPlayer().addPoints(100);
						}else {
							PlayerActor.getInstance().getCurrentPlayer().addPoints(100);
						}
						informMessage("Correct! You got 100 Points!");
						setVisible(false);
						
					}else {
						informMessage("Errrooool!");
						setVisible(false);
					}
				}else {
					informMessage("Please select an option!");
				}
				
				
			}
		});
		btnConfirm.setForeground(Color.GREEN);
		btnConfirm.setBackground(Color.BLACK);
		btnConfirm.setBounds(116, 227, 89, 23);
		contentPane.add(btnConfirm);
		
		
		JButton btnPass = new JButton("Pass");
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(0 == JOptionPane.showConfirmDialog(getContentPane(), "Are you Sure?", "Passar", JOptionPane.YES_NO_OPTION)) {
					if(!passed) {
						JOptionPane.showMessageDialog(null, ""+PlayerActor.getInstance().getCurrentPlayer().getName() +"! It's your turn now!", "Passed", JOptionPane.WARNING_MESSAGE);
						passed = true;
					}else {
						JOptionPane.showMessageDialog(null, "Y'all are quitters!", "Passed", JOptionPane.WARNING_MESSAGE);
						setVisible(false);
					}
					
				}
			}
		});
		btnPass.setBackground(Color.RED);
		btnPass.setBounds(227, 227, 89, 23);
		contentPane.add(btnPass);
	}
	public void informMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Aviso", JOptionPane.PLAIN_MESSAGE);
	}
}
