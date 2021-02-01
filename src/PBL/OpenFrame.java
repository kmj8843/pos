package PBL;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class OpenFrame extends JFrame {
	int year_index, month_index, day_index, event_index;
	OpenPanel op = new OpenPanel();

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

	private Image backgroundOpen = new ImageIcon(PBL.class.getResource("../image_cafe/cafeLoginBackground(Title).jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(PBL.class.getResource("../image_cafe/menuBar2.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton allwindowButton = new JButton(allwindowButtonBasicImage);
	private JButton underbarButton = new JButton(underbarButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;

	OpenFrame() {
		PBL.orderNumber = 1;
		PBL.cardselln = 0;
		PBL.moneyselln = 0;
		PBL.totalAmericano = 0;
		PBL.totalFrappe = 0;
		PBL.totalCafeLatte = 0;
		PBL.totalCapuccino = 0;
		PBL.totalExpress = 0;
		PBL.totalIceTea = 0;
		PBL.totalLemonAdes = 0;
		PBL.totalMilkTea = 0;
		PBL.totalAffogato = 0;
		PBL.money = 0;
		PBL.month = 0;
		PBL.day = 0;
		PBL.event_sale = 1;

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(op);
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
				new CafeFrame();
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
		g.drawImage(backgroundOpen, 0, 0, null);

		paintComponents(g);
		this.repaint();
	}

	class OpenPanel extends JPanel {
		OpenPanel() {
			setLayout(null);

			PBL.year = new GregorianCalendar().get(new GregorianCalendar().YEAR);
			int year_a[] = { PBL.year - 2, PBL.year - 1, PBL.year, PBL.year + 1, PBL.year + 2 };
			JComboBox yearCombo = new JComboBox();
			for (int i = 0; i < year_a.length; i++) {
				yearCombo.addItem(year_a[i]);
			}
			yearCombo.setBounds(115, 250, 70, 30);
			add(yearCombo);
			yearCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox year_box = (JComboBox) e.getSource();
					year_index = year_box.getSelectedIndex();
				}
			});

			int month_a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
			JComboBox monthCombo = new JComboBox();
			for (int i = 0; i < month_a.length; i++) {
				monthCombo.addItem(month_a[i]);
			}
			monthCombo.setBounds(225, 250, 70, 30);
			add(monthCombo);
			monthCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox month_box = (JComboBox) e.getSource();
					month_index = month_box.getSelectedIndex();
				}
			});

			int day_a[] = new int[31];
			JComboBox dayCombo = new JComboBox();
			for (int i = 0; i < 31; i++) {
				day_a[i] = i + 1;
			}
			for (int i = 0; i < 31; i++) {
				dayCombo.addItem(day_a[i]);
			}
			dayCombo.setBounds(325, 250, 70, 30);
			add(dayCombo);
			dayCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox day_box = (JComboBox) e.getSource();
					day_index = day_box.getSelectedIndex();
				}
			});

			JLabel 행사 = new JLabel("행사");
			행사.setBounds(130, 300, 50, 30);
			add(행사);

			String event[] = { "없음", "전 메뉴 10% 할인", "전 메뉴 30% 할인" };
			JComboBox eventCombo = new JComboBox(event);
			eventCombo.setBounds(165, 300, 150, 30);
			eventCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox event_box = (JComboBox) e.getSource();
					PBL.event_number = event_box.getSelectedIndex();
					if (PBL.event_number == 1) {
						PBL.event_sale = 0.9;
					} else if (PBL.event_number == 2) {
						PBL.event_sale = 0.7;
					}
				}
			});
			add(eventCombo);

			JLabel year_D, month_D, day_D;
			year_D = new JLabel("년");
			year_D.setBounds(195, 250, 30, 30);
			add(year_D);

			month_D = new JLabel("월");
			month_D.setBounds(305, 250, 30, 30);
			add(month_D);

			day_D = new JLabel("일");
			day_D.setBounds(405, 250, 30, 30);
			add(day_D);

			JButton open = new JButton("개점");
			open.setBounds(335, 300, 70, 28);
			add(open);

			open.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PBL.year = PBL.year - 2 + year_index;
					PBL.month = PBL.month + 1 + month_index;
					PBL.day = PBL.day + 1 + day_index;

					dispose();
					new MenuFrame();
				}
			});
			open.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					open.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					open.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					PBL.year = PBL.year - 2 + year_index;
					PBL.month = PBL.month + 1 + month_index;
					PBL.day = PBL.day + 1 + day_index;

					dispose();
					new MenuFrame();
				}
			});
		}
	}
}
