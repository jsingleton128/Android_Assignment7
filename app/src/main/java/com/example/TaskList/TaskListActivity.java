package com.example.TaskList;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get db and StringBuilder objects
        TaskListDB db = new TaskListDB(this);
        StringBuilder sb = new StringBuilder();

        // insert a task
        Task task = new Task(1, "Make dentist appointment", "", "0", "0");
        long insertId = db.insertTask(task);
        if (insertId > 0) {
            sb.append("Row inserted! Insert Id: " + insertId + "\n");
        }

        // insert a second task
        Task task2 = new Task(1, "Take car in for oil change", "", "0", "0");
        long insertId2 = db.insertTask(task2);
        if (insertId2 > 0) {
            sb.append("Row inserted! Insert Id: " + insertId2 + "\n");
        }

        Task task3 = new Task(1, "Take out trash", "", "0", "0");
        long insertId3 = db.insertTask(task3);
        if (insertId3 > 0) {
            sb.append("Row inserted! Insert Id: " + insertId3 + "\n");
        }

        Task task4 = new Task(1, "Water the plants", "", "0", "0");
        long insertId4 = db.insertTask(task4);
        if (insertId3 > 0) {
            sb.append("Row inserted! Insert Id: " + insertId4 + "\n");
        }

        Task task5 = new Task(1, "Go to the bank", "", "0", "0");
        long insertId5 = db.insertTask(task5);
        if (insertId5 > 0) {
            sb.append("Row inserted! Insert Id: " + insertId5 + "\n");
        }

        // update a task
        //task.setId((int) insertId);
        //task.setName("Update test");
        //int updateCount = db.updateTask(task);
        //if (updateCount == 1) {
        //    sb.append("Task updated! Update count: " + updateCount + "\n");
        //}

        // delete a task
        //int deleteCount = db.deleteTask(insertId);
        //if (deleteCount == 1) {
        //    sb.append("Task deleted! Delete count: " + deleteCount + "\n\n");
        //}
        //
        //// delete old tasks (this may vary from system to system)
        //db.deleteTask(5);
        //db.deleteTask(7);



        // display all tasks (id + name)
        ArrayList<Task> tasks = db.getTasks("Personal");
        for (Task t : tasks) {
            sb.append(t.getId() + "|" + t.getName() + "\n");
        }

        // display string on UI
        TextView taskListTextView = (TextView)
                findViewById (R.id.taskListTextView);
        taskListTextView.setText(sb.toString());
    }
}