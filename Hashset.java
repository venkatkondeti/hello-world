package hashset;

public class Hashset<T extends Comparable<T>> {
	private static final int THREHOLD=10;
	private static final int INIT_SIZE = 11;
	public Entry<T>[] array;
	private int size =0;
	
	public Hashset() {
		this.array = new Entry[INIT_SIZE];
		for(int i = 0;i<INIT_SIZE;i++){
			array[i]=new Entry<T>(null);
		}
	}
	
	public int getSize(){
		return this.size;
	}
	
	public boolean contains(T t){
		int index = t.hashCode()%array.length;
		return listFind(array[index], t);
	}
	
	private boolean listFind(Entry<T> entry, T t){
		for(Entry<T> curr=entry.next; curr!=null;curr=curr.next ){
			if(curr.t.compareTo(t)==0)
				return true;
		}
		return false;
	}
	
	public boolean remove(T t){
		int index = t.hashCode()%array.length;
		return entryRemove(array[index], t);
	}
	
	private boolean entryRemove(Entry<T> entry, T t){
		Entry<T> temp = entry;
		boolean isRemoved = false;
		for(Entry<T> curr = entry.next; curr != null; curr = curr.next){
			temp = curr;
			if(curr.t.compareTo(t)==0){
				temp.next= curr.next;
				this.size--;
				isRemoved = true;
				break;
			}
		}
		return isRemoved;
	}
	
	public boolean add(T t){
		if((size/array.length)>THREHOLD)
			rehash();
		
		int index = t.hashCode()%array.length;
		this.size++;
		return addEntry(array[index], t);
	}
	
	private void rehash(){
		Entry<T>[] newArray = new Entry[(int) (array.length*1.5)];
		for(int i = 0; i<newArray.length;i++){
			newArray[i] = new Entry<T>(null);
		}
		for(int i =0; i<array.length;i++){
			for(Entry<T> curr=array[i].next;curr!=null;curr=curr.next){
				int index = curr.t.hashCode()%newArray.length;
				addEntry(newArray[index], curr.t);
			}
		}
		array=newArray;
	}
	
	
	private boolean addEntry(Entry<T> entry, T t){
		Entry<T> temp = entry;
		Entry<T> newEntry = new Entry<T>(t);
		for(Entry<T> curr = entry.next;curr!=null;curr= curr.next){
			temp = curr;
			if(curr.t.compareTo(t)==0)
				return false;
		}
		temp.next = newEntry;
		return true;
	}
	
	private static class Entry<T>{
		Entry<T> previous;
		Entry<T> next;
		T t;
		public Entry(T t) {
			this.t = t;
		}
	}
	
	public static void main(String[] args) {
		Hashset<Integer> set = new Hashset<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		System.out.println(set.getSize());
		System.out.println(set.contains(1));
		System.out.println(set.contains(2));
		System.out.println(set.contains(3));
		System.out.println(set.contains(4));
		System.out.println(set.contains(5));
		System.out.println(set.remove(6));
		System.out.println(set.getSize());
	}
}
