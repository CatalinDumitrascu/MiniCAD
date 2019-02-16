package tema;

public class Diamond implements Element, Shape {

	private int centerX;
	private int centerY;
	private int horizontalDiagonal;
	private int verticalDiagonal;
	private int sideColour;
	private int fillColour;

	public Diamond() {

	}

	public Diamond(final int x, final int y, final int first,
			final int second, final int side, final int fill) {
		this.centerX = x;
		this.centerY = y;
		this.horizontalDiagonal = first;
		this.verticalDiagonal = second;
		this.sideColour = side;
		this.fillColour = fill;
	}
	/**
	 * @return the centerX
	 */
	public int getCenterX() {
		return centerX;
	}
	/**
	 * @param centerX to set
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
	 * @return the horizontalDiagonal
	 */
	public int getHorizontalDiagonal() {
		return horizontalDiagonal;
	}
	/**
	 * @param horizontalDiagonal to set
	 */
	public void setHorizontalDiagonal(final int horizontalDiagonal) {
		this.horizontalDiagonal = horizontalDiagonal;
	}
	/**
	 * @return the verticalDiagonal
	 */
	public int getVerticalDiagonal() {
		return verticalDiagonal;
	}
	/**
	 * @param verticalDiagonal to set
	 */
	public void setVerticalDiagonal(final int verticalDiagonal) {
		this.verticalDiagonal = verticalDiagonal;
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
		return new Diamond();
	}

	@Override
	/**
	 *  Overrides Visitor interface, implements visitor pattern/
	 */
	public void accept(final Visitor v) {
		v.visit(this);
	}

}
