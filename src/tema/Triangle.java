package tema;

public class Triangle implements Element, Shape {

	private int firstPointX;
	private int firstPointY;
	private int secondPointX;
	private int secondPointY;
	private int thirdPointX;
	private int thirdPointY;
	private int sideColour;
	private int fillColour;

	public Triangle() {

	}

	public Triangle(final int x1, final int y1, final int x2, final int y2,
			final int x3, final int y3, final int side, final int fill) {
		this.firstPointX = x1;
		this.firstPointY = y1;
		this.secondPointX = x2;
		this.secondPointY = y2;
		this.thirdPointX = x3;
		this.thirdPointY = y3;
		this.sideColour = side;
		this.fillColour = fill;
	}

	/**
	 * @return the firstPointX
	 */
	public int getFirstPointX() {
		return firstPointX;
	}
	/**
	 * @param firstPointX to set
	 */
	public void setFirstPointX(final int firstPointX) {
		this.firstPointX = firstPointX;
	}
	/**
	 * @return the firstPointY
	 */
	public int getFirstPointY() {
		return firstPointY;
	}
	/**
	 * @param firstPointY to set
	 */
	public void setFirstPointY(final int firstPointY) {
		this.firstPointY = firstPointY;
	}
	/**
	 * @return the secondPointX
	 */
	public int getSecondPointX() {
		return secondPointX;
	}
	/**
	 * @param secondPointX to set
	 */
	public void setSecondPointX(final int secondPointX) {
		this.secondPointX = secondPointX;
	}
	/**
	 * @return the secondPointY
	 */
	public int getSecondPointY() {
		return secondPointY;
	}
	/**
	 * @param secondPointY to set
	 */
	public void setSecondPointY(final int secondPointY) {
		this.secondPointY = secondPointY;
	}
	/**
	 * @return the thirdPointX
	 */
	public int getThirdPointX() {
		return thirdPointX;
	}
	/**
	 * @param thirdPointX to set
	 */
	public void setThirdPointX(final int thirdPointX) {
		this.thirdPointX = thirdPointX;
	}
	/**
	 * @return the thirdPointY
	 */
	public int getThirdPointY() {
		return thirdPointY;
	}
	/**
	 * @param thirdPointY to set
	 */
	public void setThirdPointY(final int thirdPointY) {
		this.thirdPointY = thirdPointY;
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
		return new Triangle();
	}

	@Override
	/**
	 *  Overrides Visitor interface, implements visitor pattern/
	 */
	public void accept(final Visitor v) {
		v.visit(this);
	}

}
