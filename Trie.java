package trie;

public class Trie {
	
	private TSTNode root;
	private int size;
	
	
	public boolean contains(String key){
		return auxContains(root,key);
	}
	
	private boolean auxContains(TSTNode current, String key){
		if(key.charAt(0) == current.data){
			if(key.length()>1){
				return auxContains(current.middle, key.substring(1));
			}else{
				return current.isWord==true;
			}
		}else if(key.charAt(0)<current.data){
			return auxContains(current.left, key);
		}else{
			return auxContains(current.right, key);
		}
	}
	
	public void add(String key){
		root = auxAdd(root, key);
	}
	
	private TSTNode auxAdd(TSTNode current, String key){
		if(current == null ){
			 current = new TSTNode(key.charAt(0));
		}
		if(key.charAt(0)==current.data){
			if(key.length()>1)
				current.middle=auxAdd(current.middle, key.substring(1));
			else{
				current.isWord=true;
				size++;
			}
		}else if(key.charAt(0)<current.data){
			current.left=auxAdd(current.left, key);
		}else{
			current.right=auxAdd(current.right, key);
		}
		return current;
	}
	
	
	static class TSTNode{
		boolean isWord;
		char data;
		TSTNode left;
		TSTNode middle;
		TSTNode right;
		public TSTNode(char data) {
			this.data=data;
		}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("venkat");
		trie.add("kondeti");
		trie.add("accenture");
		trie.add("hyderabad");
		trie.add("mindspace");
		System.out.println(trie.contains("venkat"));
		System.out.println(trie.size);
	}
}
