package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class Chiff {

	private JFrame frmChiffrement;
	private JTextField textField;
	private JTextField txtRsultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chiff window = new Chiff();
					window.frmChiffrement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chiff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChiffrement = new JFrame();
		frmChiffrement.setTitle("Chiffrement");
		frmChiffrement.setBounds(100, 100, 450, 197);
		frmChiffrement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frmChiffrement.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("cl\u00E9 :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 44, 27, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("cl\u00E9 s\u00E9lectionn\u00E9e :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 72, 109, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(129, 72, 295, 14);
		panel.add(lblNewLabel_4);
		String cle2="147852369";
		lblNewLabel_4.setText(cle2);
		
		textField = new JTextField();
		textField.setBounds(76, 41, 249, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cle2 = textField.getText();
				lblNewLabel_4.setText(cle2);				
			}
		});
		btnNewButton_1.setBounds(335, 40, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Texte (Uniquement  les caract\u00E8re ASCII de 0 \u00E0 127)");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 100, 285, 14);
		panel.add(lblNewLabel_2);
		
		txtRsultat = new JTextField();
		txtRsultat.setText("");
		txtRsultat.setBounds(20, 125, 404, 23);
		panel.add(txtRsultat);
		txtRsultat.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Chiffre");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//chiffre
				
				String cle = lblNewLabel_4.getText();
				String text = txtRsultat.getText();
				txtRsultat.setText("");
				int lengeText = 0, lengeCle = 0;
				String resulta = "";
				lengeText = text.length();
				lengeCle = cle.length();
				String cleLengStatique = cle;
				String str2 = null;
				
				while (lengeText > lengeCle) {
					cle = cle + cleLengStatique;
					lengeCle = cle.length();
					
				}
				

					for (int i = 0; i <= lengeText - 1; i++) {
						char charVarText = text.charAt(i);
						char charVarCle = cle.charAt(i);
						int intResult = charVarText + charVarCle;
						if (intResult<16) {
							str2 = Integer.toHexString(intResult).toUpperCase();
							str2 = "0"+str2;
						}else {
							str2 = Integer.toHexString(intResult).toUpperCase();
						}
						resulta = resulta + str2;
						
					}
					txtRsultat.setText(resulta);
					
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(230, 11, 194, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("D\u00E9chiffre");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dechiffre
				
				String cle = lblNewLabel_4.getText();
				String text = txtRsultat.getText();
				txtRsultat.setText("");
				int lengeText = 0, lengeCle = 0;
				String resulta = "";
				lengeText = text.length();
				lengeCle = cle.length();
				String cleLengStatique = cle;
				
				while (lengeText > lengeCle) {
					cle = cle + cleLengStatique;
					lengeCle = cle.length();
				}
				

					String strTempcarac = "";
					String strTempcarac2 = "";
					int incrementest=0;
					int tempInt=0;
					int panplemousse=0;
					for (int i = 0; i <= lengeText - 1; i++) {
						char charVarText = text.charAt(i);									
						if(incrementest==1) {
							incrementest=0;
							strTempcarac = String.valueOf(charVarText);
							strTempcarac2=strTempcarac2+strTempcarac;
							//System.out.println(strTempcarac2);
							tempInt = Integer.parseInt(strTempcarac2, 16);
							//System.out.println("tempInt " + tempInt);
							int intVarCle = cle.charAt(panplemousse);
							panplemousse++;
							//System.out.println("intVarCle " + intVarCle+" panplemousse "+panplemousse);
							int intResult = tempInt - intVarCle;
							//System.out.println("intResult " + intResult);
							char charVarResult = (char) intResult;					
							resulta = resulta +charVarResult;
							strTempcarac = "";
							strTempcarac2="";
							tempInt=0;
						}else {
							incrementest++;
							strTempcarac = String.valueOf(charVarText);
							strTempcarac2=strTempcarac2+strTempcarac;
						}
					}
					txtRsultat.setText(resulta);
			}
		});
		btnNewButton.setBounds(10, 11, 194, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();
				String str="";
				for(int i = 0 ; i < 20 ; i++){
				  char c = (char)(rand.nextInt(93) + 33);
				  str += c;
				}
				textField.setText(str);
				
				
			}
		});
		btnNewButton_3.setBounds(10, 43, 19, 20);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("-1.1-");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(391, 97, 33, 14);
		panel.add(lblNewLabel_3);
		
	
		
		
		
			
		
	}
}
