public class InputData {

    private Task[] arr;
    private int index;

    public InputData() {
        this.arr = new Task[100];
        this.index = 0;
    }

    public String add(Task input) {
        this.arr[this.index] = input;
        this.index++;
        return String.format("added: %s", input);
    }

    public String mark(int index) {
        return this.arr[index - 1].mark();
    }

    public String unmark(int index) {
        return this.arr[index - 1].unmark();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < index; i++) {
            result.append(String.format("%d. %s\n", i + 1, this.arr[i]));
        }
        return result.toString();
    }
}
