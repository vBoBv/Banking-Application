package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class HomeUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmountTo;
	private JTextField txtDescription;
	private JTextField txtTodayDate;
	private JTextField txtDepositAmount;
	private JTextField txtDepositDescription;
	private JTextField txtWithdrawAmount;
	private JTextField txtWithdrawDescription;
	private JSpinner spinnerDepositTo;
	private JButton btnDepositTo;
	private JLabel lblCustomerId;
	private JLabel lblId;
	private JButton btnWithdrawFrom;
	private JSpinner spinnerWithdrawFrom;
	
	private JLabel lblMainBalance;
	private JLabel lblSavingBalance;
	private JLabel lblSeriousBalance;
	private JButton btnAccount;
	
	private JLabel lblNameValue;
	private JLabel lblIdValue;
	private JButton btnLogOut;
	
	private JSpinner SpinnerFrom;
	private JSpinner SpinnerTo;
	private JButton btnTransferPanel;
	
	public JTextField getTxtTodayDate() {
		return txtTodayDate;
	}

	public JSpinner getSpinnerFrom() {
		return SpinnerFrom;
	}

	public void setSpinnerFrom(JSpinner spinnerFrom) {
		SpinnerFrom = spinnerFrom;
	}

	public JSpinner getSpinnerTo() {
		return SpinnerTo;
	}

	public void setSpinnerTo(JSpinner spinnerTo) {
		SpinnerTo = spinnerTo;
	}

	public JButton getBtnTransferPanel() {
		return btnTransferPanel;
	}

	public void setBtnTransferPanel(JButton btnTransferPanel) {
		this.btnTransferPanel = btnTransferPanel;
	}

	public void setTxtAmountTo(JTextField txtAmountTo) {
		this.txtAmountTo = txtAmountTo;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JLabel getLblNameValue() {
		return lblNameValue;
	}

	public JLabel getLblIdValue() {
		return lblIdValue;
	}

	public JButton getBtnAccount() {
		return btnAccount;
	}

	public JLabel getLblMainBalance() {
		return lblMainBalance;
	}

	public JLabel getLblSavingBalance() {
		return lblSavingBalance;
	}

	public JLabel getLblSeriousBalance() {
		return lblSeriousBalance;
	}

	public JSpinner getSpinnerWithdrawFrom() {
		return spinnerWithdrawFrom;
	}

	public JButton getBtnWithdrawFrom() {
		return btnWithdrawFrom;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public JLabel getLblCustomerId() {
		return lblCustomerId;
	}

	public JLabel getLblCustomerNumber() {
		return lblCustomerId;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTxtAmountTo() {
		return txtAmountTo;
	}

	public JTextField getTxtDescription() {
		return txtDescription;
	}

	public JTextField getLblTodayDate() {
		return txtTodayDate;
	}

	public JTextField getTxtDepositAmount() {
		return txtDepositAmount;
	}

	public JTextField getTxtDepositDescription() {
		return txtDepositDescription;
	}

	public JTextField getTxtWithdrawAmount() {
		return txtWithdrawAmount;
	}

	public JTextField getTxtWithdrawDescription() {
		return txtWithdrawDescription;
	}

	public JSpinner getSpinnerDepositTo() {
		return spinnerDepositTo;
	}

	public JButton getBtnDepositTo() {
		return btnDepositTo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUI frame = new HomeUI();
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
	public HomeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(Color.LIGHT_GRAY);
		header.setBounds(0, 0, 480, 55);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel lblAccounts = new JLabel("Accounts");
		lblAccounts.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAccounts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccounts.setBounds(0, 13, 480, 29);
		header.add(lblAccounts);
		
		JPanel footer = new JPanel();
		footer.setLayout(null);
		footer.setBackground(Color.LIGHT_GRAY);
		footer.setBounds(0, 561, 480, 55);
		contentPane.add(footer);

		
		JPanel main = new JPanel();
		main.setBounds(0, 56, 480, 505);
		contentPane.add(main);
		main.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 480, 505);
		main.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel homePanel = new JPanel();
		layeredPane.add(homePanel, "name_198307436532320");
		homePanel.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerName.setBounds(58, 220, 146, 16);
		homePanel.add(lblCustomerName);
		
		JLabel lblCustomerIdNumber = new JLabel("Customer Id Number:");
		lblCustomerIdNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerIdNumber.setBounds(58, 250, 146, 16);
		homePanel.add(lblCustomerIdNumber);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(Color.GRAY);
		btnLogOut.setBounds(193, 301, 97, 25);
		homePanel.add(btnLogOut);
		
		lblNameValue = new JLabel("Customer Name:");
		lblNameValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameValue.setBounds(264, 220, 146, 16);
		homePanel.add(lblNameValue);
		
		lblIdValue = new JLabel("Customer Id Number:");
		lblIdValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdValue.setBounds(264, 250, 146, 16);
		homePanel.add(lblIdValue);
		
		JLabel lblAppName = new JLabel("anking Application");
		lblAppName.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppName.setBounds(46, 13, 422, 141);
		homePanel.add(lblAppName);
		
		JLabel lblNewLabel = new JLabel("B");
		lblNewLabel.setFont(new Font("UD Digi Kyokasho NP-B", Font.PLAIN, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 13, 41, 141);
		homePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("By Ponhvath Vann");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 476, 480, 16);
		homePanel.add(lblNewLabel_1);
		
		JPanel accountsPanel = new JPanel();
		layeredPane.add(accountsPanel, "name_494394849704833");
		accountsPanel.setLayout(null);
		
		JPanel mainAcc = new JPanel();
		mainAcc.setBackground(Color.LIGHT_GRAY);
		mainAcc.setBounds(81, 24, 320, 131);
		accountsPanel.add(mainAcc);
		mainAcc.setLayout(null);
		
		JLabel lblMain = new JLabel("Main");
		lblMain.setBounds(146, 5, 27, 16);
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		mainAcc.add(lblMain);
		
		lblMainBalance = new JLabel("$0.00");
		lblMainBalance.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMainBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainBalance.setBounds(0, 44, 320, 25);
		mainAcc.add(lblMainBalance);
		
		
		
		JPanel savingAcc = new JPanel();
		savingAcc.setBackground(Color.LIGHT_GRAY);
		savingAcc.setBounds(81, 168, 320, 131);
		accountsPanel.add(savingAcc);
		savingAcc.setLayout(null);
		
		JLabel lblSaving = new JLabel("Saving");
		lblSaving.setBounds(141, 5, 38, 16);
		savingAcc.add(lblSaving);
		
		lblSavingBalance = new JLabel("$0.00");
		lblSavingBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingBalance.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSavingBalance.setBounds(0, 48, 320, 25);
		savingAcc.add(lblSavingBalance);
		
		
		
		
		
		JPanel seriousSavingAcc = new JPanel();
		seriousSavingAcc.setBackground(Color.LIGHT_GRAY);
		seriousSavingAcc.setBounds(81, 312, 320, 131);
		accountsPanel.add(seriousSavingAcc);
		seriousSavingAcc.setLayout(null);
		
		JLabel lblSeriousSaving = new JLabel("Serious Saving");
		lblSeriousSaving.setBounds(117, 5, 85, 16);
		seriousSavingAcc.add(lblSeriousSaving);
		
		lblSeriousBalance = new JLabel("$0.00");
		lblSeriousBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeriousBalance.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSeriousBalance.setBounds(0, 44, 320, 25);
		seriousSavingAcc.add(lblSeriousBalance);
		
		
		
		lblCustomerId = new JLabel("Customer ID Number :");
		lblCustomerId.setForeground(Color.LIGHT_GRAY);
		lblCustomerId.setBackground(Color.LIGHT_GRAY);
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setBounds(0, 456, 480, 16);
		accountsPanel.add(lblCustomerId);
		
		lblId = new JLabel("id");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setBackground(Color.LIGHT_GRAY);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(0, 476, 480, 16);
		accountsPanel.add(lblId);
		
		JPanel transferPanel = new JPanel();
		layeredPane.add(transferPanel, "name_494513101293348");
		transferPanel.setLayout(null);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setBounds(55, 45, 80, 29);
		transferPanel.add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(341, 45, 80, 29);
		transferPanel.add(lblTo);
		
		SpinnerFrom = new JSpinner();
		SpinnerFrom.setBackground(Color.LIGHT_GRAY);
		SpinnerFrom.setModel(new SpinnerListModel(new String[] {"Main", "Saving", "Serious Saving"}));
		SpinnerFrom.setBounds(26, 87, 145, 29);
		transferPanel.add(SpinnerFrom);
		
		SpinnerTo = new JSpinner();
		SpinnerTo.setModel(new SpinnerListModel(new String[] {"Main", "Saving", "Serious Saving"}));
		SpinnerTo.setBackground(Color.LIGHT_GRAY);
		SpinnerTo.setBounds(307, 87, 145, 29);
		transferPanel.add(SpinnerTo);
		
		JLabel lblRightArrow = new JLabel("");
		lblRightArrow.setIcon(new ImageIcon(HomeUI.class.getResource("/rightArrow.png")));
		lblRightArrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblRightArrow.setBounds(212, 93, 56, 16);
		transferPanel.add(lblRightArrow);
		
		JLabel lblAmountTo = new JLabel("Amount:");
		lblAmountTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountTo.setBounds(114, 174, 80, 29);
		transferPanel.add(lblAmountTo);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(106, 222, 80, 29);
		transferPanel.add(lblDescription);
		
		txtAmountTo = new JTextField();
		txtAmountTo.setBounds(222, 177, 150, 22);
		transferPanel.add(txtAmountTo);
		txtAmountTo.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(222, 225, 150, 22);
		transferPanel.add(txtDescription);
		txtDescription.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(128, 272, 72, 29);
		transferPanel.add(lblDate);
		
		txtTodayDate = new JTextField();
		txtTodayDate.setBackground(Color.WHITE);
		txtTodayDate.setEditable(false);
		txtTodayDate.setColumns(10);
		txtTodayDate.setBounds(222, 275, 150, 22);
		transferPanel.add(txtTodayDate);
		
		btnTransferPanel = new JButton("Transfer");
		btnTransferPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTransferPanel.setBackground(Color.LIGHT_GRAY);
		btnTransferPanel.setBounds(257, 320, 97, 25);
		transferPanel.add(btnTransferPanel);
		
		JPanel depositPanel = new JPanel();
		layeredPane.add(depositPanel, "name_494522781661989");
		depositPanel.setLayout(null);
		
		JLabel lblDepositToAccount = new JLabel("To : ");
		lblDepositToAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepositToAccount.setBounds(80, 57, 65, 31);
		depositPanel.add(lblDepositToAccount);
		
		spinnerDepositTo = new JSpinner();
		spinnerDepositTo.setModel(new SpinnerListModel(new String[] {"Main", "Saving", "Serious Saving"}));
		spinnerDepositTo.setBounds(190, 57, 192, 31);
		depositPanel.add(spinnerDepositTo);
		
		JLabel lblDepositAmount = new JLabel("Amount :");
		lblDepositAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepositAmount.setBounds(80, 109, 65, 31);
		depositPanel.add(lblDepositAmount);
		
		txtDepositAmount = new JTextField();
		txtDepositAmount.setBounds(190, 109, 192, 31);
		depositPanel.add(txtDepositAmount);
		txtDepositAmount.setColumns(10);
		
		JLabel lblDepositDescription = new JLabel("Description :");
		lblDepositDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepositDescription.setBounds(57, 165, 88, 31);
		depositPanel.add(lblDepositDescription);
		
		txtDepositDescription = new JTextField();
		txtDepositDescription.setColumns(10);
		txtDepositDescription.setBounds(190, 165, 192, 31);
		depositPanel.add(txtDepositDescription);
		
		btnDepositTo = new JButton("Deposit");
		btnDepositTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDepositTo.setBackground(Color.LIGHT_GRAY);
		btnDepositTo.setBounds(239, 222, 97, 25);
		depositPanel.add(btnDepositTo);
		
		JPanel withdrawPanel = new JPanel();
		layeredPane.add(withdrawPanel, "name_497875154538863");
		withdrawPanel.setLayout(null);
		
		JLabel lblWithdrawFrom = new JLabel("From :");
		lblWithdrawFrom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWithdrawFrom.setBounds(80, 57, 65, 31);
		withdrawPanel.add(lblWithdrawFrom);
		
		spinnerWithdrawFrom = new JSpinner();
		spinnerWithdrawFrom.setModel(new SpinnerListModel(new String[] {"Main", "Saving", "Serious Saving"}));
		spinnerWithdrawFrom.setBounds(190, 57, 192, 31);
		withdrawPanel.add(spinnerWithdrawFrom);
		
		JLabel lblWithdrawAmount = new JLabel("Amount :");
		lblWithdrawAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWithdrawAmount.setBounds(80, 109, 65, 31);
		withdrawPanel.add(lblWithdrawAmount);
		
		txtWithdrawAmount = new JTextField();
		txtWithdrawAmount.setColumns(10);
		txtWithdrawAmount.setBounds(190, 109, 192, 31);
		withdrawPanel.add(txtWithdrawAmount);
		
		JLabel lblWithdrawDescription = new JLabel("Description :");
		lblWithdrawDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWithdrawDescription.setBounds(57, 165, 88, 31);
		withdrawPanel.add(lblWithdrawDescription);
		
		txtWithdrawDescription = new JTextField();
		txtWithdrawDescription.setColumns(10);
		txtWithdrawDescription.setBounds(190, 165, 192, 31);
		withdrawPanel.add(txtWithdrawDescription);
		
		btnWithdrawFrom = new JButton("Withdraw");
		btnWithdrawFrom.setBackground(Color.LIGHT_GRAY);
		btnWithdrawFrom.setBounds(239, 222, 97, 25);
		withdrawPanel.add(btnWithdrawFrom);
		
		JPanel mainDetails = new JPanel();
		layeredPane.add(mainDetails, "name_495151309015368");
		mainDetails.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(54, 13, 369, 122);
		mainDetails.add(panel);
		panel.setLayout(null);
		
		JLabel lblMainAccountNumber = new JLabel("Account Number");
		lblMainAccountNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblMainAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainAccountNumber.setBounds(0, 0, 369, 29);
		panel.add(lblMainAccountNumber);
		
		JLabel lblMainBalancePanel = new JLabel("$0.00");
		lblMainBalancePanel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMainBalancePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainBalancePanel.setBounds(0, 30, 369, 66);
		panel.add(lblMainBalancePanel);
		
		JLabel lblMainAccountName = new JLabel("Main");
		lblMainAccountName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainAccountName.setBounds(0, 93, 369, 29);
		panel.add(lblMainAccountName);
		
		JLabel lblTransaction = new JLabel("Transaction History");
		lblTransaction.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setBounds(0, 165, 480, 30);
		mainDetails.add(lblTransaction);
		
		JPanel savingDetails = new JPanel();
		layeredPane.add(savingDetails, "name_496034970318184");
		savingDetails.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(54, 13, 369, 122);
		savingDetails.add(panel_2);
		
		JLabel lblSavingAccountNumber = new JLabel("Account Number");
		lblSavingAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingAccountNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblSavingAccountNumber.setBounds(0, 0, 369, 29);
		panel_2.add(lblSavingAccountNumber);
		
		JLabel lblSavingAccountBalancePanel = new JLabel("$0.00");
		lblSavingAccountBalancePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingAccountBalancePanel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSavingAccountBalancePanel.setBounds(0, 30, 369, 66);
		panel_2.add(lblSavingAccountBalancePanel);
		
		JLabel lblSavingAccountName = new JLabel("Saving");
		lblSavingAccountName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavingAccountName.setBounds(0, 93, 369, 29);
		panel_2.add(lblSavingAccountName);
		
		JLabel lblTransactionHistory = new JLabel("Transaction History");
		lblTransactionHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionHistory.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblTransactionHistory.setBounds(0, 165, 480, 30);
		savingDetails.add(lblTransactionHistory);
		
		JPanel seriousSavingDetails = new JPanel();
		layeredPane.add(seriousSavingDetails, "name_496360876593620");
		seriousSavingDetails.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(54, 13, 369, 122);
		seriousSavingDetails.add(panel_3);
		
		JLabel lblSeriousAccountNumber = new JLabel("Account Number");
		lblSeriousAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeriousAccountNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblSeriousAccountNumber.setBounds(0, 0, 369, 29);
		panel_3.add(lblSeriousAccountNumber);
		
		JLabel lblSeriousBalancePanel = new JLabel("$0.00");
		lblSeriousBalancePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeriousBalancePanel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSeriousBalancePanel.setBounds(0, 30, 369, 66);
		panel_3.add(lblSeriousBalancePanel);
		
		JLabel lblAccountSeriousName = new JLabel("Serious Saving");
		lblAccountSeriousName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountSeriousName.setBounds(0, 93, 369, 29);
		panel_3.add(lblAccountSeriousName);
		
		JLabel label_3 = new JLabel("Transaction History");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		label_3.setBounds(0, 165, 480, 30);
		seriousSavingDetails.add(label_3);
		
		
		btnAccount = new JButton("Accounts");
		btnAccount.setBackground(Color.LIGHT_GRAY);
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(accountsPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnAccount.setBounds(96, 0, 97, 55);
		footer.add(btnAccount);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(transferPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnTransfer.setBackground(Color.LIGHT_GRAY);
		btnTransfer.setBounds(192, 0, 97, 55);
		footer.add(btnTransfer);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(depositPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnDeposit.setBackground(Color.LIGHT_GRAY);
		btnDeposit.setBounds(288, 0, 97, 55);
		footer.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(withdrawPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnWithdraw.setBackground(Color.LIGHT_GRAY);
		btnWithdraw.setBounds(383, 0, 97, 55);
		footer.add(btnWithdraw);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 0, 97, 55);
		footer.add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(homePanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnHome.setBackground(Color.LIGHT_GRAY);
		
		JButton btnMainDetails = new JButton("View Details");
		btnMainDetails.setEnabled(false);
		btnMainDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(mainDetails);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnMainDetails.setForeground(Color.WHITE);
		btnMainDetails.setBackground(Color.GRAY);
		btnMainDetails.setBounds(97, 93, 124, 25);
		mainAcc.add(btnMainDetails);
		
		JButton btnSavingDetails = new JButton("View Details");
		btnSavingDetails.setEnabled(false);
		btnSavingDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(savingDetails);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSavingDetails.setBackground(Color.GRAY);
		btnSavingDetails.setForeground(Color.WHITE);
		btnSavingDetails.setBounds(97, 93, 124, 25);
		savingAcc.add(btnSavingDetails);
		
		JButton btnSeriousDetails = new JButton("View Details");
		btnSeriousDetails.setEnabled(false);
		btnSeriousDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(seriousSavingDetails);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSeriousDetails.setForeground(Color.WHITE);
		btnSeriousDetails.setBackground(Color.GRAY);
		btnSeriousDetails.setBounds(95, 93, 124, 25);
		seriousSavingAcc.add(btnSeriousDetails);
	}
}
