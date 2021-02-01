package PBL;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CalculateFrame extends JFrame {
	CalculatePanel cal = new CalculatePanel();

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

	private Image backgroundCalculateFrame = new ImageIcon(PBL.class.getResource("../image_cafe/정산Background(Title).jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(PBL.class.getResource("../image_cafe/menuBar2.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton allwindowButton = new JButton(allwindowButtonBasicImage);
	private JButton underbarButton = new JButton(underbarButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;

	CalculateFrame() {
		setUndecorated(true);
		setTitle("Cafe's POS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(cal);

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
		g.drawImage(backgroundCalculateFrame, 0, 0, null);

		paintComponents(g);
		this.repaint();
	}

	class CalculatePanel extends JPanel {

		CalculatePanel() {
			setLayout(null);

			JButton 년도 = new JButton("년도별");
			JButton 반기 = new JButton("반기별");
			JButton 분기 = new JButton("분기별");
			JButton 달 = new JButton("달별");
			JButton 일 = new JButton("일별");

			JButton confirm = new JButton("확인");
			JTextField year_Text = new JTextField();
			JLabel year_Label = new JLabel("년");
			JTextField month_Text = new JTextField();
			JLabel month_Label = new JLabel("월");
			JTextField day_Text = new JTextField();
			JLabel day_Label = new JLabel("일");

			String half_a[] = { "전반기", "후반기" };
			JComboBox half = new JComboBox(half_a);

			String quarter_a[] = { "1분기", "2분기", "3분기", "4분기" };
			JComboBox quarter = new JComboBox(quarter_a);

			년도.setBounds(30, 130, 80, 30);
			반기.setBounds(30, 200, 80, 30);
			분기.setBounds(30, 270, 80, 30);
			달.setBounds(30, 340, 80, 30);
			일.setBounds(30, 410, 80, 30);

			년도.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					년도.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					년도.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					confirm.setVisible(false);
					year_Text.setVisible(false);
					year_Label.setVisible(false);
					month_Text.setVisible(false);
					month_Label.setVisible(false);
					day_Text.setVisible(false);
					day_Label.setVisible(false);
					half.setVisible(false);
					quarter.setVisible(false);

					year_Text.setBounds(190, 130, 80, 30);
					year_Text.setVisible(true);
					year_Label.setBounds(275, 130, 30, 30);
					year_Label.setVisible(true);

					confirm.setBounds(350, 130, 70, 30);
					confirm.setVisible(true);

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
							File f = new File("C:\\Java Cafe");
							String filenames[] = f.list();
							for (int i = 0; i < filenames.length; i++) {
								if (year_Text.getText().equals(filenames[i].substring(0, 4))) {
									File s = new File("C:\\Java Cafe\\" + filenames[i]);
									FileReader fi;
									BufferedReader in;
									try {
										fi = new FileReader(s);
										in = new BufferedReader(fi);
										String c = "";
										int k = 0;

										while ((c = in.readLine()) != null) {
											String str[] = c.split(" ");
											switch (k) {
											case 1:
												PBL.cal_Americano += Integer.parseInt(str[4]);
												k++;
												break;
											case 2:
												PBL.cal_Frappe += Integer.parseInt(str[4]);
												k++;
												break;
											case 3:
												PBL.cal_CafeLatte += Integer.parseInt(str[4]);
												k++;
												break;
											case 4:
												PBL.cal_Capuccino += Integer.parseInt(str[4]);
												k++;
												break;
											case 5:
												PBL.cal_Express += Integer.parseInt(str[4]);
												k++;
												break;
											case 6:
												PBL.cal_IceTea += Integer.parseInt(str[4]);
												k++;
												break;
											case 7:
												PBL.cal_LemonAdes += Integer.parseInt(str[4]);
												k++;
												break;
											case 8:
												PBL.cal_MilkTea += Integer.parseInt(str[4]);
												k++;
												break;
											case 9:
												PBL.cal_Affogato += Integer.parseInt(str[4]);
												k++;
												break;
											case 11:
												PBL.cal_card += Integer.parseInt(str[3]);
												k++;
												break;
											case 12:
												PBL.cal_money += Integer.parseInt(str[3]);
												k++;
												break;
											default:
												k++;
											}
										}

										in.close();
										fi.close();
									} catch (IOException a) {
										System.out.println(a.getMessage());
									}
								}
							}
							dispose();
							new Frame();
						}
					});
				}
			});

			반기.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					반기.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					반기.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					confirm.setVisible(false);
					year_Text.setVisible(false);
					year_Label.setVisible(false);
					month_Text.setVisible(false);
					month_Label.setVisible(false);
					day_Text.setVisible(false);
					day_Label.setVisible(false);
					half.setVisible(false);
					quarter.setVisible(false);

					year_Text.setBounds(130, 200, 80, 30);
					year_Text.setVisible(true);
					year_Label.setBounds(215, 200, 30, 30);
					year_Label.setVisible(true);
					half.setBounds(250, 200, 70, 30);
					half.setVisible(true);

					confirm.setBounds(350, 200, 70, 30);
					confirm.setVisible(true);

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
							File f = new File("C:\\Java Cafe");
							String filenames[] = f.list();
							for (int i = 0; i < filenames.length; i++) {
								int n = half.getSelectedIndex();
								String st[] = filenames[i].split("\\.");
								if (n == 0) {
									if (year_Text.getText().equals(st[0])
											&& (Integer.parseInt(st[1]) >= 1 && Integer.parseInt(st[1]) <= 6)) {
										File s = new File("C:\\Java Cafe\\" + filenames[i]);
										FileReader fi;
										BufferedReader in;
										try {
											fi = new FileReader(s);
											in = new BufferedReader(fi);
											String c = "";
											int k = 0;

											while ((c = in.readLine()) != null) {
												String str[] = c.split(" ");
												switch (k) {
												case 1:
													PBL.cal_Americano += Integer.parseInt(str[4]);
													k++;
													break;
												case 2:
													PBL.cal_Frappe += Integer.parseInt(str[4]);
													k++;
													break;
												case 3:
													PBL.cal_CafeLatte += Integer.parseInt(str[4]);
													k++;
													break;
												case 4:
													PBL.cal_Capuccino += Integer.parseInt(str[4]);
													k++;
													break;
												case 5:
													PBL.cal_Express += Integer.parseInt(str[4]);
													k++;
													break;
												case 6:
													PBL.cal_IceTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 7:
													PBL.cal_LemonAdes += Integer.parseInt(str[4]);
													k++;
													break;
												case 8:
													PBL.cal_MilkTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 9:
													PBL.cal_Affogato += Integer.parseInt(str[4]);
													k++;
													break;
												case 11:
													PBL.cal_card += Integer.parseInt(str[3]);
													k++;
													break;
												case 12:
													PBL.cal_money += Integer.parseInt(str[3]);
													k++;
													break;
												default:
													k++;
												}
											}

											in.close();
											fi.close();
										} catch (IOException a) {
											System.out.println(a.getMessage());
										}
									}
								} else if (n == 1) {
									if (year_Text.getText().equals(st[0])
											&& (Integer.parseInt(st[1]) >= 7 && Integer.parseInt(st[1]) <= 12)) {
										File s = new File("C:\\Java Cafe\\" + filenames[i]);
										FileReader fi;
										BufferedReader in;
										try {
											fi = new FileReader(s);
											in = new BufferedReader(fi);
											String c = "";
											int k = 0;

											while ((c = in.readLine()) != null) {
												String str[] = c.split(" ");
												switch (k) {
												case 1:
													PBL.cal_Americano += Integer.parseInt(str[4]);
													k++;
													break;
												case 2:
													PBL.cal_Frappe += Integer.parseInt(str[4]);
													k++;
													break;
												case 3:
													PBL.cal_CafeLatte += Integer.parseInt(str[4]);
													k++;
													break;
												case 4:
													PBL.cal_Capuccino += Integer.parseInt(str[4]);
													k++;
													break;
												case 5:
													PBL.cal_Express += Integer.parseInt(str[4]);
													k++;
													break;
												case 6:
													PBL.cal_IceTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 7:
													PBL.cal_LemonAdes += Integer.parseInt(str[4]);
													k++;
													break;
												case 8:
													PBL.cal_MilkTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 9:
													PBL.cal_Affogato += Integer.parseInt(str[4]);
													k++;
													break;
												case 11:
													PBL.cal_card += Integer.parseInt(str[3]);
													k++;
													break;
												case 12:
													PBL.cal_money += Integer.parseInt(str[3]);
													k++;
													break;
												default:
													k++;
												}
											}
											in.close();
											fi.close();
										} catch (IOException a) {
											System.out.println(a.getMessage());
										}
									}
								}
							}
							dispose();
							new Frame();
						}
					});
				}
			});

			분기.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					분기.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					분기.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();
					confirm.setVisible(false);
					year_Text.setVisible(false);
					year_Label.setVisible(false);
					month_Text.setVisible(false);
					month_Label.setVisible(false);
					day_Text.setVisible(false);
					day_Label.setVisible(false);
					half.setVisible(false);
					quarter.setVisible(false);

					year_Text.setBounds(130, 270, 80, 30);
					year_Text.setVisible(true);
					year_Label.setBounds(215, 270, 30, 30);
					year_Label.setVisible(true);
					quarter.setBounds(250, 270, 70, 30);
					quarter.setVisible(true);

					confirm.setBounds(350, 270, 70, 30);
					confirm.setVisible(true);

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

							File f = new File("C:\\Java Cafe");
							String filenames[] = f.list();
							for (int i = 0; i < filenames.length; i++) {
								int n = quarter.getSelectedIndex();
								String st[] = filenames[i].split("\\.");
								if (n == 0) {
									if (year_Text.getText().equals(st[0])
											&& (Integer.parseInt(st[1]) >= 1 && Integer.parseInt(st[1]) <= 3)) {
										File s = new File("C:\\Java Cafe\\" + filenames[i]);
										FileReader fi;
										BufferedReader in;
										try {
											fi = new FileReader(s);
											in = new BufferedReader(fi);
											String c = "";
											int k = 0;

											while ((c = in.readLine()) != null) {
												String str[] = c.split(" ");
												switch (k) {
												case 1:
													PBL.cal_Americano += Integer.parseInt(str[4]);
													k++;
													break;
												case 2:
													PBL.cal_Frappe += Integer.parseInt(str[4]);
													k++;
													break;
												case 3:
													PBL.cal_CafeLatte += Integer.parseInt(str[4]);
													k++;
													break;
												case 4:
													PBL.cal_Capuccino += Integer.parseInt(str[4]);
													k++;
													break;
												case 5:
													PBL.cal_Express += Integer.parseInt(str[4]);
													k++;
													break;
												case 6:
													PBL.cal_IceTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 7:
													PBL.cal_LemonAdes += Integer.parseInt(str[4]);
													k++;
													break;
												case 8:
													PBL.cal_MilkTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 9:
													PBL.cal_Affogato += Integer.parseInt(str[4]);
													k++;
													break;
												case 11:
													PBL.cal_card += Integer.parseInt(str[3]);
													k++;
													break;
												case 12:
													PBL.cal_money += Integer.parseInt(str[3]);
													k++;
													break;
												default:
													k++;
												}
											}
											in.close();
											fi.close();
										} catch (IOException a) {
											System.out.println(a.getMessage());
										}
									}
								} else if (n == 1) {
									if (year_Text.getText().equals(st[0])
											&& (Integer.parseInt(st[1]) >= 4 && Integer.parseInt(st[1]) <= 6)) {
										File s = new File("C:\\Java Cafe\\" + filenames[i]);
										FileReader fi;
										BufferedReader in;
										try {
											fi = new FileReader(s);
											in = new BufferedReader(fi);
											String c = "";
											int k = 0;

											while ((c = in.readLine()) != null) {
												String str[] = c.split(" ");
												switch (k) {
												case 1:
													PBL.cal_Americano += Integer.parseInt(str[4]);
													k++;
													break;
												case 2:
													PBL.cal_Frappe += Integer.parseInt(str[4]);
													k++;
													break;
												case 3:
													PBL.cal_CafeLatte += Integer.parseInt(str[4]);
													k++;
													break;
												case 4:
													PBL.cal_Capuccino += Integer.parseInt(str[4]);
													k++;
													break;
												case 5:
													PBL.cal_Express += Integer.parseInt(str[4]);
													k++;
													break;
												case 6:
													PBL.cal_IceTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 7:
													PBL.cal_LemonAdes += Integer.parseInt(str[4]);
													k++;
													break;
												case 8:
													PBL.cal_MilkTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 9:
													PBL.cal_Affogato += Integer.parseInt(str[4]);
													k++;
													break;
												case 11:
													PBL.cal_card += Integer.parseInt(str[3]);
													k++;
													break;
												case 12:
													PBL.cal_money += Integer.parseInt(str[3]);
													k++;
													break;
												default:
													k++;
												}
											}
											in.close();
											fi.close();
										} catch (IOException a) {
											System.out.println(a.getMessage());
										}
									}
								} else if (n == 2) {
									if (year_Text.getText().equals(st[0])
											&& (Integer.parseInt(st[1]) >= 7 && Integer.parseInt(st[1]) <= 9)) {
										File s = new File("C:\\Java Cafe\\" + filenames[i]);
										FileReader fi;
										BufferedReader in;
										try {
											fi = new FileReader(s);
											in = new BufferedReader(fi);
											String c = "";
											int k = 0;

											while ((c = in.readLine()) != null) {
												String str[] = c.split(" ");
												switch (k) {
												case 1:
													PBL.cal_Americano += Integer.parseInt(str[4]);
													k++;
													break;
												case 2:
													PBL.cal_Frappe += Integer.parseInt(str[4]);
													k++;
													break;
												case 3:
													PBL.cal_CafeLatte += Integer.parseInt(str[4]);
													k++;
													break;
												case 4:
													PBL.cal_Capuccino += Integer.parseInt(str[4]);
													k++;
													break;
												case 5:
													PBL.cal_Express += Integer.parseInt(str[4]);
													k++;
													break;
												case 6:
													PBL.cal_IceTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 7:
													PBL.cal_LemonAdes += Integer.parseInt(str[4]);
													k++;
													break;
												case 8:
													PBL.cal_MilkTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 9:
													PBL.cal_Affogato += Integer.parseInt(str[4]);
													k++;
													break;
												case 11:
													PBL.cal_card += Integer.parseInt(str[3]);
													k++;
													break;
												case 12:
													PBL.cal_money += Integer.parseInt(str[3]);
													k++;
													break;
												default:
													k++;
												}
											}
											in.close();
											fi.close();
										} catch (IOException a) {
											System.out.println(a.getMessage());
										}
									}

								} else if (n == 3) {
									if (year_Text.getText().equals(st[0])
											&& (Integer.parseInt(st[1]) >= 10 && Integer.parseInt(st[1]) <= 12)) {
										File s = new File("C:\\Java Cafe\\" + filenames[i]);
										FileReader fi;
										BufferedReader in;
										try {
											fi = new FileReader(s);
											in = new BufferedReader(fi);
											String c = "";
											int k = 0;

											while ((c = in.readLine()) != null) {
												String str[] = c.split(" ");
												switch (k) {
												case 1:
													PBL.cal_Americano += Integer.parseInt(str[4]);
													k++;
													break;
												case 2:
													PBL.cal_Frappe += Integer.parseInt(str[4]);
													k++;
													break;
												case 3:
													PBL.cal_CafeLatte += Integer.parseInt(str[4]);
													k++;
													break;
												case 4:
													PBL.cal_Capuccino += Integer.parseInt(str[4]);
													k++;
													break;
												case 5:
													PBL.cal_Express += Integer.parseInt(str[4]);
													k++;
													break;
												case 6:
													PBL.cal_IceTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 7:
													PBL.cal_LemonAdes += Integer.parseInt(str[4]);
													k++;
													break;
												case 8:
													PBL.cal_MilkTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 9:
													PBL.cal_Affogato += Integer.parseInt(str[4]);
													k++;
													break;
												case 11:
													PBL.cal_card += Integer.parseInt(str[3]);
													k++;
													break;
												case 12:
													PBL.cal_money += Integer.parseInt(str[3]);
													k++;
													break;
												default:
													k++;
												}
											}

											in.close();
											fi.close();
										} catch (IOException a) {
											System.out.println(a.getMessage());
										}
									}

								}

							}
							dispose();
							new Frame();
						}
					});
				}
			});

			달.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					달.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					달.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();

					confirm.setVisible(false);
					year_Text.setVisible(false);
					year_Label.setVisible(false);
					month_Text.setVisible(false);
					month_Label.setVisible(false);
					day_Text.setVisible(false);
					day_Label.setVisible(false);
					half.setVisible(false);
					quarter.setVisible(false);

					year_Text.setBounds(130, 340, 80, 30);
					year_Text.setVisible(true);
					year_Label.setBounds(215, 340, 30, 30);
					year_Label.setVisible(true);
					month_Text.setBounds(255, 340, 50, 30);
					month_Text.setVisible(true);
					month_Label.setBounds(310, 340, 30, 30);
					month_Label.setVisible(true);

					confirm.setBounds(350, 340, 70, 30);
					confirm.setVisible(true);

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

							File f = new File("C:\\Java Cafe");
							String filenames[] = f.list();
							for (int i = 0; i < filenames.length; i++) {
								int n = half.getSelectedIndex();
								String st[] = filenames[i].split("\\.");
								if (n == 0) {
									if (year_Text.getText().equals(st[0]) && month_Text.getText().equals(st[1])) {
										File s = new File("C:\\Java Cafe\\" + filenames[i]);
										FileReader fi;
										BufferedReader in;
										try {
											fi = new FileReader(s);
											in = new BufferedReader(fi);
											String c = "";
											int k = 0;

											while ((c = in.readLine()) != null) {
												String str[] = c.split(" ");
												switch (k) {
												case 1:
													PBL.cal_Americano += Integer.parseInt(str[4]);
													k++;
													break;
												case 2:
													PBL.cal_Frappe += Integer.parseInt(str[4]);
													k++;
													break;
												case 3:
													PBL.cal_CafeLatte += Integer.parseInt(str[4]);
													k++;
													break;
												case 4:
													PBL.cal_Capuccino += Integer.parseInt(str[4]);
													k++;
													break;
												case 5:
													PBL.cal_Express += Integer.parseInt(str[4]);
													k++;
													break;
												case 6:
													PBL.cal_IceTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 7:
													PBL.cal_LemonAdes += Integer.parseInt(str[4]);
													k++;
													break;
												case 8:
													PBL.cal_MilkTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 9:
													PBL.cal_Affogato += Integer.parseInt(str[4]);
													k++;
													break;
												case 11:
													PBL.cal_card += Integer.parseInt(str[3]);
													k++;
													break;
												case 12:
													PBL.cal_money += Integer.parseInt(str[3]);
													k++;
													break;
												default:
													k++;
												}
											}

											in.close();
											fi.close();
										} catch (IOException a) {
											System.out.println(a.getMessage());
										}
									}
								}

							}
							dispose();
							new Frame();
						}
					});
				}
			});

			일.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					일.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				public void mouseExited(MouseEvent e) {
					일.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				public void mousePressed(MouseEvent e) {
					CafeMusic buttonEnteredMusic = new CafeMusic("buttonMusic.mp3", false);
					buttonEnteredMusic.start();

					confirm.setVisible(false);
					year_Text.setVisible(false);
					year_Label.setVisible(false);
					month_Text.setVisible(false);
					month_Label.setVisible(false);
					day_Text.setVisible(false);
					day_Label.setVisible(false);
					half.setVisible(false);
					quarter.setVisible(false);

					year_Text.setBounds(130, 410, 70, 30);
					year_Text.setVisible(true);
					year_Label.setBounds(205, 410, 15, 30);
					year_Label.setVisible(true);
					month_Text.setBounds(225, 410, 40, 30);
					month_Text.setVisible(true);
					month_Label.setBounds(270, 410, 15, 30);
					month_Label.setVisible(true);
					day_Text.setBounds(290, 410, 40, 30);
					day_Text.setVisible(true);
					day_Label.setBounds(335, 410, 15, 30);
					day_Label.setVisible(true);

					confirm.setBounds(360, 410, 70, 30);
					confirm.setVisible(true);

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

							File f = new File("C:\\Java Cafe");
							String filenames[] = f.list();
							for (int i = 0; i < filenames.length; i++) {
								int n = half.getSelectedIndex();
								String st[] = filenames[i].split("\\.");
								if (n == 0) {
									if (year_Text.getText().equals(st[0]) && month_Text.getText().equals(st[1])
											&& day_Text.getText().equals(st[2])) {
										File s = new File("C:\\Java Cafe\\" + filenames[i]);
										FileReader fi;
										BufferedReader in;
										try {
											fi = new FileReader(s);
											in = new BufferedReader(fi);
											String c = "";
											int k = 0;

											while ((c = in.readLine()) != null) {
												String str[] = c.split(" ");
												switch (k) {
												case 1:
													PBL.cal_Americano += Integer.parseInt(str[4]);
													k++;
													break;
												case 2:
													PBL.cal_Frappe += Integer.parseInt(str[4]);
													k++;
													break;
												case 3:
													PBL.cal_CafeLatte += Integer.parseInt(str[4]);
													k++;
													break;
												case 4:
													PBL.cal_Capuccino += Integer.parseInt(str[4]);
													k++;
													break;
												case 5:
													PBL.cal_Express += Integer.parseInt(str[4]);
													k++;
													break;
												case 6:
													PBL.cal_IceTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 7:
													PBL.cal_LemonAdes += Integer.parseInt(str[4]);
													k++;
													break;
												case 8:
													PBL.cal_MilkTea += Integer.parseInt(str[4]);
													k++;
													break;
												case 9:
													PBL.cal_Affogato += Integer.parseInt(str[4]);
													k++;
													break;
												case 11:
													PBL.cal_card += Integer.parseInt(str[3]);
													k++;
													break;
												case 12:
													PBL.cal_money += Integer.parseInt(str[3]);
													k++;
													break;
												default:
													k++;
												}
											}

											in.close();
											fi.close();
										} catch (IOException a) {
											System.out.println(a.getMessage());
										}
									}
								}

							}
							dispose();
							new Frame();
						}
					});
				}
			});

			add(년도);
			add(반기);
			add(분기);
			add(달);
			add(일);
			add(confirm);
			add(year_Text);
			add(year_Label);
			add(month_Text);
			add(month_Label);
			add(day_Text);
			add(day_Label);
			add(half);
			add(quarter);
		}
	}
}
