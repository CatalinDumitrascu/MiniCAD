package main;
import java.io.FileReader;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

import tema.Canvas;
import tema.Circle;
import tema.Diamond;
import tema.Line;
import tema.Painter;
import tema.Polygon;
import tema.Rectangle;
import tema.Shape;
import tema.ShapeFactory;
import tema.Square;
import tema.Triangle;


public final class Main {

	private Main() {

	}
	private static final int SIXTEEN = 16;
	private static final int TWENTYFOUR = 24;
	private static final int ONEH = 100;

    public static void main(String[] args) throws IOException {

    	 //BufferedReader reader = new BufferedReader(new FileReader(args[0]));
    	 Scanner scanner = new Scanner(System.in);
    	 Canvas canvas = Canvas.getInstance();
    	 Painter painter = new Painter();
    	 int numberOfFigures = scanner.nextInt();
    	 String figure = null;
    	 String colour1 = null;
    	 int colourNumber1;
    	 String colour2 = null;
    	 int colourNumber2;
    	 int alpha;
    	 int width, height, rad;
    	 int startX, startY, endX, endY;
    	 int x1, y1, x2, y2, x3, y3;
    	 int number;
    	 Shape current = null;

    	 while (numberOfFigures > 0) {
    		 
    		 scanner.nextLine();
    		 figure = scanner.next();

    		 if (figure.equals("CANVAS")) {
    			 height = scanner.nextInt();
    			 width = scanner.nextInt();
    			 colour1 = scanner.next();
    			 colour1 = colour1.substring(1);
    			 alpha = scanner.nextInt();
    			 colourNumber1 = Integer.parseInt(colour1, SIXTEEN);
    			 colourNumber1 = colourNumber1 + (alpha << TWENTYFOUR);
    			 canvas.setDimensions(height, width);
    			 canvas.setColour(colourNumber1);
    			 canvas.accept(painter);

    		 } else if (figure.equals("LINE")) {
    			painter.clearContur(canvas);
    			current = ShapeFactory.getShape(figure);
    			startX = scanner.nextInt();
    			startY = scanner.nextInt();
    			endX = scanner.nextInt();
    			endY = scanner.nextInt();
    			colour1 = scanner.next();
   			    colour1 = colour1.substring(1);
   			    alpha = scanner.nextInt();
   			    colourNumber1 = Integer.parseInt(colour1, SIXTEEN);
   			    colourNumber1 += Math.pow(2, TWENTYFOUR) * alpha;
   			    current = new Line(startX, startY, endX, endY, colourNumber1);
   			    current.accept(painter);

    		 } else if (figure.equals("SQUARE")) {
    			 painter.clearContur(canvas);
    			current = ShapeFactory.getShape(figure);
    			startX = scanner.nextInt();
    			startY = scanner.nextInt();
    			height = scanner.nextInt();
    			colour1 = scanner.next();
   			    colour1 = colour1.substring(1);
   			    alpha = scanner.nextInt();
   			    colourNumber1 = Integer.parseInt(colour1, SIXTEEN);
   			    colourNumber1 += Math.pow(2, TWENTYFOUR) * alpha;
   			    colour2 = scanner.next();
			    colour2 = colour2.substring(1);
			    alpha = scanner.nextInt();
			    colourNumber2 = Integer.parseInt(colour2, SIXTEEN);
			    colourNumber2 += Math.pow(2, TWENTYFOUR) * alpha;
			    current = new Square(startX, startY, height,
			    		colourNumber1, colourNumber2);
			    current.accept(painter);

    		 } else if (figure.equals("RECTANGLE")) {
    			 painter.clearContur(canvas);
    			current = ShapeFactory.getShape(figure);
    			startX = scanner.nextInt();
     			startY = scanner.nextInt();
     			height = scanner.nextInt();
     			width = scanner.nextInt();
     			colour1 = scanner.next();
    			colour1 = colour1.substring(1);
    			alpha = scanner.nextInt();
    			colourNumber1 = Integer.parseInt(colour1, SIXTEEN);
    			colourNumber1 += Math.pow(2, TWENTYFOUR) * alpha;
    			colour2 = scanner.next();
 			    colour2 = colour2.substring(1);
 			    alpha = scanner.nextInt();
 			    colourNumber2 = Integer.parseInt(colour2, SIXTEEN);
 			    colourNumber2 += Math.pow(2, TWENTYFOUR) * alpha;
 			    current = new Rectangle(startX, startY,
 			    		height, width, colourNumber1, colourNumber2);
 			    current.accept(painter);

    		 } else if (figure.equals("CIRCLE")) {
    			 painter.clearContur(canvas);
    			current = ShapeFactory.getShape(figure);
    			startX = scanner.nextInt();
    			startY = scanner.nextInt();
    			rad = scanner.nextInt();
    			colour1 = scanner.next();
    			colour1 = colour1.substring(1);
    			alpha = scanner.nextInt();
    			colourNumber1 = Integer.parseInt(colour1, SIXTEEN);
    			colourNumber1 += Math.pow(2, TWENTYFOUR) * alpha;
    			colour2 = scanner.next();
 			    colour2 = colour2.substring(1);
 			    alpha = scanner.nextInt();
 			    colourNumber2 = Integer.parseInt(colour2, SIXTEEN);
 			    colourNumber2 += Math.pow(2, TWENTYFOUR) * alpha;
 			    current = new Circle(startX, startY, rad, colourNumber1, colourNumber2);
 			    current.accept(painter);

    		 } else if (figure.equals("DIAMOND")) {
    			 painter.clearContur(canvas);
    			current = ShapeFactory.getShape(figure);
    			startX = scanner.nextInt();
    			startY = scanner.nextInt();
    			height = scanner.nextInt();
    			width = scanner.nextInt();
    			colour1 = scanner.next();
     			colour1 = colour1.substring(1);
     			alpha = scanner.nextInt();
     			colourNumber1 = Integer.parseInt(colour1, SIXTEEN);
     			colourNumber1 += Math.pow(2, TWENTYFOUR) * alpha;
     			colour2 = scanner.next();
  			    colour2 = colour2.substring(1);
  			    alpha = scanner.nextInt();
  			    colourNumber2 = Integer.parseInt(colour2, SIXTEEN);
  			    colourNumber2 += Math.pow(2, TWENTYFOUR) * alpha;
  			    current = new Diamond(startX, startY,
  			    		height, width, colourNumber1, colourNumber2);
  			    current.accept(painter);

    		 } else if (figure.equals("TRIANGLE")) {
    			 painter.clearContur(canvas);
    			current = ShapeFactory.getShape(figure);
    			x1 = scanner.nextInt();
    			y1 = scanner.nextInt();
    			x2 = scanner.nextInt();
    			y2 = scanner.nextInt();
    			x3 = scanner.nextInt();
    			y3 = scanner.nextInt();
    			colour1 = scanner.next();
     			colour1 = colour1.substring(1);
     			alpha = scanner.nextInt();
     			colourNumber1 = Integer.parseInt(colour1, SIXTEEN);
     			colourNumber1 += Math.pow(2, TWENTYFOUR) * alpha;
     			colour2 = scanner.next();
  			    colour2 = colour2.substring(1);
  			    alpha = scanner.nextInt();
  			    colourNumber2 = Integer.parseInt(colour2, SIXTEEN);
  			    colourNumber2 += Math.pow(2, TWENTYFOUR) * alpha;
  			    current = new Triangle(x1, y1, x2, y2,
  			    		x3, y3, colourNumber1, colourNumber2);
  			    current.accept(painter);

    		 } else if (figure.equals("POLYGON")) {
    			painter.clearContur(canvas);
    			current = ShapeFactory.getShape(figure);
    			number = scanner.nextInt();
    			int[] x = new int[ONEH];
    	    	int[] y = new int[ONEH];
    			for (int i = 0; i < number; i++) {
    				x[i] = scanner.nextInt();
    				y[i] = scanner.nextInt();
    			}

    			colour1 = scanner.next();
     			colour1 = colour1.substring(1);
     			alpha = scanner.nextInt();
     			colourNumber1 = Integer.parseInt(colour1, SIXTEEN);
     			colourNumber1 += Math.pow(2, TWENTYFOUR) * alpha;
     			colour2 = scanner.next();
  			    colour2 = colour2.substring(1);
  			    alpha = scanner.nextInt();
  			    colourNumber2 = Integer.parseInt(colour2, SIXTEEN);
  			    colourNumber2 += Math.pow(2, TWENTYFOUR) * alpha;
  			    current = new Polygon(number, x, y, colourNumber1, colourNumber2);
  			    current.accept(painter);

    		 }

    		 numberOfFigures -= 1;
    	 }

    	 BufferedImage img = painter.getImg();
    	 File outputfile = new File("drawing.png");
		 ImageIO.write(img, "png", outputfile);
		 scanner.close();

    }
}
