package firstTry;

import java.sql.Time;
import java.util.List;

/**
 * Created by ELODE on 07/03/2017.
 */
public class Hall {
    private List<User> borneQRQueue; // list of user waiting  for a QR borne
    private List<User> borneNoQRQueue; // list of user waiting for a non QR borne
    private List<Borne> bornesQR;
    private List<Borne> bornesNoQR;
    private List<User> listUserExit;

    Hall(List<User> aBorneQRQueue, List<User> aBorneNoQRQueue, List<Borne> aBornesQR, List<Borne> aBornesNoQR){
        borneNoQRQueue = aBorneNoQRQueue;
        borneQRQueue = aBorneQRQueue;
        bornesQR = aBornesQR;
        bornesNoQR = aBornesNoQR;
    }

    /*
    //////////////////////////////////////////////////////////////////
    divideUserToBorne
    Divide User to a borne Queue wityh in entry, a list of User who enter into the administration and hall
    ///////////////////////////////////////////////////////////////////
    */
    private void divideUserToBorne(User user,Hall hall){
        if(user.getPriority().equals("1") || user.getPriority().equals("2") || user.getPriority().equals("3")){
            hall.borneQRQueue.add(user);
        }
        else if(user.getPriority().equals("4") || user.getPriority().equals("5") || user.getPriority().equals("6")){
            hall.borneNoQRQueue.add(user);
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
    private void assignUserToBorne(List<User> listUser, List<Borne> listBornes, Time nowTime) {
        Time time = new Time(0);
        for (Borne borne : listBornes) {
            if(borne.getTimeRemaining() == time || !borne.isUsed()){
                borne.userInProgress.setStartQueueTime(nowTime);
                listUserExit.add(borne.userInProgress);
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
    runHall
    Case noir Hall, permet de faire entrer les users dans la file virtuel guichet
    ///////////////////////////////////////////////////////////////////
    */
    public void runHall(List<User> listUser, Hall hall, Time nowTime){
        for(User user: listUser) {
            divideUserToBorne(user, hall);
        }
        assignUserToBorne(hall.borneNoQRQueue, hall.bornesNoQR, nowTime);
        assignUserToBorne(hall.borneQRQueue, hall.bornesQR, nowTime);
        hall.listUserExit = sortExitList(hall.listUserExit);
    }


}
