package PBL;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Frame extends JFrame {
	Panel pn = new Panel();

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

	private Image backgroundCalFrame = new ImageIcon(PBL.class.getResource("../image_cafe/마감Background(Title).jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(PBL.class.getResource("../image_cafe/menuBar2.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton allwindowButton = new JButton(allwindowButtonBasicImage);
	private JButton underbarButton = new JButton(underbarButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;

	Frame() {
		setUndecorated(true);
		setTitle("Cafe's POS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(pn);
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
				new CalculateFrame();
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
		g.drawImage(backgroundCalFrame, 0, 0, null);

		paintComponents(g);
		this.repaint();
	}

	class Panel extends JPanel {
		JLabel screen[] = new JLabel[14];

		Panel() {
			setLayout(null);
			screen[0] = new JLabel("--------------------------------------------");
			screen[1] = new JLabel("아메리카노 판매 건수 : " + PBL.cal_Americano + " 건　");
			screen[2] = new JLabel("프라페 판매 건수 : " + PBL.cal_Frappe + " 건　");
			screen[3] = new JLabel("카페라떼 판매 건수 : " + PBL.cal_CafeLatte + " 건　");
			screen[4] = new JLabel("카푸치노 판매 건수 : " + PBL.cal_Capuccino + " 건　");
			screen[5] = new JLabel("익스프레스 판매 건수 : " + PBL.cal_Express + " 건　");
			screen[6] = new JLabel("아이스티 판매 건수 : " + PBL.cal_IceTea + " 건　");
			screen[7] = new JLabel("레몬에이드 판매 건수 : " + PBL.cal_LemonAdes + " 건　");
			screen[8] = new JLabel("밀크티 판매 건수 : " + PBL.cal_MilkTea + " 건　");
			screen[9] = new JLabel("아포가토 판매 건수 : " + PBL.cal_Affogato + " 건　");
			screen[10] = new JLabel("--------------------------------------------　");
			screen[11] = new JLabel("카드 계산 : " + PBL.cal_card + " 건　");
			screen[12] = new JLabel("현금 계산 : " + PBL.cal_money + " 건　");
			screen[13] = new JLabel("수익금 : " + getCalmoney() + " 원　");

			for (int i = 0; i < 14; i++) {
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
					dispose();
					new CalculateFrame();
				}
			});
			add(confirm);

			PBL.cal_Americano = 0;
			PBL.cal_Frappe = 0;
			PBL.cal_CafeLatte = 0;
			PBL.cal_Capuccino = 0;
			PBL.cal_Express = 0;
			PBL.cal_IceTea = 0;
			PBL.cal_LemonAdes = 0;
			PBL.cal_MilkTea = 0;
			PBL.cal_Affogato = 0;
			PBL.cal_card = 0;
			PBL.cal_money = 0;
			PBL.cal_totalmoney = 0;
		}

		int getCalmoney() {
			PBL.cal_totalmoney = (int) ((PBL.cal_Americano * 1500 + PBL.cal_Frappe * 1500 + PBL.cal_CafeLatte * 2000
					+ PBL.cal_Capuccino * 2000 + PBL.cal_Express * 2000 + PBL.cal_IceTea * 1500
					+ PBL.cal_LemonAdes * 2500 + PBL.cal_MilkTea * 2500 + PBL.cal_Affogato * 3500) * PBL.event_sale);
			return PBL.cal_totalmoney;
		}
	}
}
