package com.qly.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qly
 */
public class DogCatQueue {
    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Dog());
        System.out.println(dogCatQueue.isEmpty());
        dogCatQueue.pollAll();
        dogCatQueue.pollAll();
        System.out.println(dogCatQueue.isCatQueueEmpty());
        System.out.println(dogCatQueue.isDogQueueEmpty());
        dogCatQueue.pollAll();
        dogCatQueue.pollAll();
        System.out.println(dogCatQueue.isEmpty());
        dogCatQueue.pollDog();
    }

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if ("dog".equals(pet.getPetType())) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if ("cat".equals(pet.getPetType())) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err, not dog or cat!");
        }
    }

    public Pet pollAll() {
        if (!this.isCatQueueEmpty() && !this.isDogQueueEmpty()) {
            if (this.catQ.peek().getCount() < this.dogQ.peek().getCount()) {
                return this.catQ.poll().getPet();
            } else {
                return this.dogQ.poll().getPet();
            }
        } else if (!this.isCatQueueEmpty()) {
            return this.catQ.poll().getPet();
        } else if (!this.isDogQueueEmpty()) {
            return this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Dog pollDog() {
        if (!this.isDogQueueEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("err, dog queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, cat queue is empty!");
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }
}

class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterPetType() {
        return this.pet.getPetType();
    }
}

/**
 * base
 */
class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}
