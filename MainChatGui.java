import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.*;
import java.awt.Label;
import java.awt.*;

public class MainChatGui extends JFrame {

	private JFrame frameChat;
	private JTextField textName;
	private JPanel panelMessage;
	private JTextPane textDisplayChat;
	private Label textState,labelReceive;
	private JButton buttonDisCon,buttonSend,buttonChoose;
	public boolean isStop=false, isSendFile = false, isReceiveFile = false;
	private JProgressBar progressSendFile;
	private JTextField textMessage;
	private JTextField textPath;
	private JScrollPane scrollPane;
	private JButton smileButton;
	private JButton cryingButton;
	private JButton lulButton;
	private JButton flirtButton;
	private JButton scaredButton;
	private JButton sadinconButton;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainChatGui frame = new MainChatGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainChatGui() {
		initialize();
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		
//		setContentPane(contentPane);
	}
	private void initialize() {
		frameChat = new JFrame();
		frameChat.setTitle("Private Chat");
		frameChat.setResizable(false);
		frameChat.setBounds(200,200,673,645);
		frameChat.getContentPane().setLayout(null);
		frameChat.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel labelClientIP = new JLabel("");
		
	}

}
