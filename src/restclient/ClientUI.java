package restclient;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientUI {

	public static void main(String[] args) {
		ClientUI clientUI = new ClientUI();
		clientUI.initAndShowUI();
	}
	
	public void initAndShowUI() {
		
		Container container = new JPanel();

		container.add(createMethodButtons());
		container.add(createURLField());
		container.add(createSubmitButton());
		container.add(createConsole());
		
		Dimension size = new Dimension(768, 480);
		
		JFrame frame = new JFrame();
		frame.setTitle("Rest Client");
		frame.setContentPane(container);
		frame.setMinimumSize(size);
		frame.setMaximumSize(size);
		frame.setPreferredSize(size);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private JTextArea createConsole() {
		Dimension size = new Dimension(700, 300);
		JTextArea console = new JTextArea();
		console.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		console.setWrapStyleWord(true);
		console.setLineWrap(true);
		console.setSize(size);
		console.setPreferredSize(size);
		console.setMaximumSize(size);;
		return console;
	}
	
	private JButton createSubmitButton() {
		JButton submitBtn = new JButton("Send");
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return submitBtn;
	}

	private JTextArea createURLField() {
		Dimension size = new Dimension(600, 80);
		JTextArea textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setSize(size);
		textArea.setPreferredSize(size);
		textArea.setMaximumSize(size);;
		return textArea;
	}

	private JPanel createMethodButtons() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		buttonsPanel.setLayout(new GridLayout(4, 1));
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		JRadioButton getBtn = new JRadioButton("GET");
		btnGroup.add(getBtn);
		buttonsPanel.add(getBtn);

		JRadioButton postBtn = new JRadioButton("POST");
		btnGroup.add(postBtn);
		buttonsPanel.add(postBtn);

		JRadioButton putBtn = new JRadioButton("PUT");
		btnGroup.add(putBtn);
		buttonsPanel.add(putBtn);
		
		JRadioButton deleteBtn = new JRadioButton("DELETE");
		btnGroup.add(deleteBtn);
		buttonsPanel.add(deleteBtn);
		
		return buttonsPanel;
	}
	
}
