package linkedlists;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {

	private transient Entry<E> header = new Entry<E>(null, null, null);
	private transient int size = 0;

	public DoubleLinkedList() {
		header.previous = header.next = header;
	}

	public E getFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		return header.next.element;
	}

	public E getLast() {
		if (size == 0)
			throw new NoSuchElementException();
		return header.previous.element;
	}

	public boolean add(E e) {
		addBefore(e, header);
		return true;
	}

	public void addFirst(E e) {
		addBefore(e, header.next);
	}

	public void addLast(E e) {
		addBefore(e, header);
	}

	public int getSize() {
		return size;
	}

	private Entry<E> addBefore(E e, Entry<E> entry) {
		Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
		newEntry.previous.next = newEntry;
		newEntry.next.previous = newEntry;
		size++;
		return newEntry;
	}

	public void display() {
		Entry<E> curr = header.next;
		while (curr != header) {
			System.out.println(curr.element);
			curr = curr.next;
		}
	}

	public E remove(Entry<E> e) {
		if (e == header)
			throw new NoSuchElementException();
		E result = e.element;
		e.previous.next = e.next;
		e.next.previous = e.previous;
		e.next = e.previous = null;
		e.element = null;
		size--;
		return result;

	}

	private Entry<E> entry(int index) {
		if (index >= size)
			throw new NoSuchElementException();
		Entry<E> e = header;
		if (index < (size >> 1)) {
			for (int i = 0; i <= index; i++) {
				e = e.next;
			}
		} else {
			for (int i = size; i > index; i++)
				e = e.previous;
		}
		return e;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (Entry<E> e = header.next; e != header; e = e.next){
				if(e.element==null){
					remove(e);
					return true;
				}
			}
		}else{
			for(Entry<E> e=header.next;e!=header;e=e.next){
				if(o.equals(e.element)){
					remove(e);
					return true;
				}
			}
		}
		return false;
	}

	public E remove(int index) {
		return remove(entry(index));
	}
	
	public E removeFirst(){
		return remove(header.next);
	}
	
	public E removeLast(){
		return remove(header.previous);
	}

	
	
	private static class Entry<E> {
		E element;
		Entry<E> next;
		Entry<E> previous;

		Entry(E element, Entry<E> next, Entry<E> previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

		List<Integer> ls = new LinkedList<Integer>();
		ls.add(1);
		System.out.println(ls);

		list.add(4);
		list.add(5);
		list.add(6);
		list.display();
		list.addFirst(3);
		list.addFirst(2);
		list.display();
		list.remove(null);
	}
}
