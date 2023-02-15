package main.java.com.datastructure.pointslocator.models;

import java.util.ArrayList;
import java.util.List;

public class TwoDTree {
    private class TreeNode{
        Point item;
        TreeNode l;
        TreeNode r;

        int size(){
            int ownSize = 1;

            if (l != null)
                ownSize += l.size();

            if (r != null)
                ownSize += r.size();

            return  ownSize;
        }

        void insert(Point p, boolean reverse) throws Exception {
            if (p.Y() == item.Y() && p.X() == item.X())
                throw new Exception("Point already exists");

            if (reverse) {
                if (p.Y() < item.Y()){
                    if (l == null){
                        l = new TreeNode();
                        l.item = p;
                    } else {
                        l.insert(p, false);
                    }
                } else{
                    if (r == null){
                        r = new TreeNode();
                        r.item = p;
                    } else {
                        r.insert(p, false);
                    }
                }
            } else {
                if (p.X() < item.X()){
                    if (l == null){
                        l = new TreeNode();
                        l.item = p;
                    } else {
                        l.insert(p, true);
                    }
                } else{
                    if (r == null){
                        r = new TreeNode();
                        r.item = p;
                    } else {
                        r.insert(p, true);
                    }
                }
            }
        }

        boolean exists(Point p, boolean reverse){
            if (p.X() == item.X() && p.Y() == item.Y())
                return true;

            if (reverse) {
                if (r == null)
                    return false;
                return r.exists(p, false);
            } else {
                if (l == null)
                    return false;
                return l.exists(p, true);
            }
        }
    }
    private TreeNode head;

    public TwoDTree() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size(){
        if (isEmpty()) return 0;

        return head.size();
    }

    public void insert(Point p){
        if (isEmpty()){
            head = new TreeNode();
            head.item = p;
            return;
        }

        try {
            head.insert(p, false);
        } catch (Exception ex){
            System.out.println("Point already in the tree");
        }
    }


    public boolean search(Point p){
        if (isEmpty()) return false;

        return head.exists(p, false);
    }

    public Point nearestNeighbor(Point p) throws Exception {
        if (isEmpty())
            return null;

        throw new UnsupportedOperationException();
    }

    public List<Point> rangeSearch(Rectangle rect) throws Exception {
        throw new UnsupportedOperationException();
    }
}
