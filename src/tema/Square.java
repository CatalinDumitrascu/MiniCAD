package tema;

public class Square implements Element, Shape {

	private int topLeftX;
	private int topLeftY;
	private int sideLength;
	private int sideColour;
	private int fillColour;

	public Square() {

	}

	public Square(final int x1, final int y1, final int length,
			final int side, final int fill) {
		this.topLeftX = x1;
		this.topLeftY = y1;
		this.sideLength = length;
		this.sideColour = side;
		this.fillColour = fill;
	}

	/**
	 * @return the topLeftX
	 */
	public int getTopLeftX() {
		return topLeftX;
	}
	/**
	 * @param topLeftX to set
	 */
	public void setTopLeftX(final int topLeftX) {
		this.topLeftX = topLeftX;
	}
	/**
	 * @return the topLeftY
	 */
	public int getTopLeftY() {
		return topLeftY;
	}
	/**
	 * @param topLeftY to set
	 */
	public void setTopLeftY(final int topLeftY) {
		this.topLeftY = topLeftY;
	}
	/**
	 * @return the sideLength
	 */
	public int getSideLength() {
		return sideLength;
	}
	/**
	 * @param sideLength to set
	 */
	public void setSideLength(final int sideLength) {
		this.sideLength = sideLength;
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
		return new Square();

	}

	@Override
	/**
	 *  Overrides Visitor interface, implements visitor pattern/
	 */
	public void accept(final Visitor v) {
		v.visit(this);
	}
}
