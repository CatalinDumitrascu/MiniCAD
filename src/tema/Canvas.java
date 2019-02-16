package tema;

public final class Canvas implements Shape, Element {

	   //create an object of Canvas
	   private static Canvas instance = new Canvas();

	   private int height;
	   public int getHeight() {
		   return height;
	   }

	   public int getWidth() {
		   return width;
	   }

	   public int getColour() {
		   return colour;
	   }

	   private int width;
	   private int colour;

	   private Canvas() {

	   }

	   //Get the only object available
	   public static Canvas getInstance() {
	      return instance;
	   }

	   /** Sets the height and width of the Canvas.*/
	   public void setDimensions(final int h, final int w) {
		   this.height = h;
		   this.width = w;
	   }

	   /** Sets the colour of the Canvas. */
	   public void setColour(final int colour) {
		   this.colour = colour;
	   }

	@Override
	/**
	 *  Overrides Visitor interface, implements visitor pattern/
	 */
	public void accept(final Visitor v) {
		v.visit(this);
	}

	@Override
	/**
	 *  Overrides Shape interface, implements factory pattern/
	 */
	public Shape create(final String string) {
		// TODO Auto-generated method stub
		return instance;
	}
}
