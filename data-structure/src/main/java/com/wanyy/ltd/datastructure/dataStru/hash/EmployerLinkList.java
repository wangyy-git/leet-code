package com.wanyy.ltd.datastructure.dataStru.hash;

public class EmployerLinkList {
    //此处头指针是有效，是该链表的第一个Employee
    private Employee head;
    //假定传进来的id是自增长的
    public void add(Employee emp){
        if (head == null){
            //是第一个
            head = emp;
            return;
        }
        Employee temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        
        temp.next = emp;
    }
    

    public void addByOrder(Employee employee){
        
        if (head == null){
            //是第一个
            head = employee;
            return;
        }
        Employee temp = head;
        if (head.id > employee.id){
            head = employee;
            head.next = temp;
            return;
        }
        
        while (true){
            Employee tempNext = temp.next;
            if (tempNext == null || tempNext.id > employee.id){
                employee.next = temp.next;
                temp.next = employee;
                return;
            }
            temp = temp.next;
        }
        
    }


    public Employee find(int no){
        if (head == null){
            System.out.println("员工号为 " + no + " 的雇员不存在...");
            return null;
        }
        
        Employee temp = head;
        
        while (temp != null){
            if (temp.id == no){
                return temp;
            }
            temp = temp.next;
        }

        System.out.println("未找到" + no + "对应的员工信息...");
        return null;
    }
    
    
    public boolean deleteById(int id){

        Employee employee = find(id);
        if (employee == null){
            System.out.println("员工号为 " + id + " 的雇员不存在...");
            return false;
        }
        Employee next = employee.next;
        Employee temp = head;
        while (temp != null){
            if (temp.next == employee){
                temp.next = next;
                return true;
            }
            temp = temp.next;
            
        }
        
        return false;
    }
    public void list(){
        if (head == null){
            System.out.println("当前链表为空....");
            return;
        }
        
        Employee temp = head;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class Employee{
    int id;
    String name;
    Employee next;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}
