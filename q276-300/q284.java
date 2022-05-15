// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/peeking-iterator/

// idea: https://leetcode.com/problems/peeking-iterator/discuss/72558/Concise-Java-Solution
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    public Iterator<Integer> iter;
    public Integer next = null; // Integer object
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
	    if (iter.hasNext()) {
            next = iter.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ret = next;
        if (iter.hasNext()) {
            next = iter.next(); // move iter and next forward
            return ret;
        } else {
            next = null;
            return ret;
        }
	}
	
	@Override
	public boolean hasNext() {
	    return (next!=null);
	}
}