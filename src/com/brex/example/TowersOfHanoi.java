package com.brex.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.stream.Collectors;

public class TowersOfHanoi {

    private static class Disk {

        private final int number;

        public Disk(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Disk disk = (Disk) o;
            return number == disk.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public String toString() {
            return "Disk(" + number +
                    ')';
        }
    }

    private static class Tower {
        private final String name;
        private final Deque<Disk> stack = new ArrayDeque<>();

        public Tower(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void addDisk(final Disk disk) {
            stack.push(disk);
        }

        public Disk getTop() {
            return stack.peek();
        }

        public Disk removeTop() {
            return stack.pop();
        }

        public int height() {
            return stack.size();
        }

        public void moveDisk(final Tower dst) {
            dst.addDisk(removeTop());
            System.out.println("Moved " + dst.getTop() + " from " + getName() + " to " + dst.getName());
        }

        public void moveDisks(int n, final Tower dest, final Tower buf) {
            if (n > 0) {
                moveDisks(n - 1, buf, dest);
                moveDisk(dest);
                buf.moveDisks(n - 1, dest, this);
            }
        }

        public void moveDisks(final Tower dest, final Tower buf) {
            moveDisks(height(), dest, buf);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tower tower = (Tower) o;
            return name.equals(tower.name) &&
                    stack.equals(tower.stack);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, stack);
        }

        @Override
        public String toString() {
            return "Tower{" +
                    "name='" + name + '\'' +
                    ", contents =" + stack.stream().map(Disk::toString).collect(Collectors.joining(",")) +
                    '}';
        }
    }

    public static void main(String[] args) {
        Tower a = new Tower("A"), b = new Tower("B"), c = new Tower("C");
        for (int i = 1; i <= 4; ++i) {
            a.addDisk(new Disk(i));
        }
        System.out.print("Initial state \n" + a + '\n' + b + "\n" + c + "\n");
        a.moveDisks(c, b);
        System.out.print("Final state \n" + a + '\n' + b + "\n" + c + "\n");
    }
}

