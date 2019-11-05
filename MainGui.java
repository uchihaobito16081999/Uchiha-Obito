import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.font.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.awt.color.*;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainGui extends JFrame {

	private static String IPClient = "", userName = "" , userData = "";
	private static int portClient = 0;
	private JFrame frameMain;
	private JLabel labelActiveNow;
	private static JList<String> listActive;
	private JPanel contentPane;
	private JTextField textField_1;
	private JButton sendMessageButton;
	private JTextArea textArea;
	private JTextArea textArea_userInput;
	private JScrollBar scrollBar;
	private JButton sendFileButton;
	private JButton sendPictureButton;
	private JScrollPane scroll_bar;
//	private final Action action = new SwingAction();
	private String content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGui(String arg, int arg1, String name, String msg) throws Exception {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		IPClient = arg;
		portClient = arg1;
		userName = name;
		userData = msg;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
				);
	}
	public MainGui() throws Exception {
		initialize();
	}
	private void initialize() throws IOException {
		frameMain = new JFrame();
		frameMain.setTitle("CHAT WINDOW");
		frameMain.setResizable(false);
		frameMain.setBounds(100,100,700,560);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		labelActiveNow = new JLabel("Online Friend");
		labelActiveNow.setHorizontalAlignment(SwingConstants.CENTER);
		labelActiveNow.setBounds(16, 6, 156, 16);
		labelActiveNow.setForeground(new Color(100,149,237));
		labelActiveNow.setFont(new Font("Segoe UI", Font.PLAIN,13));
		frameMain.getContentPane().add(labelActiveNow);
		
		listActive = new JList<>();
		listActive.setBounds(16, 30, 156, 502);
		listActive.setFont(new Font("Segoe UI",Font.PLAIN,15));
//		listActive.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg) {
//				String value = (String)listActive.getModel().getElementAt(listActive.locationToIndex(arg.getPoint()));
//			textNameFriend.setText(value);
//			}
//		});
		JScrollPane scr = new JScrollPane(listActive);
		scr.setBounds(16,30,156,502);
		
		frameMain.getContentPane().add(scr);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(192, 6, 74, 16);
		lblUserName.setForeground(new Color(0, 191, 255));
		frameMain.getContentPane().add(lblUserName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(273, 1, 178, 26);
		frameMain.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.setBounds(455, 1, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frameMain.getContentPane().add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Disconnect");
		btnNewButton_1.setBounds(564, 1, 117, 29);
		frameMain.getContentPane().add(btnNewButton_1);
		
		sendMessageButton = new JButton();//send message
		sendMessageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				content ="You : " + textArea_userInput.getText() + "\n";
				textArea.append((content ));
				textArea_userInput.setText("");
			}
		});
		
		sendMessageButton.setBounds(586, 436, 96, 96);
		sendMessageButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		sendMessageButton.setBackground(new Color(253, 245, 230));
		ImageIcon imgIcon_1 = new ImageIcon(new ImageIcon("2.jpg").getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH));
		sendMessageButton.setIcon(imgIcon_1);
		sendMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frameMain.getContentPane().add(sendMessageButton);
		
		textArea = new JTextArea();
		
		
		
		textArea.setEditable(false);
		textArea.setBounds(192, 121, 379, 303);
		textArea.setLineWrap(true);
//		frameMain.getContentPane().add(textArea);
		scroll_bar= new JScrollPane(textArea);
		scroll_bar.setBounds(192,121,379,303);
		frameMain.getContentPane().add(scroll_bar);
				
		
		//frameMain.getContentPane().add(scrollBar);
		
		sendFileButton = new JButton("send file");
		sendFileButton.setBounds(184, 50, 82, 59);
		sendFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textArea_userInput = new JTextArea();
		textArea_userInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					content ="You :"  + textArea_userInput.getText();
					textArea.append((content   ));
					textArea_userInput.setText("");
			}
			}
		});
		
		textArea_userInput.setBounds(192, 436, 380, 93);
		textArea_userInput.setLineWrap(true);
//		frameMain.getContentPane().add(textArea_1);
		JScrollPane sp = new JScrollPane(textArea_userInput);
		sp.setBounds(192,436,380,93);
		
		frameMain.getContentPane().add(sp);
		
//		
		
		
		
		
		
		sendPictureButton = new JButton();//send picture
		sendPictureButton.setBounds(485, 49, 60, 60);
		ImageIcon img = new ImageIcon(new ImageIcon("images.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		sendPictureButton.setIcon(img);
		sendPictureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frameMain.getContentPane().add(sendPictureButton);
		
		
		
		ImageIcon imgIcon = new ImageIcon(new ImageIcon("user.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		JLabel user_Avatar = new JLabel("New label");
		user_Avatar.setBounds(605, 56, 80, 80);
		user_Avatar.setIcon(imgIcon);
		frameMain.getContentPane().add(user_Avatar);
		
		JButton sendFilebutton = new JButton();
		JFileChooser fc = new JFileChooser();
		
		sendFilebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		
		
		ImageIcon imgicon = new ImageIcon(new ImageIcon("3.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		sendFilebutton.setIcon(imgicon);
		sendFilebutton.setBounds(203, 49, 60, 60);
		frameMain.getContentPane().add(sendFilebutton);
		
	}
}
