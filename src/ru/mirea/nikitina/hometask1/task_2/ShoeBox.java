package ru.mirea.nikitina.hometask1.task_2;

public class ShoeBox implements Box<Shoe> {
    private Shoe shoe;

    @Override
    public Shoe open() {
        return shoe;
    }

    @Override
    public void put(Shoe item) {
        shoe = item;
    }

    @Override
    public Shoe removeFromBox() {
        Shoe item = shoe;
        shoe = null;
        return item;
    }
}
