package firstTry;

import java.sql.Time;
import java.util.List;

/**
 * Created by ELODE on 07/03/2017.
 */
public class Hall {
    List<User> borneQRQueue; // list of user waiting  for a QR borne
    List<User> borneNoQRQueue; // list of user waiting for a non QR borne
    List<Borne> bornesQR;
    List<Borne> bornesNoQR;

    Hall(List<User> aBorneQRQueue, List<User> aBorneNoQRQueue, List<Borne> aBornesQR, List<Borne> aBornesNoQR){
        borneNoQRQueue = aBorneNoQRQueue;
        borneQRQueue = aBorneQRQueue;
        bornesQR = aBornesQR;
        bornesNoQR = aBornesNoQR;
    }

    ////////////////////////////////////////////////////////////////////
    //divideUserToBorn
    // Divide User to a borne Queue
    /////////////////////////////////////////////////////////////////////
    public void divideUserToBorn(User user){
        if(user.getPriority() == "1" || user.getPriority() == "2" || user.getPriority() == "3"){
            borneQRQueue.add(user);
        }
        else if(user.getPriority() == "4" || user.getPriority() == "5" || user.getPriority() == "6"){
            borneNoQRQueue.add(user);
        }
        else{
            System.out.println("ERROR, USER " + user.getId() + "NON HAVE CORRECT STATUS");
        }
    }

    /////////////////////////////////////////////////////////////////////
    //assignUserToBorne
    //assign an User to a Borne from queue
    /////////////////////////////////////////////////////////////////////
    public void assignUserToBorne(List<User> listUser, List<Borne> listBornes){
        for(User user : listUser ) {
            for (Borne borne : listBornes) {
                if (borne.getTimeNeed() != null ) {
                    borne.freeBorne();
                    borne.inProgress = user;
                    //borne.setTimeNeed(); // /!\ à compléter avec classe temps des Besoins
                }
            }
        }
    }
}
