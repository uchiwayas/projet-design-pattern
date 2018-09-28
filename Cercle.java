package exoReflexion;

public class Cercle {
	private Point centre;
	private double rayon;

	/**
	 * crée le cercle de rayon 1 centré en l'origine O(0,0)
	 */
	public Cercle() {
		this.centre = new Point(0, 0);
		this.rayon = 1;
	}

	/**
	 * @param centre
	 * @param rayon
	 *            >= 0
	 */
	public Cercle(Point centre, double rayon) {
		this.centre = centre;
		this.setRayon(rayon);
	}

	public Point getCentre() {
		return this.centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public void setCentre(String centre) {
		this.setCentre(new Point(centre));
	}

	public double getRayon() {
		return this.rayon;
	}

	public void setRayon(double rayon) {
		if (rayon <= 0)
			throw new IllegalArgumentException("rayon invalide : " + rayon);
		this.rayon = rayon;
	}

	public void setRayon(String rayon) {
		this.setRayon(Double.parseDouble(rayon.trim()));
	}

	@Override
	public String toString() {
		return "Cercle [centre=" + this.centre + ", rayon=" + this.rayon + "]";
	}

}
