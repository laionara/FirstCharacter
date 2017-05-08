package main;

public class StreamImpl implements Stream {

	private String string;
	private int count;
	
	public StreamImpl(String string) {
		if(string == null)
			string = new String();
		this.string = string;
		count = 0;
	}
	
	@Override
	public boolean hasNext() {
		return count < string.length();
	}
	
	@Override
	public char getNext() {
		return string.charAt(count++);
	}
}
