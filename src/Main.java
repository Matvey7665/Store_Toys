class  Main{
    public static void main(String[] args) {
        ToyStore store = new ToyStore();
        store.addToy(1,"Toy1",10,20);
        store.addToy(2,"Toy2",5,10);
        store.addToy(3,"Toy3",20,70);
        store.setToyWeight(2,30);
        store.play();
        store.getPrizeToy();
    }
}