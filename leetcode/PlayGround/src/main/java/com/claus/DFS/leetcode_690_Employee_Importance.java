package com.claus.DFS;

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class leetcode_690_Employee_Importance {
    // DFS 递归
    public int getImportance_1(List<Employee> employees, int id) {
        for (Employee e: employees) {
            if (e.id == id) {
                if (e.subordinates.size() == 0) {
                    return e.importance;
                }
                for (int subId: e.subordinates) {
                    e.importance += getImportance_1(employees, subId);
                }
            }
            return e.importance;
        }
        return 0;
    }

    // 队列存储待处理的Employee
    public int getImportance_2(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        Deque<Employee> queue = new LinkedList<>();
        queue.addLast(map.get(id));
        int res = 0;
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            res += e.importance;
            for (int subId: e.subordinates) {
                queue.addLast(map.get(subId));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        Integer[] sub1 = new Integer[]{2, 3};
        e1.subordinates = Arrays.asList(sub1);
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new LinkedList<>();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new LinkedList<>();
        List<Employee> emps = new LinkedList<>();
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);
        leetcode_690_Employee_Importance solution = new leetcode_690_Employee_Importance();
        int res = solution.getImportance_2(emps, 1);
    }
}
