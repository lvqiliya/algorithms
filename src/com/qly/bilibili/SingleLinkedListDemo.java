package com.qly.bilibili;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(new HeroNode(1, "宋江", "及时雨"));
        list.addByOrder(new HeroNode(4, "公孙胜", "入云龙"));
        list.addByOrder(new HeroNode(3, "吴用", "智多星"));
        list.addByOrder(new HeroNode(2, "卢俊义", "玉麒麟"));
        list.update(new HeroNode(2, "", ""));
        list.delete(3);
        list.delete(1);
        list.delete(4);
        list.list();
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode();

    public void add(HeroNode heroNode) {
        HeroNode cur = head;
        // 遍历链表，直到链尾
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode cur = head;
        while (cur.next != null) {
            if (cur.next.no == heroNode.no) {
                throw new RuntimeException("Duplicate no!");
            } else if (cur.next.no < heroNode.no) {
                cur = cur.next;
            } else {
                heroNode.next = cur.next;
                cur.next = heroNode;
                return;
            }
        }
        cur.next = heroNode;
    }

    public void update(HeroNode heroNode) {
        HeroNode cur = head;
        while (cur.next != null) {
            if (cur.next.no == heroNode.no) {
                cur.next.name = heroNode.name;
                cur.next.nickName = heroNode.nickName;
                return;
            }
            cur = cur.next;
        }
        throw new RuntimeException("Not matched to update!");
    }

    public void delete(int no) {
        HeroNode cur = head;
        while (cur.next != null) {
            if (cur.next.no == no) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
        throw new RuntimeException("Not matched to delete!");
    }

    public void list() {
        HeroNode cur = head.next;
        if (cur == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        do {
            System.out.println(cur);
            cur = cur.next;
        } while (cur != null);
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }
}