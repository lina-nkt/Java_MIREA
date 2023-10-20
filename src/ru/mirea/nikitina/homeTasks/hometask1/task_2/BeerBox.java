package ru.mirea.nikitina.homeTasks.hometask1.task_2;

public class BeerBox implements Box<Beer> {
    private Beer beer;

    @Override
    public Beer open() {
        return beer;
    }

    @Override
    public void put(Beer item) {
        beer = item;
    }

    @Override
    public Beer removeFromBox() {
        Beer item = beer;
        beer = null;
        return item;
    }
}
