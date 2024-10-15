import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JScrollPane;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField username_signup;
	private JTextField email_signup;
	private JPasswordField confirm_signup;
	private JPasswordField password_signup;
	private JTextField id_login;
	private JPasswordField password_login;
	private JLayeredPane background_layer;
	private JPanel Signup;
	private JPanel Login;
	private JPanel home_dashboard;
	private JPanel returns_dashboard;
	private JPanel rent_dashboard;
	private JPanel sell_dashboard;
	private JPanel buy_dashboard;
	String Session_username , Session_password, Session_email;
	String Session_carname , Session_price, Session_description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * 
	 * connection to database
	 * 
	 */
	PreparedStatement pst;
	Connection con;
	ResultSet rs;
	private JPanel Dashboard;
	private JLabel brand1;
	
	public int Connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service","root","laptop");
			System.out.println("Connected With the database successfully \n"+con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error while connecting to the database");
			return 1;
		}
		return 0;
}
	
	/*
	 * Inserting users data
	 * 
	 */
	public int user_Data_Entry( String username ,String email ,String password_string) {
		
		try {
			pst = con.prepareStatement("insert into users(username,email,password)values(?,?,?)");
			pst.setString(1, username);
			pst.setString(2, email);
			pst.setString(3, password_string);
			pst.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return 1;
		}
		
		
		return 0;
	}
/*
 * 
 * email login
 */
public int email_Login(String id_string_login,String password_login_string) {
		
		try {
	          
 
                pst = con.prepareStatement("select username,email,password from users where email = ?");
                pst.setString(1, id_string_login);
                ResultSet rs = pst.executeQuery();
 
            if(rs.next()==true)
            {
              
                Session_username = rs.getString(1);
                Session_email = rs.getString(2);
                Session_password = rs.getString(3);
                
               
                id_login.setText("");
				password_login.setText("");
				id_login.requestFocusInWindow();
                
            }  
            
            return 0;
 
        }
catch (SQLException e) {

          return 1;
        }
		
	}
/*
 * 
 * Username login
 * 
 */


