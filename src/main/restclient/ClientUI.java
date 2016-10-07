package main.restclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

public class ClientUI {

	private JPanel buttonsPanel;
	private JPanel enteredURLPanel;
	private JPanel consolePanel;
	private JPanel jsonDataPanel;
	private JTextArea enteredURL;
	private JTextArea jsonData;
	private JTextArea console;
	private JButton submitBtn;
	
	private JRadioButton getBtn;
	private JRadioButton postBtn;
	private JRadioButton putBtn;
	private JRadioButton deleteBtn;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ClientUI clientUI = new ClientUI();
				clientUI.initAndShowUI();
			}
		});
	}
	
	public void initAndShowUI() {
		Container container = createUIContainer();
		createWindow(container);
	}

	private Container createUIContainer() {

		createMethodButtonsPanel();
		createURLFields();
		createSubmitButton();
		createConsole();
		
		JPanel inputFieldsPanel = new JPanel();
		inputFieldsPanel.setLayout(new BoxLayout(inputFieldsPanel, BoxLayout.Y_AXIS));
		inputFieldsPanel.add(enteredURLPanel);
		inputFieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		inputFieldsPanel.add(jsonDataPanel);

		JPanel upperCont1 = new JPanel();
		upperCont1.add(buttonsPanel);
		upperCont1.add(inputFieldsPanel);
		upperCont1.add(submitBtn);
		
		Container container = new JPanel();
		container.add(upperCont1);
		container.add(consolePanel);
		
		return container;
	}

	private void createWindow(Container container) {
		Dimension size = new Dimension(768, 680);
		
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
	
	private void createMethodButtonsPanel() {
		buttonsPanel = new JPanel();
		buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		buttonsPanel.setLayout(new GridLayout(4, 1));
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		getBtn = new JRadioButton("GET");
		btnGroup.add(getBtn);
		buttonsPanel.add(getBtn);
		
		postBtn = new JRadioButton("POST");
		btnGroup.add(postBtn);
		buttonsPanel.add(postBtn);
		
		putBtn = new JRadioButton("PUT");
		btnGroup.add(putBtn);
		buttonsPanel.add(putBtn);
		
		deleteBtn = new JRadioButton("DELETE");
		btnGroup.add(deleteBtn);
		buttonsPanel.add(deleteBtn);
	}
	
	private void createURLFields() {
		Dimension size = new Dimension(600, 40);
		enteredURL = new JTextArea("http://jsonplaceholder.typicode.com/posts/1");
		enteredURL.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		enteredURL.setWrapStyleWord(true);
		enteredURL.setLineWrap(true);
		enteredURL.setSize(size);
		enteredURL.setPreferredSize(size);
		enteredURL.setMaximumSize(size);
		
		enteredURLPanel = new JPanel();
		enteredURLPanel.setLayout(new BorderLayout());
		enteredURLPanel.add(new JLabel("url"), BorderLayout.NORTH);
		enteredURLPanel.add(enteredURL, BorderLayout.SOUTH);
		
		jsonData = new JTextArea("{ \"id\": \"1\", \"title\": \"foo2\", \"body\": \"bar\", \"userId\": \"1\" }");
		jsonData.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jsonData.setWrapStyleWord(true);
		jsonData.setLineWrap(true);
		jsonData.setSize(size);
		jsonData.setPreferredSize(size);
		jsonData.setMaximumSize(size);
		
		jsonDataPanel = new JPanel();
		jsonDataPanel.setLayout(new BorderLayout());
		jsonDataPanel.add(new JLabel("json data"), BorderLayout.NORTH);
		jsonDataPanel.add(jsonData, BorderLayout.SOUTH);
		
	}
	

	private void createConsole() {
		Dimension size = new Dimension(740, 460);
		console = new JTextArea();
		DefaultCaret caret = (DefaultCaret)console.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		console.setWrapStyleWord(true);
		console.setLineWrap(true);
		console.setSize(size);
		console.setPreferredSize(size);
		console.setMaximumSize(size);
		
		consolePanel = new JPanel();
		consolePanel.setLayout(new BorderLayout());
		consolePanel.add(new JLabel("output"), BorderLayout.NORTH);
		consolePanel.add(console, BorderLayout.SOUTH);
	}
	
	private void createSubmitButton() {
		submitBtn = new JButton("Send");
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ServiceManager serv = new ServiceManager();
				try {
					serv.send(enteredURL.getText(), getMethod(), jsonData.getText(), null);
					
					StringBuilder sb = new StringBuilder();
					sb.append("\n Status Code: " + serv.getMetadata().getStatusCode());
					sb.append("\n Response: \n" + serv.getMetadata().getResponse());
					console.setText(sb.toString());
				} catch (IOException e1) {
					console.append("url does not seem correct\n");
				} catch (Exception e1) {
					console.append("you have not selected a method!\n");
				}
			}
		});		
	}
	
	private Method getMethod() throws Exception {

		if(getBtn.isSelected()) {
			return Method.GET;
		}
		if(postBtn.isSelected()) {
			return Method.POST;
		}
		if(putBtn.isSelected()) {
			return Method.PUT;
		}
		if(deleteBtn.isSelected()) {
			return Method.DELETE;
		}
		
		throw new Exception("no method button has been selected!");
	}
	
}

