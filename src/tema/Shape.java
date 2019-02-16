package tema;

public interface Shape {
       Shape create(String string);
       void accept(Visitor v);
}
