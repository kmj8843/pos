package PBL;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class CafeFrame extends JFrame {
	CafePanel cf = new CafePanel();
	
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(PBL.class.getResource("../image_cafe/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(PBL.class.getResource("../image_cafe/exitButtonBasic.png"));
	private ImageIcon allwindowButtonEnteredImage = new ImageIcon(PBL.class.getResource("../image_cafe/allwindowButtonEntered.png"));
	private ImageIcon allwindowButtonBasicImage = new ImageIcon(PBL.class.getResource("../image_cafe/allwindowButtonBasic.png"));
	private ImageIcon underbarButtonEnteredImage = new ImageIcon(PBL.class.getResource("../image_cafe/underbarButtonEntered.png"));
	private ImageIcon underbarButtonBasicImage = new ImageIcon(PBL.class.getResource("../image_cafe/underbarButtonBasic.png"));

	private Image backgroundLogin = new ImageIcon(PBL.class.getResource("../image_cafe/cafeLoginBackground(Title).jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(PBL.class.getResource("../image_cafe/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton allwindowButton = new JButton(allwindowButtonBasicImage);
	private JButton underbarButton = new JButton(underbarButtonBasicImage);
	
	private int mouseX, mouseY;
	
	
	CafeFrame() {
		setUndecorated(true);
		setTitle("Cafe's POS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(cf);

		setSize(PBL.SCREEN_WIDTH, PBL.SCREEN_LENGTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		
		exitButton.setBounds(442, 4, 53, 22);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusable(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 							
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(500); 														
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		allwindowButton.setBounds(412, 4, 33, 22);
		allwindowButton.setBorderPainted(false);
		allwindowButton.setContentAreaFilled(false);
		allwindowButton.setFocusable(false);
		allwindowButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				allwindowButton.setIcon(allwindowButtonEnteredImage);
				allwindowButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 		
			}

			@Override
			public void mouseExited(MouseEvent e) {
				allwindowButton.setIcon(allwindowButtonBasicImage);
				allwindowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
				buttonEnteredMusic.start();

			}
		});
		add(allwindowButton);
		
		underbarButton.setBounds(383, 4, 33, 22);
		underbarButton.setBorderPainted(false);
		underbarButton.setContentAreaFilled(false);
		underbarButton.setFocusable(false);
		underbarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				underbarButton.setIcon(underbarButtonEnteredImage);
				underbarButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 							
			}

			@Override
			public void mouseExited(MouseEvent e) {
				underbarButton.setIcon(underbarButtonBasicImage);
				underbarButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
				buttonEnteredMusic.start();
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		add(underbarButton);
		
		menuBar.setBounds(0, 0, 500, 30); 										
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { 								
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen(); 									
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); 					
			}
		});
		add(menuBar);
	}
	
	public void paint(Graphics g) {															
		screenImage = createImage(PBL.SCREEN_WIDTH, PBL.SCREEN_LENGTH);					
		screenGraphic = screenImage.getGraphics();											
		screenDraw(screenGraphic);															
		g.drawImage(screenImage, 0, 0, null);												
	}

	public void screenDraw(Graphics g) {
		g.drawImage(backgroundLogin, 0, 0, null);				
		
		paintComponents(g);					
		this.repaint();							
	}

	class CafePanel extends JPanel {
		private JLabel ID;
		private JTextField PW;
		private JButton checkPw;

		CafePanel() {
			setLayout(null);
			ID = new JLabel("Write Password!");
			ID.setBounds(170, 230, 100, 40);
			add(ID);

			PW = new JPasswordField();
			PW.setBounds(170, 270, 100, 30);
			add(PW);

			checkPw = new JButton("Login");
			checkPw.setBounds(280, 240, 80, 60);
			add(checkPw);
			checkPw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					checkPw.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					checkPw.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					if (PW.getText().equals("1")) {
						CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
						buttonEnteredMusic.start();									
						dispose();
						new OpenFrame();
					} else {
						CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
						buttonEnteredMusic.start();		
						ID.setText("Password Error!");
					}
				}
			});
			PW.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						if (PW.getText().equals("1")) {
							CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
							buttonEnteredMusic.start();	
							dispose();
							new OpenFrame();
						}
						else {
							ID.setText("Password Error!");
						}
					}
				}
			});
		}

	}//panel

}