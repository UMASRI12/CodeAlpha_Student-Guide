# Student Grade Tracker

A beginner-friendly Java Swing desktop app for entering student marks and viewing totals, averages and grades.

## Features
- Add a student with an ID, name and comma-separated marks
- Input validation: numeric ID, non-empty name, unique ID, marks between 0 and 100
- View all students with Total, Average, Highest, Lowest and Grade
- Grade scale (by average): A+ (90+), A (80+), B (70+), C (60+), D (50+), Fail (below 50)

## Tech Stack
- Java 17+
- Swing / AWT (GUI)

## Project Structure
```
StudentGradeTracker/
└── src/
    ├── Main.java            # Entry point (launches the GUI)
    ├── GradeTrackerGUI.java # Swing window, form and output area
    └── Student.java         # Student model and grade calculations
```

## Requirements
- JDK 17 or later

## How to Run
From the `StudentGradeTracker` folder:
```bash
javac -d out src/*.java
java -cp out Main
```

## Usage
1. Enter Student ID, Student Name and marks, e.g. `78, 85, 92`.
2. Click **Add Student**.
3. Click **View Students** to see the results.

## Notes
- Records are kept in memory only and are lost when the app closes.
- Possible extensions: file/database storage, edit and delete, search, sorting.
