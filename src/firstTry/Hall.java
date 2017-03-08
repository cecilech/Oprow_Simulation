package firstTry;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ELODE on 07/03/2017.
 */
public class Hall {
    private List<User> borneQRQueue =new ArrayList<>(); // list of user waiting  for a QR borne
    private List<User> borneNoQRQueue = new ArrayList<>(); // list of user waiting for a non QR borne
    private List<Borne> bornesQR = new ArrayList<>();
    private List<Borne> bornesNoQR = new ArrayList<>();
    private List<User> listUserExit = new ArrayList<>();

    Hall(List<User> aBorneQRQueue, List<User> aBorneNoQRQueue, List<Borne> aBornesQR, List<Borne> aBornesNoQR){
        borneNoQRQueue.addAll(aBorneNoQRQueue);
        borneQRQueue.addAll(aBorneQRQueue);
        bornesQR.addAll(aBornesQR);
        bornesNoQR.addAll(aBornesNoQR);
    }

    /*
    //////////////////////////////////////////////////////////////////
    divideUserToBorne
    Divide User to a borne Queue wityh in entry, a list of User who enter into the administration and hall
    ///////////////////////////////////////////////////////////////////
    */
    private void divideUserToBorne(User user){
        if(user.getPriority().equals("1") || user.getPriority().equals("2") || user.getPriority().equals("3")){
            this.borneQRQueue.add(user);
        }
        else if(user.getPriority().equals("4") || user.getPriority().equals("5") || user.getPriority().equals("6")){
            this.borneNoQRQueue.add(user);
        }
        else{
            System.out.println("ERROR, USER " + user.getId() + "WRONG STATUS");
        }
    }


    /*
    ///////////////////////////////////////////////////////////////////
    assignUserToBorne
    assign an User to a Borne from queue
    ///////////////////////////////////////////////////////////////////
    */
    private void assignUserToBorne(List<User> listUser, List<Borne> listBornes, Time currentTime) {
        Time time = new Time(0);
        for (Borne borne : listBornes) {
            borne.updateTimeRemaining(currentTime);
            if(borne.getTimeRemaining() == time || !borne.isUsed()){
                borne.userInProgress.setStartQueueTime(currentTime);
                this.listUserExit.add(borne.userInProgress);
                borne.userInProgress = listUser.get(0);
                borne.getTimeNeed(); // a compléter avec la classe "temps des besoins" pour prendre le temps d'utilisation
                listUser.remove(0);
            }
        }
    }

    /*
    ///////////////////////////////////////////////////////////////////
    sortExitList
    sort the exit list when people can't check their files
    ///////////////////////////////////////////////////////////////////
    */
    private List<User> sortExitList(List<User> listUserExit){
        for (User user : listUserExit){
            if(user.getPriority().equals("3") || user.getPriority().equals("6")){
                this.listUserExit.remove(user);
            }
        }
        return listUserExit;
    }

    /*
    ///////////////////////////////////////////////////////////////////
    decrementTime
    update time in borne
    ///////////////////////////////////////////////////////////////////
    */




    /*
    ///////////////////////////////////////////////////////////////////
    runHall
    Case noir Hall, permet de faire entrer les users dans la file virtuel guichet
    ///////////////////////////////////////////////////////////////////
    */
    public void runHall(List<User> listUser,Time currentTime){
        for(User user: listUser) {
            divideUserToBorne(user);
        }
        assignUserToBorne(this.borneNoQRQueue, this.bornesNoQR, currentTime);
        assignUserToBorne(this.borneQRQueue, this.bornesQR, currentTime);
        this.listUserExit = sortExitList(this.listUserExit);
    }


}
