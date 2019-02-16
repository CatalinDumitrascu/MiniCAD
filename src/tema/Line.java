package tema;

public class Line implements Element, Shape {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int colour;

	public Line() {

	}

	public Line(final int x1, final int y1, final int x2,
			final int y2, final int colour) {
		this.startX = x1;
		this.startY = y1;
		this.endX = x2;
		this.endY = y2;
		this.colour = colour;
	}

	/**
	 * @return the startX
	 */
	public int getStartX() {
		return startX;
	}


	/**
	 * @param startX to set
	 */
	public void setStartX(final int startX) {
		this.startX = startX;
	}


	/**
	 * @return the startY
	 */
	public int getStartY() {
		return startY;
	}


	/**
	 * @param startY to set
	 */
	public void setStartY(final int startY) {
		this.startY = startY;
	}


	/**
	 * @return the endX
	 */
	public int getEndX() {
		return endX;
	}


	/**
	 * @param endX to set
	 */
	public void setEndX(final int endX) {
		this.endX = endX;
	}


	/**
	 * @return the endY
	 */
	public int getEndY() {
		return endY;
	}


	/**
	 * @param endY to set
	 */
	public void setEndY(final int endY) {
		this.endY = endY;
	}


	/**
	 * @return the colour
	 */
	public int getColour() {
		return colour;
	}


	/**
	 * @param colour to set
	 */
	public void setColour(final int colour) {
		this.colour = colour;
	}


	@Override
	/**
	 *  Overrides Shape interface, implements factory pattern/
	 */
	public Shape create(final String string) {
		return new Line();

	}

	@Override
	/**
	 *  Overrides Visitor interface, implements visitor pattern/
	 */
	public void accept(final Visitor v) {
		v.visit(this);

	}

}
