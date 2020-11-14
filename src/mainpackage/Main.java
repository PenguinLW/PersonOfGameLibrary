package mainpackage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;

public class Main extends JFrame {
	private JPanel[] jpnl = new JPanel[3];
	private GridBagConstraints pen, gbc, cil;
	private JButton[] jbtn = new JButton[2];
	private JLabel[] jlbl = new JLabel[7];
	private JPanel[] auxp = new JPanel[3];
	private GridBagConstraints[] auxc = new GridBagConstraints[auxp.length];
	private int index, count_of_person;
	private BufferedReader input, person;
	
	public Main() {
		initComponents();
	}
	private void initComponents() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Person's of game library");
		this.setLayout(new GridBagLayout());
		pen = new GridBagConstraints();
		pen.fill = GridBagConstraints.BOTH;
		pen.insets = new Insets(2,2,2,2);
//init comp
		index = 1;
		count_of_person = getCountOfPerson();
		for(int i = 0; i <= jpnl.length-1; i++) {
			jpnl[i] = new JPanel();
		}
		for(int i = 0; i <= jbtn.length-1; i++) {
			jbtn[i] = new JButton("", new ImageIcon( this.getClass().getResource("img/"+(i == 0 ? "back" : "next")+".png")) );
			jbtn[i].setOpaque(false);
			jbtn[i].setContentAreaFilled(false);
			jbtn[i].setBorderPainted(false);
			jbtn[i].addActionListener(new ButList());
		}
		for(int i = 0; i <= jlbl.length-1; i++) {
			jlbl[i] = new JLabel();
		}
		gbc = new GridBagConstraints();
		cil = new GridBagConstraints();
		for(int i = 0; i <= auxp.length-1; i++) {
			auxp[i] = new JPanel();
			auxc[i] = new GridBagConstraints();
		}
//end init
//set comp
		jpnl[0].setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(2,2,2,2);
		
		jpnl[0].setPreferredSize(new Dimension(750,350));
		jpnl[0].setBackground(Color.GRAY);
		jpnl[1].setPreferredSize(new Dimension(725,325));
		jpnl[1].setBackground(Color.BLACK);
		
		jpnl[1].setLayout(new GridBagLayout());
		cil.fill = GridBagConstraints.BOTH;
		cil.insets = new Insets(2,2,2,2);
		
		auxp[0].setLayout(new GridBagLayout());
		auxc[0].fill = GridBagConstraints.BOTH;
		auxc[0].insets = new Insets(2,2,2,2);
		auxc[0].gridx = 0;
		auxc[0].gridy = 0;
		auxp[0].add(jlbl[3],auxc[0]);
		auxc[0].gridx = 1;
		auxc[0].gridy = 0;
		auxp[0].add(jlbl[4],auxc[0]);
		auxc[0].gridx = 2;
		auxc[0].gridy = 0;
		auxp[0].add(jlbl[5],auxc[0]);
		auxc[0].gridx = 3;
		auxc[0].gridy = 0;
		auxp[0].add(jlbl[6],auxc[0]);
		auxp[0].setBackground(Color.BLACK);
		
		auxp[1].setLayout(new GridBagLayout());
		auxc[1].fill = GridBagConstraints.BOTH;
		auxc[1].insets = new Insets(2,2,2,2);
		auxc[1].gridx = 0;
		auxc[1].gridy = 0;
		auxp[1].add(jlbl[2],auxc[1]);
		auxc[1].gridx = 0;
		auxc[1].gridy = 1;
		auxp[1].add(auxp[0],auxc[1]);
		auxp[1].setBackground(Color.BLACK);
		
		auxp[2].setLayout(new GridBagLayout());
		auxc[2].fill = GridBagConstraints.BOTH;
		auxc[2].insets = new Insets(2,2,2,2);
		auxc[2].gridx = 0;
		auxc[2].gridy = 0;
		auxp[2].add(jlbl[1],auxc[2]);
		auxc[2].gridx = 1;
		auxc[2].gridy = 0;
		auxp[2].add(auxp[1],auxc[2]);
		auxp[2].setPreferredSize(new Dimension(480,220));
		auxp[2].setBackground(Color.BLACK);
		
