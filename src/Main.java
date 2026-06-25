import people.positions.Goalkeeper;
import team.Team;

public class Main {
    public static void main(String[] args) {

        Team palmeiras = new Team("Palmeiras", "Allianz parque", 44000, 70.0, "Mancha verde");
        Team santos = new Team("Santos", "Caldeira",44000, 77.80,"Torcida Jovem do Santos");

        Goalkeeper luan = new Goalkeeper("Luan", "barbosa", 21,true,20,12);

        santos.promoverJogador(luan, santos,8,9.4);
        palmeiras.buyPlayer(luan,9,1,90);


    }
}
