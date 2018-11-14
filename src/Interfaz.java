/*
 * Programa: "Programa de Cifrado Caesar"
 * 	Es un programa con pantalla gráfica para codificar y de decodificar mensajes en cifrado caesar.
 * La pantalla de este programa esta modelada con conceptos de proyectos pasados . 
 * Este programa usa una clase auxiliar llamado EnciptadoCaesar, el cual contiene los metodos actuales
 * de cifrado.
 * 
 * Creado por: Luis Fernando Lomelín Ibarra
 * 
 * */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.StringTokenizer;
public class Interfaz extends JFrame {
	JTextArea IN= new JTextArea();
	JTextArea OUT= new JTextArea();
	JTextField DIS= new JTextField();
	JButton CONVERTIR= new JButton("Convertir");
	String NUM="QWERTYUIOPASDFGHJKLÑZXCVBNM<>,.-{}´+\\!\"#$%&/()=[]}^``_-.,:;'?¡¿+*~´¨";
	StringTokenizer TOK;
	CheckboxGroup TIPO= new CheckboxGroup();
	Checkbox CODE= new Checkbox("Codificar",TIPO,true);
	Checkbox DECODE = new Checkbox("Decodificar",TIPO,false);
	GridBagConstraints lim= new GridBagConstraints();
	
	
	Interfaz(){
		setSize(1000,700);
		setTitle("Cifrador Caesar");
		Toolkit tool= getToolkit();
		Dimension Ssize=tool.getScreenSize();
		setLocation(Ssize.width/8,Ssize.height/32);//para ponerlo en el centro setLocation(Ssize.width/4,Ssize.height/32);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel display=new JPanel();
		getContentPane().add(display);
		display.setLayout(new GridBagLayout());
		JLabel inLbl= new JLabel("Entrada");
		JLabel outLbl= new JLabel("Salida");
		JLabel disLbl= new JLabel("No. de Desplazameinto");
		JScrollPane txtArea[]= new JScrollPane [3];
		for(int i=0; i<3;i++)
			txtArea[i]= new JScrollPane();
		IN.setSize(300, 300);
		OUT.setSize(300, 300);
		DIS.setSize(100, 100);
		txtArea[0]= new JScrollPane(IN);
		txtArea[0].setViewportView(IN);
		txtArea[0].setPreferredSize(new Dimension(300,300));
		txtArea[1]= new JScrollPane(OUT);
		txtArea[1].setViewportView(OUT);
		txtArea[1].setPreferredSize(new Dimension(300,300));
		txtArea[2]= new JScrollPane(DIS);
		txtArea[2].setViewportView(DIS);
		txtArea[2].setPreferredSize(new Dimension(100,50));
		EncriptadoCaesar cipher= new EncriptadoCaesar();
		
		/*CODE.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});*/
	
		CONVERTIR.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TOK= new StringTokenizer(IN.getText()," ");
				OUT.setText("");
				String paso="";
				int displace=0;
				boolean esNum=true;
				char verDis[]= DIS.getText().toCharArray();
				char invalid[]= NUM.toCharArray();
				for(int i=0; i<verDis.length;i++){
					for(int x=0; x<invalid.length;x++){
						if(verDis[i]==invalid[x]){
							displace=0;
							esNum=false;
							i+=verDis.length;
							x+=invalid.length;
						}
						
					}
					
				}
				if(esNum){
					displace=Integer.parseInt(DIS.getText());
				}
				
				while(TOK.hasMoreTokens()){
					if(CODE.getState()){
						paso+=" "+cipher.encode(TOK.nextToken(), displace);
					}else{
						
						paso+=" "+cipher.decode(TOK.nextToken(), displace);
					}
				}
				OUT.setText(paso);
			}});
		
		/*
		 * PLAN APROX DE LA PANTALLA
		 * *********************************
		 * + [] x________________________________________________________________________
		 * 
		 * 	Entrada                       Desplazar         Salida
		 * [                    ]    [                ]   [                  ]
		 * 
		 * 							[Conertir]
		 * 						    o Codificar
		 * 						    o Decodificar
		 * 
		 * 
		 * _______________________________________________________________________________
		 * 
		 * 
		 * Sería aprox una matríz de 3*5
		 * 
		 * insets de 5x5x5x5
		 * 
		 * 
		 * */
		
		lim.insets= new Insets(5,5,5,5);
		
		// Labels primero y=0
		lim.gridy=0;
		//Entrada Lbl
		lim.gridx=0;
		display.add(inLbl, lim);
		//Displace lbl
		lim.gridx=1;
		display.add(disLbl, lim);
		// Salida lbl
		lim.gridx=2;
		display.add(outLbl, lim);
		
		//Areas de texto y=1
		lim.gridy=1;
		
		//Area IN
		lim.gridx=0;
		display.add(txtArea[0], lim);
		
		//Area DIS
		lim.gridx=1;
		display.add(txtArea[2], lim);
		
		//Area OUT
		lim.gridx=2;
		display.add(txtArea[1], lim);
		
		//Boton y checkboxes x=1
		lim.gridx=1;
		
		//Boton convertir
		lim.gridy=3;
		display.add(CONVERTIR, lim);
		
		//ENCODE button
		lim.gridy=4;
		display.add(CODE, lim);
				
		//ENCODE button
		lim.gridy=5;
		display.add(DECODE, lim);
		
		setVisible(true);
		
	}
	
	public static void main(String args[]){
		Interfaz vent= new Interfaz();
		
	}
}
