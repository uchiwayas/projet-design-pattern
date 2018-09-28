package exoReflexion;

/**
 * classe créée pour tester les fonctionnalités de la réflexion : c-à-d les
 * propriétés de la classe Class<?>
 * 
 */
public class Personne {
	private String prenom;
	public String nom;

	private int taille; /* en cm */
	public double poids; /* en kg */
	private char sexe; /* 'M' ou 'F' */

	public Personne() {
		this("John", "Doe", 175, 76, 'm');
	}

	public Personne(String prenom, String nom, int taille, double poids, char sexe) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.taille = taille;
		this.poids = poids;
		this.sexe = Character.toUpperCase(sexe);
	}

	public void setIdentité(String prénom, String nom) {
		this.setPrenom(prénom);
		this.setNom(nom);
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prénom) {
		this.prenom = prénom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public void setTaille(String taille) {
		this.setTaille(Integer.parseInt(taille.trim()));
	}

	public double getPoids() {
		return this.poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public void setPoids(String poids) {
		this.setPoids(Double.parseDouble(poids.trim()));
	}

	public char getSexe() {
		return this.sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public void setSexe(String sexe) {
		this.setSexe(sexe.trim().charAt(0));
	}

	@Override
	public String toString() {
		return "Personne [prénom=" + this.prenom + ", nom=" + this.nom + ", taille=" + this.taille + ", poids="
				+ this.poids + ", sexe=" + this.sexe + "]";
	}

} // Personne
