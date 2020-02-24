package MinBinHeap_A3;

public class MinBinHeap_Playground {
  public static void main(String[] args){   
    //Add more tests as methods and call them here!!
    TestBuild();
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
    MinBinHeap mbh= new MinBinHeap();
//    EntryPair[] collection= new EntryPair[8];
//    collection[0]=new EntryPair("i",3);
//    collection[1]=new EntryPair("b",5);
//    collection[2]=new EntryPair("c",1);
//    collection[3]=new EntryPair("d",0);
//    collection[4]=new EntryPair("e",46);
//    collection[5]=new EntryPair("f",5);
//    collection[6]=new EntryPair("g",6);
//    collection[7]=new EntryPair("h",17);
//    mbh.build(collection);
//    printHeapCollection(collection);
//    //for (int i = 0; i<9; i++) {System.out.print(mbh.getHeap()[i] + "\t");}
//    printHeap(mbh.getHeap(), mbh.size());
//    System.out.println(mbh.getMin().getValue() + mbh.getMin().getPriority());
//    System.out.println(mbh.size());
//    mbh.delMin();
//    printHeap(mbh.getHeap(), mbh.size());
//    System.out.println(mbh.size());
//    EntryPair ep = new EntryPair("d", 0);
//    mbh.insert(ep);
//    printHeap(mbh.getHeap(), mbh.size());
//    mbh.insert(new EntryPair("z", 2));
//    printHeap(mbh.getHeap(), mbh.size());
//    
//    MinBinHeap mbh2 = new MinBinHeap();
//    mbh2.insert(new EntryPair("a", 2));
//    mbh2.insert(new EntryPair("b", 2));
//    printHeap(mbh2.getHeap(), mbh2.size());
    mbh.insert(new EntryPair("a", 1));
    mbh.insert(new EntryPair("b", 2));
    mbh.insert(new EntryPair("c", 3));
    System.out.println(mbh.size());
    printHeap(mbh.getHeap(), mbh.size());
    mbh.delMin();
    printHeap(mbh.getHeap(), mbh.size());
    mbh.delMin();
    printHeap(mbh.getHeap(), mbh.size());
    mbh.delMin();
    printHeap(mbh.getHeap(), mbh.size());


  }
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
}