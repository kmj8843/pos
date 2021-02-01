package PBL;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CafeMenuFrame extends JFrame {
	private CafeMenuPanel cm = new CafeMenuPanel();
	private JButton menu[];
	private JLabel list[];

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

	private JLabel menuBar = new JLabel(new ImageIcon(PBL.class.getResource("../image_cafe/menuBar2.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton allwindowButton = new JButton(allwindowButtonBasicImage);
	private JButton underbarButton = new JButton(underbarButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;

	CafeMenuFrame() {
		setUndecorated(true);
		setTitle("Cafe's POS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(cm);

		setSize(PBL.SCREEN_WIDTH, PBL.SCREEN_LENGTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

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

	class CafeMenuPanel extends JPanel {
		private int bevCount[] = new int[9];

		CafeMenuPanel() {
			setLayout(null);

			for (int i = 0; i < 9; i++) {
				bevCount[i] = 0;
			}
			
			list = new JLabel[10];
			for (int i = 0; i < 10; i++) {
				list[i] = new JLabel("");
				list[i].setOpaque(true);
				list[i].setBackground(Color.WHITE);
			}
			
			menu = new JButton[9];
			menu[0] = new JButton("<html>Americano<br />" + (int) (1500 * PBL.event_sale) + "냥</html>");
			menu[1] = new JButton("<html>Frappe<br />" + (int) (1500 * PBL.event_sale) + "냥</html>");
			menu[2] = new JButton("<html>Cafe Latte<br />" + (int) (2000 * PBL.event_sale) + "냥</html>");
			menu[3] = new JButton("<html>Capuccino<br />" + (int) (2000 * PBL.event_sale) + "냥</html>");
			menu[4] = new JButton("<html>Express<br />" + (int) (2000 * PBL.event_sale) + "냥</html>");
			menu[5] = new JButton("<html>Ice Tea<br />" + (int) (1500 * PBL.event_sale) + "냥</html>");
			menu[6] = new JButton("<html>Lemon Ades<br />" + (int) (2500 * PBL.event_sale) + "냥</html>");
			menu[7] = new JButton("<html>Milk Tea<br />" + (int) (2500 * PBL.event_sale) + "냥</html>");
			menu[8] = new JButton("<html>Affogato<br />" + (int) (3500 * PBL.event_sale) + "냥</html>");
			
			JButton cal_C = new JButton("카드 계산");
			JButton cal_M = new JButton("현금 계산");
			JLabel orderN = new JLabel(PBL.orderNumber + "번째 주문 입니다.");
			orderN.setHorizontalAlignment(JLabel.CENTER);

			for (int i = 0; i < 10; i++) {
				if (i < 5) {
					list[i].setBounds(12, 45 + 20 * i, 230, 20);
				} else if (i >= 5) {
					list[i].setBounds(242, 45 + 20 * (i - 5), 230, 20);
				}
			}

			menu[0].setBounds(12, 165, 140, 60);
			menu[1].setBounds(172, 165, 140, 60);
			menu[2].setBounds(332, 165, 140, 60);
			menu[3].setBounds(12, 235, 140, 60);
			menu[4].setBounds(172, 235, 140, 60);
			menu[5].setBounds(332, 235, 140, 60);
			menu[6].setBounds(12, 305, 140, 60);
			menu[7].setBounds(172, 305, 140, 60);
			menu[8].setBounds(332, 305, 140, 60);
			cal_C.setBounds(12, 375, 220, 80);
			cal_M.setBounds(250, 375, 220, 80);
			orderN.setBounds(12, 465, 460, 20);

			for (int i = 0; i < 9; i++) {
				add(menu[i]);
				add(list[i]);
			}
			add(list[9]);
			add(cal_C);
			add(cal_M);
			add(orderN);

			menu[0].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[0].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[0]++;
					PBL.totalAmericano++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Americano")) {
							flag = 1;
							list[i].setText("Americano " + bevCount[0] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Americano " + bevCount[0] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			menu[1].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[1].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[1]++;
					PBL.totalFrappe++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Frappe")) {
							flag = 1;
							list[i].setText("Frappe  " + bevCount[1] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Frappe " + bevCount[1] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			menu[2].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[2].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[2]++;
					PBL.totalCafeLatte++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Cafe")) {
							flag = 1;
							list[i].setText("Cafe Latte " + bevCount[2] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Cafe Latte " + bevCount[2] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			menu[3].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[3].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[3].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[3]++;
					PBL.totalCapuccino++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Capuccino")) {
							flag = 1;
							list[i].setText("Capuccino " + bevCount[3] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Capuccino " + bevCount[3] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			menu[4].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[4].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[4].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[4]++;
					PBL.totalExpress++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Express")) {
							flag = 1;
							list[i].setText("Express " + bevCount[4] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Express " + bevCount[4] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			menu[5].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[5].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[5].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[5]++;
					PBL.totalIceTea++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Ice")) {
							flag = 1;
							list[i].setText("Ice Tea " + bevCount[5] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Ice Tea " + bevCount[5] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			menu[6].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[6].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[6].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[6]++;
					PBL.totalLemonAdes++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Lemon")) {
							flag = 1;
							list[i].setText("Lemon Ades " + bevCount[6] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Lemon Ades " + bevCount[6] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			menu[7].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[7].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[7].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[7]++;
					PBL.totalMilkTea++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Milk")) {
							flag = 1;
							list[i].setText("Milk Tea " + bevCount[7] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Milk Tea " + bevCount[7] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			menu[8].addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					menu[8].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					menu[8].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					int flag = 0;
					bevCount[8]++;
					PBL.totalAffogato++;
					for (int i = 0; i < 9; i++) {
						if (list[i].getText().contains("Affogato")) {
							flag = 1;
							list[i].setText("Affogato " + bevCount[8] + " 개");
							break;
						}
					}
					if (flag == 0) {
						list[nCount()].setText("Affogato " + bevCount[8] + " 개");
					}
					setTotalMoney();
					list[9].setText("총 금액 : " + getTotalMoney());
				}
			});

			cal_C.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					cal_C.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					cal_C.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					cal();
					PBL.cardselln++;
					dispose();
					new MenuFrame();
				}
			});
			cal_M.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					cal_M.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					cal_M.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					cal();
					PBL.moneyselln++;

					dispose();
					new MenuFrame();
				}
			});
		}

		int nCount() {
			int count = -1;
			for (int i = 0; i < 9; i++) {
				if (bevCount[i] != 0) {
					count++;
				}
			}
			return count;
		}

		void setTotalMoney() {
			PBL.total_money = (int) ((bevCount[0] * 1500 + bevCount[1] * 1500 + bevCount[2] * 2000 + bevCount[3] * 2000
					+ bevCount[4] * 2000 + bevCount[5] * 1500 + bevCount[6] * 2500 + bevCount[7] * 2500
					+ bevCount[8] * 3500) * PBL.event_sale);
			if (PBL.total_money % 10 == 9) {
				PBL.total_money += 1;
			}
		}

		int getTotalMoney() {
			return PBL.total_money;
		}
		void cal() {
			setTotalMoney();
			if(getTotalMoney()>0) {
                  PBL.orderNumber++;
               }
			PBL.money += PBL.total_money;
		}
	}
}
