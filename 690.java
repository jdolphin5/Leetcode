/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    private int recur(Employee e, List<Employee> employees, Map<Integer, Employee> myMap) {
        int ret = 0;
        ret += e.importance;

        for (int subordinateID : e.subordinates) {
            ret += recur(myMap.get(subordinateID), employees, myMap);
        }

        return ret;
    }

    public int getImportance(List<Employee> employees, int id) {
        int totalImportance = 0;
        Map<Integer, Employee> myMap = new HashMap<>();

        for (Employee e : employees) {
            myMap.put(e.id, e);
        }

        totalImportance = recur(myMap.get(id), employees, myMap);

        return totalImportance;
    }
}