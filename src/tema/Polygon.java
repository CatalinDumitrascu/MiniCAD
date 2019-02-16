package tema;

public class Polygon implements Element, Shape {

	private static final int ONEH = 100;
	private int numberOfPolygons;
	private int[] x = new int[ONEH];
	private int[] y = new int[ONEH];
	private int sideColour;
	private int fillColour;

	public Polygon() {

	}

	public Polygon(final int n, final int[] x, final int[] y, final int side, final int fill) {
		this.numberOfPolygons = n;
		this.x = x;
		this.y = y;
		this.sideColour = side;
		this.fillColour = fill;
	}
	/**
	 * @return the numberOfPolygons
	 */
	public int getNumberOfPolygons() {
		return numberOfPolygons;
	}
	/**
	 * @param numberOfPolygons to set
	 */
	public void setNumberOfPolygons(final int numberOfPolygons) {
		this.numberOfPolygons = numberOfPolygons;
	}
	/**
	 * @return the x
	 */
	public int[] getX() {
		return x;
	}
	/**
	 * @param x to set
	 */
	public void setX(final int[] x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int[] getY() {
		return y;
	}
	/**
	 * @param y to set
	 */
	public void setY(final int[] y) {
		this.y = y;
	}
	/**
	 * @return the sideColour
	 */
	public int getSideColour() {
		return sideColour;
	}
	/**
	 * @param sideColour to set
	 */
	public void setSideColour(final int sideColour) {
		this.sideColour = sideColour;
	}
	/**
	 * @return the fillColour
	 */
	public int getFillColour() {
		return fillColour;
	}
	/**
	 * @param fillColour to set
	 */
	public void setFillColour(final int fillColour) {
		this.fillColour = fillColour;
	}

	@Override
	/**
	 *  Overrides Shape interface, implements factory pattern/
	 */
	public Shape create(final String string) {
		return new Polygon();
	}

	@Override
	/**
	 *  Overrides Visitor interface, implements visitor pattern/
	 */
	public void accept(final Visitor v) {
		v.visit(this);
	}

}
