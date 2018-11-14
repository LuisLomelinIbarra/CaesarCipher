/*
 * Programa: "Verifica propiedades de la relacion"
 * Descripción:
 * Este es un programa en consola que identifica las propiedades de una relacion dada por un set A y una matriz de adjaciencia que representa sus relaciones
 * 
 * Creado por: Luis Fernando Lomelín Ibarra
 * 
 * 
 * */

import java.io.*;
import java.util.StringTokenizer;

public class checarPropiedades {
	//Es una funcion  que verifica la reflexividad de una relacion
	public static boolean verificarReflexividad(String setA[],String R[]){
		boolean es=true;
		int indx=0;
		do{
			String paso="("+setA[indx]+","+setA[indx]+")";
			for(int i=0; i<R.length;i++){
				if(paso.equals(R[i])){
					es=true;
					i+=R.length;
				}else{
					es=false;
				}
			}
			indx++;
		}while(es&&indx<setA.length);
		
		return es;
	}
	//Es una funcion  que verifica la Simetría de una relacion
	public static boolean verificarSimetria(String setA[],String R[]){
		boolean es=true;
		for(int i=0;i<setA.length;i++){
			for(int x=0; x<setA.length;x++){
				String paso="("+setA[i]+","+setA[x]+")";
				String paso2="("+setA[x]+","+setA[i]+")";
				boolean con1=false;
				boolean con2=false;
				if(i!=x){
					for(int z=0; z<R.length;z++){
						if(paso.equals(R[z])){
							con1=paso.equals(R[z]);
						}
						if(paso2.equals(R[z])){
							con2=paso2.equals(R[z]);
						}
					}
				}
				
				es=!con1||con2;
				if(!es){
					return es;
				}
			}
		}
		return es;
		
	}
	
	//Es una funcion  que verifica la transividad de una relacion
	public static boolean verificarTransitividad(String setA[],String R[]){
		boolean es=true;
		
		for(int x=0; x<setA.length;x++){
			for(int y=0; y<setA.length;y++){
				for(int z=0; z<setA.length;z++){
					if(y!=z&&z!=x&&x!=y){
					String paso="("+setA[x]+","+setA[y]+")";
					String paso2="("+setA[y]+","+setA[z]+")";
					String paso3="("+setA[x]+","+setA[z]+")";
					boolean con1=false;
					boolean con2=false;
					boolean con3=false;
					for(int i=0; i<R.length;i++){
						if(paso.equals(R[i])){
							con1=paso.equals(R[i]);
						}
						if(paso2.equals(R[i])){
							con2=paso2.equals(R[i]);
						}
						if(paso3.equals(R[i])){
							con3=paso3.equals(R[i]);
						}
					}
					
					es=!(con1&&con2)||con3;
					if(!es){
						return es;
					}
					
					}
				}
			}
			
		}
		
		
		
		return es;
		
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader ln= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Escriba el tamaño de el set:");
		int tamA= Integer.parseInt(ln.readLine());
		String a[]= new String[tamA];
		System.out.println("Escribe el set speadado por un enter:");
		for(int i=0; i<tamA; i++){
			a[i]= ln.readLine();
		}
		
		String r[]= new String[tamA*tamA];
		String mat[][]= new String [tamA][tamA];
		int tamR=0;
		System.out.println("Escribe la matríz de adjaciencia speadado por espacios y enters :");
		//Transforma la matriz a un conjunto ordenado
		for(int x=0; x<tamA; x++){
			String in=ln.readLine();
			StringTokenizer tok= new StringTokenizer(in," ");
			for(int y=0; y<tamA;y++){
				if(tok.hasMoreTokens())
				mat[x][y]=tok.nextToken();
			}
		}
		for(int x=0; x<tamA;x++){
			for(int y=0; y<tamA;y++){
				if(mat[x][y].equals("1")){
					r[tamR]="("+a[x]+","+a[y]+")";
					tamR++;
				}
			}
			
		}
		String paso[]= new String [tamR];
		for(int i=0; i<tamR;i++){
			paso[i]=r[i];
		}
		
		r=paso;
		
		System.out.println("Sus propiedades son:");
		System.out.println("Reflexiva: "+verificarReflexividad(a,r));
		System.out.println("Simetría: "+verificarSimetria(a,r));
		System.out.println("Transitividad: "+verificarTransitividad(a,r));
		
	}

}
