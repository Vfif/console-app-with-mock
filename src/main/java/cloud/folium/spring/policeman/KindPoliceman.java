package cloud.folium.spring.policeman;

public class KindPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Please, leave the room");
    }
}
