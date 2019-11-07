import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class requestForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					requestForm frame = new requestForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public requestForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel mainLabel = new JLabel("Friend Request");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setBounds(6, 6, 438, 16);
//		mainLabel.setFont(new Font());
		contentPane.add(mainLabel);
		
		JList list = new JList();// cai list yeu cau ket ban
		
		list.setBounds(16, 34, 415, 194);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String value = (String)list.getModel().getElementAt(list.locationToIndex(e.getPoint()));
				textNameFriend.setText(value);
			}
		});
		JScrollPane scroller4List = new JScrollPane(list);
		scroller4List.setBounds(16,34,415,194);
		contentPane.add(scroller4List);
		
		
		JButton accept = new JButton("accept");
		accept.addMouseListener(new MouseAdapter() { // chap nhan ket ban thi them ban vao list friend
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		accept.setBounds(200, 240, 117, 29);
		accept.setEnabled(false);
		contentPane.add(accept);
		
		JButton decline = new JButton("decline");
		decline.addMouseListener(new MouseAdapter() {// khong dong y thi nhan nut nay de huy loi moi ket ban
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		decline.setBounds(314, 240, 117, 29);
		decline.setEnabled(false);
		contentPane.add(decline);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				accept.setEnabled(true);
				decline.setEnabled(true);
			}
			
		});
	}
}
