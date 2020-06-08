package com.wanyy.ltd.datastructure.hash;

/**
 * 散列函数
 */
public class HashTable {
    
    private static final int SIZE = 7;

    //还要对数组初始化 要不空指针
    private EmployerLinkList[] linkList;
    public HashTable(){
        linkList = new EmployerLinkList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            linkList[i] = new EmployerLinkList();
        }
    }
    
    //根据id取模来放置
    public void add(Employee emp){
        int index = emp.id%SIZE;
        Employee byId = findById(emp.id);
        if (byId != null){
            System.out.println("当前员工号 " + emp.id + "已存在");
            return;
        }
        EmployerLinkList employerLinkList = linkList[index];
        employerLinkList.add(emp);
    }
    
    public void addByOrder(Employee emp){
        int index = emp.id%SIZE;
        Employee byId = findById(emp.id);
        if (byId != null){
            System.out.println("当前员工号 " + emp.id + "已存在");
            return;
        }

        EmployerLinkList employerLinkList = linkList[index];
        employerLinkList.addByOrder(emp);
    }
    
    public Employee findById(int id){
        EmployerLinkList employerLinkList = linkList[(id)%(SIZE)];
        return employerLinkList.find(id);
    }
    
    public boolean deleteById(int id){
        
        EmployerLinkList employerLinkList = linkList[id%SIZE];
        return employerLinkList.deleteById(id);
    }
    
    public void list(){
        int index = 1;
        for (EmployerLinkList l:linkList){
            System.out.println("第" + (index++) + "个链表:");
            l.list();
        }
    }
}

class Test{
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        

        Employee emp2 = new Employee(2 + 14,"mxm");
        hashTable.addByOrder(emp2);

        Employee emp3 = new Employee(2 + 7,"mxm");
        hashTable.addByOrder(emp3);
        
        Employee emp = new Employee(2,"mxm");
        hashTable.addByOrder(emp);
//        System.out.println(hashTable.findById(3));
        hashTable.list();

        System.out.println("------------------------------");

        System.out.println(hashTable.deleteById(9));

        hashTable.list();
        
    }
}
