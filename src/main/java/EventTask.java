public class EventTask extends Task {

    private final String start;
    private final String end;
    public EventTask(String description, String start, String end) throws IllegalInputPotongException {
        super(description);
        if (start.isEmpty() || end.isEmpty()) {
            throw new IllegalInputPotongException();
        }
        this.start = start;
        this.end = end;
    }

    public EventTask(String description, String start, String end, boolean isDone) throws IllegalInputPotongException {
        super(description, isDone);
        if (start.isEmpty() || end.isEmpty()) {
            throw new IllegalInputPotongException();
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public String getTime() {
        return this.start + "-" + this.end;
    }
    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.start, this.end);
    }
}
