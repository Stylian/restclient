package restclient;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientUI {

	private JPanel buttonsPanel;
	private JTextArea enteredURL;
	private JTextArea console;
	private JButton submitBtn;
	
	private JRadioButton getBtn;
	private JRadioButton postBtn;
	private JRadioButton putBtn;
	private JRadioButton deleteBtn;
	
	public static void main(String[] args) {
		ClientUI clientUI = new ClientUI();
		clientUI.initAndShowUI();
	}
	
	public void initAndShowUI() {
		Container container = createUIContainer();
		createWindow(container);
	}

	private Container createUIContainer() {
		Container container = new JPanel();

		createMethodButtonsPanel();
		createURLFields();
		createSubmitButton();
		createConsole();
		
		container.add(buttonsPanel);
		container.add(enteredURL);
		container.add(console);
		container.add(submitBtn);
		return container;
	}

	private void createWindow(Container container) {
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
		Dimension size = new Dimension(600, 80);
		enteredURL = new JTextArea();
		enteredURL.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		enteredURL.setWrapStyleWord(true);
		enteredURL.setLineWrap(true);
		enteredURL.setSize(size);
		enteredURL.setPreferredSize(size);
		enteredURL.setMaximumSize(size);;
	}
	

	private void createConsole() {
		Dimension size = new Dimension(700, 300);
		console = new JTextArea();
		console.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		console.setWrapStyleWord(true);
		console.setLineWrap(true);
		console.setSize(size);
		console.setPreferredSize(size);
		console.setMaximumSize(size);;
	}
	
	private void createSubmitButton() {
		submitBtn = new JButton("Send");
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Writer writer = new StringWriter();
				ServiceManager serv = new ServiceManager(writer);
				try {
					serv.send(enteredURL.getText(), getMethod());
					console.setText(writer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
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

