import java.util.Scanner;

class Node
{
	private int data;
	private Node prev;
	private Node next;
	
	public Node()
	{
		data = 0;
		prev = null;
		next = null;
	}
	
	public Node(int d, Node p, Node n)
	{
		data = d;
		prev = p;
		next = n;
	}
	
	public void setData(int d)
	{
		data = d;
	}
	
	public void setPrev(Node p)
	{
		prev = p;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	public int getData()
	{
		return (data);
	}
	
	public Node getPrev()
	{
		return (prev);
	}
	
	public Node getNext()
	{
		return (next);
	}
}

class DoublyLinkedList
{
	private int size;
	private Node start;
	
	public DoublyLinkedList()
	{
		size = 0;
		start = null;
	}
	
	public boolean isEmpty()
	{
		if(start==null)
			return(true);
		else
			return(false);
	}
	
	public int getListSize()
	{
		return(size);
	}
	
	public void insertAtFirst(int value)
	{
		Node NewNodeAdded = new Node();
		NewNodeAdded.setData(value);
		NewNodeAdded.setNext(start);
		NewNodeAdded.setPrev(null);
		start = NewNodeAdded;
		size++;
	}
	
	public void insertAtLast(int value)
	{
		Node NewNodeAdded = new Node();
		NewNodeAdded.setData(value);
		NewNodeAdded.setNext(null);
		Node t = start;
		if(start==null)
		{
			NewNodeAdded.setPrev(null);
			start = NewNodeAdded;
		}
		else
		{
			while(t.getNext()!=null)
			{
				t=t.getNext();
			}
			t.setNext(NewNodeAdded);
			NewNodeAdded.setPrev(t);
		}
		size++;
	}
	
	public void insertAtPos(int value, int pos)
	{
		if(pos==1)
		{
			insertAtFirst(value);
		}
			
		else if(pos==size+1)
		{
			insertAtLast(value);
		}
			
		else if(pos>1&&pos<=size)
		{
			Node NewNodeAdded = new Node();
			NewNodeAdded.setData(value);
			Node t = start;
			if(start==null)
			{
				NewNodeAdded.setNext(null);
				NewNodeAdded.setPrev(null);
				start = NewNodeAdded;
			}
			else
			{
				for(int i=1 ; i<pos-1 ; i++)
				{
					t=t.getNext();
				}
				NewNodeAdded.setNext(t.getNext());
				(t.getNext()).setPrev(NewNodeAdded);
				t.setNext(NewNodeAdded);
				NewNodeAdded.setPrev(t);
			}
			size++;
		}
		else
			System.out.println("Insertion not possible at position : "+pos);
		
	}
	
	public void deleteFirst()
	{
		if(start==null)
			System.out.println("List is already empty.");
		else
		{
			(start.getNext()).setPrev(null);
			start=start.getNext();
			size--;
		}
	}
	
	public void deleteLast()
	{
		if(start==null)
			System.out.println("List is already empty.");
		else
		{
			Node t = start;
			for(int i=1;i<size-1;i++)
			{
				t=t.getNext();
			}
			t.setNext(null);
			size--;
		}
	}
	
	public void deleteAtPos(int pos)
	{
		Node t = start;
		if(start==null)
			System.out.println("List is empty.");
		else if(pos>size||pos<1)
			System.out.println("Invalid position.");
		else if(pos==1)
			deleteFirst();
		else if(pos==size)
			deleteLast();
		else
		{
			for(int i=1;i<pos;i++)
			{
				t=t.getNext();
			}
			(t.getPrev()).setNext(t.getNext());
			(t.getNext()).setPrev(t.getPrev());
			size--;
		}
	}
	
	public void viewList()
	{
		Node t;
		if(isEmpty())
		{
			System.out.println("List is empty.");
		}
		else
		{
			t = start;
			for(int i=1;i<=size;i++)
			{
				System.out.println("  "+t.getData());
				t = t.getNext();
			}
		}
	}
}

public class Main2 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		DoublyLinkedList list = new DoublyLinkedList();
		boolean flag=true;
		while(flag)
		{
			System.out.println("");
			System.out.println("1. Add item to the list at first");
			System.out.println("2. Add item to the list at last");
			System.out.println("3. Add item to the list at position");
			System.out.println("4. Delete item from the list at first");
			System.out.println("5. Delete item from the list at last");
			System.out.println("6. Delete item from the list at position");
			System.out.println("7. View List");
			System.out.println("8. EXIT");
			System.out.println("Enter your choice : ");
			int choice = s.nextInt();
			int position,value;
			switch(choice)
			{
				case 1:
					System.out.println("Enter value of item : ");
					value = s.nextInt();
					list.insertAtFirst(value);
					break;
				case 2:
					System.out.println("Enter value of item : ");
					value = s.nextInt();
					list.insertAtLast(value);
					break;
				case 3:
					System.out.println("Enter position of item : ");
					position = s.nextInt();
					System.out.println("Enter value of item : ");
					value = s.nextInt();
					list.insertAtPos(value, position);
					break;
				case 4:
					list.deleteFirst();
					break;
				case 5:
					list.deleteLast();
					break;
				case 6:
					System.out.println("Enter position : ");
					position = s.nextInt();
					list.deleteAtPos(position);
					break;
				case 7:
					list.viewList();
					break;
				case 8:
					flag=false;
					break;
				default:System.out.println("Invalid choice");
			}
		}
	}
}
