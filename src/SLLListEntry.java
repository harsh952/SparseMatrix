//Harshkumar Desai
//CS435 - Project 1

public class SLLListEntry extends ListEntry {
	private SLLListEntry next;

	public SLLListEntry(int value, int i, int j, SLLListEntry next) {
	    super(value, i, j);
	    this.next = next;
	}
	public SLLListEntry getNext(){
		return next;
	}
	public void setNext(SLLListEntry next) {
			this.next = next;
	}

}
