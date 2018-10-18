package com.mini.khcinema.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mini.khcinema.controller.MemberController;
import com.mini.khcinema.model.Member;

public class One extends JPanel {

	public One(JPanel startPanel, JFrame mainF) {
		setBackground(new Color(255, 255, 255));

		setSize(894, 600);
		setLayout(null);

		ImageIcon ic = new ImageIcon("Images/cinema.png");
		Image ic1 = ic.getImage();

		Image changedlmg = ic1.getScaledInstance(800, 200, Image.SCALE_SMOOTH);
		ImageIcon icon5 = new ImageIcon(changedlmg);

		ArrayList<Member> members = new MemberController().GetMembers();
		Member member = null;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getId().equals(MemberController.loginID)) {
				member = members.get(i);
			}
		}

		JLabel lblNewLabel = new JLabel("이름: " + member.getName());
		lblNewLabel.setBounds(260, 57, 137, 29);
		add(lblNewLabel);

		JButton btnNewButton = new JButton("정보변경");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(165, 185, 137, 116);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startPanel.removeAll();
				startPanel.add(new EditPanel(startPanel, mainF));
				startPanel.revalidate();
				startPanel.repaint();

			}
		});
		add(btnNewButton);

		JLabel label = new JLabel("아이디: " + member.getId());
		label.setBounds(430, 57, 259, 29);
		add(label);

		JButton button = new JButton("예매확인 / 취소");
		button.setBackground(new Color(250, 240, 230));
		button.setBounds(331, 186, 137, 116);
		button.setBorderPainted(false);
		add(button);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startPanel.removeAll();
				startPanel.add(new ReservationCheck(startPanel, mainF));
				startPanel.revalidate();
				startPanel.repaint();

			}
		});

		JButton button_1 = new JButton("음식 확인 / 취소");
		button_1.setBackground(new Color(250, 240, 230));
		button_1.setBorderPainted(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		button_1.setBounds(510, 186, 137, 116);
		add(button_1);

		JLabel jl = new JLabel(icon5);
		jl.setSize(717, 189);
		jl.setLocation(24, 347);
		add(jl);
		
		setVisible(true);

	}
}
