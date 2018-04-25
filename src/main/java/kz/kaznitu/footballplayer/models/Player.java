package kz.kaznitu.footballplayer.models;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerId;

    private String firstName;

    private String lastName;

    @ManyToOne
    private Club club;

    public Player() {
    }

    public Player(String firstName, String lastName, Club club) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.club = club;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
