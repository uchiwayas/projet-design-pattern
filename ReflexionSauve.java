package exoReflexion;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ReflexionSauve {
	
	public static int id=1;
	
	public static void main(String[] args) {
		
		
		//les sommets du triangle
		Point p = new Point(2,3);
		Point p2 = new Point(5,6);
		Point p3 = new Point(7,5);
		
		//les droites du triangle
		Droite d1 = new Droite(p,p2);
		Droite d2 = new Droite(p2,p3);
		Droite d3 = new Droite(p3,p);
		
		//objets
//		Personne per = new Personne("Yassine", "Tahri", 175, 76, 'm');
//		Cercle c = new Cercle(p, 30);
		Triangle t = new Triangle(d1, d2, d3);
		
		
		
//		String fichier = "monPoint1.txt";
//		String fichier2 = "maPersonne1.txt";
//		String fichier3 = "monCercle1.txt";
		String fichier4 = "monTriangle1.txt";
		
//		sauveRecursif(p, fichier);
//		sauveRecursif(per, fichier2); 
//		sauveRecursif(c, fichier3);
		sauveRecursif(t, fichier4);
		
//		sauveSimple(p, fichier);
//		sauveSimple(per, fichier2); 
//		sauveSimple(c, fichier3); 
	}
	
/*	public static void sauveSimple(Object objet, String nomFichier){
//		Class<?> cl = objet.getClass();
//		Field[] champs = cl.getDeclaredFields();
//		try {
//			PrintWriter writer = new PrintWriter(nomFichier, "UTF-8");
//			writer.println("Données pour créer une instance de : "+ objet.getClass().getName());
//			for (Field ch : champs){
//				try {
//					//on crée un string de getter (ex : getX)
//					String getterName = créeNomGetter(ch.getName());
//					//on crée un methode m, et on lui attribue la VRAIE methode getterName (la vraie getX)
//					Method m = cl.getMethod(getterName);
//					//on utilise la methode grace a invoke sur l'objet pour récuperer la valeur
//					Object obj = m.invoke(objet);
//					writer.println(ch.getName() + "=" + obj);
//					System.out.println(ch.getName() + "=" + obj);
//				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
//						| InvocationTargetException e) {
//					// On ne fait rien
//				}
//			}
//			writer.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}
 * 
 */
	
	public static String sauveRecursif(Object objet, String nomFichier){
		Class<?> cl = objet.getClass();
		Field[] champs = cl.getDeclaredFields();
		try {
			PrintWriter writer = new PrintWriter(nomFichier, "UTF-8");
			String[] comment = objet.getClass().getName().split(Pattern.quote("."));
			writer.println("Données pour créer une instance de : "+ comment[comment.length-1]);
			writer.println(objet.getClass());

			for (Field ch : champs){
				try {
					String classe = ch.getType().toString();
					Object obj = getObj(objet, ch, cl);
				   if (classe.trim().contains("exoReflexion")) { //getDeclaringClass
					   id++;
						String[] nomClasse = obj.getClass().getName().split(Pattern.quote("."));
						String fichier = "mon"+nomClasse[nomClasse.length-1]+ id +".txt"; //getDeclaringClass
						writer.println(ch.getName() + "=" + sauveRecursif(obj, fichier));
				   }
				   else {
						writer.println(ch.getName() + "=" + obj);
				   }
				} catch (SecurityException | IllegalArgumentException e) {
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
		
		return nomFichier;
	}
	
	public static Object getObj(Object objet, Field ch, Class<?> cl)
	{
		//on crée un string de getter (ex : getX)
		String getterName = créeNomGetter(ch.getName());
		//on crée un methode m, et on lui attribue la VRAIE methode getterName (la vraie getX)
		try {
			Method m = cl.getMethod(getterName);
			//on utilise la methode grace a invoke sur l'objet pour récuperer la valeur
			return m.invoke(objet);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String créeNomGSetter(String getouset, String nomChamp)
	{
		char l = nomChamp.charAt(0); 
		String nomSetter = getouset + Character.toUpperCase(l)+nomChamp.substring(1);        
		// on crée le nom du setter associé au champ à renseigner
		return nomSetter;
	}
	
	public static String créeNomSetter(String nomChamp)
	{
		return créeNomGSetter("set", nomChamp);
	}
	
	public static String créeNomGetter(String nomChamp)
	{
		return créeNomGSetter("get", nomChamp);
	}

}
