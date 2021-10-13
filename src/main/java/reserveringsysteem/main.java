package reserveringsysteem;

import reserveringsysteem.gebouw.domain.*;

//TEMP main class to test
public class main {
    public static void main(String[] args){

        VestigingRepository rep = new VestigingRepository();
        Vestiging v1 = new Vestiging(new VestigingId(1),new VestigingAdres("test","test","holland",7,"B"),"06-1008488");
        Vestiging v2 = new Vestiging(new VestigingId(2),new VestigingAdres("test","test","duitsland",7,"B"),"06-1859598");
        v2.addFlexplek(new FlexplexId(5));
        v2.addFlexplek(new FlexplexId(6));
        v2.addFlexplek(new FlexplexId(7));
        v2.removeFlexplek(new FlexplexId(6));
        Vestiging v3 = new Vestiging(new VestigingId(3),new VestigingAdres("test","test","belgie",7,"B"),"06-101488");

        rep.add(v1);
        rep.add(v2);
        rep.add(v3);

        rep.remove(v2);

        System.out.println(rep.getAll());

    }
}
