import java.util.*;

class lect4_Heap{
    static class Heap{
        List<Integer> heap;
        Heap(){
            heap = new ArrayList();
        }
        void add(int ele){
            heap.add(ele);
            upHeapify(heap.size()-1);
        }
        void upHeapify(int childIdx){
            if(childIdx == 0) return;
            int parentIdx = (childIdx - 1) / 2;
            if(heap.get(parentIdx) > heap.get(childIdx)){
                //parent a data hesha choota hoga by its child or iss cond meh parent ka data big hogya
                swap(parentIdx,childIdx);
                upHeapify(parentIdx);
            }   
        }
        private void swap(int aidx, int bidx) {
                int temp = heap.get(aidx);
                int temp2 = heap.get(bidx);
                heap.set(aidx,temp2);
                heap.set(bidx,temp);
        }
        int removeTop(){
            //swap the first with lst
    
            swap(0, heap.size()-1);
            int val = heap.remove(heap.size()-1);
            downHeapify(0);
            return val;
        }
        private void downHeapify(int parentIdx) {
            int leftChildIdx = 2*parentIdx+1;
            int rightChildIdx = 2*parentIdx+2;
            int letMinIdx = parentIdx;
            if(leftChildIdx >= heap.size() || rightChildIdx>=heap.size()) return;
            if(heap.get(letMinIdx)>heap.get(leftChildIdx)){
                letMinIdx = leftChildIdx;
            }
            if(heap.get(letMinIdx)>heap.get(rightChildIdx)){
                letMinIdx = rightChildIdx;
            }
            if(letMinIdx != parentIdx){
                //swap lmi with pi
                swap(parentIdx, letMinIdx);
                downHeapify(letMinIdx);
            }
        }
        int getMin(){
            return heap.get(0);
        }
    }
    public static void main(String[] args) {
        int [] arr = {10,9,8,7,6,5,4,3,2,1};
        Heap minHeap = new Heap();
        for(int i:arr) minHeap.add(i);
        System.out.print("Min ele: "+minHeap.getMin()+"\n");
        System.out.print("Removed ele: "+minHeap.removeTop()+"\n");
        System.out.print("Min ele: "+minHeap.getMin()+"\n");
        System.out.print("Removed ele: "+minHeap.removeTop()+"\n");
        System.out.print("Min ele: "+minHeap.getMin()+"\n");
    }
}