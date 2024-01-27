import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizaToys;

    public ToyStore(){
        toys = new ArrayList<>();
        prizaToys = new ArrayList<>();
    }
    public void addToy(int id,String name, int quantity,double weight){
        Toy toy = new Toy(id,name,quantity,weight);
        toys.add(toy);
    }
    public void setToyWeight(int id,double weight){
        for (Toy toy:toys){
            if (toy.getId() == id){
                toy.setWeight(weight);
                break;
            }
        }
    }
    public void play(){
        double totalWeight = 0;
        for (Toy toy:toys){
            totalWeight += toy.getWeight();
        }
        Random rand  = new Random();
        double randNumber = rand.nextDouble()*totalWeight;
        Toy prizeToy = null;
        for (Toy toy:toys){
            if (randNumber<toy.getWeight()){
                prizeToy = toy;
                break;
            }
            randNumber -= toy.getWeight();
        }
        if (prizeToy!=null && prizeToy.getQuantity()>0){
            prizaToys.add(prizeToy);
            prizeToy.setQuantity(prizeToy.getQuantity()-1);
        }
    }
    public void getPrizeToy(){
        if(prizaToys.size() > 0){
            Toy prizeToy = prizaToys.remove(0);
            try {
                FileWriter writer = new FileWriter("prize_toys.txt",true);
                writer.write(prizeToy.getId() + "," + prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
