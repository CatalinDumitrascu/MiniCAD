package tema;

public class Rectangle implements Element, Shape {

	private int topLeftX;
	private int topLeftY;
	private int heightLength;
	private int widthLength;
	private int sideColour;
	private int fillColour;

	public Rectangle() {

	}

	public Rectangle(final int x1, final int y1, final int height,
			final int width, final int side, final int fill) {
		this.topLeftX = x1;
		this.topLeftY = y1;
		this.heightLength = height;
		this.widthLength = width;
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
	 * @return the heightLength
	 */
	public int getHeightLength() {
		return heightLength;
	}
	/**
	 * @param heightLength to set
	 */
	public void setHeightLength(final int heightLength) {
		this.heightLength = heightLength;
	}
	/**
	 * @return the widthLength
	 */
	public int getWidthLength() {
		return widthLength;
	}
	/**
	 * @param widthLength to set
	 */
	public void setWidthLength(final int widthLength) {
		this.widthLength = widthLength;
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
		return new Rectangle();
	}

	@Override
	/**
	 *  Overrides Visitor interface, implements visitor pattern/
	 */
	public void accept(final Visitor v) {
		v.visit(this);
	}

}
