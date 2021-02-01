package PBL;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class DeadLineFrame extends JFrame {
	DeadLinePanel dl = new DeadLinePanel();

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			PBL.class.getResource("../image_cafe/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(PBL.class.getResource("../image_cafe/exitButtonBasic.png"));
	private ImageIcon allwindowButtonEnteredImage = new ImageIcon(
			PBL.class.getResource("../image_cafe/allwindowButtonEntered.png"));
	private ImageIcon allwindowButtonBasicImage = new ImageIcon(
			PBL.class.getResource("../image_cafe/allwindowButtonBasic.png"));
	private ImageIcon underbarButtonEnteredImage = new ImageIcon(
			PBL.class.getResource("../image_cafe/underbarButtonEntered.png"));
	private ImageIcon underbarButtonBasicImage = new ImageIcon(
			PBL.class.getResource("../image_cafe/underbarButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(
			PBL.class.getResource("../image_cafe/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(PBL.class.getResource("../image_cafe/backButtonBasic.png"));

	private Image backgroundDeadline = new ImageIcon(PBL.class.getResource("../image_cafe/마감Background(Title).jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(PBL.class.getResource("../image_cafe/menuBar2.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton allwindowButton = new JButton(allwindowButtonBasicImage);
	private JButton underbarButton = new JButton(underbarButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;

	DeadLineFrame() {
		setUndecorated(true);
		setTitle("Cafe's POS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(dl);

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
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

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
			public void mouseEntered(MouseEvent e) {
				allwindowButton.setIcon(allwindowButtonEnteredImage);
				allwindowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				allwindowButton.setIcon(allwindowButtonBasicImage);
				allwindowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

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
			public void mouseEntered(MouseEvent e) {
				underbarButton.setIcon(underbarButtonEnteredImage);
				underbarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				underbarButton.setIcon(underbarButtonBasicImage);
				underbarButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
				buttonEnteredMusic.start();
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		add(underbarButton);

		backButton.setBounds(4, 4, 32, 22);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusable(false);
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
				buttonEnteredMusic.start();
				dispose();
				new MenuFrame();
			}
		});
		add(backButton);

		menuBar.setBounds(0, 0, 500, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
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
		g.drawImage(backgroundDeadline, 0, 0, null);

		paintComponents(g);
		this.repaint();
	}

	class DeadLinePanel extends JPanel {
		JLabel screen[] = new JLabel[20];

		DeadLinePanel() {
			setLayout(null);
			File dst = new File(
					"C:\\Java Cafe\\" + PBL.year + "." + PBL.month + "." + PBL.day + ".txt");
			FileInputStream fi;
			InputStreamReader in;
			StringBuffer screenText[] = new StringBuffer[16];
			for (int i = 0; i < 16; i++) {
				screenText[i] = new StringBuffer("");
			}

			String newLine = System.getProperty("line.separator");
			try {
				fi = new FileInputStream(dst);
				in = new InputStreamReader(fi);
				int c;
				int i = 0;

				while ((c = in.read()) != -1) {
					screenText[i].append((char) c);
					if ((char) c == '　') {
						i++;
					}
				}
				in.close();
				fi.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

			for (int i = 0; i < 16; i++) {
				screen[i] = new JLabel(screenText[i].toString());
				screen[i].setBounds(130, 130 + 20 * (i + 1), 430, 22);
				screen[i].setHorizontalAlignment(JLabel.CENTER);
				add(screen[i]);
			}
			JButton confirm = new JButton("확인");
			confirm.setBounds(305, 440, 60, 30);
			confirm.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					confirm.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

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
			add(confirm);
		}
	}
}