		jlbl[0].setPreferredSize(new Dimension(480,80));//240,40));
		jlbl[0].setIcon(new ImageIcon(	this.getClass().getResource("img/name.png")	));//имя-240:40 | 480:80
		jlbl[0].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jlbl[0].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
//		jlbl[1].setPreferredSize(new Dimension(80,80));
		//фото-80:80 | 160:160
//		jlbl[1].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//		jlbl[1].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		jlbl[2].setPreferredSize(new Dimension(320,80));//160,40));
		jlbl[2].setIcon(new ImageIcon(	this.getClass().getResource("img/endurance.png")	));//выносливость-160:40 | 320:80
		jlbl[2].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jlbl[2].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		jlbl[3].setPreferredSize(new Dimension(80,80));//40,40));
		jlbl[3].setIcon(new ImageIcon(	this.getClass().getResource("img/gold.png")	));//золото-40:40 | 80:80
		jlbl[3].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jlbl[3].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		jlbl[4].setPreferredSize(new Dimension(80,80));//40,40));
		jlbl[4].setIcon(new ImageIcon(	this.getClass().getResource("img/height.png")	));//рост-40:40 | 80:80
		jlbl[4].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jlbl[4].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		jlbl[5].setPreferredSize(new Dimension(80,80));//40,40));
		jlbl[5].setIcon(new ImageIcon(	this.getClass().getResource("img/weight.png")	));//вес-40:40 | 80:80
		jlbl[5].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jlbl[5].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		jlbl[6].setPreferredSize(new Dimension(80,80));//40,40));
		jlbl[6].setIcon(new ImageIcon(	this.getClass().getResource("img/rapidity.png")	));//скорость-40:40 | 80:80
		jlbl[6].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jlbl[6].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		showStatus(index);
		cil.gridx = 0;
		cil.gridy = 0;
		jpnl[1].add(jlbl[0],cil);
		cil.gridx = 0;
		cil.gridy = 1;
		jpnl[1].add(auxp[2],cil);
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		jpnl[0].add(jpnl[1],gbc);
		
		jpnl[2].setBackground(Color.BLACK);
		jpnl[2].add(jbtn[0],gbc);
		jpnl[2].add(jpnl[0],pen);
		jpnl[2].add(jbtn[1],gbc);
//end set
		pen.gridx = 0;
		pen.gridy = 0;
		this.add(jpnl[2],pen);
		
		this.getContentPane().setBackground(Color.BLACK);
		this.setIconImage((new ImageIcon(this.getClass().getResource("img/symb.png"))).getImage());
		
		this.setSize(new Dimension(950,450));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	private int getCountOfPerson() {
		String str = "";
		int count = 0;
		try {
			person = new BufferedReader(new FileReader("library/list_of_person/list.txt"));
			while((str=person.readLine()) != null) {
				if(str.equals("#"+(count+1))) {
					count++;
				}
			}
			
		} catch(IOException exc) {
			
		}
		
		return count;
	}
	private String getStatus(int index) {
		String rez = "";
		String str = "";
		int count = 0;
		try {
			input = new BufferedReader(new FileReader("library/list_of_person/list.txt"));
			while((str=input.readLine()) != null) {
				if(str.equals("#"+index)) {
					while(count <= 6) {
						rez += input.readLine();
						rez += "\n";
						count++;
					}
				}
				count = 0;
			}
			
		} catch(IOException exc) {
			
		}
		return rez;
	}
	private void showStatus(int index) {
		int k = 0, n = 0;
		String person, str = "";
		person = getStatus(index);
		while(k <= person.length()-1 && n <= jlbl.length-1) {
			while((person.charAt(k)) != '\n') {
				str += person.charAt(k);
				k++;
			}
			if(n != 1) {
				jlbl[n].setText(""+str);
			} else {
				jlbl[n].setIcon(new ImageIcon(""+str));//фото-80:80 | 160:160
			}
			n++;
			str = "";
			k++;
			
		}
	}
	private class ButList implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if( (e.getSource()).equals(jbtn[0]) ) {
				showStatus( index > 1 ? --index : index);
			}
			if( (e.getSource()).equals(jbtn[1]) ) {
				showStatus( index < count_of_person ? ++index : index);
			}
		}
	}
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
/*
	javac -d bin -sourcepath src src/mainpackage/Main.java
	java -classpath bin mainpackage.Main
*/
