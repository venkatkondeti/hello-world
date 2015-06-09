import java.util.Arrays;


public class arrayList<T extends Comparable<T>> {

	private Object[] array;
	private int size;
	private static final int INIT_SIZE = 10;
	
	public arrayList() {
		System.out.println("constructor invoked");
		this.array = new Object[INIT_SIZE];
		this.size=0;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public boolean contains(Object o){
		return indexOf(o) >= 0;
	}
	
	private int indexOf(Object o){
		if(o==null){
			for(int i=0;i<size;i++){
				if(array[i]==null)
					return i;
			}
		}else{
			for(int i = 0; i < size ;i++){
				if(array[i].equals(o))
					return i;
			}
		}
		return -1;
	}
	
	public boolean add(Object o){
		ensureCapacity(this.size+1);
		this.array[size]=o;
		this.size++;
		return true;
	}
	
	private void ensureCapacity(int minCapacity){
		int oldCapacity = array.length;
		int newCapacity = (oldCapacity*3)/2+1;
		if(minCapacity>oldCapacity){
			array = Arrays.copyOf(array, newCapacity);
		}
	}
	
	public boolean remove(Object o){
		if(o==null){
			for(int i=0; i<size; i++){
				if(array[i]==null){
					fastRemove(i);
					//this.size--;
					return true;
				}
			}
		}else{
			for(int i=0; i<size; i++){
				if(o.equals(array[i])){
					fastRemove(i);
					//this.size--;
					return true;
				}
			}
		}
		return false;
	}
	
	private void fastRemove(int index){
		int numMoved = size - index - 1;
		System.arraycopy(array, index+1, array, index, numMoved);
		
		array[--size] = null;
	}
	
	public static void main(String[] args) {
		arrayList<Integer> list = new arrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		System.out.println(list.getSize());
		System.out.println(list.remove(8));
		System.out.println(list.getSize());
	}
}
