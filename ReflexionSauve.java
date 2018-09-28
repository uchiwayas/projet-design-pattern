package exoReflexion;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexionSauve {

	public static void main(String[] args) {
		
		Point p = new Point(2,3);
		Personne per = new Personne("Yassine", "Tahri", 175, 76, 'm');
		Cercle c = new Cercle(p, 30);
		
		String fichier = "monpoint1.txt";
		String fichier2 = "mapersonne1.txt";
		String fichier3 = "moncercle1.txt";
		
		sauve(p, fichier);
		sauve(per, fichier2); 
		sauve(c, fichier3);
	}
	
	public static void sauve(Object objet, String nomFichier){
		Class<?> cl = objet.getClass();
		Field[] champs = cl.getDeclaredFields();
		try {
			PrintWriter writer = new PrintWriter(nomFichier, "UTF-8");
			writer.println("Donn�es pour cr�er une instance de : "+ objet.getClass().getName());
			for (Field ch : champs){
				try {
					//on cr�e un string de getter (ex : getX)
					String getterName = cr�eNomGetter(ch.getName());
					//on cr�e un methode m, et on lui attribue la VRAIE methode getterName (la vraie getX)
					Method m = cl.getMethod(getterName);
					//on utilise la methode grace a invoke sur l'objet pour r�cuperer la valeur
					Object obj = m.invoke(objet);
					writer.println(ch.getName() + "=" + obj);
					System.out.println(ch.getName() + "=" + obj);
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// On ne fait rien
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public static String cr�eNomGSetter(String getouset, String nomChamp)
	{
		char l = nomChamp.charAt(0); 
		String nomSetter = getouset + Character.toUpperCase(l)+nomChamp.substring(1);        
		// on cr�e le nom du setter associ� au champ � renseigner
		return nomSetter;
	}
	
	public static String cr�eNomSetter(String nomChamp)
	{
		return cr�eNomGSetter("set", nomChamp);
	}
	
	public static String cr�eNomGetter(String nomChamp)
	{
		return cr�eNomGSetter("get", nomChamp);
	}

}
