package bj.ch04_LinkedList;

import java.io.*;
import java.util.*;

public class BJ_1158_03 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Node head = new Node(1);
        head.setNxt(head);
        head.setPre(head);
        Node lts = head;
        for (int i = 2; i <= N; i++) {
            Node tmp = new Node(i);
            tmp.setPre(head);
            tmp.setNxt(head);
            lts = tmp;
            head.setNxt(lts);
            head.setPre(tmp);
        }
        Node tmp = head;
        // for (int i = 0; i < 7; i++) {
        //     System.out.println(tmp.toString());
        //     tmp = head.getNxt();
        // }
        System.out.println(head.getPre().getData());
    }

    private static class Node {
        private Node nxt, pre;
        private int data;

        public Node(int data) {
            this.nxt = null;
            this.pre = null;
            this.data = data;
        }

        public Node getNxt() {
            return nxt;
        }

        public void setNxt(Node nxt) {
            this.nxt = nxt;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [nxt=" + nxt + ", pre=" + pre + ", data=" + data + "]";
        }

    }
}
