package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
	this.size = 0;
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

@Override
public void insert(EntryPair entry) {
	int hole = (size + 1);
	insertBubble(hole, entry);
	size++;
}

private void insertBubble(int hole, EntryPair entry) {
	if (hole == 1) {
		array[hole] = entry;
	} else {
		int temp = entry.getPriority();
		int p = Math.floorDiv(hole, 2);
		if (array[p].getPriority() < temp) {
			array[hole] = entry;
		} else {
			array[hole] = array[p];
			insertBubble(p, entry);
		}
	}
}

@Override
public void delMin() {
	if (size == 0) {
		return;
	}
	//if not empty
	array[1] = null;
	EntryPair temp = array[size];
	array[size] = null;
	delBubble(1, temp);
	size--;
}

private void delBubble(int hole, EntryPair temp) {
	int l = (hole * 2);
	int r = ((hole * 2) + 1);
	//may have to check for null slots here
	if (array[l] == null && array[r] == null) {
		array[hole] = temp;
		return;
	} else if (array[r] == null) {
		if (array[l].getPriority() > temp.getPriority()) {
			array[hole] = temp;
			return;
		} else {
			array[hole] = array[l];
			delBubble(l, temp);
		}
	} else if (array[l].getPriority() > temp.getPriority() && array[r].getPriority() > temp.getPriority()) {
		array[hole] = temp;
		return;
	} else {
		if (array[l].getPriority() < array[r].getPriority()) {
			array[hole] = array[l];
			delBubble(l, temp);
		} else {
			array[hole] = array[r];
			delBubble(r, temp);
		}
	}
}

@Override
public EntryPair getMin() {
	if (size == 0) {
		return null;
	} else {
		return array[1];
	}
}

@Override
public int size() {
	return size;
}

@Override
public void build(EntryPair[] entries) {
	//structure
	int g = 1;
	for (int i = 0; i < entries.length; i++) {
		array[g] = entries[i];
		size++;
		g++;
	}
	//do the bubble for heap-order
	for (int p = Math.floorDiv(size, 2); p > 0; p--) {
		buildBubble(p);
	}
}

private void buildBubble(int p) {
	int l = (p * 2);
	int r = ((p * 2) + 1);
	//may need to check for null slots here
	if (array[l] == null && array[r] == null) {
		return;
	} else if (array[r] == null) {
		if (array[p].getPriority() < array[l].getPriority()) {
			return;
		} else {
			EntryPair temp = array[p];
			array[p] = array[l];
			array[l] = temp;
		}
	} else if (array[p].getPriority() < array[l].getPriority() && array[p].getPriority() < array[r].getPriority()) {
		return;
	} else {
		EntryPair temp = array[p];
		if (array[l].getPriority() < array[r].getPriority()) {
			array[p] = array[l];
			array[l] = temp;
			buildBubble(l);
		} else {
			array[p] = array[r];
			array[r] = temp;
			buildBubble(r);
		}
	}
}

}