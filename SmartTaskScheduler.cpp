#include <bits/stdc++.h>
using namespace std;

struct Task {
    int taskId;
    int userId;
    int priority;
    int deadline;
    string category;

    Task(int t, int u, int p, int d, string c)
        : taskId(t), userId(u), priority(p), deadline(d), category(c) {}
};

// Comparator for max-heap
struct CompareTask {
    bool operator()(const Task& a, const Task& b) {
        if (a.priority != b.priority)
            return a.priority < b.priority; // higher priority first
        if (a.deadline != b.deadline)
            return a.deadline > b.deadline; // earlier deadline first
        return a.taskId > b.taskId;         // smaller taskId first
    }
};

class SmartTaskScheduler {
    priority_queue<Task, vector<Task>, CompareTask> taskHeap;
    unordered_map<int, Task> taskMap; // taskId -> Task
    unordered_set<int> removed;        // lazy deletion
    unordered_map<string, set<int>> categoryMap; // category -> taskIds

public:
    void addTask(int taskId, int userId, int priority, int deadline, string category) {
        Task t(taskId, userId, priority, deadline, category);
        taskHeap.push(t);
        taskMap[taskId] = t;
        categoryMap[category].insert(taskId);
    }

    void editTaskPriority(int taskId, int newPriority) {
        if (taskMap.find(taskId) == taskMap.end()) return;
        Task t = taskMap[taskId];
        removed.insert(taskId); // mark old task as invalid
        Task newTask(t.taskId, t.userId, newPriority, t.deadline, t.category);
        taskHeap.push(newTask);
        taskMap[taskId] = newTask;
    }

    void removeTask(int taskId) {
        if (taskMap.find(taskId) == taskMap.end()) return;
        removed.insert(taskId);
        string cat = taskMap[taskId].category;
        categoryMap[cat].erase(taskId);
        taskMap.erase(taskId);
    }

    int executeTopTask() {
        while (!taskHeap.empty()) {
            Task t = taskHeap.top();
            taskHeap.pop();
            if (removed.count(t.taskId)) continue; // skip invalid tasks

            // execute task
            removed.insert(t.taskId);
            taskMap.erase(t.taskId);
            categoryMap[t.category].erase(t.taskId);
            return t.taskId;
        }
        return -1; // no tasks left
    }

    vector<int> topTasksInCategory(string category, int k = 3) {
        vector<Task> tasks;
        for (int tid : categoryMap[category]) {
            tasks.push_back(taskMap[tid]);
        }
        sort(tasks.begin(), tasks.end(), CompareTask());
        vector<int> result;
        for (int i = 0; i < min(k, (int)tasks.size()); i++)
            result.push_back(tasks[i].taskId);
        return result;
    }
};

int main() {
    SmartTaskScheduler scheduler;

    scheduler.addTask(101, 1, 50, 5, "bug");
    scheduler.addTask(102, 2, 60, 3, "feature");
    scheduler.addTask(103, 1, 50, 4, "bug");
    scheduler.addTask(104, 3, 70, 6, "research");
    scheduler.addTask(105, 2, 50, 3, "feature");

    cout << "Executing top task: " << scheduler.executeTopTask() << endl; // 104
    cout << "Executing top task: " << scheduler.executeTopTask() << endl; // 102

    scheduler.editTaskPriority(101, 80); // boost priority
    cout << "Executing top task: " << scheduler.executeTopTask() << endl; // 101

    auto topBugs = scheduler.topTasksInCategory("bug");
    cout << "Top bugs remaining: ";
    for (int tid : topBugs) cout << tid << " ";
    cout << endl;

    return 0;
}
