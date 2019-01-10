package demo.se.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            hashSet.add("Some strange text: " + i);
            treeSet.add("Some strange text: " + i);
        }
        Iterator<String> hashIterator = hashSet.iterator();
        Iterator<String> treeIterator = treeSet.iterator();
        while (hashIterator.hasNext() || treeIterator.hasNext()) {
            System.out.println("Hash: " + hashIterator.next() + ", tree: " + treeIterator.next());
        }
    }
}
