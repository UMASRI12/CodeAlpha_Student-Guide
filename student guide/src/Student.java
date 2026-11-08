public class Student {
    private final int id;
    private final String name;
    private final double[] marks;

    public Student(int id, String name, double[] marks) {
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("At least one mark is required.");
        }
        this.id = id;
        this.name = name;
        this.marks = marks.clone();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public double getTotal() {
        double total = 0;
        for (double mark : marks) total += mark;
        return total;
    }

    public double getAverage() { return getTotal() / marks.length; }

    public double getHighest() {
        double highest = marks[0];
        for (double mark : marks) if (mark > highest) highest = mark;
        return highest;
    }

    public double getLowest() {
        double lowest = marks[0];
        for (double mark : marks) if (mark < lowest) lowest = mark;
        return lowest;
    }

    public String getGrade() {
        double average = getAverage();
        if (average >= 90) return "A+";
        if (average >= 80) return "A";
        if (average >= 70) return "B";
        if (average >= 60) return "C";
        if (average >= 50) return "D";
        return "Fail";
    }
}