public void details_set() {
	String car_id = "1";
	try {
        
		 
        pst = con.prepareStatement("select name,price,description from cars where id = ?");
        pst.setString(1, car_id);
        ResultSet rs = pst.executeQuery();

    if(rs.next()==true)
    {
      
        Session_carname = rs.getString(1);
        Session_price = rs.getString(2);
        Session_description = rs.getString(3);
        
       
        brand1.setText(Session_carname);
		;
		
        
    }  
    

}
catch (SQLException ex) {
 
}

	
}
	public int username_Login(String id_string_login,String password_login_string) {
		
		try {
	          
 
                pst = con.prepareStatement("select username,email,password from users where username = ?");
                pst.setString(1, id_string_login);
                ResultSet rs = pst.executeQuery();
 
            if(rs.next()==true)
            {
              
                Session_username = rs.getString(1);
                Session_email = rs.getString(2);
                Session_password = rs.getString(3);
                
               
                id_login.setText("");
				password_login.setText("");
				id_login.requestFocusInWindow();
				
                
            }  
            
 
            return 0;
        }
catch (SQLException ex) {
          return 1;
        }
		
	}
	/**
	 * Create the frame.
	 */
	
	
	public void switchBackgroundPanels(JPanel panel) {
		background_layer.removeAll();
		background_layer.add(panel);
		background_layer.repaint();
		background_layer.revalidate();
		
	}
	public Home() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		background_layer = new JLayeredPane();
		background_layer.setBounds(0, 0, 713, 412);
		contentPane.add(background_layer);
		background_layer.setLayout(new CardLayout(0, 0));
		
		
		Signup = new JPanel();
		Signup.setLayout(null);
		Signup.setBackground(Color.WHITE);
		background_layer.add(Signup, "name_991252688956800");
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(0, 0, 377, 490);
		Signup.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("PEPEA CAR SERVICE");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(66, 11, 283, 53);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pelton EA");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(136, 320, 125, 14);
		panel_5.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("...Innovating change...");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(124, 370, 161, 14);
		panel_5.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Home.class.getResource("/images/wallhaven-dpl3x3_377x409.png")));
		lblNewLabel_2_1.setBounds(0, 0, 377, 408);
		panel_5.add(lblNewLabel_2_1);
		
		Button button = new Button("Sign Up");
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				String username , email ,password_string,confirm_string;
				char []password;
				char []confirm;
				username = username_signup.getText().toLowerCase();
				email = email_signup.getText().toLowerCase();
				password = password_signup.getPassword();
				confirm = confirm_signup.getPassword();
				password_string= new String(password);
				confirm_string = new String(confirm);
				
				
				if(username.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter a Username");
				}
				if(email.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter an Email Address");
				}
				if(password_string.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter your Password");
				}
				if(confirm_string.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Confirm your Password");
				}
				else {
					if(password_string.equals(confirm_string)) {
						int connection_result= Connect();
							if(connection_result == 0) {
								int entry_result = user_Data_Entry( username , email , password_string);
								
								if(entry_result==0) {
									JOptionPane.showMessageDialog(null, "Registration successful");
									
									username_signup.setText("");
									email_signup.setText("");
									password_signup.setText("");
									confirm_signup.setText("");
									username_signup.requestFocusInWindow();
									switchBackgroundPanels(Login);
									
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Server Error please retry later");
								username_signup.setText("");
								email_signup.setText("");
								password_signup.setText("");
								confirm_signup.setText("");
								username_signup.requestFocusInWindow();
							}
						
					}else {
						JOptionPane.showMessageDialog(null, "Passwords do not match, Please retype.");
					}
				}
				
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(429, 349, 251, 35);
		Signup.add(button);
		
		username_signup = new JTextField();
		username_signup.setColumns(10);
		username_signup.setBounds(429, 64, 251, 29);
		Signup.add(username_signup);
		
		JLabel lblNewLabel_6 = new JLabel("EMAIL");
		lblNewLabel_6.setBounds(429, 119, 63, 14);
		Signup.add(lblNewLabel_6);
		
		email_signup = new JTextField();
		email_signup.setColumns(10);
		email_signup.setBounds(429, 136, 251, 29);
		Signup.add(email_signup);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("PASSWORD");
		lblNewLabel_1_1_5.setBounds(429, 176, 94, 14);
		Signup.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_1_2_5.setBounds(429, 246, 152, 14);
		Signup.add(lblNewLabel_1_2_5);
		
		confirm_signup = new JPasswordField();
		confirm_signup.setBounds(429, 271, 251, 29);
		Signup.add(confirm_signup);
		
		password_signup = new JPasswordField();
		password_signup.setBounds(429, 201, 251, 29);
		Signup.add(password_signup);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_close.setBackground(new Color(241, 57, 83));
		lbl_close.setBounds(680, 0, 33, 29);
		Signup.add(lbl_close);
		
		JLabel lblNewLabel = new JLabel("Already have an account?");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchBackgroundPanels(Login);
			}
		});
		lblNewLabel.setForeground(new Color(241, 57, 83));
		lblNewLabel.setBounds(548, 321, 165, 14);
		Signup.add(lblNewLabel);
		
		JLabel lblNewLabel_6_1 = new JLabel("USERNAME");
		lblNewLabel_6_1.setBounds(429, 43, 94, 14);
		Signup.add(lblNewLabel_6_1);
		
		Login = new JPanel();
		Login.setLayout(null);
		Login.setBackground(Color.WHITE);
		background_layer.add(Login, "name_991320077632900");
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(Color.BLACK);
		panel_5_1.setBounds(0, 0, 377, 490);
		Login.add(panel_5_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PEPEA CAR SERVICE");
		lblNewLabel_1_2.setBounds(66, 11, 283, 53);
		panel_5_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Pelton EA");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1.setBounds(136, 306, 125, 14);
		panel_5_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("...Innovating change...");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(124, 356, 161, 14);
		panel_5_1.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Home.class.getResource("/images/pexels-kamshotthat-3457780(2).jpg")));
		lblNewLabel_2_1_1.setBounds(0, 0, 377, 455);
		panel_5_1.add(lblNewLabel_2_1_1);
		
		Button login_btn = new Button("Login");
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id_string_login, password_login_string;
				char [] password;
				id_string_login = id_login.getText().toLowerCase();
				password = password_login.getPassword();
				password_login_string = new String(password);
				

				if(id_string_login.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter your Username or Email Address");
				}
				if(password_login_string.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter your Password");
				}
				else {
					int connection_result = Connect();
					if(connection_result==0) {
						int result_username_login =username_Login(id_string_login,password_login_string);
						int result_email_login = email_Login(id_string_login,password_login_string);	
						//checking on whether its email or username login
						if((result_username_login == 0 ||result_email_login==0)) {
							if(password_login_string.equals(Session_password)) {
								
								// logging into the dashboard
								
								switchBackgroundPanels(Dashboard);
								details_set();
							}
							else {
								JOptionPane.showMessageDialog(null, "Incorrect password");
							}
						}
			               		               	
						else {
							JOptionPane.showMessageDialog(null, "Invalid login Details");
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Server Error please retry later");
						id_login.setText("");
						password_login.setText("");
						id_login.requestFocusInWindow();
					}
				}
			}
		});
		login_btn.setForeground(Color.WHITE);
		login_btn.setBackground(new Color(241, 57, 83));
		login_btn.setBounds(429, 293, 251, 35);
		Login.add(login_btn);
		
		id_login = new JTextField();
		id_login.setColumns(10);
		id_login.setBounds(429, 122, 251, 29);
		Login.add(id_login);
		
		JLabel lblNewLabel_1_1_5_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1_5_1.setBounds(429, 162, 94, 14);
		Login.add(lblNewLabel_1_1_5_1);
		
		password_login = new JPasswordField();
		password_login.setBounds(429, 187, 251, 29);
		Login.add(password_login);
		
		JLabel lbl_close_1 = new JLabel("X");
		lbl_close_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_close_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close_1.setForeground(new Color(241, 57, 83));
		lbl_close_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_close_1.setBackground(new Color(241, 57, 83));
		lbl_close_1.setBounds(680, 0, 33, 29);
		Login.add(lbl_close_1);
		
		JLabel lblNewLabel_2 = new JLabel("Don't have an Account?");
		lblNewLabel_2.setForeground(new Color(241, 57, 83));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchBackgroundPanels(Signup);
			}
		});
		lblNewLabel_2.setBounds(558, 239, 145, 14);
		Login.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_5_1_1 = new JLabel("USERNAME / EMAIL");
		lblNewLabel_1_1_5_1_1.setBounds(429, 97, 129, 14);
		Login.add(lblNewLabel_1_1_5_1_1);
		
		Dashboard = new JPanel();
		Dashboard.setBackground(Color.WHITE);
		background_layer.add(Dashboard, "name_1032536376957000");
		Dashboard.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(241, 57, 83));
		panel.setBounds(0, 0, 171, 411);
		Dashboard.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("PEPEA");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(62, 11, 85, 25);
		panel.add(lblNewLabel_3);
		
		home_dashboard = new JPanel();
		home_dashboard.setBackground(new Color(242, 77, 101));
		home_dashboard.setBounds(0, 47, 171, 36);
		panel.add(home_dashboard);
		home_dashboard.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("HOME");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(66, 11, 53, 14);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		home_dashboard.add(lblNewLabel_4);
		
		buy_dashboard = new JPanel();
		buy_dashboard.setLayout(null);
		buy_dashboard.setBackground(new Color(242, 77, 101));
		buy_dashboard.setBounds(0, 83, 171, 36);
		panel.add(buy_dashboard);
		
		JLabel lblNewLabel_4_2 = new JLabel("BUY");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_4_2.setBounds(66, 11, 53, 14);
		buy_dashboard.add(lblNewLabel_4_2);
		
		sell_dashboard = new JPanel();
		sell_dashboard.setLayout(null);
		sell_dashboard.setBackground(new Color(242, 77, 101));
		sell_dashboard.setBounds(0, 118, 171, 36);
		panel.add(sell_dashboard);
		
		JLabel lblNewLabel_4_3 = new JLabel("SELL");
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_4_3.setBounds(66, 11, 53, 14);
		sell_dashboard.add(lblNewLabel_4_3);
		
		rent_dashboard = new JPanel();
		rent_dashboard.setLayout(null);
		rent_dashboard.setBackground(new Color(242, 77, 101));
		rent_dashboard.setBounds(0, 154, 171, 36);
		panel.add(rent_dashboard);
		
		JLabel lblNewLabel_4_4 = new JLabel("RENT");
		lblNewLabel_4_4.setForeground(Color.WHITE);
		lblNewLabel_4_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_4_4.setBounds(66, 11, 53, 14);
		rent_dashboard.add(lblNewLabel_4_4);
		
		returns_dashboard = new JPanel();
		returns_dashboard.setLayout(null);
		returns_dashboard.setBackground(new Color(242, 77, 101));
		returns_dashboard.setBounds(0, 190, 171, 36);
		panel.add(returns_dashboard);
		
		JLabel lblNewLabel_4_5 = new JLabel("RETURNS");
		lblNewLabel_4_5.setForeground(Color.WHITE);
		lblNewLabel_4_5.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_4_5.setBounds(56, 11, 68, 14);
		returns_dashboard.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Pelton EA");
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1_1.setBounds(46, 336, 101, 14);
		panel.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("...Innovating change...");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1_1.setBounds(10, 386, 161, 14);
		panel.add(lblNewLabel_4_1_1_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(171, 0, 542, 571);
		Dashboard.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel home_subpanel = new JPanel();
		home_subpanel.setBackground(Color.WHITE);
		layeredPane.add(home_subpanel, "name_1049694049711100");
		home_subpanel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(241, 57, 83));
		header.setBounds(0, 0, 542, 48);
		home_subpanel.add(header);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 48, 542, 357);
		home_subpanel.add(scrollPane);
		
		JPanel body = new JPanel();
		body.setBackground(Color.WHITE);
		scrollPane.setViewportView(body);
		body.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 540, 560);
		body.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		JPanel panel_3_2_1_1 = new JPanel();
		panel_3_2_1_1.setBounds(377, 307, 153, 126);
		panel_1.add(panel_3_2_1_1);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setBounds(377, 161, 153, 126);
		panel_1.add(panel_3_2_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(377, 11, 153, 126);
		panel_1.add(panel_3_2);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(200, 11, 153, 126);
		panel_1.add(panel_3_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(21, 11, 153, 126);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		brand1 = new JLabel("BRAND");
		brand1.setFont(new Font("Tahoma", Font.BOLD, 12));
		brand1.setBounds(0, 90, 153, 25);
		panel_3.add(brand1);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBounds(21, 161, 153, 126);
		panel_1.add(panel_3_3);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(200, 161, 153, 126);
		panel_1.add(panel_3_1_1);
		
		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setBounds(21, 307, 153, 126);
		panel_1.add(panel_3_3_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_3_3_1.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(Home.class.getResource("/images/wallhaven-m9m6p9_1280x1024_re.png")));
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setBounds(200, 307, 153, 126);
		panel_1.add(panel_3_1_1_1);
		
	
	}
}
