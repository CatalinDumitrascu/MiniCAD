package tema;

public class Circle implements Shape, Element {

	private int centerX;
	private int centerY;
	private int radius;
	private int colourEdge;
	private int colourFill;

	public Circle() {

	}

	public Circle(final int x, final int y, final int rad,
			final int edge, final int fill) {
		this.centerX = x;
		this.centerY = y;
		this.radius = rad;
		this.colourEdge = edge;
		this.colourFill = fill;
	}
	/**
	 * @return the centerX
	 */
	public int getCenterX() {
		return centerX;
	}

	/**
	 * @param sets the X coordinate of this
	 */
	public void setCenterX(final int centerX) {
		this.centerX = centerX;
	}

	/**
	 * @return the centerY
	 */
	public int getCenterY() {
		return centerY;
	}

	/**
	 * @param centerY to set
	 */
	public void setCenterY(final int centerY) {
		this.centerY = centerY;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * @param radius to set
	 */
	public void setRadius(final int radius) {
		this.radius = radius;
	}
	/**
	 * @return the colourEdge
	 */
	public int getColourEdge() {
		return colourEdge;
	}

	/**
	 * @param colourEdge to set
	 */
	public void setColourEdge(final int colourEdge) {
		this.colourEdge = colourEdge;
	}

	/**
	 * @return the colourFill
	 */
	public int getColourFill() {
		return colourFill;
	}

	/**
	 * @param colourFill to set
	 */
	public void setColourFill(final int colourFill) {
		this.colourFill = colourFill;
	}

	@Override
	/**
	 *  Overrides Shape interface, implements factory pattern/
	 */
	public Shape create(final String string) {
		return new Circle();

	}

	@Override
	/**
	 *  Overrides Visitor interface, implements visitor pattern/
	 */
	public void accept(final Visitor v) {
		v.visit(this);

	}

}
