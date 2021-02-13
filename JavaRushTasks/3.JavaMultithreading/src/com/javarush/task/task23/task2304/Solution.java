package com.javarush.task.task23.task2304;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Inner 3
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    private class TaskDataProvider extends MockDB implements DbDataProvider<Task> {
        @Override
        public void refreshAllData(Map criteria) {
            tasks = new ArrayList<>(getFakeTasks(MockView.getFakeTaskCriteria()));
        }
    }

    private class NameDataProvider extends MockDB implements DbDataProvider<String> {
        @Override
        public void refreshAllData(Map criteria) {
            names = new ArrayList<>(getFakeNames(MockView.getFakeNameCriteria()));
        }
    }

    public static void main(String[] args) {

    }
}
