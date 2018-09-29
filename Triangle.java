package exoReflexion;

public class Triangle {
	Droite d1, d2, d3;

	public Triangle(Droite d1, Droite d2, Droite d3) {
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
	}

	public Droite getD1() {
		return d1;
	}

	public void setD1(Droite d1) {
		this.d1 = d1;
	}

	public Droite getD2() {
		return d2;
	}

	public void setD2(Droite d2) {
		this.d2 = d2;
	}

	public Droite getD3() {
		return d3;
	}

	public void setD3(Droite d3) {
		this.d3 = d3;
	}

	@Override
	public String toString() {
		return "Triangle [d1=" + d1 + ", d2=" + d2 + ", d3=" + d3 + "]";
	}
}
