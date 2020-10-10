
Customised Database Management System
import java.util.*;

class Node
{
 public int rno;
 public String name;
 public int age;
 public Node next;

{
 this.next = null;
 }

 public Node(int i,String str, int j)
 {
 this.rno = i;
 this.name = str;
 this.age = j;
 }
}

/////////////////////////////////////////////////

interface LinkedLL
  {
 public void InsertFirst(int i,String s,int j);

 public void InsertLast(int i,String s,int j);

 public int Count();

 public void Display();

 public void Search(int z);

 public void Search(String y);

 public void Delete(int a);

 public void Delete(String a);

 public void Update(int a);
}

/////////////////////////////////////////////////


class Student implements LinkedLL
 {
 public Node head;
 public int size;

 public Student()
 {
 head = null;
 size = 0;
 }

 public void InsertFirst(int i,String s,int j)
 {
 Node newn = new Node(i,s,j);

 if(this.head == null)
 {
 this.head = newn;
 }
 else
 {
 newn.next = this.head;
 this.head = newn;
 }
 this.size++;
 }

 public void InsertLast(int i,String s,int j)
 {
 Node temp = this.head;
 Node newn = new Node(i,s,j);

 if(this.head == null)
 {
 this.head = newn;
 }
 else
 {
 while(temp.next != null)
 {
 temp = temp.next;
 }

 temp.next = newn;
 }
 this.size++;
 }

 public void Display()
 {
 Node temp = this.head;

 System.out.println("Members of linked list");

 while(temp != null)
 {
 System.out.println("Rno : "+temp.rno+" Name : "+temp.name+"
		Age :"+temp.age);

 temp = temp.next;
 }
 }

 public int Count()
 {
 return this.size;
 }

 public void Search(int no)
 {
 Node temp = this.head;

 while(temp != null)
 {
 if(temp.rno == no)
 {
 break;
 }
 temp = temp.next;
 }

 if(temp == null)
 {
 System.out.println("There is no such member");
 }
 else
 {
 System.out.println("Member found of Roll no" +no);
 System.out.println("Name : "+temp.name);
 System.out.println("Roll number : "+temp.rno);
 System.out.println("Age : "+temp.age);
 }
}


 public void Search(String str)
 {
 Node temp = this.head;

 while(temp != null)
 {
 if(str.equals(temp.name))
 {
 break;
 }
 temp = temp.next;
 }

 if(temp == null)
 {
 System.out.println("There is no such member");
 }
 else
 {
 System.out.println("Member found of name " +str);
 System.out.println("Name : "+temp.name);
 System.out.println("Roll number : "+temp.rno);
 System.out.println("Age : "+temp.age);
 }
 }

 public void Delete(int no)
 {
 Node temp = this.head;
 int i = 0;
 if(head == null)
 {
 return;
 }
 if(head.rno == no)
 {
 head = head.next;
 this.size--;
 return;
 }

 for(i = 1; i< this.size;i++)
 {
 if(temp.next.rno == no)
 {
 break;
 }
 temp=temp.next;
 }

 if(i == this.size)
 {
 System.out.println("No element");
 }
 else
 {
 temp.next=temp.next.next;
 this.size--;
 }
 }

public void Delete(String str)
 {
 Node temp = this.head;
 int i = 0;
 if(head == null)
 {
 return;
 }
 if(str.equals(head.name))
 {
 head = head.next;
 this.size--;
 return;
 }

 for(i = 1; i< this.size;i++)
 {
 if(str.equals(temp.next.name))
 {
	  break;
}
 temp=temp.next;
  }

 if(i == this.size)
 {
 System.out.println("No element");
 }
 else
 {
 temp.next=temp.next.next;
 this.size--;
 }
 }

 public void Update(int no)
 {
 Node temp = this.head;

 while(temp != null)
 {
if(temp.rno == no)
 {
 break;
 }
 temp = temp.next;
 }

 if(temp == null)
 {
 System.out.println("There is no such member");
 }
 else
 {
 Scanner sobj = new Scanner(System.in);
 System.out.println("Update : Name / Age / Both");
 System.out.println("1/2/3");

 int option = sobj.nextInt();
 System.out.println(option);

 switch(option)
 {
 case 3:
 case 1:
 System.out.println("Enter new name");
 sobj.nextLine();
 String s = sobj.nextLine();
 temp.name = s;

 if(option == 1)
 break;

 case 2:
 System.out.println("Enter new age");
 int j = sobj.nextInt();
temp.age = j;
 break;
 }

 }
 }
}


/////////////////////////////////////////////////

class Demo
{
 public static void main(String arg[])
 {
 Student ss = null;

 Scanner sobj = new Scanner(System.in);

 System.out.println("Marvellous DB Started");

 while(true)
 {
 System.out.println("MarvellousDB:>");
 String query = sobj.nextLine();

 String tokens[] = query.split("\\s");
 // stop
 if(tokens.length ==1)
 {
 if(query.equalsIgnoreCase("stop"))
 {
 System.out.println("Thank you for using Marvellous DB");
 break;
 }
 }

 // select * from student;
 if(tokens.length == 4)
 {
if(tokens[0].equalsIgnoreCase("select"))
 ss.Display();
 }

 // insert into student value 11 asdas 21
 // delete from student where rno = 11
 if(tokens.length == 7)
 {
 if(tokens[0].equalsIgnoreCase("insert"))
 {

ss.InsertFirst(Integer.parseInt(tokens[4]),tokens[5],Integer.parseInt(tokens[6]));
 }
 if(tokens[0].equalsIgnoreCase("delete"))
 {
 if(ss == null)
 {
 System.out.println("Table is not present");
 continue;
 }

 ss.Delete(Integer.parseInt(tokens[6]));
 }
 }

 // create table student
 if(tokens.length == 3)
 {
 if(tokens[0].equalsIgnoreCase("create"))
 ss = new Student();
 }
 }
 }
}
