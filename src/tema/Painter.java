package tema;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Painter implements Visitor {

	private BufferedImage img = null;
	private static final int SIX = 6;
	private static final int THREE = 3;
	private static final int TEN = 10;
	private static final int FOUR = 4;
	private static final int GREAT = 2000;

	public final BufferedImage getImg() {
		return img;
	}

	public final void visit(final Canvas canvas) {
		this.img = new BufferedImage(canvas.getWidth(), canvas.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		int i, j;

		for (i = 0; i < canvas.getWidth(); i++) {
			for (j = 0; j < canvas.getHeight(); j++) {
				img.setRGB(i, j, canvas.getColour());

			}
		}

	}

	private int[][] contur = new int[GREAT][GREAT];
	public final void clearContur(final Canvas canvas) {
		for (int i = 0; i < canvas.getWidth(); i++) {
			for (int j = 0; j < canvas.getHeight(); j++) {
				contur[i][j] = 0;
			}
		}
	}

	public final void visit(final Line line) {

		int x = line.getStartX();
		int y = line.getStartY();
		int deltax = Math.abs(line.getEndX() - line.getStartX());
		int deltay = Math.abs(line.getEndY() - line.getStartY());
		int s1 = (int) Math.signum(line.getEndX() - line.getStartX());
		int s2 = (int) Math.signum(line.getEndY() - line.getStartY());
		boolean interchanged;

		if (deltay > deltax) {
			int temp;
			temp = deltax;
			deltax = deltay;
			deltay = temp;
			interchanged = true;
		} else {
			interchanged = false;
		}

		int error = 2 * deltay - deltax;

		for (int i = 0; i <= deltax; i++) {
			if (x < img.getWidth() && y < img.getHeight()
					&& x >= 0 && y >= 0) {
				img.setRGB(x, y, line.getColour());
				contur[x][y] = 1;
			}
			while (error > 0) {
				if (interchanged) {
					x = x + s1;
				} else {
					y = y + s2;
				}

				error = error - 2 * deltax;
			}

			if (interchanged) {
				y = y + s2;
			} else {
				x = x + s1;
			}

			error = error + 2 * deltay;
		}

	}

	public final void visit(final Square square) {

		int x = square.getTopLeftX();
		int y = square.getTopLeftY();
		int length = square.getSideLength();
		int i, j;

		for (i = x; i < x + length; i++) {
			if (i < img.getWidth()) {
				img.setRGB(i, y, square.getSideColour());
			}
		}

		for (i = y; i < y + length; i++) {
			if (x + length <  img.getWidth() && i < img.getHeight()) {
				img.setRGB(x + length - 1, i, square.getSideColour());
			}
		}

		for (i = y; i < y + length; i++) {
			if (i < img.getHeight()) {
				img.setRGB(x, i, square.getSideColour());
			}
		}

		for (i = x; i < x + length; i++) {
			if (i < img.getWidth() && y + length < img.getHeight()) {
				img.setRGB(i, y + length - 1, square.getSideColour());
			}
		}

		for (i = x + 1; i < x + length - 1; i++) {
			for (j = y + 1; j < y + length - 1; j++) {
				if (i < img.getWidth() && j < img.getHeight()) {
					img.setRGB(i, j, square.getFillColour());
				}

			}
		}
	}

	public final void visit(final Rectangle rectangle) {

		int x = rectangle.getTopLeftX();
		int y = rectangle.getTopLeftY();
		int height = rectangle.getHeightLength();
		int width = rectangle.getWidthLength();
		int i, j;

		for (i = x; i < x + width; i++) {
			if (i < img.getWidth()) {
				img.setRGB(i, y, rectangle.getSideColour());
			}
		}

		for (i = y; i < y + height; i++) {
			if (x + width < img.getWidth() && i < img.getHeight()) {
				img.setRGB(x + width - 1, i, rectangle.getSideColour());
			}
		}

		for (i = y; i < y + height; i++) {
			if (i < img.getHeight()) {
				img.setRGB(x, i, rectangle.getSideColour());
			}
		}

		for (i = x; i < x + width - 1; i++) {
			if (i < img.getWidth() && y + height < img.getHeight()) {
				img.setRGB(i, y + height - 1, rectangle.getSideColour());
			}
		}

		for (i = x + 1; i < x + width - 1; i++) {
			for (j = y + 1; j < y + height - 1; j++) {
				if (i < img.getWidth() && j < img.getHeight()) {
					img.setRGB(i, j, rectangle.getFillColour());
				}
			}
		}
	}

	public final void visit(final Diamond diamond) {

		int x = diamond.getCenterX();
		int y = diamond.getCenterY();
		int horizontal = diamond.getHorizontalDiagonal();
		int vertical = diamond.getVerticalDiagonal();
		int sideC = diamond.getSideColour();

		Line line1 = new Line(x, y - vertical / 2, x - horizontal / 2, y, sideC);
		Line line2 = new Line(x - horizontal / 2, y, x, y + vertical / 2, sideC);
		Line line3 = new Line(x, y + vertical / 2, x + horizontal / 2, y, sideC);
		Line line4 = new Line(x + horizontal / 2, y, x, y - vertical / 2, sideC);

		visit(line1);
		visit(line2);
		visit(line3);
		visit(line4);

		floodFill(img, contur, x, y, diamond.getFillColour());

	}
	public final void visit(final Triangle triangle) {

		int x1 = triangle.getFirstPointX();
		int y1 = triangle.getFirstPointY();
		int x2 = triangle.getSecondPointX();
		int y2 = triangle.getSecondPointY();
		int x3 = triangle.getThirdPointX();
		int y3 = triangle.getThirdPointY();
		int sideC = triangle.getSideColour();

		Line line1 = new Line(x1, y1, x2, y2, sideC);
		Line line2 = new Line(x2, y2, x3, y3, sideC);
		Line line3 = new Line(x3, y3, x1, y1, sideC);

		visit(line1);
		visit(line2);
		visit(line3);

		int centerX = (x1 + x2 + x3) / THREE;
		int centerY = (y1 + y2 + y3) / THREE;

		floodFill(img, contur, centerX, centerY, triangle.getFillColour());

	}
	public final void visit(final Polygon polygon) {

		int n = polygon.getNumberOfPolygons();
		int[] x = polygon.getX();
		int[] y = polygon.getY();
		int sumX = 0;
		int sumY = 0;
		int i;
		Line line = null;

		for (i = 0; i < n - 1; i++) {
			line = new Line(x[i], y[i], x[i + 1], y[i + 1], polygon.getSideColour());
			visit(line);
		}

		line = new Line(x[n - 1], y[n - 1], x[0], y[0], polygon.getSideColour());
		visit(line);
		for (i = 0; i < n; i++) {
			sumX = sumX + x[i];
			sumY = sumY + y[i];
		}

		System.out.println("sumX " + sumX);
		System.out.println("sumY " + sumY);
		sumX = sumX / n + 2;
		sumY = sumY / n - 2;
		System.out.println("sumX " + sumX);
		System.out.println("sumY " + sumY);

		floodFill(img, contur, sumX, sumY, polygon.getFillColour());

	}

	public final void visit(final Circle circle) {

		int x = circle.getCenterX();
		int y = circle.getCenterY();
		int r = circle.getRadius();
		int p = 0;
		int q = r;
		int d = THREE - 2 * r;

		while (p < q) {
		    drawCircle(img, contur, x, y, p, q, circle.getColourEdge());
		    p = p + 1;

		    if (d < 0) {
		    	d = d + FOUR * p + SIX;
			} else {
		    	q = q - 1;
		    	d = d + FOUR * (p - q) + TEN;
		    }

		    drawCircle(img, contur, x, y, p, q, circle.getColourEdge());
		}

		floodFill(img, contur, x, y, circle.getColourFill());

	}

	final void drawCircle(final BufferedImage img, final int[][] contur, final int X,
			final int Y, final int P, final int Q, final int rgb) {
		if (X + P < img.getWidth() && Y + Q < img.getHeight()
				&& X + P >= 0 && Y + Q >= 0) {
		img.setRGB(X + P, Y + Q, rgb);
		contur[X + P][Y + Q] = 1;
		}
		if (X - P < img.getWidth() && Y + Q < img.getHeight()
				&& X - P >= 0 && Y + Q >= 0) {
		img.setRGB(X - P, Y + Q, rgb);
		contur[X - P][Y + Q] = 1;
		}
		if (X + P < img.getWidth() && Y - Q < img.getHeight()
				&& X + P >= 0 && Y - Q >= 0) {
		img.setRGB(X + P, Y - Q, rgb);
		contur[X + P][Y - Q] = 1;
		}
		if (X - P < img.getWidth() && Y - Q < img.getHeight()
				&& X - P >= 0 && Y - Q >= 0) {
		img.setRGB(X - P, Y - Q, rgb);
		contur[X - P][Y - Q] = 1;
		}
		if (X + Q < img.getWidth() && Y + P < img.getHeight()
				&& X + Q >= 0 && Y + P >= 0) {
		img.setRGB(X + Q, Y + P, rgb);
		contur[X + Q][Y + P] = 1;
		}
		if (X - Q < img.getWidth() && Y + P < img.getHeight()
				&& X - Q >= 0 && Y + P >= 0) {
		img.setRGB(X - Q, Y + P, rgb);
		contur[X - Q][Y + P] = 1;
		}
		if (X + Q < img.getWidth() && Y - P < img.getHeight()
				&& X + Q >= 0 && Y - P >= 0) {
		img.setRGB(X + Q, Y - P, rgb);
		contur[X + Q][Y - P] = 1;
		}
		if (X - Q < img.getWidth() && Y - P < img.getHeight()
				&& X - Q >= 0 && Y - P >= 0) {
		img.setRGB(X - Q, Y - P, rgb);
		contur[X - Q][Y - P] = 1;
		}
	}

	public final void floodFill(final BufferedImage img, final int[][] contur, 
			final int x, final int y, final int newC) {
		Queue<Point> q = new LinkedList<Point>();
	    q.add(new Point(x, y));
	    img.setRGB(x, y, newC);
	    while (!q.isEmpty()) {
	    	Point p = q.remove();

	    	if (p.x >= 0 && p.x <= img.getWidth() - 1
	    			&& p.y >= 0 && p.y <= img.getHeight() - 1) {

	    		// test left
	    		if (p.x - 1 >= 0) {
	    			if (img.getRGB(p.x - 1, p.y) != newC && contur[p.x - 1][p.y] != 1) {
	    				q.add(new Point(p.x - 1, p.y));
	    				img.setRGB(p.x - 1, p.y, newC);
	    			}
                }
	    		// test right
	    		if (p.x + 1 <= img.getWidth() - 1) {
	    			if (img.getRGB(p.x + 1, p.y) != newC && contur[p.x + 1][p.y] != 1) {
	    				q.add(new Point(p.x + 1, p.y));
	    				img.setRGB(p.x + 1, p.y, newC);
	    			}
	    		}
	    		// test up
	    		if (p.y - 1 >= 0) {
	    			if (img.getRGB(p.x, p.y - 1) != newC && contur[p.x][p.y - 1] != 1) {
	    				q.add(new Point(p.x, p.y - 1));
	    				img.setRGB(p.x, p.y - 1, newC);
	    			}
	    		}
	    		// test down
	    		if (p.y + 1 <= img.getHeight() - 1) {
	    			if (img.getRGB(p.x, p.y + 1) != newC && contur[p.x][p.y + 1] != 1) {
	    				q.add(new Point(p.x, p.y + 1));
	    				img.setRGB(p.x, p.y + 1, newC);
	    			}
	    		}

	    	}

	    }
    }

}
