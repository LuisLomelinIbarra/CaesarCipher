/*
 * Clase: Cifrado Caesar
 * 
 * Esta clase es una clase auxiliar que contiene los metodos necesarios para codificar y decodificar cualquier string
 * a un encriptado caesar. 
 * 
 * Actualmente solo soporta el abecedario ingles (debidio a la limitacion de la tabla ASCII)
 * 
 * */


import java.io.*;
public class EncriptadoCaesar {
	String encode(String msg,int displace){
		String result="";
		msg=msg.toUpperCase();
		char tempMsg[]=msg.toCharArray();
		for(int i=0; i<tempMsg.length;i++){
			//System.out.println("Char["+i+"]= "+tempMsg[i]);
			int caracter= ((int) tempMsg[i]);
			int sum=64;
			caracter-=sum;
			//System.out.println(caracter);
			caracter=(caracter+displace)%26;
			//System.out.println("\n *********"+caracter);
			if(caracter==0){
				caracter=26;
			}
			caracter+=sum;
			result+=(char) caracter;
		}
		
		
		return result;
	}
	String decode(String msg,int displace){
		String result="";
		msg=msg.toUpperCase();
		char tempMsg[]=msg.toCharArray();
		for(int i=0; i<tempMsg.length;i++){
			int caracter= ((int) tempMsg[i]);
			int sum=64;
			caracter-=sum;
			//System.out.println(caracter);
			if(caracter-displace<1){
				caracter=26+(caracter-displace);
				
				caracter=(caracter)%26;
				if(caracter==0){
					caracter=26;
				}
			}else{
				caracter=(caracter-displace)%26;
			}
			//System.out.println("\n------"+caracter);
			caracter+=sum;
			result+=(char) caracter;
		}
		
		
		return result;
	}
	/*public static void main(String args[])throws IOException{
		String x="";
		BufferedReader ln= new BufferedReader(new InputStreamReader(System.in));
		EncriptadoCaesar cypher= new EncriptadoCaesar();
		x=ln.readLine();
		x=cypher.encode(x, 4);
		System.out.println("---------------\n"
				+ x+"\n"
				+ "***************\n"
				+ cypher.decode(x, 4));
		
	}*/
}
