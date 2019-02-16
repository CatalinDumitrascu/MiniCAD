package MyStack;

    public class MyStack{
        private int[] array;
        private int count;

        public MyStack() {
            array = new int[5];
            count = 0;
        }

        public void push(int value) {
            array[count++] = value;
        }

        public int pop() {
            return array[--count];
        }

        public int peek() {
            return array[count];
        }

        public static void main(String[] args) {

            MyStack stack = new MyStack();
            stack.push(0);
            stack.push(5);
            stack.pop();
            System.out.println(stack.peek());



        }
    }

