package exoReflexion;

public class Point {
	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this(0, 0);
	}

	/**
	 * @param p
	 *            vérifiant le format ( nombre réel , nombre réel)
	 */
	public Point(String p) {
		String[] t = p.split(",");

		int p1, p2;

		p1 = t[0].indexOf('(');
		p2 = t[1].indexOf(')');

		String sx, sy;
		sx = t[0].substring(1 + p1);
		sy = t[1].substring(0, p2);

		this.x = Double.parseDouble(sx.trim());
		this.y = Double.parseDouble(sy.trim());
	}

	@Override
	public String toString() {
		return "( " + this.x + ", " + this.y + ")";
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setX(String x) {
		this.setX(Double.parseDouble(x.trim()));
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setY(String y) {
		this.setY(Double.parseDouble(y.trim()));
	}
}
